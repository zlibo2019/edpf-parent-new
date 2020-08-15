package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author sxm
 * @Description 用户扩展信息
 * @Date 2019-02-21
 */
public class UserInfoExtendEntity extends BaseEntity implements Serializable {
    /**
     * 用户编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "用户编号")
    private String userSerial;

    /**
     * 用户头像
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "用户头像")
    private String headImage;

    /**
     * 预留字段1
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段3")
    private String spareCol3;

    /**
     * 创建用户
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建用户")
    private String ctUser;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间")
    private String ctDate;

    /**
     * 修改用户
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改用户")
    private String ltUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改时间")
    private String ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column user_info_extend.user_serial
     *
     * @return the value of user_info_extend.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public UserInfoExtendEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.user_serial
     *
     * @param userSerial the value for user_info_extend.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column user_info_extend.head_image
     *
     * @return the value of user_info_extend.head_image
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     */
    public UserInfoExtendEntity withHeadImage(String headImage) {
        this.setHeadImage(headImage);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.head_image
     *
     * @param headImage the value for user_info_extend.head_image
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    /**
     * This method returns the value of the database column user_info_extend.spare_col1
     *
     * @return the value of user_info_extend.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public UserInfoExtendEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.spare_col1
     *
     * @param spareCol1 the value for user_info_extend.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column user_info_extend.spare_col2
     *
     * @return the value of user_info_extend.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public UserInfoExtendEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.spare_col2
     *
     * @param spareCol2 the value for user_info_extend.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column user_info_extend.spare_col3
     *
     * @return the value of user_info_extend.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public UserInfoExtendEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.spare_col3
     *
     * @param spareCol3 the value for user_info_extend.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column user_info_extend.ct_user
     *
     * @return the value of user_info_extend.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public UserInfoExtendEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.ct_user
     *
     * @param ctUser the value for user_info_extend.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column user_info_extend.ct_date
     *
     * @return the value of user_info_extend.ct_date
     */
    public String getCtDate() {
        return ctDate;
    }

    /**
     */
    public UserInfoExtendEntity withCtDate(String ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.ct_date
     *
     * @param ctDate the value for user_info_extend.ct_date
     */
    public void setCtDate(String ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column user_info_extend.lt_user
     *
     * @return the value of user_info_extend.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public UserInfoExtendEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.lt_user
     *
     * @param ltUser the value for user_info_extend.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column user_info_extend.lt_date
     *
     * @return the value of user_info_extend.lt_date
     */
    public String getLtDate() {
        return ltDate;
    }

    /**
     */
    public UserInfoExtendEntity withLtDate(String ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column user_info_extend.lt_date
     *
     * @param ltDate the value for user_info_extend.lt_date
     */
    public void setLtDate(String ltDate) {
        this.ltDate = ltDate;
    }
}