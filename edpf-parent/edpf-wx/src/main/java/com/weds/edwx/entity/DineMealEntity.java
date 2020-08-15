package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DineMealEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mealBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mealName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String kssj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String jssj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer dineVali;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String bz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-13 13:52:08", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer mealBle;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String ownerNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column dine_meal.Xh
     *
     * @return the value of dine_meal.Xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DineMealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.Xh
     *
     * @param xh the value for dine_meal.Xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column dine_meal.meal_bh
     *
     * @return the value of dine_meal.meal_bh
     */
    public String getMealBh() {
        return mealBh;
    }

    /**
     */
    public DineMealEntity withMealBh(String mealBh) {
        this.setMealBh(mealBh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.meal_bh
     *
     * @param mealBh the value for dine_meal.meal_bh
     */
    public void setMealBh(String mealBh) {
        this.mealBh = mealBh;
    }

    /**
     * This method returns the value of the database column dine_meal.meal_name
     *
     * @return the value of dine_meal.meal_name
     */
    public String getMealName() {
        return mealName;
    }

    /**
     */
    public DineMealEntity withMealName(String mealName) {
        this.setMealName(mealName);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.meal_name
     *
     * @param mealName the value for dine_meal.meal_name
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * This method returns the value of the database column dine_meal.kssj
     *
     * @return the value of dine_meal.kssj
     */
    public String getKssj() {
        return kssj;
    }

    /**
     */
    public DineMealEntity withKssj(String kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.kssj
     *
     * @param kssj the value for dine_meal.kssj
     */
    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column dine_meal.jssj
     *
     * @return the value of dine_meal.jssj
     */
    public String getJssj() {
        return jssj;
    }

    /**
     */
    public DineMealEntity withJssj(String jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.jssj
     *
     * @param jssj the value for dine_meal.jssj
     */
    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column dine_meal.dine_Vali
     *
     * @return the value of dine_meal.dine_Vali
     */
    public Integer getDineVali() {
        return dineVali;
    }

    /**
     */
    public DineMealEntity withDineVali(Integer dineVali) {
        this.setDineVali(dineVali);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.dine_Vali
     *
     * @param dineVali the value for dine_meal.dine_Vali
     */
    public void setDineVali(Integer dineVali) {
        this.dineVali = dineVali;
    }

    /**
     * This method returns the value of the database column dine_meal.bz
     *
     * @return the value of dine_meal.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public DineMealEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.bz
     *
     * @param bz the value for dine_meal.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column dine_meal.sj
     *
     * @return the value of dine_meal.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DineMealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.sj
     *
     * @param sj the value for dine_meal.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dine_meal.Gly_no
     *
     * @return the value of dine_meal.Gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DineMealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.Gly_no
     *
     * @param glyNo the value for dine_meal.Gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column dine_meal.meal_ble
     *
     * @return the value of dine_meal.meal_ble
     */
    public Integer getMealBle() {
        return mealBle;
    }

    /**
     */
    public DineMealEntity withMealBle(Integer mealBle) {
        this.setMealBle(mealBle);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.meal_ble
     *
     * @param mealBle the value for dine_meal.meal_ble
     */
    public void setMealBle(Integer mealBle) {
        this.mealBle = mealBle;
    }

    /**
     * This method returns the value of the database column dine_meal.Owner_no
     *
     * @return the value of dine_meal.Owner_no
     */
    public String getOwnerNo() {
        return ownerNo;
    }

    /**
     */
    public DineMealEntity withOwnerNo(String ownerNo) {
        this.setOwnerNo(ownerNo);
        return this;
    }

    /**
     * This method sets the value of the database column dine_meal.Owner_no
     *
     * @param ownerNo the value for dine_meal.Owner_no
     */
    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }
}