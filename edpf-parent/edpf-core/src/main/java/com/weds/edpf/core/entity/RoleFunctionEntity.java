package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 角色功能关系
 * @Date 2019-03-08
 */
public class RoleFunctionEntity extends BaseEntity implements Serializable {
    /**
     *   角色编号####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "角色编号####")
    private String roleId;

    /**
     *   功能编号####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能编号####")
    private String functionId;

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

    /**
     * This method returns the value of the database column ed_role_function.role_id
     *
     * @return the value of ed_role_function.role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     */
    public RoleFunctionEntity withRoleId(String roleId) {
        this.setRoleId(roleId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.role_id
     *
     * @param roleId the value for ed_role_function.role_id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column ed_role_function.function_id
     *
     * @return the value of ed_role_function.function_id
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     */
    public RoleFunctionEntity withFunctionId(String functionId) {
        this.setFunctionId(functionId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.function_id
     *
     * @param functionId the value for ed_role_function.function_id
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    /**
     * This method returns the value of the database column ed_role_function.spare_col1
     *
     * @return the value of ed_role_function.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RoleFunctionEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.spare_col1
     *
     * @param spareCol1 the value for ed_role_function.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_role_function.spare_col2
     *
     * @return the value of ed_role_function.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RoleFunctionEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.spare_col2
     *
     * @param spareCol2 the value for ed_role_function.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_role_function.spare_col3
     *
     * @return the value of ed_role_function.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RoleFunctionEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.spare_col3
     *
     * @param spareCol3 the value for ed_role_function.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_role_function.ct_user
     *
     * @return the value of ed_role_function.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RoleFunctionEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.ct_user
     *
     * @param ctUser the value for ed_role_function.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_role_function.ct_date
     *
     * @return the value of ed_role_function.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RoleFunctionEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.ct_date
     *
     * @param ctDate the value for ed_role_function.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_role_function.lt_user
     *
     * @return the value of ed_role_function.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public RoleFunctionEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.lt_user
     *
     * @param ltUser the value for ed_role_function.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_role_function.lt_date
     *
     * @return the value of ed_role_function.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public RoleFunctionEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_role_function.lt_date
     *
     * @param ltDate the value for ed_role_function.lt_date
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