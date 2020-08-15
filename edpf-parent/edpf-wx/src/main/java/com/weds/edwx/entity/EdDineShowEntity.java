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
 * @Description 订餐说明
 * @Date 2019-04-30
 */
public class EdDineShowEntity extends BaseEntity implements Serializable {
    /**
     * 场所编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "场所编号")
    private String placeId;

    /**
     * 订餐说明
     */
    @Size(max = 2000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "订餐说明")
    private String dineShow;

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
     * This method returns the value of the database column ed_dine_show.place_id
     *
     * @return the value of ed_dine_show.place_id
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     */
    public EdDineShowEntity withPlaceId(String placeId) {
        this.setPlaceId(placeId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.place_id
     *
     * @param placeId the value for ed_dine_show.place_id
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * This method returns the value of the database column ed_dine_show.dine_show
     *
     * @return the value of ed_dine_show.dine_show
     */
    public String getDineShow() {
        return dineShow;
    }

    /**
     */
    public EdDineShowEntity withDineShow(String dineShow) {
        this.setDineShow(dineShow);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.dine_show
     *
     * @param dineShow the value for ed_dine_show.dine_show
     */
    public void setDineShow(String dineShow) {
        this.dineShow = dineShow;
    }

    /**
     * This method returns the value of the database column ed_dine_show.remark
     *
     * @return the value of ed_dine_show.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public EdDineShowEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.remark
     *
     * @param remark the value for ed_dine_show.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col1
     *
     * @return the value of ed_dine_show.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public EdDineShowEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col1
     *
     * @param spareCol1 the value for ed_dine_show.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col2
     *
     * @return the value of ed_dine_show.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public EdDineShowEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col2
     *
     * @param spareCol2 the value for ed_dine_show.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col3
     *
     * @return the value of ed_dine_show.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public EdDineShowEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col3
     *
     * @param spareCol3 the value for ed_dine_show.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col4
     *
     * @return the value of ed_dine_show.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public EdDineShowEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col4
     *
     * @param spareCol4 the value for ed_dine_show.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col5
     *
     * @return the value of ed_dine_show.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public EdDineShowEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col5
     *
     * @param spareCol5 the value for ed_dine_show.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_dine_show.spare_col6
     *
     * @return the value of ed_dine_show.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public EdDineShowEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.spare_col6
     *
     * @param spareCol6 the value for ed_dine_show.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column ed_dine_show.ct_user
     *
     * @return the value of ed_dine_show.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public EdDineShowEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.ct_user
     *
     * @param ctUser the value for ed_dine_show.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_dine_show.ct_date
     *
     * @return the value of ed_dine_show.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public EdDineShowEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.ct_date
     *
     * @param ctDate the value for ed_dine_show.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_dine_show.lt_user
     *
     * @return the value of ed_dine_show.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public EdDineShowEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.lt_user
     *
     * @param ltUser the value for ed_dine_show.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_dine_show.lt_date
     *
     * @return the value of ed_dine_show.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public EdDineShowEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_dine_show.lt_date
     *
     * @param ltDate the value for ed_dine_show.lt_date
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