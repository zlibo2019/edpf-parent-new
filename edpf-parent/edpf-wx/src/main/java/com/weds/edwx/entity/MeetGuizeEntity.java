package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class MeetGuizeEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer meetBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer ksqdsj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jsqdsj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer ksjcdsj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer ksjztsj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bxqd;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bxqt;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer rqyc;

    /**
     *
     */
    @Size(max = 2000)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String roomGly;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column meet_guize.meet_bh
     *
     * @return the value of meet_guize.meet_bh
     */
    public Integer getMeetBh() {
        return meetBh;
    }

    /**
     */
    public MeetGuizeEntity withMeetBh(Integer meetBh) {
        this.setMeetBh(meetBh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.meet_bh
     *
     * @param meetBh the value for meet_guize.meet_bh
     */
    public void setMeetBh(Integer meetBh) {
        this.meetBh = meetBh;
    }

    /**
     * This method returns the value of the database column meet_guize.bh
     *
     * @return the value of meet_guize.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public MeetGuizeEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.bh
     *
     * @param bh the value for meet_guize.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column meet_guize.ksqdsj
     *
     * @return the value of meet_guize.ksqdsj
     */
    public Integer getKsqdsj() {
        return ksqdsj;
    }

    /**
     */
    public MeetGuizeEntity withKsqdsj(Integer ksqdsj) {
        this.setKsqdsj(ksqdsj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.ksqdsj
     *
     * @param ksqdsj the value for meet_guize.ksqdsj
     */
    public void setKsqdsj(Integer ksqdsj) {
        this.ksqdsj = ksqdsj;
    }

    /**
     * This method returns the value of the database column meet_guize.jsqdsj
     *
     * @return the value of meet_guize.jsqdsj
     */
    public Integer getJsqdsj() {
        return jsqdsj;
    }

    /**
     */
    public MeetGuizeEntity withJsqdsj(Integer jsqdsj) {
        this.setJsqdsj(jsqdsj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.jsqdsj
     *
     * @param jsqdsj the value for meet_guize.jsqdsj
     */
    public void setJsqdsj(Integer jsqdsj) {
        this.jsqdsj = jsqdsj;
    }

    /**
     * This method returns the value of the database column meet_guize.ksjcdsj
     *
     * @return the value of meet_guize.ksjcdsj
     */
    public Integer getKsjcdsj() {
        return ksjcdsj;
    }

    /**
     */
    public MeetGuizeEntity withKsjcdsj(Integer ksjcdsj) {
        this.setKsjcdsj(ksjcdsj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.ksjcdsj
     *
     * @param ksjcdsj the value for meet_guize.ksjcdsj
     */
    public void setKsjcdsj(Integer ksjcdsj) {
        this.ksjcdsj = ksjcdsj;
    }

    /**
     * This method returns the value of the database column meet_guize.ksjztsj
     *
     * @return the value of meet_guize.ksjztsj
     */
    public Integer getKsjztsj() {
        return ksjztsj;
    }

    /**
     */
    public MeetGuizeEntity withKsjztsj(Integer ksjztsj) {
        this.setKsjztsj(ksjztsj);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.ksjztsj
     *
     * @param ksjztsj the value for meet_guize.ksjztsj
     */
    public void setKsjztsj(Integer ksjztsj) {
        this.ksjztsj = ksjztsj;
    }

    /**
     * This method returns the value of the database column meet_guize.bxqd
     *
     * @return the value of meet_guize.bxqd
     */
    public Integer getBxqd() {
        return bxqd;
    }

    /**
     */
    public MeetGuizeEntity withBxqd(Integer bxqd) {
        this.setBxqd(bxqd);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.bxqd
     *
     * @param bxqd the value for meet_guize.bxqd
     */
    public void setBxqd(Integer bxqd) {
        this.bxqd = bxqd;
    }

    /**
     * This method returns the value of the database column meet_guize.bxqt
     *
     * @return the value of meet_guize.bxqt
     */
    public Integer getBxqt() {
        return bxqt;
    }

    /**
     */
    public MeetGuizeEntity withBxqt(Integer bxqt) {
        this.setBxqt(bxqt);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.bxqt
     *
     * @param bxqt the value for meet_guize.bxqt
     */
    public void setBxqt(Integer bxqt) {
        this.bxqt = bxqt;
    }

    /**
     * This method returns the value of the database column meet_guize.rqyc
     *
     * @return the value of meet_guize.rqyc
     */
    public Integer getRqyc() {
        return rqyc;
    }

    /**
     */
    public MeetGuizeEntity withRqyc(Integer rqyc) {
        this.setRqyc(rqyc);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.rqyc
     *
     * @param rqyc the value for meet_guize.rqyc
     */
    public void setRqyc(Integer rqyc) {
        this.rqyc = rqyc;
    }

    /**
     * This method returns the value of the database column meet_guize.room_gly
     *
     * @return the value of meet_guize.room_gly
     */
    public String getRoomGly() {
        return roomGly;
    }

    /**
     */
    public MeetGuizeEntity withRoomGly(String roomGly) {
        this.setRoomGly(roomGly);
        return this;
    }

    /**
     * This method sets the value of the database column meet_guize.room_gly
     *
     * @param roomGly the value for meet_guize.room_gly
     */
    public void setRoomGly(String roomGly) {
        this.roomGly = roomGly;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}