package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class LoginLogEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer state;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String userNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String userLname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String openid;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String logSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String logBz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String orderId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String gateBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long visitorXh;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column wx_login_log.xh
     *
     * @return the value of wx_login_log.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public LoginLogEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.xh
     *
     * @param xh the value for wx_login_log.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wx_login_log.lx
     *
     * @return the value of wx_login_log.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public LoginLogEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.lx
     *
     * @param lx the value for wx_login_log.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column wx_login_log.state
     *
     * @return the value of wx_login_log.state
     */
    public Integer getState() {
        return state;
    }

    /**
     */
    public LoginLogEntity withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.state
     *
     * @param state the value for wx_login_log.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method returns the value of the database column wx_login_log.user_serial
     *
     * @return the value of wx_login_log.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public LoginLogEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.user_serial
     *
     * @param userSerial the value for wx_login_log.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column wx_login_log.user_no
     *
     * @return the value of wx_login_log.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public LoginLogEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.user_no
     *
     * @param userNo the value for wx_login_log.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column wx_login_log.user_lname
     *
     * @return the value of wx_login_log.user_lname
     */
    public String getUserLname() {
        return userLname;
    }

    /**
     */
    public LoginLogEntity withUserLname(String userLname) {
        this.setUserLname(userLname);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.user_lname
     *
     * @param userLname the value for wx_login_log.user_lname
     */
    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column wx_login_log.openid
     *
     * @return the value of wx_login_log.openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     */
    public LoginLogEntity withOpenid(String openid) {
        this.setOpenid(openid);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.openid
     *
     * @param openid the value for wx_login_log.openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * This method returns the value of the database column wx_login_log.log_sj
     *
     * @return the value of wx_login_log.log_sj
     */
    public String getLogSj() {
        return logSj;
    }

    /**
     */
    public LoginLogEntity withLogSj(String logSj) {
        this.setLogSj(logSj);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.log_sj
     *
     * @param logSj the value for wx_login_log.log_sj
     */
    public void setLogSj(String logSj) {
        this.logSj = logSj;
    }

    /**
     * This method returns the value of the database column wx_login_log.log_bz
     *
     * @return the value of wx_login_log.log_bz
     */
    public String getLogBz() {
        return logBz;
    }

    /**
     */
    public LoginLogEntity withLogBz(String logBz) {
        this.setLogBz(logBz);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.log_bz
     *
     * @param logBz the value for wx_login_log.log_bz
     */
    public void setLogBz(String logBz) {
        this.logBz = logBz;
    }

    /**
     * This method returns the value of the database column wx_login_log.order_id
     *
     * @return the value of wx_login_log.order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     */
    public LoginLogEntity withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.order_id
     *
     * @param orderId the value for wx_login_log.order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method returns the value of the database column wx_login_log.gate_bh
     *
     * @return the value of wx_login_log.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public LoginLogEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.gate_bh
     *
     * @param gateBh the value for wx_login_log.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column wx_login_log.visitor_xh
     *
     * @return the value of wx_login_log.visitor_xh
     */
    public Long getVisitorXh() {
        return visitorXh;
    }

    /**
     */
    public LoginLogEntity withVisitorXh(Long visitorXh) {
        this.setVisitorXh(visitorXh);
        return this;
    }

    /**
     * This method sets the value of the database column wx_login_log.visitor_xh
     *
     * @param visitorXh the value for wx_login_log.visitor_xh
     */
    public void setVisitorXh(Long visitorXh) {
        this.visitorXh = visitorXh;
    }
}