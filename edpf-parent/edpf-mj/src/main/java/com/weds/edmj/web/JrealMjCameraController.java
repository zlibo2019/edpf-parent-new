package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.jwt.JwtUtils;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.MjLogRealEntity;
import com.weds.edmj.service.MjLogRealService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.JrealMjCameraEntity;
import com.weds.edmj.service.JrealMjCameraService;

/**
 * @Author sxm
 * @Description JrealMjCamera管理
 * @Date 2019-07-31
 */
@RestController
@RequestMapping(value = "/jrealMjCamera")
@Api(value = "JrealMjCamera管理", description = "JrealMjCamera管理")
public class JrealMjCameraController extends BaseController {
    @Autowired
    private JrealMjCameraService jrealMjCameraService;

    @Autowired
    private DicFmtBean fmtBean;

    @Autowired
    private MjLogRealService mjLogRealService;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增摄像头信息", notes = "新增摄像头信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid JrealMjCameraEntity record) {
        jrealMjCameraService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询摄像头列表", notes = "查询摄像头列表")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JrealMjCameraEntity>> selectListPageByEntity(@RequestBody BasePageSearch<JrealMjCameraEntity> record) {
        setPageHelper(record);
        JrealMjCameraEntity entity = record.getSearch();
        if (entity == null) {
            entity = new JrealMjCameraEntity();
        }
        List<JrealMjCameraEntity> list = jrealMjCameraService.selectListByEntity(entity);
        fmtBean.DicFormat(list.toArray(new JrealMjCameraEntity[0]), new String[]{"04008", "04009", "01001"});
        return succMsgData(new BaseCommPager<JrealMjCameraEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody JrealMjCameraEntity record) {
        List<JrealMjCameraEntity> list = jrealMjCameraService.selectListByEntity(record);
        fmtBean.DicFormat(list.toArray(new JrealMjCameraEntity[0]), new String[]{"04008", "04009", "01001"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "删除摄像头信息", notes = "删除摄像头信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer jid) {
        jrealMjCameraService.deleteByPrimaryKey(jid);
        return succMsg();
    }


    @Logs
    @ApiOperation(value = "批量删除摄像头信息", notes = "批量删除摄像头信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<JrealMjCameraEntity> list = JSONObject.parseArray(keys, JrealMjCameraEntity.class);
        List<JrealMjCameraEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                jrealMjCameraService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        //更新摄像头列表
        jrealMjCameraService.insertNowCmdNetCam();
        //插入日志
        MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
        mjLogRealEntity.setLx(2);
        mjLogRealEntity.setLogType(17);
        mjLogRealEntity.setLogState(0);
        mjLogRealEntity.setLogBz("批量删除摄像头信息");
        mjLogRealEntity.setLogSj(new Date());
        mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
        mjLogRealEntity.setLogIp(request.getRemoteAddr());
        mjLogRealService.insertSelective(mjLogRealEntity);
        return succMsg();
    }
}