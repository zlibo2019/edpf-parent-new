package com.weds.edpf.core.entity;

import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 人员详细信息
 * @Date 2019-09-27
 */
public class UserDetailEntity extends UserInfoEntity implements Serializable {
    /**
     *   性别#1#1##9#01016
     *
     */
    @Size(max = 10)
    @Dict("01016")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "性别#1#1##9#01016")
    private String userSex;

    /**
     *   出生日期#1#1##0#
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "出生日期#1#1##0#")
    private String userBirth;

    /**
     *   家庭住址#1#1##0#
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "家庭住址#1#1##0#")
    private String userAddr;

    /**
     *   毕业学校#1#1##0#
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "毕业学校#1#1##0#")
    private String userSchool;

    /**
     *   工作日期#1#1##0#
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "工作日期#1#1##0#")
    private String workStart;

    /**
     *   婚姻状况#1#1##9#01017
     *
     */
    @Size(max = 10)
    @Dict("01017")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "婚姻状况#1#1##9#01017")
    private String married;

    /**
     *   民族#1#1##9#01018
     *
     */
    @Size(max = 10)
    @Dict("01018")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "民族#1#1##9#01018")
    private String nation;

    /**
     *   学历#1#1##9#01019
     *
     */
    @Size(max = 10)
    @Dict("01019")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "学历#1#1##9#01019")
    private String education;

    /**
     *   政治面貌#1#1##9#01020
     *
     */
    @Size(max = 10)
    @Dict("01020")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "政治面貌#1#1##9#01020")
    private String politic;

    /**
     *   擅长#1#1##0#
     *
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "擅长#1#1##0#")
    private String adept;

    /**
     *   备注#1#1##1#
     *
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注#1#1##1#")
    private String remakr;

    /**
     *   预留字段1
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol11;

    /**
     *   预留字段2
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol12;

    /**
     *   预留字段3
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol13;

    /**
     *   预留字段4
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol14;

    /**
     *   预留字段5
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol15;

    /**
     *   预留字段6
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol16;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column ed_user_detail.user_sex
     *
     * @return the value of ed_user_detail.user_sex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     */
    public UserDetailEntity withUserSex(String userSex) {
        this.setUserSex(userSex);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.user_sex
     *
     * @param userSex the value for ed_user_detail.user_sex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * This method returns the value of the database column ed_user_detail.user_birth
     *
     * @return the value of ed_user_detail.user_birth
     */
    public String getUserBirth() {
        return userBirth;
    }

    /**
     */
    public UserDetailEntity withUserBirth(String userBirth) {
        this.setUserBirth(userBirth);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.user_birth
     *
     * @param userBirth the value for ed_user_detail.user_birth
     */
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    /**
     * This method returns the value of the database column ed_user_detail.user_addr
     *
     * @return the value of ed_user_detail.user_addr
     */
    public String getUserAddr() {
        return userAddr;
    }

    /**
     */
    public UserDetailEntity withUserAddr(String userAddr) {
        this.setUserAddr(userAddr);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.user_addr
     *
     * @param userAddr the value for ed_user_detail.user_addr
     */
    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    /**
     * This method returns the value of the database column ed_user_detail.user_school
     *
     * @return the value of ed_user_detail.user_school
     */
    public String getUserSchool() {
        return userSchool;
    }

    /**
     */
    public UserDetailEntity withUserSchool(String userSchool) {
        this.setUserSchool(userSchool);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.user_school
     *
     * @param userSchool the value for ed_user_detail.user_school
     */
    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    /**
     * This method returns the value of the database column ed_user_detail.work_start
     *
     * @return the value of ed_user_detail.work_start
     */
    public String getWorkStart() {
        return workStart;
    }

    /**
     */
    public UserDetailEntity withWorkStart(String workStart) {
        this.setWorkStart(workStart);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.work_start
     *
     * @param workStart the value for ed_user_detail.work_start
     */
    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    /**
     * This method returns the value of the database column ed_user_detail.married
     *
     * @return the value of ed_user_detail.married
     */
    public String getMarried() {
        return married;
    }

    /**
     */
    public UserDetailEntity withMarried(String married) {
        this.setMarried(married);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.married
     *
     * @param married the value for ed_user_detail.married
     */
    public void setMarried(String married) {
        this.married = married;
    }

    /**
     * This method returns the value of the database column ed_user_detail.nation
     *
     * @return the value of ed_user_detail.nation
     */
    public String getNation() {
        return nation;
    }

    /**
     */
    public UserDetailEntity withNation(String nation) {
        this.setNation(nation);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.nation
     *
     * @param nation the value for ed_user_detail.nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * This method returns the value of the database column ed_user_detail.education
     *
     * @return the value of ed_user_detail.education
     */
    public String getEducation() {
        return education;
    }

    /**
     */
    public UserDetailEntity withEducation(String education) {
        this.setEducation(education);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.education
     *
     * @param education the value for ed_user_detail.education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * This method returns the value of the database column ed_user_detail.politic
     *
     * @return the value of ed_user_detail.politic
     */
    public String getPolitic() {
        return politic;
    }

    /**
     */
    public UserDetailEntity withPolitic(String politic) {
        this.setPolitic(politic);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.politic
     *
     * @param politic the value for ed_user_detail.politic
     */
    public void setPolitic(String politic) {
        this.politic = politic;
    }

    /**
     * This method returns the value of the database column ed_user_detail.adept
     *
     * @return the value of ed_user_detail.adept
     */
    public String getAdept() {
        return adept;
    }

    /**
     */
    public UserDetailEntity withAdept(String adept) {
        this.setAdept(adept);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.adept
     *
     * @param adept the value for ed_user_detail.adept
     */
    public void setAdept(String adept) {
        this.adept = adept;
    }

    /**
     * This method returns the value of the database column ed_user_detail.remakr
     *
     * @return the value of ed_user_detail.remakr
     */
    public String getRemakr() {
        return remakr;
    }

    /**
     */
    public UserDetailEntity withRemakr(String remakr) {
        this.setRemakr(remakr);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.remakr
     *
     * @param remakr the value for ed_user_detail.remakr
     */
    public void setRemakr(String remakr) {
        this.remakr = remakr;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col1
     *
     * @return the value of ed_user_detail.spare_col1
     */
    public String getspareCol11() {
        return spareCol11;
    }

    /**
     */
    public UserDetailEntity withspareCol11(String spareCol11) {
        this.setspareCol11(spareCol11);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col1
     *
     * @param spareCol11 the value for ed_user_detail.spare_col1
     */
    public void setspareCol11(String spareCol11) {
        this.spareCol11 = spareCol11;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col2
     *
     * @return the value of ed_user_detail.spare_col2
     */
    public String getspareCol12() {
        return spareCol12;
    }

    /**
     */
    public UserDetailEntity withspareCol12(String spareCol12) {
        this.setspareCol12(spareCol12);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col2
     *
     * @param spareCol12 the value for ed_user_detail.spare_col2
     */
    public void setspareCol12(String spareCol12) {
        this.spareCol12 = spareCol12;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col3
     *
     * @return the value of ed_user_detail.spare_col3
     */
    public String getspareCol13() {
        return spareCol13;
    }

    /**
     */
    public UserDetailEntity withspareCol13(String spareCol13) {
        this.setspareCol13(spareCol13);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col3
     *
     * @param spareCol13 the value for ed_user_detail.spare_col3
     */
    public void setspareCol13(String spareCol13) {
        this.spareCol13 = spareCol13;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col4
     *
     * @return the value of ed_user_detail.spare_col4
     */
    public String getspareCol14() {
        return spareCol14;
    }

    /**
     */
    public UserDetailEntity withspareCol14(String spareCol14) {
        this.setspareCol14(spareCol14);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col4
     *
     * @param spareCol14 the value for ed_user_detail.spare_col4
     */
    public void setspareCol14(String spareCol14) {
        this.spareCol14 = spareCol14;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col5
     *
     * @return the value of ed_user_detail.spare_col5
     */
    public String getspareCol15() {
        return spareCol15;
    }

    /**
     */
    public UserDetailEntity withspareCol15(String spareCol15) {
        this.setspareCol15(spareCol15);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col5
     *
     * @param spareCol15 the value for ed_user_detail.spare_col5
     */
    public void setspareCol15(String spareCol15) {
        this.spareCol15 = spareCol15;
    }

    /**
     * This method returns the value of the database column ed_user_detail.spare_col6
     *
     * @return the value of ed_user_detail.spare_col6
     */
    public String getspareCol16() {
        return spareCol16;
    }

    /**
     */
    public UserDetailEntity withspareCol16(String spareCol16) {
        this.setspareCol16(spareCol16);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_detail.spare_col6
     *
     * @param spareCol16 the value for ed_user_detail.spare_col6
     */
    public void setspareCol16(String spareCol16) {
        this.spareCol16 = spareCol16;
    }
}