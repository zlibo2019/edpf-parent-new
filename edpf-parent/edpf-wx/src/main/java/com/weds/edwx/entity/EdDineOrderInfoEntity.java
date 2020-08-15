package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 订餐订单信息
 * @Date 2019-10-22
 */
public class EdDineOrderInfoEntity extends BaseEntity implements Serializable {
    /**
     * 餐别订单
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别订单")
    private String subOrderId;

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
     * 餐别名称
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别名称")
    private String mealName;

    /**
     * 餐别金额
     */
    @Digits(integer = 6, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "餐别金额")
    private BigDecimal mealPrice;

    /**
     * 订餐份数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "订餐份数")
    private Integer foodNum;

    /**
     * 餐别状态
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别状态")
    private String mealState;

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

    private List<EdDineOrderDetailEntity> list;

    /**
     * This method returns the value of the database column ed_dine_order_info.sub_order_id
     *
     * @return the value of ed_dine_order_info.sub_order_id
     */
    public String getSubOrderId() {
        return subOrderId;
    }

    /**
     */
    public EdDineOrderInfoEntity withSubOrderId(String subOrderId) {
        this.setSubOrderId(subOrderId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.sub_order_id
     *
     * @param subOrderId the value for ed_dine_order_info.sub_order_id
     */
    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.order_id
     *
     * @return the value of ed_dine_order_info.order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     */
    public EdDineOrderInfoEntity withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.order_id
     *
     * @param orderId the value for ed_dine_order_info.order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.meal_id
     *
     * @return the value of ed_dine_order_info.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdDineOrderInfoEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.meal_id
     *
     * @param mealId the value for ed_dine_order_info.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.meal_name
     *
     * @return the value of ed_dine_order_info.meal_name
     */
    public String getMealName() {
        return mealName;
    }

    /**
     */
    public EdDineOrderInfoEntity withMealName(String mealName) {
        this.setMealName(mealName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.meal_name
     *
     * @param mealName the value for ed_dine_order_info.meal_name
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.meal_price
     *
     * @return the value of ed_dine_order_info.meal_price
     */
    public BigDecimal getMealPrice() {
        return mealPrice;
    }

    /**
     */
    public EdDineOrderInfoEntity withMealPrice(BigDecimal mealPrice) {
        this.setMealPrice(mealPrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.meal_price
     *
     * @param mealPrice the value for ed_dine_order_info.meal_price
     */
    public void setMealPrice(BigDecimal mealPrice) {
        this.mealPrice = mealPrice;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.food_num
     *
     * @return the value of ed_dine_order_info.food_num
     */
    public Integer getFoodNum() {
        return foodNum;
    }

    /**
     */
    public EdDineOrderInfoEntity withFoodNum(Integer foodNum) {
        this.setFoodNum(foodNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.food_num
     *
     * @param foodNum the value for ed_dine_order_info.food_num
     */
    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.meal_state
     *
     * @return the value of ed_dine_order_info.meal_state
     */
    public String getMealState() {
        return mealState;
    }

    /**
     */
    public EdDineOrderInfoEntity withMealState(String mealState) {
        this.setMealState(mealState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.meal_state
     *
     * @param mealState the value for ed_dine_order_info.meal_state
     */
    public void setMealState(String mealState) {
        this.mealState = mealState;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col1
     *
     * @return the value of ed_dine_order_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col1
     *
     * @param spareCol1 the value for ed_dine_order_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col2
     *
     * @return the value of ed_dine_order_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col2
     *
     * @param spareCol2 the value for ed_dine_order_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col3
     *
     * @return the value of ed_dine_order_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col3
     *
     * @param spareCol3 the value for ed_dine_order_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col4
     *
     * @return the value of ed_dine_order_info.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col4
     *
     * @param spareCol4 the value for ed_dine_order_info.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col5
     *
     * @return the value of ed_dine_order_info.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col5
     *
     * @param spareCol5 the value for ed_dine_order_info.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.spare_col6
     *
     * @return the value of ed_dine_order_info.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineOrderInfoEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.spare_col6
     *
     * @param spareCol6 the value for ed_dine_order_info.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.ct_user
     *
     * @return the value of ed_dine_order_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineOrderInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.ct_user
     *
     * @param ctUser the value for ed_dine_order_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.ct_date
     *
     * @return the value of ed_dine_order_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineOrderInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.ct_date
     *
     * @param ctDate the value for ed_dine_order_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.lt_user
     *
     * @return the value of ed_dine_order_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineOrderInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.lt_user
     *
     * @param ltUser the value for ed_dine_order_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order_info.lt_date
     *
     * @return the value of ed_dine_order_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineOrderInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order_info.lt_date
     *
     * @param ltDate the value for ed_dine_order_info.lt_date
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

    public List<EdDineOrderDetailEntity> getList() {
        return list;
    }

    public void setList(List<EdDineOrderDetailEntity> list) {
        this.list = list;
    }
}