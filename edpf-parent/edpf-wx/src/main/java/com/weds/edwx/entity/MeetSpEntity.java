package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class MeetSpEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer spOrder;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer spJg;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-11-28 15:27:01", value = "")
    private Date sj;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spYj;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer spFlag;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer meetBh;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    private String userLname;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column meet_sp.xh
     *
     * @return the value of meet_sp.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MeetSpEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.xh
     *
     * @param xh the value for meet_sp.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column meet_sp.user_serial
     *
     * @return the value of meet_sp.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MeetSpEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.user_serial
     *
     * @param userSerial the value for meet_sp.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column meet_sp.sp_order
     *
     * @return the value of meet_sp.sp_order
     */
    public Integer getSpOrder() {
        return spOrder;
    }

    /**
     */
    public MeetSpEntity withSpOrder(Integer spOrder) {
        this.setSpOrder(spOrder);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.sp_order
     *
     * @param spOrder the value for meet_sp.sp_order
     */
    public void setSpOrder(Integer spOrder) {
        this.spOrder = spOrder;
    }

    /**
     * This method returns the value of the database column meet_sp.sp_jg
     *
     * @return the value of meet_sp.sp_jg
     */
    public Integer getSpJg() {
        return spJg;
    }

    /**
     */
    public MeetSpEntity withSpJg(Integer spJg) {
        this.setSpJg(spJg);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.sp_jg
     *
     * @param spJg the value for meet_sp.sp_jg
     */
    public void setSpJg(Integer spJg) {
        this.spJg = spJg;
    }

    /**
     * This method returns the value of the database column meet_sp.sj
     *
     * @return the value of meet_sp.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MeetSpEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.sj
     *
     * @param sj the value for meet_sp.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column meet_sp.sp_yj
     *
     * @return the value of meet_sp.sp_yj
     */
    public String getSpYj() {
        return spYj;
    }

    /**
     */
    public MeetSpEntity withSpYj(String spYj) {
        this.setSpYj(spYj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.sp_yj
     *
     * @param spYj the value for meet_sp.sp_yj
     */
    public void setSpYj(String spYj) {
        this.spYj = spYj;
    }

    /**
     * This method returns the value of the database column meet_sp.gly_no
     *
     * @return the value of meet_sp.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MeetSpEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.gly_no
     *
     * @param glyNo the value for meet_sp.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column meet_sp.sp_flag
     *
     * @return the value of meet_sp.sp_flag
     */
    public Integer getSpFlag() {
        return spFlag;
    }

    /**
     */
    public MeetSpEntity withSpFlag(Integer spFlag) {
        this.setSpFlag(spFlag);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.sp_flag
     *
     * @param spFlag the value for meet_sp.sp_flag
     */
    public void setSpFlag(Integer spFlag) {
        this.spFlag = spFlag;
    }

    /**
     * This method returns the value of the database column meet_sp.meet_bh
     *
     * @return the value of meet_sp.meet_bh
     */
    public Integer getMeetBh() {
        return meetBh;
    }

    /**
     */
    public MeetSpEntity withMeetBh(Integer meetBh) {
        this.setMeetBh(meetBh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_sp.meet_bh
     *
     * @param meetBh the value for meet_sp.meet_bh
     */
    public void setMeetBh(Integer meetBh) {
        this.meetBh = meetBh;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}