package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class MjSdRuleRealEntity extends BaseEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 门禁规则编号
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门禁规则编号")
    private String ruleNo;

    /**
     * 时段编号
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "时段编号")
    private String sdNo;

    /**
     * 时段级别（时段在规则中的优先使用排序）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "时段级别（时段在规则中的优先使用排序）")
    private Integer sdLevel;

    /**
     * 创建规则的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-25 09:55:24", value = "创建规则的时间")
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

    /**
     * 时段级别（时段在规则中的优先使用排序）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "时段级别（时段在规则中的优先使用排序）")
    private Integer sdRela;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column mj_sd_rule_real.xh
     *
     * @return the value of mj_sd_rule_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MjSdRuleRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.xh
     *
     * @param xh the value for mj_sd_rule_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.rule_no
     *
     * @return the value of mj_sd_rule_real.rule_no
     */
    public String getRuleNo() {
        return ruleNo;
    }

    /**
     */
    public MjSdRuleRealEntity withRuleNo(String ruleNo) {
        this.setRuleNo(ruleNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.rule_no
     *
     * @param ruleNo the value for mj_sd_rule_real.rule_no
     */
    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.sd_no
     *
     * @return the value of mj_sd_rule_real.sd_no
     */
    public String getSdNo() {
        return sdNo;
    }

    /**
     */
    public MjSdRuleRealEntity withSdNo(String sdNo) {
        this.setSdNo(sdNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.sd_no
     *
     * @param sdNo the value for mj_sd_rule_real.sd_no
     */
    public void setSdNo(String sdNo) {
        this.sdNo = sdNo;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.sd_level
     *
     * @return the value of mj_sd_rule_real.sd_level
     */
    public Integer getSdLevel() {
        return sdLevel;
    }

    /**
     */
    public MjSdRuleRealEntity withSdLevel(Integer sdLevel) {
        this.setSdLevel(sdLevel);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.sd_level
     *
     * @param sdLevel the value for mj_sd_rule_real.sd_level
     */
    public void setSdLevel(Integer sdLevel) {
        this.sdLevel = sdLevel;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.sj
     *
     * @return the value of mj_sd_rule_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjSdRuleRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.sj
     *
     * @param sj the value for mj_sd_rule_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.gly_no
     *
     * @return the value of mj_sd_rule_real.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjSdRuleRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.gly_no
     *
     * @param glyNo the value for mj_sd_rule_real.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.regserial
     *
     * @return the value of mj_sd_rule_real.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public MjSdRuleRealEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.regserial
     *
     * @param regserial the value for mj_sd_rule_real.regserial
     */
    public void setRegserial(String regserial) {
        this.regserial = regserial;
    }

    /**
     * This method returns the value of the database column mj_sd_rule_real.sd_rela
     *
     * @return the value of mj_sd_rule_real.sd_rela
     */
    public Integer getSdRela() {
        return sdRela;
    }

    /**
     */
    public MjSdRuleRealEntity withSdRela(Integer sdRela) {
        this.setSdRela(sdRela);
        return this;
    }

    /**
     * This method sets the value of the database column mj_sd_rule_real.sd_rela
     *
     * @param sdRela the value for mj_sd_rule_real.sd_rela
     */
    public void setSdRela(Integer sdRela) {
        this.sdRela = sdRela;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}