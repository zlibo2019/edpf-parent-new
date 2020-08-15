package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class AppSubmitEntity extends BaseEntity {
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

    @ApiModelProperty("流程编号")
    private String processId;

    @ApiModelProperty("申请人ID")
    private Integer initiatorId;

    @ApiModelProperty("审批人ID")
    private String approveIds;

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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Integer getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Integer initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getApproveIds() {
        return approveIds;
    }

    public void setApproveIds(String approveIds) {
        this.approveIds = approveIds;
    }
}
