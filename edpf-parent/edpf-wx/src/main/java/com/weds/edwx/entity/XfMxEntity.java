package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XfMxEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String jlBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String userCard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String cardSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal oldMoney;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String newMoney;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal newSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal newAdd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal saveMoney;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-21 14:19:16", value = "")
    private Date jlSj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-21 14:19:16", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer moneyCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer subCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer addCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal newDel;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer delCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer cardLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal newZero;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer delZero;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal newEdit;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer delEdit;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String timeNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer newEach;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer eachCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devTimeNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-21 14:19:16", value = "")
    private Date rq;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal moreMoney;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal rateMoney;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer discountRate;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal eachUnit;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer mould;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer type;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long acdepSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer corCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal corMoney;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal corSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal corAdd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal delCash;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal delSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer delEach;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal oldAdd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal oldSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal saveAdd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal saveSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal xfAdd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal xfSub;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "充值和补贴的方式 0 电脑端；1 手机端；")
    private Integer addType;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "交易类型")
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column xf_mx.xh
     *
     * @return the value of xf_mx.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public XfMxEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.xh
     *
     * @param xh the value for xf_mx.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column xf_mx.jl_bh
     *
     * @return the value of xf_mx.jl_bh
     */
    public String getJlBh() {
        return jlBh;
    }

    /**
     */
    public XfMxEntity withJlBh(String jlBh) {
        this.setJlBh(jlBh);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.jl_bh
     *
     * @param jlBh the value for xf_mx.jl_bh
     */
    public void setJlBh(String jlBh) {
        this.jlBh = jlBh;
    }

    /**
     * This method returns the value of the database column xf_mx.dev_serial
     *
     * @return the value of xf_mx.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public XfMxEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.dev_serial
     *
     * @param devSerial the value for xf_mx.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column xf_mx.user_serial
     *
     * @return the value of xf_mx.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public XfMxEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.user_serial
     *
     * @param userSerial the value for xf_mx.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column xf_mx.user_card
     *
     * @return the value of xf_mx.user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     */
    public XfMxEntity withUserCard(String userCard) {
        this.setUserCard(userCard);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.user_card
     *
     * @param userCard the value for xf_mx.user_card
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    /**
     * This method returns the value of the database column xf_mx.card_serial
     *
     * @return the value of xf_mx.card_serial
     */
    public String getCardSerial() {
        return cardSerial;
    }

    /**
     */
    public XfMxEntity withCardSerial(String cardSerial) {
        this.setCardSerial(cardSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.card_serial
     *
     * @param cardSerial the value for xf_mx.card_serial
     */
    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    /**
     * This method returns the value of the database column xf_mx.old_money
     *
     * @return the value of xf_mx.old_money
     */
    public BigDecimal getOldMoney() {
        return oldMoney;
    }

    /**
     */
    public XfMxEntity withOldMoney(BigDecimal oldMoney) {
        this.setOldMoney(oldMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.old_money
     *
     * @param oldMoney the value for xf_mx.old_money
     */
    public void setOldMoney(BigDecimal oldMoney) {
        this.oldMoney = oldMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.new_money
     *
     * @return the value of xf_mx.new_money
     */
    public String getNewMoney() {
        return newMoney;
    }

    /**
     */
    public XfMxEntity withNewMoney(String newMoney) {
        this.setNewMoney(newMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_money
     *
     * @param newMoney the value for xf_mx.new_money
     */
    public void setNewMoney(String newMoney) {
        this.newMoney = newMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.new_sub
     *
     * @return the value of xf_mx.new_sub
     */
    public BigDecimal getNewSub() {
        return newSub;
    }

    /**
     */
    public XfMxEntity withNewSub(BigDecimal newSub) {
        this.setNewSub(newSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_sub
     *
     * @param newSub the value for xf_mx.new_sub
     */
    public void setNewSub(BigDecimal newSub) {
        this.newSub = newSub;
    }

    /**
     * This method returns the value of the database column xf_mx.new_add
     *
     * @return the value of xf_mx.new_add
     */
    public BigDecimal getNewAdd() {
        return newAdd;
    }

    /**
     */
    public XfMxEntity withNewAdd(BigDecimal newAdd) {
        this.setNewAdd(newAdd);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_add
     *
     * @param newAdd the value for xf_mx.new_add
     */
    public void setNewAdd(BigDecimal newAdd) {
        this.newAdd = newAdd;
    }

    /**
     * This method returns the value of the database column xf_mx.save_money
     *
     * @return the value of xf_mx.save_money
     */
    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    /**
     */
    public XfMxEntity withSaveMoney(BigDecimal saveMoney) {
        this.setSaveMoney(saveMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.save_money
     *
     * @param saveMoney the value for xf_mx.save_money
     */
    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.jl_sj
     *
     * @return the value of xf_mx.jl_sj
     */
    public Date getJlSj() {
        return jlSj;
    }

    /**
     */
    public XfMxEntity withJlSj(Date jlSj) {
        this.setJlSj(jlSj);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.jl_sj
     *
     * @param jlSj the value for xf_mx.jl_sj
     */
    public void setJlSj(Date jlSj) {
        this.jlSj = jlSj;
    }

    /**
     * This method returns the value of the database column xf_mx.sj
     *
     * @return the value of xf_mx.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public XfMxEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.sj
     *
     * @param sj the value for xf_mx.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column xf_mx.money_count
     *
     * @return the value of xf_mx.money_count
     */
    public Integer getMoneyCount() {
        return moneyCount;
    }

    /**
     */
    public XfMxEntity withMoneyCount(Integer moneyCount) {
        this.setMoneyCount(moneyCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.money_count
     *
     * @param moneyCount the value for xf_mx.money_count
     */
    public void setMoneyCount(Integer moneyCount) {
        this.moneyCount = moneyCount;
    }

    /**
     * This method returns the value of the database column xf_mx.sub_count
     *
     * @return the value of xf_mx.sub_count
     */
    public Integer getSubCount() {
        return subCount;
    }

    /**
     */
    public XfMxEntity withSubCount(Integer subCount) {
        this.setSubCount(subCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.sub_count
     *
     * @param subCount the value for xf_mx.sub_count
     */
    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    /**
     * This method returns the value of the database column xf_mx.add_count
     *
     * @return the value of xf_mx.add_count
     */
    public Integer getAddCount() {
        return addCount;
    }

    /**
     */
    public XfMxEntity withAddCount(Integer addCount) {
        this.setAddCount(addCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.add_count
     *
     * @param addCount the value for xf_mx.add_count
     */
    public void setAddCount(Integer addCount) {
        this.addCount = addCount;
    }

    /**
     * This method returns the value of the database column xf_mx.new_del
     *
     * @return the value of xf_mx.new_del
     */
    public BigDecimal getNewDel() {
        return newDel;
    }

    /**
     */
    public XfMxEntity withNewDel(BigDecimal newDel) {
        this.setNewDel(newDel);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_del
     *
     * @param newDel the value for xf_mx.new_del
     */
    public void setNewDel(BigDecimal newDel) {
        this.newDel = newDel;
    }

    /**
     * This method returns the value of the database column xf_mx.del_count
     *
     * @return the value of xf_mx.del_count
     */
    public Integer getDelCount() {
        return delCount;
    }

    /**
     */
    public XfMxEntity withDelCount(Integer delCount) {
        this.setDelCount(delCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_count
     *
     * @param delCount the value for xf_mx.del_count
     */
    public void setDelCount(Integer delCount) {
        this.delCount = delCount;
    }

    /**
     * This method returns the value of the database column xf_mx.jl_count
     *
     * @return the value of xf_mx.jl_count
     */
    public Integer getJlCount() {
        return jlCount;
    }

    /**
     */
    public XfMxEntity withJlCount(Integer jlCount) {
        this.setJlCount(jlCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.jl_count
     *
     * @param jlCount the value for xf_mx.jl_count
     */
    public void setJlCount(Integer jlCount) {
        this.jlCount = jlCount;
    }

    /**
     * This method returns the value of the database column xf_mx.lx
     *
     * @return the value of xf_mx.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public XfMxEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.lx
     *
     * @param lx the value for xf_mx.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column xf_mx.gly_no
     *
     * @return the value of xf_mx.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public XfMxEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.gly_no
     *
     * @param glyNo the value for xf_mx.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column xf_mx.card_lx
     *
     * @return the value of xf_mx.card_lx
     */
    public Integer getCardLx() {
        return cardLx;
    }

    /**
     */
    public XfMxEntity withCardLx(Integer cardLx) {
        this.setCardLx(cardLx);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.card_lx
     *
     * @param cardLx the value for xf_mx.card_lx
     */
    public void setCardLx(Integer cardLx) {
        this.cardLx = cardLx;
    }

    /**
     * This method returns the value of the database column xf_mx.new_zero
     *
     * @return the value of xf_mx.new_zero
     */
    public BigDecimal getNewZero() {
        return newZero;
    }

    /**
     */
    public XfMxEntity withNewZero(BigDecimal newZero) {
        this.setNewZero(newZero);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_zero
     *
     * @param newZero the value for xf_mx.new_zero
     */
    public void setNewZero(BigDecimal newZero) {
        this.newZero = newZero;
    }

    /**
     * This method returns the value of the database column xf_mx.del_zero
     *
     * @return the value of xf_mx.del_zero
     */
    public Integer getDelZero() {
        return delZero;
    }

    /**
     */
    public XfMxEntity withDelZero(Integer delZero) {
        this.setDelZero(delZero);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_zero
     *
     * @param delZero the value for xf_mx.del_zero
     */
    public void setDelZero(Integer delZero) {
        this.delZero = delZero;
    }

    /**
     * This method returns the value of the database column xf_mx.new_edit
     *
     * @return the value of xf_mx.new_edit
     */
    public BigDecimal getNewEdit() {
        return newEdit;
    }

    /**
     */
    public XfMxEntity withNewEdit(BigDecimal newEdit) {
        this.setNewEdit(newEdit);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_edit
     *
     * @param newEdit the value for xf_mx.new_edit
     */
    public void setNewEdit(BigDecimal newEdit) {
        this.newEdit = newEdit;
    }

    /**
     * This method returns the value of the database column xf_mx.del_edit
     *
     * @return the value of xf_mx.del_edit
     */
    public Integer getDelEdit() {
        return delEdit;
    }

    /**
     */
    public XfMxEntity withDelEdit(Integer delEdit) {
        this.setDelEdit(delEdit);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_edit
     *
     * @param delEdit the value for xf_mx.del_edit
     */
    public void setDelEdit(Integer delEdit) {
        this.delEdit = delEdit;
    }

    /**
     * This method returns the value of the database column xf_mx.time_no
     *
     * @return the value of xf_mx.time_no
     */
    public String getTimeNo() {
        return timeNo;
    }

    /**
     */
    public XfMxEntity withTimeNo(String timeNo) {
        this.setTimeNo(timeNo);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.time_no
     *
     * @param timeNo the value for xf_mx.time_no
     */
    public void setTimeNo(String timeNo) {
        this.timeNo = timeNo;
    }

    /**
     * This method returns the value of the database column xf_mx.new_each
     *
     * @return the value of xf_mx.new_each
     */
    public Integer getNewEach() {
        return newEach;
    }

    /**
     */
    public XfMxEntity withNewEach(Integer newEach) {
        this.setNewEach(newEach);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.new_each
     *
     * @param newEach the value for xf_mx.new_each
     */
    public void setNewEach(Integer newEach) {
        this.newEach = newEach;
    }

    /**
     * This method returns the value of the database column xf_mx.each_count
     *
     * @return the value of xf_mx.each_count
     */
    public Integer getEachCount() {
        return eachCount;
    }

    /**
     */
    public XfMxEntity withEachCount(Integer eachCount) {
        this.setEachCount(eachCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.each_count
     *
     * @param eachCount the value for xf_mx.each_count
     */
    public void setEachCount(Integer eachCount) {
        this.eachCount = eachCount;
    }

    /**
     * This method returns the value of the database column xf_mx.dev_time_no
     *
     * @return the value of xf_mx.dev_time_no
     */
    public String getDevTimeNo() {
        return devTimeNo;
    }

    /**
     */
    public XfMxEntity withDevTimeNo(String devTimeNo) {
        this.setDevTimeNo(devTimeNo);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.dev_time_no
     *
     * @param devTimeNo the value for xf_mx.dev_time_no
     */
    public void setDevTimeNo(String devTimeNo) {
        this.devTimeNo = devTimeNo;
    }

    /**
     * This method returns the value of the database column xf_mx.rq
     *
     * @return the value of xf_mx.rq
     */
    public Date getRq() {
        return rq;
    }

    /**
     */
    public XfMxEntity withRq(Date rq) {
        this.setRq(rq);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.rq
     *
     * @param rq the value for xf_mx.rq
     */
    public void setRq(Date rq) {
        this.rq = rq;
    }

    /**
     * This method returns the value of the database column xf_mx.more_money
     *
     * @return the value of xf_mx.more_money
     */
    public BigDecimal getMoreMoney() {
        return moreMoney;
    }

    /**
     */
    public XfMxEntity withMoreMoney(BigDecimal moreMoney) {
        this.setMoreMoney(moreMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.more_money
     *
     * @param moreMoney the value for xf_mx.more_money
     */
    public void setMoreMoney(BigDecimal moreMoney) {
        this.moreMoney = moreMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.rate_money
     *
     * @return the value of xf_mx.rate_money
     */
    public BigDecimal getRateMoney() {
        return rateMoney;
    }

    /**
     */
    public XfMxEntity withRateMoney(BigDecimal rateMoney) {
        this.setRateMoney(rateMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.rate_money
     *
     * @param rateMoney the value for xf_mx.rate_money
     */
    public void setRateMoney(BigDecimal rateMoney) {
        this.rateMoney = rateMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.discount_rate
     *
     * @return the value of xf_mx.discount_rate
     */
    public Integer getDiscountRate() {
        return discountRate;
    }

    /**
     */
    public XfMxEntity withDiscountRate(Integer discountRate) {
        this.setDiscountRate(discountRate);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.discount_rate
     *
     * @param discountRate the value for xf_mx.discount_rate
     */
    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * This method returns the value of the database column xf_mx.each_unit
     *
     * @return the value of xf_mx.each_unit
     */
    public BigDecimal getEachUnit() {
        return eachUnit;
    }

    /**
     */
    public XfMxEntity withEachUnit(BigDecimal eachUnit) {
        this.setEachUnit(eachUnit);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.each_unit
     *
     * @param eachUnit the value for xf_mx.each_unit
     */
    public void setEachUnit(BigDecimal eachUnit) {
        this.eachUnit = eachUnit;
    }

    /**
     * This method returns the value of the database column xf_mx.mould
     *
     * @return the value of xf_mx.mould
     */
    public Integer getMould() {
        return mould;
    }

    /**
     */
    public XfMxEntity withMould(Integer mould) {
        this.setMould(mould);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.mould
     *
     * @param mould the value for xf_mx.mould
     */
    public void setMould(Integer mould) {
        this.mould = mould;
    }

    /**
     * This method returns the value of the database column xf_mx.dep_serial
     *
     * @return the value of xf_mx.dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public XfMxEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.dep_serial
     *
     * @param depSerial the value for xf_mx.dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column xf_mx.type
     *
     * @return the value of xf_mx.type
     */
    public Integer getType() {
        return type;
    }

    /**
     */
    public XfMxEntity withType(Integer type) {
        this.setType(type);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.type
     *
     * @param type the value for xf_mx.type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column xf_mx.acdep_serial
     *
     * @return the value of xf_mx.acdep_serial
     */
    public Long getAcdepSerial() {
        return acdepSerial;
    }

    /**
     */
    public XfMxEntity withAcdepSerial(Long acdepSerial) {
        this.setAcdepSerial(acdepSerial);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.acdep_serial
     *
     * @param acdepSerial the value for xf_mx.acdep_serial
     */
    public void setAcdepSerial(Long acdepSerial) {
        this.acdepSerial = acdepSerial;
    }

    /**
     * This method returns the value of the database column xf_mx.cor_count
     *
     * @return the value of xf_mx.cor_count
     */
    public Integer getCorCount() {
        return corCount;
    }

    /**
     */
    public XfMxEntity withCorCount(Integer corCount) {
        this.setCorCount(corCount);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.cor_count
     *
     * @param corCount the value for xf_mx.cor_count
     */
    public void setCorCount(Integer corCount) {
        this.corCount = corCount;
    }

    /**
     * This method returns the value of the database column xf_mx.cor_money
     *
     * @return the value of xf_mx.cor_money
     */
    public BigDecimal getCorMoney() {
        return corMoney;
    }

    /**
     */
    public XfMxEntity withCorMoney(BigDecimal corMoney) {
        this.setCorMoney(corMoney);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.cor_money
     *
     * @param corMoney the value for xf_mx.cor_money
     */
    public void setCorMoney(BigDecimal corMoney) {
        this.corMoney = corMoney;
    }

    /**
     * This method returns the value of the database column xf_mx.cor_sub
     *
     * @return the value of xf_mx.cor_sub
     */
    public BigDecimal getCorSub() {
        return corSub;
    }

    /**
     */
    public XfMxEntity withCorSub(BigDecimal corSub) {
        this.setCorSub(corSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.cor_sub
     *
     * @param corSub the value for xf_mx.cor_sub
     */
    public void setCorSub(BigDecimal corSub) {
        this.corSub = corSub;
    }

    /**
     * This method returns the value of the database column xf_mx.cor_add
     *
     * @return the value of xf_mx.cor_add
     */
    public BigDecimal getCorAdd() {
        return corAdd;
    }

    /**
     */
    public XfMxEntity withCorAdd(BigDecimal corAdd) {
        this.setCorAdd(corAdd);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.cor_add
     *
     * @param corAdd the value for xf_mx.cor_add
     */
    public void setCorAdd(BigDecimal corAdd) {
        this.corAdd = corAdd;
    }

    /**
     * This method returns the value of the database column xf_mx.del_cash
     *
     * @return the value of xf_mx.del_cash
     */
    public BigDecimal getDelCash() {
        return delCash;
    }

    /**
     */
    public XfMxEntity withDelCash(BigDecimal delCash) {
        this.setDelCash(delCash);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_cash
     *
     * @param delCash the value for xf_mx.del_cash
     */
    public void setDelCash(BigDecimal delCash) {
        this.delCash = delCash;
    }

    /**
     * This method returns the value of the database column xf_mx.del_sub
     *
     * @return the value of xf_mx.del_sub
     */
    public BigDecimal getDelSub() {
        return delSub;
    }

    /**
     */
    public XfMxEntity withDelSub(BigDecimal delSub) {
        this.setDelSub(delSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_sub
     *
     * @param delSub the value for xf_mx.del_sub
     */
    public void setDelSub(BigDecimal delSub) {
        this.delSub = delSub;
    }

    /**
     * This method returns the value of the database column xf_mx.del_each
     *
     * @return the value of xf_mx.del_each
     */
    public Integer getDelEach() {
        return delEach;
    }

    /**
     */
    public XfMxEntity withDelEach(Integer delEach) {
        this.setDelEach(delEach);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.del_each
     *
     * @param delEach the value for xf_mx.del_each
     */
    public void setDelEach(Integer delEach) {
        this.delEach = delEach;
    }

    /**
     * This method returns the value of the database column xf_mx.old_add
     *
     * @return the value of xf_mx.old_add
     */
    public BigDecimal getOldAdd() {
        return oldAdd;
    }

    /**
     */
    public XfMxEntity withOldAdd(BigDecimal oldAdd) {
        this.setOldAdd(oldAdd);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.old_add
     *
     * @param oldAdd the value for xf_mx.old_add
     */
    public void setOldAdd(BigDecimal oldAdd) {
        this.oldAdd = oldAdd;
    }

    /**
     * This method returns the value of the database column xf_mx.old_sub
     *
     * @return the value of xf_mx.old_sub
     */
    public BigDecimal getOldSub() {
        return oldSub;
    }

    /**
     */
    public XfMxEntity withOldSub(BigDecimal oldSub) {
        this.setOldSub(oldSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.old_sub
     *
     * @param oldSub the value for xf_mx.old_sub
     */
    public void setOldSub(BigDecimal oldSub) {
        this.oldSub = oldSub;
    }

    /**
     * This method returns the value of the database column xf_mx.save_add
     *
     * @return the value of xf_mx.save_add
     */
    public BigDecimal getSaveAdd() {
        return saveAdd;
    }

    /**
     */
    public XfMxEntity withSaveAdd(BigDecimal saveAdd) {
        this.setSaveAdd(saveAdd);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.save_add
     *
     * @param saveAdd the value for xf_mx.save_add
     */
    public void setSaveAdd(BigDecimal saveAdd) {
        this.saveAdd = saveAdd;
    }

    /**
     * This method returns the value of the database column xf_mx.save_sub
     *
     * @return the value of xf_mx.save_sub
     */
    public BigDecimal getSaveSub() {
        return saveSub;
    }

    /**
     */
    public XfMxEntity withSaveSub(BigDecimal saveSub) {
        this.setSaveSub(saveSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.save_sub
     *
     * @param saveSub the value for xf_mx.save_sub
     */
    public void setSaveSub(BigDecimal saveSub) {
        this.saveSub = saveSub;
    }

    /**
     * This method returns the value of the database column xf_mx.xf_add
     *
     * @return the value of xf_mx.xf_add
     */
    public BigDecimal getXfAdd() {
        return xfAdd;
    }

    /**
     */
    public XfMxEntity withXfAdd(BigDecimal xfAdd) {
        this.setXfAdd(xfAdd);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.xf_add
     *
     * @param xfAdd the value for xf_mx.xf_add
     */
    public void setXfAdd(BigDecimal xfAdd) {
        this.xfAdd = xfAdd;
    }

    /**
     * This method returns the value of the database column xf_mx.xf_sub
     *
     * @return the value of xf_mx.xf_sub
     */
    public BigDecimal getXfSub() {
        return xfSub;
    }

    /**
     */
    public XfMxEntity withXfSub(BigDecimal xfSub) {
        this.setXfSub(xfSub);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.xf_sub
     *
     * @param xfSub the value for xf_mx.xf_sub
     */
    public void setXfSub(BigDecimal xfSub) {
        this.xfSub = xfSub;
    }

    /**
     * This method returns the value of the database column xf_mx.add_type
     *
     * @return the value of xf_mx.add_type
     */
    public Integer getAddType() {
        return addType;
    }

    /**
     */
    public XfMxEntity withAddType(Integer addType) {
        this.setAddType(addType);
        return this;
    }

    /**
     * This method sets the value of the database column xf_mx.add_type
     *
     * @param addType the value for xf_mx.add_type
     */
    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}