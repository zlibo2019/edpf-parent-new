package com.weds.edwx.entity;

import com.google.gson.annotations.SerializedName;

public class IcbcBaseEntity {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("msg_id")
    private String msgId;
    @SerializedName("format")
    private String format;
    @SerializedName("charset")
    private String charset;
    @SerializedName("sign_type")
    private String signType;
    @SerializedName("sign")
    private String sign;
    @SerializedName("encrypt_type")
    private String encryptType;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("ca")
    private String ca;
    @SerializedName("biz_content")
    private String bizContent;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }
}
