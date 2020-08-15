package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.RSACoder;
import com.weds.dingtalk.constant.DingTalkParams;
import com.weds.dingtalk.service.PayDtService;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.AccountEntity;
import com.weds.edwx.service.AccountService;
import com.weds.edwx.util.WXPayConstants;
import com.weds.edwx.util.WXPayUtil;
import com.weds.pay.constants.PayParams;
import com.weds.pay.constants.PayType;
import com.weds.pay.lcsw.constants.LcswConstants;
import com.weds.pay.lcsw.entity.*;
import com.weds.pay.lcsw.service.LcswService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author sxm
 * @Description Account管理
 * @Date 2018-12-28
 */
@RestController
@RequestMapping(value = "/account")
@Api(value = "充值管理", description = "充值管理")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    @Resource
    private PayDtService payDtService;

    @Resource
    private DingTalkParams dingTalkParams;

    @Resource
    private PayParams payParams;

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private LcswService lcswService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "微信预充值接口", notes = "微信预充值接口")
    @RequestMapping(value = "/payOrder", method = RequestMethod.PUT)
    public JsonResult insert(@RequestBody AccountEntity record) {
        record.setOrderId(StringUtils.getUUID()); //插入订单编号
        record.setSj(new Date()); //插入订单时间
        record.setState(0);
        int preFlg = accountService.insertSelective(record);
        if (preFlg > 0) {
            try {
                if (payParams.getType().equals(PayType.WX.getType())) {
                    return accountService.wechatPay(record);
                } else {
                    PayPreReq payPreReq = new PayPreReq();
                    payPreReq.setTerminalTrace(record.getOrderId());
                    payPreReq.setTerminalTime(DateUtils.formatDate(record.getSj(), DateUtils.DATE_TIME_SIMPLE_FORMAT));
                    payPreReq.setTotalFee(record.getAddMoney().toString());
                    payPreReq.setSubAppid(weiXinParams.getAppId());
                    payPreReq.setOpenId(record.getOpenId());
                    payPreReq.setOrderBody("威尔-联机充值");
                    payPreReq.setNotifyUrl(weiXinParams.getNotifyUrl());
                    payPreReq.setAttach(record.getUserSerial().toString());
                    PayPreRstResp payPreRstResp = lcswService.wxPrePay(payPreReq);
                    if (payPreRstResp != null) {
                        Map<String, String> temp = new HashMap<>();
                        temp.put("trade_no", payPreRstResp.getPayPreResp().getOutTradeNo());
                        temp.put("out_trade_no", record.getOrderId());
                        accountService.updateTradeNo(temp);

                        Map<String, String> dataSucess = new HashMap<>();
                        dataSucess.put("appId", payPreRstResp.getAppId());
                        dataSucess.put("nonceStr", payPreRstResp.getNonceStr());
                        dataSucess.put("package", payPreRstResp.getPackageStr());
                        dataSucess.put("signType", payPreRstResp.getSignType());
                        dataSucess.put("timeStamp", payPreRstResp.getTimeStamp());
                        dataSucess.put("paySign", payPreRstResp.getPaySign());
                        dataSucess.put("out_trade_no", record.getOrderId());
                        dataSucess.put("total_fee", record.getAddMoney().toString());
                        return succMsgData(dataSucess);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg("充值失败");
            }
        }
        return failMsg("充值失败");
    }

    @Logs
    @ApiOperation(value = "支付宝预充值接口", notes = "支付宝预充值接口")
    @RequestMapping(value = "/payDtOrder", method = RequestMethod.PUT)
    public JsonResult payDtOrder(@RequestBody AccountEntity record) {
        String tradeNo = StringUtils.getUUID();
        record.setOrderId(tradeNo); //插入订单编号
        record.setSj(new Date()); //插入订单时间
        record.setState(0);
        int preFlg = accountService.insertSelective(record);
        if (preFlg > 0) {
            try {
                String resp = payDtService.panyInfo(tradeNo, record.getAddMoney().toString());
                Map<String, String> map = new HashMap<>();
                map.put("resp", resp);
                map.put("tradeNo", tradeNo);
                return succMsgData(map);
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg("充值失败");
            }
        }
        return failMsg("充值失败");
    }

    @Logs
    @ApiOperation(value = "支付宝预充值接口", notes = "支付宝预充值接口")
    @RequestMapping(value = "/payDtOrderTemp", method = RequestMethod.PUT)
    public JsonResult payDtOrderTemp(@RequestBody AccountEntity record) {
        String tradeNo = StringUtils.getUUID();
        record.setOrderId(tradeNo); //插入订单编号
        record.setSj(new Date()); //插入订单时间
        record.setState(0);
        String addMoney = record.getAddMoney().toString();
        record.setAddMoney(record.getAddMoney().multiply(new BigDecimal(100)));
        int preFlg = accountService.insertSelective(record);
        if (preFlg > 0) {
            try {
                String resp = payDtService.redirectPay(tradeNo, addMoney);
                Map<String, String> map = new HashMap<>();
                map.put("resp", resp);
                map.put("tradeNo", tradeNo);
                return succMsgData(map);
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg("充值失败");
            }
        }
        return failMsg("充值失败");
    }

    @Logs
    @ApiOperation(value = "查询支付宝支付详情", notes = "查询支付宝支付详情")
    @RequestMapping(value = "/getDtResultDetail", method = RequestMethod.POST)
    public JsonResult<AccountEntity> getDtResultDetail(@RequestBody AccountEntity record) {
        AccountEntity entity = accountService.selectPayResult(record);
        if (entity == null) {
            return failMsg("查询失败，请稍后再试");
        } else {
            if (1 == entity.getState()) {
                return succMsgData(entity);
            } else if (2 == entity.getState()) {//如果正在充值中，休眠1秒
                return failMsg("充值中");
            } else {
                return failMsg("充值失败");
            }
        }
    }

    @Logs
    @ApiOperation(value = "支付宝调用通知支付成功", notes = "支付宝调用通知支付成功")
    @RequestMapping(value = "/payDtSuccess", method = RequestMethod.POST)
    public String payDtSuccess(@RequestBody String paramsStr) {
        String decode;
        try {
            decode = URLDecoder.decode(paramsStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        String[] params = StringUtils.stringToArray(decode, "&");
        Map<String, String> paramsMap = new HashMap<>();
        for (String param : params) {
            String[] temp = param.split("=");
            paramsMap.put(temp[0], temp[1]);
        }
        String notify_type = paramsMap.get("notify_type");
        String trade_status = paramsMap.get("trade_status");
        String sign_type = paramsMap.get("sign_type");
        String sign = paramsMap.get("sign");

        // String notify_type = dtNoticeEntity.getNotify_type();
        // String trade_status = dtNoticeEntity.getTrade_status();
        // String sign_type = dtNoticeEntity.getSign_type();
        // String sign = dtNoticeEntity.getSign();

        if ("trade_status_sync".equals(notify_type) && "TRADE_SUCCESS".equals(trade_status)) {
            List<String> list = new ArrayList<>();
            // JSONObject paramsMap = JSONObject.parseObject(toJson(dtNoticeEntity));
            for (String key : paramsMap.keySet()) {
                if ("sign".equals(key) || "sign_type".equals(key)) {
                    continue;
                }
                list.add(key);
            }
            list.sort(String.CASE_INSENSITIVE_ORDER);

            StringBuilder sb = new StringBuilder();
            for (String key : list) {
                sb.append(key).append("=").append(paramsMap.get(key)).append("&");
            }

            try {
                if ("RSA2".equals(sign_type) && RSACoder.verify(sb.substring(0, sb.length() - 1).getBytes(StandardCharsets.UTF_8),
                        dingTalkParams.getAliPubKey(), sign, RSACoder.SIGNATURE_ALGORITHM_SHA256)) {
                    // AccountEntity accountEntity = accountService.selectPreOrderByTradeNo(dtNoticeEntity.getOut_trade_no());
                    AccountEntity accountEntity = accountService.selectPreOrderByTradeNo(paramsMap.get("out_trade_no"));
                    if (accountEntity != null) {
                        Map<String, String> reqData = new HashMap<>();
                        // reqData.put("out_trade_no", dtNoticeEntity.getOut_trade_no());
                        reqData.put("out_trade_no", paramsMap.get("out_trade_no"));
                        reqData.put("attach", accountEntity.getUserSerial().toString());
                        reqData.put("openid", accountEntity.getOpenId());
                        // reqData.put("total_fee", dtNoticeEntity.getTotal_fee());
                        BigDecimal bigDecimal = new BigDecimal(paramsMap.get("total_amount"));
                        reqData.put("total_fee", bigDecimal.multiply(new BigDecimal(100)).intValue() + "");
                        int flg = accountService.rechargeAccount(reqData);
                        if (flg > 0) {
                            return "success";
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Logs
    @ApiOperation(value = "扫呗调用，通知支付成功", notes = "扫呗调用，通知支付成功")
    @RequestMapping(value = "/lcswPaySuccess", method = RequestMethod.POST)
    public Map lcswPaySuccess(@RequestBody NoticeReq noticeReq) {
        NoticeReq req = lcswService.payNotice(noticeReq);
        Map<String, String> map = new HashMap<>();
        if (req != null && LcswConstants.HTTP_SUCCESS.equals(req.getReturnCode())
                && LcswConstants.HTTP_SUCCESS.equals(req.getResultCode())) {
            PayQueryReq payQueryReq = new PayQueryReq();
            payQueryReq.setTerminalTrace(req.getTerminalTrace());
            payQueryReq.setTerminalTime(DateUtils.getCurrentDateTimeSimple());
            payQueryReq.setOutTradeNo(req.getOutTradeNo());
            try {
                PayQueryRstResp payQueryRstResp = lcswService.payQuery(payQueryReq);
                if (payQueryRstResp != null && "SUCCESS".equals(payQueryRstResp.getTradeState())) {
                    //走业务流程，进行该订单的充值处理
                    Map<String, String> respData = new HashMap<>();
                    respData.put("attach", payQueryRstResp.getAttach());
                    respData.put("out_trade_no", payQueryRstResp.getAttach());
                    respData.put("openid", payQueryRstResp.getUserId());
                    respData.put("total_fee", payQueryRstResp.getPayQueryResp().getTotalFee());
                    int flg = accountService.rechargeAccount(respData);
                    if (flg > 0) {
                        map.put("return_code", LcswConstants.HTTP_SUCCESS);
                        map.put("return_msg", "OK");
                        return map;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        map.put("return_code", LcswConstants.HTTP_FAIL);
        map.put("return_msg", "");
        return map;
    }

    @Logs
    @ApiOperation(value = "微信调用，通知支付成功", notes = "微信调用，通知支付成功")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    public String updateByPrimaryKey(@RequestBody String xmlStr) {
        Map<String, String> returnMap = new HashMap<>();
        String RETURN_CODE = "return_code";
        String RESULT_CODE = "result_code";
        try {
            Map<String, String> respData = WXPayUtil.xmlToMap(xmlStr);
            if (WXPayConstants.SUCCESS.equals(respData.get(RETURN_CODE))
                    && WXPayConstants.SUCCESS.equals(respData.get(RESULT_CODE))) { //返回值是成功
                //验证密钥
                if (accountService.isPayResultNotifySignatureValid(respData)) { //密钥验证成功
                    // 增加查询验证
                    AccountEntity record = new AccountEntity();
                    record.setOrderId(respData.get("out_trade_no"));
                    Map map = accountService.orderQuery(record);
                    if (WXPayConstants.SUCCESS.equals(map.get("return_code"))
                            && WXPayConstants.SUCCESS.equals(map.get("result_code"))
                            && WXPayConstants.SUCCESS.equals(map.get("trade_state"))) { //返回值是成功
                        //走业务流程，进行该订单的充值处理
                        String[] attach = respData.get("attach").split("#");
                        respData.put("attach", attach[0]);
                        int flg = accountService.rechargeAccount(respData);
                        if (flg > 0) {
                            returnMap.put("return_code", "SUCCESS");
                            returnMap.put("return_msg", "OK");
                            return WXPayUtil.mapToXml(returnMap);
                        }
                    }
                    returnMap.put("return_code", "FAIL");
                    returnMap.put("return_msg", "");
                    return WXPayUtil.mapToXml(returnMap);
                }
                returnMap.put("return_code", "FAIL");
                returnMap.put("return_msg", "");
                return WXPayUtil.mapToXml(returnMap);
            }
            returnMap.put("return_code", "FAIL");
            returnMap.put("return_msg", "");
            return WXPayUtil.mapToXml(returnMap);
        } catch (Exception e) {
            return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[]]></return_msg></xml>";
        }
    }

    @Logs
    @ApiOperation(value = "查询支付详情", notes = "查询支付详情")
    @RequestMapping(value = "/getResultDetail", method = RequestMethod.POST)
    public JsonResult<AccountEntity> selectByPrimaryKey(@RequestBody AccountEntity record) {
        AccountEntity entity = accountService.selectPayResult(record);
        if (entity == null) {
            return failMsg("查询失败，请稍后再试");
        }
        if (1 == entity.getState()) {
            return succMsgData(entity);
        }
        if (2 == entity.getState()) {//如果正在充值中，休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return failMsg("查询失败，请稍后再试");
            }
        }
        // return failMsg("查询失败，请稍后再试");
        try {
            if (payParams.getType().equals(PayType.WX.getType())) {
                //如果充值状态是0，那就去微信订单查询确认
                Map map = accountService.orderQuery(record);
                if (WXPayConstants.SUCCESS.equals(map.get("return_code"))
                        && WXPayConstants.SUCCESS.equals(map.get("result_code"))
                        && WXPayConstants.SUCCESS.equals(map.get("trade_state"))) { //返回值是成功
                    map.put("attach", record.getUserSerial().toString());
                    //走业务流程，进行该订单的充值处理
                    int flg = accountService.rechargeAccount(map);
                    if (flg > 0) {
                        AccountEntity entity1 = accountService.selectPayResult(record);
                        return succMsgData(entity1);
                    }
                    return failMsg("充值失败，请联系管理员");
                }
            } else {
                PayQueryReq payQueryReq = new PayQueryReq();
                payQueryReq.setTerminalTrace(record.getOrderId());
                payQueryReq.setTerminalTime(DateUtils.getCurrentDateTimeSimple());
                payQueryReq.setOutTradeNo(entity.getTradeNo());
                try {
                    PayQueryRstResp payQueryRstResp = lcswService.payQuery(payQueryReq);
                    if (payQueryRstResp != null && "SUCCESS".equals(payQueryRstResp.getTradeState())) {
                        //走业务流程，进行该订单的充值处理
                        Map<String, String> respData = new HashMap<>();
                        respData.put("attach", payQueryRstResp.getAttach());
                        respData.put("out_trade_no", payQueryRstResp.getAttach());
                        respData.put("openid", payQueryRstResp.getUserId());
                        respData.put("total_fee", payQueryRstResp.getPayQueryResp().getTotalFee());
                        int flg = accountService.rechargeAccount(respData);
                        if (flg > 0) {
                            AccountEntity entity1 = accountService.selectPayResult(record);
                            return succMsgData(entity1);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return failMsg("充值失败");
        } catch (Exception e) {
            return failMsg("查询失败，请稍后再试");
        }
    }

    @Logs
    @ApiOperation(value = "一卡通平台充值接口", notes = "小程序预充值接口")
    @RequestMapping(value = "/rechargeAccount", method = RequestMethod.POST)
    public int rechargeAccount(@RequestBody Map<String, String> paramMap) {
        return accountService.rechargeAccount(paramMap);
    }

    @Logs
    @ApiOperation(value = "小程序预充值接口", notes = "小程序预充值接口")
    @RequestMapping(value = "/appletPayOrder", method = RequestMethod.POST)
    public JsonResult appletPayOrder(@RequestBody AccountEntity record) {
        record.setOrderId(StringUtils.getUUID()); //插入订单编号
        record.setSj(new Date()); //插入订单时间
        record.setState(0);
        int preFlg = accountService.insertSelective(record);
        if (preFlg > 0) {
            try {
                record.setLx(1);
                return accountService.wechatPay(record);
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg("充值失败");
            }
        }
        return failMsg("充值失败");
    }

//	@Logs
//	@ApiOperation(value = "更新Account信息", notes = "更新Account信息")
//	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
//	public JsonResult<Object> updateByPrimaryKey(@RequestBody AccountEntity record) {
//				accountService.updateByPrimaryKeySelective(record);
//		return succMsg();
//	}
//
//	@Logs
//	@ApiOperation(value = "查询Account清单", notes = "查询Account清单")
//	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
//	public JsonResult<BaseCommPager<AccountEntity>> selectListPageByEntity(@RequestBody BasePageSearch<AccountEntity> record) {
//		setPageHelper(record);
//		AccountEntity entity = record.getSearch();
//        if (entity == null) {
//        	entity = new AccountEntity();
//        }
//		        List<AccountEntity> list = accountService.selectListByEntity(entity);
//		return succMsg(new BaseCommPager<AccountEntity>(list));
//	}
//
//    @Logs
//    @ApiOperation(value = "查询Account列表", notes = "查询Account列表")
//    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
//    public JsonResult<List<AccountEntity>> selectListByEntity(@RequestBody AccountEntity record) {
//                List<AccountEntity> list = accountService.selectListByEntity(record);
//        return succMsg(list);
//    }
//
//		@Logs
//	@ApiOperation(value = "删除Account信息", notes = "删除Account信息")
//	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
//	public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
//        accountService.deleteByPrimaryKey(xh);
//        return succMsg();
//	}
//
//	@Logs
//	@ApiOperation(value = "查询Account信息", notes = "查询Account信息")
//	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
//	public JsonResult<AccountEntity> selectByPrimaryKey(@RequestParam Integer xh) {
//		AccountEntity entity = accountService.selectByPrimaryKey(xh);
//        return succMsg(entity);
//	}
}