package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class DoorInfoEntity extends BaseEntity implements Serializable {
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "人员序号")
    private Long userSerial;

    @ApiModelProperty(required = true, dataType = "object", example = "", value = "门列表")
    private List<MjMobileEntity> doorList;

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    public List<MjMobileEntity> getDoorList() {
        return doorList;
    }

    public void setDoorList(List<MjMobileEntity> doorList) {
        this.doorList = doorList;
    }
}
