package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DeviceMonitorEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer onlineState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devDowndata;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devDownfile;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devUpdate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devUpfile;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devSoftver;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-24 10:20:22", value = "")
    private Date onlineSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devState;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column st_device_monitor.xh
     *
     * @return the value of st_device_monitor.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DeviceMonitorEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.xh
     *
     * @param xh the value for st_device_monitor.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_serial
     *
     * @return the value of st_device_monitor.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public DeviceMonitorEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_serial
     *
     * @param devSerial the value for st_device_monitor.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_id
     *
     * @return the value of st_device_monitor.dev_id
     */
    public Integer getDevId() {
        return devId;
    }

    /**
     */
    public DeviceMonitorEntity withDevId(Integer devId) {
        this.setDevId(devId);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_id
     *
     * @param devId the value for st_device_monitor.dev_id
     */
    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    /**
     * This method returns the value of the database column st_device_monitor.online_state
     *
     * @return the value of st_device_monitor.online_state
     */
    public Integer getOnlineState() {
        return onlineState;
    }

    /**
     */
    public DeviceMonitorEntity withOnlineState(Integer onlineState) {
        this.setOnlineState(onlineState);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.online_state
     *
     * @param onlineState the value for st_device_monitor.online_state
     */
    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_downdata
     *
     * @return the value of st_device_monitor.dev_downdata
     */
    public Integer getDevDowndata() {
        return devDowndata;
    }

    /**
     */
    public DeviceMonitorEntity withDevDowndata(Integer devDowndata) {
        this.setDevDowndata(devDowndata);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_downdata
     *
     * @param devDowndata the value for st_device_monitor.dev_downdata
     */
    public void setDevDowndata(Integer devDowndata) {
        this.devDowndata = devDowndata;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_downfile
     *
     * @return the value of st_device_monitor.dev_downfile
     */
    public Integer getDevDownfile() {
        return devDownfile;
    }

    /**
     */
    public DeviceMonitorEntity withDevDownfile(Integer devDownfile) {
        this.setDevDownfile(devDownfile);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_downfile
     *
     * @param devDownfile the value for st_device_monitor.dev_downfile
     */
    public void setDevDownfile(Integer devDownfile) {
        this.devDownfile = devDownfile;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_update
     *
     * @return the value of st_device_monitor.dev_update
     */
    public Integer getDevUpdate() {
        return devUpdate;
    }

    /**
     */
    public DeviceMonitorEntity withDevUpdate(Integer devUpdate) {
        this.setDevUpdate(devUpdate);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_update
     *
     * @param devUpdate the value for st_device_monitor.dev_update
     */
    public void setDevUpdate(Integer devUpdate) {
        this.devUpdate = devUpdate;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_upfile
     *
     * @return the value of st_device_monitor.dev_upfile
     */
    public Integer getDevUpfile() {
        return devUpfile;
    }

    /**
     */
    public DeviceMonitorEntity withDevUpfile(Integer devUpfile) {
        this.setDevUpfile(devUpfile);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_upfile
     *
     * @param devUpfile the value for st_device_monitor.dev_upfile
     */
    public void setDevUpfile(Integer devUpfile) {
        this.devUpfile = devUpfile;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_softver
     *
     * @return the value of st_device_monitor.dev_softver
     */
    public String getDevSoftver() {
        return devSoftver;
    }

    /**
     */
    public DeviceMonitorEntity withDevSoftver(String devSoftver) {
        this.setDevSoftver(devSoftver);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_softver
     *
     * @param devSoftver the value for st_device_monitor.dev_softver
     */
    public void setDevSoftver(String devSoftver) {
        this.devSoftver = devSoftver;
    }

    /**
     * This method returns the value of the database column st_device_monitor.online_sj
     *
     * @return the value of st_device_monitor.online_sj
     */
    public Date getOnlineSj() {
        return onlineSj;
    }

    /**
     */
    public DeviceMonitorEntity withOnlineSj(Date onlineSj) {
        this.setOnlineSj(onlineSj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.online_sj
     *
     * @param onlineSj the value for st_device_monitor.online_sj
     */
    public void setOnlineSj(Date onlineSj) {
        this.onlineSj = onlineSj;
    }

    /**
     * This method returns the value of the database column st_device_monitor.dev_state
     *
     * @return the value of st_device_monitor.dev_state
     */
    public Integer getDevState() {
        return devState;
    }

    /**
     */
    public DeviceMonitorEntity withDevState(Integer devState) {
        this.setDevState(devState);
        return this;
    }

    /**
     * This method sets the value of the database column st_device_monitor.dev_state
     *
     * @param devState the value for st_device_monitor.dev_state
     */
    public void setDevState(Integer devState) {
        this.devState = devState;
    }
}