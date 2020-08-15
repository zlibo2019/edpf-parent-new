package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisUserEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String openId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long visSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visPolice;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer idcSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visLname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String compNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String compName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visAc;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visDuty;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visFinger;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:06:42", value = "")
    private Date pactBegin;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:06:42", value = "")
    private Date pactEnd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visPhoto;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visSex;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visNation;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visXueli;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visNative;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy.MM.dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:06:42", value = "")
    private Date visBirthday;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visPost;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visLinkman;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visTelephone;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visAddress;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visEmail;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visBz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:06:42", value = "")
    private Date visSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visFlg;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String facePhoto;

    private String facePhotoFlag;

    private String subScribe;

    private String cardPhoto;

    private int ttOrder;

    public int getTtOrder() {
        return ttOrder;
    }

    public void setTtOrder(int ttOrder) {
        this.ttOrder = ttOrder;
    }

    public String getFacePhotoFlag() {
        return facePhotoFlag;
    }

    public void setFacePhotoFlag(String facePhotoFlag) {
        this.facePhotoFlag = facePhotoFlag;
    }

    public String getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(String cardPhoto) {
        this.cardPhoto = cardPhoto;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    public String getSubScribe() {
        return subScribe;
    }

    public void setSubScribe(String subScribe) {
        this.subScribe = subScribe;
    }

    /**
     * This method returns the value of the database column vis_user.open_id
     *
     * @return the value of vis_user.open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     */
    public VisUserEntity withOpenId(String openId) {
        this.setOpenId(openId);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.open_id
     *
     * @param openId the value for vis_user.open_id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * This method returns the value of the database column vis_user.vis_serial
     *
     * @return the value of vis_user.vis_serial
     */
    public Long getVisSerial() {
        return visSerial;
    }

    /**
     */
    public VisUserEntity withVisSerial(Long visSerial) {
        this.setVisSerial(visSerial);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_serial
     *
     * @param visSerial the value for vis_user.vis_serial
     */
    public void setVisSerial(Long visSerial) {
        this.visSerial = visSerial;
    }

    /**
     * This method returns the value of the database column vis_user.vis_id
     *
     * @return the value of vis_user.vis_id
     */
    public String getVisId() {
        return visId;
    }

    /**
     */
    public VisUserEntity withVisId(String visId) {
        this.setVisId(visId);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_id
     *
     * @param visId the value for vis_user.vis_id
     */
    public void setVisId(String visId) {
        this.visId = visId;
    }

    /**
     * This method returns the value of the database column vis_user.vis_police
     *
     * @return the value of vis_user.vis_police
     */
    public String getVisPolice() {
        return visPolice;
    }

    /**
     */
    public VisUserEntity withVisPolice(String visPolice) {
        this.setVisPolice(visPolice);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_police
     *
     * @param visPolice the value for vis_user.vis_police
     */
    public void setVisPolice(String visPolice) {
        this.visPolice = visPolice;
    }

    /**
     * This method returns the value of the database column vis_user.idc_sj
     *
     * @return the value of vis_user.idc_sj
     */
    public Integer getIdcSj() {
        return idcSj;
    }

    /**
     */
    public VisUserEntity withIdcSj(Integer idcSj) {
        this.setIdcSj(idcSj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.idc_sj
     *
     * @param idcSj the value for vis_user.idc_sj
     */
    public void setIdcSj(Integer idcSj) {
        this.idcSj = idcSj;
    }

    /**
     * This method returns the value of the database column vis_user.vis_lname
     *
     * @return the value of vis_user.vis_lname
     */
    public String getVisLname() {
        return visLname;
    }

    /**
     */
    public VisUserEntity withVisLname(String visLname) {
        this.setVisLname(visLname);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_lname
     *
     * @param visLname the value for vis_user.vis_lname
     */
    public void setVisLname(String visLname) {
        this.visLname = visLname;
    }

    /**
     * This method returns the value of the database column vis_user.comp_no
     *
     * @return the value of vis_user.comp_no
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     */
    public VisUserEntity withCompNo(String compNo) {
        this.setCompNo(compNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.comp_no
     *
     * @param compNo the value for vis_user.comp_no
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    /**
     * This method returns the value of the database column vis_user.dep_no
     *
     * @return the value of vis_user.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public VisUserEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.dep_no
     *
     * @param depNo the value for vis_user.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column vis_user.comp_name
     *
     * @return the value of vis_user.comp_name
     */
    public String getCompName() {
        return compName;
    }

    /**
     */
    public VisUserEntity withCompName(String compName) {
        this.setCompName(compName);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.comp_name
     *
     * @param compName the value for vis_user.comp_name
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }

    /**
     * This method returns the value of the database column vis_user.dep_name
     *
     * @return the value of vis_user.dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public VisUserEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.dep_name
     *
     * @param depName the value for vis_user.dep_name
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * This method returns the value of the database column vis_user.vis_ac
     *
     * @return the value of vis_user.vis_ac
     */
    public Integer getVisAc() {
        return visAc;
    }

    /**
     */
    public VisUserEntity withVisAc(Integer visAc) {
        this.setVisAc(visAc);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_ac
     *
     * @param visAc the value for vis_user.vis_ac
     */
    public void setVisAc(Integer visAc) {
        this.visAc = visAc;
    }

    /**
     * This method returns the value of the database column vis_user.vis_duty
     *
     * @return the value of vis_user.vis_duty
     */
    public String getVisDuty() {
        return visDuty;
    }

    /**
     */
    public VisUserEntity withVisDuty(String visDuty) {
        this.setVisDuty(visDuty);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_duty
     *
     * @param visDuty the value for vis_user.vis_duty
     */
    public void setVisDuty(String visDuty) {
        this.visDuty = visDuty;
    }

    /**
     * This method returns the value of the database column vis_user.vis_finger
     *
     * @return the value of vis_user.vis_finger
     */
    public String getVisFinger() {
        return visFinger;
    }

    /**
     */
    public VisUserEntity withVisFinger(String visFinger) {
        this.setVisFinger(visFinger);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_finger
     *
     * @param visFinger the value for vis_user.vis_finger
     */
    public void setVisFinger(String visFinger) {
        this.visFinger = visFinger;
    }

    /**
     * This method returns the value of the database column vis_user.pact_begin
     *
     * @return the value of vis_user.pact_begin
     */
    public Date getPactBegin() {
        return pactBegin;
    }

    /**
     */
    public VisUserEntity withPactBegin(Date pactBegin) {
        this.setPactBegin(pactBegin);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.pact_begin
     *
     * @param pactBegin the value for vis_user.pact_begin
     */
    public void setPactBegin(Date pactBegin) {
        this.pactBegin = pactBegin;
    }

    /**
     * This method returns the value of the database column vis_user.pact_end
     *
     * @return the value of vis_user.pact_end
     */
    public Date getPactEnd() {
        return pactEnd;
    }

    /**
     */
    public VisUserEntity withPactEnd(Date pactEnd) {
        this.setPactEnd(pactEnd);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.pact_end
     *
     * @param pactEnd the value for vis_user.pact_end
     */
    public void setPactEnd(Date pactEnd) {
        this.pactEnd = pactEnd;
    }

    /**
     * This method returns the value of the database column vis_user.vis_photo
     *
     * @return the value of vis_user.vis_photo
     */
    public Integer getVisPhoto() {
        return visPhoto;
    }

    /**
     */
    public VisUserEntity withVisPhoto(Integer visPhoto) {
        this.setVisPhoto(visPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_photo
     *
     * @param visPhoto the value for vis_user.vis_photo
     */
    public void setVisPhoto(Integer visPhoto) {
        this.visPhoto = visPhoto;
    }

    /**
     * This method returns the value of the database column vis_user.vis_sex
     *
     * @return the value of vis_user.vis_sex
     */
    public String getVisSex() {
        return visSex;
    }

    /**
     */
    public VisUserEntity withVisSex(String visSex) {
        this.setVisSex(visSex);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_sex
     *
     * @param visSex the value for vis_user.vis_sex
     */
    public void setVisSex(String visSex) {
        this.visSex = visSex;
    }

    /**
     * This method returns the value of the database column vis_user.vis_nation
     *
     * @return the value of vis_user.vis_nation
     */
    public String getVisNation() {
        return visNation;
    }

    /**
     */
    public VisUserEntity withVisNation(String visNation) {
        this.setVisNation(visNation);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_nation
     *
     * @param visNation the value for vis_user.vis_nation
     */
    public void setVisNation(String visNation) {
        this.visNation = visNation;
    }

    /**
     * This method returns the value of the database column vis_user.vis_xueli
     *
     * @return the value of vis_user.vis_xueli
     */
    public String getVisXueli() {
        return visXueli;
    }

    /**
     */
    public VisUserEntity withVisXueli(String visXueli) {
        this.setVisXueli(visXueli);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_xueli
     *
     * @param visXueli the value for vis_user.vis_xueli
     */
    public void setVisXueli(String visXueli) {
        this.visXueli = visXueli;
    }

    /**
     * This method returns the value of the database column vis_user.vis_native
     *
     * @return the value of vis_user.vis_native
     */
    public String getVisNative() {
        return visNative;
    }

    /**
     */
    public VisUserEntity withVisNative(String visNative) {
        this.setVisNative(visNative);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_native
     *
     * @param visNative the value for vis_user.vis_native
     */
    public void setVisNative(String visNative) {
        this.visNative = visNative;
    }

    /**
     * This method returns the value of the database column vis_user.vis_birthday
     *
     * @return the value of vis_user.vis_birthday
     */
    public Date getVisBirthday() {
        return visBirthday;
    }

    /**
     */
    public VisUserEntity withVisBirthday(Date visBirthday) {
        this.setVisBirthday(visBirthday);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_birthday
     *
     * @param visBirthday the value for vis_user.vis_birthday
     */
    public void setVisBirthday(Date visBirthday) {
        this.visBirthday = visBirthday;
    }

    /**
     * This method returns the value of the database column vis_user.vis_post
     *
     * @return the value of vis_user.vis_post
     */
    public String getVisPost() {
        return visPost;
    }

    /**
     */
    public VisUserEntity withVisPost(String visPost) {
        this.setVisPost(visPost);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_post
     *
     * @param visPost the value for vis_user.vis_post
     */
    public void setVisPost(String visPost) {
        this.visPost = visPost;
    }

    /**
     * This method returns the value of the database column vis_user.vis_linkman
     *
     * @return the value of vis_user.vis_linkman
     */
    public String getVisLinkman() {
        return visLinkman;
    }

    /**
     */
    public VisUserEntity withVisLinkman(String visLinkman) {
        this.setVisLinkman(visLinkman);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_linkman
     *
     * @param visLinkman the value for vis_user.vis_linkman
     */
    public void setVisLinkman(String visLinkman) {
        this.visLinkman = visLinkman;
    }

    /**
     * This method returns the value of the database column vis_user.vis_telephone
     *
     * @return the value of vis_user.vis_telephone
     */
    public String getVisTelephone() {
        return visTelephone;
    }

    /**
     */
    public VisUserEntity withVisTelephone(String visTelephone) {
        this.setVisTelephone(visTelephone);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_telephone
     *
     * @param visTelephone the value for vis_user.vis_telephone
     */
    public void setVisTelephone(String visTelephone) {
        this.visTelephone = visTelephone;
    }

    /**
     * This method returns the value of the database column vis_user.vis_address
     *
     * @return the value of vis_user.vis_address
     */
    public String getVisAddress() {
        return visAddress;
    }

    /**
     */
    public VisUserEntity withVisAddress(String visAddress) {
        this.setVisAddress(visAddress);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_address
     *
     * @param visAddress the value for vis_user.vis_address
     */
    public void setVisAddress(String visAddress) {
        this.visAddress = visAddress;
    }

    /**
     * This method returns the value of the database column vis_user.vis_email
     *
     * @return the value of vis_user.vis_email
     */
    public String getVisEmail() {
        return visEmail;
    }

    /**
     */
    public VisUserEntity withVisEmail(String visEmail) {
        this.setVisEmail(visEmail);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_email
     *
     * @param visEmail the value for vis_user.vis_email
     */
    public void setVisEmail(String visEmail) {
        this.visEmail = visEmail;
    }

    /**
     * This method returns the value of the database column vis_user.vis_bz
     *
     * @return the value of vis_user.vis_bz
     */
    public String getVisBz() {
        return visBz;
    }

    /**
     */
    public VisUserEntity withVisBz(String visBz) {
        this.setVisBz(visBz);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_bz
     *
     * @param visBz the value for vis_user.vis_bz
     */
    public void setVisBz(String visBz) {
        this.visBz = visBz;
    }

    /**
     * This method returns the value of the database column vis_user.vis_sj
     *
     * @return the value of vis_user.vis_sj
     */
    public Date getVisSj() {
        return visSj;
    }

    /**
     */
    public VisUserEntity withVisSj(Date visSj) {
        this.setVisSj(visSj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_sj
     *
     * @param visSj the value for vis_user.vis_sj
     */
    public void setVisSj(Date visSj) {
        this.visSj = visSj;
    }

    /**
     * This method returns the value of the database column vis_user.gly_no
     *
     * @return the value of vis_user.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisUserEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.gly_no
     *
     * @param glyNo the value for vis_user.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column vis_user.vis_flg
     *
     * @return the value of vis_user.vis_flg
     */
    public Integer getVisFlg() {
        return visFlg;
    }

    /**
     */
    public VisUserEntity withVisFlg(Integer visFlg) {
        this.setVisFlg(visFlg);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.vis_flg
     *
     * @param visFlg the value for vis_user.vis_flg
     */
    public void setVisFlg(Integer visFlg) {
        this.visFlg = visFlg;
    }

    /**
     * This method returns the value of the database column vis_user.face_photo
     *
     * @return the value of vis_user.face_photo
     */
    public String getFacePhoto() {
        return facePhoto;
    }

    /**
     */
    public VisUserEntity withFacePhoto(String facePhoto) {
        this.setFacePhoto(facePhoto);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user.face_photo
     *
     * @param facePhoto the value for vis_user.face_photo
     */
    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}