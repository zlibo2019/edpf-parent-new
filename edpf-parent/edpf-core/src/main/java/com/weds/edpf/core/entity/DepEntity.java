package com.weds.edpf.core.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DepEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long depSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depParent;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depOrder;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depRule;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depRegserial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String jzDtAbbreviation;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depTeachserial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depDomain;

    /**
     */
    private static final long serialVersionUID = 1L;

    private Integer userNums;

    private int leaf;

    /**
     * This method returns the value of the database column dt_dep.dep_serial
     *
     * @return the value of dt_dep.dep_serial
     */
    public Long getDepSerial() {
        return depSerial;
    }

    /**
     */
    public DepEntity withDepSerial(Long depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_serial
     *
     * @param depSerial the value for dt_dep.dep_serial
     */
    public void setDepSerial(Long depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_parent
     *
     * @return the value of dt_dep.dep_parent
     */
    public Integer getDepParent() {
        return depParent;
    }

    /**
     */
    public DepEntity withDepParent(Integer depParent) {
        this.setDepParent(depParent);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_parent
     *
     * @param depParent the value for dt_dep.dep_parent
     */
    public void setDepParent(Integer depParent) {
        this.depParent = depParent;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_order
     *
     * @return the value of dt_dep.dep_order
     */
    public Integer getDepOrder() {
        return depOrder;
    }

    /**
     */
    public DepEntity withDepOrder(Integer depOrder) {
        this.setDepOrder(depOrder);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_order
     *
     * @param depOrder the value for dt_dep.dep_order
     */
    public void setDepOrder(Integer depOrder) {
        this.depOrder = depOrder;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_name
     *
     * @return the value of dt_dep.dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public DepEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_name
     *
     * @param depName the value for dt_dep.dep_name
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_no
     *
     * @return the value of dt_dep.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public DepEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_no
     *
     * @param depNo the value for dt_dep.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_rule
     *
     * @return the value of dt_dep.dep_rule
     */
    public String getDepRule() {
        return depRule;
    }

    /**
     */
    public DepEntity withDepRule(String depRule) {
        this.setDepRule(depRule);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_rule
     *
     * @param depRule the value for dt_dep.dep_rule
     */
    public void setDepRule(String depRule) {
        this.depRule = depRule;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_regserial
     *
     * @return the value of dt_dep.dep_regserial
     */
    public String getDepRegserial() {
        return depRegserial;
    }

    /**
     */
    public DepEntity withDepRegserial(String depRegserial) {
        this.setDepRegserial(depRegserial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_regserial
     *
     * @param depRegserial the value for dt_dep.dep_regserial
     */
    public void setDepRegserial(String depRegserial) {
        this.depRegserial = depRegserial;
    }

    /**
     * This method returns the value of the database column dt_dep.jz_dt_abbreviation
     *
     * @return the value of dt_dep.jz_dt_abbreviation
     */
    public String getJzDtAbbreviation() {
        return jzDtAbbreviation;
    }

    /**
     */
    public DepEntity withJzDtAbbreviation(String jzDtAbbreviation) {
        this.setJzDtAbbreviation(jzDtAbbreviation);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.jz_dt_abbreviation
     *
     * @param jzDtAbbreviation the value for dt_dep.jz_dt_abbreviation
     */
    public void setJzDtAbbreviation(String jzDtAbbreviation) {
        this.jzDtAbbreviation = jzDtAbbreviation;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_teachserial
     *
     * @return the value of dt_dep.dep_teachserial
     */
    public Integer getDepTeachserial() {
        return depTeachserial;
    }

    /**
     */
    public DepEntity withDepTeachserial(Integer depTeachserial) {
        this.setDepTeachserial(depTeachserial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_teachserial
     *
     * @param depTeachserial the value for dt_dep.dep_teachserial
     */
    public void setDepTeachserial(Integer depTeachserial) {
        this.depTeachserial = depTeachserial;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_lx
     *
     * @return the value of dt_dep.dep_lx
     */
    public Integer getDepLx() {
        return depLx;
    }

    /**
     */
    public DepEntity withDepLx(Integer depLx) {
        this.setDepLx(depLx);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_lx
     *
     * @param depLx the value for dt_dep.dep_lx
     */
    public void setDepLx(Integer depLx) {
        this.depLx = depLx;
    }

    /**
     * This method returns the value of the database column dt_dep.dep_domain
     *
     * @return the value of dt_dep.dep_domain
     */
    public String getDepDomain() {
        return depDomain;
    }

    /**
     */
    public DepEntity withDepDomain(String depDomain) {
        this.setDepDomain(depDomain);
        return this;
    }

    /**
     * This method sets the value of the database column dt_dep.dep_domain
     *
     * @param depDomain the value for dt_dep.dep_domain
     */
    public void setDepDomain(String depDomain) {
        this.depDomain = depDomain;
    }

    public Integer getUserNums() {
        return userNums;
    }

    public void setUserNums(Integer userNums) {
        this.userNums = userNums;
    }

    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }
}