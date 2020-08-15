package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XfMenuJlEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String keyNo;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String devSerial;

    /**
     *
     */
    @Digits(integer = 15, fraction = 4)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "")
    private BigDecimal moreMoney;

    /**
     *
     */
    @Digits(integer = 15, fraction = 4)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "")
    private BigDecimal newMoney;

    private String newMoneyCn;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer moneyCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-11-27 16:29:08", value = "")
    private Date jlSj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-11-27 16:29:08", value = "")
    private Date sj;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String parentBh;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String menuName;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String cardHao;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlSerial;

    /**
     *
     */
    @Digits(integer = 15, fraction = 4)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "")
    private BigDecimal price;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    public String getNewMoneyCn() {
        return newMoneyCn;
    }

    public void setNewMoneyCn(String newMoneyCn) {
        this.newMoneyCn = newMoneyCn;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.xh
     *
     * @return the value of xf_menu_jl.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public XfMenuJlEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.xh
     *
     * @param xh the value for xf_menu_jl.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.key_no
     *
     * @return the value of xf_menu_jl.key_no
     */
    public String getKeyNo() {
        return keyNo;
    }

    /**
     */
    public XfMenuJlEntity withKeyNo(String keyNo) {
        this.setKeyNo(keyNo);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.key_no
     *
     * @param keyNo the value for xf_menu_jl.key_no
     */
    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.dev_serial
     *
     * @return the value of xf_menu_jl.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public XfMenuJlEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.dev_serial
     *
     * @param devSerial the value for xf_menu_jl.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.more_money
     *
     * @return the value of xf_menu_jl.more_money
     */
    public BigDecimal getMoreMoney() {
        return moreMoney;
    }

    /**
     */
    public XfMenuJlEntity withMoreMoney(BigDecimal moreMoney) {
        this.setMoreMoney(moreMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.more_money
     *
     * @param moreMoney the value for xf_menu_jl.more_money
     */
    public void setMoreMoney(BigDecimal moreMoney) {
        this.moreMoney = moreMoney;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.new_money
     *
     * @return the value of xf_menu_jl.new_money
     */
    public BigDecimal getNewMoney() {
        return newMoney;
    }

    /**
     */
    public XfMenuJlEntity withNewMoney(BigDecimal newMoney) {
        this.setNewMoney(newMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.new_money
     *
     * @param newMoney the value for xf_menu_jl.new_money
     */
    public void setNewMoney(BigDecimal newMoney) {
        this.newMoney = newMoney;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.money_count
     *
     * @return the value of xf_menu_jl.money_count
     */
    public Integer getMoneyCount() {
        return moneyCount;
    }

    /**
     */
    public XfMenuJlEntity withMoneyCount(Integer moneyCount) {
        this.setMoneyCount(moneyCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.money_count
     *
     * @param moneyCount the value for xf_menu_jl.money_count
     */
    public void setMoneyCount(Integer moneyCount) {
        this.moneyCount = moneyCount;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.user_serial
     *
     * @return the value of xf_menu_jl.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public XfMenuJlEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.user_serial
     *
     * @param userSerial the value for xf_menu_jl.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.user_no
     *
     * @return the value of xf_menu_jl.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public XfMenuJlEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.user_no
     *
     * @param userNo the value for xf_menu_jl.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.jl_sj
     *
     * @return the value of xf_menu_jl.jl_sj
     */
    public Date getJlSj() {
        return jlSj;
    }

    /**
     */
    public XfMenuJlEntity withJlSj(Date jlSj) {
        this.setJlSj(jlSj);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.jl_sj
     *
     * @param jlSj the value for xf_menu_jl.jl_sj
     */
    public void setJlSj(Date jlSj) {
        this.jlSj = jlSj;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.sj
     *
     * @return the value of xf_menu_jl.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public XfMenuJlEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.sj
     *
     * @param sj the value for xf_menu_jl.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.parent_bh
     *
     * @return the value of xf_menu_jl.parent_bh
     */
    public String getParentBh() {
        return parentBh;
    }

    /**
     */
    public XfMenuJlEntity withParentBh(String parentBh) {
        this.setParentBh(parentBh);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.parent_bh
     *
     * @param parentBh the value for xf_menu_jl.parent_bh
     */
    public void setParentBh(String parentBh) {
        this.parentBh = parentBh;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.menu_name
     *
     * @return the value of xf_menu_jl.menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     */
    public XfMenuJlEntity withMenuName(String menuName) {
        this.setMenuName(menuName);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.menu_name
     *
     * @param menuName the value for xf_menu_jl.menu_name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.card_hao
     *
     * @return the value of xf_menu_jl.card_hao
     */
    public String getCardHao() {
        return cardHao;
    }

    /**
     */
    public XfMenuJlEntity withCardHao(String cardHao) {
        this.setCardHao(cardHao);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.card_hao
     *
     * @param cardHao the value for xf_menu_jl.card_hao
     */
    public void setCardHao(String cardHao) {
        this.cardHao = cardHao;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.jl_serial
     *
     * @return the value of xf_menu_jl.jl_serial
     */
    public Integer getJlSerial() {
        return jlSerial;
    }

    /**
     */
    public XfMenuJlEntity withJlSerial(Integer jlSerial) {
        this.setJlSerial(jlSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.jl_serial
     *
     * @param jlSerial the value for xf_menu_jl.jl_serial
     */
    public void setJlSerial(Integer jlSerial) {
        this.jlSerial = jlSerial;
    }

    /**
     * This method returns the value of the database column xf_menu_jl.price
     *
     * @return the value of xf_menu_jl.price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     */
    public XfMenuJlEntity withPrice(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    /**
     * This method sets the value of the database column xf_menu_jl.price
     *
     * @param price the value for xf_menu_jl.price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}