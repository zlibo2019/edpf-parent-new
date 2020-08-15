package com.weds.edpf.core.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.gateway")
public class GatewayParams {

    private String sourceUrl = "https://open.weixin.qq.com,https://api.weixin.qq.com,https://api.mch.weixin.qq.com";

    private String targetUrl = "https://enterprises.weds.com.cn/qiye/vedwx/web/wx";

    private String host;

    private int port;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
