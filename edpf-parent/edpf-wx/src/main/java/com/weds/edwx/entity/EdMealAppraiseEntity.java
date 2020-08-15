package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 就餐评价
 * @Date 2019-11-27
 */
public class EdMealAppraiseEntity extends BaseEntity implements Serializable {

    /**
     * bh##1##0#
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "bh##1##0#")
    private String bh;

    /**
     * 用户编号##1##0#
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号##1##0#")
    private String userSerial;

    /**
     * 餐别编号##1##0#
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别编号##1##0#")
    private String mealId;

    /**
     * 餐别名称##1##0#
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "餐别名称##1##0#")
    private String mealName;

    /**
     * 消费时间##1##0#
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-11-27 08:51:27", value = "消费时间##1##0#")
    private Date mealDate;

    /**
     * 就餐评价##1##2#03003
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "就餐评价##1##2#03003")
    private String mealAppraise;

    /**
     * 备注##1##1#
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注##1##1#")
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

    private String startDate;

    private String endDate;

    private String operate;

    private int currTime;

    @Digits(integer = 15, fraction = 4)
    @ApiModelProperty(required = true, dataType = "long", example = "-1", value = "")
    private BigDecimal mealMoney;

    private String mealMoneyCn;

    private List<XfMenuJlEntity> list;

    private String jlBh;

    private String devSerial;

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    public String getJlBh() {
        return jlBh;
    }

    public void setJlBh(String jlBh) {
        this.jlBh = jlBh;
    }

    public List<XfMenuJlEntity> getList() {
        return list;
    }

    public void setList(List<XfMenuJlEntity> list) {
        this.list = list;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public int getCurrTime() {
        return currTime;
    }

    public void setCurrTime(int currTime) {
        this.currTime = currTime;
    }

    public String getMealMoneyCn() {
        return mealMoneyCn;
    }

    public void setMealMoneyCn(String mealMoneyCn) {
        this.mealMoneyCn = mealMoneyCn;
    }

    public BigDecimal getMealMoney() {
        return mealMoney;
    }

    public void setMealMoney(BigDecimal mealMoney) {
        this.mealMoney = mealMoney;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.bh
     *
     * @return the value of ed_meal_appraise.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public EdMealAppraiseEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.bh
     *
     * @param bh the value for ed_meal_appraise.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.user_serial
     *
     * @return the value of ed_meal_appraise.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public EdMealAppraiseEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.user_serial
     *
     * @param userSerial the value for ed_meal_appraise.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.meal_id
     *
     * @return the value of ed_meal_appraise.meal_id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     */
    public EdMealAppraiseEntity withMealId(String mealId) {
        this.setMealId(mealId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.meal_id
     *
     * @param mealId the value for ed_meal_appraise.meal_id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.meal_name
     *
     * @return the value of ed_meal_appraise.meal_name
     */
    public String getMealName() {
        return mealName;
    }

    /**
     */
    public EdMealAppraiseEntity withMealName(String mealName) {
        this.setMealName(mealName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.meal_name
     *
     * @param mealName the value for ed_meal_appraise.meal_name
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.meal_date
     *
     * @return the value of ed_meal_appraise.meal_date
     */
    public Date getMealDate() {
        return mealDate;
    }

    /**
     */
    public EdMealAppraiseEntity withMealDate(Date mealDate) {
        this.setMealDate(mealDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.meal_date
     *
     * @param mealDate the value for ed_meal_appraise.meal_date
     */
    public void setMealDate(Date mealDate) {
        this.mealDate = mealDate;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.meal_appraise
     *
     * @return the value of ed_meal_appraise.meal_appraise
     */
    public String getMealAppraise() {
        return mealAppraise;
    }

    /**
     */
    public EdMealAppraiseEntity withMealAppraise(String mealAppraise) {
        this.setMealAppraise(mealAppraise);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.meal_appraise
     *
     * @param mealAppraise the value for ed_meal_appraise.meal_appraise
     */
    public void setMealAppraise(String mealAppraise) {
        this.mealAppraise = mealAppraise;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.remark
     *
     * @return the value of ed_meal_appraise.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdMealAppraiseEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.remark
     *
     * @param remark the value for ed_meal_appraise.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col1
     *
     * @return the value of ed_meal_appraise.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col1
     *
     * @param spareCol1 the value for ed_meal_appraise.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col2
     *
     * @return the value of ed_meal_appraise.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col2
     *
     * @param spareCol2 the value for ed_meal_appraise.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col3
     *
     * @return the value of ed_meal_appraise.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col3
     *
     * @param spareCol3 the value for ed_meal_appraise.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col4
     *
     * @return the value of ed_meal_appraise.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col4
     *
     * @param spareCol4 the value for ed_meal_appraise.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col5
     *
     * @return the value of ed_meal_appraise.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col5
     *
     * @param spareCol5 the value for ed_meal_appraise.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.spare_col6
     *
     * @return the value of ed_meal_appraise.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdMealAppraiseEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.spare_col6
     *
     * @param spareCol6 the value for ed_meal_appraise.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.ct_user
     *
     * @return the value of ed_meal_appraise.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdMealAppraiseEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.ct_user
     *
     * @param ctUser the value for ed_meal_appraise.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.ct_date
     *
     * @return the value of ed_meal_appraise.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdMealAppraiseEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.ct_date
     *
     * @param ctDate the value for ed_meal_appraise.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.lt_user
     *
     * @return the value of ed_meal_appraise.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdMealAppraiseEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.lt_user
     *
     * @param ltUser the value for ed_meal_appraise.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_meal_appraise.lt_date
     *
     * @return the value of ed_meal_appraise.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdMealAppraiseEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_meal_appraise.lt_date
     *
     * @param ltDate the value for ed_meal_appraise.lt_date
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