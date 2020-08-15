package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 账户充值日志
 * @Date 2019-10-22
 */
public class AccountRechargeLogEntity extends BaseEntity implements Serializable {
    /**
     * id
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "id")
    private String id;

    /**
     * 用户编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号")
    private String userSerial;

    /**
     * 身份证号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "身份证号")
    private String userIdcard;

    /**
     * 充值金额
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "充值金额")
    private Long transAmt;

    /**
     * 充值渠道
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "充值渠道")
    private String transChannel;

    /**
     * 充值状态
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "充值状态")
    private String transState;

    /**
     * 充值时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-22 15:29:22", value = "充值时间")
    private Date transDate;

    /**
     * 充值ip地址
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "充值ip地址")
    private String transIp;

    /**
     * 交易流水号
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "交易流水号")
    private String transNo;

    /**
     * 交易时间
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "交易时间")
    private String transSj;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_account_recharge_log.id
     *
     * @return the value of ed_account_recharge_log.id
     */
    public String getId() {
        return id;
    }

    /**
     */
    public AccountRechargeLogEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.id
     *
     * @param id the value for ed_account_recharge_log.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.user_serial
     *
     * @return the value of ed_account_recharge_log.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public AccountRechargeLogEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.user_serial
     *
     * @param userSerial the value for ed_account_recharge_log.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.user_idcard
     *
     * @return the value of ed_account_recharge_log.user_idcard
     */
    public String getUserIdcard() {
        return userIdcard;
    }

    /**
     */
    public AccountRechargeLogEntity withUserIdcard(String userIdcard) {
        this.setUserIdcard(userIdcard);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.user_idcard
     *
     * @param userIdcard the value for ed_account_recharge_log.user_idcard
     */
    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_amt
     *
     * @return the value of ed_account_recharge_log.trans_amt
     */
    public Long getTransAmt() {
        return transAmt;
    }

    /**
     */
    public AccountRechargeLogEntity withTransAmt(Long transAmt) {
        this.setTransAmt(transAmt);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_amt
     *
     * @param transAmt the value for ed_account_recharge_log.trans_amt
     */
    public void setTransAmt(Long transAmt) {
        this.transAmt = transAmt;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_channel
     *
     * @return the value of ed_account_recharge_log.trans_channel
     */
    public String getTransChannel() {
        return transChannel;
    }

    /**
     */
    public AccountRechargeLogEntity withTransChannel(String transChannel) {
        this.setTransChannel(transChannel);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_channel
     *
     * @param transChannel the value for ed_account_recharge_log.trans_channel
     */
    public void setTransChannel(String transChannel) {
        this.transChannel = transChannel;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_state
     *
     * @return the value of ed_account_recharge_log.trans_state
     */
    public String getTransState() {
        return transState;
    }

    /**
     */
    public AccountRechargeLogEntity withTransState(String transState) {
        this.setTransState(transState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_state
     *
     * @param transState the value for ed_account_recharge_log.trans_state
     */
    public void setTransState(String transState) {
        this.transState = transState;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_date
     *
     * @return the value of ed_account_recharge_log.trans_date
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     */
    public AccountRechargeLogEntity withTransDate(Date transDate) {
        this.setTransDate(transDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_date
     *
     * @param transDate the value for ed_account_recharge_log.trans_date
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_ip
     *
     * @return the value of ed_account_recharge_log.trans_ip
     */
    public String getTransIp() {
        return transIp;
    }

    /**
     */
    public AccountRechargeLogEntity withTransIp(String transIp) {
        this.setTransIp(transIp);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_ip
     *
     * @param transIp the value for ed_account_recharge_log.trans_ip
     */
    public void setTransIp(String transIp) {
        this.transIp = transIp;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_no
     *
     * @return the value of ed_account_recharge_log.trans_no
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     */
    public AccountRechargeLogEntity withTransNo(String transNo) {
        this.setTransNo(transNo);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_no
     *
     * @param transNo the value for ed_account_recharge_log.trans_no
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    /**
     * This method returns the value of the database column ed_account_recharge_log.trans_sj
     *
     * @return the value of ed_account_recharge_log.trans_sj
     */
    public String getTransSj() {
        return transSj;
    }

    /**
     */
    public AccountRechargeLogEntity withTransSj(String transSj) {
        this.setTransSj(transSj);
        return this;
    }

    /**
     * This method sets the value of the database column ed_account_recharge_log.trans_sj
     *
     * @param transSj the value for ed_account_recharge_log.trans_sj
     */
    public void setTransSj(String transSj) {
        this.transSj = transSj;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}