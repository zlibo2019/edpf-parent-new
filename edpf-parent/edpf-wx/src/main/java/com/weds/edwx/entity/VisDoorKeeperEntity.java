package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 门卫用户管理
 * @Date 2019-04-17
 */
public class VisDoorKeeperEntity extends BaseEntity implements Serializable {
    /**
     * 用户编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户编号")
    private String userNo;

    /**
     * 用户姓名
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户姓名")
    private String userLname;

    /**
     * 用户密码
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户密码")
    private String userPwd;

    /**
     * 联系方式
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "联系方式")
    private String userTel;

    /**
     * 证件号码
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "证件号码")
    private String userCardId;

    /**
     * 是否启用
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "是否启用")
    private String useFlag;

    /**
     * 备注
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String remark;

    /**
     * 预留字段1
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段1")
    private String spareCol1;

    /**
     * 预留字段2
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段2")
    private String spareCol2;

    /**
     * 预留字段3
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段3")
    private String spareCol3;

    /**
     * 预留字段4
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段4")
    private String spareCol4;

    /**
     * 预留字段5
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段5")
    private String spareCol5;

    /**
     * 预留字段6
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "预留字段6")
    private String spareCol6;

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
    @Size(max = 23)
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
    @Size(max = 23)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    private String token;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column vis_door_keeper.user_no
     *
     * @return the value of vis_door_keeper.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public VisDoorKeeperEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.user_no
     *
     * @param userNo the value for vis_door_keeper.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.user_lname
     *
     * @return the value of vis_door_keeper.user_lname
     */
    public String getUserLname() {
        return userLname;
    }

    /**
     */
    public VisDoorKeeperEntity withUserLname(String userLname) {
        this.setUserLname(userLname);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.user_lname
     *
     * @param userLname the value for vis_door_keeper.user_lname
     */
    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.user_pwd
     *
     * @return the value of vis_door_keeper.user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     */
    public VisDoorKeeperEntity withUserPwd(String userPwd) {
        this.setUserPwd(userPwd);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.user_pwd
     *
     * @param userPwd the value for vis_door_keeper.user_pwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.user_tel
     *
     * @return the value of vis_door_keeper.user_tel
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     */
    public VisDoorKeeperEntity withUserTel(String userTel) {
        this.setUserTel(userTel);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.user_tel
     *
     * @param userTel the value for vis_door_keeper.user_tel
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.user_card_id
     *
     * @return the value of vis_door_keeper.user_card_id
     */
    public String getUserCardId() {
        return userCardId;
    }

    /**
     */
    public VisDoorKeeperEntity withUserCardId(String userCardId) {
        this.setUserCardId(userCardId);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.user_card_id
     *
     * @param userCardId the value for vis_door_keeper.user_card_id
     */
    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.use_flag
     *
     * @return the value of vis_door_keeper.use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     */
    public VisDoorKeeperEntity withUseFlag(String useFlag) {
        this.setUseFlag(useFlag);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.use_flag
     *
     * @param useFlag the value for vis_door_keeper.use_flag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.remark
     *
     * @return the value of vis_door_keeper.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public VisDoorKeeperEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.remark
     *
     * @param remark the value for vis_door_keeper.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col1
     *
     * @return the value of vis_door_keeper.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col1
     *
     * @param spareCol1 the value for vis_door_keeper.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col2
     *
     * @return the value of vis_door_keeper.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col2
     *
     * @param spareCol2 the value for vis_door_keeper.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col3
     *
     * @return the value of vis_door_keeper.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col3
     *
     * @param spareCol3 the value for vis_door_keeper.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col4
     *
     * @return the value of vis_door_keeper.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col4
     *
     * @param spareCol4 the value for vis_door_keeper.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col5
     *
     * @return the value of vis_door_keeper.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col5
     *
     * @param spareCol5 the value for vis_door_keeper.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.spare_col6
     *
     * @return the value of vis_door_keeper.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public VisDoorKeeperEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.spare_col6
     *
     * @param spareCol6 the value for vis_door_keeper.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.ct_user
     *
     * @return the value of vis_door_keeper.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public VisDoorKeeperEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.ct_user
     *
     * @param ctUser the value for vis_door_keeper.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.ct_date
     *
     * @return the value of vis_door_keeper.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public VisDoorKeeperEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.ct_date
     *
     * @param ctDate the value for vis_door_keeper.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.lt_user
     *
     * @return the value of vis_door_keeper.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public VisDoorKeeperEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.lt_user
     *
     * @param ltUser the value for vis_door_keeper.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column vis_door_keeper.lt_date
     *
     * @return the value of vis_door_keeper.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public VisDoorKeeperEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column vis_door_keeper.lt_date
     *
     * @param ltDate the value for vis_door_keeper.lt_date
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}