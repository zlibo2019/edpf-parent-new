package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class ControlRealEntity extends BaseEntity implements Serializable {
    /**
     *   关联设备编号
     *
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "关联设备编号")
    private String devSerial;

    /**
     *   继电器顺序号从1开始累加
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "继电器顺序号从1开始累加")
    private Integer devOrder;

    /**
     *   自增序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     *   继电器名称
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "继电器名称")
    private String devName;

    /**
     *   门属性创建时间
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-31 11:46:05", value = "门属性创建时间")
    private Date sj;

    @ApiModelProperty(required = true, dataType = "int", example = "0", value = "是否被占用")
    private Integer isUse;

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column st_control_real.dev_serial
     *
     * @return the value of st_control_real.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public ControlRealEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column st_control_real.dev_serial
     *
     * @param devSerial the value for st_control_real.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column st_control_real.dev_order
     *
     * @return the value of st_control_real.dev_order
     */
    public Integer getDevOrder() {
        return devOrder;
    }

    /**
     */
    public ControlRealEntity withDevOrder(Integer devOrder) {
        this.setDevOrder(devOrder);
        return this;
    }

    /**
     * This method sets the value of the database column st_control_real.dev_order
     *
     * @param devOrder the value for st_control_real.dev_order
     */
    public void setDevOrder(Integer devOrder) {
        this.devOrder = devOrder;
    }

    /**
     * This method returns the value of the database column st_control_real.xh
     *
     * @return the value of st_control_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public ControlRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column st_control_real.xh
     *
     * @param xh the value for st_control_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column st_control_real.dev_name
     *
     * @return the value of st_control_real.dev_name
     */
    public String getDevName() {
        return devName;
    }

    /**
     */
    public ControlRealEntity withDevName(String devName) {
        this.setDevName(devName);
        return this;
    }

    /**
     * This method sets the value of the database column st_control_real.dev_name
     *
     * @param devName the value for st_control_real.dev_name
     */
    public void setDevName(String devName) {
        this.devName = devName;
    }

    /**
     * This method returns the value of the database column st_control_real.sj
     *
     * @return the value of st_control_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public ControlRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column st_control_real.sj
     *
     * @param sj the value for st_control_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}