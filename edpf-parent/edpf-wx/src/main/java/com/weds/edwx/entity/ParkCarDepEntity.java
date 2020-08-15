package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ParkCarDepEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer parkSerial;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer parkParent;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer parkNo;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String parkName;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isPublic;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isKq;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer isVis;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column park_car_dep.park_serial
     *
     * @return the value of park_car_dep.park_serial
     */
    public Integer getParkSerial() {
        return parkSerial;
    }

    /**
     */
    public ParkCarDepEntity withParkSerial(Integer parkSerial) {
        this.setParkSerial(parkSerial);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.park_serial
     *
     * @param parkSerial the value for park_car_dep.park_serial
     */
    public void setParkSerial(Integer parkSerial) {
        this.parkSerial = parkSerial;
    }

    /**
     * This method returns the value of the database column park_car_dep.park_parent
     *
     * @return the value of park_car_dep.park_parent
     */
    public Integer getParkParent() {
        return parkParent;
    }

    /**
     */
    public ParkCarDepEntity withParkParent(Integer parkParent) {
        this.setParkParent(parkParent);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.park_parent
     *
     * @param parkParent the value for park_car_dep.park_parent
     */
    public void setParkParent(Integer parkParent) {
        this.parkParent = parkParent;
    }

    /**
     * This method returns the value of the database column park_car_dep.park_no
     *
     * @return the value of park_car_dep.park_no
     */
    public Integer getParkNo() {
        return parkNo;
    }

    /**
     */
    public ParkCarDepEntity withParkNo(Integer parkNo) {
        this.setParkNo(parkNo);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.park_no
     *
     * @param parkNo the value for park_car_dep.park_no
     */
    public void setParkNo(Integer parkNo) {
        this.parkNo = parkNo;
    }

    /**
     * This method returns the value of the database column park_car_dep.park_name
     *
     * @return the value of park_car_dep.park_name
     */
    public String getParkName() {
        return parkName;
    }

    /**
     */
    public ParkCarDepEntity withParkName(String parkName) {
        this.setParkName(parkName);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.park_name
     *
     * @param parkName the value for park_car_dep.park_name
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * This method returns the value of the database column park_car_dep.is_public
     *
     * @return the value of park_car_dep.is_public
     */
    public Integer getIsPublic() {
        return isPublic;
    }

    /**
     */
    public ParkCarDepEntity withIsPublic(Integer isPublic) {
        this.setIsPublic(isPublic);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.is_public
     *
     * @param isPublic the value for park_car_dep.is_public
     */
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * This method returns the value of the database column park_car_dep.is_kq
     *
     * @return the value of park_car_dep.is_kq
     */
    public Integer getIsKq() {
        return isKq;
    }

    /**
     */
    public ParkCarDepEntity withIsKq(Integer isKq) {
        this.setIsKq(isKq);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.is_kq
     *
     * @param isKq the value for park_car_dep.is_kq
     */
    public void setIsKq(Integer isKq) {
        this.isKq = isKq;
    }

    /**
     * This method returns the value of the database column park_car_dep.is_vis
     *
     * @return the value of park_car_dep.is_vis
     */
    public Integer getIsVis() {
        return isVis;
    }

    /**
     */
    public ParkCarDepEntity withIsVis(Integer isVis) {
        this.setIsVis(isVis);
        return this;
    }

    /**
     * This method sets the value of the database column park_car_dep.is_vis
     *
     * @param isVis the value for park_car_dep.is_vis
     */
    public void setIsVis(Integer isVis) {
        this.isVis = isVis;
    }
}