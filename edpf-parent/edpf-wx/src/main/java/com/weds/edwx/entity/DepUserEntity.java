package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class DepUserEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depSerial;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userSerial;

    private String userName;

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
    @ApiModelProperty(required = true, dataType = "string", example = "2019-09-09 10:31:12", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column dt_dep_user.xh
     *
     * @return the value of dt_dep_user.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DepUserEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.xh
     *
     * @param xh the value for dt_dep_user.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column dt_dep_user.dep_serial
     *
     * @return the value of dt_dep_user.dep_serial
     */
    public String getDepSerial() {
        return depSerial;
    }

    /**
     */
    public DepUserEntity withDepSerial(String depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.dep_serial
     *
     * @param depSerial the value for dt_dep_user.dep_serial
     */
    public void setDepSerial(String depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column dt_dep_user.user_serial
     *
     * @return the value of dt_dep_user.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public DepUserEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.user_serial
     *
     * @param userSerial the value for dt_dep_user.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column dt_dep_user.gly_no
     *
     * @return the value of dt_dep_user.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DepUserEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.gly_no
     *
     * @param glyNo the value for dt_dep_user.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column dt_dep_user.sj
     *
     * @return the value of dt_dep_user.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DepUserEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.sj
     *
     * @param sj the value for dt_dep_user.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dt_dep_user.lx
     *
     * @return the value of dt_dep_user.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public DepUserEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep_user.lx
     *
     * @param lx the value for dt_dep_user.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}