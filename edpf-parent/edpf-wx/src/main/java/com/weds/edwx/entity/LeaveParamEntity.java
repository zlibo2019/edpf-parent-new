package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class LeaveParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121409030901", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = true, dataType = "String", example = "00103", value = "假类编号")
    private String bh;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-12-11 10:00:00", value = "开始时间")
    private Date kssj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-12-11 12:00:00", value = "结束时间")
    private Date jssj;

    @ApiModelProperty(required = true, dataType = "String", example = "8", value = "请假时长")
    private String leaveLength;

    @ApiModelProperty(required = true, dataType = "String", example = "测试", value = "备注")
    private String bz;

    @ApiModelProperty(required = false, dataType = "String", example = "..", value = "图片地址")
    private String imgPath;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001,20000002", value = "自定义审批人")
    private String approver;

    @ApiModelProperty(required = false, dataType = "String", example = "SYSOO1", value = "自定义审批ID")
    private String processId;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "$20000001$", value = "")
    private String checkPp;

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "0:PC端 1:移动端")
    private String qjlx;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001,20000002", value = "自定义抄送人员")
    private String copyUser;


    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public Date getKssj() {
        return kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public String getLeaveLength() {
        return leaveLength;
    }

    public void setLeaveLength(String leaveLength) {
        this.leaveLength = leaveLength;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getCheckProgress() {
        return checkProgress;
    }

    public void setCheckProgress(String checkProgress) {
        this.checkProgress = checkProgress;
    }

    public String getCheckPp() {
        return checkPp;
    }

    public void setCheckPp(String checkPp) {
        this.checkPp = checkPp;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getQjlx() {
        return qjlx;
    }

    public void setQjlx(String qjlx) {
        this.qjlx = qjlx;
    }

    public String getCopyUser() {
        return copyUser;
    }

    public void setCopyUser(String copyUser) {
        this.copyUser = copyUser;
    }
}
