package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeviceEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mc;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String bz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String ip;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer com;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer port;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer btl;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mm;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String zt;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Byte lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer yzfs;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyPass;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mac;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devXs;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String kmry;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String dyip;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jksz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Byte tjkq;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date onLine;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Byte runState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Byte devLb;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devVersion;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Byte devUp;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer maxFlowNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devLock;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short state;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date kssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date jssj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer payType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer subType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer subDel;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userVersion;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date onlineSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devSearch;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String gateway;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mask;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regserial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer rateEnable;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer mainCard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer btVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer fbtVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer addVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer acVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String acCrc32;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String sysCrc32;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer sysVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer moreCard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String devXh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long devSbId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long devAppId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devLogicBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer dlx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String moduleId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isreal;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer kqSysVer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer kqSysCrc32;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Short signal;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String notice;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal onceAddMax;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer dayAddCount;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private BigDecimal dayAddMax;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-12-28 09:24:17", value = "")
    private Date addSj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer devDorm;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long rechargeInterval;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String xs;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String mj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String pztj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String pzlj;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long depSerial;
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    public Long getDepSerial() {
        return depSerial;
    }

    public void setDepSerial(Long depSerial) {
        this.depSerial = depSerial;
    }

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column st_device.bh
     *
     * @return the value of st_device.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public DeviceEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.bh
     *
     * @param bh the value for st_device.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column st_device.mc
     *
     * @return the value of st_device.mc
     */
    public String getMc() {
        return mc;
    }

    /**
     */
    public DeviceEntity withMc(String mc) {
        this.setMc(mc);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.mc
     *
     * @param mc the value for st_device.mc
     */
    public void setMc(String mc) {
        this.mc = mc;
    }

    /**
     * This method returns the value of the database column st_device.bz
     *
     * @return the value of st_device.bz
     */
    public String getBz() {
        return bz;
    }

    /**
     */
    public DeviceEntity withBz(String bz) {
        this.setBz(bz);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.bz
     *
     * @param bz the value for st_device.bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * This method returns the value of the database column st_device.ip
     *
     * @return the value of st_device.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     */
    public DeviceEntity withIp(String ip) {
        this.setIp(ip);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.ip
     *
     * @param ip the value for st_device.ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * This method returns the value of the database column st_device.com
     *
     * @return the value of st_device.com
     */
    public Integer getCom() {
        return com;
    }

    /**
     */
    public DeviceEntity withCom(Integer com) {
        this.setCom(com);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.com
     *
     * @param com the value for st_device.com
     */
    public void setCom(Integer com) {
        this.com = com;
    }

    /**
     * This method returns the value of the database column st_device.port
     *
     * @return the value of st_device.port
     */
    public Integer getPort() {
        return port;
    }

    /**
     */
    public DeviceEntity withPort(Integer port) {
        this.setPort(port);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.port
     *
     * @param port the value for st_device.port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method returns the value of the database column st_device.btl
     *
     * @return the value of st_device.btl
     */
    public Integer getBtl() {
        return btl;
    }

    /**
     */
    public DeviceEntity withBtl(Integer btl) {
        this.setBtl(btl);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.btl
     *
     * @param btl the value for st_device.btl
     */
    public void setBtl(Integer btl) {
        this.btl = btl;
    }

    /**
     * This method returns the value of the database column st_device.mm
     *
     * @return the value of st_device.mm
     */
    public String getMm() {
        return mm;
    }

    /**
     */
    public DeviceEntity withMm(String mm) {
        this.setMm(mm);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.mm
     *
     * @param mm the value for st_device.mm
     */
    public void setMm(String mm) {
        this.mm = mm;
    }

    /**
     * This method returns the value of the database column st_device.zt
     *
     * @return the value of st_device.zt
     */
    public String getZt() {
        return zt;
    }

    /**
     */
    public DeviceEntity withZt(String zt) {
        this.setZt(zt);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.zt
     *
     * @param zt the value for st_device.zt
     */
    public void setZt(String zt) {
        this.zt = zt;
    }

    /**
     * This method returns the value of the database column st_device.sj
     *
     * @return the value of st_device.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DeviceEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.sj
     *
     * @param sj the value for st_device.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column st_device.lx
     *
     * @return the value of st_device.lx
     */
    public Byte getLx() {
        return lx;
    }

    /**
     */
    public DeviceEntity withLx(Byte lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.lx
     *
     * @param lx the value for st_device.lx
     */
    public void setLx(Byte lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column st_device.yzfs
     *
     * @return the value of st_device.yzfs
     */
    public Integer getYzfs() {
        return yzfs;
    }

    /**
     */
    public DeviceEntity withYzfs(Integer yzfs) {
        this.setYzfs(yzfs);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.yzfs
     *
     * @param yzfs the value for st_device.yzfs
     */
    public void setYzfs(Integer yzfs) {
        this.yzfs = yzfs;
    }

    /**
     * This method returns the value of the database column st_device.gly_no
     *
     * @return the value of st_device.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public DeviceEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.gly_no
     *
     * @param glyNo the value for st_device.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column st_device.gly_pass
     *
     * @return the value of st_device.gly_pass
     */
    public String getGlyPass() {
        return glyPass;
    }

    /**
     */
    public DeviceEntity withGlyPass(String glyPass) {
        this.setGlyPass(glyPass);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.gly_pass
     *
     * @param glyPass the value for st_device.gly_pass
     */
    public void setGlyPass(String glyPass) {
        this.glyPass = glyPass;
    }

    /**
     * This method returns the value of the database column st_device.mac
     *
     * @return the value of st_device.mac
     */
    public String getMac() {
        return mac;
    }

    /**
     */
    public DeviceEntity withMac(String mac) {
        this.setMac(mac);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.mac
     *
     * @param mac the value for st_device.mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * This method returns the value of the database column st_device.dev_xs
     *
     * @return the value of st_device.dev_xs
     */
    public String getDevXs() {
        return devXs;
    }

    /**
     */
    public DeviceEntity withDevXs(String devXs) {
        this.setDevXs(devXs);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_xs
     *
     * @param devXs the value for st_device.dev_xs
     */
    public void setDevXs(String devXs) {
        this.devXs = devXs;
    }

    /**
     * This method returns the value of the database column st_device.dev_lx
     *
     * @return the value of st_device.dev_lx
     */
    public String getDevLx() {
        return devLx;
    }

    /**
     */
    public DeviceEntity withDevLx(String devLx) {
        this.setDevLx(devLx);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_lx
     *
     * @param devLx the value for st_device.dev_lx
     */
    public void setDevLx(String devLx) {
        this.devLx = devLx;
    }

    /**
     * This method returns the value of the database column st_device.kmry
     *
     * @return the value of st_device.kmry
     */
    public String getKmry() {
        return kmry;
    }

    /**
     */
    public DeviceEntity withKmry(String kmry) {
        this.setKmry(kmry);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.kmry
     *
     * @param kmry the value for st_device.kmry
     */
    public void setKmry(String kmry) {
        this.kmry = kmry;
    }

    /**
     * This method returns the value of the database column st_device.dyip
     *
     * @return the value of st_device.dyip
     */
    public String getDyip() {
        return dyip;
    }

    /**
     */
    public DeviceEntity withDyip(String dyip) {
        this.setDyip(dyip);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dyip
     *
     * @param dyip the value for st_device.dyip
     */
    public void setDyip(String dyip) {
        this.dyip = dyip;
    }

    /**
     * This method returns the value of the database column st_device.jksz
     *
     * @return the value of st_device.jksz
     */
    public Integer getJksz() {
        return jksz;
    }

    /**
     */
    public DeviceEntity withJksz(Integer jksz) {
        this.setJksz(jksz);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.jksz
     *
     * @param jksz the value for st_device.jksz
     */
    public void setJksz(Integer jksz) {
        this.jksz = jksz;
    }

    /**
     * This method returns the value of the database column st_device.tjkq
     *
     * @return the value of st_device.tjkq
     */
    public Byte getTjkq() {
        return tjkq;
    }

    /**
     */
    public DeviceEntity withTjkq(Byte tjkq) {
        this.setTjkq(tjkq);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.tjkq
     *
     * @param tjkq the value for st_device.tjkq
     */
    public void setTjkq(Byte tjkq) {
        this.tjkq = tjkq;
    }

    /**
     * This method returns the value of the database column st_device.on_line
     *
     * @return the value of st_device.on_line
     */
    public Date getOnLine() {
        return onLine;
    }

    /**
     */
    public DeviceEntity withOnLine(Date onLine) {
        this.setOnLine(onLine);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.on_line
     *
     * @param onLine the value for st_device.on_line
     */
    public void setOnLine(Date onLine) {
        this.onLine = onLine;
    }

    /**
     * This method returns the value of the database column st_device.run_state
     *
     * @return the value of st_device.run_state
     */
    public Byte getRunState() {
        return runState;
    }

    /**
     */
    public DeviceEntity withRunState(Byte runState) {
        this.setRunState(runState);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.run_state
     *
     * @param runState the value for st_device.run_state
     */
    public void setRunState(Byte runState) {
        this.runState = runState;
    }

    /**
     * This method returns the value of the database column st_device.dev_lb
     *
     * @return the value of st_device.dev_lb
     */
    public Byte getDevLb() {
        return devLb;
    }

    /**
     */
    public DeviceEntity withDevLb(Byte devLb) {
        this.setDevLb(devLb);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_lb
     *
     * @param devLb the value for st_device.dev_lb
     */
    public void setDevLb(Byte devLb) {
        this.devLb = devLb;
    }

    /**
     * This method returns the value of the database column st_device.dev_version
     *
     * @return the value of st_device.dev_version
     */
    public String getDevVersion() {
        return devVersion;
    }

    /**
     */
    public DeviceEntity withDevVersion(String devVersion) {
        this.setDevVersion(devVersion);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_version
     *
     * @param devVersion the value for st_device.dev_version
     */
    public void setDevVersion(String devVersion) {
        this.devVersion = devVersion;
    }

    /**
     * This method returns the value of the database column st_device.dev_up
     *
     * @return the value of st_device.dev_up
     */
    public Byte getDevUp() {
        return devUp;
    }

    /**
     */
    public DeviceEntity withDevUp(Byte devUp) {
        this.setDevUp(devUp);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_up
     *
     * @param devUp the value for st_device.dev_up
     */
    public void setDevUp(Byte devUp) {
        this.devUp = devUp;
    }

    /**
     * This method returns the value of the database column st_device.max_flow_no
     *
     * @return the value of st_device.max_flow_no
     */
    public Integer getMaxFlowNo() {
        return maxFlowNo;
    }

    /**
     */
    public DeviceEntity withMaxFlowNo(Integer maxFlowNo) {
        this.setMaxFlowNo(maxFlowNo);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.max_flow_no
     *
     * @param maxFlowNo the value for st_device.max_flow_no
     */
    public void setMaxFlowNo(Integer maxFlowNo) {
        this.maxFlowNo = maxFlowNo;
    }

    /**
     * This method returns the value of the database column st_device.dev_lock
     *
     * @return the value of st_device.dev_lock
     */
    public Integer getDevLock() {
        return devLock;
    }

    /**
     */
    public DeviceEntity withDevLock(Integer devLock) {
        this.setDevLock(devLock);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_lock
     *
     * @param devLock the value for st_device.dev_lock
     */
    public void setDevLock(Integer devLock) {
        this.devLock = devLock;
    }

    /**
     * This method returns the value of the database column st_device.state
     *
     * @return the value of st_device.state
     */
    public Short getState() {
        return state;
    }

    /**
     */
    public DeviceEntity withState(Short state) {
        this.setState(state);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.state
     *
     * @param state the value for st_device.state
     */
    public void setState(Short state) {
        this.state = state;
    }

    /**
     * This method returns the value of the database column st_device.kssj
     *
     * @return the value of st_device.kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     */
    public DeviceEntity withKssj(Date kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.kssj
     *
     * @param kssj the value for st_device.kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column st_device.jssj
     *
     * @return the value of st_device.jssj
     */
    public Date getJssj() {
        return jssj;
    }

    /**
     */
    public DeviceEntity withJssj(Date jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.jssj
     *
     * @param jssj the value for st_device.jssj
     */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column st_device.dev_id
     *
     * @return the value of st_device.dev_id
     */
    public String getDevId() {
        return devId;
    }

    /**
     */
    public DeviceEntity withDevId(String devId) {
        this.setDevId(devId);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_id
     *
     * @param devId the value for st_device.dev_id
     */
    public void setDevId(String devId) {
        this.devId = devId;
    }

    /**
     * This method returns the value of the database column st_device.pay_type
     *
     * @return the value of st_device.pay_type
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     */
    public DeviceEntity withPayType(Integer payType) {
        this.setPayType(payType);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.pay_type
     *
     * @param payType the value for st_device.pay_type
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method returns the value of the database column st_device.dev_type
     *
     * @return the value of st_device.dev_type
     */
    public Integer getDevType() {
        return devType;
    }

    /**
     */
    public DeviceEntity withDevType(Integer devType) {
        this.setDevType(devType);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_type
     *
     * @param devType the value for st_device.dev_type
     */
    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    /**
     * This method returns the value of the database column st_device.sub_type
     *
     * @return the value of st_device.sub_type
     */
    public Integer getSubType() {
        return subType;
    }

    /**
     */
    public DeviceEntity withSubType(Integer subType) {
        this.setSubType(subType);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.sub_type
     *
     * @param subType the value for st_device.sub_type
     */
    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    /**
     * This method returns the value of the database column st_device.sub_del
     *
     * @return the value of st_device.sub_del
     */
    public Integer getSubDel() {
        return subDel;
    }

    /**
     */
    public DeviceEntity withSubDel(Integer subDel) {
        this.setSubDel(subDel);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.sub_del
     *
     * @param subDel the value for st_device.sub_del
     */
    public void setSubDel(Integer subDel) {
        this.subDel = subDel;
    }

    /**
     * This method returns the value of the database column st_device.user_version
     *
     * @return the value of st_device.user_version
     */
    public Integer getUserVersion() {
        return userVersion;
    }

    /**
     */
    public DeviceEntity withUserVersion(Integer userVersion) {
        this.setUserVersion(userVersion);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.user_version
     *
     * @param userVersion the value for st_device.user_version
     */
    public void setUserVersion(Integer userVersion) {
        this.userVersion = userVersion;
    }

    /**
     * This method returns the value of the database column st_device.online_sj
     *
     * @return the value of st_device.online_sj
     */
    public Date getOnlineSj() {
        return onlineSj;
    }

    /**
     */
    public DeviceEntity withOnlineSj(Date onlineSj) {
        this.setOnlineSj(onlineSj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.online_sj
     *
     * @param onlineSj the value for st_device.online_sj
     */
    public void setOnlineSj(Date onlineSj) {
        this.onlineSj = onlineSj;
    }

    /**
     * This method returns the value of the database column st_device.dev_search
     *
     * @return the value of st_device.dev_search
     */
    public Integer getDevSearch() {
        return devSearch;
    }

    /**
     */
    public DeviceEntity withDevSearch(Integer devSearch) {
        this.setDevSearch(devSearch);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_search
     *
     * @param devSearch the value for st_device.dev_search
     */
    public void setDevSearch(Integer devSearch) {
        this.devSearch = devSearch;
    }

    /**
     * This method returns the value of the database column st_device.gateway
     *
     * @return the value of st_device.gateway
     */
    public String getGateway() {
        return gateway;
    }

    /**
     */
    public DeviceEntity withGateway(String gateway) {
        this.setGateway(gateway);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.gateway
     *
     * @param gateway the value for st_device.gateway
     */
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * This method returns the value of the database column st_device.mask
     *
     * @return the value of st_device.mask
     */
    public String getMask() {
        return mask;
    }

    /**
     */
    public DeviceEntity withMask(String mask) {
        this.setMask(mask);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.mask
     *
     * @param mask the value for st_device.mask
     */
    public void setMask(String mask) {
        this.mask = mask;
    }

    /**
     * This method returns the value of the database column st_device.regserial
     *
     * @return the value of st_device.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public DeviceEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.regserial
     *
     * @param regserial the value for st_device.regserial
     */
    public void setRegserial(String regserial) {
        this.regserial = regserial;
    }

    /**
     * This method returns the value of the database column st_device.rate_enable
     *
     * @return the value of st_device.rate_enable
     */
    public Integer getRateEnable() {
        return rateEnable;
    }

    /**
     */
    public DeviceEntity withRateEnable(Integer rateEnable) {
        this.setRateEnable(rateEnable);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.rate_enable
     *
     * @param rateEnable the value for st_device.rate_enable
     */
    public void setRateEnable(Integer rateEnable) {
        this.rateEnable = rateEnable;
    }

    /**
     * This method returns the value of the database column st_device.main_card
     *
     * @return the value of st_device.main_card
     */
    public Integer getMainCard() {
        return mainCard;
    }

    /**
     */
    public DeviceEntity withMainCard(Integer mainCard) {
        this.setMainCard(mainCard);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.main_card
     *
     * @param mainCard the value for st_device.main_card
     */
    public void setMainCard(Integer mainCard) {
        this.mainCard = mainCard;
    }

    /**
     * This method returns the value of the database column st_device.bt_ver
     *
     * @return the value of st_device.bt_ver
     */
    public Integer getBtVer() {
        return btVer;
    }

    /**
     */
    public DeviceEntity withBtVer(Integer btVer) {
        this.setBtVer(btVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.bt_ver
     *
     * @param btVer the value for st_device.bt_ver
     */
    public void setBtVer(Integer btVer) {
        this.btVer = btVer;
    }

    /**
     * This method returns the value of the database column st_device.fbt_ver
     *
     * @return the value of st_device.fbt_ver
     */
    public Integer getFbtVer() {
        return fbtVer;
    }

    /**
     */
    public DeviceEntity withFbtVer(Integer fbtVer) {
        this.setFbtVer(fbtVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.fbt_ver
     *
     * @param fbtVer the value for st_device.fbt_ver
     */
    public void setFbtVer(Integer fbtVer) {
        this.fbtVer = fbtVer;
    }

    /**
     * This method returns the value of the database column st_device.add_ver
     *
     * @return the value of st_device.add_ver
     */
    public Integer getAddVer() {
        return addVer;
    }

    /**
     */
    public DeviceEntity withAddVer(Integer addVer) {
        this.setAddVer(addVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.add_ver
     *
     * @param addVer the value for st_device.add_ver
     */
    public void setAddVer(Integer addVer) {
        this.addVer = addVer;
    }

    /**
     * This method returns the value of the database column st_device.ac_ver
     *
     * @return the value of st_device.ac_ver
     */
    public Integer getAcVer() {
        return acVer;
    }

    /**
     */
    public DeviceEntity withAcVer(Integer acVer) {
        this.setAcVer(acVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.ac_ver
     *
     * @param acVer the value for st_device.ac_ver
     */
    public void setAcVer(Integer acVer) {
        this.acVer = acVer;
    }

    /**
     * This method returns the value of the database column st_device.ac_crc32
     *
     * @return the value of st_device.ac_crc32
     */
    public String getAcCrc32() {
        return acCrc32;
    }

    /**
     */
    public DeviceEntity withAcCrc32(String acCrc32) {
        this.setAcCrc32(acCrc32);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.ac_crc32
     *
     * @param acCrc32 the value for st_device.ac_crc32
     */
    public void setAcCrc32(String acCrc32) {
        this.acCrc32 = acCrc32;
    }

    /**
     * This method returns the value of the database column st_device.sys_crc32
     *
     * @return the value of st_device.sys_crc32
     */
    public String getSysCrc32() {
        return sysCrc32;
    }

    /**
     */
    public DeviceEntity withSysCrc32(String sysCrc32) {
        this.setSysCrc32(sysCrc32);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.sys_crc32
     *
     * @param sysCrc32 the value for st_device.sys_crc32
     */
    public void setSysCrc32(String sysCrc32) {
        this.sysCrc32 = sysCrc32;
    }

    /**
     * This method returns the value of the database column st_device.sys_ver
     *
     * @return the value of st_device.sys_ver
     */
    public Integer getSysVer() {
        return sysVer;
    }

    /**
     */
    public DeviceEntity withSysVer(Integer sysVer) {
        this.setSysVer(sysVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.sys_ver
     *
     * @param sysVer the value for st_device.sys_ver
     */
    public void setSysVer(Integer sysVer) {
        this.sysVer = sysVer;
    }

    /**
     * This method returns the value of the database column st_device.more_card
     *
     * @return the value of st_device.more_card
     */
    public Integer getMoreCard() {
        return moreCard;
    }

    /**
     */
    public DeviceEntity withMoreCard(Integer moreCard) {
        this.setMoreCard(moreCard);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.more_card
     *
     * @param moreCard the value for st_device.more_card
     */
    public void setMoreCard(Integer moreCard) {
        this.moreCard = moreCard;
    }

    /**
     * This method returns the value of the database column st_device.dev_xh
     *
     * @return the value of st_device.dev_xh
     */
    public String getDevXh() {
        return devXh;
    }

    /**
     */
    public DeviceEntity withDevXh(String devXh) {
        this.setDevXh(devXh);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_xh
     *
     * @param devXh the value for st_device.dev_xh
     */
    public void setDevXh(String devXh) {
        this.devXh = devXh;
    }

    /**
     * This method returns the value of the database column st_device.dev_sb_id
     *
     * @return the value of st_device.dev_sb_id
     */
    public Long getDevSbId() {
        return devSbId;
    }

    /**
     */
    public DeviceEntity withDevSbId(Long devSbId) {
        this.setDevSbId(devSbId);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_sb_id
     *
     * @param devSbId the value for st_device.dev_sb_id
     */
    public void setDevSbId(Long devSbId) {
        this.devSbId = devSbId;
    }

    /**
     * This method returns the value of the database column st_device.dev_state
     *
     * @return the value of st_device.dev_state
     */
    public Integer getDevState() {
        return devState;
    }

    /**
     */
    public DeviceEntity withDevState(Integer devState) {
        this.setDevState(devState);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_state
     *
     * @param devState the value for st_device.dev_state
     */
    public void setDevState(Integer devState) {
        this.devState = devState;
    }

    /**
     * This method returns the value of the database column st_device.dev_app_id
     *
     * @return the value of st_device.dev_app_id
     */
    public Long getDevAppId() {
        return devAppId;
    }

    /**
     */
    public DeviceEntity withDevAppId(Long devAppId) {
        this.setDevAppId(devAppId);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_app_id
     *
     * @param devAppId the value for st_device.dev_app_id
     */
    public void setDevAppId(Long devAppId) {
        this.devAppId = devAppId;
    }

    /**
     * This method returns the value of the database column st_device.dev_logic_bh
     *
     * @return the value of st_device.dev_logic_bh
     */
    public Integer getDevLogicBh() {
        return devLogicBh;
    }

    /**
     */
    public DeviceEntity withDevLogicBh(Integer devLogicBh) {
        this.setDevLogicBh(devLogicBh);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_logic_bh
     *
     * @param devLogicBh the value for st_device.dev_logic_bh
     */
    public void setDevLogicBh(Integer devLogicBh) {
        this.devLogicBh = devLogicBh;
    }

    /**
     * This method returns the value of the database column st_device.dlx
     *
     * @return the value of st_device.dlx
     */
    public Integer getDlx() {
        return dlx;
    }

    /**
     */
    public DeviceEntity withDlx(Integer dlx) {
        this.setDlx(dlx);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dlx
     *
     * @param dlx the value for st_device.dlx
     */
    public void setDlx(Integer dlx) {
        this.dlx = dlx;
    }

    /**
     * This method returns the value of the database column st_device.module_id
     *
     * @return the value of st_device.module_id
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     */
    public DeviceEntity withModuleId(String moduleId) {
        this.setModuleId(moduleId);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.module_id
     *
     * @param moduleId the value for st_device.module_id
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method returns the value of the database column st_device.isReal
     *
     * @return the value of st_device.isReal
     */
    public Integer getIsreal() {
        return isreal;
    }

    /**
     */
    public DeviceEntity withIsreal(Integer isreal) {
        this.setIsreal(isreal);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.isReal
     *
     * @param isreal the value for st_device.isReal
     */
    public void setIsreal(Integer isreal) {
        this.isreal = isreal;
    }

    /**
     * This method returns the value of the database column st_device.kq_sys_ver
     *
     * @return the value of st_device.kq_sys_ver
     */
    public Integer getKqSysVer() {
        return kqSysVer;
    }

    /**
     */
    public DeviceEntity withKqSysVer(Integer kqSysVer) {
        this.setKqSysVer(kqSysVer);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.kq_sys_ver
     *
     * @param kqSysVer the value for st_device.kq_sys_ver
     */
    public void setKqSysVer(Integer kqSysVer) {
        this.kqSysVer = kqSysVer;
    }

    /**
     * This method returns the value of the database column st_device.kq_sys_crc32
     *
     * @return the value of st_device.kq_sys_crc32
     */
    public Integer getKqSysCrc32() {
        return kqSysCrc32;
    }

    /**
     */
    public DeviceEntity withKqSysCrc32(Integer kqSysCrc32) {
        this.setKqSysCrc32(kqSysCrc32);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.kq_sys_crc32
     *
     * @param kqSysCrc32 the value for st_device.kq_sys_crc32
     */
    public void setKqSysCrc32(Integer kqSysCrc32) {
        this.kqSysCrc32 = kqSysCrc32;
    }

    /**
     * This method returns the value of the database column st_device.signal
     *
     * @return the value of st_device.signal
     */
    public Short getSignal() {
        return signal;
    }

    /**
     */
    public DeviceEntity withSignal(Short signal) {
        this.setSignal(signal);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.signal
     *
     * @param signal the value for st_device.signal
     */
    public void setSignal(Short signal) {
        this.signal = signal;
    }

    /**
     * This method returns the value of the database column st_device.notice
     *
     * @return the value of st_device.notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     */
    public DeviceEntity withNotice(String notice) {
        this.setNotice(notice);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.notice
     *
     * @param notice the value for st_device.notice
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * This method returns the value of the database column st_device.once_add_max
     *
     * @return the value of st_device.once_add_max
     */
    public BigDecimal getOnceAddMax() {
        return onceAddMax;
    }

    /**
     */
    public DeviceEntity withOnceAddMax(BigDecimal onceAddMax) {
        this.setOnceAddMax(onceAddMax);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.once_add_max
     *
     * @param onceAddMax the value for st_device.once_add_max
     */
    public void setOnceAddMax(BigDecimal onceAddMax) {
        this.onceAddMax = onceAddMax;
    }

    /**
     * This method returns the value of the database column st_device.day_add_count
     *
     * @return the value of st_device.day_add_count
     */
    public Integer getDayAddCount() {
        return dayAddCount;
    }

    /**
     */
    public DeviceEntity withDayAddCount(Integer dayAddCount) {
        this.setDayAddCount(dayAddCount);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.day_add_count
     *
     * @param dayAddCount the value for st_device.day_add_count
     */
    public void setDayAddCount(Integer dayAddCount) {
        this.dayAddCount = dayAddCount;
    }

    /**
     * This method returns the value of the database column st_device.day_add_max
     *
     * @return the value of st_device.day_add_max
     */
    public BigDecimal getDayAddMax() {
        return dayAddMax;
    }

    /**
     */
    public DeviceEntity withDayAddMax(BigDecimal dayAddMax) {
        this.setDayAddMax(dayAddMax);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.day_add_max
     *
     * @param dayAddMax the value for st_device.day_add_max
     */
    public void setDayAddMax(BigDecimal dayAddMax) {
        this.dayAddMax = dayAddMax;
    }

    /**
     * This method returns the value of the database column st_device.add_sj
     *
     * @return the value of st_device.add_sj
     */
    public Date getAddSj() {
        return addSj;
    }

    /**
     */
    public DeviceEntity withAddSj(Date addSj) {
        this.setAddSj(addSj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.add_sj
     *
     * @param addSj the value for st_device.add_sj
     */
    public void setAddSj(Date addSj) {
        this.addSj = addSj;
    }

    /**
     * This method returns the value of the database column st_device.dev_dorm
     *
     * @return the value of st_device.dev_dorm
     */
    public Integer getDevDorm() {
        return devDorm;
    }

    /**
     */
    public DeviceEntity withDevDorm(Integer devDorm) {
        this.setDevDorm(devDorm);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.dev_dorm
     *
     * @param devDorm the value for st_device.dev_dorm
     */
    public void setDevDorm(Integer devDorm) {
        this.devDorm = devDorm;
    }

    /**
     * This method returns the value of the database column st_device.recharge_interval
     *
     * @return the value of st_device.recharge_interval
     */
    public Long getRechargeInterval() {
        return rechargeInterval;
    }

    /**
     */
    public DeviceEntity withRechargeInterval(Long rechargeInterval) {
        this.setRechargeInterval(rechargeInterval);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.recharge_interval
     *
     * @param rechargeInterval the value for st_device.recharge_interval
     */
    public void setRechargeInterval(Long rechargeInterval) {
        this.rechargeInterval = rechargeInterval;
    }

    /**
     * This method returns the value of the database column st_device.xs
     *
     * @return the value of st_device.xs
     */
    public String getXs() {
        return xs;
    }

    /**
     */
    public DeviceEntity withXs(String xs) {
        this.setXs(xs);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.xs
     *
     * @param xs the value for st_device.xs
     */
    public void setXs(String xs) {
        this.xs = xs;
    }

    /**
     * This method returns the value of the database column st_device.mj
     *
     * @return the value of st_device.mj
     */
    public String getMj() {
        return mj;
    }

    /**
     */
    public DeviceEntity withMj(String mj) {
        this.setMj(mj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.mj
     *
     * @param mj the value for st_device.mj
     */
    public void setMj(String mj) {
        this.mj = mj;
    }

    /**
     * This method returns the value of the database column st_device.pztj
     *
     * @return the value of st_device.pztj
     */
    public String getPztj() {
        return pztj;
    }

    /**
     */
    public DeviceEntity withPztj(String pztj) {
        this.setPztj(pztj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.pztj
     *
     * @param pztj the value for st_device.pztj
     */
    public void setPztj(String pztj) {
        this.pztj = pztj;
    }

    /**
     * This method returns the value of the database column st_device.pzlj
     *
     * @return the value of st_device.pzlj
     */
    public String getPzlj() {
        return pzlj;
    }

    /**
     */
    public DeviceEntity withPzlj(String pzlj) {
        this.setPzlj(pzlj);
        return this;
    }

    /**
     * This method sets the value of the database column st_device.pzlj
     *
     * @param pzlj the value for st_device.pzlj
     */
    public void setPzlj(String pzlj) {
        this.pzlj = pzlj;
    }
}