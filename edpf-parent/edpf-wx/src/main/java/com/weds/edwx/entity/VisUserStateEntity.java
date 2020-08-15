package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class VisUserStateEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer state;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visBz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:38:58", value = "")
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
     * This method returns the value of the database column vis_user_state.user_serial
     *
     * @return the value of vis_user_state.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public VisUserStateEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.user_serial
     *
     * @param userSerial the value for vis_user_state.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column vis_user_state.xh
     *
     * @return the value of vis_user_state.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisUserStateEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.xh
     *
     * @param xh the value for vis_user_state.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column vis_user_state.state
     *
     * @return the value of vis_user_state.state
     */
    public Integer getState() {
        return state;
    }

    /**
     */
    public VisUserStateEntity withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.state
     *
     * @param state the value for vis_user_state.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method returns the value of the database column vis_user_state.lx
     *
     * @return the value of vis_user_state.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public VisUserStateEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.lx
     *
     * @param lx the value for vis_user_state.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column vis_user_state.dep_serial
     *
     * @return the value of vis_user_state.dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public VisUserStateEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.dep_serial
     *
     * @param depSerial the value for vis_user_state.dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column vis_user_state.vis_bz
     *
     * @return the value of vis_user_state.vis_bz
     */
    public String getVisBz() {
        return visBz;
    }

    /**
     */
    public VisUserStateEntity withVisBz(String visBz) {
        this.setVisBz(visBz);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.vis_bz
     *
     * @param visBz the value for vis_user_state.vis_bz
     */
    public void setVisBz(String visBz) {
        this.visBz = visBz;
    }

    /**
     * This method returns the value of the database column vis_user_state.sj
     *
     * @return the value of vis_user_state.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisUserStateEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.sj
     *
     * @param sj the value for vis_user_state.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column vis_user_state.gly_no
     *
     * @return the value of vis_user_state.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisUserStateEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column vis_user_state.gly_no
     *
     * @param glyNo the value for vis_user_state.gly_no
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