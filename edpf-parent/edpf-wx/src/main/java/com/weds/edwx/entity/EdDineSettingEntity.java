package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 订餐配置
 * @Date 2019-04-12
 */
public class EdDineSettingEntity extends BaseEntity implements Serializable {
    /**
     *   场所编号
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "场所编号")
    private String placeId;

    /**
     *   可供餐别
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "可供餐别")
    private String mealId;

    /**
     *   可预订时间
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "可预订时间")
    private Integer orderDays;

    /**
     *   就餐人员
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "就餐人员")
    private String orderType;

    /**
     *   考勤关联开始
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "考勤关联开始")
    private String startTime;

    /**
     *   考勤关联结束
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "考勤关联结束")
    private String endTime;

    /**
     *   是否启用
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用")
    private String useFlag;

    /**
     *   备注
     *
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

    /**
     *   预留字段1
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     *   预留字段2
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     *   预留字段3
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

    /**
     *   预留字段4
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol4;

    /**
     *   预留字段5
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol5;

    /**
     *   预留字段6
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol6;

    /**
     *   创建用户
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建用户")
    private String ctUser;

    /**
     *   创建时间
     *
     */
    @JsonIgnore
    @Size(max = 23)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     *   修改用户
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改用户")
    private String ltUser;

    /**
     *   修改时间
     *
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
     * This method returns the value of the database column ed_dine_setting.place_id
     *
     * @return the value of ed_dine_setting.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineSettingEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.place_id
     *
     * @param placeId the value for ed_dine_setting.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.meal_id
     *
     * @return the value of ed_dine_setting.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdDineSettingEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.meal_id
     *
     * @param mealId the value for ed_dine_setting.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.order_days
     *
     * @return the value of ed_dine_setting.order_days
     */
    public Integer getOrderDays() {
        return orderDays;
    }

    /**
     */
    public EdDineSettingEntity withOrderDays(Integer orderDays) {
        this.setOrderDays(orderDays);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.order_days
     *
     * @param orderDays the value for ed_dine_setting.order_days
     */
    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.order_type
     *
     * @return the value of ed_dine_setting.order_type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     */
    public EdDineSettingEntity withOrderType(String orderType) {
        this.setOrderType(orderType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.order_type
     *
     * @param orderType the value for ed_dine_setting.order_type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.start_time
     *
     * @return the value of ed_dine_setting.start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     */
    public EdDineSettingEntity withStartTime(String startTime) {
        this.setStartTime(startTime);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.start_time
     *
     * @param startTime the value for ed_dine_setting.start_time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.end_time
     *
     * @return the value of ed_dine_setting.end_time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     */
    public EdDineSettingEntity withEndTime(String endTime) {
        this.setEndTime(endTime);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.end_time
     *
     * @param endTime the value for ed_dine_setting.end_time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.use_flag
     *
     * @return the value of ed_dine_setting.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public EdDineSettingEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.use_flag
     *
     * @param useFlag the value for ed_dine_setting.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.remark
     *
     * @return the value of ed_dine_setting.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineSettingEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.remark
     *
     * @param remark the value for ed_dine_setting.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col1
     *
     * @return the value of ed_dine_setting.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col1
     *
     * @param spareCol1 the value for ed_dine_setting.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col2
     *
     * @return the value of ed_dine_setting.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col2
     *
     * @param spareCol2 the value for ed_dine_setting.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col3
     *
     * @return the value of ed_dine_setting.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col3
     *
     * @param spareCol3 the value for ed_dine_setting.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col4
     *
     * @return the value of ed_dine_setting.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col4
     *
     * @param spareCol4 the value for ed_dine_setting.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col5
     *
     * @return the value of ed_dine_setting.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col5
     *
     * @param spareCol5 the value for ed_dine_setting.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.spare_col6
     *
     * @return the value of ed_dine_setting.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineSettingEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.spare_col6
     *
     * @param spareCol6 the value for ed_dine_setting.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.ct_user
     *
     * @return the value of ed_dine_setting.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineSettingEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.ct_user
     *
     * @param ctUser the value for ed_dine_setting.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.ct_date
     *
     * @return the value of ed_dine_setting.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineSettingEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.ct_date
     *
     * @param ctDate the value for ed_dine_setting.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.lt_user
     *
     * @return the value of ed_dine_setting.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineSettingEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.lt_user
     *
     * @param ltUser the value for ed_dine_setting.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_setting.lt_date
     *
     * @return the value of ed_dine_setting.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineSettingEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_setting.lt_date
     *
     * @param ltDate the value for ed_dine_setting.lt_date
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