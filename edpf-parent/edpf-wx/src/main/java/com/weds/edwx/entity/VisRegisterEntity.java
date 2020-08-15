package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.annotation.Dict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class VisRegisterEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long visSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visCard;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visNums;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visCars;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date visKssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date visJssj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visTime;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visThing;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visBz;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    @Dict("02001")
    private Integer visOk;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date visKssjReal;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date visJssjReal;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visTimeOut;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String bh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visArea;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String followUser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String carries;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer visLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String approveState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String visitorState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String carState;

    private String remark;

    private String userLname;

    private String userNo;

    private String userDepname;

    private String telePhone;

    private String companyName;

    private String visLname;

    private String visSex;

    private String visId;

    private String facePhoto;

    private String qrcode;

    private String visKeeperNo;

    @Dict("02002")
    private String state;

    private String thingName;

    private String visAreaName;

    private int ttOrder;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-03-20 16:04:25", value = "")
    private Date endDate;

    private String qrId;

    private String userTelephone;

    public String getVisKeeperNo() {
        return visKeeperNo;
    }

    public void setVisKeeperNo(String visKeeperNo) {
        this.visKeeperNo = visKeeperNo;
    }

    public String getVisAreaName() {
        return visAreaName;
    }

    public void setVisAreaName(String visAreaName) {
        this.visAreaName = visAreaName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserDepname() {
        return userDepname;
    }

    public void setUserDepname(String userDepname) {
        this.userDepname = userDepname;
    }

    public String getVisSex() {
        return visSex;
    }

    public void setVisSex(String visSex) {
        this.visSex = visSex;
    }

    public String getVisId() {
        return visId;
    }

    public void setVisId(String visId) {
        this.visId = visId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    private String keys;

    /**
     * This method returns the value of the database column Vis_register.xh
     *
     * @return the value of Vis_register.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public VisRegisterEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.xh
     *
     * @param xh the value for Vis_register.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_serial
     *
     * @return the value of Vis_register.vis_serial
     */
    public Long getVisSerial() {
        return visSerial;
    }

    /**
     */
    public VisRegisterEntity withVisSerial(Long visSerial) {
        this.setVisSerial(visSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_serial
     *
     * @param visSerial the value for Vis_register.vis_serial
     */
    public void setVisSerial(Long visSerial) {
        this.visSerial = visSerial;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_no
     *
     * @return the value of Vis_register.vis_no
     */
    public String getVisNo() {
        return visNo;
    }

    /**
     */
    public VisRegisterEntity withVisNo(String visNo) {
        this.setVisNo(visNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_no
     *
     * @param visNo the value for Vis_register.vis_no
     */
    public void setVisNo(String visNo) {
        this.visNo = visNo;
    }

    /**
     * This method returns the value of the database column Vis_register.dep_no
     *
     * @return the value of Vis_register.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public VisRegisterEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.dep_no
     *
     * @param depNo the value for Vis_register.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column Vis_register.user_serial
     *
     * @return the value of Vis_register.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public VisRegisterEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.user_serial
     *
     * @param userSerial the value for Vis_register.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_card
     *
     * @return the value of Vis_register.vis_card
     */
    public String getVisCard() {
        return visCard;
    }

    /**
     */
    public VisRegisterEntity withVisCard(String visCard) {
        this.setVisCard(visCard);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_card
     *
     * @param visCard the value for Vis_register.vis_card
     */
    public void setVisCard(String visCard) {
        this.visCard = visCard;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_nums
     *
     * @return the value of Vis_register.vis_nums
     */
    public Integer getVisNums() {
        return visNums;
    }

    /**
     */
    public VisRegisterEntity withVisNums(Integer visNums) {
        this.setVisNums(visNums);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_nums
     *
     * @param visNums the value for Vis_register.vis_nums
     */
    public void setVisNums(Integer visNums) {
        this.visNums = visNums;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_cars
     *
     * @return the value of Vis_register.vis_cars
     */
    public String getVisCars() {
        return visCars;
    }

    /**
     */
    public VisRegisterEntity withVisCars(String visCars) {
        this.setVisCars(visCars);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_cars
     *
     * @param visCars the value for Vis_register.vis_cars
     */
    public void setVisCars(String visCars) {
        this.visCars = visCars;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_kssj
     *
     * @return the value of Vis_register.vis_kssj
     */
    public Date getVisKssj() {
        return visKssj;
    }

    /**
     */
    public VisRegisterEntity withVisKssj(Date visKssj) {
        this.setVisKssj(visKssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_kssj
     *
     * @param visKssj the value for Vis_register.vis_kssj
     */
    public void setVisKssj(Date visKssj) {
        this.visKssj = visKssj;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_jssj
     *
     * @return the value of Vis_register.vis_jssj
     */
    public Date getVisJssj() {
        return visJssj;
    }

    /**
     */
    public VisRegisterEntity withVisJssj(Date visJssj) {
        this.setVisJssj(visJssj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_jssj
     *
     * @param visJssj the value for Vis_register.vis_jssj
     */
    public void setVisJssj(Date visJssj) {
        this.visJssj = visJssj;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_time
     *
     * @return the value of Vis_register.vis_time
     */
    public Integer getVisTime() {
        return visTime;
    }

    /**
     */
    public VisRegisterEntity withVisTime(Integer visTime) {
        this.setVisTime(visTime);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_time
     *
     * @param visTime the value for Vis_register.vis_time
     */
    public void setVisTime(Integer visTime) {
        this.visTime = visTime;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_thing
     *
     * @return the value of Vis_register.vis_thing
     */
    public String getVisThing() {
        return visThing;
    }

    /**
     */
    public VisRegisterEntity withVisThing(String visThing) {
        this.setVisThing(visThing);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_thing
     *
     * @param visThing the value for Vis_register.vis_thing
     */
    public void setVisThing(String visThing) {
        this.visThing = visThing;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_state
     *
     * @return the value of Vis_register.vis_state
     */
    public Integer getVisState() {
        return visState;
    }

    /**
     */
    public VisRegisterEntity withVisState(Integer visState) {
        this.setVisState(visState);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_state
     *
     * @param visState the value for Vis_register.vis_state
     */
    public void setVisState(Integer visState) {
        this.visState = visState;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_bz
     *
     * @return the value of Vis_register.vis_bz
     */
    public String getVisBz() {
        return visBz;
    }

    /**
     */
    public VisRegisterEntity withVisBz(String visBz) {
        this.setVisBz(visBz);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_bz
     *
     * @param visBz the value for Vis_register.vis_bz
     */
    public void setVisBz(String visBz) {
        this.visBz = visBz;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_ok
     *
     * @return the value of Vis_register.vis_ok
     */
    public Integer getVisOk() {
        return visOk;
    }

    /**
     */
    public VisRegisterEntity withVisOk(Integer visOk) {
        this.setVisOk(visOk);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_ok
     *
     * @param visOk the value for Vis_register.vis_ok
     */
    public void setVisOk(Integer visOk) {
        this.visOk = visOk;
    }

    /**
     * This method returns the value of the database column Vis_register.sj
     *
     * @return the value of Vis_register.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public VisRegisterEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.sj
     *
     * @param sj the value for Vis_register.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column Vis_register.gly_no
     *
     * @return the value of Vis_register.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public VisRegisterEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.gly_no
     *
     * @param glyNo the value for Vis_register.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_kssj_real
     *
     * @return the value of Vis_register.vis_kssj_real
     */
    public Date getVisKssjReal() {
        return visKssjReal;
    }

    /**
     */
    public VisRegisterEntity withVisKssjReal(Date visKssjReal) {
        this.setVisKssjReal(visKssjReal);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_kssj_real
     *
     * @param visKssjReal the value for Vis_register.vis_kssj_real
     */
    public void setVisKssjReal(Date visKssjReal) {
        this.visKssjReal = visKssjReal;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_jssj_real
     *
     * @return the value of Vis_register.vis_jssj_real
     */
    public Date getVisJssjReal() {
        return visJssjReal;
    }

    /**
     */
    public VisRegisterEntity withVisJssjReal(Date visJssjReal) {
        this.setVisJssjReal(visJssjReal);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_jssj_real
     *
     * @param visJssjReal the value for Vis_register.vis_jssj_real
     */
    public void setVisJssjReal(Date visJssjReal) {
        this.visJssjReal = visJssjReal;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_time_out
     *
     * @return the value of Vis_register.vis_time_out
     */
    public Integer getVisTimeOut() {
        return visTimeOut;
    }

    /**
     */
    public VisRegisterEntity withVisTimeOut(Integer visTimeOut) {
        this.setVisTimeOut(visTimeOut);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_time_out
     *
     * @param visTimeOut the value for Vis_register.vis_time_out
     */
    public void setVisTimeOut(Integer visTimeOut) {
        this.visTimeOut = visTimeOut;
    }

    /**
     * This method returns the value of the database column Vis_register.bh
     *
     * @return the value of Vis_register.bh
     */
    public String getBh() {
        return bh;
    }

    /**
     */
    public VisRegisterEntity withBh(String bh) {
        this.setBh(bh);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.bh
     *
     * @param bh the value for Vis_register.bh
     */
    public void setBh(String bh) {
        this.bh = bh;
    }

    /**
     * This method returns the value of the database column Vis_register.Vis_area
     *
     * @return the value of Vis_register.Vis_area
     */
    public String getVisArea() {
        return visArea;
    }

    /**
     */
    public VisRegisterEntity withVisArea(String visArea) {
        this.setVisArea(visArea);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.Vis_area
     *
     * @param visArea the value for Vis_register.Vis_area
     */
    public void setVisArea(String visArea) {
        this.visArea = visArea;
    }

    /**
     * This method returns the value of the database column Vis_register.follow_user
     *
     * @return the value of Vis_register.follow_user
     */
    public String getFollowUser() {
        return followUser;
    }

    /**
     */
    public VisRegisterEntity withFollowUser(String followUser) {
        this.setFollowUser(followUser);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.follow_user
     *
     * @param followUser the value for Vis_register.follow_user
     */
    public void setFollowUser(String followUser) {
        this.followUser = followUser;
    }

    /**
     * This method returns the value of the database column Vis_register.carries
     *
     * @return the value of Vis_register.carries
     */
    public String getCarries() {
        return carries;
    }

    /**
     */
    public VisRegisterEntity withCarries(String carries) {
        this.setCarries(carries);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.carries
     *
     * @param carries the value for Vis_register.carries
     */
    public void setCarries(String carries) {
        this.carries = carries;
    }

    /**
     * This method returns the value of the database column Vis_register.vis_lx
     *
     * @return the value of Vis_register.vis_lx
     */
    public Integer getVisLx() {
        return visLx;
    }

    /**
     */
    public VisRegisterEntity withVisLx(Integer visLx) {
        this.setVisLx(visLx);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.vis_lx
     *
     * @param visLx the value for Vis_register.vis_lx
     */
    public void setVisLx(Integer visLx) {
        this.visLx = visLx;
    }

    /**
     * This method returns the value of the database column Vis_register.approve_state
     *
     * @return the value of Vis_register.approve_state
     */
    public String getApproveState() {
        return approveState;
    }

    /**
     */
    public VisRegisterEntity withApproveState(String approveState) {
        this.setApproveState(approveState);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.approve_state
     *
     * @param approveState the value for Vis_register.approve_state
     */
    public void setApproveState(String approveState) {
        this.approveState = approveState;
    }

    /**
     * This method returns the value of the database column Vis_register.visitor_state
     *
     * @return the value of Vis_register.visitor_state
     */
    public String getVisitorState() {
        return visitorState;
    }

    /**
     */
    public VisRegisterEntity withVisitorState(String visitorState) {
        this.setVisitorState(visitorState);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.visitor_state
     *
     * @param visitorState the value for Vis_register.visitor_state
     */
    public void setVisitorState(String visitorState) {
        this.visitorState = visitorState;
    }

    /**
     * This method returns the value of the database column Vis_register.car_state
     *
     * @return the value of Vis_register.car_state
     */
    public String getCarState() {
        return carState;
    }

    /**
     */
    public VisRegisterEntity withCarState(String carState) {
        this.setCarState(carState);
        return this;
    }

    /**
     * This method sets the value of the database column Vis_register.car_state
     *
     * @param carState the value for Vis_register.car_state
     */
    public void setCarState(String carState) {
        this.carState = carState;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVisLname() {
        return visLname;
    }

    public void setVisLname(String visLname) {
        this.visLname = visLname;
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public int getTtOrder() {
        return ttOrder;
    }

    public void setTtOrder(int ttOrder) {
        this.ttOrder = ttOrder;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }
}