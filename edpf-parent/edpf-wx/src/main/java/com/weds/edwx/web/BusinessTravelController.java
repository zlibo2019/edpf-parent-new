package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.constants.CoreConstants;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.ApprovalParamEntity;
import com.weds.edwx.entity.BusinessParamEntity;
import com.weds.edwx.entity.DeleteRecordParamEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.service.BusinessTravelService;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.service.ManagementService;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/businessTravel")
@Api(value = "出差管理",description = "出差管理")
public class BusinessTravelController extends BaseController {

    @Autowired
    private BusinessTravelService businessTravelService;

    @Autowired
    private ManagementService managementService;



    @Logs
    @ApiOperation(value = "录入出差申请" , notes = "录入出差申请")
    @RequestMapping(value = "/insertBusinessTravel",method = RequestMethod.POST)
    public JsonResult<Object> insertBusinessTravel(@RequestBody BusinessParamEntity businessParamEntity) {
        String approval = businessParamEntity.getApprover();
        if (approval != null && !approval.equals("")) {
            String [] arry = approval.split(",");
            if (arry.length > 10) {
                return message("603","自定义审批人不能超过十人",null);
            }
        }

        Map<String,Object> map = null;
        Map<String,String> repMap = new LinkedHashMap<String, String>();
        try {
            map = businessTravelService.insertBusinessTravel(businessParamEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg("操作失败");
        }
        if (map.get("code").equals("1")){
            repMap.put("xh",map.get("xh").toString());
            return succMsgData(repMap);
        }
        if (map.get("code").equals("2")){
            // 新增失败,返回businessKey,以及自定义审批ID,作为二次请求的参数.
            repMap.put("xh",map.get("xh").toString());
            repMap.put("processId",map.get("processId").toString());
            return message("602","没有预设流程,请选择自定义审批人.",repMap);
        }
        if (map.get("code").equals("3")){
            return failMsg(map.get("msg").toString());
        }
        if (map.get("code").equals("5")){
            return failMsg("预借金额参数过长");
        }
        if (map.get("code").equals("6")){
            return failMsg("入住天数参数过长");
        }
        return failMsg("当前时间段内已经存在请假或加班记录");
    }

    @Logs
    @ApiOperation(value = "查看人员出差记录详情" , notes = "查看人员出差记录详情")
    @RequestMapping(value = "/selectUserBusiness",method = RequestMethod.POST)
    public JsonResult<Map<String,Object>> selectUserBusiness(@RequestBody BusinessParamEntity businessParamEntity){
        Map<String,Object> map = null;
        try {
            map = businessTravelService.selectUserBusiness(businessParamEntity);
        } catch (Exception e) {
            //e.printStackTrace();
            return message("-1","操作失败",null);
        }
        if (map.size() == 0){
            return failMsg("记录序号错误或记录不存在",map);
        } else {
            return succMsgData(map);
        }

    }

    @Logs
    @ApiOperation(value = "撤销出差申请",notes = "撤销出差申请")
    @RequestMapping(value = "/deleteBusiness",method = RequestMethod.DELETE)
    @ApiImplicitParams({@ApiImplicitParam(name = "reason",paramType = "query")})
    public JsonResult deleteBusiness(@RequestParam String userSerial,
                                     @RequestParam String xh,
                                     @RequestParam(required = false, defaultValue = "") String reason)
    {
        try {
            JsonResult responEntity = businessTravelService.deleteBusiness(userSerial,xh,reason);
            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
                return succMsg();
            } else {
                return failMsg(responEntity.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }

    }

    @Logs
    @ApiOperation(value = "审核出差申请",notes = "审核出差申请")
    @RequestMapping(value = "/approvalBusiness",method = RequestMethod.POST)
    public JsonResult approvalBusiness(@RequestBody ApprovalParamEntity approvalParamEntity) {

        try {
            JsonResult responEntity = businessTravelService.approvalBusiness(approvalParamEntity);
            if (!CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode()) && !WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){
                return failMsg(responEntity.getMsg());
            } else {
                return succMsg();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }

    }
}
