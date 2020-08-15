package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.edwx.entity.ManagementEntity;
import com.weds.edwx.service.ManagementService;
import com.weds.core.resp.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/management")
@Api(value = "获取相关人员", description = "获取相关人员")
public class ManagementController extends BaseController {

    @Autowired
    private ManagementService managementService;

    @Logs
    @ApiOperation(value = "获取自定义审批人", notes = "获取自定义审批人")
    @RequestMapping(value = "/selectApprovalUser", method = RequestMethod.POST)
    public JsonResult<List<ManagementEntity>> selectApprovalUser(@RequestBody Map<String, String> map) {
        String userSerial = map.get("userSerial");
        List<ManagementEntity> list = new ArrayList<ManagementEntity>();
        String num = managementService.findUserApproval(userSerial);
        if (num != null && !num.equals("") && num.equals("0")) {
            list = managementService.selectApprovalUser(userSerial);
            return succMsgData(list);
        } else {
            return failMsg("暂无自定义审批人", list);
        }
    }

    @Logs
    @ApiOperation(value = "获取抄送人员", notes = "获取抄送人员")
    @RequestMapping(value = "/selectCopyUser", method = RequestMethod.POST)
    public JsonResult<List<ManagementEntity>> selectCopyUser(@RequestBody Map<String, String> map) {
        String lx = map.get("lx");
        long userSerial = Long.parseLong(map.get("userSerial"));
        List<ManagementEntity> list = new ArrayList<ManagementEntity>();
        int num = managementService.findCopyUser(lx, userSerial);
        if (num != 0) {
            list = managementService.selectCopyUser(lx, userSerial);
            return succMsgData(list);
        } else {
            return failMsg("暂无默认抄送人员,请去后台设置", list);
        }
    }

    @Logs
    @ApiOperation(value = "获取同行人员", notes = "获取同行人员")
    @RequestMapping(value = "/getTravelPeople", method = RequestMethod.POST)
    public JsonResult<List<ManagementEntity>> getTravelPeople(@RequestBody Map<String, String> map) {
        String userSerial = map.get("userSerial");
        List<ManagementEntity> list = managementService.getTravelPeople(userSerial);
        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("暂无同行人员", list);
        }
    }


    @Logs
    @ApiOperation(value = "上传照片", notes = "上传照片")
    @RequestMapping(value = "/insertPhoto", method = RequestMethod.POST)
    public JsonResult<String[]> insertPhoto(String base64String) {
        try {
            if (base64String != null) {
                String[] img = base64String.split(",");
                String[] imgPath = managementService.insertPhoto(img);
                return succMsgData(imgPath);
            } else {
                return failMsg("图片为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1", "操作失败", null);
        }
    }


    @Logs
    @ApiOperation(value = "删除照片", notes = "删除照片")
    @RequestMapping(value = "/deletePhoto", method = RequestMethod.DELETE)
    public JsonResult deletePhoto(@RequestParam String imgPath) {
        try {
            boolean boo = managementService.deletePhoto(imgPath);
            if (boo) {
                return succMsg();
            } else {
                return failMsg("图片删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return message("-1", "操作失败", null);
        }
    }
}
