package com.weds.edwx.web;

import com.weds.core.constants.CoreConstants;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.DeviceService;
import com.weds.edwx.service.MjMobileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Date;
import java.util.Map;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;

import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.service.KtJlService;

/**
 * @Author sxm
 * @Description KtJl管理
 * @Date 2018-12-27
 */
@RestController
@RequestMapping(value = "/ktJl")
@Api(value = "KtJl管理", description = "KtJl管理")
public class KtJlController extends BaseController {
    @Autowired
    private KtJlService ktJlService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private MjMobileService mjMobileService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "处理扫码信息", notes = "处理扫码信息")
    @RequestMapping(value = "/scanResult", method = RequestMethod.POST)
    public JsonResult<Object> insert(@RequestBody WxConfigEntity record) {
        //先调二维码中台服务，进行解密
        Map<String,Object> map= ktJlService.decodingStr(record.getCodeStr());
        JsonResult<Map> jsonResult = (JsonResult) map.get("jsonResult");
        if (CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) { //中控服务验证成功
            //验证权限
            Map<String,Object> mapData = jsonResult.getData();
            if ("0".equals(map.get("codeType").toString())) {//走考勤验证
                KtJlEntity ktJlEntity = new KtJlEntity();
                DeviceEntity deviceEntity = deviceService.selectByDevsbid(mapData.get("DevSID").toString());
                if (deviceEntity == null) {
                    return failMsg("设备不存在或已经被删除");
                }
                ktJlEntity.setDevSerial(deviceEntity.getBh());
                ktJlEntity.setSj(new Date());
                ktJlEntity.setUserSerial(record.getUserSerial().intValue());
                //如果无场所白名单
                if (ktJlService.selectDepUser(deviceEntity) == 0 && ktJlService.selectDepPlace(deviceEntity) == 0) {
                    ktJlService.insert(ktJlEntity);//插入考勤记录
                    //插入操作日志
                    //插入推送消息
                    return succMsg("考勤成功");
                }
                deviceEntity.setUserSerial(record.getUserSerial());

                //如果有场所白名单或者部门白名单
                if (ktJlService.selectDepPlaceByUserSerial(deviceEntity) > 0 || ktJlService.selectDepUserByUserSerial(deviceEntity) > 0) {
                    ktJlService.insert(ktJlEntity);//插入考勤记录
                    //插入操作日志
                    //插入推送消息
                    return succMsg("考勤成功");
                }
                return failMsg("非授权人员");
            }
            if ("1".equals(map.get("codeType").toString())) { //走门禁开门验证
                String codeInfo = mapData.get("dataStr").toString();
                String[] codeArr = codeInfo.split(","); //分割字符串
                if (codeArr.length > 2) {
                    String[] codeStrs = codeArr[0].split(":"); //分割字符串
                    //userSerial, devSid,devOrder,devLb
                    DoorfxRealEntity doorfxRealEntity = mjMobileService.selectDoorFlgByDevSerial(record.getUserSerial(), codeStrs[4],
                            Integer.parseInt(codeArr[2]), Integer.parseInt(codeStrs[1]));
                    if (doorfxRealEntity == null) {
                        return failMsg("您没有该门的授权");
                    }

                    int doorResult = mjMobileService.openDoor(doorfxRealEntity);
                    if (doorResult == 0) {
                        return failMsg("该门不存在，请联系管理员");
                    }
                    int jcmdsig = doorfxRealEntity.getXh();
                    int openState = 3; //定义开门状态为成功
                    //查询本次开门状态
                    for (int i = 0; i < 3; i++) {
                        openState = mjMobileService.getOpenState(jcmdsig);
                        if (openState == 3 || openState == 7) { // 3 成功 7 失败
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return failMsg("开门失败");
                        }
                    }
                    MjMobileEntity mjMobileEntity = new MjMobileEntity();
                    mjMobileEntity.setGateBh(doorfxRealEntity.getGateBh());
                    mjMobileEntity.setUserSerial(record.getUserSerial());
                    mjMobileEntity.setSj(new Date());
                    mjMobileEntity.setLx(openState);
                    mjMobileService.insertLog(mjMobileEntity);
                    if (openState == 3) {
                        return succMsg("开门成功");
                    }
                    if (openState == 7) {
                        return failMsg("开门失败,不在线等");
                    }
                    return failMsg("开门失败，开门指令未执行");
                }
                return failMsg("二维码非法");
            }
        }
        return failMsg(jsonResult.getMsg());
    }
}