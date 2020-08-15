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


import com.weds.edwx.entity.VisFailEntity;
import com.weds.edwx.service.VisFailService;

/**
 * @Author sxm
 * @Description VisFail管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visFail")
@Api(value = "VisFail管理", description = "VisFail管理")
public class VisFailController extends BaseController {
    @Autowired
    private VisFailService visFailService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisFail信息", notes = "新增VisFail信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisFailEntity record) {
        visFailService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisFail信息", notes = "更新VisFail信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisFailEntity record) {
        visFailService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisFail清单", notes = "查询VisFail清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisFailEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisFailEntity> record) {
        setPageHelper(record);
        VisFailEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisFailEntity();
        }
        List<VisFailEntity> list = visFailService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisFailEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisFail列表", notes = "查询VisFail列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisFailEntity>> selectListByEntity(@RequestBody VisFailEntity record) {
        List<VisFailEntity> list = visFailService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisFail信息", notes = "删除VisFail信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visFailService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisFail信息", notes = "查询VisFail信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisFailEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisFailEntity entity = visFailService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisFail信息", notes = "关键字查询VisFail信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisFailEntity>> selectListByKeys(@RequestBody BasePageSearch<VisFailEntity> record) {
        setPageHelper(record);
        List<VisFailEntity> list = visFailService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisFailEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisFail信息", notes = "批量删除VisFail信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisFailEntity> list = JSONObject.parseArray(keys, VisFailEntity.class);
        // visFailService.deleteBatchByKeys(list);
        for (VisFailEntity entity : list) {
            visFailService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }
}