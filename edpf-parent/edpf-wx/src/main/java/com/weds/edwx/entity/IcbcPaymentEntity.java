package com.weds.edwx.entity;

import com.google.gson.annotations.SerializedName;

public class IcbcPaymentEntity extends IcbcBaseEntity {
    @SerializedName("interfaceVersion")
    private String interfaceVersion;
    @SerializedName("mer_id")
    private String merId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("tp_app_id")
    private String tpAppId;
    @SerializedName("tp_open_id")
    private String tpOpenId;
    @SerializedName("out_trade_no")
    private String outTradeNo;
    @SerializedName("tran_type")
    private String tranType;
    @SerializedName("order_date")
    private String orderDate;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("goods_body")
    private String goodsBody;
    @SerializedName("goods_detail")
    private String goodsDetail;
    @SerializedName("attach")
    private String attach;
    @SerializedName("order_amount")
    private String orderAmount;
    @SerializedName("spbill_create_ip")
    private String spbillCreateIp;
    @SerializedName("install_times")
    private String installTimes;
    @SerializedName("mer_hint")
    private String merHint;
    @SerializedName("return_url")
    private String returnUrl;
    @SerializedName("pay_limit")
    private String payLimit;
    @SerializedName("notify_url")
    private String notifyUrl;
    @SerializedName("notify_type")
    private String notifyType;
    @SerializedName("result_type")
    private String resultType;
    @SerializedName("backup1")
    private String backup1;
    @SerializedName("backup2")
    private String backup2;
    @SerializedName("backup3")
    private String backup3;
    @SerializedName("backup4")
    private String backup4;

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTpAppId() {
        return tpAppId;
    }

    public void setTpAppId(String tpAppId) {
        this.tpAppId = tpAppId;
    }

    public String getTpOpenId() {
        return tpOpenId;
    }

    public void setTpOpenId(String tpOpenId) {
        this.tpOpenId = tpOpenId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGoodsBody() {
        return goodsBody;
    }

    public void setGoodsBody(String goodsBody) {
        this.goodsBody = goodsBody;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getInstallTimes() {
        return installTimes;
    }

    public void setInstallTimes(String installTimes) {
        this.installTimes = installTimes;
    }

    public String getMerHint() {
        return merHint;
    }

    public void setMerHint(String merHint) {
        this.merHint = merHint;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getPayLimit() {
        return payLimit;
    }

    public void setPayLimit(String payLimit) {
        this.payLimit = payLimit;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

    public String getBackup3() {
        return backup3;
    }

    public void setBackup3(String backup3) {
        this.backup3 = backup3;
    }

    public String getBackup4() {
        return backup4;
    }

    public void setBackup4(String backup4) {
        this.backup4 = backup4;
    }
}
