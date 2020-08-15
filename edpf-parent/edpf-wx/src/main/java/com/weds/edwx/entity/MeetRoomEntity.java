package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MeetRoomEntity extends BaseEntity implements Serializable {
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial; //会议室编号

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depName; //会议室名称

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String picUrl; //会议室图片地址

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String resourceName; //会议室资源

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh; //会议编号

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String meetName; //会议名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:36:23", value = "")
    private Date kssj; //开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:36:23", value = "")
    private Date jssj; //结束时间

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer meetState; //会议状态 0 未开始 1 进行中 2 已结束

    private List<RoomResourceEntity> roomResource;

    public List<RoomResourceEntity> getRoomResource() {
        return roomResource;
    }

    public void setRoomResource(List<RoomResourceEntity> roomResource) {
        this.roomResource = roomResource;
    }

    public Integer getDepSerial() {
        return depSerial;
    }

    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }

    public String getMeetName() {
        return meetName;
    }

    public void setMeetName(String meetName) {
        this.meetName = meetName;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public Integer getMeetState() {
        return meetState;
    }

    public void setMeetState(Integer meetState) {
        this.meetState = meetState;
    }
}
