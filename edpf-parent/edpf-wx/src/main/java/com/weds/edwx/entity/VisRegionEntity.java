package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisRegionEntity extends BaseEntity implements Serializable {
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
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String name;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:08:21", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String regserial;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column Vis_Region.xh
     *
     * @return the value of Vis_Region.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisRegionEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.xh
     *
     * @param xh the value for Vis_Region.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column Vis_Region.bh
     *
     * @return the value of Vis_Region.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public VisRegionEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.bh
     *
     * @param bh the value for Vis_Region.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column Vis_Region.name
     *
     * @return the value of Vis_Region.name
     */
    public String getName() {
        return name;
    }

    /**
     */
    public VisRegionEntity withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.name
     *
     * @param name the value for Vis_Region.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column Vis_Region.sj
     *
     * @return the value of Vis_Region.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisRegionEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.sj
     *
     * @param sj the value for Vis_Region.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column Vis_Region.gly_no
     *
     * @return the value of Vis_Region.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisRegionEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.gly_no
     *
     * @param glyNo the value for Vis_Region.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column Vis_Region.regserial
     *
     * @return the value of Vis_Region.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public VisRegionEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_Region.regserial
     *
     * @param regserial the value for Vis_Region.regserial
     */
    public void setRegserial(String regserial) {
        this.regserial = regserial;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}