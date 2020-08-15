package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisThingEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String thingName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String bz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 14:59:54", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column vis_thing.xh
     *
     * @return the value of vis_thing.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisThingEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.xh
     *
     * @param xh the value for vis_thing.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column vis_thing.bh
     *
     * @return the value of vis_thing.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public VisThingEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.bh
     *
     * @param bh the value for vis_thing.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column vis_thing.lx
     *
     * @return the value of vis_thing.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public VisThingEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.lx
     *
     * @param lx the value for vis_thing.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column vis_thing.thing_name
     *
     * @return the value of vis_thing.thing_name
     */
    public String getThingName() {
        return thingName;
    }

    /**
     */
    public VisThingEntity withThingName(String thingName) {
        this.setThingName(thingName);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.thing_name
     *
     * @param thingName the value for vis_thing.thing_name
     */
    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    /**
     * This method returns the value of the database column vis_thing.bz
     *
     * @return the value of vis_thing.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public VisThingEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.bz
     *
     * @param bz the value for vis_thing.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column vis_thing.sj
     *
     * @return the value of vis_thing.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisThingEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.sj
     *
     * @param sj the value for vis_thing.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column vis_thing.gly_no
     *
     * @return the value of vis_thing.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisThingEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_thing.gly_no
     *
     * @param glyNo the value for vis_thing.gly_no
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