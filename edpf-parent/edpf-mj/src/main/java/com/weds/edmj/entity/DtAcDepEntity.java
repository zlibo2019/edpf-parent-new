package com.weds.edmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

public class DtAcDepEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depParent;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depOrder;

    /**
     *
     *
     *
     *
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depName;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNo;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depRule;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = true, dataType = "string", example = "2019-07-30 17:16:35", value = "")
    private Date sj;

    /**
     *
     */
    @Size(max = 4)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String moduleId;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depType;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String regserial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depState;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depLx;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depPlace;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depXPoint;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depYPoint;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depLock;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSex;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depFloor;

    /**
     *
     */
    @Size(max = 50)
    @ApiModelProperty(required = true, dataType = "string", example = "test", value = "")
    private String depNumber;

    /**
     */
    private static final long serialVersionUID = 1L;

    private String keys;

    /**
     * This method returns the value of the database column dt_ac_dep.dep_serial
     *
     * @return the value of dt_ac_dep.dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public DtAcDepEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_serial
     *
     * @param depSerial the value for dt_ac_dep.dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_parent
     *
     * @return the value of dt_ac_dep.dep_parent
     */
    public Integer getDepParent() {
        return depParent;
    }

    /**
     */
    public DtAcDepEntity withDepParent(Integer depParent) {
        this.setDepParent(depParent);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_parent
     *
     * @param depParent the value for dt_ac_dep.dep_parent
     */
    public void setDepParent(Integer depParent) {
        this.depParent = depParent;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_order
     *
     * @return the value of dt_ac_dep.dep_order
     */
    public Integer getDepOrder() {
        return depOrder;
    }

    /**
     */
    public DtAcDepEntity withDepOrder(Integer depOrder) {
        this.setDepOrder(depOrder);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_order
     *
     * @param depOrder the value for dt_ac_dep.dep_order
     */
    public void setDepOrder(Integer depOrder) {
        this.depOrder = depOrder;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_name
     *
     * @return the value of dt_ac_dep.dep_name
     */
    public String getDepName() {
        return depName;
    }

    /**
     */
    public DtAcDepEntity withDepName(String depName) {
        this.setDepName(depName);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_name
     *
     * @param depName the value for dt_ac_dep.dep_name
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_no
     *
     * @return the value of dt_ac_dep.dep_no
     */
    public String getDepNo() {
        return depNo;
    }

    /**
     */
    public DtAcDepEntity withDepNo(String depNo) {
        this.setDepNo(depNo);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_no
     *
     * @param depNo the value for dt_ac_dep.dep_no
     */
    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_rule
     *
     * @return the value of dt_ac_dep.dep_rule
     */
    public String getDepRule() {
        return depRule;
    }

    /**
     */
    public DtAcDepEntity withDepRule(String depRule) {
        this.setDepRule(depRule);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_rule
     *
     * @param depRule the value for dt_ac_dep.dep_rule
     */
    public void setDepRule(String depRule) {
        this.depRule = depRule;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.sj
     *
     * @return the value of dt_ac_dep.sj
     */
    public Date getSj() {
        return sj;
    }

    /**
     */
    public DtAcDepEntity withSj(Date sj) {
        this.setSj(sj);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.sj
     *
     * @param sj the value for dt_ac_dep.sj
     */
    public void setSj(Date sj) {
        this.sj = sj;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.module_id
     *
     * @return the value of dt_ac_dep.module_id
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     */
    public DtAcDepEntity withModuleId(String moduleId) {
        this.setModuleId(moduleId);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.module_id
     *
     * @param moduleId the value for dt_ac_dep.module_id
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_type
     *
     * @return the value of dt_ac_dep.Dep_type
     */
    public Integer getDepType() {
        return depType;
    }

    /**
     */
    public DtAcDepEntity withDepType(Integer depType) {
        this.setDepType(depType);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_type
     *
     * @param depType the value for dt_ac_dep.Dep_type
     */
    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.regserial
     *
     * @return the value of dt_ac_dep.regserial
     */
    public String getRegserial() {
        return regserial;
    }

    /**
     */
    public DtAcDepEntity withRegserial(String regserial) {
        this.setRegserial(regserial);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.regserial
     *
     * @param regserial the value for dt_ac_dep.regserial
     */
    public void setRegserial(String regserial) {
        this.regserial = regserial;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_state
     *
     * @return the value of dt_ac_dep.dep_state
     */
    public Integer getDepState() {
        return depState;
    }

    /**
     */
    public DtAcDepEntity withDepState(Integer depState) {
        this.setDepState(depState);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_state
     *
     * @param depState the value for dt_ac_dep.dep_state
     */
    public void setDepState(Integer depState) {
        this.depState = depState;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_lx
     *
     * @return the value of dt_ac_dep.dep_lx
     */
    public Integer getDepLx() {
        return depLx;
    }

    /**
     */
    public DtAcDepEntity withDepLx(Integer depLx) {
        this.setDepLx(depLx);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_lx
     *
     * @param depLx the value for dt_ac_dep.dep_lx
     */
    public void setDepLx(Integer depLx) {
        this.depLx = depLx;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_place
     *
     * @return the value of dt_ac_dep.dep_place
     */
    public Integer getDepPlace() {
        return depPlace;
    }

    /**
     */
    public DtAcDepEntity withDepPlace(Integer depPlace) {
        this.setDepPlace(depPlace);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_place
     *
     * @param depPlace the value for dt_ac_dep.dep_place
     */
    public void setDepPlace(Integer depPlace) {
        this.depPlace = depPlace;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_x_point
     *
     * @return the value of dt_ac_dep.Dep_x_point
     */
    public Integer getDepXPoint() {
        return depXPoint;
    }

    /**
     */
    public DtAcDepEntity withDepXPoint(Integer depXPoint) {
        this.setDepXPoint(depXPoint);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_x_point
     *
     * @param depXPoint the value for dt_ac_dep.Dep_x_point
     */
    public void setDepXPoint(Integer depXPoint) {
        this.depXPoint = depXPoint;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_Y_point
     *
     * @return the value of dt_ac_dep.Dep_Y_point
     */
    public Integer getDepYPoint() {
        return depYPoint;
    }

    /**
     */
    public DtAcDepEntity withDepYPoint(Integer depYPoint) {
        this.setDepYPoint(depYPoint);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_Y_point
     *
     * @param depYPoint the value for dt_ac_dep.Dep_Y_point
     */
    public void setDepYPoint(Integer depYPoint) {
        this.depYPoint = depYPoint;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_lock
     *
     * @return the value of dt_ac_dep.Dep_lock
     */
    public Integer getDepLock() {
        return depLock;
    }

    /**
     */
    public DtAcDepEntity withDepLock(Integer depLock) {
        this.setDepLock(depLock);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_lock
     *
     * @param depLock the value for dt_ac_dep.Dep_lock
     */
    public void setDepLock(Integer depLock) {
        this.depLock = depLock;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_sex
     *
     * @return the value of dt_ac_dep.Dep_sex
     */
    public Integer getDepSex() {
        return depSex;
    }

    /**
     */
    public DtAcDepEntity withDepSex(Integer depSex) {
        this.setDepSex(depSex);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_sex
     *
     * @param depSex the value for dt_ac_dep.Dep_sex
     */
    public void setDepSex(Integer depSex) {
        this.depSex = depSex;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.Dep_floor
     *
     * @return the value of dt_ac_dep.Dep_floor
     */
    public Integer getDepFloor() {
        return depFloor;
    }

    /**
     */
    public DtAcDepEntity withDepFloor(Integer depFloor) {
        this.setDepFloor(depFloor);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.Dep_floor
     *
     * @param depFloor the value for dt_ac_dep.Dep_floor
     */
    public void setDepFloor(Integer depFloor) {
        this.depFloor = depFloor;
    }

    /**
     * This method returns the value of the database column dt_ac_dep.dep_number
     *
     * @return the value of dt_ac_dep.dep_number
     */
    public String getDepNumber() {
        return depNumber;
    }

    /**
     */
    public DtAcDepEntity withDepNumber(String depNumber) {
        this.setDepNumber(depNumber);
        return this;
    }

    /**
     * This method sets the value of the database column dt_ac_dep.dep_number
     *
     * @param depNumber the value for dt_ac_dep.dep_number
     */
    public void setDepNumber(String depNumber) {
        this.depNumber = depNumber;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}