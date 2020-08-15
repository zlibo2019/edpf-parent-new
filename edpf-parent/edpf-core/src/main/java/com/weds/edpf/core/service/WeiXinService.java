package com.weds.edpf.core.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.base.BaseService;
import com.weds.core.constants.WeiXinConstants;
import com.weds.core.utils.WeiXinUtils;
import com.weds.core.utils.xml.XmlUtils;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeiXinService extends BaseService {
    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private RestTemplate restTemplate;

    private Logger log = LogManager.getLogger();

    /**
     * 根据code获取openid
     *
     * @param code
     * @return
     */
    public String getOpenInfo(String code) {
        //服务号地址
        String requestUrl = weiXinParams.getOpenIdUrl() + "?appid=" + weiXinParams.getAppId()
                + "&secret=" + weiXinParams.getAppSecret() + "&code=" + code + "&grant_type=authorization_code";
        if ("1".equals(weiXinParams.getSort())) {//企业号
            requestUrl = weiXinParams.getOpenIdUrl() + "?access_token=" + SystemPool.getToken() + "&code=" + code;
        }
        return restTemplate.getForObject(requestUrl, String.class);
    }

    public String getOpenId(String code) {
        String resp = this.getOpenInfo(code);
        JSONObject json = JSONObject.parseObject(resp);
        String openId = json.getString("openid");
        if ("1".equals(weiXinParams.getSort())) {//企业号
            openId = json.getString("UserId");
        }
        return openId;
    }

    public String getAppletUrl(String type) {
        String temp = MessageFormat.format(weiXinParams.getAppletUrl(), "", weiXinParams.getAppId(), "", type, "");
        return restTemplate.getForObject(temp, String.class);
    }

    /**
     * 小程序根据code 获取 unionId
     */
    public JSONObject getUnionId(String code) {
        String requestUrl = weiXinParams.getUnionidUrl() + "?appid=" + weiXinParams.getAppletAppId()
                + "&secret=" + weiXinParams.getAppletAppSecret() + "&js_code=" + code + "&grant_type=authorization_code";
        return restTemplate.getForObject(requestUrl, JSONObject.class);
    }

    /**
     * 微信公众号获取unionId
     *
     * @param openId
     * @return
     */
    public String getUnionIdByOpenId(String openId) {
        JSONObject json = this.getWxUserInfo(openId);
        String unionId = null;
        if (json != null) {
            unionId = json.getString("unionid");
        }
        return unionId;
    }

    /**
     * 微信公众号获取用户信息
     *
     * @param openId
     * @return
     */
    public JSONObject getWxUserInfo(String openId) {
        String requestUrl = weiXinParams.getUnionidUrl() + "?access_token=" + SystemPool.getToken() + "&openid=" + openId + "&lang=zh_CN";
        String resp = restTemplate.getForObject(requestUrl, String.class);
        JSONObject json = JSONObject.parseObject(resp);
        if (json != null && json.getString("errcode") == null) {
            return json;
        } else {
            return null;
        }
    }

    /**
     * 获取微信授权token，两个小时过期一次
     *
     * @return
     */
    public void getAccessToken() {
        String requestUrl = weiXinParams.getTokenUrl() + "?grant_type=client_credential"
                + "&appid=" + weiXinParams.getAppId() + "&secret=" + weiXinParams.getAppSecret();
        if ("1".equals(weiXinParams.getSort())) {//企业号
            requestUrl = weiXinParams.getTokenUrl() + "?corpid=" + weiXinParams.getAppId() + "&corpsecret=" + weiXinParams.getAppSecret();
        }
        String resp = restTemplate.getForObject(requestUrl, String.class);
        log.info("请求微信平台获取Token返回：" + resp);
        JSONObject json = JSONObject.parseObject(resp);
        SystemPool.addToken(json.getString("access_token"));
        SystemPool.addToken("expires_in", json.getIntValue("expires_in"));
        SystemPool.addToken("errcode", json.getIntValue("errcode"));
    }

    public void getJsapiTicket() {
        String token = SystemPool.getToken();
        String requestUrl = weiXinParams.getTicketUrl() + "?type=jsapi" + "&appid=" + weiXinParams.getAppId() + "&access_token=" + token;
        for (int i = 0; i < 2; i++) {
            String resp = restTemplate.getForObject(requestUrl, String.class);
            JSONObject json = JSONObject.parseObject(resp);
            if ("0".equals(json.getString("errcode"))) { //反回值正常则正常
                SystemPool.addTicket(json.getString("ticket"));
                SystemPool.addTicket("errcode", json.getIntValue("errcode"));
                SystemPool.addTicket("expires_in", json.getIntValue("expires_in"));
                return;
            } else {
                //返回错误，则重新请求token，再重新请求ticket
                requestUrl = weiXinParams.getTicketUrl() + "?type=jsapi" + "&appid=" + weiXinParams.getAppId() + "&access_token=" + token;
            }
        }
        SystemPool.addTicket("errcode", 601);
    }

    public Map orderQuery(Map<String, Object> param) {
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, String> reqData = new HashMap<>();
            reqData.put("appid", weiXinParams.getAppId());
            reqData.put("mch_id", weiXinParams.getMchid());
            reqData.put("nonce_str", WeiXinUtils.generateNonceStr());
            reqData.put("sign_type", "MD5");
            reqData.put("out_trade_no", param.get("orderId").toString());
            reqData.put("sign", WeiXinUtils.generateSignature(reqData, weiXinParams.getMchkey(), WeiXinConstants.SignType.MD5));
            //配置完参数后，发起http xml 请求
            map.put("xml", reqData);
            String reqBody = XmlUtils.mapToXml(map);//将map 转换为 xml
            String httpResponEntity = restTemplate.postForObject(weiXinParams.getOrderQueryUrl(), reqBody, String.class);
            return (Map) XmlUtils.xmlToMap(httpResponEntity).get("xml");
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> rtn = new HashMap<>();
            rtn.put("return_code", WeiXinConstants.FAIL);
            rtn.put("return_msg", "Error");
            return rtn;
        }
    }
}
