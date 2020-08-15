package com.weds.edmj.entity;

import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class JrealMjCameraEntity extends ExportRptEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer jid;

    /**
     * 门编号
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门编号")
    private String gateBh;

    /**
     * 关联方向
     */
    @Dict("04008")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "关联方向")
    private Integer jdoorFx;

    /**
     * 设备类型
     */
    @Dict("04009")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "设备类型")
    private Integer jcamType;

    /**
     * 设备ip
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "设备ip")
    private String jcamIp;

    /**
     * 设备端口
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "设备端口")
    private Integer jcamPort;

    /**
     * 用户名
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "用户名")
    private String jcamUser;

    /**
     * 密码
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "密码")
    private String jcamPassword;

    /**
     * 通道号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "通道号")
    private Integer jcamChan;

    /**
     * 是否启用录像
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "是否启用录像")
    private Integer jcamVideo;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamSleep;

    /**
     * 开门成功是否拍照
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "开门成功是否拍照")
    private Integer jcamSuccess;

    /**
     * 开门失败是否拍照
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "开门失败是否拍照")
    private Integer jcamFail;

    /**
     * 报警事件是否拍照
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "报警事件是否拍照")
    private Integer jcamWarning;

    /**
     * 其他事件是否拍照
     */
    @Dict("01001")
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "其他事件是否拍照")
    private Integer jcamOther;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamCutLeft;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamCutTop;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamCutWeight;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamCutHeight;

    /**
     * 未知
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "未知")
    private Integer jcamZoomPer;

    @ApiModelProperty(required = true, dataType = "string", example = "门", value = "门名称")
    private String doorName;

    @ApiModelProperty(dataType = "list", value = "")
    private List<Integer> acdepList;

    @ApiModelProperty(dataType = "list", value = "")
    private List<String> gateList;

    @ApiModelProperty(dataType = "list", value = "")
    private List<Integer> fxList;

    public List<Integer> getFxList() {
        return fxList;
    }

    public void setFxList(List<Integer> fxList) {
        this.fxList = fxList;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public List<Integer> getAcdepList() {
        return acdepList;
    }

    public void setAcdepList(List<Integer> acdepList) {
        this.acdepList = acdepList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column jreal_mj_camera.jid
     *
     * @return the value of jreal_mj_camera.jid
     */
    public Integer getJid() {
        return jid;
    }

    /**
     */
    public JrealMjCameraEntity withJid(Integer jid) {
        this.setJid(jid);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jid
     *
     * @param jid the value for jreal_mj_camera.jid
     */
    public void setJid(Integer jid) {
        this.jid = jid;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.Gate_bh
     *
     * @return the value of jreal_mj_camera.Gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public JrealMjCameraEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.Gate_bh
     *
     * @param gateBh the value for jreal_mj_camera.Gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jdoor_fx
     *
     * @return the value of jreal_mj_camera.jdoor_fx
     */
    public Integer getJdoorFx() {
        return jdoorFx;
    }

    /**
     */
    public JrealMjCameraEntity withJdoorFx(Integer jdoorFx) {
        this.setJdoorFx(jdoorFx);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jdoor_fx
     *
     * @param jdoorFx the value for jreal_mj_camera.jdoor_fx
     */
    public void setJdoorFx(Integer jdoorFx) {
        this.jdoorFx = jdoorFx;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_type
     *
     * @return the value of jreal_mj_camera.jcam_type
     */
    public Integer getJcamType() {
        return jcamType;
    }

    /**
     */
    public JrealMjCameraEntity withJcamType(Integer jcamType) {
        this.setJcamType(jcamType);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_type
     *
     * @param jcamType the value for jreal_mj_camera.jcam_type
     */
    public void setJcamType(Integer jcamType) {
        this.jcamType = jcamType;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_ip
     *
     * @return the value of jreal_mj_camera.jcam_ip
     */
    public String getJcamIp() {
        return jcamIp;
    }

    /**
     */
    public JrealMjCameraEntity withJcamIp(String jcamIp) {
        this.setJcamIp(jcamIp);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_ip
     *
     * @param jcamIp the value for jreal_mj_camera.jcam_ip
     */
    public void setJcamIp(String jcamIp) {
        this.jcamIp = jcamIp;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_port
     *
     * @return the value of jreal_mj_camera.jcam_port
     */
    public Integer getJcamPort() {
        return jcamPort;
    }

    /**
     */
    public JrealMjCameraEntity withJcamPort(Integer jcamPort) {
        this.setJcamPort(jcamPort);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_port
     *
     * @param jcamPort the value for jreal_mj_camera.jcam_port
     */
    public void setJcamPort(Integer jcamPort) {
        this.jcamPort = jcamPort;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_user
     *
     * @return the value of jreal_mj_camera.jcam_user
     */
    public String getJcamUser() {
        return jcamUser;
    }

    /**
     */
    public JrealMjCameraEntity withJcamUser(String jcamUser) {
        this.setJcamUser(jcamUser);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_user
     *
     * @param jcamUser the value for jreal_mj_camera.jcam_user
     */
    public void setJcamUser(String jcamUser) {
        this.jcamUser = jcamUser;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_password
     *
     * @return the value of jreal_mj_camera.jcam_password
     */
    public String getJcamPassword() {
        return jcamPassword;
    }

    /**
     */
    public JrealMjCameraEntity withJcamPassword(String jcamPassword) {
        this.setJcamPassword(jcamPassword);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_password
     *
     * @param jcamPassword the value for jreal_mj_camera.jcam_password
     */
    public void setJcamPassword(String jcamPassword) {
        this.jcamPassword = jcamPassword;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_chan
     *
     * @return the value of jreal_mj_camera.jcam_chan
     */
    public Integer getJcamChan() {
        return jcamChan;
    }

    /**
     */
    public JrealMjCameraEntity withJcamChan(Integer jcamChan) {
        this.setJcamChan(jcamChan);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_chan
     *
     * @param jcamChan the value for jreal_mj_camera.jcam_chan
     */
    public void setJcamChan(Integer jcamChan) {
        this.jcamChan = jcamChan;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_video
     *
     * @return the value of jreal_mj_camera.jcam_video
     */
    public Integer getJcamVideo() {
        return jcamVideo;
    }

    /**
     */
    public JrealMjCameraEntity withJcamVideo(Integer jcamVideo) {
        this.setJcamVideo(jcamVideo);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_video
     *
     * @param jcamVideo the value for jreal_mj_camera.jcam_video
     */
    public void setJcamVideo(Integer jcamVideo) {
        this.jcamVideo = jcamVideo;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_sleep
     *
     * @return the value of jreal_mj_camera.jcam_sleep
     */
    public Integer getJcamSleep() {
        return jcamSleep;
    }

    /**
     */
    public JrealMjCameraEntity withJcamSleep(Integer jcamSleep) {
        this.setJcamSleep(jcamSleep);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_sleep
     *
     * @param jcamSleep the value for jreal_mj_camera.jcam_sleep
     */
    public void setJcamSleep(Integer jcamSleep) {
        this.jcamSleep = jcamSleep;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_success
     *
     * @return the value of jreal_mj_camera.jcam_success
     */
    public Integer getJcamSuccess() {
        return jcamSuccess;
    }

    /**
     */
    public JrealMjCameraEntity withJcamSuccess(Integer jcamSuccess) {
        this.setJcamSuccess(jcamSuccess);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_success
     *
     * @param jcamSuccess the value for jreal_mj_camera.jcam_success
     */
    public void setJcamSuccess(Integer jcamSuccess) {
        this.jcamSuccess = jcamSuccess;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_fail
     *
     * @return the value of jreal_mj_camera.jcam_fail
     */
    public Integer getJcamFail() {
        return jcamFail;
    }

    /**
     */
    public JrealMjCameraEntity withJcamFail(Integer jcamFail) {
        this.setJcamFail(jcamFail);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_fail
     *
     * @param jcamFail the value for jreal_mj_camera.jcam_fail
     */
    public void setJcamFail(Integer jcamFail) {
        this.jcamFail = jcamFail;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_warning
     *
     * @return the value of jreal_mj_camera.jcam_warning
     */
    public Integer getJcamWarning() {
        return jcamWarning;
    }

    /**
     */
    public JrealMjCameraEntity withJcamWarning(Integer jcamWarning) {
        this.setJcamWarning(jcamWarning);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_warning
     *
     * @param jcamWarning the value for jreal_mj_camera.jcam_warning
     */
    public void setJcamWarning(Integer jcamWarning) {
        this.jcamWarning = jcamWarning;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_other
     *
     * @return the value of jreal_mj_camera.jcam_other
     */
    public Integer getJcamOther() {
        return jcamOther;
    }

    /**
     */
    public JrealMjCameraEntity withJcamOther(Integer jcamOther) {
        this.setJcamOther(jcamOther);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_other
     *
     * @param jcamOther the value for jreal_mj_camera.jcam_other
     */
    public void setJcamOther(Integer jcamOther) {
        this.jcamOther = jcamOther;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_cut_left
     *
     * @return the value of jreal_mj_camera.jcam_cut_left
     */
    public Integer getJcamCutLeft() {
        return jcamCutLeft;
    }

    /**
     */
    public JrealMjCameraEntity withJcamCutLeft(Integer jcamCutLeft) {
        this.setJcamCutLeft(jcamCutLeft);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_cut_left
     *
     * @param jcamCutLeft the value for jreal_mj_camera.jcam_cut_left
     */
    public void setJcamCutLeft(Integer jcamCutLeft) {
        this.jcamCutLeft = jcamCutLeft;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_cut_top
     *
     * @return the value of jreal_mj_camera.jcam_cut_top
     */
    public Integer getJcamCutTop() {
        return jcamCutTop;
    }

    /**
     */
    public JrealMjCameraEntity withJcamCutTop(Integer jcamCutTop) {
        this.setJcamCutTop(jcamCutTop);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_cut_top
     *
     * @param jcamCutTop the value for jreal_mj_camera.jcam_cut_top
     */
    public void setJcamCutTop(Integer jcamCutTop) {
        this.jcamCutTop = jcamCutTop;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_cut_weight
     *
     * @return the value of jreal_mj_camera.jcam_cut_weight
     */
    public Integer getJcamCutWeight() {
        return jcamCutWeight;
    }

    /**
     */
    public JrealMjCameraEntity withJcamCutWeight(Integer jcamCutWeight) {
        this.setJcamCutWeight(jcamCutWeight);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_cut_weight
     *
     * @param jcamCutWeight the value for jreal_mj_camera.jcam_cut_weight
     */
    public void setJcamCutWeight(Integer jcamCutWeight) {
        this.jcamCutWeight = jcamCutWeight;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_cut_height
     *
     * @return the value of jreal_mj_camera.jcam_cut_height
     */
    public Integer getJcamCutHeight() {
        return jcamCutHeight;
    }

    /**
     */
    public JrealMjCameraEntity withJcamCutHeight(Integer jcamCutHeight) {
        this.setJcamCutHeight(jcamCutHeight);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_cut_height
     *
     * @param jcamCutHeight the value for jreal_mj_camera.jcam_cut_height
     */
    public void setJcamCutHeight(Integer jcamCutHeight) {
        this.jcamCutHeight = jcamCutHeight;
    }

    /**
     * This method returns the value of the database column jreal_mj_camera.jcam_zoom_per
     *
     * @return the value of jreal_mj_camera.jcam_zoom_per
     */
    public Integer getJcamZoomPer() {
        return jcamZoomPer;
    }

    /**
     */
    public JrealMjCameraEntity withJcamZoomPer(Integer jcamZoomPer) {
        this.setJcamZoomPer(jcamZoomPer);
        return this;
    }

    /**
     * This method sets the value of the database column jreal_mj_camera.jcam_zoom_per
     *
     * @param jcamZoomPer the value for jreal_mj_camera.jcam_zoom_per
     */
    public void setJcamZoomPer(Integer jcamZoomPer) {
        this.jcamZoomPer = jcamZoomPer;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}