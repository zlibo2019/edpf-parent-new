package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 外勤记录
 * @Date 2019-08-26
 */
public class OutsideEntity extends BaseEntity implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "id")
    private Long id;

    /**
     * 用户编号##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号##1###")
    private String userSerial;


    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户姓名")
    private String userLname;

    /**
     * 记录时间##1###
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-26 17:14:40", value = "记录时间##1###")
    private Date recordTime;

    /**
     * 方向##1###
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "方向##1###")
    private Integer fx;

    /**
     * 地址##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "地址##1###")
    private String address;

    /**
     * 经度##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "经度##1###")
    private String lang;

    /**
     * 维度##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "维度##1###")
    private String lat;

    /**
     * 客户名称##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "客户名称##1###")
    private String customerName;

    /**
     * 备注##1###
     */
    @Size(max = 2000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注##1###")
    private String outsideInfo;

    /**
     * 审核人##1###
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "审核人##1###")
    private String shenhe;

    private String shenheLname;

    /**
     * 设备编号
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "设备编号")
    private String devSerial;

    /**
     * 照片编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "-1", value = "照片编号")
    private String jlzpSerial;

    private String type;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column wx_outside_record.id
     *
     * @return the value of wx_outside_record.id
     */
    public Long getId() {
        return id;
    }

    /**
     */
    public OutsideEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.id
     *
     * @param id the value for wx_outside_record.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column wx_outside_record.user_serial
     *
     * @return the value of wx_outside_record.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public OutsideEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.user_serial
     *
     * @param userSerial the value for wx_outside_record.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column wx_outside_record.record_time
     *
     * @return the value of wx_outside_record.record_time
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     */
    public OutsideEntity withRecordTime(Date recordTime) {
        this.setRecordTime(recordTime);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.record_time
     *
     * @param recordTime the value for wx_outside_record.record_time
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * This method returns the value of the database column wx_outside_record.fx
     *
     * @return the value of wx_outside_record.fx
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public OutsideEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.fx
     *
     * @param fx the value for wx_outside_record.fx
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column wx_outside_record.address
     *
     * @return the value of wx_outside_record.address
     */
    public String getAddress() {
        return address;
    }

    /**
     */
    public OutsideEntity withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.address
     *
     * @param address the value for wx_outside_record.address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * This method returns the value of the database column wx_outside_record.lat
     *
     * @return the value of wx_outside_record.lat
     */
    public String getLat() {
        return lat;
    }

    /**
     */
    public OutsideEntity withLat(String lat) {
        this.setLat(lat);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.lat
     *
     * @param lat the value for wx_outside_record.lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * This method returns the value of the database column wx_outside_record.customer_name
     *
     * @return the value of wx_outside_record.customer_name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     */
    public OutsideEntity withCustomerName(String customerName) {
        this.setCustomerName(customerName);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.customer_name
     *
     * @param customerName the value for wx_outside_record.customer_name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * This method returns the value of the database column wx_outside_record.outside_info
     *
     * @return the value of wx_outside_record.outside_info
     */
    public String getOutsideInfo() {
        return outsideInfo;
    }

    /**
     */
    public OutsideEntity withOutsideInfo(String outsideInfo) {
        this.setOutsideInfo(outsideInfo);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.outside_info
     *
     * @param outsideInfo the value for wx_outside_record.outside_info
     */
    public void setOutsideInfo(String outsideInfo) {
        this.outsideInfo = outsideInfo;
    }

    /**
     * This method returns the value of the database column wx_outside_record.shenhe
     *
     * @return the value of wx_outside_record.shenhe
     */
    public String getShenhe() {
        return shenhe;
    }

    /**
     */
    public OutsideEntity withShenhe(String shenhe) {
        this.setShenhe(shenhe);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.shenhe
     *
     * @param shenhe the value for wx_outside_record.shenhe
     */
    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

    /**
     * This method returns the value of the database column wx_outside_record.dev_serial
     *
     * @return the value of wx_outside_record.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public OutsideEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wx_outside_record.dev_serial
     *
     * @param devSerial the value for wx_outside_record.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    public String getJlzpSerial() {
        return jlzpSerial;
    }

    public void setJlzpSerial(String jlzpSerial) {
        this.jlzpSerial = jlzpSerial;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShenheLname() {
        return shenheLname;
    }

    public void setShenheLname(String shenheLname) {
        this.shenheLname = shenheLname;
    }
}