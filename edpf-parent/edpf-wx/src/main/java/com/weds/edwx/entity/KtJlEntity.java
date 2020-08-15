package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class KtJlEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-27 11:34:20", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short fx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer yich;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String iden;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short devState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlzpSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer shenhe;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long devLogicBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short dealState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String recordno;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String jcard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String doorState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlType;

    private String image;

    private String mc;

    private Long devSbId;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column kt_jl.sj
     *
     * @return the value of kt_jl.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public KtJlEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.sj
     *
     * @param sj the value for kt_jl.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column kt_jl.user_serial
     *
     * @return the value of kt_jl.user_serial
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public KtJlEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.user_serial
     *
     * @param userSerial the value for kt_jl.user_serial
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column kt_jl.bh
     *
     * @return the value of kt_jl.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public KtJlEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.bh
     *
     * @param bh the value for kt_jl.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column kt_jl.fx
     *
     * @return the value of kt_jl.fx
     */
    public Short getFx() {
        return fx;
    }

    /**
     */
    public KtJlEntity withFx(Short fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.fx
     *
     * @param fx the value for kt_jl.fx
     */
    public void setFx(Short fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column kt_jl.lx
     *
     * @return the value of kt_jl.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public KtJlEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.lx
     *
     * @param lx the value for kt_jl.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column kt_jl.yich
     *
     * @return the value of kt_jl.yich
     */
    public Integer getYich() {
        return yich;
    }

    /**
     */
    public KtJlEntity withYich(Integer yich) {
        this.setYich(yich);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.yich
     *
     * @param yich the value for kt_jl.yich
     */
    public void setYich(Integer yich) {
        this.yich = yich;
    }

    /**
     * This method returns the value of the database column kt_jl.iden
     *
     * @return the value of kt_jl.iden
     */
    public String getIden() {
        return iden;
    }

    /**
     */
    public KtJlEntity withIden(String iden) {
        this.setIden(iden);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.iden
     *
     * @param iden the value for kt_jl.iden
     */
    public void setIden(String iden) {
        this.iden = iden;
    }

    /**
     * This method returns the value of the database column kt_jl.dev_serial
     *
     * @return the value of kt_jl.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public KtJlEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.dev_serial
     *
     * @param devSerial the value for kt_jl.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column kt_jl.dev_state
     *
     * @return the value of kt_jl.dev_state
     */
    public Short getDevState() {
        return devState;
    }

    /**
     */
    public KtJlEntity withDevState(Short devState) {
        this.setDevState(devState);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.dev_state
     *
     * @param devState the value for kt_jl.dev_state
     */
    public void setDevState(Short devState) {
        this.devState = devState;
    }

    /**
     * This method returns the value of the database column kt_jl.jlzp_serial
     *
     * @return the value of kt_jl.jlzp_serial
     */
    public Integer getJlzpSerial() {
        return jlzpSerial;
    }

    /**
     */
    public KtJlEntity withJlzpSerial(Integer jlzpSerial) {
        this.setJlzpSerial(jlzpSerial);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.jlzp_serial
     *
     * @param jlzpSerial the value for kt_jl.jlzp_serial
     */
    public void setJlzpSerial(Integer jlzpSerial) {
        this.jlzpSerial = jlzpSerial;
    }

    /**
     * This method returns the value of the database column kt_jl.gly_no
     *
     * @return the value of kt_jl.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public KtJlEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.gly_no
     *
     * @param glyNo the value for kt_jl.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column kt_jl.shenhe
     *
     * @return the value of kt_jl.shenhe
     */
    public Integer getShenhe() {
        return shenhe;
    }

    /**
     */
    public KtJlEntity withShenhe(Integer shenhe) {
        this.setShenhe(shenhe);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.shenhe
     *
     * @param shenhe the value for kt_jl.shenhe
     */
    public void setShenhe(Integer shenhe) {
        this.shenhe = shenhe;
    }

    /**
     * This method returns the value of the database column kt_jl.dev_logic_bh
     *
     * @return the value of kt_jl.dev_logic_bh
     */
    public Long getDevLogicBh() {
        return devLogicBh;
    }

    /**
     */
    public KtJlEntity withDevLogicBh(Long devLogicBh) {
        this.setDevLogicBh(devLogicBh);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.dev_logic_bh
     *
     * @param devLogicBh the value for kt_jl.dev_logic_bh
     */
    public void setDevLogicBh(Long devLogicBh) {
        this.devLogicBh = devLogicBh;
    }

    /**
     * This method returns the value of the database column kt_jl.deal_state
     *
     * @return the value of kt_jl.deal_state
     */
    public Short getDealState() {
        return dealState;
    }

    /**
     */
    public KtJlEntity withDealState(Short dealState) {
        this.setDealState(dealState);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.deal_state
     *
     * @param dealState the value for kt_jl.deal_state
     */
    public void setDealState(Short dealState) {
        this.dealState = dealState;
    }

    /**
     * This method returns the value of the database column kt_jl.recordno
     *
     * @return the value of kt_jl.recordno
     */
    public String getRecordno() {
        return recordno;
    }

    /**
     */
    public KtJlEntity withRecordno(String recordno) {
        this.setRecordno(recordno);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.recordno
     *
     * @param recordno the value for kt_jl.recordno
     */
    public void setRecordno(String recordno) {
        this.recordno = recordno;
    }

    /**
     * This method returns the value of the database column kt_jl.jcard
     *
     * @return the value of kt_jl.jcard
     */
    public String getJcard() {
        return jcard;
    }

    /**
     */
    public KtJlEntity withJcard(String jcard) {
        this.setJcard(jcard);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.jcard
     *
     * @param jcard the value for kt_jl.jcard
     */
    public void setJcard(String jcard) {
        this.jcard = jcard;
    }

    /**
     * This method returns the value of the database column kt_jl.door_state
     *
     * @return the value of kt_jl.door_state
     */
    public String getDoorState() {
        return doorState;
    }

    /**
     */
    public KtJlEntity withDoorState(String doorState) {
        this.setDoorState(doorState);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.door_state
     *
     * @param doorState the value for kt_jl.door_state
     */
    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    /**
     * This method returns the value of the database column kt_jl.jl_type
     *
     * @return the value of kt_jl.jl_type
     */
    public Integer getJlType() {
        return jlType;
    }

    /**
     */
    public KtJlEntity withJlType(Integer jlType) {
        this.setJlType(jlType);
        return this;
    }

    /**
     * This method sets the value of the database column kt_jl.jl_type
     *
     * @param jlType the value for kt_jl.jl_type
     */
    public void setJlType(Integer jlType) {
        this.jlType = jlType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public Long getDevSbId() {
        return devSbId;
    }

    public void setDevSbId(Long devSbId) {
        this.devSbId = devSbId;
    }
}