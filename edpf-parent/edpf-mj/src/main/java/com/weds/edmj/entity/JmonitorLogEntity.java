package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class JmonitorLogEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jid;

    /**
     *
     */
    @Size(max = 7)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jdevBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte jdoor;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte jdoorDir;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlogSn;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-14 17:26:34", value = "")
    private Date jlogTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte jlogStyle;

    /**
     *
     */
    @Size(max = 17)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jcard;

    /**
     *
     */
    @Size(max = 25)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jlogName;

    /**
     *
     */
    @Size(max = 10)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jdoorDirname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jlogState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer userSerial;

    /**
     *
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String gateBh;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userLname;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String userDepname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jframeId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Byte userLx;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column jmonitor_log.JID
     *
     * @return the value of jmonitor_log.JID
     */
    public Integer getJid() {
        return jid;
    }

    /**
     */
    public JmonitorLogEntity withJid(Integer jid) {
        this.setJid(jid);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.JID
     *
     * @param jid the value for jmonitor_log.JID
     */
    public void setJid(Integer jid) {
        this.jid = jid;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jdev_bh
     *
     * @return the value of jmonitor_log.jdev_bh
     */
    public String getJdevBh() {
        return jdevBh;
    }

    /**
     */
    public JmonitorLogEntity withJdevBh(String jdevBh) {
        this.setJdevBh(jdevBh);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jdev_bh
     *
     * @param jdevBh the value for jmonitor_log.jdev_bh
     */
    public void setJdevBh(String jdevBh) {
        this.jdevBh = jdevBh;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jdoor
     *
     * @return the value of jmonitor_log.jdoor
     */
    public Byte getJdoor() {
        return jdoor;
    }

    /**
     */
    public JmonitorLogEntity withJdoor(Byte jdoor) {
        this.setJdoor(jdoor);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jdoor
     *
     * @param jdoor the value for jmonitor_log.jdoor
     */
    public void setJdoor(Byte jdoor) {
        this.jdoor = jdoor;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jdoor_dir
     *
     * @return the value of jmonitor_log.jdoor_dir
     */
    public Byte getJdoorDir() {
        return jdoorDir;
    }

    /**
     */
    public JmonitorLogEntity withJdoorDir(Byte jdoorDir) {
        this.setJdoorDir(jdoorDir);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jdoor_dir
     *
     * @param jdoorDir the value for jmonitor_log.jdoor_dir
     */
    public void setJdoorDir(Byte jdoorDir) {
        this.jdoorDir = jdoorDir;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jlog_sn
     *
     * @return the value of jmonitor_log.jlog_sn
     */
    public Integer getJlogSn() {
        return jlogSn;
    }

    /**
     */
    public JmonitorLogEntity withJlogSn(Integer jlogSn) {
        this.setJlogSn(jlogSn);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jlog_sn
     *
     * @param jlogSn the value for jmonitor_log.jlog_sn
     */
    public void setJlogSn(Integer jlogSn) {
        this.jlogSn = jlogSn;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jlog_time
     *
     * @return the value of jmonitor_log.jlog_time
     */
    public Date getJlogTime() {
        return jlogTime;
    }

    /**
     */
    public JmonitorLogEntity withJlogTime(Date jlogTime) {
        this.setJlogTime(jlogTime);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jlog_time
     *
     * @param jlogTime the value for jmonitor_log.jlog_time
     */
    public void setJlogTime(Date jlogTime) {
        this.jlogTime = jlogTime;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jlog_style
     *
     * @return the value of jmonitor_log.jlog_style
     */
    public Byte getJlogStyle() {
        return jlogStyle;
    }

    /**
     */
    public JmonitorLogEntity withJlogStyle(Byte jlogStyle) {
        this.setJlogStyle(jlogStyle);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jlog_style
     *
     * @param jlogStyle the value for jmonitor_log.jlog_style
     */
    public void setJlogStyle(Byte jlogStyle) {
        this.jlogStyle = jlogStyle;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jcard
     *
     * @return the value of jmonitor_log.jcard
     */
    public String getJcard() {
        return jcard;
    }

    /**
     */
    public JmonitorLogEntity withJcard(String jcard) {
        this.setJcard(jcard);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jcard
     *
     * @param jcard the value for jmonitor_log.jcard
     */
    public void setJcard(String jcard) {
        this.jcard = jcard;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jlog_name
     *
     * @return the value of jmonitor_log.jlog_name
     */
    public String getJlogName() {
        return jlogName;
    }

    /**
     */
    public JmonitorLogEntity withJlogName(String jlogName) {
        this.setJlogName(jlogName);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jlog_name
     *
     * @param jlogName the value for jmonitor_log.jlog_name
     */
    public void setJlogName(String jlogName) {
        this.jlogName = jlogName;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jdoor_dirname
     *
     * @return the value of jmonitor_log.jdoor_dirname
     */
    public String getJdoorDirname() {
        return jdoorDirname;
    }

    /**
     */
    public JmonitorLogEntity withJdoorDirname(String jdoorDirname) {
        this.setJdoorDirname(jdoorDirname);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jdoor_dirname
     *
     * @param jdoorDirname the value for jmonitor_log.jdoor_dirname
     */
    public void setJdoorDirname(String jdoorDirname) {
        this.jdoorDirname = jdoorDirname;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jlog_state
     *
     * @return the value of jmonitor_log.jlog_state
     */
    public Integer getJlogState() {
        return jlogState;
    }

    /**
     */
    public JmonitorLogEntity withJlogState(Integer jlogState) {
        this.setJlogState(jlogState);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jlog_state
     *
     * @param jlogState the value for jmonitor_log.jlog_state
     */
    public void setJlogState(Integer jlogState) {
        this.jlogState = jlogState;
    }

    /**
     * This method returns the value of the database column jmonitor_log.user_serial
     *
     * @return the value of jmonitor_log.user_serial
     */
    public Integer getUserSerial() {
        return userSerial;
    }

    /**
     */
    public JmonitorLogEntity withUserSerial(Integer userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.user_serial
     *
     * @param userSerial the value for jmonitor_log.user_serial
     */
    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column jmonitor_log.Gate_Bh
     *
     * @return the value of jmonitor_log.Gate_Bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public JmonitorLogEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.Gate_Bh
     *
     * @param gateBh the value for jmonitor_log.Gate_Bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column jmonitor_log.user_lname
     *
     * @return the value of jmonitor_log.user_lname
     */
    public String getUserLname() {
        return userLname;
    }

    /**
     */
    public JmonitorLogEntity withUserLname(String userLname) {
        this.setUserLname(userLname);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.user_lname
     *
     * @param userLname the value for jmonitor_log.user_lname
     */
    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    /**
     * This method returns the value of the database column jmonitor_log.user_depname
     *
     * @return the value of jmonitor_log.user_depname
     */
    public String getUserDepname() {
        return userDepname;
    }

    /**
     */
    public JmonitorLogEntity withUserDepname(String userDepname) {
        this.setUserDepname(userDepname);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.user_depname
     *
     * @param userDepname the value for jmonitor_log.user_depname
     */
    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    /**
     * This method returns the value of the database column jmonitor_log.jframe_id
     *
     * @return the value of jmonitor_log.jframe_id
     */
    public Integer getJframeId() {
        return jframeId;
    }

    /**
     */
    public JmonitorLogEntity withJframeId(Integer jframeId) {
        this.setJframeId(jframeId);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.jframe_id
     *
     * @param jframeId the value for jmonitor_log.jframe_id
     */
    public void setJframeId(Integer jframeId) {
        this.jframeId = jframeId;
    }

    /**
     * This method returns the value of the database column jmonitor_log.user_lx
     *
     * @return the value of jmonitor_log.user_lx
     */
    public Byte getUserLx() {
        return userLx;
    }

    /**
     */
    public JmonitorLogEntity withUserLx(Byte userLx) {
        this.setUserLx(userLx);
        return this;
    }

    /**
     * This method sets the value of the database column jmonitor_log.user_lx
     *
     * @param userLx the value for jmonitor_log.user_lx
     */
    public void setUserLx(Byte userLx) {
        this.userLx = userLx;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
    @ApiModelProperty(dataType = "list", value = "场所列表")
    private List<Integer> placeList;
    @ApiModelProperty(dataType = "list", value = "门列表")
    private List<String> gateList;

    private String doorName;

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public List<Integer> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Integer> placeList) {
        this.placeList = placeList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }
}