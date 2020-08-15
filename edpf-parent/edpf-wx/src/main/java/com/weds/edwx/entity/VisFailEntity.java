package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisFailEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long visSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visCard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visNums;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visCars;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:11:20", value = "")
    private Date visKssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:11:20", value = "")
    private Date visJssj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visThing;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visFail;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visBz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visOk;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 15:11:20", value = "")
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
     * This method returns the value of the database column Vis_fail.xh
     *
     * @return the value of Vis_fail.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisFailEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.xh
     *
     * @param xh the value for Vis_fail.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_serial
     *
     * @return the value of Vis_fail.vis_serial
     */
    public Long getVisSerial() {
        return visSerial;
    }

    /**
     */
    public VisFailEntity withVisSerial(Long visSerial) {
        this.setVisSerial(visSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_serial
     *
     * @param visSerial the value for Vis_fail.vis_serial
     */
    public void setVisSerial(Long visSerial) {
        this.visSerial = visSerial;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_no
     *
     * @return the value of Vis_fail.vis_no
     */
    public String getVisNo() {
        return visNo;
    }

    /**
     */
    public VisFailEntity withVisNo(String visNo) {
        this.setVisNo(visNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_no
     *
     * @param visNo the value for Vis_fail.vis_no
     */
    public void setVisNo(String visNo) {
        this.visNo = visNo;
    }

    /**
     * This method returns the value of the database column Vis_fail.dep_no
     *
     * @return the value of Vis_fail.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public VisFailEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.dep_no
     *
     * @param depNo the value for Vis_fail.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column Vis_fail.user_serial
     *
     * @return the value of Vis_fail.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public VisFailEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.user_serial
     *
     * @param userSerial the value for Vis_fail.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_card
     *
     * @return the value of Vis_fail.vis_card
     */
    public String getVisCard() {
        return visCard;
    }

    /**
     */
    public VisFailEntity withVisCard(String visCard) {
        this.setVisCard(visCard);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_card
     *
     * @param visCard the value for Vis_fail.vis_card
     */
    public void setVisCard(String visCard) {
        this.visCard = visCard;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_nums
     *
     * @return the value of Vis_fail.vis_nums
     */
    public Integer getVisNums() {
        return visNums;
    }

    /**
     */
    public VisFailEntity withVisNums(Integer visNums) {
        this.setVisNums(visNums);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_nums
     *
     * @param visNums the value for Vis_fail.vis_nums
     */
    public void setVisNums(Integer visNums) {
        this.visNums = visNums;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_cars
     *
     * @return the value of Vis_fail.vis_cars
     */
    public String getVisCars() {
        return visCars;
    }

    /**
     */
    public VisFailEntity withVisCars(String visCars) {
        this.setVisCars(visCars);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_cars
     *
     * @param visCars the value for Vis_fail.vis_cars
     */
    public void setVisCars(String visCars) {
        this.visCars = visCars;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_kssj
     *
     * @return the value of Vis_fail.vis_kssj
     */
    public Date getVisKssj() {
        return visKssj;
    }

    /**
     */
    public VisFailEntity withVisKssj(Date visKssj) {
        this.setVisKssj(visKssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_kssj
     *
     * @param visKssj the value for Vis_fail.vis_kssj
     */
    public void setVisKssj(Date visKssj) {
        this.visKssj = visKssj;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_jssj
     *
     * @return the value of Vis_fail.vis_jssj
     */
    public Date getVisJssj() {
        return visJssj;
    }

    /**
     */
    public VisFailEntity withVisJssj(Date visJssj) {
        this.setVisJssj(visJssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_jssj
     *
     * @param visJssj the value for Vis_fail.vis_jssj
     */
    public void setVisJssj(Date visJssj) {
        this.visJssj = visJssj;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_time
     *
     * @return the value of Vis_fail.vis_time
     */
    public Integer getVisTime() {
        return visTime;
    }

    /**
     */
    public VisFailEntity withVisTime(Integer visTime) {
        this.setVisTime(visTime);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_time
     *
     * @param visTime the value for Vis_fail.vis_time
     */
    public void setVisTime(Integer visTime) {
        this.visTime = visTime;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_thing
     *
     * @return the value of Vis_fail.vis_thing
     */
    public String getVisThing() {
        return visThing;
    }

    /**
     */
    public VisFailEntity withVisThing(String visThing) {
        this.setVisThing(visThing);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_thing
     *
     * @param visThing the value for Vis_fail.vis_thing
     */
    public void setVisThing(String visThing) {
        this.visThing = visThing;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_fail
     *
     * @return the value of Vis_fail.vis_fail
     */
    public Integer getVisFail() {
        return visFail;
    }

    /**
     */
    public VisFailEntity withVisFail(Integer visFail) {
        this.setVisFail(visFail);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_fail
     *
     * @param visFail the value for Vis_fail.vis_fail
     */
    public void setVisFail(Integer visFail) {
        this.visFail = visFail;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_bz
     *
     * @return the value of Vis_fail.vis_bz
     */
    public String getVisBz() {
        return visBz;
    }

    /**
     */
    public VisFailEntity withVisBz(String visBz) {
        this.setVisBz(visBz);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_bz
     *
     * @param visBz the value for Vis_fail.vis_bz
     */
    public void setVisBz(String visBz) {
        this.visBz = visBz;
    }

    /**
     * This method returns the value of the database column Vis_fail.vis_ok
     *
     * @return the value of Vis_fail.vis_ok
     */
    public Integer getVisOk() {
        return visOk;
    }

    /**
     */
    public VisFailEntity withVisOk(Integer visOk) {
        this.setVisOk(visOk);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.vis_ok
     *
     * @param visOk the value for Vis_fail.vis_ok
     */
    public void setVisOk(Integer visOk) {
        this.visOk = visOk;
    }

    /**
     * This method returns the value of the database column Vis_fail.sj
     *
     * @return the value of Vis_fail.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisFailEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.sj
     *
     * @param sj the value for Vis_fail.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column Vis_fail.gly_no
     *
     * @return the value of Vis_fail.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisFailEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_fail.gly_no
     *
     * @param glyNo the value for Vis_fail.gly_no
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