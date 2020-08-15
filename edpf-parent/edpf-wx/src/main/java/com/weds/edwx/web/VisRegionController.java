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


import com.weds.edwx.entity.VisRegionEntity;
import com.weds.edwx.service.VisRegionService;

/**
 * @Author sxm
 * @Description VisRegion管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visRegion")
@Api(value = "VisRegion管理", description = "VisRegion管理")
public class VisRegionController extends BaseController {
    @Autowired
    private VisRegionService visRegionService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisRegion信息", notes = "新增VisRegion信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisRegionEntity record) {
        visRegionService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisRegion信息", notes = "更新VisRegion信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisRegionEntity record) {
        visRegionService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisRegion清单", notes = "查询VisRegion清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegionEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisRegionEntity> record) {
        setPageHelper(record);
        VisRegionEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisRegionEntity();
        }
        List<VisRegionEntity> list = visRegionService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisRegionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisRegion列表", notes = "查询VisRegion列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisRegionEntity>> selectListByEntity(@RequestBody VisRegionEntity record) {
        List<VisRegionEntity> list = visRegionService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisRegion信息", notes = "删除VisRegion信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visRegionService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisRegion信息", notes = "查询VisRegion信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisRegionEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisRegionEntity entity = visRegionService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisRegion信息", notes = "关键字查询VisRegion信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegionEntity>> selectListByKeys(@RequestBody BasePageSearch<VisRegionEntity> record) {
        setPageHelper(record);
        List<VisRegionEntity> list = visRegionService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisRegionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisRegion信息", notes = "批量删除VisRegion信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisRegionEntity> list = JSONObject.parseArray(keys, VisRegionEntity.class);
        // visRegionService.deleteBatchByKeys(list);
        for (VisRegionEntity entity : list) {
            visRegionService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }
}