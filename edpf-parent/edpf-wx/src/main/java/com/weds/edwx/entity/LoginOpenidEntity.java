package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class LoginOpenidEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String openid;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-26 13:29:55", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer sendStatus;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String unionId;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column wx_login_openid.xh
     *
     * @return the value of wx_login_openid.xh
     */
    public Long getXh() {
        return xh;
    }

    /**
     */
    public LoginOpenidEntity withXh(Long xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_openid.xh
     *
     * @param xh the value for wx_login_openid.xh
     */
    public void setXh(Long xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wx_login_openid.user_serial
     *
     * @return the value of wx_login_openid.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public LoginOpenidEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_openid.user_serial
     *
     * @param userSerial the value for wx_login_openid.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column wx_login_openid.openid
     *
     * @return the value of wx_login_openid.openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     */
    public LoginOpenidEntity withOpenid(String openid) {
        this.setOpenid(openid);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_openid.openid
     *
     * @param openid the value for wx_login_openid.openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * This method returns the value of the database column wx_login_openid.sj
     *
     * @return the value of wx_login_openid.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public LoginOpenidEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_openid.sj
     *
     * @param sj the value for wx_login_openid.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column wx_login_openid.send_status
     *
     * @return the value of wx_login_openid.send_status
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     */
    public LoginOpenidEntity withSendStatus(Integer sendStatus) {
        this.setSendStatus(sendStatus);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_openid.send_status
     *
     * @param sendStatus the value for wx_login_openid.send_status
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}