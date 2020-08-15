package com.weds.edwx.entity;

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
 * @Description 菜谱详情
 * @Date 2019-04-12
 */
public class EdDineMenuDetailEntity extends BaseEntity implements Serializable {
    /**
     * 菜谱编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜谱编号")
    private String menuId;

    /**
     * 菜品编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "菜品编号")
    private String foodId;

    /**
     * 菜品份数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "菜品份数")
    private Integer foodNum;

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
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_dine_menu_detail.menu_id
     *
     * @return the value of ed_dine_menu_detail.menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     */
    public EdDineMenuDetailEntity withMenuId(String menuId) {
        this.setMenuId(menuId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.menu_id
     *
     * @param menuId the value for ed_dine_menu_detail.menu_id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.food_id
     *
     * @return the value of ed_dine_menu_detail.food_id
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     */
    public EdDineMenuDetailEntity withFoodId(String foodId) {
        this.setFoodId(foodId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.food_id
     *
     * @param foodId the value for ed_dine_menu_detail.food_id
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.food_num
     *
     * @return the value of ed_dine_menu_detail.food_num
     */
    public Integer getFoodNum() {
        return foodNum;
    }

    /**
     */
    public EdDineMenuDetailEntity withFoodNum(Integer foodNum) {
        this.setFoodNum(foodNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.food_num
     *
     * @param foodNum the value for ed_dine_menu_detail.food_num
     */
    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col1
     *
     * @return the value of ed_dine_menu_detail.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col1
     *
     * @param spareCol1 the value for ed_dine_menu_detail.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col2
     *
     * @return the value of ed_dine_menu_detail.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col2
     *
     * @param spareCol2 the value for ed_dine_menu_detail.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col3
     *
     * @return the value of ed_dine_menu_detail.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col3
     *
     * @param spareCol3 the value for ed_dine_menu_detail.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col4
     *
     * @return the value of ed_dine_menu_detail.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col4
     *
     * @param spareCol4 the value for ed_dine_menu_detail.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col5
     *
     * @return the value of ed_dine_menu_detail.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col5
     *
     * @param spareCol5 the value for ed_dine_menu_detail.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.spare_col6
     *
     * @return the value of ed_dine_menu_detail.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineMenuDetailEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.spare_col6
     *
     * @param spareCol6 the value for ed_dine_menu_detail.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.ct_user
     *
     * @return the value of ed_dine_menu_detail.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineMenuDetailEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.ct_user
     *
     * @param ctUser the value for ed_dine_menu_detail.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_menu_detail.ct_date
     *
     * @return the value of ed_dine_menu_detail.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineMenuDetailEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_menu_detail.ct_date
     *
     * @param ctDate the value for ed_dine_menu_detail.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}