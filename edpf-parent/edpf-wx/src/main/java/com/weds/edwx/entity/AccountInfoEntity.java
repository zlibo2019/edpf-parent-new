package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class AccountInfoEntity extends BaseEntity implements Serializable {
    private String userLname;
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "人员序号")
    private Integer userSerial;
    @ApiModelProperty(required = true, dataType = "String", example = "100.01", value = "账户余额")
    private String acMoney;
    @ApiModelProperty(required = true, dataType = "String", example = "100.01", value = "现金余额")
    private String acAddo;
    @ApiModelProperty(required = true, dataType = "String", example = "100.01", value = "补贴余额")
    private String acSubo;

    public Integer getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    public String getAcMoney() {
        return acMoney;
    }

    public void setAcMoney(String acMoney) {
        this.acMoney = acMoney;
    }

    public String getAcAddo() {
        return acAddo;
    }

    public void setAcAddo(String acAddo) {
        this.acAddo = acAddo;
    }

    public String getAcSubo() {
        return acSubo;
    }

    public void setAcSubo(String acSubo) {
        this.acSubo = acSubo;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }
}
