package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 用户角色关系
 * @Date 2019-03-07
 */
public class UserRoleEntity extends BaseEntity implements Serializable {
    /**
     * 用户编号####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "用户编号####")
    private String userSerial;

    /**
     * 角色编号####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "角色编号####")
    private String roleId;

    /**
     * 预留字段1####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段1####")
    private String spareCol1;

    /**
     * 预留字段2####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段2####")
    private String spareCol2;

    /**
     * 预留字段3####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段3####")
    private String spareCol3;

    /**
     * 创建用户####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建用户####")
    private String ctUser;

    /**
     * 创建时间####
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间####")
    private Date ctDate;

    /**
     * 修改用户####
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改用户####")
    private String ltUser;

    /**
     * 修改时间####
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改时间####")
    private Date ltDate;

    private String userSerials;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_user_role.user_serial
     *
     * @return the value of ed_user_role.user_serial
     */
    public String getUserSerial() {
        return userSerial;
    }

    /**
     */
    public UserRoleEntity withUserSerial(String userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.user_serial
     *
     * @param userSerial the value for ed_user_role.user_serial
     */
    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column ed_user_role.role_id
     *
     * @return the value of ed_user_role.role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     */
    public UserRoleEntity withRoleId(String roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.role_id
     *
     * @param roleId the value for ed_user_role.role_id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column ed_user_role.spare_col1
     *
     * @return the value of ed_user_role.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public UserRoleEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.spare_col1
     *
     * @param spareCol1 the value for ed_user_role.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_user_role.spare_col2
     *
     * @return the value of ed_user_role.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public UserRoleEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.spare_col2
     *
     * @param spareCol2 the value for ed_user_role.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_user_role.spare_col3
     *
     * @return the value of ed_user_role.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public UserRoleEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.spare_col3
     *
     * @param spareCol3 the value for ed_user_role.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_user_role.ct_user
     *
     * @return the value of ed_user_role.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public UserRoleEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.ct_user
     *
     * @param ctUser the value for ed_user_role.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_user_role.ct_date
     *
     * @return the value of ed_user_role.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public UserRoleEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.ct_date
     *
     * @param ctDate the value for ed_user_role.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_user_role.lt_user
     *
     * @return the value of ed_user_role.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public UserRoleEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.lt_user
     *
     * @param ltUser the value for ed_user_role.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_user_role.lt_date
     *
     * @return the value of ed_user_role.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public UserRoleEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_role.lt_date
     *
     * @param ltDate the value for ed_user_role.lt_date
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

    public String getUserSerials() {
        return userSerials;
    }

    public void setUserSerials(String userSerials) {
        this.userSerials = userSerials;
    }
}