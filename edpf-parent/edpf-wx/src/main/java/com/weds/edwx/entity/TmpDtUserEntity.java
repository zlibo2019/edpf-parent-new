package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class TmpDtUserEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String zh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userNo;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userLname;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userFname;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userDep;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userDepname;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date userWorkday;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userDuty;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userCard;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userFinger;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userPassword;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date pwdBegin;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date pwdEnd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Short userType;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date pactBegin;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date pactEnd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userLevel;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userPhoto;

    /**
     *
     */
    @Size(max = 8)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userSex;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userNation;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userXueli;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userNative;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date userBirthday;

    /**
     *
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userId;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userPost;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userLinkman;

    /**
     *
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userTelephone;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userAddress;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userEmail;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String user1;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String user2;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userBz;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String kqRule;

    /**
     *
     */
    @Size(max = 500)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String kqTaoban;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer kqTiaoxiu;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date xfTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xfJiange;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xfJe;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-10-24 10:52:27", value = "")
    private Date userSj;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userRank;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer glyImg;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userAc;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userGsbh;

    /**
     *
     */
    @Size(max = 5)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userYglx;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userZhbh;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userZhlx;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userTxm;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userMj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userIdentity;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userFace;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userRole;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol1;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String spareCol2;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column tmp_dt_user.zh
     *
     * @return the value of tmp_dt_user.zh
     */
    public String getZh() {
        return zh;
    }

    /**
     */
    public TmpDtUserEntity withZh(String zh) {
        this.setZh(zh);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.zh
     *
     * @param zh the value for tmp_dt_user.zh
     */
    public void setZh(String zh) {
        this.zh = zh;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_serial
     *
     * @return the value of tmp_dt_user.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public TmpDtUserEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_serial
     *
     * @param userSerial the value for tmp_dt_user.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_no
     *
     * @return the value of tmp_dt_user.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public TmpDtUserEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_no
     *
     * @param userNo the value for tmp_dt_user.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_lname
     *
     * @return the value of tmp_dt_user.user_lname
     */
    public String getUserLname() {
        return userLname;
    }

    /**
     */
    public TmpDtUserEntity withUserLname(String userLname) {
        this.setUserLname(userLname);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_lname
     *
     * @param userLname the value for tmp_dt_user.user_lname
     */
    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_fname
     *
     * @return the value of tmp_dt_user.user_fname
     */
    public String getUserFname() {
        return userFname;
    }

    /**
     */
    public TmpDtUserEntity withUserFname(String userFname) {
        this.setUserFname(userFname);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_fname
     *
     * @param userFname the value for tmp_dt_user.user_fname
     */
    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.dep_no
     *
     * @return the value of tmp_dt_user.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public TmpDtUserEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.dep_no
     *
     * @param depNo the value for tmp_dt_user.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_dep
     *
     * @return the value of tmp_dt_user.user_dep
     */
    public Integer getUserDep() {
        return userDep;
    }

    /**
     */
    public TmpDtUserEntity withUserDep(Integer userDep) {
        this.setUserDep(userDep);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_dep
     *
     * @param userDep the value for tmp_dt_user.user_dep
     */
    public void setUserDep(Integer userDep) {
        this.userDep = userDep;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_depname
     *
     * @return the value of tmp_dt_user.user_depname
     */
    public String getUserDepname() {
        return userDepname;
    }

    /**
     */
    public TmpDtUserEntity withUserDepname(String userDepname) {
        this.setUserDepname(userDepname);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_depname
     *
     * @param userDepname the value for tmp_dt_user.user_depname
     */
    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_workday
     *
     * @return the value of tmp_dt_user.user_workday
     */
    public Date getUserWorkday() {
        return userWorkday;
    }

    /**
     */
    public TmpDtUserEntity withUserWorkday(Date userWorkday) {
        this.setUserWorkday(userWorkday);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_workday
     *
     * @param userWorkday the value for tmp_dt_user.user_workday
     */
    public void setUserWorkday(Date userWorkday) {
        this.userWorkday = userWorkday;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_duty
     *
     * @return the value of tmp_dt_user.user_duty
     */
    public String getUserDuty() {
        return userDuty;
    }

    /**
     */
    public TmpDtUserEntity withUserDuty(String userDuty) {
        this.setUserDuty(userDuty);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_duty
     *
     * @param userDuty the value for tmp_dt_user.user_duty
     */
    public void setUserDuty(String userDuty) {
        this.userDuty = userDuty;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_card
     *
     * @return the value of tmp_dt_user.user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     */
    public TmpDtUserEntity withUserCard(String userCard) {
        this.setUserCard(userCard);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_card
     *
     * @param userCard the value for tmp_dt_user.user_card
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_finger
     *
     * @return the value of tmp_dt_user.user_finger
     */
    public String getUserFinger() {
        return userFinger;
    }

    /**
     */
    public TmpDtUserEntity withUserFinger(String userFinger) {
        this.setUserFinger(userFinger);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_finger
     *
     * @param userFinger the value for tmp_dt_user.user_finger
     */
    public void setUserFinger(String userFinger) {
        this.userFinger = userFinger;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_password
     *
     * @return the value of tmp_dt_user.user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     */
    public TmpDtUserEntity withUserPassword(String userPassword) {
        this.setUserPassword(userPassword);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_password
     *
     * @param userPassword the value for tmp_dt_user.user_password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.pwd_begin
     *
     * @return the value of tmp_dt_user.pwd_begin
     */
    public Date getPwdBegin() {
        return pwdBegin;
    }

    /**
     */
    public TmpDtUserEntity withPwdBegin(Date pwdBegin) {
        this.setPwdBegin(pwdBegin);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.pwd_begin
     *
     * @param pwdBegin the value for tmp_dt_user.pwd_begin
     */
    public void setPwdBegin(Date pwdBegin) {
        this.pwdBegin = pwdBegin;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.pwd_end
     *
     * @return the value of tmp_dt_user.pwd_end
     */
    public Date getPwdEnd() {
        return pwdEnd;
    }

    /**
     */
    public TmpDtUserEntity withPwdEnd(Date pwdEnd) {
        this.setPwdEnd(pwdEnd);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.pwd_end
     *
     * @param pwdEnd the value for tmp_dt_user.pwd_end
     */
    public void setPwdEnd(Date pwdEnd) {
        this.pwdEnd = pwdEnd;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_type
     *
     * @return the value of tmp_dt_user.user_type
     */
    public Short getUserType() {
        return userType;
    }

    /**
     */
    public TmpDtUserEntity withUserType(Short userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_type
     *
     * @param userType the value for tmp_dt_user.user_type
     */
    public void setUserType(Short userType) {
        this.userType = userType;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.pact_begin
     *
     * @return the value of tmp_dt_user.pact_begin
     */
    public Date getPactBegin() {
        return pactBegin;
    }

    /**
     */
    public TmpDtUserEntity withPactBegin(Date pactBegin) {
        this.setPactBegin(pactBegin);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.pact_begin
     *
     * @param pactBegin the value for tmp_dt_user.pact_begin
     */
    public void setPactBegin(Date pactBegin) {
        this.pactBegin = pactBegin;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.pact_end
     *
     * @return the value of tmp_dt_user.pact_end
     */
    public Date getPactEnd() {
        return pactEnd;
    }

    /**
     */
    public TmpDtUserEntity withPactEnd(Date pactEnd) {
        this.setPactEnd(pactEnd);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.pact_end
     *
     * @param pactEnd the value for tmp_dt_user.pact_end
     */
    public void setPactEnd(Date pactEnd) {
        this.pactEnd = pactEnd;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_level
     *
     * @return the value of tmp_dt_user.user_level
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     */
    public TmpDtUserEntity withUserLevel(Integer userLevel) {
        this.setUserLevel(userLevel);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_level
     *
     * @param userLevel the value for tmp_dt_user.user_level
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_photo
     *
     * @return the value of tmp_dt_user.user_photo
     */
    public Integer getUserPhoto() {
        return userPhoto;
    }

    /**
     */
    public TmpDtUserEntity withUserPhoto(Integer userPhoto) {
        this.setUserPhoto(userPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_photo
     *
     * @param userPhoto the value for tmp_dt_user.user_photo
     */
    public void setUserPhoto(Integer userPhoto) {
        this.userPhoto = userPhoto;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_sex
     *
     * @return the value of tmp_dt_user.user_sex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     */
    public TmpDtUserEntity withUserSex(String userSex) {
        this.setUserSex(userSex);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_sex
     *
     * @param userSex the value for tmp_dt_user.user_sex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_nation
     *
     * @return the value of tmp_dt_user.user_nation
     */
    public String getUserNation() {
        return userNation;
    }

    /**
     */
    public TmpDtUserEntity withUserNation(String userNation) {
        this.setUserNation(userNation);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_nation
     *
     * @param userNation the value for tmp_dt_user.user_nation
     */
    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_xueli
     *
     * @return the value of tmp_dt_user.user_xueli
     */
    public String getUserXueli() {
        return userXueli;
    }

    /**
     */
    public TmpDtUserEntity withUserXueli(String userXueli) {
        this.setUserXueli(userXueli);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_xueli
     *
     * @param userXueli the value for tmp_dt_user.user_xueli
     */
    public void setUserXueli(String userXueli) {
        this.userXueli = userXueli;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_native
     *
     * @return the value of tmp_dt_user.user_native
     */
    public String getUserNative() {
        return userNative;
    }

    /**
     */
    public TmpDtUserEntity withUserNative(String userNative) {
        this.setUserNative(userNative);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_native
     *
     * @param userNative the value for tmp_dt_user.user_native
     */
    public void setUserNative(String userNative) {
        this.userNative = userNative;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_birthday
     *
     * @return the value of tmp_dt_user.user_birthday
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     */
    public TmpDtUserEntity withUserBirthday(Date userBirthday) {
        this.setUserBirthday(userBirthday);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_birthday
     *
     * @param userBirthday the value for tmp_dt_user.user_birthday
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_id
     *
     * @return the value of tmp_dt_user.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public TmpDtUserEntity withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_id
     *
     * @param userId the value for tmp_dt_user.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_post
     *
     * @return the value of tmp_dt_user.user_post
     */
    public String getUserPost() {
        return userPost;
    }

    /**
     */
    public TmpDtUserEntity withUserPost(String userPost) {
        this.setUserPost(userPost);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_post
     *
     * @param userPost the value for tmp_dt_user.user_post
     */
    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_linkman
     *
     * @return the value of tmp_dt_user.user_linkman
     */
    public String getUserLinkman() {
        return userLinkman;
    }

    /**
     */
    public TmpDtUserEntity withUserLinkman(String userLinkman) {
        this.setUserLinkman(userLinkman);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_linkman
     *
     * @param userLinkman the value for tmp_dt_user.user_linkman
     */
    public void setUserLinkman(String userLinkman) {
        this.userLinkman = userLinkman;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_telephone
     *
     * @return the value of tmp_dt_user.user_telephone
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     */
    public TmpDtUserEntity withUserTelephone(String userTelephone) {
        this.setUserTelephone(userTelephone);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_telephone
     *
     * @param userTelephone the value for tmp_dt_user.user_telephone
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_address
     *
     * @return the value of tmp_dt_user.user_address
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     */
    public TmpDtUserEntity withUserAddress(String userAddress) {
        this.setUserAddress(userAddress);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_address
     *
     * @param userAddress the value for tmp_dt_user.user_address
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_email
     *
     * @return the value of tmp_dt_user.user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     */
    public TmpDtUserEntity withUserEmail(String userEmail) {
        this.setUserEmail(userEmail);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_email
     *
     * @param userEmail the value for tmp_dt_user.user_email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_1
     *
     * @return the value of tmp_dt_user.user_1
     */
    public String getUser1() {
        return user1;
    }

    /**
     */
    public TmpDtUserEntity withUser1(String user1) {
        this.setUser1(user1);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_1
     *
     * @param user1 the value for tmp_dt_user.user_1
     */
    public void setUser1(String user1) {
        this.user1 = user1;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_2
     *
     * @return the value of tmp_dt_user.user_2
     */
    public String getUser2() {
        return user2;
    }

    /**
     */
    public TmpDtUserEntity withUser2(String user2) {
        this.setUser2(user2);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_2
     *
     * @param user2 the value for tmp_dt_user.user_2
     */
    public void setUser2(String user2) {
        this.user2 = user2;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_bz
     *
     * @return the value of tmp_dt_user.user_bz
     */
    public String getUserBz() {
        return userBz;
    }

    /**
     */
    public TmpDtUserEntity withUserBz(String userBz) {
        this.setUserBz(userBz);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_bz
     *
     * @param userBz the value for tmp_dt_user.user_bz
     */
    public void setUserBz(String userBz) {
        this.userBz = userBz;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.kq_rule
     *
     * @return the value of tmp_dt_user.kq_rule
     */
    public String getKqRule() {
        return kqRule;
    }

    /**
     */
    public TmpDtUserEntity withKqRule(String kqRule) {
        this.setKqRule(kqRule);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.kq_rule
     *
     * @param kqRule the value for tmp_dt_user.kq_rule
     */
    public void setKqRule(String kqRule) {
        this.kqRule = kqRule;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.kq_taoban
     *
     * @return the value of tmp_dt_user.kq_taoban
     */
    public String getKqTaoban() {
        return kqTaoban;
    }

    /**
     */
    public TmpDtUserEntity withKqTaoban(String kqTaoban) {
        this.setKqTaoban(kqTaoban);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.kq_taoban
     *
     * @param kqTaoban the value for tmp_dt_user.kq_taoban
     */
    public void setKqTaoban(String kqTaoban) {
        this.kqTaoban = kqTaoban;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.kq_tiaoxiu
     *
     * @return the value of tmp_dt_user.kq_tiaoxiu
     */
    public Integer getKqTiaoxiu() {
        return kqTiaoxiu;
    }

    /**
     */
    public TmpDtUserEntity withKqTiaoxiu(Integer kqTiaoxiu) {
        this.setKqTiaoxiu(kqTiaoxiu);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.kq_tiaoxiu
     *
     * @param kqTiaoxiu the value for tmp_dt_user.kq_tiaoxiu
     */
    public void setKqTiaoxiu(Integer kqTiaoxiu) {
        this.kqTiaoxiu = kqTiaoxiu;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.xf_time
     *
     * @return the value of tmp_dt_user.xf_time
     */
    public Date getXfTime() {
        return xfTime;
    }

    /**
     */
    public TmpDtUserEntity withXfTime(Date xfTime) {
        this.setXfTime(xfTime);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.xf_time
     *
     * @param xfTime the value for tmp_dt_user.xf_time
     */
    public void setXfTime(Date xfTime) {
        this.xfTime = xfTime;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.xf_jiange
     *
     * @return the value of tmp_dt_user.xf_jiange
     */
    public Integer getXfJiange() {
        return xfJiange;
    }

    /**
     */
    public TmpDtUserEntity withXfJiange(Integer xfJiange) {
        this.setXfJiange(xfJiange);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.xf_jiange
     *
     * @param xfJiange the value for tmp_dt_user.xf_jiange
     */
    public void setXfJiange(Integer xfJiange) {
        this.xfJiange = xfJiange;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.xf_je
     *
     * @return the value of tmp_dt_user.xf_je
     */
    public Integer getXfJe() {
        return xfJe;
    }

    /**
     */
    public TmpDtUserEntity withXfJe(Integer xfJe) {
        this.setXfJe(xfJe);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.xf_je
     *
     * @param xfJe the value for tmp_dt_user.xf_je
     */
    public void setXfJe(Integer xfJe) {
        this.xfJe = xfJe;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_sj
     *
     * @return the value of tmp_dt_user.user_sj
     */
    public Date getUserSj() {
        return userSj;
    }

    /**
     */
    public TmpDtUserEntity withUserSj(Date userSj) {
        this.setUserSj(userSj);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_sj
     *
     * @param userSj the value for tmp_dt_user.user_sj
     */
    public void setUserSj(Date userSj) {
        this.userSj = userSj;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_rank
     *
     * @return the value of tmp_dt_user.user_rank
     */
    public String getUserRank() {
        return userRank;
    }

    /**
     */
    public TmpDtUserEntity withUserRank(String userRank) {
        this.setUserRank(userRank);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_rank
     *
     * @param userRank the value for tmp_dt_user.user_rank
     */
    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.gly_img
     *
     * @return the value of tmp_dt_user.gly_img
     */
    public Integer getGlyImg() {
        return glyImg;
    }

    /**
     */
    public TmpDtUserEntity withGlyImg(Integer glyImg) {
        this.setGlyImg(glyImg);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.gly_img
     *
     * @param glyImg the value for tmp_dt_user.gly_img
     */
    public void setGlyImg(Integer glyImg) {
        this.glyImg = glyImg;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_ac
     *
     * @return the value of tmp_dt_user.user_ac
     */
    public Integer getUserAc() {
        return userAc;
    }

    /**
     */
    public TmpDtUserEntity withUserAc(Integer userAc) {
        this.setUserAc(userAc);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_ac
     *
     * @param userAc the value for tmp_dt_user.user_ac
     */
    public void setUserAc(Integer userAc) {
        this.userAc = userAc;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_gsbh
     *
     * @return the value of tmp_dt_user.user_gsbh
     */
    public String getUserGsbh() {
        return userGsbh;
    }

    /**
     */
    public TmpDtUserEntity withUserGsbh(String userGsbh) {
        this.setUserGsbh(userGsbh);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_gsbh
     *
     * @param userGsbh the value for tmp_dt_user.user_gsbh
     */
    public void setUserGsbh(String userGsbh) {
        this.userGsbh = userGsbh;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_yglx
     *
     * @return the value of tmp_dt_user.user_yglx
     */
    public String getUserYglx() {
        return userYglx;
    }

    /**
     */
    public TmpDtUserEntity withUserYglx(String userYglx) {
        this.setUserYglx(userYglx);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_yglx
     *
     * @param userYglx the value for tmp_dt_user.user_yglx
     */
    public void setUserYglx(String userYglx) {
        this.userYglx = userYglx;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_zhbh
     *
     * @return the value of tmp_dt_user.user_zhbh
     */
    public String getUserZhbh() {
        return userZhbh;
    }

    /**
     */
    public TmpDtUserEntity withUserZhbh(String userZhbh) {
        this.setUserZhbh(userZhbh);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_zhbh
     *
     * @param userZhbh the value for tmp_dt_user.user_zhbh
     */
    public void setUserZhbh(String userZhbh) {
        this.userZhbh = userZhbh;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_zhlx
     *
     * @return the value of tmp_dt_user.user_zhlx
     */
    public String getUserZhlx() {
        return userZhlx;
    }

    /**
     */
    public TmpDtUserEntity withUserZhlx(String userZhlx) {
        this.setUserZhlx(userZhlx);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_zhlx
     *
     * @param userZhlx the value for tmp_dt_user.user_zhlx
     */
    public void setUserZhlx(String userZhlx) {
        this.userZhlx = userZhlx;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_txm
     *
     * @return the value of tmp_dt_user.user_txm
     */
    public String getUserTxm() {
        return userTxm;
    }

    /**
     */
    public TmpDtUserEntity withUserTxm(String userTxm) {
        this.setUserTxm(userTxm);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_txm
     *
     * @param userTxm the value for tmp_dt_user.user_txm
     */
    public void setUserTxm(String userTxm) {
        this.userTxm = userTxm;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_lx
     *
     * @return the value of tmp_dt_user.user_lx
     */
    public Integer getUserLx() {
        return userLx;
    }

    /**
     */
    public TmpDtUserEntity withUserLx(Integer userLx) {
        this.setUserLx(userLx);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_lx
     *
     * @param userLx the value for tmp_dt_user.user_lx
     */
    public void setUserLx(Integer userLx) {
        this.userLx = userLx;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_mj
     *
     * @return the value of tmp_dt_user.user_mj
     */
    public Integer getUserMj() {
        return userMj;
    }

    /**
     */
    public TmpDtUserEntity withUserMj(Integer userMj) {
        this.setUserMj(userMj);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_mj
     *
     * @param userMj the value for tmp_dt_user.user_mj
     */
    public void setUserMj(Integer userMj) {
        this.userMj = userMj;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_identity
     *
     * @return the value of tmp_dt_user.user_identity
     */
    public Integer getUserIdentity() {
        return userIdentity;
    }

    /**
     */
    public TmpDtUserEntity withUserIdentity(Integer userIdentity) {
        this.setUserIdentity(userIdentity);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_identity
     *
     * @param userIdentity the value for tmp_dt_user.user_identity
     */
    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_face
     *
     * @return the value of tmp_dt_user.user_face
     */
    public Integer getUserFace() {
        return userFace;
    }

    /**
     */
    public TmpDtUserEntity withUserFace(Integer userFace) {
        this.setUserFace(userFace);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_face
     *
     * @param userFace the value for tmp_dt_user.user_face
     */
    public void setUserFace(Integer userFace) {
        this.userFace = userFace;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.lx
     *
     * @return the value of tmp_dt_user.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public TmpDtUserEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.lx
     *
     * @param lx the value for tmp_dt_user.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.user_role
     *
     * @return the value of tmp_dt_user.user_role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     */
    public TmpDtUserEntity withUserRole(String userRole) {
        this.setUserRole(userRole);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.user_role
     *
     * @param userRole the value for tmp_dt_user.user_role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.spare_col1
     *
     * @return the value of tmp_dt_user.spare_col1
     */
    public String getSpareCol1() {
        return spareCol1;
    }

    /**
     */
    public TmpDtUserEntity withSpareCol1(String spareCol1) {
        this.setSpareCol1(spareCol1);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.spare_col1
     *
     * @param spareCol1 the value for tmp_dt_user.spare_col1
     */
    public void setSpareCol1(String spareCol1) {
        this.spareCol1 = spareCol1;
    }

    /**
     * This method returns the value of the database column tmp_dt_user.spare_col2
     *
     * @return the value of tmp_dt_user.spare_col2
     */
    public String getSpareCol2() {
        return spareCol2;
    }

    /**
     */
    public TmpDtUserEntity withSpareCol2(String spareCol2) {
        this.setSpareCol2(spareCol2);
        return this;
    }

    /**
     * This method sets the value of the database column tmp_dt_user.spare_col2
     *
     * @param spareCol2 the value for tmp_dt_user.spare_col2
     */
    public void setSpareCol2(String spareCol2) {
        this.spareCol2 = spareCol2;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}