package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.AccountEntity;
import com.weds.edwx.mapper.AccountMapper;
import com.weds.edwx.util.WXPayConstants;
import com.weds.edwx.util.WXPayConstants.SignType;
import com.weds.edwx.util.WXPayUtil;
import com.weds.edwx.util.WxSignUtil;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description Account管理
 * @Date 2018-12-28
 */
@Service
public class AccountService extends BaseService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CommProcService commProcService;
    @Resource
    private WeiXinParams weiXinParams;

    private SignType signType;

    @Autowired
    private RestTemplate restTemplate;

    private Logger log = LogManager.getLogger();

    public int insertSelective(AccountEntity record) {
        return accountMapper.insertSelective(record);
    }

    public int updateTradeNo(Map<String, String> record) {
        return accountMapper.updateTradeNo(record);
    }

    public JsonResult wechatPay(AccountEntity record) throws Exception {
        if ("1".equals(weiXinParams.getMode())) {
            Map<String, Object> param = new HashMap<>();
            param.put("lx", record.getLx());
            param.put("userSerial", record.getUserSerial());
            param.put("openId", record.getOpenId());
            param.put("orderId", record.getOrderId());
            param.put("addMoney", record.getAddMoney());
            return restTemplate.postForObject(weiXinParams.getUnifiedOrderUrl(), param, JsonResult.class);
        } else {
            String payAppid = weiXinParams.getAppId();
            if (null != record.getLx() && 1 == record.getLx()) {
                payAppid = weiXinParams.getAppletAppId();
            }
            //先解决返回值乱码问题
            List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
            converterList.remove(1);    //移除StringHttpMessageConverter
            HttpMessageConverter<?> converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            converterList.add(1, converter);    //convert顺序错误会导致失败
            restTemplate.setMessageConverters(converterList);
            //解决乱码问题结束
            Map<String, String> reqData = new HashMap<>();
            signType = SignType.MD5;
            reqData.put("appid", payAppid);
            reqData.put("attach", record.getUserSerial().toString());
            reqData.put("body", "威尔-联机充值");//商品描述
            reqData.put("mch_id", weiXinParams.getMchid());
            reqData.put("nonce_str", WxSignUtil.generateNonceStr());
            //reqData.put("sign_type", signType);
            reqData.put("notify_url", weiXinParams.getNotifyUrl());
            reqData.put("openid", record.getOpenId());
            reqData.put("out_trade_no", record.getOrderId());
            reqData.put("spbill_create_ip", weiXinParams.getSpbillCreateIp());
            reqData.put("total_fee", record.getAddMoney().toString());
            reqData.put("trade_type", "JSAPI");
            reqData.put("sign", WxSignUtil.generateSignature(reqData, weiXinParams.getMchkey(), this.signType));
            //配置完参数后，发起http xml 请求
            String reqBody = WxSignUtil.mapToXml(reqData);//将map 转换为 xml
            String httpResponEntity = restTemplate.postForObject(weiXinParams.getUnifiedOrderUrl(), reqBody, String.class);
            Map<String, String> rtn = WxSignUtil.xmlToMap(httpResponEntity);
            if ("SUCCESS".equals(rtn.get("return_code")) && "SUCCESS".equals(rtn.get("result_code"))) {
                Map<String, String> dataSucess = new HashMap<>();
                dataSucess.put("appId", rtn.get("appid"));
                dataSucess.put("nonceStr", WxSignUtil.create_nonce_str());
                dataSucess.put("package", "prepay_id=" + rtn.get("prepay_id"));
                dataSucess.put("signType", "MD5");
                dataSucess.put("timeStamp", WxSignUtil.create_timestamp());
                signType = WXPayConstants.SignType.MD5;
                dataSucess.put("paySign", WxSignUtil.generateSignature(dataSucess, weiXinParams.getMchkey(), signType));
                dataSucess.put("prepay_id", rtn.get("prepay_id"));
                dataSucess.put("out_trade_no", record.getOrderId());
                dataSucess.put("total_fee", record.getAddMoney().toString());

                Map<String, String> temp = new HashMap<>();
                temp.put("trade_no", rtn.get("prepay_id"));
                temp.put("out_trade_no", record.getOrderId());
                accountMapper.updateTradeNo(temp);
                return succMsgData(dataSucess);
            } else {
                return failMsg(rtn.get("return_msg"));
            }
        }
    }

    /**
     * 判断支付结果通知中的sign是否有效
     *
     * @param reqData 向wxpay post的请求数据
     * @return 签名是否有效
     * @throws Exception
     */
    public boolean isPayResultNotifySignatureValid(Map<String, String> reqData) throws Exception {
        String signTypeInData = reqData.get(WXPayConstants.FIELD_SIGN_TYPE);
        SignType signType;
        if (signTypeInData == null) {
            signType = SignType.MD5;
        } else {
            signTypeInData = signTypeInData.trim();
            if (signTypeInData.length() == 0) {
                signType = SignType.MD5;
            } else if (WXPayConstants.MD5.equals(signTypeInData)) {
                signType = SignType.MD5;
            } else if (WXPayConstants.HMACSHA256.equals(signTypeInData)) {
                signType = SignType.HMACSHA256;
            } else {
                throw new Exception(String.format("Unsupported sign_type: %s", signTypeInData));
            }
        }
        return WXPayUtil.isSignatureValid(reqData, weiXinParams.getMchkey(), signType);
    }

    /**
     * 给一卡通账户充钱
     *
     * @param reqData
     * @return
     */
    public int rechargeAccount(Map<String, String> reqData) {
        int count = accountMapper.selectPreOrder(reqData);//取出预充值数据
        if (count == 0) {
            return 0;
        }
        reqData.put("state", "2");
        reqData.put("lstate", "0");
        int count2 = accountMapper.updateOrderState(reqData);//state 值由0 改为 2 ，正在充值中。
        if (count2 == 0) { //改为充值中失败，可能已经充值了，返回失败
            return 0;
        }
        //开始走给一卡通充值流程
        CommProcEntity commProcEntity = new CommProcEntity();
        commProcEntity.setProcName("wx_zh_recharge");
        List<Object> list = new ArrayList<>();
        list.add(reqData.get("attach"));
        list.add(reqData.get("total_fee"));
        list.add("微信支付");
        commProcEntity.setParams(list);
        List<List<Map>> map = commProcService.loadProcData(commProcEntity);
        //给一卡通充值成功
        if ("0".equals(map.get(0).get(0).get("").toString())) { //改为充值完成
            reqData.put("state", "1");
            reqData.put("lstate", "2");
            int flg = accountMapper.updateOrderState(reqData);
            if (flg > 0) {
                return 1;
            }
        } else { // 充值失败之后，将正在充值改为未充值
            reqData.put("state", "0");
            reqData.put("lstate", "2");
            accountMapper.updateOrderState(reqData);
            return 0;
        }
        return 0;
    }

    public AccountEntity selectPayResult(AccountEntity record) {
        return accountMapper.selectPayResult(record);
    }

    public Map orderQuery(AccountEntity record) throws Exception {
        if ("1".equals(weiXinParams.getMode())) {
            Map<String, Object> param = new HashMap<>();
            param.put("orderId", record.getOrderId());
            return restTemplate.postForObject(weiXinParams.getOrderQueryUrl(), param, Map.class);
        } else {
            //先解决返回值乱码问题
            List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
            converterList.remove(1);    //移除StringHttpMessageConverter
            HttpMessageConverter<?> converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            converterList.add(1, converter);    //convert顺序错误会导致失败
            restTemplate.setMessageConverters(converterList);
            //解决乱码问题结束
            signType = SignType.MD5;
            Map<String, String> reqData = new HashMap<>();
            reqData.put("appid", weiXinParams.getAppId());
            reqData.put("mch_id", weiXinParams.getMchid());
            reqData.put("nonce_str", WxSignUtil.generateNonceStr());
            reqData.put("sign_type", "MD5");
            reqData.put("out_trade_no", record.getOrderId());
            reqData.put("sign", WxSignUtil.generateSignature(reqData, weiXinParams.getMchkey(), this.signType));
            //配置完参数后，发起http xml 请求
            String reqBody = WxSignUtil.mapToXml(reqData);//将map 转换为 xml
            String httpResponEntity = restTemplate.postForObject(weiXinParams.getOrderQueryUrl(), reqBody, String.class);
            return WxSignUtil.xmlToMap(httpResponEntity);
        }
    }

    public AccountEntity selectPreOrderByTradeNo(String orderId) {
        return accountMapper.selectPreOrderByTradeNo(orderId);
    }

//	public AccountEntity selectByPrimaryKey(Integer xh) {
//		return accountMapper.selectByPrimaryKey(xh);
//	}
//
//	public int updateByPrimaryKeySelective(AccountEntity record) {
//		return accountMapper.updateByPrimaryKeySelective(record);
//	}
//
//	public int updateByPrimaryKey(AccountEntity record) {
//		return accountMapper.updateByPrimaryKey(record);
//	}
//
//	public List<AccountEntity> selectListByEntity(AccountEntity record) {
//		return accountMapper.selectListByEntity(record);
//	}

}
