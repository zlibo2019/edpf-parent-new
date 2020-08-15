package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.constants.CoreConstants;
import com.weds.edwx.entity.ApprovalParamEntity;
import com.weds.edwx.entity.DeleteRecordParamEntity;
import com.weds.edwx.entity.OutParamEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.service.OutService;
import com.weds.core.resp.JsonResult;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/out")
@Api(value = "外出管理",description = "外出管理")
public class OutController extends BaseController {

    @Autowired
    private OutService outService;

    @Logs
    @ApiOperation(value = "新增外出记录",notes = "新增外出记录")
    @RequestMapping(value = "/insertOut",method = RequestMethod.POST)
    public JsonResult insertOut(@RequestBody OutParamEntity outParamEntity)
    {
        String approval = outParamEntity.getApprover();
        if (approval != null && !approval.equals("")) {
            String [] arry = approval.split(",");
            if (arry.length > 10) {
                return message("603","自定义审批人不能超过十人",null);
            }
        }
        Map<String,Object> map = null;
        Map<String,String> repMap = new LinkedHashMap<String, String>();
        try {
            map = outService.insertOut(outParamEntity);
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
        return failMsg("当前时间段内已经存在请假或加班记录");
    }

    @Logs
    @ApiOperation(value = "查找外出申请详情",notes = "查找外出申请详情")
    @RequestMapping(value = "/selectOutByXh",method = RequestMethod.POST)
    public JsonResult<Map<String,Object>> selectOutByXh(@RequestBody OutParamEntity outParamEntity){
        Map<String,Object> map = null;
        try {
            map = outService.selectOutByXh(outParamEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1","操作失败",null);
        }
        if (map.size() == 0){
            return failMsg("记录序号错误或者记录不存在",map);
        } else {
            return succMsgData(map);
        }

    }

    @Logs
    @ApiOperation(value = "撤销外出申请",notes = "撤销外出申请")
    @RequestMapping(value = "/deleteOut",method = RequestMethod.DELETE)
    @ApiImplicitParams({@ApiImplicitParam(name = "reason",paramType = "query")})
    public JsonResult deleteOut(@RequestParam String userSerial,
                                @RequestParam String xh,
                                @RequestParam(required = false,defaultValue = "") String reason) {
        try {
            JsonResult responEntity  = outService.deleteOut(userSerial,xh,reason);
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
    @ApiOperation(value = "审核外出申请",notes = "审核外出申请")
    @RequestMapping(value = "/approvalOut",method = RequestMethod.POST)
    public JsonResult approvalOut(@RequestBody ApprovalParamEntity approvalParamEntity) {
        try {
            JsonResult responEntity = outService.approvalOut(approvalParamEntity);
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
