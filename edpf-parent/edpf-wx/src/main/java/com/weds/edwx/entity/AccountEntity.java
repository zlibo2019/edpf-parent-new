package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountEntity extends BaseEntity implements Serializable {
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
    private String openId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String orderId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal addMoney;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 13:30:08", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer state;

    private String tradeNo;

    private Integer lx;

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column wx_account.Xh
     *
     * @return the value of wx_account.Xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public AccountEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.Xh
     *
     * @param xh the value for wx_account.Xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wx_account.user_serial
     *
     * @return the value of wx_account.user_serial
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public AccountEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.user_serial
     *
     * @param userSerial the value for wx_account.user_serial
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column wx_account.open_id
     *
     * @return the value of wx_account.open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     */
    public AccountEntity withOpenId(String openId) {
        this.setOpenId(openId);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.open_id
     *
     * @param openId the value for wx_account.open_id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * This method returns the value of the database column wx_account.order_id
     *
     * @return the value of wx_account.order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     */
    public AccountEntity withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.order_id
     *
     * @param orderId the value for wx_account.order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method returns the value of the database column wx_account.add_money
     *
     * @return the value of wx_account.add_money
     */
    public BigDecimal getAddMoney() {
        return addMoney;
    }

    /**
     */
    public AccountEntity withAddMoney(BigDecimal addMoney) {
        this.setAddMoney(addMoney);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.add_money
     *
     * @param addMoney the value for wx_account.add_money
     */
    public void setAddMoney(BigDecimal addMoney) {
        this.addMoney = addMoney;
    }

    /**
     * This method returns the value of the database column wx_account.sj
     *
     * @return the value of wx_account.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public AccountEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.sj
     *
     * @param sj the value for wx_account.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column wx_account.state
     *
     * @return the value of wx_account.state
     */
    public Integer getState() {
        return state;
    }

    /**
     */
    public AccountEntity withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column wx_account.state
     *
     * @param state the value for wx_account.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}