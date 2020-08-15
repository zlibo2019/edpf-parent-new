package com.weds.edwx.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weds.custom.tongtai")
public class TongTaiParams {
    private String appkey = "ykt@tt.com";
    private String password = "123456";
    private String url = "http://bos.tongtai.com.cn:55321/servlets/binserv/Rest";
    private String defaultPwd = "123456";
    private String defaultDep = "001";
    private int row = 100;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDefaultPwd() {
        return defaultPwd;
    }

    public void setDefaultPwd(String defaultPwd) {
        this.defaultPwd = defaultPwd;
    }

    public String getDefaultDep() {
        return defaultDep;
    }

    public void setDefaultDep(String defaultDep) {
        this.defaultDep = defaultDep;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
