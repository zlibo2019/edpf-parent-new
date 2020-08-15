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


import com.weds.edmj.entity.MjSdRuleRealEntity;
import com.weds.edmj.service.MjSdRuleRealService;

/**
 * @Author sxm
 * @Description MjSdRuleReal管理
 * @Date 2019-07-25
 */
@RestController
@RequestMapping(value = "/mjSdRuleReal")
@Api(value = "MjSdRuleReal管理", description = "MjSdRuleReal管理")
public class MjSdRuleRealController extends BaseController {
    @Autowired
    private MjSdRuleRealService mjSdRuleRealService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MjSdRuleReal信息", notes = "新增MjSdRuleReal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MjSdRuleRealEntity record) {
        mjSdRuleRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MjSdRuleReal信息", notes = "更新MjSdRuleReal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MjSdRuleRealEntity record) {
        mjSdRuleRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjSdRuleReal清单", notes = "查询MjSdRuleReal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjSdRuleRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjSdRuleRealEntity> record) {
        setPageHelper(record);
        MjSdRuleRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjSdRuleRealEntity();
        }
        List<MjSdRuleRealEntity> list = mjSdRuleRealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MjSdRuleRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询MjSdRuleReal列表", notes = "查询MjSdRuleReal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MjSdRuleRealEntity>> selectListByEntity(@RequestBody MjSdRuleRealEntity record) {
        List<MjSdRuleRealEntity> list = mjSdRuleRealService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MjSdRuleReal信息", notes = "删除MjSdRuleReal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        mjSdRuleRealService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjSdRuleReal信息", notes = "查询MjSdRuleReal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MjSdRuleRealEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        MjSdRuleRealEntity entity = mjSdRuleRealService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询MjSdRuleReal信息", notes = "关键字查询MjSdRuleReal信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjSdRuleRealEntity>> selectListByKeys(@RequestBody BasePageSearch<MjSdRuleRealEntity> record) {
        setPageHelper(record);
        List<MjSdRuleRealEntity> list = mjSdRuleRealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MjSdRuleRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除MjSdRuleReal信息", notes = "批量删除MjSdRuleReal信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MjSdRuleRealEntity> list = JSONObject.parseArray(keys, MjSdRuleRealEntity.class);
        List<MjSdRuleRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                mjSdRuleRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增MjSdRuleReal信息", notes = "批量新增MjSdRuleReal信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MjSdRuleRealEntity> list = JSONObject.parseArray(data, MjSdRuleRealEntity.class);
        mjSdRuleRealService.insertBatch(list);
        return succMsg();
    }
}