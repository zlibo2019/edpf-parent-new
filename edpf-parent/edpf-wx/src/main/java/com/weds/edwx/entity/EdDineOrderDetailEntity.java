package com.weds.edwx.entity;

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
 * @Description 订餐订单详情
 * @Date 2019-10-22
 */
public class EdDineOrderDetailEntity extends BaseEntity implements Serializable {
    /**
     * id
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "id")
    private String id;

    /**
     * 订单编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订单编号")
    private String orderId;

    /**
     * 餐别编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别编号")
    private String mealId;

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
     * 菜品价格
     */
    @Digits(integer = 4, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "菜品价格")
    private BigDecimal foodPrice;

    /**
     * 菜品份数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "菜品份数")
    private Integer foodNum;

    /**
     * 订单状态
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订单状态")
    private String orderState;

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
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    private String foodPhoto;

    /**
     * This method returns the value of the database column ed_dine_order_detail.id
     *
     * @return the value of ed_dine_order_detail.id
     */
    public String getId() {
        return id;
    }

    /**
     */
    public EdDineOrderDetailEntity withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.id
     *
     * @param id the value for ed_dine_order_detail.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.order_id
     *
     * @return the value of ed_dine_order_detail.order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     */
    public EdDineOrderDetailEntity withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.order_id
     *
     * @param orderId the value for ed_dine_order_detail.order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.meal_id
     *
     * @return the value of ed_dine_order_detail.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdDineOrderDetailEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.meal_id
     *
     * @param mealId the value for ed_dine_order_detail.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.merchant_id
     *
     * @return the value of ed_dine_order_detail.merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     */
    public EdDineOrderDetailEntity withMerchantId(String merchantId) {
        this.setMerchantId(merchantId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.merchant_id
     *
     * @param merchantId the value for ed_dine_order_detail.merchant_id
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.merchant_name
     *
     * @return the value of ed_dine_order_detail.merchant_name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     */
    public EdDineOrderDetailEntity withMerchantName(String merchantName) {
        this.setMerchantName(merchantName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.merchant_name
     *
     * @param merchantName the value for ed_dine_order_detail.merchant_name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.food_id
     *
     * @return the value of ed_dine_order_detail.food_id
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     */
    public EdDineOrderDetailEntity withFoodId(String foodId) {
        this.setFoodId(foodId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.food_id
     *
     * @param foodId the value for ed_dine_order_detail.food_id
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.food_name
     *
     * @return the value of ed_dine_order_detail.food_name
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     */
    public EdDineOrderDetailEntity withFoodName(String foodName) {
        this.setFoodName(foodName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.food_name
     *
     * @param foodName the value for ed_dine_order_detail.food_name
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.food_price
     *
     * @return the value of ed_dine_order_detail.food_price
     */
    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    /**
     */
    public EdDineOrderDetailEntity withFoodPrice(BigDecimal foodPrice) {
        this.setFoodPrice(foodPrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.food_price
     *
     * @param foodPrice the value for ed_dine_order_detail.food_price
     */
    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.food_num
     *
     * @return the value of ed_dine_order_detail.food_num
     */
    public Integer getFoodNum() {
        return foodNum;
    }

    /**
     */
    public EdDineOrderDetailEntity withFoodNum(Integer foodNum) {
        this.setFoodNum(foodNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.food_num
     *
     * @param foodNum the value for ed_dine_order_detail.food_num
     */
    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.order_state
     *
     * @return the value of ed_dine_order_detail.order_state
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     */
    public EdDineOrderDetailEntity withOrderState(String orderState) {
        this.setOrderState(orderState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.order_state
     *
     * @param orderState the value for ed_dine_order_detail.order_state
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col1
     *
     * @return the value of ed_dine_order_detail.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col1
     *
     * @param spareCol1 the value for ed_dine_order_detail.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col2
     *
     * @return the value of ed_dine_order_detail.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col2
     *
     * @param spareCol2 the value for ed_dine_order_detail.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col3
     *
     * @return the value of ed_dine_order_detail.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col3
     *
     * @param spareCol3 the value for ed_dine_order_detail.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col4
     *
     * @return the value of ed_dine_order_detail.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col4
     *
     * @param spareCol4 the value for ed_dine_order_detail.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col5
     *
     * @return the value of ed_dine_order_detail.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col5
     *
     * @param spareCol5 the value for ed_dine_order_detail.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.spare_col6
     *
     * @return the value of ed_dine_order_detail.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineOrderDetailEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.spare_col6
     *
     * @param spareCol6 the value for ed_dine_order_detail.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.ct_user
     *
     * @return the value of ed_dine_order_detail.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineOrderDetailEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.ct_user
     *
     * @param ctUser the value for ed_dine_order_detail.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.ct_date
     *
     * @return the value of ed_dine_order_detail.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineOrderDetailEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.ct_date
     *
     * @param ctDate the value for ed_dine_order_detail.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.lt_user
     *
     * @return the value of ed_dine_order_detail.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineOrderDetailEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.lt_user
     *
     * @param ltUser the value for ed_dine_order_detail.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order_detail.lt_date
     *
     * @return the value of ed_dine_order_detail.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineOrderDetailEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_detail.lt_date
     *
     * @param ltDate the value for ed_dine_order_detail.lt_date
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

    public String getFoodPhoto() {
        return foodPhoto;
    }

    public void setFoodPhoto(String foodPhoto) {
        this.foodPhoto = foodPhoto;
    }
}