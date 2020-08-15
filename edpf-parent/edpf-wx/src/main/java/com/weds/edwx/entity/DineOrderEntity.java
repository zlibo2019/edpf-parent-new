package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DineOrderEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String listBh;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-13", value = "")
    private Date rq;

    private String beginDate;

    private String endDate;

    private String key;

    private String mealName;

    private String strRq;

    private List<DineOrderEntity> list;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mealBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String foodBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer dineNums;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String dineBz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer dineType;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-13 15:21:28", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column dine_order.Xh
     *
     * @return the value of dine_order.Xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public DineOrderEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Xh
     *
     * @param xh the value for dine_order.Xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column dine_order.List_bh
     *
     * @return the value of dine_order.List_bh
     */
    public String getListBh() {
        return listBh;
    }

    /**
     */
    public DineOrderEntity withListBh(String listBh) {
        this.setListBh(listBh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.List_bh
     *
     * @param listBh the value for dine_order.List_bh
     */
    public void setListBh(String listBh) {
        this.listBh = listBh;
    }

    /**
     * This method returns the value of the database column dine_order.Rq
     *
     * @return the value of dine_order.Rq
     */
    public Date getRq() {
        return rq;
    }

    /**
     */
    public DineOrderEntity withRq(Date rq) {
        this.setRq(rq);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Rq
     *
     * @param rq the value for dine_order.Rq
     */
    public void setRq(Date rq) {
        this.rq = rq;
    }

    /**
     * This method returns the value of the database column dine_order.Meal_bh
     *
     * @return the value of dine_order.Meal_bh
     */
    public String getMealBh() {
        return mealBh;
    }

    /**
     */
    public DineOrderEntity withMealBh(String mealBh) {
        this.setMealBh(mealBh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Meal_bh
     *
     * @param mealBh the value for dine_order.Meal_bh
     */
    public void setMealBh(String mealBh) {
        this.mealBh = mealBh;
    }

    /**
     * This method returns the value of the database column dine_order.Food_bh
     *
     * @return the value of dine_order.Food_bh
     */
    public String getFoodBh() {
        return foodBh;
    }

    /**
     */
    public DineOrderEntity withFoodBh(String foodBh) {
        this.setFoodBh(foodBh);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Food_bh
     *
     * @param foodBh the value for dine_order.Food_bh
     */
    public void setFoodBh(String foodBh) {
        this.foodBh = foodBh;
    }

    /**
     * This method returns the value of the database column dine_order.User_serial
     *
     * @return the value of dine_order.User_serial
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public DineOrderEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.User_serial
     *
     * @param userSerial the value for dine_order.User_serial
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column dine_order.dine_nums
     *
     * @return the value of dine_order.dine_nums
     */
    public Integer getDineNums() {
        return dineNums;
    }

    /**
     */
    public DineOrderEntity withDineNums(Integer dineNums) {
        this.setDineNums(dineNums);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.dine_nums
     *
     * @param dineNums the value for dine_order.dine_nums
     */
    public void setDineNums(Integer dineNums) {
        this.dineNums = dineNums;
    }

    /**
     * This method returns the value of the database column dine_order.dine_bz
     *
     * @return the value of dine_order.dine_bz
     */
    public String getDineBz() {
        return dineBz;
    }

    /**
     */
    public DineOrderEntity withDineBz(String dineBz) {
        this.setDineBz(dineBz);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.dine_bz
     *
     * @param dineBz the value for dine_order.dine_bz
     */
    public void setDineBz(String dineBz) {
        this.dineBz = dineBz;
    }

    /**
     * This method returns the value of the database column dine_order.dine_type
     *
     * @return the value of dine_order.dine_type
     */
    public Integer getDineType() {
        return dineType;
    }

    /**
     */
    public DineOrderEntity withDineType(Integer dineType) {
        this.setDineType(dineType);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.dine_type
     *
     * @param dineType the value for dine_order.dine_type
     */
    public void setDineType(Integer dineType) {
        this.dineType = dineType;
    }

    /**
     * This method returns the value of the database column dine_order.Sj
     *
     * @return the value of dine_order.Sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DineOrderEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Sj
     *
     * @param sj the value for dine_order.Sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dine_order.Gly_no
     *
     * @return the value of dine_order.Gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DineOrderEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column dine_order.Gly_no
     *
     * @param glyNo the value for dine_order.Gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<DineOrderEntity> getList() {
        return list;
    }

    public void setList(List<DineOrderEntity> list) {
        this.list = list;
    }

    public String getStrRq() {
        return strRq;
    }

    public void setStrRq(String strRq) {
        this.strRq = strRq;
    }
}