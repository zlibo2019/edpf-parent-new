package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.VisThingEntity;
import com.weds.edwx.service.VisThingService;

/**
 * @Author sxm
 * @Description VisThing管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visThing")
@Api(value = "VisThing管理", description = "VisThing管理")
public class VisThingController extends BaseController {
    @Autowired
    private VisThingService visThingService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisThing信息", notes = "新增VisThing信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisThingEntity record) {
        visThingService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisThing信息", notes = "更新VisThing信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisThingEntity record) {
        visThingService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisThing清单", notes = "查询VisThing清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisThingEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisThingEntity> record) {
        setPageHelper(record);
        VisThingEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisThingEntity();
        }
        List<VisThingEntity> list = visThingService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisThingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisThing列表", notes = "查询VisThing列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisThingEntity>> selectListByEntity(@RequestBody VisThingEntity record) {
        List<VisThingEntity> list = visThingService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisThing信息", notes = "删除VisThing信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visThingService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisThing信息", notes = "查询VisThing信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisThingEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisThingEntity entity = visThingService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisThing信息", notes = "关键字查询VisThing信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisThingEntity>> selectListByKeys(@RequestBody BasePageSearch<VisThingEntity> record) {
        setPageHelper(record);
        List<VisThingEntity> list = visThingService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisThingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisThing信息", notes = "批量删除VisThing信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisThingEntity> list = JSONObject.parseArray(keys, VisThingEntity.class);
        // visThingService.deleteBatchByKeys(list);
        for (VisThingEntity entity : list) {
            visThingService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }
}