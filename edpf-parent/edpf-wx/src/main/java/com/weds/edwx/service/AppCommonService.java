package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.AppApprovalEntity;
import com.weds.edwx.entity.AppCancelEntity;
import com.weds.edwx.entity.AppFlowEntity;
import com.weds.edwx.entity.AppSubmitEntity;
import com.weds.workflow.constants.WorkFlowConstants;
import com.weds.workflow.entity.WorkFlowEngineEntity;
import com.weds.workflow.service.WorkFlowEngineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class AppCommonService extends BaseService {

    @Autowired
    private WorkFlowEngineService workFlowEngineService;

    @Autowired
    private AppFlowService appFlowService;

    @ApiOperation(value = "发起申请")
    @Transactional
    public JsonResult<Object> startApply(AppSubmitEntity appSubmitEntity) {
        WorkFlowEngineEntity workFlowEngineEntity = new WorkFlowEngineEntity();
        workFlowEngineEntity.setBusinessKey(appSubmitEntity.getBussinessId());
        workFlowEngineEntity.setInitiatorId(appSubmitEntity.getInitiatorId().toString());
        workFlowEngineEntity.setProcessId(appSubmitEntity.getProcessId());
        Map<String, Object> variables = new HashMap<>();
        workFlowEngineEntity.setVariables(variables);
        workFlowEngineEntity.setApproveIds(appSubmitEntity.getApproveIds());

        JsonResult<Object> rtn = workFlowEngineService.startUserTask(workFlowEngineEntity);
        if (CoreConstants.SUCCESSED_FLAG.equals(rtn.getCode()) || WorkFlowConstants.PROCESS_FINISHED.equals(rtn.getCode())) {
            AppFlowEntity appFlowEntity = new AppFlowEntity();
            appFlowEntity.setFlowId(StringUtils.getUUID());
            appFlowEntity.setCompanyId(appSubmitEntity.getCompanyId());
            appFlowEntity.setBussinessId(appSubmitEntity.getBussinessId());
            appFlowEntity.setFlowUserId(appSubmitEntity.getInitiatorId().toString());
            appFlowEntity.setFlowState(Integer.parseInt(WorkFlowConstants.TASK_SUBMIT));
            appFlowEntity.setFlowTime(DateUtils.getCurrentDateTime());
            appFlowService.insertSelective(appFlowEntity);

            appFlowEntity = new AppFlowEntity();
            appFlowEntity.setFlowId(StringUtils.getUUID());
            appFlowEntity.setCompanyId(appSubmitEntity.getCompanyId());
            appFlowEntity.setBussinessId(appSubmitEntity.getBussinessId());
            appFlowEntity.setFlowTime(DateUtils.getCurrentDateTime());

            if (CoreConstants.SUCCESSED_FLAG.equals(rtn.getCode())) {
                appFlowEntity.setFlowUserId(((Map) rtn.getData()).get("approveId").toString());
                appFlowEntity.setFlowState(Integer.parseInt(WorkFlowConstants.TASK_NEXT));
            } else {
                appFlowEntity.setFlowUserId(appSubmitEntity.getInitiatorId().toString());
                appFlowEntity.setFlowState(Integer.parseInt(WorkFlowConstants.APPROVE_AGREE));
            }
            appFlowService.insertSelective(appFlowEntity);
        }
        return rtn;
    }

    @ApiOperation(value = "任务审批")
    @Transactional
    public JsonResult<String> approveApply(AppApprovalEntity appApprovalEntity) {
        JsonResult<String> rtn = workFlowEngineService.completeTask(appApprovalEntity.getUserId(), appApprovalEntity.getTaskId(),
                appApprovalEntity.getResult(), appApprovalEntity.getMessage());
        if (CoreConstants.SUCCESSED_FLAG.equals(rtn.getCode()) || WorkFlowConstants.PROCESS_FINISHED.equals(rtn.getCode())) {
            appFlowService.deleteNextApproval(appApprovalEntity.getBussinessId());

            AppFlowEntity appFlowEntity = new AppFlowEntity();
            appFlowEntity.setFlowId(StringUtils.getUUID());
            appFlowEntity.setCompanyId(appApprovalEntity.getCompanyId());
            appFlowEntity.setBussinessId(appApprovalEntity.getBussinessId());
            appFlowEntity.setFlowUserId(appApprovalEntity.getUserId());
            appFlowEntity.setFlowState(Integer.parseInt(appApprovalEntity.getResult()));
            appFlowEntity.setFlowTime(DateUtils.getCurrentDateTime());
            appFlowEntity.setFlowCotent(appApprovalEntity.getMessage());
            appFlowService.insertSelective(appFlowEntity);
        }
        return rtn;
    }

    @ApiOperation(value = "任务撤销")
    @Transactional
    public JsonResult<Object> cancleApply(AppCancelEntity appCancelEntity) {
        JsonResult<Object> rtn = workFlowEngineService.deleteProcessInstanceByBussinessKey(appCancelEntity.getBussinessId(), null);
        if (CoreConstants.SUCCESSED_FLAG.equals(rtn.getCode())) {
            appFlowService.deleteNextApproval(appCancelEntity.getBussinessId());

            AppFlowEntity appFlowEntity = new AppFlowEntity();
            appFlowEntity.setFlowId(StringUtils.getUUID());
            appFlowEntity.setCompanyId(appCancelEntity.getCompanyId());
            appFlowEntity.setBussinessId(appCancelEntity.getBussinessId());
            appFlowEntity.setFlowUserId(appCancelEntity.getInitiatorId().toString());
            appFlowEntity.setFlowState(Integer.parseInt(WorkFlowConstants.TASK_CANCEL));
            appFlowEntity.setFlowTime(DateUtils.getCurrentDateTime());
            appFlowService.insertSelective(appFlowEntity);
        }
        return rtn;
    }
}
