package com.weds.edwx.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ManagementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "张三", value = "人员姓名")
    private String userName;

    @ApiModelProperty(required = false, dataType = "int", example = "0", value = "标志位,抄送人员是否可以删除,0:不可删,1:可删")
    private int flag;

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
