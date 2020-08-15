package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class AttendanceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121811214001", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "王富贵", value = "人员姓名")
    private String userName;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "审批人员")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "人事部", value = "部门名称")
    private String userDepname;

    @ApiModelProperty(required = false, dataType = "String", example = "补出勤", value = "名称")
    private String mc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-18 11:25", value = "上班时间")
    private Date sbsj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-18 11:26", value = "下班时间")
    private Date xbsj;

    @ApiModelProperty(required = false, dataType = "String", example = "2018-12-18 11:26:24", value = "操作时间")
    private String czrq;

    @ApiModelProperty(required = false, dataType = "String", example = "0", value = "审批状态 0,1: 待审批 2:审批通过 3:审批拒绝 4:审批撤销")
    private String flag;

    @ApiModelProperty(required = false, dataType = "String", example = "测试", value = "备注")
    private String bz;

    @ApiModelProperty(required = false, dataType = "String", example = "123450", value = "审批唯一ID")
    private String checkId;

    @ApiModelProperty(required = false, dataType = "String", example = "00203", value = "补出勤编号,暂定:00203")
    private String bh;

    @ApiModelProperty(required = false, dataType = "String", example = "..", value = "图片路径")
    private String imgPath;

    @ApiModelProperty(required = false, dataType = "String[]", example = "..", value = "图片数组")
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

    public String getCheckProgress() {
        return checkProgress;
    }

    public void setCheckProgress(String checkProgress) {
        this.checkProgress = checkProgress;
    }

    public String getUserDepname() {
        return userDepname;
    }

    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
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

    public String getCzrq() {
        return czrq;
    }

    public void setCzrq(String czrq) {
        this.czrq = czrq;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
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
}
