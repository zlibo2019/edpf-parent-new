package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 报表模板参数
 * @Date 2019-05-15
 */
public class RptParamsEntity extends BaseEntity implements Serializable {
    /**
     * 报表编号#1#1#1##
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表编号#1#1#1##")
    private String rptId;

    /**
     * 参数类型#1#1#1#9#01011
     */
    @Size(max = 10)
    @Dict("01011")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数类型#1#1#1#9#01011")
    private String paramType;

    /**
     * 参数名称#1#1#1##
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数名称#1#1#1##")
    private String paramName;

    /**
     * 参数说明#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数说明#1#1###")
    private String paramDesc;

    /**
     * 参数值#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "参数值#1#1###")
    private String paramVal;

    /**
     * 是否启用#1#1##9#01001
     */
    @Size(max = 10)
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用#1#1##9#01001")
    private String useFlag;

    private int paramIdx;

    /**
     * 预留字段1
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

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
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_rpt_params.rpt_id
     *
     * @return the value of ed_rpt_params.rpt_id
     */
    public String getRptId() {
        return rptId;
    }

    /**
     */
    public RptParamsEntity withRptId(String rptId) {
        this.setRptId(rptId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.rpt_id
     *
     * @param rptId the value for ed_rpt_params.rpt_id
     */
    public void setRptId(String rptId) {
        this.rptId = rptId;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.param_type
     *
     * @return the value of ed_rpt_params.param_type
     */
    public String getParamType() {
        return paramType;
    }

    /**
     */
    public RptParamsEntity withParamType(String paramType) {
        this.setParamType(paramType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.param_type
     *
     * @param paramType the value for ed_rpt_params.param_type
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.param_name
     *
     * @return the value of ed_rpt_params.param_name
     */
    public String getParamName() {
        return paramName;
    }

    /**
     */
    public RptParamsEntity withParamName(String paramName) {
        this.setParamName(paramName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.param_name
     *
     * @param paramName the value for ed_rpt_params.param_name
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.param_desc
     *
     * @return the value of ed_rpt_params.param_desc
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     */
    public RptParamsEntity withParamDesc(String paramDesc) {
        this.setParamDesc(paramDesc);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.param_desc
     *
     * @param paramDesc the value for ed_rpt_params.param_desc
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.param_val
     *
     * @return the value of ed_rpt_params.param_val
     */
    public String getParamVal() {
        return paramVal;
    }

    /**
     */
    public RptParamsEntity withParamVal(String paramVal) {
        this.setParamVal(paramVal);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.param_val
     *
     * @param paramVal the value for ed_rpt_params.param_val
     */
    public void setParamVal(String paramVal) {
        this.paramVal = paramVal;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.use_flag
     *
     * @return the value of ed_rpt_params.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public RptParamsEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    public int getParamIdx() {
        return paramIdx;
    }

    public void setParamIdx(int paramIdx) {
        this.paramIdx = paramIdx;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.use_flag
     *
     * @param useFlag the value for ed_rpt_params.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.spare_col1
     *
     * @return the value of ed_rpt_params.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RptParamsEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.spare_col1
     *
     * @param spareCol1 the value for ed_rpt_params.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.spare_col2
     *
     * @return the value of ed_rpt_params.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RptParamsEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.spare_col2
     *
     * @param spareCol2 the value for ed_rpt_params.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.spare_col3
     *
     * @return the value of ed_rpt_params.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RptParamsEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.spare_col3
     *
     * @param spareCol3 the value for ed_rpt_params.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.ct_user
     *
     * @return the value of ed_rpt_params.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RptParamsEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.ct_user
     *
     * @param ctUser the value for ed_rpt_params.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_rpt_params.ct_date
     *
     * @return the value of ed_rpt_params.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RptParamsEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_params.ct_date
     *
     * @param ctDate the value for ed_rpt_params.ct_date
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