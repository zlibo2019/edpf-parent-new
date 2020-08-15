package com.weds.edpf.core.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.wx")
public class WeiXinParams {
    // 获取token地址
    private String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
    // 获取ticket地址
    private String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    // 获取unionid地址
    private String unionidUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
    // 推送消息地址
    private String sendmsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send";
    // 获取code地址
    private String appletUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={1}&redirect_uri={2}&response_type=code&scope={3}&state={4}#wechat_redirect";
    // 开票信息地址
    private String invoiceUrl = "https://api.weixin.qq.com/card/invoice/biz/getusertitleurl?access_token={1}";
    // 图片下载地址
    private String imageUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token={1}&media_id={2}";
    // 获取openId地址
    private String openIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";

    // appId
    private String appId = "";
    // appsecret
    private String appSecret = "";

    // 支付地址
    private String unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    // 支付订单查询地址
    private String orderQueryUrl = "https://api.mch.weixin.qq.com/pay/orderquery";
    // 支付地址
    private String notifyUrl = "";
    // 支付ID
    private String mchid = "";
    // 支付key
    private String mchkey = "";
    // 终端IP
    private String spbillCreateIp = "";
    // 回调地址
    private String headUrl = "";

    // 附件图片地址
    private String imagePath = "image";
    // 头像图片地址
    private String headImagePath = "head";

    // 小程序appId
    private String appletAppId = "";
    // 小程序appSecret
    private String appletAppSecret = "";
    // 小程序openId
    private String appletOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session";

    // 0 服务号 1 企业号
    private String sort = "0";
    // 0 单企业版 1 多企业版
    private String mode = "0";
    // 企业编号
    private String companyId = "";
    // 默认密码
    private String password = "";
    // 排除菜单
    private String exceptMenu = "";

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getTicketUrl() {
        return ticketUrl;
    }

    public void setTicketUrl(String ticketUrl) {
        this.ticketUrl = ticketUrl;
    }

    public String getUnionidUrl() {
        return unionidUrl;
    }

    public void setUnionidUrl(String unionidUrl) {
        this.unionidUrl = unionidUrl;
    }

    public String getSendmsgUrl() {
        return sendmsgUrl;
    }

    public void setSendmsgUrl(String sendmsgUrl) {
        this.sendmsgUrl = sendmsgUrl;
    }

    public String getAppletUrl() {
        return appletUrl;
    }

    public void setAppletUrl(String appletUrl) {
        this.appletUrl = appletUrl;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenIdUrl() {
        return openIdUrl;
    }

    public void setOpenIdUrl(String openIdUrl) {
        this.openIdUrl = openIdUrl;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getMchkey() {
        return mchkey;
    }

    public void setMchkey(String mchkey) {
        this.mchkey = mchkey;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getAppletAppId() {
        return appletAppId;
    }

    public void setAppletAppId(String appletAppId) {
        this.appletAppId = appletAppId;
    }

    public String getAppletAppSecret() {
        return appletAppSecret;
    }

    public void setAppletAppSecret(String appletAppSecret) {
        this.appletAppSecret = appletAppSecret;
    }

    public String getAppletOpenIdUrl() {
        return appletOpenIdUrl;
    }

    public void setAppletOpenIdUrl(String appletOpenIdUrl) {
        this.appletOpenIdUrl = appletOpenIdUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnifiedOrderUrl() {
        return unifiedOrderUrl;
    }

    public void setUnifiedOrderUrl(String unifiedOrderUrl) {
        this.unifiedOrderUrl = unifiedOrderUrl;
    }

    public String getOrderQueryUrl() {
        return orderQueryUrl;
    }

    public void setOrderQueryUrl(String orderQueryUrl) {
        this.orderQueryUrl = orderQueryUrl;
    }

    public String getExceptMenu() {
        return exceptMenu;
    }

    public void setExceptMenu(String exceptMenu) {
        this.exceptMenu = exceptMenu;
    }
}
