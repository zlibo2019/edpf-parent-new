package com.weds.edwx.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.icbc.pay")
public class IcbcPayParams {
    // 商户ID
    private String merId;

    private String channelId;

    // 银行网关公钥
    private String apigwPubKey;

    // 商户私钥
    private String privateKey;

    // 商户APPID
    private String appId;

    // 聚合支付URL
    private String paymentUrl;

    // 查询URL
    private String queryUrl;

    // 回调地址
    private String notifyUrl;

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getApigwPubKey() {
        return apigwPubKey;
    }

    public void setApigwPubKey(String apigwPubKey) {
        this.apigwPubKey = apigwPubKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }
}
