package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.MjLogRealEntity;
import com.weds.edmj.service.MjLogRealService;

/**
 * @Author sxm
 * @Description MjLogReal管理
 * @Date 2019-08-01
 */
@RestController
@RequestMapping(value = "/mjLogReal")
@Api(value = "MjLogReal管理", description = "MjLogReal管理")
public class MjLogRealController extends BaseController {
    @Autowired
    private MjLogRealService mjLogRealService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MjLogReal信息", notes = "新增MjLogReal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MjLogRealEntity record) {
        mjLogRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MjLogReal信息", notes = "更新MjLogReal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MjLogRealEntity record) {
        mjLogRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjLogReal清单", notes = "查询MjLogReal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjLogRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjLogRealEntity> record) {
        setPageHelper(record);
        MjLogRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjLogRealEntity();
        }
        List<MjLogRealEntity> list = mjLogRealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MjLogRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询MjLogReal列表", notes = "查询MjLogReal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MjLogRealEntity>> selectListByEntity(@RequestBody MjLogRealEntity record) {
        List<MjLogRealEntity> list = mjLogRealService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MjLogReal信息", notes = "删除MjLogReal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        mjLogRealService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjLogReal信息", notes = "查询MjLogReal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MjLogRealEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        MjLogRealEntity entity = mjLogRealService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询MjLogReal信息", notes = "关键字查询MjLogReal信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjLogRealEntity>> selectListByKeys(@RequestBody BasePageSearch<MjLogRealEntity> record) {
        setPageHelper(record);
        List<MjLogRealEntity> list = mjLogRealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MjLogRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除MjLogReal信息", notes = "批量删除MjLogReal信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MjLogRealEntity> list = JSONObject.parseArray(keys, MjLogRealEntity.class);
        List<MjLogRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                mjLogRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增MjLogReal信息", notes = "批量新增MjLogReal信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MjLogRealEntity> list = JSONObject.parseArray(data, MjLogRealEntity.class);
        mjLogRealService.insertBatch(list);
        return succMsg();
    }
}