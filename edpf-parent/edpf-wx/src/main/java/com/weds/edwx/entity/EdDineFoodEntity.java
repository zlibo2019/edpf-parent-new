package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 菜品定义
 * @Date 2019-04-12
 */
public class EdDineFoodEntity extends BaseEntity implements Serializable {
    /**
     * 菜品编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜品编号")
    private String foodId;

    /**
     * 菜品名称
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜品名称")
    private String foodName;

    /**
     * 菜品类型
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜品类型")
    @Dict("03001")
    private String foodType;

    /**
     * 菜品价格
     */
    @Digits(integer = 6, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "菜品价格")
    private BigDecimal foodPrice;

    /**
     * 菜品图片
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜品图片")
    private String foodPhoto;

    /**
     * 菜品折扣
     */
    @Digits(integer = 1, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "菜品折扣")
    private BigDecimal foodDiscount;

    /**
     * 商户编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "商户编号")
    private String merchantId;

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

    private int foodNum;

    private String orderEnd;

    private int orderDays;

    private int foodUse;

    private String weekNum;

    @ApiModelProperty(required = true, dataType = "Date", example = "2019-04-16", value = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    private String mealId;

    private String mealName;

    private String placeId;

    private String operate;

    public int getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }

    public String getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
    }

    public int getOrderDays() {
        return orderDays;
    }

    public void setOrderDays(int orderDays) {
        this.orderDays = orderDays;
    }

    public int getFoodUse() {
        return foodUse;
    }

    public void setFoodUse(int foodUse) {
        this.foodUse = foodUse;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dine_food.food_id
     *
     * @return the value of ed_dine_food.food_id
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     */
    public EdDineFoodEntity withFoodId(String foodId) {
        this.setFoodId(foodId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_id
     *
     * @param foodId the value for ed_dine_food.food_id
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * This method returns the value of the database column ed_dine_food.food_name
     *
     * @return the value of ed_dine_food.food_name
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     */
    public EdDineFoodEntity withFoodName(String foodName) {
        this.setFoodName(foodName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_name
     *
     * @param foodName the value for ed_dine_food.food_name
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * This method returns the value of the database column ed_dine_food.food_type
     *
     * @return the value of ed_dine_food.food_type
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     */
    public EdDineFoodEntity withFoodType(String foodType) {
        this.setFoodType(foodType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_type
     *
     * @param foodType the value for ed_dine_food.food_type
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * This method returns the value of the database column ed_dine_food.food_price
     *
     * @return the value of ed_dine_food.food_price
     */
    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    /**
     */
    public EdDineFoodEntity withFoodPrice(BigDecimal foodPrice) {
        this.setFoodPrice(foodPrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_price
     *
     * @param foodPrice the value for ed_dine_food.food_price
     */
    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * This method returns the value of the database column ed_dine_food.food_photo
     *
     * @return the value of ed_dine_food.food_photo
     */
    public String getFoodPhoto() {
        return foodPhoto;
    }

    /**
     */
    public EdDineFoodEntity withFoodPhoto(String foodPhoto) {
        this.setFoodPhoto(foodPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_photo
     *
     * @param foodPhoto the value for ed_dine_food.food_photo
     */
    public void setFoodPhoto(String foodPhoto) {
        this.foodPhoto = foodPhoto;
    }

    /**
     * This method returns the value of the database column ed_dine_food.food_discount
     *
     * @return the value of ed_dine_food.food_discount
     */
    public BigDecimal getFoodDiscount() {
        return foodDiscount;
    }

    /**
     */
    public EdDineFoodEntity withFoodDiscount(BigDecimal foodDiscount) {
        this.setFoodDiscount(foodDiscount);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.food_discount
     *
     * @param foodDiscount the value for ed_dine_food.food_discount
     */
    public void setFoodDiscount(BigDecimal foodDiscount) {
        this.foodDiscount = foodDiscount;
    }

    /**
     * This method returns the value of the database column ed_dine_food.merchant_id
     *
     * @return the value of ed_dine_food.merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     */
    public EdDineFoodEntity withMerchantId(String merchantId) {
        this.setMerchantId(merchantId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.merchant_id
     *
     * @param merchantId the value for ed_dine_food.merchant_id
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column ed_dine_food.use_flag
     *
     * @return the value of ed_dine_food.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public EdDineFoodEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.use_flag
     *
     * @param useFlag the value for ed_dine_food.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dine_food.remark
     *
     * @return the value of ed_dine_food.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineFoodEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.remark
     *
     * @param remark the value for ed_dine_food.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col1
     *
     * @return the value of ed_dine_food.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col1
     *
     * @param spareCol1 the value for ed_dine_food.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col2
     *
     * @return the value of ed_dine_food.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col2
     *
     * @param spareCol2 the value for ed_dine_food.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col3
     *
     * @return the value of ed_dine_food.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col3
     *
     * @param spareCol3 the value for ed_dine_food.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col4
     *
     * @return the value of ed_dine_food.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col4
     *
     * @param spareCol4 the value for ed_dine_food.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col5
     *
     * @return the value of ed_dine_food.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col5
     *
     * @param spareCol5 the value for ed_dine_food.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_food.spare_col6
     *
     * @return the value of ed_dine_food.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineFoodEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.spare_col6
     *
     * @param spareCol6 the value for ed_dine_food.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_food.ct_user
     *
     * @return the value of ed_dine_food.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineFoodEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.ct_user
     *
     * @param ctUser the value for ed_dine_food.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_food.ct_date
     *
     * @return the value of ed_dine_food.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineFoodEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.ct_date
     *
     * @param ctDate the value for ed_dine_food.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_food.lt_user
     *
     * @return the value of ed_dine_food.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineFoodEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.lt_user
     *
     * @param ltUser the value for ed_dine_food.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_food.lt_date
     *
     * @return the value of ed_dine_food.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineFoodEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_food.lt_date
     *
     * @param ltDate the value for ed_dine_food.lt_date
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

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}