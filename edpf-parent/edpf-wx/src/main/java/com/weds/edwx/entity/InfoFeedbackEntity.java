package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class InfoFeedbackEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String infoTitle;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String infoContent;

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
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 13:24:03", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    private String userLname;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column INFO_FEEDBACK.XH
     *
     * @return the value of INFO_FEEDBACK.XH
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public InfoFeedbackEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.XH
     *
     * @param xh the value for INFO_FEEDBACK.XH
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.USER_SERIAL
     *
     * @return the value of INFO_FEEDBACK.USER_SERIAL
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public InfoFeedbackEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.USER_SERIAL
     *
     * @param userSerial the value for INFO_FEEDBACK.USER_SERIAL
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.INFO_TITLE
     *
     * @return the value of INFO_FEEDBACK.INFO_TITLE
     */
    public String getInfoTitle() {
        return infoTitle;
    }

    /**
     */
    public InfoFeedbackEntity withInfoTitle(String infoTitle) {
        this.setInfoTitle(infoTitle);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.INFO_TITLE
     *
     * @param infoTitle the value for INFO_FEEDBACK.INFO_TITLE
     */
    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.INFO_CONTENT
     *
     * @return the value of INFO_FEEDBACK.INFO_CONTENT
     */
    public String getInfoContent() {
        return infoContent;
    }

    /**
     */
    public InfoFeedbackEntity withInfoContent(String infoContent) {
        this.setInfoContent(infoContent);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.INFO_CONTENT
     *
     * @param infoContent the value for INFO_FEEDBACK.INFO_CONTENT
     */
    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.SPARE_COL1
     *
     * @return the value of INFO_FEEDBACK.SPARE_COL1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public InfoFeedbackEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.SPARE_COL1
     *
     * @param spareCol1 the value for INFO_FEEDBACK.SPARE_COL1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.SPARE_COL2
     *
     * @return the value of INFO_FEEDBACK.SPARE_COL2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public InfoFeedbackEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.SPARE_COL2
     *
     * @param spareCol2 the value for INFO_FEEDBACK.SPARE_COL2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.SPARE_COL3
     *
     * @return the value of INFO_FEEDBACK.SPARE_COL3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public InfoFeedbackEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.SPARE_COL3
     *
     * @param spareCol3 the value for INFO_FEEDBACK.SPARE_COL3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.DINE_BZ
     *
     * @return the value of INFO_FEEDBACK.DINE_BZ
     */
    public String getDineBz() {
        return dineBz;
    }

    /**
     */
    public InfoFeedbackEntity withDineBz(String dineBz) {
        this.setDineBz(dineBz);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.DINE_BZ
     *
     * @param dineBz the value for INFO_FEEDBACK.DINE_BZ
     */
    public void setDineBz(String dineBz) {
        this.dineBz = dineBz;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.SJ
     *
     * @return the value of INFO_FEEDBACK.SJ
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public InfoFeedbackEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.SJ
     *
     * @param sj the value for INFO_FEEDBACK.SJ
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column INFO_FEEDBACK.GLY_NO
     *
     * @return the value of INFO_FEEDBACK.GLY_NO
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public InfoFeedbackEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column INFO_FEEDBACK.GLY_NO
     *
     * @param glyNo the value for INFO_FEEDBACK.GLY_NO
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }
}