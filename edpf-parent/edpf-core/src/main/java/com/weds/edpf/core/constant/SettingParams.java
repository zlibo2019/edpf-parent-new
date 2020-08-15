package com.weds.edpf.core.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.setting")
public class SettingParams {
    // 密钥
    private String key = "d2VkczEyMzQ1Njc4OTAxMg==";

    // 人数限制
    private String limit = "ohDbOOWosnw";

    // 公钥
    private String pubKey = "";

    // 临时目录
    private String tempDir = "";

    // 主目录
    private String sysRoot = "";

    // LOGO图片目录
    private String logoPath = "";

    // 背景图片目录
    private String backPath = "";

    // 打印纸宽度
    private int printWidth = 220;

    // 支付方式
    private String payType = "weixin";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public String getTempDir() {
        return tempDir;
    }

    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    public String getSysRoot() {
        return sysRoot;
    }

    public void setSysRoot(String sysRoot) {
        this.sysRoot = sysRoot;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getBackPath() {
        return backPath;
    }

    public void setBackPath(String backPath) {
        this.backPath = backPath;
    }

    public int getPrintWidth() {
        return printWidth;
    }

    public void setPrintWidth(int printWidth) {
        this.printWidth = printWidth;
    }
}
