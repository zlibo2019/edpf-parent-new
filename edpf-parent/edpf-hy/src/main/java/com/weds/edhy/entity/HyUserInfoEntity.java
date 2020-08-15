package com.weds.edhy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weds.edpf.core.entity.UserBaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 会员附属信息
 * @Date 2019-10-08
 */
public class HyUserInfoEntity extends UserBaseEntity {
    /**
     * 会员档案编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "会员档案编号")
    private String userId;

    /**
     * 教练档案编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "教练档案编号")
    private String coachId;

    /**
     * 所属会籍
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "所属会籍")
    private String memberShip;

    /**
     * 客户来源
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "客户来源")
    private String customSource;

    /**
     * 介绍人
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "介绍人")
    private String introducer;

    /**
     * 介绍会员数
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "介绍会员数")
    private Integer memberNum;

    /**
     * 备注
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

    /**
     * 预留字段1
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol21;

    /**
     * 预留字段2
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol22;

    /**
     * 预留字段3
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol23;

    /**
     * 预留字段4
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol24;

    /**
     * 预留字段5
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol25;

    /**
     * 预留字段6
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol26;

    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "教练姓名")
    private String coachName;

    /**
     * This method returns the value of the database column ed_hy_user_info.user_id
     *
     * @return the value of ed_hy_user_info.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public HyUserInfoEntity withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.user_id
     *
     * @param userId the value for ed_hy_user_info.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.coach_id
     *
     * @return the value of ed_hy_user_info.coach_id
     */
    public String getCoachId() {
        return coachId;
    }

    /**
     */
    public HyUserInfoEntity withCoachId(String coachId) {
        this.setCoachId(coachId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.coach_id
     *
     * @param coachId the value for ed_hy_user_info.coach_id
     */
    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.member_ship
     *
     * @return the value of ed_hy_user_info.member_ship
     */
    public String getMemberShip() {
        return memberShip;
    }

    /**
     */
    public HyUserInfoEntity withMemberShip(String memberShip) {
        this.setMemberShip(memberShip);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.member_ship
     *
     * @param memberShip the value for ed_hy_user_info.member_ship
     */
    public void setMemberShip(String memberShip) {
        this.memberShip = memberShip;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.custom_source
     *
     * @return the value of ed_hy_user_info.custom_source
     */
    public String getCustomSource() {
        return customSource;
    }

    /**
     */
    public HyUserInfoEntity withCustomSource(String customSource) {
        this.setCustomSource(customSource);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.custom_source
     *
     * @param customSource the value for ed_hy_user_info.custom_source
     */
    public void setCustomSource(String customSource) {
        this.customSource = customSource;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.introducer
     *
     * @return the value of ed_hy_user_info.introducer
     */
    public String getIntroducer() {
        return introducer;
    }

    /**
     */
    public HyUserInfoEntity withIntroducer(String introducer) {
        this.setIntroducer(introducer);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.introducer
     *
     * @param introducer the value for ed_hy_user_info.introducer
     */
    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.member_num
     *
     * @return the value of ed_hy_user_info.member_num
     */
    public Integer getMemberNum() {
        return memberNum;
    }

    /**
     */
    public HyUserInfoEntity withMemberNum(Integer memberNum) {
        this.setMemberNum(memberNum);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.member_num
     *
     * @param memberNum the value for ed_hy_user_info.member_num
     */
    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.remark
     *
     * @return the value of ed_hy_user_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public HyUserInfoEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.remark
     *
     * @param remark the value for ed_hy_user_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col21
     *
     * @return the value of ed_hy_user_info.spare_col21
     */
    public String getSpareCol21() {
        return spareCol21;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol21(String spareCol21) {
        this.setSpareCol21(spareCol21);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col21
     *
     * @param spareCol21 the value for ed_hy_user_info.spare_col21
     */
    public void setSpareCol21(String spareCol21) {
        this.spareCol21 = spareCol21;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col22
     *
     * @return the value of ed_hy_user_info.spare_col22
     */
    public String getSpareCol22() {
        return spareCol22;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol22(String spareCol22) {
        this.setSpareCol22(spareCol22);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col22
     *
     * @param spareCol22 the value for ed_hy_user_info.spare_col22
     */
    public void setSpareCol22(String spareCol22) {
        this.spareCol22 = spareCol22;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col23
     *
     * @return the value of ed_hy_user_info.spare_col23
     */
    public String getSpareCol23() {
        return spareCol23;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol23(String spareCol23) {
        this.setSpareCol23(spareCol23);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col23
     *
     * @param spareCol23 the value for ed_hy_user_info.spare_col23
     */
    public void setSpareCol23(String spareCol23) {
        this.spareCol23 = spareCol23;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col24
     *
     * @return the value of ed_hy_user_info.spare_col24
     */
    public String getSpareCol24() {
        return spareCol24;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol24(String spareCol24) {
        this.setSpareCol24(spareCol24);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col24
     *
     * @param spareCol24 the value for ed_hy_user_info.spare_col24
     */
    public void setSpareCol24(String spareCol24) {
        this.spareCol24 = spareCol24;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col25
     *
     * @return the value of ed_hy_user_info.spare_col25
     */
    public String getSpareCol25() {
        return spareCol25;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol25(String spareCol25) {
        this.setSpareCol25(spareCol25);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col25
     *
     * @param spareCol25 the value for ed_hy_user_info.spare_col25
     */
    public void setSpareCol25(String spareCol25) {
        this.spareCol25 = spareCol25;
    }

    /**
     * This method returns the value of the database column ed_hy_user_info.spare_col26
     *
     * @return the value of ed_hy_user_info.spare_col26
     */
    public String getSpareCol26() {
        return spareCol26;
    }

    /**
     */
    public HyUserInfoEntity withSpareCol26(String spareCol26) {
        this.setSpareCol26(spareCol26);
        return this;
    }

    /**
     * This method sets the value of the database column ed_hy_user_info.spare_col26
     *
     * @param spareCol26 the value for ed_hy_user_info.spare_col26
     */
    public void setSpareCol26(String spareCol26) {
        this.spareCol26 = spareCol26;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}