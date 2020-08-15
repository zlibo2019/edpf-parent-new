package com.weds.edwx.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AddOutAttenceParamEntity extends AddAttenceParamEntity {

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "未知")
    private String customerName;

    @ApiModelProperty(required = true, dataType = "String", example = "..", value = "未知")
    private String outsideInfo;

    private String images;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOutsideInfo() {
        return outsideInfo;
    }

    public void setOutsideInfo(String outsideInfo) {
        this.outsideInfo = outsideInfo;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
