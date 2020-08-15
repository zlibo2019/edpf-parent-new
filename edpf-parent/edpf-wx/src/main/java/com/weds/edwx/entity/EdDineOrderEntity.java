package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 订餐订单
 * @Date 2019-10-22
 */
public class EdDineOrderEntity extends BaseEntity implements Serializable {
    /**
     * 订单编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订单编号")
    private String orderId;

    /**
     * 人员编号
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员编号")
    private String userSerial;

    /**
     * 人员姓名
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员姓名")
    private String userName;

    /**
     * 餐厅编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐厅编号")
    private String placeId;

    /**
     * 餐厅名称
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐厅名称")
    private String placeName;

    /**
     * 订餐日期
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订餐日期")
    private String orderDate;

    /**
     * 订单金额
     */
    @Digits(integer = 6, fraction = 2)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "订单金额")
    private BigDecimal orderPrice;

    /**
     * 订餐份数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "订餐份数")
    private Integer foodNum;

    /**
     * 订单状态
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订单状态")
    @Dict("03002")
    private String orderState;

    /**
     * 订餐渠道
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订餐渠道")
    private String orderChannel;

    /**
     * 是否送餐
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否送餐")
    private String sendFlag;

    /**
     * 送餐地点编号
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "送餐地点编号")
    private String addrId;

    /**
     * 送餐地点
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "送餐地点")
    private String addrName;

    /**
     * 送餐日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-22 08:49:18", value = "送餐日期")
    private Date sendDate;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    private String orderInfo;

    private String mealName;

    private String mealId;

    private List<EdDineOrderInfoEntity> mealList;

    private List<EdDineOrderDetailEntity> foodList;

    private List<EdDineOrderEntity> list;

    private String operate;

    private String subOrderId;

    private String cancelFlag;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dine_order.order_id
     *
     * @return the value of ed_dine_order.order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     */
    public EdDineOrderEntity withOrderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.order_id
     *
     * @param orderId the value for ed_dine_order.order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method returns the value of the database column ed_dine_order.user_serial
     *
     * @return the value of ed_dine_order.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public EdDineOrderEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.user_serial
     *
     * @param userSerial the value for ed_dine_order.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_dine_order.user_name
     *
     * @return the value of ed_dine_order.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public EdDineOrderEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.user_name
     *
     * @param userName the value for ed_dine_order.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column ed_dine_order.place_id
     *
     * @return the value of ed_dine_order.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineOrderEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.place_id
     *
     * @param placeId the value for ed_dine_order.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_order.place_name
     *
     * @return the value of ed_dine_order.place_name
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     */
    public EdDineOrderEntity withPlaceName(String placeName) {
        this.setPlaceName(placeName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.place_name
     *
     * @param placeName the value for ed_dine_order.place_name
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
     * This method returns the value of the database column ed_dine_order.order_date
     *
     * @return the value of ed_dine_order.order_date
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     */
    public EdDineOrderEntity withOrderDate(String orderDate) {
        this.setOrderDate(orderDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.order_date
     *
     * @param orderDate the value for ed_dine_order.order_date
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method returns the value of the database column ed_dine_order.order_price
     *
     * @return the value of ed_dine_order.order_price
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     */
    public EdDineOrderEntity withOrderPrice(BigDecimal orderPrice) {
        this.setOrderPrice(orderPrice);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.order_price
     *
     * @param orderPrice the value for ed_dine_order.order_price
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * This method returns the value of the database column ed_dine_order.food_num
     *
     * @return the value of ed_dine_order.food_num
     */
    public Integer getFoodNum() {
        return foodNum;
    }

    /**
     */
    public EdDineOrderEntity withFoodNum(Integer foodNum) {
        this.setFoodNum(foodNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.food_num
     *
     * @param foodNum the value for ed_dine_order.food_num
     */
    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    /**
     * This method returns the value of the database column ed_dine_order.order_state
     *
     * @return the value of ed_dine_order.order_state
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     */
    public EdDineOrderEntity withOrderState(String orderState) {
        this.setOrderState(orderState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.order_state
     *
     * @param orderState the value for ed_dine_order.order_state
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * This method returns the value of the database column ed_dine_order.order_channel
     *
     * @return the value of ed_dine_order.order_channel
     */
    public String getOrderChannel() {
        return orderChannel;
    }

    /**
     */
    public EdDineOrderEntity withOrderChannel(String orderChannel) {
        this.setOrderChannel(orderChannel);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.order_channel
     *
     * @param orderChannel the value for ed_dine_order.order_channel
     */
    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    /**
     * This method returns the value of the database column ed_dine_order.send_flag
     *
     * @return the value of ed_dine_order.send_flag
     */
    public String getSendFlag() {
        return sendFlag;
    }

    /**
     */
    public EdDineOrderEntity withSendFlag(String sendFlag) {
        this.setSendFlag(sendFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.send_flag
     *
     * @param sendFlag the value for ed_dine_order.send_flag
     */
    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    /**
     * This method returns the value of the database column ed_dine_order.addr_id
     *
     * @return the value of ed_dine_order.addr_id
     */
    public String getAddrId() {
        return addrId;
    }

    /**
     */
    public EdDineOrderEntity withAddrId(String addrId) {
        this.setAddrId(addrId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.addr_id
     *
     * @param addrId the value for ed_dine_order.addr_id
     */
    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    /**
     * This method returns the value of the database column ed_dine_order.addr_name
     *
     * @return the value of ed_dine_order.addr_name
     */
    public String getAddrName() {
        return addrName;
    }

    /**
     */
    public EdDineOrderEntity withAddrName(String addrName) {
        this.setAddrName(addrName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.addr_name
     *
     * @param addrName the value for ed_dine_order.addr_name
     */
    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    /**
     * This method returns the value of the database column ed_dine_order.send_date
     *
     * @return the value of ed_dine_order.send_date
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     */
    public EdDineOrderEntity withSendDate(Date sendDate) {
        this.setSendDate(sendDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.send_date
     *
     * @param sendDate the value for ed_dine_order.send_date
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * This method returns the value of the database column ed_dine_order.remark
     *
     * @return the value of ed_dine_order.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineOrderEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.remark
     *
     * @param remark the value for ed_dine_order.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col1
     *
     * @return the value of ed_dine_order.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col1
     *
     * @param spareCol1 the value for ed_dine_order.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col2
     *
     * @return the value of ed_dine_order.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col2
     *
     * @param spareCol2 the value for ed_dine_order.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col3
     *
     * @return the value of ed_dine_order.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col3
     *
     * @param spareCol3 the value for ed_dine_order.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col4
     *
     * @return the value of ed_dine_order.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col4
     *
     * @param spareCol4 the value for ed_dine_order.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col5
     *
     * @return the value of ed_dine_order.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col5
     *
     * @param spareCol5 the value for ed_dine_order.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_order.spare_col6
     *
     * @return the value of ed_dine_order.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineOrderEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.spare_col6
     *
     * @param spareCol6 the value for ed_dine_order.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_order.ct_user
     *
     * @return the value of ed_dine_order.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineOrderEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.ct_user
     *
     * @param ctUser the value for ed_dine_order.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order.ct_date
     *
     * @return the value of ed_dine_order.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineOrderEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.ct_date
     *
     * @param ctDate the value for ed_dine_order.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_order.lt_user
     *
     * @return the value of ed_dine_order.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineOrderEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.lt_user
     *
     * @param ltUser the value for ed_dine_order.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_order.lt_date
     *
     * @return the value of ed_dine_order.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineOrderEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_order.lt_date
     *
     * @param ltDate the value for ed_dine_order.lt_date
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

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<EdDineOrderInfoEntity> getMealList() {
        return mealList;
    }

    public void setMealList(List<EdDineOrderInfoEntity> mealList) {
        this.mealList = mealList;
    }

    public List<EdDineOrderDetailEntity> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<EdDineOrderDetailEntity> foodList) {
        this.foodList = foodList;
    }

    public List<EdDineOrderEntity> getList() {
        return list;
    }

    public void setList(List<EdDineOrderEntity> list) {
        this.list = list;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
    }

    public Integer getOrderDays() {
        return orderDays;
    }

    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }
}