package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 门授权定义表
 * @Date 2019-07-30
 */
public class MjUserRuleRealEntity extends ExportRptEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 人员序号#1#1###
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员序号#1#1###")
    private Long userSerial;

    /**
     * 物理门编号#1#1###
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号#1#1###")
    private String gateBh;

    /**
     * 门方向数序号#1#1###
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门方向数序号#1#1###")
    @Dict("04001")
    private Integer fx;

    /**
     * 门禁规则编号#1#1###
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门禁规则编号#1#1###")
    private Integer ruleNo;

    /**
     * 创建规则的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-30 10:40:41", value = "创建规则的时间")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    @ApiModelProperty(required = true, dataType = "list", value = "人员序号数组")
    private List<Long> userList;
    @ApiModelProperty(required = true, dataType = "list", value = "门编号数组")
    private List<String> gateList;

    @ApiModelProperty(required = true, dataType = "int", example = "0", value = "进门规则")
    private Integer inRule;

    @ApiModelProperty(required = true, dataType = "int", example = "0", value = "出门规则")
    private Integer outRule;

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    public Integer getInRule() {
        return inRule;
    }

    public void setInRule(Integer inRule) {
        this.inRule = inRule;
    }

    public Integer getOutRule() {
        return outRule;
    }

    public void setOutRule(Integer outRule) {
        this.outRule = outRule;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    private String userNo;
    private String userLname;
    private String userDepname;
    private String userCard;
    private String doorName;
    private String ruleName;
    private String depName;
    private List<String> depList;
    private List<DoorRealEntity> doorList;
    private String devSerial;
    private Integer devOrder;

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    public Integer getDevOrder() {
        return devOrder;
    }

    public void setDevOrder(Integer devOrder) {
        this.devOrder = devOrder;
    }

    public List<String> getDepList() {
        return depList;
    }

    public void setDepList(List<String> depList) {
        this.depList = depList;
    }

    public List<DoorRealEntity> getDoorList() {
        return doorList;
    }

    public void setDoorList(List<DoorRealEntity> doorList) {
        this.doorList = doorList;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserDepname() {
        return userDepname;
    }

    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.xh
     *
     * @return the value of MJ_USER_RULE_REAL.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MjUserRuleRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.xh
     *
     * @param xh the value for MJ_USER_RULE_REAL.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.user_serial
     *
     * @return the value of MJ_USER_RULE_REAL.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MjUserRuleRealEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.user_serial
     *
     * @param userSerial the value for MJ_USER_RULE_REAL.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.Gate_bh
     *
     * @return the value of MJ_USER_RULE_REAL.Gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public MjUserRuleRealEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.Gate_bh
     *
     * @param gateBh the value for MJ_USER_RULE_REAL.Gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.FX
     *
     * @return the value of MJ_USER_RULE_REAL.FX
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public MjUserRuleRealEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.FX
     *
     * @param fx the value for MJ_USER_RULE_REAL.FX
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.rule_no
     *
     * @return the value of MJ_USER_RULE_REAL.rule_no
     */
    public Integer getRuleNo() {
        return ruleNo;
    }

    /**
     */
    public MjUserRuleRealEntity withRuleNo(Integer ruleNo) {
        this.setRuleNo(ruleNo);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.rule_no
     *
     * @param ruleNo the value for MJ_USER_RULE_REAL.rule_no
     */
    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.sj
     *
     * @return the value of MJ_USER_RULE_REAL.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MjUserRuleRealEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.sj
     *
     * @param sj the value for MJ_USER_RULE_REAL.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column MJ_USER_RULE_REAL.gly_no
     *
     * @return the value of MJ_USER_RULE_REAL.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjUserRuleRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column MJ_USER_RULE_REAL.gly_no
     *
     * @param glyNo the value for MJ_USER_RULE_REAL.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}