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


import com.weds.edwx.entity.VisBlackNewEntity;
import com.weds.edwx.service.VisBlackNewService;

/**
 * @Author sxm
 * @Description VisBlackNew管理
 * @Date 2019-05-21
 */
@RestController
@RequestMapping(value = "/visBlackNew")
@Api(value = "VisBlackNew管理", description = "VisBlackNew管理")
public class VisBlackNewController extends BaseController {
    @Autowired
    private VisBlackNewService visBlackNewService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisBlackNew信息", notes = "新增VisBlackNew信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid VisBlackNewEntity record) {
        visBlackNewService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisBlackNew信息", notes = "更新VisBlackNew信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid VisBlackNewEntity record) {
        visBlackNewService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisBlackNew清单", notes = "查询VisBlackNew清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisBlackNewEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisBlackNewEntity> record) {
        setPageHelper(record);
        VisBlackNewEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisBlackNewEntity();
        }
        List<VisBlackNewEntity> list = visBlackNewService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisBlackNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisBlackNew列表", notes = "查询VisBlackNew列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisBlackNewEntity>> selectListByEntity(@RequestBody VisBlackNewEntity record) {
        List<VisBlackNewEntity> list = visBlackNewService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisBlackNew信息", notes = "删除VisBlackNew信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String visNo) {
        visBlackNewService.deleteByPrimaryKey(visNo);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisBlackNew信息", notes = "查询VisBlackNew信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisBlackNewEntity> selectByPrimaryKey(@RequestParam String visNo) {
        VisBlackNewEntity entity = visBlackNewService.selectByPrimaryKey(visNo);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisBlackNew信息", notes = "关键字查询VisBlackNew信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisBlackNewEntity>> selectListByKeys(@RequestBody BasePageSearch<VisBlackNewEntity> record) {
        setPageHelper(record);
        List<VisBlackNewEntity> list = visBlackNewService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisBlackNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisBlackNew信息", notes = "批量删除VisBlackNew信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisBlackNewEntity> list = JSONObject.parseArray(keys, VisBlackNewEntity.class);
        List<VisBlackNewEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visBlackNewService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}