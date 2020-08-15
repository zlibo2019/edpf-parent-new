package com.weds.edwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weds.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @Author sxm
 * @Description 审批流程表
 * @Date 2019-02-19
 */
public class AppFlowEntity extends BaseEntity implements Serializable {
    /**
     *   流程编号
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "流程编号")
    private String flowId;

    /**
     *   企业编号
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "企业编号")
    private Integer companyId;

    /**
     *   记录编号
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "记录编号")
    private String bussinessId;

    /**
     *   流程人员
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "流程人员")
    private String flowUserId;

    /**
     *   审批时间
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "审批时间")
    private String flowTime;

    /**
     *   审批状态
     *
     */
    @ApiModelProperty(required = true, dataType = "int", example = "-1", value = "审批状态")
    private Integer flowState;

    /**
     *   审批意见
     *
     */
    @ApiModelProperty(required = true, dataType = "string", example = "测试", value = "审批意见")
    private String flowCotent;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column app_flow.flow_id
     *
     * @return the value of app_flow.flow_id
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     */
    public AppFlowEntity withFlowId(String flowId) {
        this.setFlowId(flowId);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.flow_id
     *
     * @param flowId the value for app_flow.flow_id
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * This method returns the value of the database column app_flow.company_id
     *
     * @return the value of app_flow.company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     */
    public AppFlowEntity withCompanyId(Integer companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.company_id
     *
     * @param companyId the value for app_flow.company_id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method returns the value of the database column app_flow.bussiness_id
     *
     * @return the value of app_flow.bussiness_id
     */
    public String getBussinessId() {
        return bussinessId;
    }

    /**
     */
    public AppFlowEntity withBussinessId(String bussinessId) {
        this.setBussinessId(bussinessId);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.bussiness_id
     *
     * @param bussinessId the value for app_flow.bussiness_id
     */
    public void setBussinessId(String bussinessId) {
        this.bussinessId = bussinessId;
    }

    /**
     * This method returns the value of the database column app_flow.flow_user_id
     *
     * @return the value of app_flow.flow_user_id
     */
    public String getFlowUserId() {
        return flowUserId;
    }

    /**
     */
    public AppFlowEntity withFlowUserId(String flowUserId) {
        this.setFlowUserId(flowUserId);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.flow_user_id
     *
     * @param flowUserId the value for app_flow.flow_user_id
     */
    public void setFlowUserId(String flowUserId) {
        this.flowUserId = flowUserId;
    }

    /**
     * This method returns the value of the database column app_flow.flow_time
     *
     * @return the value of app_flow.flow_time
     */
    public String getFlowTime() {
        return flowTime;
    }

    /**
     */
    public AppFlowEntity withFlowTime(String flowTime) {
        this.setFlowTime(flowTime);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.flow_time
     *
     * @param flowTime the value for app_flow.flow_time
     */
    public void setFlowTime(String flowTime) {
        this.flowTime = flowTime;
    }

    /**
     * This method returns the value of the database column app_flow.flow_state
     *
     * @return the value of app_flow.flow_state
     */
    public Integer getFlowState() {
        return flowState;
    }

    /**
     */
    public AppFlowEntity withFlowState(Integer flowState) {
        this.setFlowState(flowState);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.flow_state
     *
     * @param flowState the value for app_flow.flow_state
     */
    public void setFlowState(Integer flowState) {
        this.flowState = flowState;
    }

    /**
     * This method returns the value of the database column app_flow.flow_cotent
     *
     * @return the value of app_flow.flow_cotent
     */
    public String getFlowCotent() {
        return flowCotent;
    }

    /**
     */
    public AppFlowEntity withFlowCotent(String flowCotent) {
        this.setFlowCotent(flowCotent);
        return this;
    }

    /**
     * This method sets the value of the database column app_flow.flow_cotent
     *
     * @param flowCotent the value for app_flow.flow_cotent
     */
    public void setFlowCotent(String flowCotent) {
        this.flowCotent = flowCotent;
    }
}