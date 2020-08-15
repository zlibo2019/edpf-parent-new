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
 * @Description 报表模板管理
 * @Date 2019-05-13
 */
public class RptInfoEntity extends BaseEntity implements Serializable {
    /**
     * 报表编号#1#1#1##
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表编号#1#1#1##")
    private String rptId;

    /**
     * 报表名称#1#1#1##
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表名称#1#1#1##")
    private String rptName;

    /**
     * 报表类型#1#1#1#9#01010
     */
    @Size(max = 10)
    @Dict("01010")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表类型#1#1#1#9#01010")
    private String rptType;

    /**
     * 报表模板#1#1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表模板#1#1###")
    private String rptTemplate;

    /**
     * 报表版本#1#1###
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "报表版本#1#1###")
    private String rptVersion;

    /**
     * 是否启用#1#1##9#01001
     */
    @Size(max = 10)
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用#1#1##9#01001")
    private String useFlag;

    /**
     * 备注##1##1#
     */
    @Size(max = 1000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注##1##1#")
    private String remark;

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

    /**
     * This method returns the value of the database column ed_rpt_info.rpt_id
     *
     * @return the value of ed_rpt_info.rpt_id
     */
    public String getRptId() {
        return rptId;
    }

    /**
     */
    public RptInfoEntity withRptId(String rptId) {
        this.setRptId(rptId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.rpt_id
     *
     * @param rptId the value for ed_rpt_info.rpt_id
     */
    public void setRptId(String rptId) {
        this.rptId = rptId;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.rpt_name
     *
     * @return the value of ed_rpt_info.rpt_name
     */
    public String getRptName() {
        return rptName;
    }

    /**
     */
    public RptInfoEntity withRptName(String rptName) {
        this.setRptName(rptName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.rpt_name
     *
     * @param rptName the value for ed_rpt_info.rpt_name
     */
    public void setRptName(String rptName) {
        this.rptName = rptName;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.rpt_type
     *
     * @return the value of ed_rpt_info.rpt_type
     */
    public String getRptType() {
        return rptType;
    }

    /**
     */
    public RptInfoEntity withRptType(String rptType) {
        this.setRptType(rptType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.rpt_type
     *
     * @param rptType the value for ed_rpt_info.rpt_type
     */
    public void setRptType(String rptType) {
        this.rptType = rptType;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.rpt_template
     *
     * @return the value of ed_rpt_info.rpt_template
     */
    public String getRptTemplate() {
        return rptTemplate;
    }

    /**
     */
    public RptInfoEntity withRptTemplate(String rptTemplate) {
        this.setRptTemplate(rptTemplate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.rpt_template
     *
     * @param rptTemplate the value for ed_rpt_info.rpt_template
     */
    public void setRptTemplate(String rptTemplate) {
        this.rptTemplate = rptTemplate;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.rpt_version
     *
     * @return the value of ed_rpt_info.rpt_version
     */
    public String getRptVersion() {
        return rptVersion;
    }

    /**
     */
    public RptInfoEntity withRptVersion(String rptVersion) {
        this.setRptVersion(rptVersion);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.rpt_version
     *
     * @param rptVersion the value for ed_rpt_info.rpt_version
     */
    public void setRptVersion(String rptVersion) {
        this.rptVersion = rptVersion;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.use_flag
     *
     * @return the value of ed_rpt_info.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public RptInfoEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.use_flag
     *
     * @param useFlag the value for ed_rpt_info.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.remark
     *
     * @return the value of ed_rpt_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public RptInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.remark
     *
     * @param remark the value for ed_rpt_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.spare_col1
     *
     * @return the value of ed_rpt_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public RptInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.spare_col1
     *
     * @param spareCol1 the value for ed_rpt_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.spare_col2
     *
     * @return the value of ed_rpt_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public RptInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.spare_col2
     *
     * @param spareCol2 the value for ed_rpt_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.spare_col3
     *
     * @return the value of ed_rpt_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public RptInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.spare_col3
     *
     * @param spareCol3 the value for ed_rpt_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.ct_user
     *
     * @return the value of ed_rpt_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public RptInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.ct_user
     *
     * @param ctUser the value for ed_rpt_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.ct_date
     *
     * @return the value of ed_rpt_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public RptInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.ct_date
     *
     * @param ctDate the value for ed_rpt_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.lt_user
     *
     * @return the value of ed_rpt_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public RptInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.lt_user
     *
     * @param ltUser the value for ed_rpt_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_rpt_info.lt_date
     *
     * @return the value of ed_rpt_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public RptInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_rpt_info.lt_date
     *
     * @param ltDate the value for ed_rpt_info.lt_date
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