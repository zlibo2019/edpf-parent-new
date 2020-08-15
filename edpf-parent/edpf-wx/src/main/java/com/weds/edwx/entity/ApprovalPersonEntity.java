package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ApprovalPersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "王富贵", value = "人员姓名")
    private String userName;

    @ApiModelProperty(required = false, dataType = "int", example = "0", value = "审批状态")
    private int type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "1970-01-01 00:00:00", value = "操作日期")
    private Date czrq;

    @ApiModelProperty(required = false,dataType = "String",example = "测试",value = "测试")
    private String reason;

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public Date getCzrq() {
        return czrq;
    }

    public void setCzrq(Date czrq) {
        this.czrq = czrq;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
