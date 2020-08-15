package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.constants.CoreConstants;
import com.weds.edwx.entity.ApprovalParamEntity;
import com.weds.edwx.entity.AttendanceParamEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.service.AttendanceService;
import com.weds.core.resp.JsonResult;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/attendance")
@Api(value = "补出勤管理", description = "补出勤管理")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceService attendanceService;

    @Logs
    @ApiOperation(value = "录入补出勤申请", notes = "录入补出勤申请")
    @RequestMapping(value = "/insertAttendance", method = RequestMethod.POST)
    public JsonResult insertAttendance(@RequestBody AttendanceParamEntity attendanceParamEntity) {

        String approval = attendanceParamEntity.getApprover();
        if (approval != null && !approval.equals("")) {
            String [] arry = approval.split(",");
            if (arry.length > 10) {
                return message("603","自定义审批人不能超过十人",null);
            }
        }
        Map<String,String> map = null;
        Map<String,String> repMap = new LinkedHashMap<String, String>();
        try {
            map =attendanceService.insertAttendance(attendanceParamEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }
        if (map.get("code").equals("1")){
            // 新增成功,返回businessKey,用于查询记录详情
            repMap.put("xh",map.get("xh"));
            return succMsgData(repMap);
        }
        if (map.get("code").equals("2")){
            // 新增失败,没有预设流程,返回businessKey,以及自定义审批ID,作为二次请求的参数.
            repMap.put("xh",map.get("xh"));
            repMap.put("processId",map.get("processId"));
            return message("602","没有预设流程,请选择自定义审批人.",repMap);
        }
        if (map.get("code").equals("3")){
            // 请求失败,返回错误.
            return failMsg(map.get("msg"));
        }
        return failMsg("当前补录已提交");
    }

    @Logs
    @ApiOperation(value = "查看补出勤申请", notes = "查看补出勤申请")
    @RequestMapping(value = "/selectAttendance", method = RequestMethod.POST)
    public JsonResult<Map<String, Object>> selectAttendanceByXh(@RequestBody AttendanceParamEntity attendanceParamEntity) {
        Map<String,Object> map = null;
        try {
            map = attendanceService.selectAttendanceByXh(attendanceParamEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map.size() == 0){
            return failMsg("记录序号错误或记录不存在",map);
        }else{
            return succMsgData(map);
        }
    }

    @Logs
    @ApiOperation(value = "撤销补出勤记录", notes = "撤销补出勤记录")
    @RequestMapping(value = "/deleteAttendance", method = RequestMethod.DELETE)
    @ApiImplicitParams({@ApiImplicitParam(name = "reason",dataType = "String",paramType = "query")})
    public JsonResult deleteAttendance(@RequestParam String userSerial,
                                       @RequestParam String xh,
                                       @RequestParam(required = false,defaultValue = "") String reason)
    {
        try {
            JsonResult responEntity = attendanceService.deleteAttendance(userSerial,xh,reason);
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
    @ApiOperation(value = "审核补出勤记录", notes = "审核补出勤记录")
    @RequestMapping(value = "/approvalAttendance", method = RequestMethod.POST)
    public JsonResult approvalAttendance(@RequestBody ApprovalParamEntity approvalParamEntity) {
        try {
            JsonResult responEntity = attendanceService.approvalAttendance(approvalParamEntity);
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
