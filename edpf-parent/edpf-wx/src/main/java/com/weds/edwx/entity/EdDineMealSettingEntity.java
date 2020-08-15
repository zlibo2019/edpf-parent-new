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
 * @Description 餐别设置
 * @Date 2019-04-16
 */
public class EdDineMealSettingEntity extends BaseEntity implements Serializable {
    /**
     * 场所编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "场所编号")
    private String placeId;

    /**
     * 商户编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "商户编号")
    private String merchantId;

    /**
     * 餐别编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别编号")
    private String mealId;

    /**
     * 订餐开始时间
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订餐开始时间")
    private String orderStart;

    /**
     * 订餐结束时间
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订餐结束时间")
    private String orderEnd;

    /**
     * 提前预定天数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "提前预定天数")
    private Integer orderDays;

    /**
     * 就餐人员
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "就餐人员")
    private String orderType;

    /**
     * 就餐开始时间
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "就餐开始时间")
    private String repastStart;

    /**
     * 就餐结束时间
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "就餐结束时间")
    private String repastEnd;

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


    private String mealName;

    private String useFlag;

    private String operate;

    private String weekNum;

    @ApiModelProperty(required = true, dataType = "Date", example = "2019-04-16", value = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    public String getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dine_meal_setting.place_id
     *
     * @return the value of ed_dine_meal_setting.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineMealSettingEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.place_id
     *
     * @param placeId the value for ed_dine_meal_setting.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.merchant_id
     *
     * @return the value of ed_dine_meal_setting.merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     */
    public EdDineMealSettingEntity withMerchantId(String merchantId) {
        this.setMerchantId(merchantId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.merchant_id
     *
     * @param merchantId the value for ed_dine_meal_setting.merchant_id
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.meal_id
     *
     * @return the value of ed_dine_meal_setting.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdDineMealSettingEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.meal_id
     *
     * @param mealId the value for ed_dine_meal_setting.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.order_start
     *
     * @return the value of ed_dine_meal_setting.order_start
     */
    public String getOrderStart() {
        return orderStart;
    }

    /**
     */
    public EdDineMealSettingEntity withOrderStart(String orderStart) {
        this.setOrderStart(orderStart);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.order_start
     *
     * @param orderStart the value for ed_dine_meal_setting.order_start
     */
    public void setOrderStart(String orderStart) {
        this.orderStart = orderStart;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.order_end
     *
     * @return the value of ed_dine_meal_setting.order_end
     */
    public String getOrderEnd() {
        return orderEnd;
    }

    /**
     */
    public EdDineMealSettingEntity withOrderEnd(String orderEnd) {
        this.setOrderEnd(orderEnd);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.order_end
     *
     * @param orderEnd the value for ed_dine_meal_setting.order_end
     */
    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.order_days
     *
     * @return the value of ed_dine_meal_setting.order_days
     */
    public Integer getOrderDays() {
        return orderDays;
    }

    /**
     */
    public EdDineMealSettingEntity withOrderDays(Integer orderDays) {
        this.setOrderDays(orderDays);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.order_days
     *
     * @param orderDays the value for ed_dine_meal_setting.order_days
     */
    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.order_type
     *
     * @return the value of ed_dine_meal_setting.order_type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     */
    public EdDineMealSettingEntity withOrderType(String orderType) {
        this.setOrderType(orderType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.order_type
     *
     * @param orderType the value for ed_dine_meal_setting.order_type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.repast_start
     *
     * @return the value of ed_dine_meal_setting.repast_start
     */
    public String getRepastStart() {
        return repastStart;
    }

    /**
     */
    public EdDineMealSettingEntity withRepastStart(String repastStart) {
        this.setRepastStart(repastStart);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.repast_start
     *
     * @param repastStart the value for ed_dine_meal_setting.repast_start
     */
    public void setRepastStart(String repastStart) {
        this.repastStart = repastStart;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.repast_end
     *
     * @return the value of ed_dine_meal_setting.repast_end
     */
    public String getRepastEnd() {
        return repastEnd;
    }

    /**
     */
    public EdDineMealSettingEntity withRepastEnd(String repastEnd) {
        this.setRepastEnd(repastEnd);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.repast_end
     *
     * @param repastEnd the value for ed_dine_meal_setting.repast_end
     */
    public void setRepastEnd(String repastEnd) {
        this.repastEnd = repastEnd;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.remark
     *
     * @return the value of ed_dine_meal_setting.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineMealSettingEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.remark
     *
     * @param remark the value for ed_dine_meal_setting.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col1
     *
     * @return the value of ed_dine_meal_setting.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col1
     *
     * @param spareCol1 the value for ed_dine_meal_setting.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col2
     *
     * @return the value of ed_dine_meal_setting.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col2
     *
     * @param spareCol2 the value for ed_dine_meal_setting.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col3
     *
     * @return the value of ed_dine_meal_setting.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col3
     *
     * @param spareCol3 the value for ed_dine_meal_setting.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col4
     *
     * @return the value of ed_dine_meal_setting.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col4
     *
     * @param spareCol4 the value for ed_dine_meal_setting.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col5
     *
     * @return the value of ed_dine_meal_setting.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col5
     *
     * @param spareCol5 the value for ed_dine_meal_setting.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.spare_col6
     *
     * @return the value of ed_dine_meal_setting.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineMealSettingEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.spare_col6
     *
     * @param spareCol6 the value for ed_dine_meal_setting.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.ct_user
     *
     * @return the value of ed_dine_meal_setting.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineMealSettingEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.ct_user
     *
     * @param ctUser the value for ed_dine_meal_setting.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.ct_date
     *
     * @return the value of ed_dine_meal_setting.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineMealSettingEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.ct_date
     *
     * @param ctDate the value for ed_dine_meal_setting.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.lt_user
     *
     * @return the value of ed_dine_meal_setting.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineMealSettingEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.lt_user
     *
     * @param ltUser the value for ed_dine_meal_setting.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_meal_setting.lt_date
     *
     * @return the value of ed_dine_meal_setting.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineMealSettingEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_meal_setting.lt_date
     *
     * @param ltDate the value for ed_dine_meal_setting.lt_date
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