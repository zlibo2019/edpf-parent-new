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
 * @Description 菜谱定义
 * @Date 2019-04-15
 */
public class EdDineMenuEntity extends BaseEntity implements Serializable {
    /**
     * 菜谱编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜谱编号")
    private String menuId;

    /**
     * 菜谱名称
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜谱名称")
    private String menuName;

    /**
     * 场所编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "场所编号")
    private String placeId;

    /**
     * 餐别编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别编号")
    private String mealId;

    /**
     * 适用星期
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "适用星期")
    private String weekNum;

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
     * This method returns the value of the database column ed_dine_menu.menu_id
     *
     * @return the value of ed_dine_menu.menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     */
    public EdDineMenuEntity withMenuId(String menuId) {
        this.setMenuId(menuId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.menu_id
     *
     * @param menuId the value for ed_dine_menu.menu_id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.menu_name
     *
     * @return the value of ed_dine_menu.menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     */
    public EdDineMenuEntity withMenuName(String menuName) {
        this.setMenuName(menuName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.menu_name
     *
     * @param menuName the value for ed_dine_menu.menu_name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.place_id
     *
     * @return the value of ed_dine_menu.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineMenuEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.place_id
     *
     * @param placeId the value for ed_dine_menu.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.meal_id
     *
     * @return the value of ed_dine_menu.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdDineMenuEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.meal_id
     *
     * @param mealId the value for ed_dine_menu.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.week_num
     *
     * @return the value of ed_dine_menu.week_num
     */
    public String getWeekNum() {
        return weekNum;
    }

    /**
     */
    public EdDineMenuEntity withWeekNum(String weekNum) {
        this.setWeekNum(weekNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.week_num
     *
     * @param weekNum the value for ed_dine_menu.week_num
     */
    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.merchant_id
     *
     * @return the value of ed_dine_menu.merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     */
    public EdDineMenuEntity withMerchantId(String merchantId) {
        this.setMerchantId(merchantId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.merchant_id
     *
     * @param merchantId the value for ed_dine_menu.merchant_id
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.use_flag
     *
     * @return the value of ed_dine_menu.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public EdDineMenuEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.use_flag
     *
     * @param useFlag the value for ed_dine_menu.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.remark
     *
     * @return the value of ed_dine_menu.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineMenuEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.remark
     *
     * @param remark the value for ed_dine_menu.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col1
     *
     * @return the value of ed_dine_menu.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col1
     *
     * @param spareCol1 the value for ed_dine_menu.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col2
     *
     * @return the value of ed_dine_menu.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col2
     *
     * @param spareCol2 the value for ed_dine_menu.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col3
     *
     * @return the value of ed_dine_menu.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col3
     *
     * @param spareCol3 the value for ed_dine_menu.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col4
     *
     * @return the value of ed_dine_menu.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col4
     *
     * @param spareCol4 the value for ed_dine_menu.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col5
     *
     * @return the value of ed_dine_menu.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col5
     *
     * @param spareCol5 the value for ed_dine_menu.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.spare_col6
     *
     * @return the value of ed_dine_menu.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineMenuEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.spare_col6
     *
     * @param spareCol6 the value for ed_dine_menu.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.ct_user
     *
     * @return the value of ed_dine_menu.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineMenuEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.ct_user
     *
     * @param ctUser the value for ed_dine_menu.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.ct_date
     *
     * @return the value of ed_dine_menu.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineMenuEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.ct_date
     *
     * @param ctDate the value for ed_dine_menu.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.lt_user
     *
     * @return the value of ed_dine_menu.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineMenuEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.lt_user
     *
     * @param ltUser the value for ed_dine_menu.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_menu.lt_date
     *
     * @return the value of ed_dine_menu.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineMenuEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu.lt_date
     *
     * @param ltDate the value for ed_dine_menu.lt_date
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