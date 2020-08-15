package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class UserPowerEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userType;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-09 14:22:21", value = "")
    private Date sj;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column user_power.user_serial
     *
     * @return the value of user_power.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public UserPowerEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column user_power.user_serial
     *
     * @param userSerial the value for user_power.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column user_power.xh
     *
     * @return the value of user_power.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public UserPowerEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column user_power.xh
     *
     * @param xh the value for user_power.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column user_power.user_type
     *
     * @return the value of user_power.user_type
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     */
    public UserPowerEntity withUserType(Integer userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * This method sets the value of the database column user_power.user_type
     *
     * @param userType the value for user_power.user_type
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * This method returns the value of the database column user_power.gly_no
     *
     * @return the value of user_power.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public UserPowerEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column user_power.gly_no
     *
     * @param glyNo the value for user_power.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column user_power.sj
     *
     * @return the value of user_power.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public UserPowerEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column user_power.sj
     *
     * @param sj the value for user_power.sj
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