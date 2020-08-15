package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 商户定义
 * @Date 2019-04-12
 */
public class EdDineMerchantEntity extends BaseEntity implements Serializable {
    /**
     * 商户编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "商户编号")
    private String merchantId;

    /**
     * 商户名称
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "商户名称")
    private String merchantName;

    /**
     * 用户编号
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号")
    private String userSerial;

    /**
     * 用户姓名
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户姓名")
    private String userName;

    /**
     * 联系方式
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "联系方式")
    private String userTel;

    /**
     * 身份证号
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "身份证号")
    private String userCardId;

    /**
     * 性别
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "性别")
    private String userSex;

    /**
     * 商户场所
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "商户场所")
    private String placeId;

    /**
     * 商户开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-04-12 14:39:31", value = "商户开始日期")
    private Date startDate;

    /**
     * 商户结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-04-12 14:39:31", value = "商户结束日期")
    private Date endDate;

    /**
     * 是否启用
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用")
    private String useFlag;

    /**
     * 备注
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

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
     * 创建用户
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建用户")
    private String ctUser;

    /**
     * 创建时间
     */
    @JsonIgnore
    @Size(max = 23)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     * 修改用户
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改用户")
    private String ltUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @Size(max = 23)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dine_merchant.merchant_id
     *
     * @return the value of ed_dine_merchant.merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     */
    public EdDineMerchantEntity withMerchantId(String merchantId) {
        this.setMerchantId(merchantId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.merchant_id
     *
     * @param merchantId the value for ed_dine_merchant.merchant_id
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.merchant_name
     *
     * @return the value of ed_dine_merchant.merchant_name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     */
    public EdDineMerchantEntity withMerchantName(String merchantName) {
        this.setMerchantName(merchantName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.merchant_name
     *
     * @param merchantName the value for ed_dine_merchant.merchant_name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.user_serial
     *
     * @return the value of ed_dine_merchant.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public EdDineMerchantEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.user_serial
     *
     * @param userSerial the value for ed_dine_merchant.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.user_name
     *
     * @return the value of ed_dine_merchant.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public EdDineMerchantEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.user_name
     *
     * @param userName the value for ed_dine_merchant.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.user_tel
     *
     * @return the value of ed_dine_merchant.user_tel
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     */
    public EdDineMerchantEntity withUserTel(String userTel) {
        this.setUserTel(userTel);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.user_tel
     *
     * @param userTel the value for ed_dine_merchant.user_tel
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.user_card_id
     *
     * @return the value of ed_dine_merchant.user_card_id
     */
    public String getUserCardId() {
        return userCardId;
    }

    /**
     */
    public EdDineMerchantEntity withUserCardId(String userCardId) {
        this.setUserCardId(userCardId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.user_card_id
     *
     * @param userCardId the value for ed_dine_merchant.user_card_id
     */
    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.user_sex
     *
     * @return the value of ed_dine_merchant.user_sex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     */
    public EdDineMerchantEntity withUserSex(String userSex) {
        this.setUserSex(userSex);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.user_sex
     *
     * @param userSex the value for ed_dine_merchant.user_sex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.place_id
     *
     * @return the value of ed_dine_merchant.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineMerchantEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.place_id
     *
     * @param placeId the value for ed_dine_merchant.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.start_date
     *
     * @return the value of ed_dine_merchant.start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     */
    public EdDineMerchantEntity withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.start_date
     *
     * @param startDate the value for ed_dine_merchant.start_date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.end_date
     *
     * @return the value of ed_dine_merchant.end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     */
    public EdDineMerchantEntity withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.end_date
     *
     * @param endDate the value for ed_dine_merchant.end_date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.use_flag
     *
     * @return the value of ed_dine_merchant.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public EdDineMerchantEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.use_flag
     *
     * @param useFlag the value for ed_dine_merchant.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.remark
     *
     * @return the value of ed_dine_merchant.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineMerchantEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.remark
     *
     * @param remark the value for ed_dine_merchant.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col1
     *
     * @return the value of ed_dine_merchant.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col1
     *
     * @param spareCol1 the value for ed_dine_merchant.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col2
     *
     * @return the value of ed_dine_merchant.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col2
     *
     * @param spareCol2 the value for ed_dine_merchant.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col3
     *
     * @return the value of ed_dine_merchant.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col3
     *
     * @param spareCol3 the value for ed_dine_merchant.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col4
     *
     * @return the value of ed_dine_merchant.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col4
     *
     * @param spareCol4 the value for ed_dine_merchant.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col5
     *
     * @return the value of ed_dine_merchant.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col5
     *
     * @param spareCol5 the value for ed_dine_merchant.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.spare_col6
     *
     * @return the value of ed_dine_merchant.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineMerchantEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.spare_col6
     *
     * @param spareCol6 the value for ed_dine_merchant.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.ct_user
     *
     * @return the value of ed_dine_merchant.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineMerchantEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.ct_user
     *
     * @param ctUser the value for ed_dine_merchant.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.ct_date
     *
     * @return the value of ed_dine_merchant.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineMerchantEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.ct_date
     *
     * @param ctDate the value for ed_dine_merchant.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.lt_user
     *
     * @return the value of ed_dine_merchant.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineMerchantEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.lt_user
     *
     * @param ltUser the value for ed_dine_merchant.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_merchant.lt_date
     *
     * @return the value of ed_dine_merchant.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineMerchantEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_merchant.lt_date
     *
     * @param ltDate the value for ed_dine_merchant.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}