package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class FkLogEntity extends BaseEntity implements Serializable {
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
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer logType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer logState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String logBz;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-22 08:04:50", value = "")
    private Date logSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String logIp;

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
     * This method returns the value of the database column wt_fk_log.xh
     *
     * @return the value of wt_fk_log.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public FkLogEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.xh
     *
     * @param xh the value for wt_fk_log.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wt_fk_log.lx
     *
     * @return the value of wt_fk_log.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public FkLogEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.lx
     *
     * @param lx the value for wt_fk_log.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column wt_fk_log.log_type
     *
     * @return the value of wt_fk_log.log_type
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     */
    public FkLogEntity withLogType(Integer logType) {
        this.setLogType(logType);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.log_type
     *
     * @param logType the value for wt_fk_log.log_type
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * This method returns the value of the database column wt_fk_log.log_state
     *
     * @return the value of wt_fk_log.log_state
     */
    public Integer getLogState() {
        return logState;
    }

    /**
     */
    public FkLogEntity withLogState(Integer logState) {
        this.setLogState(logState);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.log_state
     *
     * @param logState the value for wt_fk_log.log_state
     */
    public void setLogState(Integer logState) {
        this.logState = logState;
    }

    /**
     * This method returns the value of the database column wt_fk_log.log_bz
     *
     * @return the value of wt_fk_log.log_bz
     */
    public String getLogBz() {
        return logBz;
    }

    /**
     */
    public FkLogEntity withLogBz(String logBz) {
        this.setLogBz(logBz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.log_bz
     *
     * @param logBz the value for wt_fk_log.log_bz
     */
    public void setLogBz(String logBz) {
        this.logBz = logBz;
    }

    /**
     * This method returns the value of the database column wt_fk_log.log_sj
     *
     * @return the value of wt_fk_log.log_sj
     */
    public Date getLogSj() {
        return logSj;
    }

    /**
     */
    public FkLogEntity withLogSj(Date logSj) {
        this.setLogSj(logSj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.log_sj
     *
     * @param logSj the value for wt_fk_log.log_sj
     */
    public void setLogSj(Date logSj) {
        this.logSj = logSj;
    }

    /**
     * This method returns the value of the database column wt_fk_log.log_ip
     *
     * @return the value of wt_fk_log.log_ip
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     */
    public FkLogEntity withLogIp(String logIp) {
        this.setLogIp(logIp);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.log_ip
     *
     * @param logIp the value for wt_fk_log.log_ip
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * This method returns the value of the database column wt_fk_log.gly_no
     *
     * @return the value of wt_fk_log.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public FkLogEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.gly_no
     *
     * @param glyNo the value for wt_fk_log.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column wt_fk_log.regserial
     *
     * @return the value of wt_fk_log.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public FkLogEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column wt_fk_log.regserial
     *
     * @param regserial the value for wt_fk_log.regserial
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