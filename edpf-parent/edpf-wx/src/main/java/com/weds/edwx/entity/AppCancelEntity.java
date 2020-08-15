package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class AppCancelEntity extends BaseEntity {
    /**
     * 企业编号
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "企业编号")
    private Integer companyId;

    /**
     * 记录编号
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "记录编号")
    private String bussinessId;

    @ApiModelProperty("申请人ID")
    private Integer initiatorId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(String bussinessId) {
        this.bussinessId = bussinessId;
    }

    public Integer getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Integer initiatorId) {
        this.initiatorId = initiatorId;
    }
}
