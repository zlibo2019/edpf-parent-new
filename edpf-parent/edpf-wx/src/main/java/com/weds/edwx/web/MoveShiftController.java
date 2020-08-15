package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.constants.CoreConstants;
import com.weds.edwx.entity.ApprovalParamEntity;
import com.weds.edwx.entity.DeleteRecordParamEntity;
import com.weds.edwx.entity.MoveShiftParamEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.service.MoveShiftService;
import com.weds.core.resp.JsonResult;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "/moveShift")
@Api(value = "调班管理",description = "调班管理")
public class MoveShiftController extends BaseController {

    @Autowired
    private MoveShiftService moveShiftService;

    @Logs
    @ApiOperation(value = "根据序号查找调班信息",notes = "根据序号查找调班信息")
    @RequestMapping(value = "/selectMoveShiftByXh",method = RequestMethod.POST)
    public JsonResult<Map<String,Object>> selectMoveShiftByXh(@RequestBody MoveShiftParamEntity moveShiftParamEntity){
        Map<String,Object> map = null;
        try {
            map = moveShiftService.selectMoveShiftByXh(moveShiftParamEntity);
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
    @ApiOperation(value = "新增调班记录",notes = "新增调班记录")
    @RequestMapping(value = "/insertMoveShift",method = RequestMethod.POST)
    public JsonResult<Object> insertMoveShift(@RequestBody MoveShiftParamEntity moveShiftParamEntity) {
        String approval = moveShiftParamEntity.getApprover();
        if (approval != null && !approval.equals("")) {
            String [] arry = approval.split(",");
            if (arry.length > 10) {
                return message("603","自定义审批人不能超过十人",null);
            }
        }
        Map<String,Object> map = null;
        Map<String,String> repMap = new LinkedHashMap<String, String>();
        try {
            map = moveShiftService.insertMoveShift(moveShiftParamEntity);
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
            // 新增失败,没有预设定流程,返回businessKey,以及自定义审批ID,作为二次请求的参数.
            repMap.put("xh",map.get("xh").toString());
            repMap.put("processId",map.get("processId").toString());
            return message("602","没有预设流程,请选择自定义审批人.",repMap);
        }
        if (map.get("code").equals("3")){
            // 请求失败,返回错误.
            return failMsg(map.get("msg").toString());
        }
        return failMsg("已存在调班记录");
    }

    @Logs
    @ApiOperation(value = "撤销调班申请",notes = "撤销调班申请")
    @RequestMapping(value = "/deleteMoveShift",method = RequestMethod.DELETE)
    @ApiImplicitParams({@ApiImplicitParam(name = "reason",paramType = "query")})
    public JsonResult deleteMoveShift(@RequestParam String userSerial,
                                      @RequestParam String xh,
                                      @RequestParam(required = false,defaultValue = "") String reason)
    {
        try {
            JsonResult responEntity =  moveShiftService.deleteMoverShift(userSerial,xh,reason);
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
    @ApiOperation(value = "审核调班记录",notes = "审核调班记录")
    @RequestMapping(value = "/approvalMoveShift",method = RequestMethod.POST)
    public JsonResult approvalMoveShift(@RequestBody ApprovalParamEntity approvalParamEntity) {
        try {
            JsonResult responEntity =  moveShiftService.approvalMoveShift(approvalParamEntity);
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
    @ApiOperation(value = "获取班次",notes = "获取班次")
    @RequestMapping(value = "/getBanci",method = RequestMethod.POST)
    public JsonResult<Object> getBanci(@RequestBody MoveShiftParamEntity moveShiftParamEntity){
        Map<String,Object> map = moveShiftService.getBanci(moveShiftParamEntity);
        if (map.size() == 2) {
            return succMsgData(map);
        } else {
            return failMsg("当前日期没有排班,无法申请调班");
        }
    }

}
