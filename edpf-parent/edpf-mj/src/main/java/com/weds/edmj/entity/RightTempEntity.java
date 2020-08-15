package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.edpf.core.entity.ExportRptEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

public class RightTempEntity extends ExportRptEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private Long userSerial;

    /**
     *
     */
    @Size(max = 16)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String gateBh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer fx;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-13 13:57:30", value = "")
    private Date kssj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-13 13:57:30", value = "")
    private Date jssj;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String ksSj;

    /**
     *
     */
    @Size(max = 20)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String jsSj;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-08-13 13:57:30", value = "")
    private Date sj;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String glyNo;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column mj_right_temp.xh
     *
     * @return the value of mj_right_temp.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public RightTempEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.xh
     *
     * @param xh the value for mj_right_temp.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column mj_right_temp.user_serial
     *
     * @return the value of mj_right_temp.user_serial
     */
    public Long getUserSerial() {
        return userSerial;
    }

    /**
     */
    public RightTempEntity withUserSerial(Long userSerial) {
        this.setUserSerial(userSerial);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.user_serial
     *
     * @param userSerial the value for mj_right_temp.user_serial
     */
    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    /**
     * This method returns the value of the database column mj_right_temp.gate_bh
     *
     * @return the value of mj_right_temp.gate_bh
     */
    public String getGateBh() {
        return gateBh;
    }

    /**
     */
    public RightTempEntity withGateBh(String gateBh) {
        this.setGateBh(gateBh);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.gate_bh
     *
     * @param gateBh the value for mj_right_temp.gate_bh
     */
    public void setGateBh(String gateBh) {
        this.gateBh = gateBh;
    }

    /**
     * This method returns the value of the database column mj_right_temp.fx
     *
     * @return the value of mj_right_temp.fx
     */
    public Integer getFx() {
        return fx;
    }

    /**
     */
    public RightTempEntity withFx(Integer fx) {
        this.setFx(fx);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.fx
     *
     * @param fx the value for mj_right_temp.fx
     */
    public void setFx(Integer fx) {
        this.fx = fx;
    }

    /**
     * This method returns the value of the database column mj_right_temp.kssj
     *
     * @return the value of mj_right_temp.kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     */
    public RightTempEntity withKssj(Date kssj) {
        this.setKssj(kssj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.kssj
     *
     * @param kssj the value for mj_right_temp.kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * This method returns the value of the database column mj_right_temp.jssj
     *
     * @return the value of mj_right_temp.jssj
     */
    public Date getJssj() {
        return jssj;
    }

    /**
     */
    public RightTempEntity withJssj(Date jssj) {
        this.setJssj(jssj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.jssj
     *
     * @param jssj the value for mj_right_temp.jssj
     */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
     * This method returns the value of the database column mj_right_temp.ks_sj
     *
     * @return the value of mj_right_temp.ks_sj
     */
    public String getKsSj() {
        return ksSj;
    }

    /**
     */
    public RightTempEntity withKsSj(String ksSj) {
        this.setKsSj(ksSj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.ks_sj
     *
     * @param ksSj the value for mj_right_temp.ks_sj
     */
    public void setKsSj(String ksSj) {
        this.ksSj = ksSj;
    }

    /**
     * This method returns the value of the database column mj_right_temp.js_sj
     *
     * @return the value of mj_right_temp.js_sj
     */
    public String getJsSj() {
        return jsSj;
    }

    /**
     */
    public RightTempEntity withJsSj(String jsSj) {
        this.setJsSj(jsSj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.js_sj
     *
     * @param jsSj the value for mj_right_temp.js_sj
     */
    public void setJsSj(String jsSj) {
        this.jsSj = jsSj;
    }

    /**
     * This method returns the value of the database column mj_right_temp.sj
     *
     * @return the value of mj_right_temp.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public RightTempEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column mj_right_temp.sj
     *
     * @param sj the value for mj_right_temp.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column mj_right_temp.gly_no
     *
     * @return the value of mj_right_temp.gly_no
     */
    public String getGlyNo() {
        return glyNo;
    }

    /**
     */
    public RightTempEntity withGlyNo(String glyNo) {
        this.setGlyNo(glyNo);
        return this;
    }

    @ApiModelProperty(dataType = "list", value = "场所列表")
    private List<Integer> placeList;
    @ApiModelProperty(dataType = "list", value = "部门列表")
    private List<Integer> depList;
    @ApiModelProperty(dataType = "list", value = "门列表")
    private List<String> gateList;
    @ApiModelProperty(dataType = "list", value = "人员列表")
    private List<Long> userList;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "场所名称")
    private String depName;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "门名称")
    private String doorName;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "姓名")
    private String userLname;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "工号")
    private String userNo;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "卡号")
    private String userCard;
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "部门名称")
    private String userDepName;

    public List<Integer> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Integer> placeList) {
        this.placeList = placeList;
    }

    public List<Integer> getDepList() {
        return depList;
    }

    public void setDepList(List<Integer> depList) {
        this.depList = depList;
    }

    public List<String> getGateList() {
        return gateList;
    }

    public void setGateList(List<String> gateList) {
        this.gateList = gateList;
    }

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserDepName() {
        return userDepName;
    }

    public void setUserDepName(String userDepName) {
        this.userDepName = userDepName;
    }

    /**
     * This method sets the value of the database column mj_right_temp.gly_no
     *
     * @param glyNo the value for mj_right_temp.gly_no
     */
    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}