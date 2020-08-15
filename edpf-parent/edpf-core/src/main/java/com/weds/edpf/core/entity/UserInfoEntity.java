package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 人员基本信息
 * @Date 2019-09-27
 */
public class UserInfoEntity extends ExportRptEntity implements Serializable {
    /**
     * 档案编号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "档案编号")
    private String userId;

    /**
     * 人员编号#1#1##0#
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员编号#1#1##0#")
    private String userNo;

    /**
     * 姓名#1#1###
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "姓名#1#1###")
    private String userName;

    /**
     * 密码##1##0#
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "密码##1##0#")
    private String userPwd;

    /**
     * 密码到期日
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "密码到期日")
    private String pwdLossDate;

    /**
     * 证件类型##1##9#01014
     */
    @Size(max = 10)
    @Dict("01014")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "证件类型##1##9#01014")
    private String credType;

    /**
     * 证件编号##1##0#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "证件编号##1##0#")
    private String credNo;

    /**
     * 联系方式#1#1##0#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "联系方式#1#1##0#")
    private String userTel;

    /**
     * 职务#1#1##9#01015
     */
    @Size(max = 10)
    @Dict("01015")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "职务#1#1##9#01015")
    private String post;

    /**
     * 人员类型#1#1##9#01012
     */
    @Size(max = 10)
    @Dict("01012")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员类型#1#1##9#01012")
    private String userType;

    /**
     * 人员状态#1#1##9#01013
     */
    @Size(max = 10)
    @Dict("01013")
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员状态#1#1##9#01013")
    private String userState;

    /**
     * 所属机构#1#1##0#
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "所属机构#1#1##0#")
    private String userOrg;

    /**
     * 卡号#1#1##0#
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡号#1#1##0#")
    private String userCard;

    /**
     * 档案照片#1#1##0#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "档案照片#1#1##0#")
    private String userPhoto;

    /**
     * 人脸照片#1#1##0#
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人脸照片#1#1##0#")
    private String userFace;

    /**
     * 用户指纹#1####
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户指纹#1####")
    private String userFinger;

    /**
     * 创建时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建时间")
    private Date ctDate;

    /**
     * 创建人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "创建人员")
    private String ctUser;

    /**
     * 修改时间
     */
    @JsonIgnore
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改时间")
    private Date ltDate;

    /**
     * 修改人员
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "修改人员")
    private String ltUser;

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
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column ed_user_info.user_id
     *
     * @return the value of ed_user_info.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public UserInfoEntity withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_id
     *
     * @param userId the value for ed_user_info.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_no
     *
     * @return the value of ed_user_info.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public UserInfoEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_no
     *
     * @param userNo the value for ed_user_info.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_name
     *
     * @return the value of ed_user_info.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     */
    public UserInfoEntity withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_name
     *
     * @param userName the value for ed_user_info.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_pwd
     *
     * @return the value of ed_user_info.user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     */
    public UserInfoEntity withUserPwd(String userPwd) {
        this.setUserPwd(userPwd);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_pwd
     *
     * @param userPwd the value for ed_user_info.user_pwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * This method returns the value of the database column ed_user_info.pwd_loss_date
     *
     * @return the value of ed_user_info.pwd_loss_date
     */
    public String getPwdLossDate() {
        return pwdLossDate;
    }

    /**
     */
    public UserInfoEntity withPwdLossDate(String pwdLossDate) {
        this.setPwdLossDate(pwdLossDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.pwd_loss_date
     *
     * @param pwdLossDate the value for ed_user_info.pwd_loss_date
     */
    public void setPwdLossDate(String pwdLossDate) {
        this.pwdLossDate = pwdLossDate;
    }

    /**
     * This method returns the value of the database column ed_user_info.cred_type
     *
     * @return the value of ed_user_info.cred_type
     */
    public String getCredType() {
        return credType;
    }

    /**
     */
    public UserInfoEntity withCredType(String credType) {
        this.setCredType(credType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.cred_type
     *
     * @param credType the value for ed_user_info.cred_type
     */
    public void setCredType(String credType) {
        this.credType = credType;
    }

    /**
     * This method returns the value of the database column ed_user_info.cred_no
     *
     * @return the value of ed_user_info.cred_no
     */
    public String getCredNo() {
        return credNo;
    }

    /**
     */
    public UserInfoEntity withCredNo(String credNo) {
        this.setCredNo(credNo);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.cred_no
     *
     * @param credNo the value for ed_user_info.cred_no
     */
    public void setCredNo(String credNo) {
        this.credNo = credNo;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_tel
     *
     * @return the value of ed_user_info.user_tel
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     */
    public UserInfoEntity withUserTel(String userTel) {
        this.setUserTel(userTel);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_tel
     *
     * @param userTel the value for ed_user_info.user_tel
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * This method returns the value of the database column ed_user_info.post
     *
     * @return the value of ed_user_info.post
     */
    public String getPost() {
        return post;
    }

    /**
     */
    public UserInfoEntity withPost(String post) {
        this.setPost(post);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.post
     *
     * @param post the value for ed_user_info.post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_type
     *
     * @return the value of ed_user_info.user_type
     */
    public String getUserType() {
        return userType;
    }

    /**
     */
    public UserInfoEntity withUserType(String userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_type
     *
     * @param userType the value for ed_user_info.user_type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_state
     *
     * @return the value of ed_user_info.user_state
     */
    public String getUserState() {
        return userState;
    }

    /**
     */
    public UserInfoEntity withUserState(String userState) {
        this.setUserState(userState);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_state
     *
     * @param userState the value for ed_user_info.user_state
     */
    public void setUserState(String userState) {
        this.userState = userState;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_org
     *
     * @return the value of ed_user_info.user_org
     */
    public String getUserOrg() {
        return userOrg;
    }

    /**
     */
    public UserInfoEntity withUserOrg(String userOrg) {
        this.setUserOrg(userOrg);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_org
     *
     * @param userOrg the value for ed_user_info.user_org
     */
    public void setUserOrg(String userOrg) {
        this.userOrg = userOrg;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_card
     *
     * @return the value of ed_user_info.user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     */
    public UserInfoEntity withUserCard(String userCard) {
        this.setUserCard(userCard);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_card
     *
     * @param userCard the value for ed_user_info.user_card
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_photo
     *
     * @return the value of ed_user_info.user_photo
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     */
    public UserInfoEntity withUserPhoto(String userPhoto) {
        this.setUserPhoto(userPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_photo
     *
     * @param userPhoto the value for ed_user_info.user_photo
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_face
     *
     * @return the value of ed_user_info.user_face
     */
    public String getUserFace() {
        return userFace;
    }

    /**
     */
    public UserInfoEntity withUserFace(String userFace) {
        this.setUserFace(userFace);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_face
     *
     * @param userFace the value for ed_user_info.user_face
     */
    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    /**
     * This method returns the value of the database column ed_user_info.user_finger
     *
     * @return the value of ed_user_info.user_finger
     */
    public String getUserFinger() {
        return userFinger;
    }

    /**
     */
    public UserInfoEntity withUserFinger(String userFinger) {
        this.setUserFinger(userFinger);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.user_finger
     *
     * @param userFinger the value for ed_user_info.user_finger
     */
    public void setUserFinger(String userFinger) {
        this.userFinger = userFinger;
    }

    /**
     * This method returns the value of the database column ed_user_info.ct_date
     *
     * @return the value of ed_user_info.ct_date
     */
    public Date getCtDate() {
        return ctDate;
    }

    /**
     */
    public UserInfoEntity withCtDate(Date ctDate) {
        this.setCtDate(ctDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.ct_date
     *
     * @param ctDate the value for ed_user_info.ct_date
     */
    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    /**
     * This method returns the value of the database column ed_user_info.ct_user
     *
     * @return the value of ed_user_info.ct_user
     */
    public String getCtUser() {
        return ctUser;
    }

    /**
     */
    public UserInfoEntity withCtUser(String ctUser) {
        this.setCtUser(ctUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.ct_user
     *
     * @param ctUser the value for ed_user_info.ct_user
     */
    public void setCtUser(String ctUser) {
        this.ctUser = ctUser;
    }

    /**
     * This method returns the value of the database column ed_user_info.lt_date
     *
     * @return the value of ed_user_info.lt_date
     */
    public Date getLtDate() {
        return ltDate;
    }

    /**
     */
    public UserInfoEntity withLtDate(Date ltDate) {
        this.setLtDate(ltDate);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.lt_date
     *
     * @param ltDate the value for ed_user_info.lt_date
     */
    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    /**
     * This method returns the value of the database column ed_user_info.lt_user
     *
     * @return the value of ed_user_info.lt_user
     */
    public String getLtUser() {
        return ltUser;
    }

    /**
     */
    public UserInfoEntity withLtUser(String ltUser) {
        this.setLtUser(ltUser);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.lt_user
     *
     * @param ltUser the value for ed_user_info.lt_user
     */
    public void setLtUser(String ltUser) {
        this.ltUser = ltUser;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col1
     *
     * @return the value of ed_user_info.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public UserInfoEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col1
     *
     * @param spareCol1 the value for ed_user_info.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col2
     *
     * @return the value of ed_user_info.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public UserInfoEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col2
     *
     * @param spareCol2 the value for ed_user_info.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col3
     *
     * @return the value of ed_user_info.spare_col3
     */
    public String getSpareCol3() {
        return spareCol3;
    }

    /**
     */
    public UserInfoEntity withSpareCol3(String spareCol3) {
        this.setSpareCol3(spareCol3);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col3
     *
     * @param spareCol3 the value for ed_user_info.spare_col3
     */
    public void setSpareCol3(String spareCol3) {
        this.spareCol3 = spareCol3;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col4
     *
     * @return the value of ed_user_info.spare_col4
     */
    public String getSpareCol4() {
        return spareCol4;
    }

    /**
     */
    public UserInfoEntity withSpareCol4(String spareCol4) {
        this.setSpareCol4(spareCol4);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col4
     *
     * @param spareCol4 the value for ed_user_info.spare_col4
     */
    public void setSpareCol4(String spareCol4) {
        this.spareCol4 = spareCol4;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col5
     *
     * @return the value of ed_user_info.spare_col5
     */
    public String getSpareCol5() {
        return spareCol5;
    }

    /**
     */
    public UserInfoEntity withSpareCol5(String spareCol5) {
        this.setSpareCol5(spareCol5);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col5
     *
     * @param spareCol5 the value for ed_user_info.spare_col5
     */
    public void setSpareCol5(String spareCol5) {
        this.spareCol5 = spareCol5;
    }

    /**
     * This method returns the value of the database column ed_user_info.spare_col6
     *
     * @return the value of ed_user_info.spare_col6
     */
    public String getSpareCol6() {
        return spareCol6;
    }

    /**
     */
    public UserInfoEntity withSpareCol6(String spareCol6) {
        this.setSpareCol6(spareCol6);
        return this;
    }

    /**
     * This method sets the value of the database column ed_user_info.spare_col6
     *
     * @param spareCol6 the value for ed_user_info.spare_col6
     */
    public void setSpareCol6(String spareCol6) {
        this.spareCol6 = spareCol6;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}