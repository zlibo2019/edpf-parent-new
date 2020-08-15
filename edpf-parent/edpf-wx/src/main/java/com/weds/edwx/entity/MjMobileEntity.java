package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class MjMobileEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "人员序号")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "门编号")
    private String gateBh;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-22 15:00:34", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门顺序号")
    private Integer gateOrder;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "门名称")
    private String doorName;

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column WT_mj_mobile.xh
     *
     * @return the value of WT_mj_mobile.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MjMobileEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.xh
     *
     * @param xh the value for WT_mj_mobile.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.user_serial
     *
     * @return the value of WT_mj_mobile.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MjMobileEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.user_serial
     *
     * @param userSerial the value for WT_mj_mobile.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.lx
     *
     * @return the value of WT_mj_mobile.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public MjMobileEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.lx
     *
     * @param lx the value for WT_mj_mobile.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gate_bh
     *
     * @return the value of WT_mj_mobile.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public MjMobileEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gate_bh
     *
     * @param gateBh the value for WT_mj_mobile.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.sj
     *
     * @return the value of WT_mj_mobile.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjMobileEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.sj
     *
     * @param sj the value for WT_mj_mobile.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gly_no
     *
     * @return the value of WT_mj_mobile.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjMobileEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gly_no
     *
     * @param glyNo the value for WT_mj_mobile.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column WT_mj_mobile.gate_order
     *
     * @return the value of WT_mj_mobile.gate_order
     */
    public Integer getGateOrder() {
        return gateOrder;
    }

    /**
     */
    public MjMobileEntity withGateOrder(Integer gateOrder) {
        this.setGateOrder(gateOrder);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mj_mobile.gate_order
     *
     * @param gateOrder the value for WT_mj_mobile.gate_order
     */
    public void setGateOrder(Integer gateOrder) {
        this.gateOrder = gateOrder;
    }
}