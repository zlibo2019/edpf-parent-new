package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 角色信息
 * @Date 2019-03-07
 */
public class RoleInfoEntity extends BaseEntity implements Serializable {
    /**
     *   角色编号#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "角色编号#1#1##")
    private String roleId;

    /**
     *   角色名称#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "角色名称#1#1##")
    private String roleName;

    /**
     *   所属系统#1#1#2#
     *
     */
    @Dict("01003")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "所属系统#1#1#2#")
    private String roleSys;

    /**
     *   是否启用#1#1#9#01001
     *
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "是否启用#1#1#9#01001")
    private String useFlag;

    /**
     *   备注##1#1#
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "备注##1#1#")
    private String remark;

    /**
     *   预留字段1####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段1####")
    private String spareCol1;

    /**
     *   预留字段2####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段2####")
    private String spareCol2;

    /**
     *   预留字段3####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "预留字段3####")
    private String spareCol3;

    /**
     *   创建用户####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建用户####")
    private String ctUser;

    /**
     *   创建时间####
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间####")
    private Date ctDate;

    /**
     *   修改用户####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改用户####")
    private String ltUser;

    /**
     *   修改时间####
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改时间####")
    private Date ltDate;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    private String functions;

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    /**
     * This method returns the value of the database column ed_role_info.role_id
     *
     * @return the value of ed_role_info.role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     */
    public RoleInfoEntity withRoleId(String roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.role_id
     *
     * @param roleId the value for ed_role_info.role_id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column ed_role_info.role_name
     *
     * @return the value of ed_role_info.role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     */
    public RoleInfoEntity withRoleName(String roleName) {
        this.setRoleName(roleName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.role_name
     *
     * @param roleName the value for ed_role_info.role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method returns the value of the database column ed_role_info.role_sys
     *
     * @return the value of ed_role_info.role_sys
     */
    public String getRoleSys() {
        return roleSys;
    }

    /**
     */
    public RoleInfoEntity withRoleSys(String roleSys) {
        this.setRoleSys(roleSys);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.role_sys
     *
     * @param roleSys the value for ed_role_info.role_sys
     */
    public void setRoleSys(String roleSys) {
        this.roleSys = roleSys;
    }

    /**
     * This method returns the value of the database column ed_role_info.use_flag
     *
     * @return the value of ed_role_info.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public RoleInfoEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.use_flag
     *
     * @param useFlag the value for ed_role_info.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_role_info.remark
     *
     * @return the value of ed_role_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public RoleInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.remark
     *
     * @param remark the value for ed_role_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_role_info.spare_col1
     *
     * @return the value of ed_role_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RoleInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.spare_col1
     *
     * @param spareCol1 the value for ed_role_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_role_info.spare_col2
     *
     * @return the value of ed_role_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RoleInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.spare_col2
     *
     * @param spareCol2 the value for ed_role_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_role_info.spare_col3
     *
     * @return the value of ed_role_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RoleInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.spare_col3
     *
     * @param spareCol3 the value for ed_role_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_role_info.ct_user
     *
     * @return the value of ed_role_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RoleInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.ct_user
     *
     * @param ctUser the value for ed_role_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_role_info.ct_date
     *
     * @return the value of ed_role_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RoleInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.ct_date
     *
     * @param ctDate the value for ed_role_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_role_info.lt_user
     *
     * @return the value of ed_role_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public RoleInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.lt_user
     *
     * @param ltUser the value for ed_role_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_role_info.lt_date
     *
     * @return the value of ed_role_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public RoleInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_info.lt_date
     *
     * @param ltDate the value for ed_role_info.lt_date
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