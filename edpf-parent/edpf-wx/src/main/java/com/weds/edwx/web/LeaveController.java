package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.constants.CoreConstants;
import com.weds.edpf.core.constant.CustomParams;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.LeaveService;
import com.weds.core.resp.JsonResult;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value = "/leave")
@Api(value = "请假管理",description = "请假管理")
public class LeaveController extends BaseController {

    @Autowired
    private LeaveService leaveService;

    @Resource
    private CustomParams customParams;

    @Logs
    @ApiOperation(value = "查找请假记录详情",notes = "查找请假记录详情")
    @RequestMapping(value = "/selectLeaveByXh",method = RequestMethod.POST)
    public JsonResult<Map<String,Object>> selectLeaveByXh(@RequestBody LeaveParamEntity leaveParamEntity){
        Map<String,Object> map = null;
        try {
            map = leaveService.selectLeaveByXh(leaveParamEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }
        if (map.size() == 0){
            return failMsg("记录序号错误或记录不存在",map);
        }else{
            return succMsgData(map);
        }
    }

    @Logs
    @ApiOperation(value = "新增请假记录",notes = "新增请假记录")
    @RequestMapping(value = "/insertLeave",method = RequestMethod.POST)
    public JsonResult<Object> insertLeave(@RequestBody LeaveParamEntity leaveParamEntity) {
        String approval = leaveParamEntity.getApprover();
        if (approval != null && !approval.equals("")) {
            String [] arry = approval.split(",");
            if (arry.length > 10) {
                return message("603","自定义审批人不能超过十人",null);
            }
        }
        Map<String,Object> map = null;
        Map<String,String> repMap = new LinkedHashMap<String, String>();
        try {
            if (customParams.getLeave() > 0) {
                map = leaveService.insertLeave_dz(leaveParamEntity);
            } else {
                map = leaveService.insertLeave(leaveParamEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }
        if (map.get("code").equals("1")){
            // 新增成功,返回businessKey,用于查询记录详情
            repMap.put("xh",map.get("xh").toString());
            return succMsgData(repMap);
        }
         if (map.get("code").equals("2")){
            // 新增失败,没有预设定审批流程,返回businessKey,以及自定义审批ID,作为二次请求的参数.
            repMap.put("xh",map.get("xh").toString());
            repMap.put("processId",map.get("processId").toString());
            return message("602","没有预设流程,请选择自定义审批人.",repMap);
        }
        if (map.get("code").equals("3")){
            // 请求失败,返回错误.
            return failMsg(map.get("msg").toString());
        }
        if (map.get("code").equals("5")){
            // 请求失败,返回错误.
            return failMsg("请假时长不合法");
        }
        if (map.get("code").equals("6")){
            return failMsg("年假或调休剩余时长不足");
        }
        return failMsg("当前时间段内已经存在请假或加班记录");

    }

    @Logs
    @ApiOperation(value = "撤销请假申请",notes = "撤销请假申请")
    @RequestMapping(value = "/deleteLeave",method = RequestMethod.DELETE)
    @ApiImplicitParams({@ApiImplicitParam(name = "reason",paramType = "query")})
    public JsonResult deleteLeave(@RequestParam String userSerial,
                                  @RequestParam String xh,
                                  @RequestParam(required = false, defaultValue = "") String reason)
    {
        try {
            JsonResult responEntity =  leaveService.deleteLeave(userSerial,xh,reason);
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
    @ApiOperation(value = "审批请假记录",notes = "审批请假记录")
    @RequestMapping(value = "/approvalLeave",method = RequestMethod.POST)
    public JsonResult approvalLeave(@RequestBody ApprovalParamEntity approvalParamEntity) {
        try {
            JsonResult responEntity = leaveService.approvalLeave(approvalParamEntity);
            if (!CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode()) && !WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode()) ){
                return failMsg(responEntity.getMsg());
            } else {
                return succMsg();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }
    }


    @Logs
    @ApiOperation(value = "获取假类编号、假类名称",notes = "获取假类编号、假类名称")
    @RequestMapping(value = "/selectLeave",method = RequestMethod.POST)
    public JsonResult<List<LeaveEntity>> selectLeave(){
        return succMsgData(leaveService.selectLeave());
    }

}
