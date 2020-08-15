package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class GateLevelRealEntity extends ExportRptEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 物理门编号
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号")
    private String gateBh;

    /**
     * 门方向
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门方向")
    private Integer fx;

    /**
     * 扩展授权类型
     */
    @Dict("04015")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "扩展授权类型")
    private Integer lx;

    private Integer delLx; //删除类型判断

    public Integer getDelLx() {
        return delLx;
    }

    public void setDelLx(Integer delLx) {
        this.delLx = delLx;
    }

    /**
     * 部门序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "部门序号")
    private Integer depSerial;

    /**
     * 门禁规则编号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁规则编号")
    private Integer ruleNo;

    /**
     * 创建规则的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-08 09:05:47", value = "创建规则的时间")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String roleCode;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.xh
     *
     * @return the value of MJ_GATE_LEVEL_REAL.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public GateLevelRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.xh
     *
     * @param xh the value for MJ_GATE_LEVEL_REAL.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.Gate_bh
     *
     * @return the value of MJ_GATE_LEVEL_REAL.Gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public GateLevelRealEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.Gate_bh
     *
     * @param gateBh the value for MJ_GATE_LEVEL_REAL.Gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.FX
     *
     * @return the value of MJ_GATE_LEVEL_REAL.FX
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public GateLevelRealEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.FX
     *
     * @param fx the value for MJ_GATE_LEVEL_REAL.FX
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.lx
     *
     * @return the value of MJ_GATE_LEVEL_REAL.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public GateLevelRealEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.lx
     *
     * @param lx the value for MJ_GATE_LEVEL_REAL.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.dep_serial
     *
     * @return the value of MJ_GATE_LEVEL_REAL.dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public GateLevelRealEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.dep_serial
     *
     * @param depSerial the value for MJ_GATE_LEVEL_REAL.dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.rule_no
     *
     * @return the value of MJ_GATE_LEVEL_REAL.rule_no
     */
    public Integer getRuleNo() {
        return ruleNo;
    }

    /**
     */
    public GateLevelRealEntity withRuleNo(Integer ruleNo) {
        this.setRuleNo(ruleNo);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.rule_no
     *
     * @param ruleNo the value for MJ_GATE_LEVEL_REAL.rule_no
     */
    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.sj
     *
     * @return the value of MJ_GATE_LEVEL_REAL.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public GateLevelRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.sj
     *
     * @param sj the value for MJ_GATE_LEVEL_REAL.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.gly_no
     *
     * @return the value of MJ_GATE_LEVEL_REAL.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public GateLevelRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.gly_no
     *
     * @param glyNo the value for MJ_GATE_LEVEL_REAL.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column MJ_GATE_LEVEL_REAL.role_code
     *
     * @return the value of MJ_GATE_LEVEL_REAL.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     */
    public GateLevelRealEntity withRoleCode(String roleCode) {
        this.setRoleCode(roleCode);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_GATE_LEVEL_REAL.role_code
     *
     * @param roleCode the value for MJ_GATE_LEVEL_REAL.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    @ApiModelProperty(dataType = "list", value = "场所数组")
    private List<Integer> depList;

    @ApiModelProperty(dataType = "list", value = "门数组")
    private List<String> gateList;

    @ApiModelProperty(dataType = "list", value = "部门数组")
    private List<Integer> departmentList;

    @ApiModelProperty(dataType = "list", value = "角色数组")
    private List<Integer> roleList;

    public List<Integer> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Integer> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门名称")
    private String doorName;

    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "部门/角色名称")
    private String depName;

    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "规则名称")
    private String ruleName;

    public List<Integer> getDepList() {
        return depList;
    }

    public void setDepList(List<Integer> depList) {
        this.depList = depList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}