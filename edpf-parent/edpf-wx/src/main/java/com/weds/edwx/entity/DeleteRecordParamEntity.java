package com.weds.edwx.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DeleteRecordParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "测试", value = "原因")
    private String reason;

    @ApiModelProperty(required = true, dataType = "String", example = "2018121809135402", value = "申请编号")
    private String xh;


    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }
}
