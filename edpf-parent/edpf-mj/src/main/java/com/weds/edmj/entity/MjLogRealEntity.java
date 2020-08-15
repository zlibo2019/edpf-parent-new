package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class MjLogRealEntity extends BaseEntity implements Serializable {
    /**
     *   自增序号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     *   日志类型
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "日志类型")
    private Integer lx;

    /**
     *   日志存储内容
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "日志存储内容")
    private Integer logType;

    /**
     *   日志操作结果
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "日志操作结果")
    private Integer logState;

    /**
     *   日志内容
     *
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "日志内容")
    private String logBz;

    /**
     *   执行操作的日期
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-01 10:16:26", value = "执行操作的日期")
    private Date logSj;

    /**
     *   操作ip
     *
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作ip")
    private String logIp;

    /**
     *   操作员
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     *   企业编号
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "企业编号")
    private String regserial;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column wt_mj_log_real.xh
     *
     * @return the value of wt_mj_log_real.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public MjLogRealEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.xh
     *
     * @param xh the value for wt_mj_log_real.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.lx
     *
     * @return the value of wt_mj_log_real.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public MjLogRealEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.lx
     *
     * @param lx the value for wt_mj_log_real.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.log_type
     *
     * @return the value of wt_mj_log_real.log_type
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     */
    public MjLogRealEntity withLogType(Integer logType) {
        this.setLogType(logType);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.log_type
     *
     * @param logType the value for wt_mj_log_real.log_type
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.log_state
     *
     * @return the value of wt_mj_log_real.log_state
     */
    public Integer getLogState() {
        return logState;
    }

    /**
     */
    public MjLogRealEntity withLogState(Integer logState) {
        this.setLogState(logState);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.log_state
     *
     * @param logState the value for wt_mj_log_real.log_state
     */
    public void setLogState(Integer logState) {
        this.logState = logState;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.log_bz
     *
     * @return the value of wt_mj_log_real.log_bz
     */
    public String getLogBz() {
        return logBz;
    }

    /**
     */
    public MjLogRealEntity withLogBz(String logBz) {
        this.setLogBz(logBz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.log_bz
     *
     * @param logBz the value for wt_mj_log_real.log_bz
     */
    public void setLogBz(String logBz) {
        this.logBz = logBz;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.log_sj
     *
     * @return the value of wt_mj_log_real.log_sj
     */
    public Date getLogSj() {
        return logSj;
    }

    /**
     */
    public MjLogRealEntity withLogSj(Date logSj) {
        this.setLogSj(logSj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.log_sj
     *
     * @param logSj the value for wt_mj_log_real.log_sj
     */
    public void setLogSj(Date logSj) {
        this.logSj = logSj;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.log_ip
     *
     * @return the value of wt_mj_log_real.log_ip
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     */
    public MjLogRealEntity withLogIp(String logIp) {
        this.setLogIp(logIp);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.log_ip
     *
     * @param logIp the value for wt_mj_log_real.log_ip
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.gly_no
     *
     * @return the value of wt_mj_log_real.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MjLogRealEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.gly_no
     *
     * @param glyNo the value for wt_mj_log_real.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column wt_mj_log_real.regserial
     *
     * @return the value of wt_mj_log_real.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public MjLogRealEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_log_real.regserial
     *
     * @param regserial the value for wt_mj_log_real.regserial
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