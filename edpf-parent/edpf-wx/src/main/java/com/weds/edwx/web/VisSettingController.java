package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.VisSettingEntity;
import com.weds.edwx.service.VisSettingService;

/**
 * @Author sxm
 * @Description VisSetting管理
 * @Date 2019-07-04
 */
@RestController
@RequestMapping(value = "/visSetting")
@Api(value = "VisSetting管理", description = "VisSetting管理")
public class VisSettingController extends BaseController {
    @Autowired
    private VisSettingService visSettingService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisSetting信息", notes = "新增VisSetting信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid VisSettingEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        visSettingService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisSetting信息", notes = "更新VisSetting信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid VisSettingEntity record) {
        record.setLtDate(new Date());
        visSettingService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisSetting清单", notes = "查询VisSetting清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisSettingEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisSettingEntity> record) {
        setPageHelper(record);
        VisSettingEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisSettingEntity();
        }
        List<VisSettingEntity> list = visSettingService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisSetting列表", notes = "查询VisSetting列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisSettingEntity>> selectListByEntity(@RequestBody VisSettingEntity record) {
        List<VisSettingEntity> list = visSettingService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisSetting信息", notes = "删除VisSetting信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String id) {
        visSettingService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisSetting信息", notes = "查询VisSetting信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisSettingEntity> selectByPrimaryKey(@RequestParam String id) {
        VisSettingEntity entity = visSettingService.selectByPrimaryKey(id);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisSetting信息", notes = "关键字查询VisSetting信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisSettingEntity>> selectListByKeys(@RequestBody BasePageSearch<VisSettingEntity> record) {
        setPageHelper(record);
        List<VisSettingEntity> list = visSettingService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisSetting信息", notes = "批量删除VisSetting信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisSettingEntity> list = JSONObject.parseArray(keys, VisSettingEntity.class);
        List<VisSettingEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visSettingService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增VisSetting信息", notes = "批量新增VisSetting信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<VisSettingEntity> list = JSONObject.parseArray(data, VisSettingEntity.class);
        visSettingService.insertBatch(list);
        return succMsg();
    }
}