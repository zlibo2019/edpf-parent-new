package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DineUserEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isAuto;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol1;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol2;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String spareCol3;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String dineBz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-13 14:41:39", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column DINE_USER.USER_SERIAL
     *
     * @return the value of DINE_USER.USER_SERIAL
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public DineUserEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.USER_SERIAL
     *
     * @param userSerial the value for DINE_USER.USER_SERIAL
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column DINE_USER.IS_AUTO
     *
     * @return the value of DINE_USER.IS_AUTO
     */
    public Integer getIsAuto() {
        return isAuto;
    }

    /**
     */
    public DineUserEntity withIsAuto(Integer isAuto) {
        this.setIsAuto(isAuto);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.IS_AUTO
     *
     * @param isAuto the value for DINE_USER.IS_AUTO
     */
    public void setIsAuto(Integer isAuto) {
        this.isAuto = isAuto;
    }

    /**
     * This method returns the value of the database column DINE_USER.SPARE_COL1
     *
     * @return the value of DINE_USER.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public DineUserEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.SPARE_COL1
     *
     * @param spareCol1 the value for DINE_USER.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column DINE_USER.SPARE_COL2
     *
     * @return the value of DINE_USER.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public DineUserEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.SPARE_COL2
     *
     * @param spareCol2 the value for DINE_USER.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column DINE_USER.SPARE_COL3
     *
     * @return the value of DINE_USER.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public DineUserEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.SPARE_COL3
     *
     * @param spareCol3 the value for DINE_USER.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column DINE_USER.DINE_BZ
     *
     * @return the value of DINE_USER.DINE_BZ
     */
    public String getDineBz() {
        return dineBz;
    }

    /**
     */
    public DineUserEntity withDineBz(String dineBz) {
        this.setDineBz(dineBz);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.DINE_BZ
     *
     * @param dineBz the value for DINE_USER.DINE_BZ
     */
    public void setDineBz(String dineBz) {
        this.dineBz = dineBz;
    }

    /**
     * This method returns the value of the database column DINE_USER.SJ
     *
     * @return the value of DINE_USER.SJ
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DineUserEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.SJ
     *
     * @param sj the value for DINE_USER.SJ
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column DINE_USER.GLY_NO
     *
     * @return the value of DINE_USER.GLY_NO
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DineUserEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column DINE_USER.GLY_NO
     *
     * @param glyNo the value for DINE_USER.GLY_NO
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }
}