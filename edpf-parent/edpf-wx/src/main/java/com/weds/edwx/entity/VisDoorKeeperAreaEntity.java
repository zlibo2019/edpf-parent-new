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
 * @Description 门卫用户区域管理
 * @Date 2019-04-17
 */
public class VisDoorKeeperAreaEntity extends BaseEntity implements Serializable {
    /**
     *   用户编号
     *
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号")
    private String userNo;

    /**
     *   区域编号
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "区域编号")
    private String areaNo;

    /**
     *   默认选中
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "默认选中")
    private String useFlag;

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

    private String areaName;
    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.user_no
     *
     * @return the value of vis_door_keeper_area.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.user_no
     *
     * @param userNo the value for vis_door_keeper_area.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.area_no
     *
     * @return the value of vis_door_keeper_area.area_no
     */
    public String getAreaNo() {
        return areaNo;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withAreaNo(String areaNo) {
        this.setAreaNo(areaNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.area_no
     *
     * @param areaNo the value for vis_door_keeper_area.area_no
     */
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.use_flag
     *
     * @return the value of vis_door_keeper_area.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.use_flag
     *
     * @param useFlag the value for vis_door_keeper_area.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col1
     *
     * @return the value of vis_door_keeper_area.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col1
     *
     * @param spareCol1 the value for vis_door_keeper_area.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col2
     *
     * @return the value of vis_door_keeper_area.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col2
     *
     * @param spareCol2 the value for vis_door_keeper_area.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col3
     *
     * @return the value of vis_door_keeper_area.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col3
     *
     * @param spareCol3 the value for vis_door_keeper_area.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col4
     *
     * @return the value of vis_door_keeper_area.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col4
     *
     * @param spareCol4 the value for vis_door_keeper_area.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col5
     *
     * @return the value of vis_door_keeper_area.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col5
     *
     * @param spareCol5 the value for vis_door_keeper_area.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.spare_col6
     *
     * @return the value of vis_door_keeper_area.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.spare_col6
     *
     * @param spareCol6 the value for vis_door_keeper_area.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.ct_user
     *
     * @return the value of vis_door_keeper_area.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.ct_user
     *
     * @param ctUser the value for vis_door_keeper_area.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column vis_door_keeper_area.ct_date
     *
     * @return the value of vis_door_keeper_area.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public VisDoorKeeperAreaEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper_area.ct_date
     *
     * @param ctDate the value for vis_door_keeper_area.ct_date
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