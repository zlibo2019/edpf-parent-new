package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class BusinessParamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121409030901", value = "申请编号")
    private String xh;

    @ApiModelProperty(required = true, dataType = "String", example = "00103", value = "假类编号")
    private String bh;

    @ApiModelProperty(required = true, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;  // 人员序号

    @ApiModelProperty(required = true, dataType = "String", example = "拓展业务", value = "出差目的")
    private String businessPurposes;  // 出差目的

    @ApiModelProperty(required = true, dataType = "String", example = "烟台", value = "出发地")
    private String inPlace;  // 出发地

    @ApiModelProperty(required = true, dataType = "String", example = "青岛", value = "目的地")
    private String outPlace;  // 目的地

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-12-11 10:00:00", value = "开始时间")
    private Date kssj;  // 开始时间

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "Date", example = "2018-12-11 12:00:00", value = "结束时间")
    private Date jssj;  // 结束时间

    @ApiModelProperty(required = true, dataType = "String", example = "20000001,20000002,20000003", value = "随行人员")
    private String travelPeople;  // 随行人员

    @ApiModelProperty(required = true, dataType = "String", example = "200.0", value = "预支金额")
    private String outMoney;  // 预支金额

    @ApiModelProperty(required = true, dataType = "String", example = "火车", value = "交通工具")
    private String outVehicle;  // 交通工具

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "是否住宿")
    private String accommodation;  // 是否住宿

    @ApiModelProperty(required = true, dataType = "String", example = "1.5", value = "住宿天数")
    private float accommodationDays;  // 住宿天数

    @ApiModelProperty(required = true, dataType = "String", example = "0", value = "0:PC端 1:移动端")
    private String qjlx;

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

    @ApiModelProperty(required = false, dataType = "String", example = "20000001,20000002", value = "抄送人员")
    private String copyUser;


    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getBusinessPurposes() {
        return businessPurposes;
    }

    public void setBusinessPurposes(String businessPurposes) {
        this.businessPurposes = businessPurposes;
    }

    public String getInPlace() {
        return inPlace;
    }

    public void setInPlace(String inPlace) {
        this.inPlace = inPlace;
    }

    public String getOutPlace() {
        return outPlace;
    }

    public void setOutPlace(String outPlace) {
        this.outPlace = outPlace;
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

    public String getTravelPeople() {
        return travelPeople;
    }

    public void setTravelPeople(String travelPeople) {
        this.travelPeople = travelPeople;
    }

    public String getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(String outMoney) {
        this.outMoney = outMoney;
    }

    public String getOutVehicle() {
        return outVehicle;
    }

    public void setOutVehicle(String outVehicle) {
        this.outVehicle = outVehicle;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public float getAccommodationDays() {
        return accommodationDays;
    }

    public void setAccommodationDays(float accommodationDays) {
        this.accommodationDays = accommodationDays;
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
