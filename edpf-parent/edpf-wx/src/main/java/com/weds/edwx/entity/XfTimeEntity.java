package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class XfTimeEntity extends BaseEntity implements Serializable {
    @ApiModelProperty(required = true, dataType = "String", example = "2018-11-14", value = "")
    private String beginDate;

    @ApiModelProperty(required = true, dataType = "String", example = "2018-11-14", value = "")
    private String endDate;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer type;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
