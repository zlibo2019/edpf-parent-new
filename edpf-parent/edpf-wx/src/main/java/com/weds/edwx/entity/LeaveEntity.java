package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class LeaveEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018010110100001", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;

    @ApiModelProperty(required = false, dataType = "String", example = "王富贵", value = "人员姓名")
    private String userName;

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "审批人员")
    private String checkProgress;

    @ApiModelProperty(required = false, dataType = "String", example = "人事部", value = "部门名称")
    private String userDepname;

    @ApiModelProperty(required = false, dataType = "String", example = "00101", value = "假类编号")
    private String bh;

    @ApiModelProperty(required = false, dataType = "String", example = "事假", value = "假类名称")
    private String mc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-11 10:44:49", value = "开始时间")
    private Date kssj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-11 10:45:00", value = "结束时间")
    private Date jssj;

    @ApiModelProperty(required = false, dataType = "String", example = "8", value = "请假时长")
    private String leaveLength;  // 请假天数

    @ApiModelProperty(required = false, dataType = "String", example = "....", value = "备注")
    private String bz;

    @ApiModelProperty(required = false, dataType = "int", example = "0", value = "审批状态")
    private int flag;

    @ApiModelProperty(required = false, dataType = "String", example = "125352`", value = "审批唯一ID")
    private String checkId;

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

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
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
}
