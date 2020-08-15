package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MeetMdEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer meetBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer ryState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String ryZwh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer mdState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String tqry;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String bz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer groupBh;
    /**
     * 人员姓名
     */
    @ApiModelProperty(required = true, dataType = "String", example = "测试", value = "")
    private String userLname;

    /**
     * 人员姓名
     */
    @ApiModelProperty(required = true, dataType = "String", example = "测试", value = "")
    private String imgUrl;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column meet_md.xh
     *
     * @return the value of meet_md.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MeetMdEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.xh
     *
     * @param xh the value for meet_md.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column meet_md.user_serial
     *
     * @return the value of meet_md.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public MeetMdEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.user_serial
     *
     * @param userSerial the value for meet_md.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column meet_md.meet_bh
     *
     * @return the value of meet_md.meet_bh
     */
    public Integer getMeetBh() {
        return meetBh;
    }

    /**
     */
    public MeetMdEntity withMeetBh(Integer meetBh) {
        this.setMeetBh(meetBh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.meet_bh
     *
     * @param meetBh the value for meet_md.meet_bh
     */
    public void setMeetBh(Integer meetBh) {
        this.meetBh = meetBh;
    }

    /**
     * This method returns the value of the database column meet_md.ry_state
     *
     * @return the value of meet_md.ry_state
     */
    public Integer getRyState() {
        return ryState;
    }

    /**
     */
    public MeetMdEntity withRyState(Integer ryState) {
        this.setRyState(ryState);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.ry_state
     *
     * @param ryState the value for meet_md.ry_state
     */
    public void setRyState(Integer ryState) {
        this.ryState = ryState;
    }

    /**
     * This method returns the value of the database column meet_md.ry_zwh
     *
     * @return the value of meet_md.ry_zwh
     */
    public String getRyZwh() {
        return ryZwh;
    }

    /**
     */
    public MeetMdEntity withRyZwh(String ryZwh) {
        this.setRyZwh(ryZwh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.ry_zwh
     *
     * @param ryZwh the value for meet_md.ry_zwh
     */
    public void setRyZwh(String ryZwh) {
        this.ryZwh = ryZwh;
    }

    /**
     * This method returns the value of the database column meet_md.md_state
     *
     * @return the value of meet_md.md_state
     */
    public Integer getMdState() {
        return mdState;
    }

    /**
     */
    public MeetMdEntity withMdState(Integer mdState) {
        this.setMdState(mdState);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.md_state
     *
     * @param mdState the value for meet_md.md_state
     */
    public void setMdState(Integer mdState) {
        this.mdState = mdState;
    }

    /**
     * This method returns the value of the database column meet_md.tqry
     *
     * @return the value of meet_md.tqry
     */
    public String getTqry() {
        return tqry;
    }

    /**
     */
    public MeetMdEntity withTqry(String tqry) {
        this.setTqry(tqry);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.tqry
     *
     * @param tqry the value for meet_md.tqry
     */
    public void setTqry(String tqry) {
        this.tqry = tqry;
    }

    /**
     * This method returns the value of the database column meet_md.bz
     *
     * @return the value of meet_md.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public MeetMdEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.bz
     *
     * @param bz the value for meet_md.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column meet_md.group_bh
     *
     * @return the value of meet_md.group_bh
     */
    public Integer getGroupBh() {
        return groupBh;
    }

    /**
     */
    public MeetMdEntity withGroupBh(Integer groupBh) {
        this.setGroupBh(groupBh);
        return this;
    }

    /**
     * This method sets the value of the database column meet_md.group_bh
     *
     * @param groupBh the value for meet_md.group_bh
     */
    public void setGroupBh(Integer groupBh) {
        this.groupBh = groupBh;
    }
}