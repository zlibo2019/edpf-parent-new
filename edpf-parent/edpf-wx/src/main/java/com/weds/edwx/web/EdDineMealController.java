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


import com.weds.edwx.entity.EdDineMealEntity;
import com.weds.edwx.service.EdDineMealService;

/**
 * @Author sxm
 * @Description 餐别定义管理
 * @Date 2019-04-16
 */
@RestController
@RequestMapping(value = "/edDineMeal")
@Api(value = "餐别定义管理", description = "餐别定义管理")
public class EdDineMealController extends BaseController {
    @Autowired
    private EdDineMealService edDineMealService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增餐别定义信息", notes = "新增餐别定义信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineMealEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineMealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新餐别定义信息", notes = "更新餐别定义信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineMealEntity record) {
        record.setLtDate(new Date());
        edDineMealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询餐别定义清单", notes = "查询餐别定义清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineMealEntity> record) {
        setPageHelper(record);
        EdDineMealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineMealEntity();
        }
        List<EdDineMealEntity> list = edDineMealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineMealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询餐别定义列表", notes = "查询餐别定义列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineMealEntity>> selectListByEntity(@RequestBody EdDineMealEntity record) {
        List<EdDineMealEntity> list = edDineMealService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除餐别定义信息", notes = "删除餐别定义信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String mealId) {
        edDineMealService.deleteByPrimaryKey(mealId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询餐别定义信息", notes = "查询餐别定义信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineMealEntity> selectByPrimaryKey(@RequestParam String mealId) {
        EdDineMealEntity entity = edDineMealService.selectByPrimaryKey(mealId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询餐别定义信息", notes = "关键字查询餐别定义信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMealEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineMealEntity> record) {
        setPageHelper(record);
        List<EdDineMealEntity> list = edDineMealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineMealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除餐别定义信息", notes = "批量删除餐别定义信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineMealEntity> list = JSONObject.parseArray(keys, EdDineMealEntity.class);
        List<EdDineMealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineMealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}