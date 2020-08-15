package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusinessTravelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "2018121110015622", value = "")
    private String xh;  // 申请主键

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "人员序号")
    private String userSerial;  // 人员序号

    @ApiModelProperty(required = false, dataType = "String", example = "王富贵", value = "人员姓名")
    private String userName;  // 人员姓名

    @ApiModelProperty(required = false, dataType = "String", example = "20000001", value = "审批人员序号")
    private String checkProgress; // 审批人员

    @ApiModelProperty(required = false, dataType = "String", example = "人事部", value = "部门名称")
    private String userDepname; // 部门

    @ApiModelProperty(required = false, dataType = "String", example = "拓展业务", value = "出差目的")
    private String businessPurposes;  // 出差目的

    @ApiModelProperty(required = false, dataType = "String", example = "烟台", value = "出发地")
    private String inPlace;  // 出发地

    @ApiModelProperty(required = false, dataType = "String", example = "青岛", value = "目的地")
    private String outPlace;  // 目的地

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-11 10:00:00", value = "开始时间")
    private Date kssj;  // 开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-11 12:00:00", value = "结束时间")
    private Date jssj;  // 结束时间

    @ApiModelProperty(required = false, dataType = "String", example = "20000001,20000002,20000003", value = "随行人员")
    private String travelPeople;  // 随行人员

    @ApiModelProperty(required = false, dataType = "String", example = "200.0", value = "预支金额")
    private BigDecimal outMoney;  // 预支金额

    @ApiModelProperty(required = false, dataType = "String", example = "火车", value = "交通工具")
    private String outVehicle;  // 交通工具

    @ApiModelProperty(required = false, dataType = "String", example = "0", value = "是否住宿")
    private String accommodation;  // 是否住宿

    @ApiModelProperty(required = false, dataType = "String", example = "1.5", value = "住宿天数")
    private float accommodationDays;  // 住宿天数

    @ApiModelProperty(required = false, dataType = "int", example = "0", value = "审批状态")
    private int flag;  // 审批状态

    @ApiModelProperty(required = false, dataType = "String", example = "125352", value = "审批任务唯一ID")
    private String checkId;  // 审批唯一ID？

    @ApiModelProperty(required = false, dataType = "String", example = "..", value = "图片路径")
    private String imgPath;

    @ApiModelProperty(required = false, dataType = "String[]", example = "..", value = "图片数组")
    private String[] img;

    //private String SCHEDULE;  // 入住提醒

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

    public BigDecimal getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(BigDecimal outMoney) {
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
