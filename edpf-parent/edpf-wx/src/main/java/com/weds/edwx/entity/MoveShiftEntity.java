package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class MoveShiftEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018010110100101", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "王富贵", value = "人员姓名")
    private String userName;

    @ApiModelProperty(required = false, dataType = "String", example = "人事部", value = "部门名称")
    private String userDepname;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "审批人员")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "调班", value = "暂定:调班")
    private String mc;

    @ApiModelProperty(required = false, dataType = "String", example = "班次编号", value = "班次编号")
    private String bh;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-11 13:06:49", value = "调班日期")
    private Date tbrq;

    @ApiModelProperty(required = false, dataType = "String", example = "00101", value = "原班次编号")
    private String ybc;

    @ApiModelProperty(required = false, dataType = "String", example = "00102", value = "新班次编号")
    private String xbc;

    @ApiModelProperty(required = false, dataType = "String", example = "...", value = "备注")
    private String bz;

    @ApiModelProperty(required = false, dataType = "String", example = "0", value = "审批状态")
    private String flag;

    @ApiModelProperty(required = false, dataType = "String", example = "123051", value = "审批唯一ID")
    private String checkId;

    @ApiModelProperty(required = false, dataType = "String", example = "", value = "图片路径")
    private String imgPath;

    @ApiModelProperty(required = false, dataType = "String[]", example = "123051", value = "图片数组")
    private String[] img;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDepname() {
        return userDepname;
    }

    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    public String getCheckProgress() {
        return checkProgress;
    }

    public void setCheckProgress(String checkProgress) {
        this.checkProgress = checkProgress;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String[] getImg() {
        return img;
    }

    public void setImg(String[] img) {
        this.img = img;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }
}
