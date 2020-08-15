package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class AddAttenceParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-12-26 18:22:47", value = "时间")
    private Date sj;

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "类型,固定为0")
    private String lx;

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "方向")
    private String fx;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "openId")
    private String openId;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "人员工号")
    private String userNo;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "姓名")
    private String lname;

    @ApiModelProperty(required = true, dataType = "String", example = "0010001", value = "设备序号")
    private Integer devSerial;

    @ApiModelProperty(required = true, dataType = "String", example = "1", value = "照片序号")
    private String jlzpSerial;

    private String image;

    private String data;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "经度")
    private String jing;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "纬度")
    private String wei;

    private String address;

    private Integer jlType;

    private String recordNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(Integer devSerial) {
        this.devSerial = devSerial;
    }

    public String getJlzpSerial() {
        return jlzpSerial;
    }

    public void setJlzpSerial(String jlzpSerial) {
        this.jlzpSerial = jlzpSerial;
    }

    public String getJing() {
        return jing;
    }

    public void setJing(String jing) {
        this.jing = jing;
    }

    public String getWei() {
        return wei;
    }

    public void setWei(String wei) {
        this.wei = wei;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getJlType() {
        return jlType;
    }

    public void setJlType(Integer jlType) {
        this.jlType = jlType;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }
}
