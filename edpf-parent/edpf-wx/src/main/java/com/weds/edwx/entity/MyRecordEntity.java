package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class MyRecordEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = false, dataType = "string", example = "2018010100000023",value = "")
    private String xh;  // 唯一ID

    @ApiModelProperty(required = false, dataType = "string", example = "张三",value = "")
    private String name;  // 人员姓名

   // private String qjbh;  // 假类编号
    @ApiModelProperty(required = false, dataType = "string", example = "事假",value = "")
    private String qjlx;  // 假类名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "string", example = "2018-12-03 09:58:30",value = "")
    private Date kssj;  // 开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "string", example = "2018-12-03 20:58:30",value = "")
    private Date jssj;   // 结束时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @ApiModelProperty(required = false, dataType = "string", example = "2018-12-03 08:58:30",value = "")
    private Date qjsj;  // 操作时间

    @ApiModelProperty(required = false, example = "1",value = "")
    private int type; // 申请类型

    @ApiModelProperty(required = false, dataType = "string", example = "2018-12-03",value = "")
    private String rq; // 调班日期

    //private String kqlx; // 考勤类型
    @ApiModelProperty(required = true, dataType = "int", example = "20000003",value = "")
    private String userSerial;

    @ApiModelProperty(required = true, dataType = "int", example = "0",value = "")
    private String lx;  // 审批状态

    private String bh;


    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQjlx() {
        return qjlx;
    }

    public void setQjlx(String qjlx) {
        this.qjlx = qjlx;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public Date getQjsj() {
        return qjsj;
    }

    public void setQjsj(Date qjsj) {
        this.qjsj = qjsj;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }
}
