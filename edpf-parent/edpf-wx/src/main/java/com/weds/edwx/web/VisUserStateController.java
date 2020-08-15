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


import com.weds.edwx.entity.VisUserStateEntity;
import com.weds.edwx.service.VisUserStateService;

/**
 * @Author sxm
 * @Description VisUserState管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visUserState")
@Api(value = "VisUserState管理", description = "VisUserState管理")
public class VisUserStateController extends BaseController {
    @Autowired
    private VisUserStateService visUserStateService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisUserState信息", notes = "新增VisUserState信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisUserStateEntity record) {
        visUserStateService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisUserState信息", notes = "更新VisUserState信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisUserStateEntity record) {
        visUserStateService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisUserState清单", notes = "查询VisUserState清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserStateEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisUserStateEntity> record) {
        setPageHelper(record);
        VisUserStateEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisUserStateEntity();
        }
        List<VisUserStateEntity> list = visUserStateService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisUserStateEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisUserState列表", notes = "查询VisUserState列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisUserStateEntity>> selectListByEntity(@RequestBody VisUserStateEntity record) {
        List<VisUserStateEntity> list = visUserStateService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisUserState信息", notes = "删除VisUserState信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long userSerial) {
        visUserStateService.deleteByPrimaryKey(userSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisUserState信息", notes = "查询VisUserState信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisUserStateEntity> selectByPrimaryKey(@RequestParam Long userSerial) {
        VisUserStateEntity entity = visUserStateService.selectByPrimaryKey(userSerial);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisUserState信息", notes = "关键字查询VisUserState信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserStateEntity>> selectListByKeys(@RequestBody BasePageSearch<VisUserStateEntity> record) {
        setPageHelper(record);
        List<VisUserStateEntity> list = visUserStateService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisUserStateEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisUserState信息", notes = "批量删除VisUserState信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisUserStateEntity> list = JSONObject.parseArray(keys, VisUserStateEntity.class);
        // visUserStateService.deleteBatchByKeys(list);
        for (VisUserStateEntity entity : list) {
            visUserStateService.deleteByPrimaryKey(entity.getUserSerial());
        }
        return succMsg();
    }
}