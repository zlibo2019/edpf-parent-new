package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class MjRuleRealEntity extends BaseEntity implements Serializable {
    /**
     * 门禁规则编号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁规则编号")
    private Integer ruleNo;

    /**
     * 门禁规则名称
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门禁规则名称")
    private String ruleName;

    /**
     * 时段个数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "时段个数")
    private Integer ruleCount;

    /**
     * 创建规则的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-25 09:53:30", value = "创建规则的时间")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     * 企业编号
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "企业编号")
    private String regserial;

    private boolean add;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column mj_rule_real.rule_no
     *
     * @return the value of mj_rule_real.rule_no
     */
    public Integer getRuleNo() {
        return ruleNo;
    }

    /**
     */
    public MjRuleRealEntity withRuleNo(Integer ruleNo) {
        this.setRuleNo(ruleNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.rule_no
     *
     * @param ruleNo the value for mj_rule_real.rule_no
     */
    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    /**
     * This method returns the value of the database column mj_rule_real.rule_name
     *
     * @return the value of mj_rule_real.rule_name
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     */
    public MjRuleRealEntity withRuleName(String ruleName) {
        this.setRuleName(ruleName);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.rule_name
     *
     * @param ruleName the value for mj_rule_real.rule_name
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * This method returns the value of the database column mj_rule_real.rule_count
     *
     * @return the value of mj_rule_real.rule_count
     */
    public Integer getRuleCount() {
        return ruleCount;
    }

    /**
     */
    public MjRuleRealEntity withRuleCount(Integer ruleCount) {
        this.setRuleCount(ruleCount);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.rule_count
     *
     * @param ruleCount the value for mj_rule_real.rule_count
     */
    public void setRuleCount(Integer ruleCount) {
        this.ruleCount = ruleCount;
    }

    /**
     * This method returns the value of the database column mj_rule_real.sj
     *
     * @return the value of mj_rule_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjRuleRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.sj
     *
     * @param sj the value for mj_rule_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column mj_rule_real.gly_no
     *
     * @return the value of mj_rule_real.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjRuleRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.gly_no
     *
     * @param glyNo the value for mj_rule_real.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column mj_rule_real.regserial
     *
     * @return the value of mj_rule_real.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public MjRuleRealEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_rule_real.regserial
     *
     * @param regserial the value for mj_rule_real.regserial
     */
    public void setRegserial(String regserial) {
        this.regserial = regserial;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }
}