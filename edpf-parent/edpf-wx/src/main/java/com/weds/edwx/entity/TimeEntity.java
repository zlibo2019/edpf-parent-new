package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TimeEntity extends BaseEntity implements Serializable {
    @ApiModelProperty(required = true, dataType = "String", example = "2018-11-14", value = "")
    private String cdate;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomBh;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "0:未开始;2:已结束;不传为全部;")
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRoomBh() {
        return roomBh;
    }

    public void setRoomBh(Integer roomBh) {
        this.roomBh = roomBh;
    }

    public Integer getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    public String getCdate() {
        return cdate;
    }

    /**
     */
    public TimeEntity withCdate(String cdate) {
        this.setCdate(cdate);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.lname
     *
     * @param cdate the value for dt_meet.lname
     */
    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}
