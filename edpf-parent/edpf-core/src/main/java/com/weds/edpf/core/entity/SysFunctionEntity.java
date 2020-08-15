package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 权限管理
 * @Date 2019-03-07
 */
public class SysFunctionEntity extends BaseEntity implements Serializable {
    /**
     *   功能编号#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能编号#1#1##")
    private String functionId;

    /**
     *   功能名称#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能名称#1#1##")
    private String functionName;

    /**
     *   功能类型#1#1#9#01002
     *
     */
    @Dict("01002")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能类型#1#1#9#01002")
    private String functionType;

    /**
     *   功能图标#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能图标#1#1##")
    private String functionIcon;

    /**
     *   功能地址##1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "功能地址##1##")
    private String functionUrl;

    /**
     *   所属区域##1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "所属区域##1##")
    private String functionArea;

    /**
     *   所属模块##1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "所属模块##1##")
    private String functionModule;

    /**
     *   所属系统#2#1##01003
     *
     */
    @Dict("01003")
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "所属系统#2#1##01003")
    private String functionSys;

    /**
     *   上级功能#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "上级功能#1#1##")
    private String parentFunction;

    /**
     *   功能序号##1##
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "功能序号##1##")
    private Integer functionIndex;

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

    private Integer userSerial;

    private String leaf;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endDate;

    private String sqlKey;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_sys_function.function_id
     *
     * @return the value of ed_sys_function.function_id
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     */
    public SysFunctionEntity withFunctionId(String functionId) {
        this.setFunctionId(functionId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_id
     *
     * @param functionId the value for ed_sys_function.function_id
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_name
     *
     * @return the value of ed_sys_function.function_name
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     */
    public SysFunctionEntity withFunctionName(String functionName) {
        this.setFunctionName(functionName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_name
     *
     * @param functionName the value for ed_sys_function.function_name
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_type
     *
     * @return the value of ed_sys_function.function_type
     */
    public String getFunctionType() {
        return functionType;
    }

    /**
     */
    public SysFunctionEntity withFunctionType(String functionType) {
        this.setFunctionType(functionType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_type
     *
     * @param functionType the value for ed_sys_function.function_type
     */
    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_icon
     *
     * @return the value of ed_sys_function.function_icon
     */
    public String getFunctionIcon() {
        return functionIcon;
    }

    /**
     */
    public SysFunctionEntity withFunctionIcon(String functionIcon) {
        this.setFunctionIcon(functionIcon);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_icon
     *
     * @param functionIcon the value for ed_sys_function.function_icon
     */
    public void setFunctionIcon(String functionIcon) {
        this.functionIcon = functionIcon;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_url
     *
     * @return the value of ed_sys_function.function_url
     */
    public String getFunctionUrl() {
        return functionUrl;
    }

    /**
     */
    public SysFunctionEntity withFunctionUrl(String functionUrl) {
        this.setFunctionUrl(functionUrl);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_url
     *
     * @param functionUrl the value for ed_sys_function.function_url
     */
    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_area
     *
     * @return the value of ed_sys_function.function_area
     */
    public String getFunctionArea() {
        return functionArea;
    }

    /**
     */
    public SysFunctionEntity withFunctionArea(String functionArea) {
        this.setFunctionArea(functionArea);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_area
     *
     * @param functionArea the value for ed_sys_function.function_area
     */
    public void setFunctionArea(String functionArea) {
        this.functionArea = functionArea;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_module
     *
     * @return the value of ed_sys_function.function_module
     */
    public String getFunctionModule() {
        return functionModule;
    }

    /**
     */
    public SysFunctionEntity withFunctionModule(String functionModule) {
        this.setFunctionModule(functionModule);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_module
     *
     * @param functionModule the value for ed_sys_function.function_module
     */
    public void setFunctionModule(String functionModule) {
        this.functionModule = functionModule;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_sys
     *
     * @return the value of ed_sys_function.function_sys
     */
    public String getFunctionSys() {
        return functionSys;
    }

    /**
     */
    public SysFunctionEntity withFunctionSys(String functionSys) {
        this.setFunctionSys(functionSys);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_sys
     *
     * @param functionSys the value for ed_sys_function.function_sys
     */
    public void setFunctionSys(String functionSys) {
        this.functionSys = functionSys;
    }

    /**
     * This method returns the value of the database column ed_sys_function.parent_function
     *
     * @return the value of ed_sys_function.parent_function
     */
    public String getParentFunction() {
        return parentFunction;
    }

    /**
     */
    public SysFunctionEntity withParentFunction(String parentFunction) {
        this.setParentFunction(parentFunction);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.parent_function
     *
     * @param parentFunction the value for ed_sys_function.parent_function
     */
    public void setParentFunction(String parentFunction) {
        this.parentFunction = parentFunction;
    }

    /**
     * This method returns the value of the database column ed_sys_function.function_index
     *
     * @return the value of ed_sys_function.function_index
     */
    public Integer getFunctionIndex() {
        return functionIndex;
    }

    /**
     */
    public SysFunctionEntity withFunctionIndex(Integer functionIndex) {
        this.setFunctionIndex(functionIndex);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.function_index
     *
     * @param functionIndex the value for ed_sys_function.function_index
     */
    public void setFunctionIndex(Integer functionIndex) {
        this.functionIndex = functionIndex;
    }

    /**
     * This method returns the value of the database column ed_sys_function.use_flag
     *
     * @return the value of ed_sys_function.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public SysFunctionEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.use_flag
     *
     * @param useFlag the value for ed_sys_function.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_sys_function.remark
     *
     * @return the value of ed_sys_function.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public SysFunctionEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.remark
     *
     * @param remark the value for ed_sys_function.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_sys_function.spare_col1
     *
     * @return the value of ed_sys_function.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public SysFunctionEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.spare_col1
     *
     * @param spareCol1 the value for ed_sys_function.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_sys_function.spare_col2
     *
     * @return the value of ed_sys_function.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public SysFunctionEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.spare_col2
     *
     * @param spareCol2 the value for ed_sys_function.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_sys_function.spare_col3
     *
     * @return the value of ed_sys_function.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public SysFunctionEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.spare_col3
     *
     * @param spareCol3 the value for ed_sys_function.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_sys_function.ct_user
     *
     * @return the value of ed_sys_function.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public SysFunctionEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.ct_user
     *
     * @param ctUser the value for ed_sys_function.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_sys_function.ct_date
     *
     * @return the value of ed_sys_function.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public SysFunctionEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.ct_date
     *
     * @param ctDate the value for ed_sys_function.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_sys_function.lt_user
     *
     * @return the value of ed_sys_function.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public SysFunctionEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.lt_user
     *
     * @param ltUser the value for ed_sys_function.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_sys_function.lt_date
     *
     * @return the value of ed_sys_function.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public SysFunctionEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_function.lt_date
     *
     * @param ltDate the value for ed_sys_function.lt_date
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

    public Integer getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSqlKey() {
        return sqlKey;
    }

    public void setSqlKey(String sqlKey) {
        this.sqlKey = sqlKey;
    }
}