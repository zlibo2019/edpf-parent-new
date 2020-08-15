package com.weds.edwx.web;

import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.DoorfxRealService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;

import com.weds.core.resp.JsonResult;
import com.weds.edwx.service.MjMobileService;

import javax.annotation.Resource;

/**
 * @Author sxm
 * @Description 门禁管理
 * @Date 2018-12-22
 */
@RestController
@RequestMapping(value = "/mjMobile")
@Api(value = "门禁管理", description = "门禁管理")
public class MjMobileController extends BaseController {
    @Autowired
    private MjMobileService mjMobileService;

    @Autowired
    private DoorfxRealService doorfxRealService;

    @Resource
    private ScmParams scmParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "点击开门", notes = "点击开门")
    @RequestMapping(value = "/openDoor", method = RequestMethod.POST)
    public JsonResult<Object> insert(@RequestBody MjMobileEntity record) {
        //查询开门权限
        int doorFlg = mjMobileService.selectDoorFlg(record);
        if (doorFlg == 0) {
            return failMsg("您没有开此门的权限，请联系管理员设置");
        }
        //查询开门需要的参数
        DoorfxRealEntity doorfxRealEntity = doorfxRealService.selectByPrimaryKey(record.getGateBh());
        if (doorfxRealEntity == null) {
            return failMsg("您要开的门不存在，请刷新后再试");
        }
        int doorResult = mjMobileService.openDoor(doorfxRealEntity);
        if (doorResult == 0) {
            return failMsg("您要开的门不存在，请刷新后重试");
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
        record.setSj(new Date());
        record.setLx(openState);
        mjMobileService.insertLog(record);
        if (openState == 3) {
            return succMsg("开门成功");
        }
        if (openState == 7) {
            return failMsg("开门失败,不在线等");
        }
        return failMsg("开门失败，开门指令未执行");

    }

    @Logs
    @ApiOperation(value = "更改门顺序", notes = "更改门顺序")
    @RequestMapping(value = "/updateGateOrder", method = RequestMethod.POST)
    public JsonResult<Object> updateGateListOrder(@RequestBody DoorInfoEntity record) {
        int updateCount = mjMobileService.updateGateListOrder(record);
        if (updateCount == 0) {
            return failMsg("修改失败，请稍后重试");
        }
        return succMsg();
    }


    @Logs
    @ApiOperation(value = "查询门列表", notes = "查询门列表")
    @RequestMapping(value = "/selectDoorList", method = RequestMethod.POST)
    public JsonResult<List<MjMobileEntity>> selectDoorList(@RequestBody MjMobileEntity record) {
        List<MjMobileEntity> list = mjMobileService.selectDoorList(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "获取门禁记录", notes = "获取门禁记录")
    @RequestMapping(value = "/getMjInfo", method = RequestMethod.GET)
    public JsonResult<Object> getMjInfo(@RequestParam Integer xh) {
        //定位考勤页面，只能获取微信端的打卡记录，其他记录不可见
        MjJlRealEntity mjJlRealEntity = mjMobileService.selectMjRecord(xh);
        if (mjJlRealEntity != null) {
            String sj = DateUtils.formatDate(mjJlRealEntity.getJlSj(), "yyyy-MM-dd");
            String path = scmParams.getRootPath() + File.separator + scmParams.getAttencePath() + File.separator
                    + mjJlRealEntity.getDevSerial() + File.separator + sj + File.separator
                    + "jk" + String.format("%06d", mjJlRealEntity.getJframeId()) + ".jpg";
            try {
                mjJlRealEntity.setImage(ImageUtils.imgToBase64(path));
            } catch (Exception e) {
                return failMsg();
            }
            return succMsgData(mjJlRealEntity);
        } else {
            return failMsg("暂无数据");
        }
    }
}