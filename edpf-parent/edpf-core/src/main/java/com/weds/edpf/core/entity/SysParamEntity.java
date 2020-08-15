package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sxm
 * @Description 系统参数
 * @Date 2019-03-07
 */
public class SysParamEntity extends BaseEntity implements Serializable {
    /**
     *   参数键#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "参数键#1#1##")
    private String paramKey;

    /**
     *   参数名称#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "参数名称#1#1##")
    private String paramName;

    /**
     *   参数值#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "参数值#1#1##")
    private String paramValue;

    /**
     *   所属模块#1#1##
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "所属模块#1#1##")
    private String paramTarget;

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
     *   创建者####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建者####")
    private String ctUserId;

    /**
     *   创建时间####
     *
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "创建时间####")
    private Date ctDate;

    /**
     *   修改者####
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "修改者####")
    private String ltUserId;

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
     * This method returns the value of the database column ed_sys_param.param_key
     *
     * @return the value of ed_sys_param.param_key
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     */
    public SysParamEntity withParamKey(String paramKey) {
        this.setParamKey(paramKey);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.param_key
     *
     * @param paramKey the value for ed_sys_param.param_key
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * This method returns the value of the database column ed_sys_param.param_name
     *
     * @return the value of ed_sys_param.param_name
     */
    public String getParamName() {
        return paramName;
    }

    /**
     */
    public SysParamEntity withParamName(String paramName) {
        this.setParamName(paramName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.param_name
     *
     * @param paramName the value for ed_sys_param.param_name
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * This method returns the value of the database column ed_sys_param.param_value
     *
     * @return the value of ed_sys_param.param_value
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     */
    public SysParamEntity withParamValue(String paramValue) {
        this.setParamValue(paramValue);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.param_value
     *
     * @param paramValue the value for ed_sys_param.param_value
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * This method returns the value of the database column ed_sys_param.param_target
     *
     * @return the value of ed_sys_param.param_target
     */
    public String getParamTarget() {
        return paramTarget;
    }

    /**
     */
    public SysParamEntity withParamTarget(String paramTarget) {
        this.setParamTarget(paramTarget);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.param_target
     *
     * @param paramTarget the value for ed_sys_param.param_target
     */
    public void setParamTarget(String paramTarget) {
        this.paramTarget = paramTarget;
    }

    /**
     * This method returns the value of the database column ed_sys_param.use_flag
     *
     * @return the value of ed_sys_param.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public SysParamEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.use_flag
     *
     * @param useFlag the value for ed_sys_param.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_sys_param.remark
     *
     * @return the value of ed_sys_param.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public SysParamEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.remark
     *
     * @param remark the value for ed_sys_param.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_sys_param.ct_user_id
     *
     * @return the value of ed_sys_param.ct_user_id
     */
    public String getCtUserId() {
        return ctUserId;
    }

    /**
     */
    public SysParamEntity withCtUserId(String ctUserId) {
        this.setCtUserId(ctUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.ct_user_id
     *
     * @param ctUserId the value for ed_sys_param.ct_user_id
     */
    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId;
    }

    /**
     * This method returns the value of the database column ed_sys_param.ct_date
     *
     * @return the value of ed_sys_param.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public SysParamEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.ct_date
     *
     * @param ctDate the value for ed_sys_param.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_sys_param.lt_user_id
     *
     * @return the value of ed_sys_param.lt_user_id
     */
    public String getLtUserId() {
        return ltUserId;
    }

    /**
     */
    public SysParamEntity withLtUserId(String ltUserId) {
        this.setLtUserId(ltUserId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.lt_user_id
     *
     * @param ltUserId the value for ed_sys_param.lt_user_id
     */
    public void setLtUserId(String ltUserId) {
        this.ltUserId = ltUserId;
    }

    /**
     * This method returns the value of the database column ed_sys_param.lt_date
     *
     * @return the value of ed_sys_param.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public SysParamEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_sys_param.lt_date
     *
     * @param ltDate the value for ed_sys_param.lt_date
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