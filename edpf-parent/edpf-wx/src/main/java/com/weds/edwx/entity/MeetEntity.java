package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MeetEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String lname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String moduleId;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:36:23", value = "")
    private Date kssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:36:23", value = "")
    private Date jssj;

    private List<MeetSpEntity> list;

    private String userLname;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public List<MeetSpEntity> getList() {
        return list;
    }

    public void setList(List<MeetSpEntity> list) {
        this.list = list;
    }

    private List<MeetMdEntity> meetUsers;

    public List<MeetMdEntity> getMeetUsers() {
        return meetUsers;
    }

    public void setMeetUsers(List<MeetMdEntity> meetUsers) {
        this.meetUsers = meetUsers;
    }

    private String meetUsersStr;

    public String getMeetUsersStr() {
        return meetUsersStr;
    }

    public void setMeetUsersStr(String meetUsersStr) {
        this.meetUsersStr = meetUsersStr;
    }

    private String meetApprovalsStr;

    public String getMeetApprovalsStr() {
        return meetApprovalsStr;
    }

    public void setMeetApprovalsStr(String meetApprovalsStr) {
        this.meetApprovalsStr = meetApprovalsStr;
    }

    private int ksqdsj;
    private int jsqdsj;

    public int getKsqdsj() {
        return ksqdsj;
    }

    public void setKsqdsj(int ksqdsj) {
        this.ksqdsj = ksqdsj;
    }

    public int getJsqdsj() {
        return jsqdsj;
    }

    public void setJsqdsj(int jsqdsj) {
        this.jsqdsj = jsqdsj;
    }

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String emcee;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String organizer;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String recordUser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String summary;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String groupBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer lx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer qdState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String glyNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:36:23", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer weekDay;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer cycle;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer day;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String appointment;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer notice;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer email;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long devTmpbh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer alluser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String zqGroup;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "会议状态 0:未开始;1:正在进行中;2:已结束")
    private Integer meetState;

    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否可撤销 0:可撤销;1:不可撤销")
    private Integer orderState;

    private Integer approveState;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String roomName;

    private Integer wxNotice;//微信通知
    private String recordTime;//通知时间

    public Integer getApproveState() {
        return approveState;
    }

    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }

    public Integer getWxNotice() {
        return wxNotice;
    }

    public void setWxNotice(Integer wxNotice) {
        this.wxNotice = wxNotice;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMeetState() {
        return meetState;
    }

    public void setMeetState(Integer meetState) {
        this.meetState = meetState;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column dt_meet.bh
     *
     * @return the value of dt_meet.bh
     */
    public Integer getBh() {
        return bh;
    }

    /**
     */
    public MeetEntity withBh(Integer bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.bh
     *
     * @param bh the value for dt_meet.bh
     */
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column dt_meet.lname
     *
     * @return the value of dt_meet.lname
     */
    public String getLname() {
        return lname;
    }

    /**
     */
    public MeetEntity withLname(String lname) {
        this.setLname(lname);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.lname
     *
     * @param lname the value for dt_meet.lname
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * This method returns the value of the database column dt_meet.module_id
     *
     * @return the value of dt_meet.module_id
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     */
    public MeetEntity withModuleId(String moduleId) {
        this.setModuleId(moduleId);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.module_id
     *
     * @param moduleId the value for dt_meet.module_id
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method returns the value of the database column dt_meet.kssj
     *
     * @return the value of dt_meet.kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     */
    public MeetEntity withKssj(Date kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.kssj
     *
     * @param kssj the value for dt_meet.kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column dt_meet.jssj
     *
     * @return the value of dt_meet.jssj
     */
    public Date getJssj() {
        return jssj;
    }

    /**
     */
    public MeetEntity withJssj(Date jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.jssj
     *
     * @param jssj the value for dt_meet.jssj
     */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column dt_meet.emcee
     *
     * @return the value of dt_meet.emcee
     */
    public String getEmcee() {
        return emcee;
    }

    /**
     */
    public MeetEntity withEmcee(String emcee) {
        this.setEmcee(emcee);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.emcee
     *
     * @param emcee the value for dt_meet.emcee
     */
    public void setEmcee(String emcee) {
        this.emcee = emcee;
    }

    /**
     * This method returns the value of the database column dt_meet.organizer
     *
     * @return the value of dt_meet.organizer
     */
    public String getOrganizer() {
        return organizer;
    }

    /**
     */
    public MeetEntity withOrganizer(String organizer) {
        this.setOrganizer(organizer);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.organizer
     *
     * @param organizer the value for dt_meet.organizer
     */
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    /**
     * This method returns the value of the database column dt_meet.Record_user
     *
     * @return the value of dt_meet.Record_user
     */
    public String getRecordUser() {
        return recordUser;
    }

    /**
     */
    public MeetEntity withRecordUser(String recordUser) {
        this.setRecordUser(recordUser);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.Record_user
     *
     * @param recordUser the value for dt_meet.Record_user
     */
    public void setRecordUser(String recordUser) {
        this.recordUser = recordUser;
    }

    /**
     * This method returns the value of the database column dt_meet.Summary
     *
     * @return the value of dt_meet.Summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     */
    public MeetEntity withSummary(String summary) {
        this.setSummary(summary);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.Summary
     *
     * @param summary the value for dt_meet.Summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * This method returns the value of the database column dt_meet.room_serial
     *
     * @return the value of dt_meet.room_serial
     */
    public Integer getRoomSerial() {
        return roomSerial;
    }

    /**
     */
    public MeetEntity withRoomSerial(Integer roomSerial) {
        this.setRoomSerial(roomSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.room_serial
     *
     * @param roomSerial the value for dt_meet.room_serial
     */
    public void setRoomSerial(Integer roomSerial) {
        this.roomSerial = roomSerial;
    }

    /**
     * This method returns the value of the database column dt_meet.group_bh
     *
     * @return the value of dt_meet.group_bh
     */
    public String getGroupBh() {
        return groupBh;
    }

    /**
     */
    public MeetEntity withGroupBh(String groupBh) {
        this.setGroupBh(groupBh);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.group_bh
     *
     * @param groupBh the value for dt_meet.group_bh
     */
    public void setGroupBh(String groupBh) {
        this.groupBh = groupBh;
    }

    /**
     * This method returns the value of the database column dt_meet.lx
     *
     * @return the value of dt_meet.lx
     */
    public Integer getLx() {
        return lx;
    }

    /**
     */
    public MeetEntity withLx(Integer lx) {
        this.setLx(lx);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.lx
     *
     * @param lx the value for dt_meet.lx
     */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
     * This method returns the value of the database column dt_meet.qd_state
     *
     * @return the value of dt_meet.qd_state
     */
    public Integer getQdState() {
        return qdState;
    }

    /**
     */
    public MeetEntity withQdState(Integer qdState) {
        this.setQdState(qdState);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.qd_state
     *
     * @param qdState the value for dt_meet.qd_state
     */
    public void setQdState(Integer qdState) {
        this.qdState = qdState;
    }

    /**
     * This method returns the value of the database column dt_meet.gly_no
     *
     * @return the value of dt_meet.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public MeetEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.gly_no
     *
     * @param glyNo the value for dt_meet.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column dt_meet.sj
     *
     * @return the value of dt_meet.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public MeetEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.sj
     *
     * @param sj the value for dt_meet.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dt_meet.reg_serial
     *
     * @return the value of dt_meet.reg_serial
     */
    public String getRegSerial() {
        return regSerial;
    }

    /**
     */
    public MeetEntity withRegSerial(String regSerial) {
        this.setRegSerial(regSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.reg_serial
     *
     * @param regSerial the value for dt_meet.reg_serial
     */
    public void setRegSerial(String regSerial) {
        this.regSerial = regSerial;
    }

    /**
     * This method returns the value of the database column dt_meet.week_day
     *
     * @return the value of dt_meet.week_day
     */
    public Integer getWeekDay() {
        return weekDay;
    }

    /**
     */
    public MeetEntity withWeekDay(Integer weekDay) {
        this.setWeekDay(weekDay);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.week_day
     *
     * @param weekDay the value for dt_meet.week_day
     */
    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * This method returns the value of the database column dt_meet.cycle
     *
     * @return the value of dt_meet.cycle
     */
    public Integer getCycle() {
        return cycle;
    }

    /**
     */
    public MeetEntity withCycle(Integer cycle) {
        this.setCycle(cycle);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.cycle
     *
     * @param cycle the value for dt_meet.cycle
     */
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    /**
     * This method returns the value of the database column dt_meet.day
     *
     * @return the value of dt_meet.day
     */
    public Integer getDay() {
        return day;
    }

    /**
     */
    public MeetEntity withDay(Integer day) {
        this.setDay(day);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.day
     *
     * @param day the value for dt_meet.day
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * This method returns the value of the database column dt_meet.dep_bh
     *
     * @return the value of dt_meet.dep_bh
     */
    public String getDepBh() {
        return depBh;
    }

    /**
     */
    public MeetEntity withDepBh(String depBh) {
        this.setDepBh(depBh);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.dep_bh
     *
     * @param depBh the value for dt_meet.dep_bh
     */
    public void setDepBh(String depBh) {
        this.depBh = depBh;
    }

    /**
     * This method returns the value of the database column dt_meet.appointment
     *
     * @return the value of dt_meet.appointment
     */
    public String getAppointment() {
        return appointment;
    }

    /**
     */
    public MeetEntity withAppointment(String appointment) {
        this.setAppointment(appointment);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.appointment
     *
     * @param appointment the value for dt_meet.appointment
     */
    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    /**
     * This method returns the value of the database column dt_meet.notice
     *
     * @return the value of dt_meet.notice
     */
    public Integer getNotice() {
        return notice;
    }

    /**
     */
    public MeetEntity withNotice(Integer notice) {
        this.setNotice(notice);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.notice
     *
     * @param notice the value for dt_meet.notice
     */
    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    /**
     * This method returns the value of the database column dt_meet.email
     *
     * @return the value of dt_meet.email
     */
    public Integer getEmail() {
        return email;
    }

    /**
     */
    public MeetEntity withEmail(Integer email) {
        this.setEmail(email);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.email
     *
     * @param email the value for dt_meet.email
     */
    public void setEmail(Integer email) {
        this.email = email;
    }

    /**
     * This method returns the value of the database column dt_meet.Dev_tmpbh
     *
     * @return the value of dt_meet.Dev_tmpbh
     */
    public Long getDevTmpbh() {
        return devTmpbh;
    }

    /**
     */
    public MeetEntity withDevTmpbh(Long devTmpbh) {
        this.setDevTmpbh(devTmpbh);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.Dev_tmpbh
     *
     * @param devTmpbh the value for dt_meet.Dev_tmpbh
     */
    public void setDevTmpbh(Long devTmpbh) {
        this.devTmpbh = devTmpbh;
    }

    /**
     * This method returns the value of the database column dt_meet.alluser
     *
     * @return the value of dt_meet.alluser
     */
    public Integer getAlluser() {
        return alluser;
    }

    /**
     */
    public MeetEntity withAlluser(Integer alluser) {
        this.setAlluser(alluser);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.alluser
     *
     * @param alluser the value for dt_meet.alluser
     */
    public void setAlluser(Integer alluser) {
        this.alluser = alluser;
    }

    /**
     * This method returns the value of the database column dt_meet.zq_group
     *
     * @return the value of dt_meet.zq_group
     */
    public String getZqGroup() {
        return zqGroup;
    }

    /**
     */
    public MeetEntity withZqGroup(String zqGroup) {
        this.setZqGroup(zqGroup);
        return this;
    }

    /**
     * This method sets the value of the database column dt_meet.zq_group
     *
     * @param zqGroup the value for dt_meet.zq_group
     */
    public void setZqGroup(String zqGroup) {
        this.zqGroup = zqGroup;
    }
}