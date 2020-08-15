package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DineGlobalEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isAllow;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isCord;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 13:03:08", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String remark;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column dine_global.bh
     *
     * @return the value of dine_global.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public DineGlobalEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.bh
     *
     * @param bh the value for dine_global.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column dine_global.is_allow
     *
     * @return the value of dine_global.is_allow
     */
    public Integer getIsAllow() {
        return isAllow;
    }

    /**
     */
    public DineGlobalEntity withIsAllow(Integer isAllow) {
        this.setIsAllow(isAllow);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.is_allow
     *
     * @param isAllow the value for dine_global.is_allow
     */
    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

    /**
     * This method returns the value of the database column dine_global.is_cord
     *
     * @return the value of dine_global.is_cord
     */
    public Integer getIsCord() {
        return isCord;
    }

    /**
     */
    public DineGlobalEntity withIsCord(Integer isCord) {
        this.setIsCord(isCord);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.is_cord
     *
     * @param isCord the value for dine_global.is_cord
     */
    public void setIsCord(Integer isCord) {
        this.isCord = isCord;
    }

    /**
     * This method returns the value of the database column dine_global.gly_no
     *
     * @return the value of dine_global.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DineGlobalEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.gly_no
     *
     * @param glyNo the value for dine_global.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column dine_global.sj
     *
     * @return the value of dine_global.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DineGlobalEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.sj
     *
     * @param sj the value for dine_global.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dine_global.remark
     *
     * @return the value of dine_global.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public DineGlobalEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column dine_global.remark
     *
     * @param remark the value for dine_global.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}