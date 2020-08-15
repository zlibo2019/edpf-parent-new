package com.weds.edwx.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ApprovalParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121809135402", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = true, dataType = "String", example = "123546", value = "审批唯一ID")
    private String checkId;

    @ApiModelProperty(required = true, dataType = "String", example = "1", value = "1:同意,2:拒绝")
    private String result;

    @ApiModelProperty(required = false, dataType = "String", example = "测试", value = "原因")
    private String reason;

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
