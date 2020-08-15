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


import com.weds.edwx.entity.VisJlAllEntity;
import com.weds.edwx.service.VisJlAllService;

/**
 * @Author sxm
 * @Description VisJlAll管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visJlAll")
@Api(value = "VisJlAll管理", description = "VisJlAll管理")
public class VisJlAllController extends BaseController {
    @Autowired
    private VisJlAllService visJlAllService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisJlAll信息", notes = "新增VisJlAll信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisJlAllEntity record) {
        visJlAllService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisJlAll信息", notes = "更新VisJlAll信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisJlAllEntity record) {
        visJlAllService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisJlAll清单", notes = "查询VisJlAll清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisJlAllEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisJlAllEntity> record) {
        setPageHelper(record);
        VisJlAllEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisJlAllEntity();
        }
        List<VisJlAllEntity> list = visJlAllService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisJlAllEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisJlAll列表", notes = "查询VisJlAll列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisJlAllEntity>> selectListByEntity(@RequestBody VisJlAllEntity record) {
        List<VisJlAllEntity> list = visJlAllService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisJlAll信息", notes = "删除VisJlAll信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long xh) {
        visJlAllService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisJlAll信息", notes = "查询VisJlAll信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisJlAllEntity> selectByPrimaryKey(@RequestParam Long xh) {
        VisJlAllEntity entity = visJlAllService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisJlAll信息", notes = "关键字查询VisJlAll信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisJlAllEntity>> selectListByKeys(@RequestBody BasePageSearch<VisJlAllEntity> record) {
        setPageHelper(record);
        List<VisJlAllEntity> list = visJlAllService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisJlAllEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisJlAll信息", notes = "批量删除VisJlAll信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisJlAllEntity> list = JSONObject.parseArray(keys, VisJlAllEntity.class);
        // visJlAllService.deleteBatchByKeys(list);
        for (VisJlAllEntity entity : list) {
            visJlAllService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }
}