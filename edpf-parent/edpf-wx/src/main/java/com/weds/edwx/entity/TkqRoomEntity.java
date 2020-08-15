package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TkqRoomEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depParent;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depOrder;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depAddress;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depType;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depDoor;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depUser;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depLevel;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depExam;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2018-11-14 14:45:10", value = "")
    private Date sj;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depNums;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSex;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depInfo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depFee;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String remark;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depNumber;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String regSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private Long userSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer sp;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomPhoto;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String photoPath;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String photoName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer roomDep;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer starLevel;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String levelDetail;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depManifesto;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String fuserSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depSlogan;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depSynopsis;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String depShowname;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer usable;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer hySpr;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column tkq_room.Dep_serial
     *
     * @return the value of tkq_room.Dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public TkqRoomEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_serial
     *
     * @param depSerial the value for tkq_room.Dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_no
     *
     * @return the value of tkq_room.Dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public TkqRoomEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_no
     *
     * @param depNo the value for tkq_room.Dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_parent
     *
     * @return the value of tkq_room.Dep_parent
     */
    public Integer getDepParent() {
        return depParent;
    }

    /**
     */
    public TkqRoomEntity withDepParent(Integer depParent) {
        this.setDepParent(depParent);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_parent
     *
     * @param depParent the value for tkq_room.Dep_parent
     */
    public void setDepParent(Integer depParent) {
        this.depParent = depParent;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_name
     *
     * @return the value of tkq_room.Dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public TkqRoomEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_name
     *
     * @param depName the value for tkq_room.Dep_name
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_order
     *
     * @return the value of tkq_room.Dep_order
     */
    public Integer getDepOrder() {
        return depOrder;
    }

    /**
     */
    public TkqRoomEntity withDepOrder(Integer depOrder) {
        this.setDepOrder(depOrder);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_order
     *
     * @param depOrder the value for tkq_room.Dep_order
     */
    public void setDepOrder(Integer depOrder) {
        this.depOrder = depOrder;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_address
     *
     * @return the value of tkq_room.Dep_address
     */
    public String getDepAddress() {
        return depAddress;
    }

    /**
     */
    public TkqRoomEntity withDepAddress(String depAddress) {
        this.setDepAddress(depAddress);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_address
     *
     * @param depAddress the value for tkq_room.Dep_address
     */
    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_type
     *
     * @return the value of tkq_room.Dep_type
     */
    public Integer getDepType() {
        return depType;
    }

    /**
     */
    public TkqRoomEntity withDepType(Integer depType) {
        this.setDepType(depType);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_type
     *
     * @param depType the value for tkq_room.Dep_type
     */
    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_door
     *
     * @return the value of tkq_room.Dep_door
     */
    public Integer getDepDoor() {
        return depDoor;
    }

    /**
     */
    public TkqRoomEntity withDepDoor(Integer depDoor) {
        this.setDepDoor(depDoor);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_door
     *
     * @param depDoor the value for tkq_room.Dep_door
     */
    public void setDepDoor(Integer depDoor) {
        this.depDoor = depDoor;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_user
     *
     * @return the value of tkq_room.Dep_user
     */
    public Integer getDepUser() {
        return depUser;
    }

    /**
     */
    public TkqRoomEntity withDepUser(Integer depUser) {
        this.setDepUser(depUser);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_user
     *
     * @param depUser the value for tkq_room.Dep_user
     */
    public void setDepUser(Integer depUser) {
        this.depUser = depUser;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_level
     *
     * @return the value of tkq_room.dep_level
     */
    public Integer getDepLevel() {
        return depLevel;
    }

    /**
     */
    public TkqRoomEntity withDepLevel(Integer depLevel) {
        this.setDepLevel(depLevel);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_level
     *
     * @param depLevel the value for tkq_room.dep_level
     */
    public void setDepLevel(Integer depLevel) {
        this.depLevel = depLevel;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_exam
     *
     * @return the value of tkq_room.dep_exam
     */
    public Integer getDepExam() {
        return depExam;
    }

    /**
     */
    public TkqRoomEntity withDepExam(Integer depExam) {
        this.setDepExam(depExam);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_exam
     *
     * @param depExam the value for tkq_room.dep_exam
     */
    public void setDepExam(Integer depExam) {
        this.depExam = depExam;
    }

    /**
     * This method returns the value of the database column tkq_room.Sj
     *
     * @return the value of tkq_room.Sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public TkqRoomEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Sj
     *
     * @param sj the value for tkq_room.Sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_state
     *
     * @return the value of tkq_room.Dep_state
     */
    public Integer getDepState() {
        return depState;
    }

    /**
     */
    public TkqRoomEntity withDepState(Integer depState) {
        this.setDepState(depState);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_state
     *
     * @param depState the value for tkq_room.Dep_state
     */
    public void setDepState(Integer depState) {
        this.depState = depState;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_nums
     *
     * @return the value of tkq_room.Dep_nums
     */
    public Integer getDepNums() {
        return depNums;
    }

    /**
     */
    public TkqRoomEntity withDepNums(Integer depNums) {
        this.setDepNums(depNums);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_nums
     *
     * @param depNums the value for tkq_room.Dep_nums
     */
    public void setDepNums(Integer depNums) {
        this.depNums = depNums;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_sex
     *
     * @return the value of tkq_room.Dep_sex
     */
    public Integer getDepSex() {
        return depSex;
    }

    /**
     */
    public TkqRoomEntity withDepSex(Integer depSex) {
        this.setDepSex(depSex);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_sex
     *
     * @param depSex the value for tkq_room.Dep_sex
     */
    public void setDepSex(Integer depSex) {
        this.depSex = depSex;
    }

    /**
     * This method returns the value of the database column tkq_room.Dep_info
     *
     * @return the value of tkq_room.Dep_info
     */
    public Integer getDepInfo() {
        return depInfo;
    }

    /**
     */
    public TkqRoomEntity withDepInfo(Integer depInfo) {
        this.setDepInfo(depInfo);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.Dep_info
     *
     * @param depInfo the value for tkq_room.Dep_info
     */
    public void setDepInfo(Integer depInfo) {
        this.depInfo = depInfo;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_fee
     *
     * @return the value of tkq_room.dep_fee
     */
    public String getDepFee() {
        return depFee;
    }

    /**
     */
    public TkqRoomEntity withDepFee(String depFee) {
        this.setDepFee(depFee);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_fee
     *
     * @param depFee the value for tkq_room.dep_fee
     */
    public void setDepFee(String depFee) {
        this.depFee = depFee;
    }

    /**
     * This method returns the value of the database column tkq_room.remark
     *
     * @return the value of tkq_room.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public TkqRoomEntity withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.remark
     *
     * @param remark the value for tkq_room.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_number
     *
     * @return the value of tkq_room.dep_number
     */
    public String getDepNumber() {
        return depNumber;
    }

    /**
     */
    public TkqRoomEntity withDepNumber(String depNumber) {
        this.setDepNumber(depNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_number
     *
     * @param depNumber the value for tkq_room.dep_number
     */
    public void setDepNumber(String depNumber) {
        this.depNumber = depNumber;
    }

    /**
     * This method returns the value of the database column tkq_room.reg_serial
     *
     * @return the value of tkq_room.reg_serial
     */
    public String getRegSerial() {
        return regSerial;
    }

    /**
     */
    public TkqRoomEntity withRegSerial(String regSerial) {
        this.setRegSerial(regSerial);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.reg_serial
     *
     * @param regSerial the value for tkq_room.reg_serial
     */
    public void setRegSerial(String regSerial) {
        this.regSerial = regSerial;
    }

    /**
     * This method returns the value of the database column tkq_room.user_serial
     *
     * @return the value of tkq_room.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public TkqRoomEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.user_serial
     *
     * @param userSerial the value for tkq_room.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column tkq_room.sp
     *
     * @return the value of tkq_room.sp
     */
    public Integer getSp() {
        return sp;
    }

    /**
     */
    public TkqRoomEntity withSp(Integer sp) {
        this.setSp(sp);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.sp
     *
     * @param sp the value for tkq_room.sp
     */
    public void setSp(Integer sp) {
        this.sp = sp;
    }

    /**
     * This method returns the value of the database column tkq_room.room_photo
     *
     * @return the value of tkq_room.room_photo
     */
    public Integer getRoomPhoto() {
        return roomPhoto;
    }

    /**
     */
    public TkqRoomEntity withRoomPhoto(Integer roomPhoto) {
        this.setRoomPhoto(roomPhoto);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.room_photo
     *
     * @param roomPhoto the value for tkq_room.room_photo
     */
    public void setRoomPhoto(Integer roomPhoto) {
        this.roomPhoto = roomPhoto;
    }

    /**
     * This method returns the value of the database column tkq_room.photo_path
     *
     * @return the value of tkq_room.photo_path
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     */
    public TkqRoomEntity withPhotoPath(String photoPath) {
        this.setPhotoPath(photoPath);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.photo_path
     *
     * @param photoPath the value for tkq_room.photo_path
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    /**
     * This method returns the value of the database column tkq_room.photo_name
     *
     * @return the value of tkq_room.photo_name
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     */
    public TkqRoomEntity withPhotoName(String photoName) {
        this.setPhotoName(photoName);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.photo_name
     *
     * @param photoName the value for tkq_room.photo_name
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * This method returns the value of the database column tkq_room.room_dep
     *
     * @return the value of tkq_room.room_dep
     */
    public Integer getRoomDep() {
        return roomDep;
    }

    /**
     */
    public TkqRoomEntity withRoomDep(Integer roomDep) {
        this.setRoomDep(roomDep);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.room_dep
     *
     * @param roomDep the value for tkq_room.room_dep
     */
    public void setRoomDep(Integer roomDep) {
        this.roomDep = roomDep;
    }

    /**
     * This method returns the value of the database column tkq_room.star_level
     *
     * @return the value of tkq_room.star_level
     */
    public Integer getStarLevel() {
        return starLevel;
    }

    /**
     */
    public TkqRoomEntity withStarLevel(Integer starLevel) {
        this.setStarLevel(starLevel);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.star_level
     *
     * @param starLevel the value for tkq_room.star_level
     */
    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    /**
     * This method returns the value of the database column tkq_room.level_detail
     *
     * @return the value of tkq_room.level_detail
     */
    public String getLevelDetail() {
        return levelDetail;
    }

    /**
     */
    public TkqRoomEntity withLevelDetail(String levelDetail) {
        this.setLevelDetail(levelDetail);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.level_detail
     *
     * @param levelDetail the value for tkq_room.level_detail
     */
    public void setLevelDetail(String levelDetail) {
        this.levelDetail = levelDetail;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_manifesto
     *
     * @return the value of tkq_room.dep_manifesto
     */
    public String getDepManifesto() {
        return depManifesto;
    }

    /**
     */
    public TkqRoomEntity withDepManifesto(String depManifesto) {
        this.setDepManifesto(depManifesto);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_manifesto
     *
     * @param depManifesto the value for tkq_room.dep_manifesto
     */
    public void setDepManifesto(String depManifesto) {
        this.depManifesto = depManifesto;
    }

    /**
     * This method returns the value of the database column tkq_room.fuser_serial
     *
     * @return the value of tkq_room.fuser_serial
     */
    public String getFuserSerial() {
        return fuserSerial;
    }

    /**
     */
    public TkqRoomEntity withFuserSerial(String fuserSerial) {
        this.setFuserSerial(fuserSerial);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.fuser_serial
     *
     * @param fuserSerial the value for tkq_room.fuser_serial
     */
    public void setFuserSerial(String fuserSerial) {
        this.fuserSerial = fuserSerial;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_slogan
     *
     * @return the value of tkq_room.dep_slogan
     */
    public String getDepSlogan() {
        return depSlogan;
    }

    /**
     */
    public TkqRoomEntity withDepSlogan(String depSlogan) {
        this.setDepSlogan(depSlogan);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_slogan
     *
     * @param depSlogan the value for tkq_room.dep_slogan
     */
    public void setDepSlogan(String depSlogan) {
        this.depSlogan = depSlogan;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_synopsis
     *
     * @return the value of tkq_room.dep_synopsis
     */
    public String getDepSynopsis() {
        return depSynopsis;
    }

    /**
     */
    public TkqRoomEntity withDepSynopsis(String depSynopsis) {
        this.setDepSynopsis(depSynopsis);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_synopsis
     *
     * @param depSynopsis the value for tkq_room.dep_synopsis
     */
    public void setDepSynopsis(String depSynopsis) {
        this.depSynopsis = depSynopsis;
    }

    /**
     * This method returns the value of the database column tkq_room.dep_showname
     *
     * @return the value of tkq_room.dep_showname
     */
    public String getDepShowname() {
        return depShowname;
    }

    /**
     */
    public TkqRoomEntity withDepShowname(String depShowname) {
        this.setDepShowname(depShowname);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.dep_showname
     *
     * @param depShowname the value for tkq_room.dep_showname
     */
    public void setDepShowname(String depShowname) {
        this.depShowname = depShowname;
    }

    /**
     * This method returns the value of the database column tkq_room.usable
     *
     * @return the value of tkq_room.usable
     */
    public Integer getUsable() {
        return usable;
    }

    /**
     */
    public TkqRoomEntity withUsable(Integer usable) {
        this.setUsable(usable);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.usable
     *
     * @param usable the value for tkq_room.usable
     */
    public void setUsable(Integer usable) {
        this.usable = usable;
    }

    /**
     * This method returns the value of the database column tkq_room.hy_spr
     *
     * @return the value of tkq_room.hy_spr
     */
    public Integer getHySpr() {
        return hySpr;
    }

    /**
     */
    public TkqRoomEntity withHySpr(Integer hySpr) {
        this.setHySpr(hySpr);
        return this;
    }

    /**
     * This method sets the value of the database column tkq_room.hy_spr
     *
     * @param hySpr the value for tkq_room.hy_spr
     */
    public void setHySpr(Integer hySpr) {
        this.hySpr = hySpr;
    }
}