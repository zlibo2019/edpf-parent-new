package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class AttenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "Date", example = "2018-12-26 15:26:51", value = "考勤时间")
    private Date sj;

    @ApiModelProperty(required = false, dataType = "String", example = "0:不区分方向,1:进,2:出", value = "方向")
    private String fx;

    private Integer bh;

    private String jlzpSerial;

    private String devSerial;

    private String image;

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJlzpSerial() {
        return jlzpSerial;
    }

    public void setJlzpSerial(String jlzpSerial) {
        this.jlzpSerial = jlzpSerial;
    }

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }
}
