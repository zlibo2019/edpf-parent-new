package com.weds.edhy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 会员与卡片关系
 * @Date 2019-10-11
 */
public class HyUserCardRelaEntity extends BaseEntity implements Serializable {
    /**
     * 会员档案编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "会员档案编号")
    private String userId;

    /**
     * 卡片编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡片编号")
    private String cardId;

    /**
     * 剩余天数/次数/课时
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "剩余天数/次数/课时")
    private Integer cardNum;

    /**
     * 开卡时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-11 15:36:42", value = "开卡时间")
    private Date startDate;

    /**
     * 到期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-11 15:36:42", value = "到期时间")
    private Date endDate;

    /**
     * 卡片状态
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡片状态")
    private String cardState;

    /**
     * 累计实收
     */
    @Digits(integer = 8, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "累计实收")
    private BigDecimal receiveSum;

    /**
     * 尾款金额
     */
    @Digits(integer = 8, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "尾款金额")
    private BigDecimal tailMoney;

    /**
     * 备注
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     * 创建人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建人员")
    private String ctUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     * 修改人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改人员")
    private String ltUser;

    /**
     * 预留字段1
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

    /**
     * 预留字段4
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol4;

    /**
     * 预留字段5
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol5;

    /**
     * 预留字段6
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol6;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.user_id
     *
     * @return the value of ed_hy_user_card_rela.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public HyUserCardRelaEntity withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.user_id
     *
     * @param userId the value for ed_hy_user_card_rela.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.card_id
     *
     * @return the value of ed_hy_user_card_rela.card_id
     */
    public String getCardId() {
        return cardId;
    }

    /**
     */
    public HyUserCardRelaEntity withCardId(String cardId) {
        this.setCardId(cardId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.card_id
     *
     * @param cardId the value for ed_hy_user_card_rela.card_id
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.card_num
     *
     * @return the value of ed_hy_user_card_rela.card_num
     */
    public Integer getCardNum() {
        return cardNum;
    }

    /**
     */
    public HyUserCardRelaEntity withCardNum(Integer cardNum) {
        this.setCardNum(cardNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.card_num
     *
     * @param cardNum the value for ed_hy_user_card_rela.card_num
     */
    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.start_date
     *
     * @return the value of ed_hy_user_card_rela.start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     */
    public HyUserCardRelaEntity withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.start_date
     *
     * @param startDate the value for ed_hy_user_card_rela.start_date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.end_date
     *
     * @return the value of ed_hy_user_card_rela.end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     */
    public HyUserCardRelaEntity withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.end_date
     *
     * @param endDate the value for ed_hy_user_card_rela.end_date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.card_state
     *
     * @return the value of ed_hy_user_card_rela.card_state
     */
    public String getCardState() {
        return cardState;
    }

    /**
     */
    public HyUserCardRelaEntity withCardState(String cardState) {
        this.setCardState(cardState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.card_state
     *
     * @param cardState the value for ed_hy_user_card_rela.card_state
     */
    public void setCardState(String cardState) {
        this.cardState = cardState;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.receive_sum
     *
     * @return the value of ed_hy_user_card_rela.receive_sum
     */
    public BigDecimal getReceiveSum() {
        return receiveSum;
    }

    /**
     */
    public HyUserCardRelaEntity withReceiveSum(BigDecimal receiveSum) {
        this.setReceiveSum(receiveSum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.receive_sum
     *
     * @param receiveSum the value for ed_hy_user_card_rela.receive_sum
     */
    public void setReceiveSum(BigDecimal receiveSum) {
        this.receiveSum = receiveSum;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.tail_money
     *
     * @return the value of ed_hy_user_card_rela.tail_money
     */
    public BigDecimal getTailMoney() {
        return tailMoney;
    }

    /**
     */
    public HyUserCardRelaEntity withTailMoney(BigDecimal tailMoney) {
        this.setTailMoney(tailMoney);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.tail_money
     *
     * @param tailMoney the value for ed_hy_user_card_rela.tail_money
     */
    public void setTailMoney(BigDecimal tailMoney) {
        this.tailMoney = tailMoney;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.remark
     *
     * @return the value of ed_hy_user_card_rela.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public HyUserCardRelaEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.remark
     *
     * @param remark the value for ed_hy_user_card_rela.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.ct_date
     *
     * @return the value of ed_hy_user_card_rela.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public HyUserCardRelaEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.ct_date
     *
     * @param ctDate the value for ed_hy_user_card_rela.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.ct_user
     *
     * @return the value of ed_hy_user_card_rela.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public HyUserCardRelaEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.ct_user
     *
     * @param ctUser the value for ed_hy_user_card_rela.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.lt_date
     *
     * @return the value of ed_hy_user_card_rela.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public HyUserCardRelaEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.lt_date
     *
     * @param ltDate the value for ed_hy_user_card_rela.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.lt_user
     *
     * @return the value of ed_hy_user_card_rela.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public HyUserCardRelaEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.lt_user
     *
     * @param ltUser the value for ed_hy_user_card_rela.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col1
     *
     * @return the value of ed_hy_user_card_rela.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col1
     *
     * @param spareCol1 the value for ed_hy_user_card_rela.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col2
     *
     * @return the value of ed_hy_user_card_rela.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col2
     *
     * @param spareCol2 the value for ed_hy_user_card_rela.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col3
     *
     * @return the value of ed_hy_user_card_rela.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col3
     *
     * @param spareCol3 the value for ed_hy_user_card_rela.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col4
     *
     * @return the value of ed_hy_user_card_rela.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col4
     *
     * @param spareCol4 the value for ed_hy_user_card_rela.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col5
     *
     * @return the value of ed_hy_user_card_rela.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col5
     *
     * @param spareCol5 the value for ed_hy_user_card_rela.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_hy_user_card_rela.spare_col6
     *
     * @return the value of ed_hy_user_card_rela.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public HyUserCardRelaEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_card_rela.spare_col6
     *
     * @param spareCol6 the value for ed_hy_user_card_rela.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}