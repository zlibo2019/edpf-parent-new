package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class VisBlackNewEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visSex;

    /**
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visBz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-05-21 14:10:26", value = "")
    private Date sj;

    /**
     *
     */
    @Size(max = 50)
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
    @Size(max = 19)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String openId;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column vis_black.vis_no
     *
     * @return the value of vis_black.vis_no
     */
    public String getVisNo() {
        return visNo;
    }

    /**
     */
    public VisBlackNewEntity withVisNo(String visNo) {
        this.setVisNo(visNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.vis_no
     *
     * @param visNo the value for vis_black.vis_no
     */
    public void setVisNo(String visNo) {
        this.visNo = visNo;
    }

    /**
     * This method returns the value of the database column vis_black.xh
     *
     * @return the value of vis_black.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisBlackNewEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.xh
     *
     * @param xh the value for vis_black.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column vis_black.lx
     *
     * @return the value of vis_black.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public VisBlackNewEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.lx
     *
     * @param lx the value for vis_black.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column vis_black.vis_name
     *
     * @return the value of vis_black.vis_name
     */
    public String getVisName() {
        return visName;
    }

    /**
     */
    public VisBlackNewEntity withVisName(String visName) {
        this.setVisName(visName);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.vis_name
     *
     * @param visName the value for vis_black.vis_name
     */
    public void setVisName(String visName) {
        this.visName = visName;
    }

    /**
     * This method returns the value of the database column vis_black.vis_sex
     *
     * @return the value of vis_black.vis_sex
     */
    public Integer getVisSex() {
        return visSex;
    }

    /**
     */
    public VisBlackNewEntity withVisSex(Integer visSex) {
        this.setVisSex(visSex);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.vis_sex
     *
     * @param visSex the value for vis_black.vis_sex
     */
    public void setVisSex(Integer visSex) {
        this.visSex = visSex;
    }

    /**
     * This method returns the value of the database column vis_black.vis_bz
     *
     * @return the value of vis_black.vis_bz
     */
    public String getVisBz() {
        return visBz;
    }

    /**
     */
    public VisBlackNewEntity withVisBz(String visBz) {
        this.setVisBz(visBz);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.vis_bz
     *
     * @param visBz the value for vis_black.vis_bz
     */
    public void setVisBz(String visBz) {
        this.visBz = visBz;
    }

    /**
     * This method returns the value of the database column vis_black.sj
     *
     * @return the value of vis_black.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisBlackNewEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.sj
     *
     * @param sj the value for vis_black.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column vis_black.gly_no
     *
     * @return the value of vis_black.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisBlackNewEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.gly_no
     *
     * @param glyNo the value for vis_black.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column vis_black.vis_flg
     *
     * @return the value of vis_black.vis_flg
     */
    public Integer getVisFlg() {
        return visFlg;
    }

    /**
     */
    public VisBlackNewEntity withVisFlg(Integer visFlg) {
        this.setVisFlg(visFlg);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.vis_flg
     *
     * @param visFlg the value for vis_black.vis_flg
     */
    public void setVisFlg(Integer visFlg) {
        this.visFlg = visFlg;
    }

    /**
     * This method returns the value of the database column vis_black.user_serial
     *
     * @return the value of vis_black.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public VisBlackNewEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.user_serial
     *
     * @param userSerial the value for vis_black.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column vis_black.open_id
     *
     * @return the value of vis_black.open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     */
    public VisBlackNewEntity withOpenId(String openId) {
        this.setOpenId(openId);
        return this;
    }

    /**
     * This method sets the value of the database column vis_black.open_id
     *
     * @param openId the value for vis_black.open_id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}