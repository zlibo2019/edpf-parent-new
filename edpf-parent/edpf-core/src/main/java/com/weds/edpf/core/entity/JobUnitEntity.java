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
 * @Description 作业单元信息
 * @Date 2019-05-06
 */
public class JobUnitEntity extends BaseEntity implements Serializable {
    /**
     * 作业编号#1#1#1##
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "作业编号#1#1#1##")
    private String jobId;

    /**
     * 作业名称#1#1#1##
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "作业名称#1#1#1##")
    private String jobName;

    /**
     * 作业路径##1###
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "作业路径##1###")
    private String jobPath;

    /**
     * 频度类型#1#1#1#9#01009
     */
    @Size(max = 10)
    @Dict("01009")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "频度类型#1#1#1#9#01009")
    private String seqType;

    /**
     * 频度公式##1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "频度公式##1###")
    private String seqExpr;

    /**
     * 启动方式#1#1##9#01010
     */
    @Size(max = 10)
    @Dict("01010")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "启动方式#1#1##9#01010")
    private String useType;

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

    private String jobState;

    /**
     * This method returns the value of the database column ed_job_unit.job_id
     *
     * @return the value of ed_job_unit.job_id
     */
    public String getJobId() {
        return jobId;
    }

    /**
     */
    public JobUnitEntity withJobId(String jobId) {
        this.setJobId(jobId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.job_id
     *
     * @param jobId the value for ed_job_unit.job_id
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * This method returns the value of the database column ed_job_unit.job_name
     *
     * @return the value of ed_job_unit.job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     */
    public JobUnitEntity withJobName(String jobName) {
        this.setJobName(jobName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.job_name
     *
     * @param jobName the value for ed_job_unit.job_name
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * This method returns the value of the database column ed_job_unit.job_path
     *
     * @return the value of ed_job_unit.job_path
     */
    public String getJobPath() {
        return jobPath;
    }

    /**
     */
    public JobUnitEntity withJobPath(String jobPath) {
        this.setJobPath(jobPath);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.job_path
     *
     * @param jobPath the value for ed_job_unit.job_path
     */
    public void setJobPath(String jobPath) {
        this.jobPath = jobPath;
    }

    /**
     * This method returns the value of the database column ed_job_unit.seq_type
     *
     * @return the value of ed_job_unit.seq_type
     */
    public String getSeqType() {
        return seqType;
    }

    /**
     */
    public JobUnitEntity withSeqType(String seqType) {
        this.setSeqType(seqType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.seq_type
     *
     * @param seqType the value for ed_job_unit.seq_type
     */
    public void setSeqType(String seqType) {
        this.seqType = seqType;
    }

    /**
     * This method returns the value of the database column ed_job_unit.seq_expr
     *
     * @return the value of ed_job_unit.seq_expr
     */
    public String getSeqExpr() {
        return seqExpr;
    }

    /**
     */
    public JobUnitEntity withSeqExpr(String seqExpr) {
        this.setSeqExpr(seqExpr);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.seq_expr
     *
     * @param seqExpr the value for ed_job_unit.seq_expr
     */
    public void setSeqExpr(String seqExpr) {
        this.seqExpr = seqExpr;
    }

    /**
     * This method returns the value of the database column ed_job_unit.use_type
     *
     * @return the value of ed_job_unit.use_type
     */
    public String getUseType() {
        return useType;
    }

    /**
     */
    public JobUnitEntity withUseType(String useType) {
        this.setUseType(useType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.use_type
     *
     * @param useType the value for ed_job_unit.use_type
     */
    public void setUseType(String useType) {
        this.useType = useType;
    }

    /**
     * This method returns the value of the database column ed_job_unit.use_flag
     *
     * @return the value of ed_job_unit.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public JobUnitEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.use_flag
     *
     * @param useFlag the value for ed_job_unit.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column ed_job_unit.remark
     *
     * @return the value of ed_job_unit.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public JobUnitEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.remark
     *
     * @param remark the value for ed_job_unit.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_job_unit.spare_col1
     *
     * @return the value of ed_job_unit.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public JobUnitEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.spare_col1
     *
     * @param spareCol1 the value for ed_job_unit.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_job_unit.spare_col2
     *
     * @return the value of ed_job_unit.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public JobUnitEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.spare_col2
     *
     * @param spareCol2 the value for ed_job_unit.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_job_unit.spare_col3
     *
     * @return the value of ed_job_unit.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public JobUnitEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.spare_col3
     *
     * @param spareCol3 the value for ed_job_unit.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_job_unit.ct_user
     *
     * @return the value of ed_job_unit.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public JobUnitEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.ct_user
     *
     * @param ctUser the value for ed_job_unit.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_job_unit.ct_date
     *
     * @return the value of ed_job_unit.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public JobUnitEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.ct_date
     *
     * @param ctDate the value for ed_job_unit.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_job_unit.lt_user
     *
     * @return the value of ed_job_unit.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public JobUnitEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.lt_user
     *
     * @param ltUser the value for ed_job_unit.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_job_unit.lt_date
     *
     * @return the value of ed_job_unit.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public JobUnitEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_job_unit.lt_date
     *
     * @param ltDate the value for ed_job_unit.lt_date
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

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }
}