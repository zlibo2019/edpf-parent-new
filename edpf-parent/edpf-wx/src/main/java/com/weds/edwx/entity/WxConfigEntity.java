package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class WxConfigEntity extends BaseEntity implements Serializable {
    @ApiModelProperty(required = true, dataType = "String", example = "http://", value = "调sdk的地址")
    private String url;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "sdk类型")
    private Integer sdkLx;

    @ApiModelProperty(required = true, dataType = "Long", example = "-1", value = "人员序号")
    private Long userSerial;

    @ApiModelProperty(required = true, dataType = "String", example = "测试", value = "返回的二维码字符串")
    private Object codeStr;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSdkLx() {
        return sdkLx;
    }

    public void setSdkLx(Integer sdkLx) {
        this.sdkLx = sdkLx;
    }

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    public Object getCodeStr() {
        return codeStr;
    }

    public void setCodeStr(Object codeStr) {
        this.codeStr = codeStr;
    }
}
