package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 配置文件更新的日志
 * @Date 2019-07-29
 */
public class WtMjVerEntity extends BaseEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 操作类型
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "操作类型")
    private Integer type;

    /**
     * 日志记录的操作类型（具体根据软件）
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "日志记录的操作类型（具体根据软件）")
    private Integer lx;

    /**
     * 档案更新的日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-29 16:59:33", value = "档案更新的日期")
    private Date logSj;

    /**
     * 操作ip
     */
    @Size(max = 30)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作ip")
    private String logIp;

    /**
     * 操作员
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     * 设备编号
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "设备编号")
    private String devSerial;

    /**
     * 物理门编号
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号")
    private String gateBh;

    /**
     * 1新增
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "1新增")
    private Integer logLx;

    /**
     * 日志详细信息
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "日志详细信息")
    private String logBz;

    /**
     * 门方向序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "门方向序号")
    private Integer fx;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column wt_mj_ver.xh
     *
     * @return the value of wt_mj_ver.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public WtMjVerEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.xh
     *
     * @param xh the value for wt_mj_ver.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.type
     *
     * @return the value of wt_mj_ver.type
     */
    public Integer getType() {
        return type;
    }

    /**
     */
    public WtMjVerEntity withType(Integer type) {
        this.setType(type);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.type
     *
     * @param type the value for wt_mj_ver.type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.lx
     *
     * @return the value of wt_mj_ver.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public WtMjVerEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.lx
     *
     * @param lx the value for wt_mj_ver.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.log_sj
     *
     * @return the value of wt_mj_ver.log_sj
     */
    public Date getLogSj() {
        return logSj;
    }

    /**
     */
    public WtMjVerEntity withLogSj(Date logSj) {
        this.setLogSj(logSj);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.log_sj
     *
     * @param logSj the value for wt_mj_ver.log_sj
     */
    public void setLogSj(Date logSj) {
        this.logSj = logSj;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.log_ip
     *
     * @return the value of wt_mj_ver.log_ip
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     */
    public WtMjVerEntity withLogIp(String logIp) {
        this.setLogIp(logIp);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.log_ip
     *
     * @param logIp the value for wt_mj_ver.log_ip
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.gly_no
     *
     * @return the value of wt_mj_ver.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public WtMjVerEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.gly_no
     *
     * @param glyNo the value for wt_mj_ver.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.dev_serial
     *
     * @return the value of wt_mj_ver.dev_serial
     */
    public String getDevSerial() {
        return devSerial;
    }

    /**
     */
    public WtMjVerEntity withDevSerial(String devSerial) {
        this.setDevSerial(devSerial);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.dev_serial
     *
     * @param devSerial the value for wt_mj_ver.dev_serial
     */
    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.Gate_bh
     *
     * @return the value of wt_mj_ver.Gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public WtMjVerEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.Gate_bh
     *
     * @param gateBh the value for wt_mj_ver.Gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.log_lx
     *
     * @return the value of wt_mj_ver.log_lx
     */
    public Integer getLogLx() {
        return logLx;
    }

    /**
     */
    public WtMjVerEntity withLogLx(Integer logLx) {
        this.setLogLx(logLx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.log_lx
     *
     * @param logLx the value for wt_mj_ver.log_lx
     */
    public void setLogLx(Integer logLx) {
        this.logLx = logLx;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.log_bz
     *
     * @return the value of wt_mj_ver.log_bz
     */
    public String getLogBz() {
        return logBz;
    }

    /**
     */
    public WtMjVerEntity withLogBz(String logBz) {
        this.setLogBz(logBz);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.log_bz
     *
     * @param logBz the value for wt_mj_ver.log_bz
     */
    public void setLogBz(String logBz) {
        this.logBz = logBz;
    }

    /**
     * This method returns the value of the database column wt_mj_ver.fx
     *
     * @return the value of wt_mj_ver.fx
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public WtMjVerEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column wt_mj_ver.fx
     *
     * @param fx the value for wt_mj_ver.fx
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}