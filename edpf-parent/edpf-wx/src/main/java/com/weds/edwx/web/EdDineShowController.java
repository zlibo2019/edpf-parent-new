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
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.EdDineShowEntity;
import com.weds.edwx.service.EdDineShowService;

/**
 * @Author sxm
 * @Description 订餐说明管理
 * @Date 2019-04-30
 */
@RestController
@RequestMapping(value = "/edDineShow")
@Api(value = "订餐说明管理", description = "订餐说明管理")
public class EdDineShowController extends BaseController {
    @Autowired
    private EdDineShowService edDineShowService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增订餐说明信息", notes = "新增订餐说明信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineShowEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineShowService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新订餐说明信息", notes = "更新订餐说明信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineShowEntity record) {
        record.setLtDate(new Date());
        edDineShowService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐说明清单", notes = "查询订餐说明清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineShowEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineShowEntity> record) {
        setPageHelper(record);
        EdDineShowEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineShowEntity();
        }
        List<EdDineShowEntity> list = edDineShowService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineShowEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询订餐说明列表", notes = "查询订餐说明列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineShowEntity>> selectListByEntity(@RequestBody EdDineShowEntity record) {
        List<EdDineShowEntity> list = edDineShowService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除订餐说明信息", notes = "删除订餐说明信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String placeId) {
        edDineShowService.deleteByPrimaryKey(placeId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐说明信息", notes = "查询订餐说明信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineShowEntity> selectByPrimaryKey(@RequestParam String placeId) {
        EdDineShowEntity entity = edDineShowService.selectByPrimaryKey(placeId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询订餐说明信息", notes = "关键字查询订餐说明信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineShowEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineShowEntity> record) {
        setPageHelper(record);
        List<EdDineShowEntity> list = edDineShowService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineShowEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除订餐说明信息", notes = "批量删除订餐说明信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineShowEntity> list = JSONObject.parseArray(keys, EdDineShowEntity.class);
        List<EdDineShowEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineShowService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}