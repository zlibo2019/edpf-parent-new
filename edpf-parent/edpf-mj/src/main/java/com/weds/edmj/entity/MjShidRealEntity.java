package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class MjShidRealEntity extends BaseEntity implements Serializable {
    /**
     * 新时段编号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "新时段编号")
    private Integer bh;

    /**
     * 时段名称#1#1#1#0#
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "时段名称#1#1#1#0#")
    private String sdName;

    /**
     * 有效开始日期#1#1##6#
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-25 09:56:50", value = "有效开始日期#1#1##6#")
    private Date kssj;

    /**
     * 有效结束日期#1#1##6#
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-25 09:56:50", value = "有效结束日期#1#1##6#")
    private Date jssj;

    /**
     * 开始月份#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "开始月份#1#1##0#")
    private Integer ksMonth;

    /**
     * 结束月份#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "结束月份#1#1##0#")
    private Integer jsMonth;

    /**
     * 开始日期#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "开始日期#1#1##0#")
    private Integer ksDay;

    /**
     * 结束日期#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "结束日期#1#1##0#")
    private Integer jsDay;

    /**
     * 开始星期#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "开始星期#1#1##0#")
    private Integer ksWeek;

    /**
     * 结束星期#1#1##0#
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "结束星期#1#1##0#")
    private Integer jsWeek;

    /**
     * 开始时间#1#1##0#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "开始时间#1#1##0#")
    private String ksSj1;

    /**
     * 结束时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "结束时间#1#1##7#")
    private String jsSj1;

    /**
     * 开始时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "开始时间#1#1##7#")
    private String ksSj2;

    /**
     * 结束时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "结束时间#1#1##7#")
    private String jsSj2;

    /**
     * 创建时段的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-25 09:56:50", value = "创建时段的时间")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     * 开始时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "开始时间#1#1##7#")
    private String ksSj3;

    /**
     * 结束时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "结束时间#1#1##7#")
    private String jsSj3;

    /**
     * 开始时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "开始时间#1#1##7#")
    private String ksSj4;

    /**
     * 结束时间#1#1##7#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "结束时间#1#1##7#")
    private String jsSj4;

    /**
     * 企业编号
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "企业编号")
    private String regserial;


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
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column mj_shid_real.bh
     *
     * @return the value of mj_shid_real.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public MjShidRealEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.bh
     *
     * @param bh the value for mj_shid_real.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column mj_shid_real.sd_name
     *
     * @return the value of mj_shid_real.sd_name
     */
    public String getSdName() {
        return sdName;
    }

    /**
     */
    public MjShidRealEntity withSdName(String sdName) {
        this.setSdName(sdName);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.sd_name
     *
     * @param sdName the value for mj_shid_real.sd_name
     */
    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    /**
     * This method returns the value of the database column mj_shid_real.kssj
     *
     * @return the value of mj_shid_real.kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     */
    public MjShidRealEntity withKssj(Date kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.kssj
     *
     * @param kssj the value for mj_shid_real.kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column mj_shid_real.jssj
     *
     * @return the value of mj_shid_real.jssj
     */
    public Date getJssj() {
        return jssj;
    }

    /**
     */
    public MjShidRealEntity withJssj(Date jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.jssj
     *
     * @param jssj the value for mj_shid_real.jssj
     */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_month
     *
     * @return the value of mj_shid_real.ks_month
     */
    public Integer getKsMonth() {
        return ksMonth;
    }

    /**
     */
    public MjShidRealEntity withKsMonth(Integer ksMonth) {
        this.setKsMonth(ksMonth);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_month
     *
     * @param ksMonth the value for mj_shid_real.ks_month
     */
    public void setKsMonth(Integer ksMonth) {
        this.ksMonth = ksMonth;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_month
     *
     * @return the value of mj_shid_real.js_month
     */
    public Integer getJsMonth() {
        return jsMonth;
    }

    /**
     */
    public MjShidRealEntity withJsMonth(Integer jsMonth) {
        this.setJsMonth(jsMonth);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_month
     *
     * @param jsMonth the value for mj_shid_real.js_month
     */
    public void setJsMonth(Integer jsMonth) {
        this.jsMonth = jsMonth;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_day
     *
     * @return the value of mj_shid_real.ks_day
     */
    public Integer getKsDay() {
        return ksDay;
    }

    /**
     */
    public MjShidRealEntity withKsDay(Integer ksDay) {
        this.setKsDay(ksDay);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_day
     *
     * @param ksDay the value for mj_shid_real.ks_day
     */
    public void setKsDay(Integer ksDay) {
        this.ksDay = ksDay;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_day
     *
     * @return the value of mj_shid_real.js_day
     */
    public Integer getJsDay() {
        return jsDay;
    }

    /**
     */
    public MjShidRealEntity withJsDay(Integer jsDay) {
        this.setJsDay(jsDay);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_day
     *
     * @param jsDay the value for mj_shid_real.js_day
     */
    public void setJsDay(Integer jsDay) {
        this.jsDay = jsDay;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_week
     *
     * @return the value of mj_shid_real.ks_week
     */
    public Integer getKsWeek() {
        return ksWeek;
    }

    /**
     */
    public MjShidRealEntity withKsWeek(Integer ksWeek) {
        this.setKsWeek(ksWeek);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_week
     *
     * @param ksWeek the value for mj_shid_real.ks_week
     */
    public void setKsWeek(Integer ksWeek) {
        this.ksWeek = ksWeek;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_week
     *
     * @return the value of mj_shid_real.js_week
     */
    public Integer getJsWeek() {
        return jsWeek;
    }

    /**
     */
    public MjShidRealEntity withJsWeek(Integer jsWeek) {
        this.setJsWeek(jsWeek);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_week
     *
     * @param jsWeek the value for mj_shid_real.js_week
     */
    public void setJsWeek(Integer jsWeek) {
        this.jsWeek = jsWeek;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_sj1
     *
     * @return the value of mj_shid_real.ks_sj1
     */
    public String getKsSj1() {
        return ksSj1;
    }

    /**
     */
    public MjShidRealEntity withKsSj1(String ksSj1) {
        this.setKsSj1(ksSj1);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_sj1
     *
     * @param ksSj1 the value for mj_shid_real.ks_sj1
     */
    public void setKsSj1(String ksSj1) {
        this.ksSj1 = ksSj1;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_sj1
     *
     * @return the value of mj_shid_real.js_sj1
     */
    public String getJsSj1() {
        return jsSj1;
    }

    /**
     */
    public MjShidRealEntity withJsSj1(String jsSj1) {
        this.setJsSj1(jsSj1);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_sj1
     *
     * @param jsSj1 the value for mj_shid_real.js_sj1
     */
    public void setJsSj1(String jsSj1) {
        this.jsSj1 = jsSj1;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_sj2
     *
     * @return the value of mj_shid_real.ks_sj2
     */
    public String getKsSj2() {
        return ksSj2;
    }

    /**
     */
    public MjShidRealEntity withKsSj2(String ksSj2) {
        this.setKsSj2(ksSj2);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_sj2
     *
     * @param ksSj2 the value for mj_shid_real.ks_sj2
     */
    public void setKsSj2(String ksSj2) {
        this.ksSj2 = ksSj2;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_sj2
     *
     * @return the value of mj_shid_real.js_sj2
     */
    public String getJsSj2() {
        return jsSj2;
    }

    /**
     */
    public MjShidRealEntity withJsSj2(String jsSj2) {
        this.setJsSj2(jsSj2);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_sj2
     *
     * @param jsSj2 the value for mj_shid_real.js_sj2
     */
    public void setJsSj2(String jsSj2) {
        this.jsSj2 = jsSj2;
    }

    /**
     * This method returns the value of the database column mj_shid_real.sj
     *
     * @return the value of mj_shid_real.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjShidRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.sj
     *
     * @param sj the value for mj_shid_real.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column mj_shid_real.gly_no
     *
     * @return the value of mj_shid_real.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjShidRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.gly_no
     *
     * @param glyNo the value for mj_shid_real.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_sj3
     *
     * @return the value of mj_shid_real.ks_sj3
     */
    public String getKsSj3() {
        return ksSj3;
    }

    /**
     */
    public MjShidRealEntity withKsSj3(String ksSj3) {
        this.setKsSj3(ksSj3);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_sj3
     *
     * @param ksSj3 the value for mj_shid_real.ks_sj3
     */
    public void setKsSj3(String ksSj3) {
        this.ksSj3 = ksSj3;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_sj3
     *
     * @return the value of mj_shid_real.js_sj3
     */
    public String getJsSj3() {
        return jsSj3;
    }

    /**
     */
    public MjShidRealEntity withJsSj3(String jsSj3) {
        this.setJsSj3(jsSj3);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_sj3
     *
     * @param jsSj3 the value for mj_shid_real.js_sj3
     */
    public void setJsSj3(String jsSj3) {
        this.jsSj3 = jsSj3;
    }

    /**
     * This method returns the value of the database column mj_shid_real.ks_sj4
     *
     * @return the value of mj_shid_real.ks_sj4
     */
    public String getKsSj4() {
        return ksSj4;
    }

    /**
     */
    public MjShidRealEntity withKsSj4(String ksSj4) {
        this.setKsSj4(ksSj4);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.ks_sj4
     *
     * @param ksSj4 the value for mj_shid_real.ks_sj4
     */
    public void setKsSj4(String ksSj4) {
        this.ksSj4 = ksSj4;
    }

    /**
     * This method returns the value of the database column mj_shid_real.js_sj4
     *
     * @return the value of mj_shid_real.js_sj4
     */
    public String getJsSj4() {
        return jsSj4;
    }

    /**
     */
    public MjShidRealEntity withJsSj4(String jsSj4) {
        this.setJsSj4(jsSj4);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.js_sj4
     *
     * @param jsSj4 the value for mj_shid_real.js_sj4
     */
    public void setJsSj4(String jsSj4) {
        this.jsSj4 = jsSj4;
    }

    /**
     * This method returns the value of the database column mj_shid_real.regserial
     *
     * @return the value of mj_shid_real.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public MjShidRealEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_shid_real.regserial
     *
     * @param regserial the value for mj_shid_real.regserial
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

    public Integer getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}