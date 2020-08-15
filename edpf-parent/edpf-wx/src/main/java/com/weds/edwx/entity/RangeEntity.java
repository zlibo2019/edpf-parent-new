package com.weds.edwx.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class RangeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "String", example = "121.098471", value = "经度")
    private String longitude;

    @ApiModelProperty(required = false, dataType = "String", example = "37.560664", value = "纬度")
    private String latitude;

    @ApiModelProperty(required = false, dataType = "String", example = "200", value = "范围")
    private String range;


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
