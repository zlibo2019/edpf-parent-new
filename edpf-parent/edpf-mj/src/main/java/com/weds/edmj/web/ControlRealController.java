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


import com.weds.edmj.entity.ControlRealEntity;
import com.weds.edmj.service.ControlRealService;

/**
 * @Author sxm
 * @Description ControlReal管理
 * @Date 2019-07-31
 */
@RestController
@RequestMapping(value = "/controlReal")
@Api(value = "ControlReal管理", description = "ControlReal管理")
public class ControlRealController extends BaseController {
    @Autowired
    private ControlRealService controlRealService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增ControlReal信息", notes = "新增ControlReal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid ControlRealEntity record) {
        controlRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新ControlReal信息", notes = "更新ControlReal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid ControlRealEntity record) {
        controlRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }


    @Logs
    @ApiOperation(value = "删除ControlReal信息", notes = "删除ControlReal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String devSerial, @RequestParam Integer devOrder) {
        controlRealService.deleteByPrimaryKey(devSerial, devOrder);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询ControlReal信息", notes = "查询ControlReal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<ControlRealEntity> selectByPrimaryKey(@RequestParam String devSerial, @RequestParam Integer devOrder) {
        ControlRealEntity entity = controlRealService.selectByPrimaryKey(devSerial, devOrder);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询ControlReal信息", notes = "关键字查询ControlReal信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<ControlRealEntity>> selectListByKeys(@RequestBody BasePageSearch<ControlRealEntity> record) {
        setPageHelper(record);
        List<ControlRealEntity> list = controlRealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<ControlRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除ControlReal信息", notes = "批量删除ControlReal信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<ControlRealEntity> list = JSONObject.parseArray(keys, ControlRealEntity.class);
        List<ControlRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                controlRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增ControlReal信息", notes = "批量新增ControlReal信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<ControlRealEntity> list = JSONObject.parseArray(data, ControlRealEntity.class);
        controlRealService.insertBatch(list);
        return succMsg();
    }
}