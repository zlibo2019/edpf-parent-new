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


import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.service.EdDineMenuDetailService;

/**
 * @Author sxm
 * @Description 菜谱详情管理
 * @Date 2019-04-12
 */
@RestController
@RequestMapping(value = "/edDineMenuDetail")
@Api(value = "菜谱详情管理", description = "菜谱详情管理")
public class EdDineMenuDetailController extends BaseController {
    @Autowired
    private EdDineMenuDetailService edDineMenuDetailService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增菜谱详情信息", notes = "新增菜谱详情信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineMenuDetailEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        edDineMenuDetailService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新菜谱详情信息", notes = "更新菜谱详情信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineMenuDetailEntity record) {
        edDineMenuDetailService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜谱详情清单", notes = "查询菜谱详情清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMenuDetailEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineMenuDetailEntity> record) {
        setPageHelper(record);
        EdDineMenuDetailEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineMenuDetailEntity();
        }
        List<EdDineMenuDetailEntity> list = edDineMenuDetailService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineMenuDetailEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询菜谱详情列表", notes = "查询菜谱详情列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineMenuDetailEntity>> selectListByEntity(@RequestBody EdDineMenuDetailEntity record) {
        List<EdDineMenuDetailEntity> list = edDineMenuDetailService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除菜谱详情信息", notes = "删除菜谱详情信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String menuId, @RequestParam String foodId) {
        edDineMenuDetailService.deleteByPrimaryKey(menuId, foodId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜谱详情信息", notes = "查询菜谱详情信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineMenuDetailEntity> selectByPrimaryKey(@RequestParam String menuId, @RequestParam String foodId) {
        EdDineMenuDetailEntity entity = edDineMenuDetailService.selectByPrimaryKey(menuId, foodId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询菜谱详情信息", notes = "关键字查询菜谱详情信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMenuDetailEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineMenuDetailEntity> record) {
        setPageHelper(record);
        List<EdDineMenuDetailEntity> list = edDineMenuDetailService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineMenuDetailEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除菜谱详情信息", notes = "批量删除菜谱详情信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineMenuDetailEntity> list = JSONObject.parseArray(keys, EdDineMenuDetailEntity.class);
        List<EdDineMenuDetailEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineMenuDetailService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}