package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 补出勤申请入参实体类
 */
public class AttendanceParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121809135402", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial
            ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-18 09:10:40", value = "上班刷卡时间")
    private Date sbsj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-18 09:10:49", value = "下班刷卡时间")
    private Date xbsj;

    @ApiModelProperty(required = true, dataType = "String", example = "00203", value = "编号")
    private String bh;

    @ApiModelProperty(required = true, dataType = "String", example = "测试", value = "备注")
    private String bz;

    @ApiModelProperty(required = false, dataType = "String", example = "..", value = "图片地址")
    private String imgPath;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001,20000002", value = "自定义审批人")
    private String approver;

    @ApiModelProperty(required = false, dataType = "String", example = "SYS001", value = "自定义审批ID")
    private String processId;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "$20000001$", value = "")
    private String checkPp;

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "0:PC端 1:移动端")
    private String qjlx;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001,20000002", value = "抄送人员")
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

    public Date getSbsj() {
        return sbsj;
    }

    public void setSbsj(Date sbsj) {
        this.sbsj = sbsj;
    }

    public Date getXbsj() {
        return xbsj;
    }

    public void setXbsj(Date xbsj) {
        this.xbsj = xbsj;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
