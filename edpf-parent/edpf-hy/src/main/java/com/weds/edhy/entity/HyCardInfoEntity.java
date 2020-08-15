package com.weds.edhy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 卡片信息
 * @Date 2019-10-11
 */
public class HyCardInfoEntity extends ExportRptEntity implements Serializable {
    /**
     * 卡片编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡片编号")
    private String cardId;

    /**
     * 卡片名称#1#1##9#01016
     */
    @Size(max = 200)
    @Dict("01016")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡片名称#1#1##9#01016")
    private String cardName;

    /**
     * 卡片类型#1#1##0#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡片类型#1#1##0#")
    private String cardType;

    /**
     * 天数/次数/课时#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "天数/次数/课时#1#1##0#")
    private Integer cardNum;

    /**
     * 期限类型#1#1##9#05001
     */
    @Size(max = 10)
    @Dict("05001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "期限类型#1#1##9#05001")
    private String termType;

    /**
     * 到期时间#1#1##6#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "到期时间#1#1##6#")
    private String endDate;

    /**
     * 固定天数#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "固定天数#1#1##0#")
    private Integer fixDays;

    /**
     * 请假天数#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "请假天数#1#1##0#")
    private Integer leaveDays;

    /**
     * 销售金额#1#1##0#
     */
    @Digits(integer = 8, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "销售金额#1#1##0#")
    private BigDecimal sellPrice;

    /**
     * 单次金额#1#1##0#
     */
    @Digits(integer = 8, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "单次金额#1#1##0#")
    private BigDecimal oncePrice;

    /**
     * 是否最低金额#1#1##9#01001
     */
    @Size(max = 10)
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否最低金额#1#1##9#01001")
    private String lowFlag;

    /**
     * 是否通卡#1#1##9#01001
     */
    @Size(max = 10)
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否通卡#1#1##9#01001")
    private String allFlag;

    /**
     * 备注##1##1#
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注##1##1#")
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
     * This method returns the value of the database column ed_hy_card_info.card_id
     *
     * @return the value of ed_hy_card_info.card_id
     */
    public String getCardId() {
        return cardId;
    }

    /**
     */
    public HyCardInfoEntity withCardId(String cardId) {
        this.setCardId(cardId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.card_id
     *
     * @param cardId the value for ed_hy_card_info.card_id
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.card_name
     *
     * @return the value of ed_hy_card_info.card_name
     */
    public String getCardName() {
        return cardName;
    }

    /**
     */
    public HyCardInfoEntity withCardName(String cardName) {
        this.setCardName(cardName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.card_name
     *
     * @param cardName the value for ed_hy_card_info.card_name
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.card_type
     *
     * @return the value of ed_hy_card_info.card_type
     */
    public String getCardType() {
        return cardType;
    }

    /**
     */
    public HyCardInfoEntity withCardType(String cardType) {
        this.setCardType(cardType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.card_type
     *
     * @param cardType the value for ed_hy_card_info.card_type
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.card_num
     *
     * @return the value of ed_hy_card_info.card_num
     */
    public Integer getCardNum() {
        return cardNum;
    }

    /**
     */
    public HyCardInfoEntity withCardNum(Integer cardNum) {
        this.setCardNum(cardNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.card_num
     *
     * @param cardNum the value for ed_hy_card_info.card_num
     */
    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.term_type
     *
     * @return the value of ed_hy_card_info.term_type
     */
    public String getTermType() {
        return termType;
    }

    /**
     */
    public HyCardInfoEntity withTermType(String termType) {
        this.setTermType(termType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.term_type
     *
     * @param termType the value for ed_hy_card_info.term_type
     */
    public void setTermType(String termType) {
        this.termType = termType;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.end_date
     *
     * @return the value of ed_hy_card_info.end_date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     */
    public HyCardInfoEntity withEndDate(String endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.end_date
     *
     * @param endDate the value for ed_hy_card_info.end_date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.fix_days
     *
     * @return the value of ed_hy_card_info.fix_days
     */
    public Integer getFixDays() {
        return fixDays;
    }

    /**
     */
    public HyCardInfoEntity withFixDays(Integer fixDays) {
        this.setFixDays(fixDays);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.fix_days
     *
     * @param fixDays the value for ed_hy_card_info.fix_days
     */
    public void setFixDays(Integer fixDays) {
        this.fixDays = fixDays;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.leave_days
     *
     * @return the value of ed_hy_card_info.leave_days
     */
    public Integer getLeaveDays() {
        return leaveDays;
    }

    /**
     */
    public HyCardInfoEntity withLeaveDays(Integer leaveDays) {
        this.setLeaveDays(leaveDays);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.leave_days
     *
     * @param leaveDays the value for ed_hy_card_info.leave_days
     */
    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.sell_price
     *
     * @return the value of ed_hy_card_info.sell_price
     */
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    /**
     */
    public HyCardInfoEntity withSellPrice(BigDecimal sellPrice) {
        this.setSellPrice(sellPrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.sell_price
     *
     * @param sellPrice the value for ed_hy_card_info.sell_price
     */
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.once_price
     *
     * @return the value of ed_hy_card_info.once_price
     */
    public BigDecimal getOncePrice() {
        return oncePrice;
    }

    /**
     */
    public HyCardInfoEntity withOncePrice(BigDecimal oncePrice) {
        this.setOncePrice(oncePrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.once_price
     *
     * @param oncePrice the value for ed_hy_card_info.once_price
     */
    public void setOncePrice(BigDecimal oncePrice) {
        this.oncePrice = oncePrice;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.low_flag
     *
     * @return the value of ed_hy_card_info.low_flag
     */
    public String getLowFlag() {
        return lowFlag;
    }

    /**
     */
    public HyCardInfoEntity withLowFlag(String lowFlag) {
        this.setLowFlag(lowFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.low_flag
     *
     * @param lowFlag the value for ed_hy_card_info.low_flag
     */
    public void setLowFlag(String lowFlag) {
        this.lowFlag = lowFlag;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.all_flag
     *
     * @return the value of ed_hy_card_info.all_flag
     */
    public String getAllFlag() {
        return allFlag;
    }

    /**
     */
    public HyCardInfoEntity withAllFlag(String allFlag) {
        this.setAllFlag(allFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.all_flag
     *
     * @param allFlag the value for ed_hy_card_info.all_flag
     */
    public void setAllFlag(String allFlag) {
        this.allFlag = allFlag;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.remark
     *
     * @return the value of ed_hy_card_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public HyCardInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.remark
     *
     * @param remark the value for ed_hy_card_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.ct_date
     *
     * @return the value of ed_hy_card_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public HyCardInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.ct_date
     *
     * @param ctDate the value for ed_hy_card_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.ct_user
     *
     * @return the value of ed_hy_card_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public HyCardInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.ct_user
     *
     * @param ctUser the value for ed_hy_card_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.lt_date
     *
     * @return the value of ed_hy_card_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public HyCardInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.lt_date
     *
     * @param ltDate the value for ed_hy_card_info.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.lt_user
     *
     * @return the value of ed_hy_card_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public HyCardInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.lt_user
     *
     * @param ltUser the value for ed_hy_card_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col1
     *
     * @return the value of ed_hy_card_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col1
     *
     * @param spareCol1 the value for ed_hy_card_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col2
     *
     * @return the value of ed_hy_card_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col2
     *
     * @param spareCol2 the value for ed_hy_card_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col3
     *
     * @return the value of ed_hy_card_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col3
     *
     * @param spareCol3 the value for ed_hy_card_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col4
     *
     * @return the value of ed_hy_card_info.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col4
     *
     * @param spareCol4 the value for ed_hy_card_info.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col5
     *
     * @return the value of ed_hy_card_info.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col5
     *
     * @param spareCol5 the value for ed_hy_card_info.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_hy_card_info.spare_col6
     *
     * @return the value of ed_hy_card_info.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public HyCardInfoEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_card_info.spare_col6
     *
     * @param spareCol6 the value for ed_hy_card_info.spare_col6
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