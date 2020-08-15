package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class RegEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regUnit;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer regDep;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer regUser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regVersion;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer regConnect;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-27 14:34:14", value = "")
    private Date regTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short zhangtaoRq;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhPjz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhPj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhZj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhJj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhXx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhCd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhZt;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhSbws;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhXbws;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regPhotopath;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mrgz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mrbc;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fhJr;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer regTrans;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer cardLen;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer areaSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer cardNum;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regCompany;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userNum;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regCode;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer versionBz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String codeKey;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long outTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long refreshTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String organId;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column wt_reg.reg_unit
     *
     * @return the value of wt_reg.reg_unit
     */
    public String getRegUnit() {
        return regUnit;
    }

    /**
     */
    public RegEntity withRegUnit(String regUnit) {
        this.setRegUnit(regUnit);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_unit
     *
     * @param regUnit the value for wt_reg.reg_unit
     */
    public void setRegUnit(String regUnit) {
        this.regUnit = regUnit;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_no
     *
     * @return the value of wt_reg.reg_no
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     */
    public RegEntity withRegNo(String regNo) {
        this.setRegNo(regNo);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_no
     *
     * @param regNo the value for wt_reg.reg_no
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_dep
     *
     * @return the value of wt_reg.reg_dep
     */
    public Integer getRegDep() {
        return regDep;
    }

    /**
     */
    public RegEntity withRegDep(Integer regDep) {
        this.setRegDep(regDep);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_dep
     *
     * @param regDep the value for wt_reg.reg_dep
     */
    public void setRegDep(Integer regDep) {
        this.regDep = regDep;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_user
     *
     * @return the value of wt_reg.reg_user
     */
    public Integer getRegUser() {
        return regUser;
    }

    /**
     */
    public RegEntity withRegUser(Integer regUser) {
        this.setRegUser(regUser);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_user
     *
     * @param regUser the value for wt_reg.reg_user
     */
    public void setRegUser(Integer regUser) {
        this.regUser = regUser;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_version
     *
     * @return the value of wt_reg.reg_version
     */
    public String getRegVersion() {
        return regVersion;
    }

    /**
     */
    public RegEntity withRegVersion(String regVersion) {
        this.setRegVersion(regVersion);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_version
     *
     * @param regVersion the value for wt_reg.reg_version
     */
    public void setRegVersion(String regVersion) {
        this.regVersion = regVersion;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_connect
     *
     * @return the value of wt_reg.reg_connect
     */
    public Integer getRegConnect() {
        return regConnect;
    }

    /**
     */
    public RegEntity withRegConnect(Integer regConnect) {
        this.setRegConnect(regConnect);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_connect
     *
     * @param regConnect the value for wt_reg.reg_connect
     */
    public void setRegConnect(Integer regConnect) {
        this.regConnect = regConnect;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_time
     *
     * @return the value of wt_reg.reg_time
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     */
    public RegEntity withRegTime(Date regTime) {
        this.setRegTime(regTime);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_time
     *
     * @param regTime the value for wt_reg.reg_time
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * This method returns the value of the database column wt_reg.zhangtao_rq
     *
     * @return the value of wt_reg.zhangtao_rq
     */
    public Short getZhangtaoRq() {
        return zhangtaoRq;
    }

    /**
     */
    public RegEntity withZhangtaoRq(Short zhangtaoRq) {
        this.setZhangtaoRq(zhangtaoRq);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.zhangtao_rq
     *
     * @param zhangtaoRq the value for wt_reg.zhangtao_rq
     */
    public void setZhangtaoRq(Short zhangtaoRq) {
        this.zhangtaoRq = zhangtaoRq;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_pjz
     *
     * @return the value of wt_reg.fh_pjz
     */
    public String getFhPjz() {
        return fhPjz;
    }

    /**
     */
    public RegEntity withFhPjz(String fhPjz) {
        this.setFhPjz(fhPjz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_pjz
     *
     * @param fhPjz the value for wt_reg.fh_pjz
     */
    public void setFhPjz(String fhPjz) {
        this.fhPjz = fhPjz;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_pj
     *
     * @return the value of wt_reg.fh_pj
     */
    public String getFhPj() {
        return fhPj;
    }

    /**
     */
    public RegEntity withFhPj(String fhPj) {
        this.setFhPj(fhPj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_pj
     *
     * @param fhPj the value for wt_reg.fh_pj
     */
    public void setFhPj(String fhPj) {
        this.fhPj = fhPj;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_zj
     *
     * @return the value of wt_reg.fh_zj
     */
    public String getFhZj() {
        return fhZj;
    }

    /**
     */
    public RegEntity withFhZj(String fhZj) {
        this.setFhZj(fhZj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_zj
     *
     * @param fhZj the value for wt_reg.fh_zj
     */
    public void setFhZj(String fhZj) {
        this.fhZj = fhZj;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_jj
     *
     * @return the value of wt_reg.fh_jj
     */
    public String getFhJj() {
        return fhJj;
    }

    /**
     */
    public RegEntity withFhJj(String fhJj) {
        this.setFhJj(fhJj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_jj
     *
     * @param fhJj the value for wt_reg.fh_jj
     */
    public void setFhJj(String fhJj) {
        this.fhJj = fhJj;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_xx
     *
     * @return the value of wt_reg.fh_xx
     */
    public String getFhXx() {
        return fhXx;
    }

    /**
     */
    public RegEntity withFhXx(String fhXx) {
        this.setFhXx(fhXx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_xx
     *
     * @param fhXx the value for wt_reg.fh_xx
     */
    public void setFhXx(String fhXx) {
        this.fhXx = fhXx;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_cd
     *
     * @return the value of wt_reg.fh_cd
     */
    public String getFhCd() {
        return fhCd;
    }

    /**
     */
    public RegEntity withFhCd(String fhCd) {
        this.setFhCd(fhCd);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_cd
     *
     * @param fhCd the value for wt_reg.fh_cd
     */
    public void setFhCd(String fhCd) {
        this.fhCd = fhCd;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_zt
     *
     * @return the value of wt_reg.fh_zt
     */
    public String getFhZt() {
        return fhZt;
    }

    /**
     */
    public RegEntity withFhZt(String fhZt) {
        this.setFhZt(fhZt);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_zt
     *
     * @param fhZt the value for wt_reg.fh_zt
     */
    public void setFhZt(String fhZt) {
        this.fhZt = fhZt;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_sbws
     *
     * @return the value of wt_reg.fh_sbws
     */
    public String getFhSbws() {
        return fhSbws;
    }

    /**
     */
    public RegEntity withFhSbws(String fhSbws) {
        this.setFhSbws(fhSbws);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_sbws
     *
     * @param fhSbws the value for wt_reg.fh_sbws
     */
    public void setFhSbws(String fhSbws) {
        this.fhSbws = fhSbws;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_xbws
     *
     * @return the value of wt_reg.fh_xbws
     */
    public String getFhXbws() {
        return fhXbws;
    }

    /**
     */
    public RegEntity withFhXbws(String fhXbws) {
        this.setFhXbws(fhXbws);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_xbws
     *
     * @param fhXbws the value for wt_reg.fh_xbws
     */
    public void setFhXbws(String fhXbws) {
        this.fhXbws = fhXbws;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_photoPath
     *
     * @return the value of wt_reg.reg_photoPath
     */
    public String getRegPhotopath() {
        return regPhotopath;
    }

    /**
     */
    public RegEntity withRegPhotopath(String regPhotopath) {
        this.setRegPhotopath(regPhotopath);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_photoPath
     *
     * @param regPhotopath the value for wt_reg.reg_photoPath
     */
    public void setRegPhotopath(String regPhotopath) {
        this.regPhotopath = regPhotopath;
    }

    /**
     * This method returns the value of the database column wt_reg.mrgz
     *
     * @return the value of wt_reg.mrgz
     */
    public String getMrgz() {
        return mrgz;
    }

    /**
     */
    public RegEntity withMrgz(String mrgz) {
        this.setMrgz(mrgz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.mrgz
     *
     * @param mrgz the value for wt_reg.mrgz
     */
    public void setMrgz(String mrgz) {
        this.mrgz = mrgz;
    }

    /**
     * This method returns the value of the database column wt_reg.mrbc
     *
     * @return the value of wt_reg.mrbc
     */
    public String getMrbc() {
        return mrbc;
    }

    /**
     */
    public RegEntity withMrbc(String mrbc) {
        this.setMrbc(mrbc);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.mrbc
     *
     * @param mrbc the value for wt_reg.mrbc
     */
    public void setMrbc(String mrbc) {
        this.mrbc = mrbc;
    }

    /**
     * This method returns the value of the database column wt_reg.fh_jr
     *
     * @return the value of wt_reg.fh_jr
     */
    public String getFhJr() {
        return fhJr;
    }

    /**
     */
    public RegEntity withFhJr(String fhJr) {
        this.setFhJr(fhJr);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.fh_jr
     *
     * @param fhJr the value for wt_reg.fh_jr
     */
    public void setFhJr(String fhJr) {
        this.fhJr = fhJr;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_trans
     *
     * @return the value of wt_reg.reg_trans
     */
    public Integer getRegTrans() {
        return regTrans;
    }

    /**
     */
    public RegEntity withRegTrans(Integer regTrans) {
        this.setRegTrans(regTrans);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_trans
     *
     * @param regTrans the value for wt_reg.reg_trans
     */
    public void setRegTrans(Integer regTrans) {
        this.regTrans = regTrans;
    }

    /**
     * This method returns the value of the database column wt_reg.card_len
     *
     * @return the value of wt_reg.card_len
     */
    public Integer getCardLen() {
        return cardLen;
    }

    /**
     */
    public RegEntity withCardLen(Integer cardLen) {
        this.setCardLen(cardLen);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.card_len
     *
     * @param cardLen the value for wt_reg.card_len
     */
    public void setCardLen(Integer cardLen) {
        this.cardLen = cardLen;
    }

    /**
     * This method returns the value of the database column wt_reg.area_serial
     *
     * @return the value of wt_reg.area_serial
     */
    public Integer getAreaSerial() {
        return areaSerial;
    }

    /**
     */
    public RegEntity withAreaSerial(Integer areaSerial) {
        this.setAreaSerial(areaSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.area_serial
     *
     * @param areaSerial the value for wt_reg.area_serial
     */
    public void setAreaSerial(Integer areaSerial) {
        this.areaSerial = areaSerial;
    }

    /**
     * This method returns the value of the database column wt_reg.card_num
     *
     * @return the value of wt_reg.card_num
     */
    public Integer getCardNum() {
        return cardNum;
    }

    /**
     */
    public RegEntity withCardNum(Integer cardNum) {
        this.setCardNum(cardNum);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.card_num
     *
     * @param cardNum the value for wt_reg.card_num
     */
    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * This method returns the value of the database column wt_reg.bh
     *
     * @return the value of wt_reg.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public RegEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.bh
     *
     * @param bh the value for wt_reg.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_company
     *
     * @return the value of wt_reg.reg_company
     */
    public String getRegCompany() {
        return regCompany;
    }

    /**
     */
    public RegEntity withRegCompany(String regCompany) {
        this.setRegCompany(regCompany);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_company
     *
     * @param regCompany the value for wt_reg.reg_company
     */
    public void setRegCompany(String regCompany) {
        this.regCompany = regCompany;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_serial
     *
     * @return the value of wt_reg.reg_serial
     */
    public String getRegSerial() {
        return regSerial;
    }

    /**
     */
    public RegEntity withRegSerial(String regSerial) {
        this.setRegSerial(regSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_serial
     *
     * @param regSerial the value for wt_reg.reg_serial
     */
    public void setRegSerial(String regSerial) {
        this.regSerial = regSerial;
    }

    /**
     * This method returns the value of the database column wt_reg.user_num
     *
     * @return the value of wt_reg.user_num
     */
    public Integer getUserNum() {
        return userNum;
    }

    /**
     */
    public RegEntity withUserNum(Integer userNum) {
        this.setUserNum(userNum);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.user_num
     *
     * @param userNum the value for wt_reg.user_num
     */
    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    /**
     * This method returns the value of the database column wt_reg.reg_code
     *
     * @return the value of wt_reg.reg_code
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     */
    public RegEntity withRegCode(String regCode) {
        this.setRegCode(regCode);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.reg_code
     *
     * @param regCode the value for wt_reg.reg_code
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    /**
     * This method returns the value of the database column wt_reg.version_bz
     *
     * @return the value of wt_reg.version_bz
     */
    public Integer getVersionBz() {
        return versionBz;
    }

    /**
     */
    public RegEntity withVersionBz(Integer versionBz) {
        this.setVersionBz(versionBz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.version_bz
     *
     * @param versionBz the value for wt_reg.version_bz
     */
    public void setVersionBz(Integer versionBz) {
        this.versionBz = versionBz;
    }

    /**
     * This method returns the value of the database column wt_reg.code_key
     *
     * @return the value of wt_reg.code_key
     */
    public String getCodeKey() {
        return codeKey;
    }

    /**
     */
    public RegEntity withCodeKey(String codeKey) {
        this.setCodeKey(codeKey);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.code_key
     *
     * @param codeKey the value for wt_reg.code_key
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    /**
     * This method returns the value of the database column wt_reg.out_time
     *
     * @return the value of wt_reg.out_time
     */
    public Long getOutTime() {
        return outTime;
    }

    /**
     */
    public RegEntity withOutTime(Long outTime) {
        this.setOutTime(outTime);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.out_time
     *
     * @param outTime the value for wt_reg.out_time
     */
    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    /**
     * This method returns the value of the database column wt_reg.refresh_time
     *
     * @return the value of wt_reg.refresh_time
     */
    public Long getRefreshTime() {
        return refreshTime;
    }

    /**
     */
    public RegEntity withRefreshTime(Long refreshTime) {
        this.setRefreshTime(refreshTime);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.refresh_time
     *
     * @param refreshTime the value for wt_reg.refresh_time
     */
    public void setRefreshTime(Long refreshTime) {
        this.refreshTime = refreshTime;
    }

    /**
     * This method returns the value of the database column wt_reg.organ_id
     *
     * @return the value of wt_reg.organ_id
     */
    public String getOrganId() {
        return organId;
    }

    /**
     */
    public RegEntity withOrganId(String organId) {
        this.setOrganId(organId);
        return this;
    }

    /**
     * This method sets the value of the database column wt_reg.organ_id
     *
     * @param organId the value for wt_reg.organ_id
     */
    public void setOrganId(String organId) {
        this.organId = organId;
    }
}