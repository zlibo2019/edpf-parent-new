package com.weds.edwx.entity;

import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class AppApprovalEntity extends BaseEntity {
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

    private String userId;

    private String taskId;

    private String result;

    private String message;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
