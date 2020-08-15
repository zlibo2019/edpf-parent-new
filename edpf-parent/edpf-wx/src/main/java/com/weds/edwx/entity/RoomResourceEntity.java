package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class RoomResourceEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer xh;

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer resourceXh;

    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "")
    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "")
    private Integer depSerial;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column room_resource.xh
     *
     * @return the value of room_resource.xh
     */
    public Integer getXh() {
        return xh;
    }

    /**
     */
    public RoomResourceEntity withXh(Integer xh) {
        this.setXh(xh);
        return this;
    }

    /**
     * This method sets the value of the database column room_resource.xh
     *
     * @param xh the value for room_resource.xh
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * This method returns the value of the database column room_resource.resource_xh
     *
     * @return the value of room_resource.resource_xh
     */
    public Integer getResourceXh() {
        return resourceXh;
    }

    /**
     */
    public RoomResourceEntity withResourceXh(Integer resourceXh) {
        this.setResourceXh(resourceXh);
        return this;
    }

    /**
     * This method sets the value of the database column room_resource.resource_xh
     *
     * @param resourceXh the value for room_resource.resource_xh
     */
    public void setResourceXh(Integer resourceXh) {
        this.resourceXh = resourceXh;
    }

    /**
     * This method returns the value of the database column room_resource.dep_serial
     *
     * @return the value of room_resource.dep_serial
     */
    public Integer getDepSerial() {
        return depSerial;
    }

    /**
     */
    public RoomResourceEntity withDepSerial(Integer depSerial) {
        this.setDepSerial(depSerial);
        return this;
    }

    /**
     * This method sets the value of the database column room_resource.dep_serial
     *
     * @param depSerial the value for room_resource.dep_serial
     */
    public void setDepSerial(Integer depSerial) {
        this.depSerial = depSerial;
    }
}