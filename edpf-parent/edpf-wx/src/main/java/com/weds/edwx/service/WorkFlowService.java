package com.weds.edwx.service;


import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.ApprovalParamEntity;
import com.weds.edwx.entity.DeleteRecordParamEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.mapper.WorkFlowMapper;
import com.weds.workflow.leave.entity.LeaveApplyEntity;
import com.weds.workflow.leave.web.LeaveManageController;
import com.weds.workflow.service.WorkFlowEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkFlowService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WorkFlowEngineService workFlowEngineService;

    @Autowired
    private WorkFlowMapper workFlowMapper;

    @Resource
    private LeaveManageController leaveManageController;


    /**
     * 录入记录申请
     * @param businessKey  流程编号 年月日时分秒+两位随机数
     * @param initiatorId  发起人ID
     * @param initiatorDep  部门
     * @param initiatorRole 发起人角色编号
     * @param leaveDays  申请天数
     * @param leaveType  申请类型编号
     * @param approveIds  审批人
     * @param processId   流程ID
     *
     */
    public JsonResult<Object> startProcess(String businessKey, String initiatorId, String initiatorDep, String initiatorRole, String leaveDays, String leaveType, String approveIds, String processId) {

        LeaveApplyEntity leaveApplyEntity = new LeaveApplyEntity();
        leaveApplyEntity.setBusinessKey(businessKey);
        leaveApplyEntity.setInitiatorDep(initiatorDep);
        leaveApplyEntity.setInitiatorId(initiatorId);
        leaveApplyEntity.setInitiatorRole(initiatorRole);
        leaveApplyEntity.setLeaveDays(new BigDecimal(leaveDays));
        leaveApplyEntity.setLeaveType(leaveType);
        leaveApplyEntity.setApproveIds(approveIds);
        leaveApplyEntity.setProcessId(processId);
        JsonResult jsonResult = leaveManageController.startProcess(leaveApplyEntity);
        return jsonResult;

        /*
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String,String> param = new HashMap<>();
        param.put("businessKey", businessKey);
        param.put("initiatorId", initiatorId);
        param.put("initiatorDep", initiatorDep);
        param.put("initiatorRole", initiatorRole);
        param.put("leaveDays", leaveDays);
        param.put("leaveType", leaveType);
        param.put("approveIds", approveIds);
        param.put("processId", processId);
        HttpEntity<Map<String,String>> request = new HttpEntity<Map<String,String>>(param,httpHeaders);
        ResponEntity responEntity = restTemplate.postForObject(workFlowUrl+"/leaveManage/startProcess",request, ResponEntity.class);
        return responEntity;*/
    }

    /**
     * 审批接口
     * @param approvalParamEntity
     * @return
     * @throws Exception
     */
    public JsonResult completeTask(ApprovalParamEntity approvalParamEntity){
        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String,String> param = new HashMap<>();
        param.put("userId",approvalParamEntity.getUserSerial());
        param.put("taskId",approvalParamEntity.getCheckId());
        param.put("result",approvalParamEntity.getResult());
        param.put("message",approvalParamEntity.getReason());
        HttpEntity<Map<String,String>> request = new HttpEntity<Map<String,String>>(param,httpHeaders);
        ResponEntity responEntity = restTemplate.postForObject(workFlowUrl+"/workFlowEngine/completeTask",request, ResponEntity.class);*/
        JsonResult result =
                workFlowEngineService.completeTask(approvalParamEntity.getUserSerial(),approvalParamEntity.getCheckId(),approvalParamEntity.getResult(),approvalParamEntity.getReason());
        return result;
    }

    /**
     * 撤销接口
     * @param xh
     * @param reason
     * @return
     * @throws Exception
     */
    public JsonResult deleteProcessInstanceByBussinessKey(String xh,String reason){
        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String,String> param = new HashMap<>();
        param.put("bussinessKey",xh);
        param.put("deleteReason",reason);
        HttpEntity<Map<String,String>> request = new HttpEntity<Map<String,String>>(param,httpHeaders);
        ResponEntity responEntity = restTemplate.postForObject(workFlowUrl+"/workFlowEngine/deleteProcessInstanceByBussinessKey",request, ResponEntity.class);*/

        JsonResult responEntity  = workFlowEngineService.deleteProcessInstanceByBussinessKey(xh,reason);
        return responEntity;
    }

    /**
     * 单个修改taskId
     * @param userSerial
     * @param xh
     */
    public void updateTaskByBusinessKey(String userSerial, String xh) {
        JsonResult result = workFlowEngineService.findTaskByBussinessKey(userSerial,xh);
        if (result != null && CoreConstants.SUCCESSED_FLAG.equals(result.getCode())) {
            workFlowMapper.updateTaskByBusinessKey(result.getMsg(),xh);
        }
    }


}
