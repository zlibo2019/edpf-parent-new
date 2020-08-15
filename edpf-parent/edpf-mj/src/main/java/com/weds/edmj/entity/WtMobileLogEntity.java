package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 * @Author sxm
 * @Description 手机门禁日志
 * @Date 2019-08-08
 */
public class WtMobileLogEntity extends ExportRptEntity implements Serializable {
    /**
     * 自增序号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "自增序号")
    private Integer xh;

    /**
     * 类型#1##1#9#04011
     */
    @Dict("04011")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "类型#1##1#9#04011")
    private Integer lx;

    /**
     * 状态#1##1#9#04012
     */
    @Dict("04012")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "状态#1##1#9#04012")
    private Integer state;

    /**
     * 人员工号#1####
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "人员工号#1####")
    private String userNo;

    /**
     * 物理门编号#1####
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "物理门编号#1####")
    private String gateBh;

    /**
     * 手机mac
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "手机mac")
    private String phMac;

    /**
     * 手机ip
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "手机ip")
    private String phIp;

    /**
     * 手机串号
     */
    @Size(max = 40)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "手机串号")
    private String phImei;

    /**
     * 手机信息
     */
    @Size(max = 200)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "手机信息")
    private String phInfo;

    /**
     * 备注
     */
    @Size(max = 300)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "备注")
    private String bz;

    /**
     * 更新的日期#1##1#8#
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-08 08:52:32", value = "更新的日期#1##1#8#")
    private Date sj;

    /**
     * 操作员
     */
    @Size(max = 100)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "操作员")
    private String glyNo;

    /**
     * 政企字段
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "政企字段")
    private String regserial;

    private String userLname;
    private String doorName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date kssj;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date jssj;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column WT_mobile_log.xh
     *
     * @return the value of WT_mobile_log.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public WtMobileLogEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.xh
     *
     * @param xh the value for WT_mobile_log.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.lx
     *
     * @return the value of WT_mobile_log.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public WtMobileLogEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.lx
     *
     * @param lx the value for WT_mobile_log.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.state
     *
     * @return the value of WT_mobile_log.state
     */
    public Integer getState() {
        return state;
    }

    /**
     */
    public WtMobileLogEntity withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.state
     *
     * @param state the value for WT_mobile_log.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.user_no
     *
     * @return the value of WT_mobile_log.user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     */
    public WtMobileLogEntity withUserNo(String userNo) {
        this.setUserNo(userNo);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.user_no
     *
     * @param userNo the value for WT_mobile_log.user_no
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.gate_bh
     *
     * @return the value of WT_mobile_log.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public WtMobileLogEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.gate_bh
     *
     * @param gateBh the value for WT_mobile_log.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.ph_mac
     *
     * @return the value of WT_mobile_log.ph_mac
     */
    public String getPhMac() {
        return phMac;
    }

    /**
     */
    public WtMobileLogEntity withPhMac(String phMac) {
        this.setPhMac(phMac);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.ph_mac
     *
     * @param phMac the value for WT_mobile_log.ph_mac
     */
    public void setPhMac(String phMac) {
        this.phMac = phMac;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.ph_ip
     *
     * @return the value of WT_mobile_log.ph_ip
     */
    public String getPhIp() {
        return phIp;
    }

    /**
     */
    public WtMobileLogEntity withPhIp(String phIp) {
        this.setPhIp(phIp);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.ph_ip
     *
     * @param phIp the value for WT_mobile_log.ph_ip
     */
    public void setPhIp(String phIp) {
        this.phIp = phIp;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.ph_imei
     *
     * @return the value of WT_mobile_log.ph_imei
     */
    public String getPhImei() {
        return phImei;
    }

    /**
     */
    public WtMobileLogEntity withPhImei(String phImei) {
        this.setPhImei(phImei);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.ph_imei
     *
     * @param phImei the value for WT_mobile_log.ph_imei
     */
    public void setPhImei(String phImei) {
        this.phImei = phImei;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.ph_info
     *
     * @return the value of WT_mobile_log.ph_info
     */
    public String getPhInfo() {
        return phInfo;
    }

    /**
     */
    public WtMobileLogEntity withPhInfo(String phInfo) {
        this.setPhInfo(phInfo);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.ph_info
     *
     * @param phInfo the value for WT_mobile_log.ph_info
     */
    public void setPhInfo(String phInfo) {
        this.phInfo = phInfo;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.bz
     *
     * @return the value of WT_mobile_log.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public WtMobileLogEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.bz
     *
     * @param bz the value for WT_mobile_log.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.sj
     *
     * @return the value of WT_mobile_log.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public WtMobileLogEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.sj
     *
     * @param sj the value for WT_mobile_log.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.gly_no
     *
     * @return the value of WT_mobile_log.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public WtMobileLogEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.gly_no
     *
     * @param glyNo the value for WT_mobile_log.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column WT_mobile_log.regserial
     *
     * @return the value of WT_mobile_log.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public WtMobileLogEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column WT_mobile_log.regserial
     *
     * @param regserial the value for WT_mobile_log.regserial
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

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }
}