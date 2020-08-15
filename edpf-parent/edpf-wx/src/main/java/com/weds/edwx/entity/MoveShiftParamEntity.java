package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class MoveShiftParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121409030901", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = true, dataType = "String", example = "00103", value = "调班编号")
    private String bh;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-01-02", value = "调班日期")
    private Date tbrq;

    @ApiModelProperty(required = true, dataType = "String", example = "00103", value = "原班次编号")
    private String ybc;

    @ApiModelProperty(required = true, dataType = "String", example = "00103", value = "现班次编号")
    private String xbc;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "备注")
    private String bz;

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "0:PC端 1:移动端")
    private String qjlx;

    @ApiModelProperty(required = false, dataType = "String", example = "..", value = "图片地址")
    private String imgPath;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001,20000002", value = "自定义审批人")
    private String approver;

    @ApiModelProperty(required = true, dataType = "String", example = "SYS001", value = "自定义审批ID")
    private String processId;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "$20000001$", value = "")
    private String checkPp;

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

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public Date getTbrq() {
        return tbrq;
    }

    public void setTbrq(Date tbrq) {
        this.tbrq = tbrq;
    }

    public String getYbc() {
        return ybc;
    }

    public void setYbc(String ybc) {
        this.ybc = ybc;
    }

    public String getXbc() {
        return xbc;
    }

    public void setXbc(String xbc) {
        this.xbc = xbc;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getQjlx() {
        return qjlx;
    }

    public void setQjlx(String qjlx) {
        this.qjlx = qjlx;
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

    public String getCopyUser() {
        return copyUser;
    }

    public void setCopyUser(String copyUser) {
        this.copyUser = copyUser;
    }
}
