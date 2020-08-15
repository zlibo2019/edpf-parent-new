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


import com.weds.edmj.entity.JrealUpdate0Entity;
import com.weds.edmj.service.JrealUpdate0Service;

/**
 * @Author sxm
 * @Description JrealUpdate0管理
 * @Date 2019-07-31
 */
@RestController
@RequestMapping(value = "/jrealUpdate0")
@Api(value = "JrealUpdate0管理", description = "JrealUpdate0管理")
public class JrealUpdate0Controller extends BaseController {
    @Autowired
    private JrealUpdate0Service jrealUpdate0Service;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增JrealUpdate0信息", notes = "新增JrealUpdate0信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid JrealUpdate0Entity record) {
        jrealUpdate0Service.insertSelective0(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新JrealUpdate0信息", notes = "更新JrealUpdate0信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid JrealUpdate0Entity record) {
        jrealUpdate0Service.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询JrealUpdate0清单", notes = "查询JrealUpdate0清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JrealUpdate0Entity>> selectListPageByEntity(@RequestBody BasePageSearch<JrealUpdate0Entity> record) {
        setPageHelper(record);
        JrealUpdate0Entity entity = record.getSearch();
        if (entity == null) {
            entity = new JrealUpdate0Entity();
        }
        List<JrealUpdate0Entity> list = jrealUpdate0Service.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<JrealUpdate0Entity>(list));
    }

    @Logs
    @ApiOperation(value = "查询JrealUpdate0列表", notes = "查询JrealUpdate0列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<JrealUpdate0Entity>> selectListByEntity(@RequestBody JrealUpdate0Entity record) {
        List<JrealUpdate0Entity> list = jrealUpdate0Service.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除JrealUpdate0信息", notes = "删除JrealUpdate0信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer jsig) {
        jrealUpdate0Service.deleteByPrimaryKey(jsig);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询JrealUpdate0信息", notes = "查询JrealUpdate0信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<JrealUpdate0Entity> selectByPrimaryKey(@RequestParam Integer jsig) {
        JrealUpdate0Entity entity = jrealUpdate0Service.selectByPrimaryKey(jsig);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询JrealUpdate0信息", notes = "关键字查询JrealUpdate0信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JrealUpdate0Entity>> selectListByKeys(@RequestBody BasePageSearch<JrealUpdate0Entity> record) {
        setPageHelper(record);
        List<JrealUpdate0Entity> list = jrealUpdate0Service.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<JrealUpdate0Entity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除JrealUpdate0信息", notes = "批量删除JrealUpdate0信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<JrealUpdate0Entity> list = JSONObject.parseArray(keys, JrealUpdate0Entity.class);
        List<JrealUpdate0Entity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                jrealUpdate0Service.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增JrealUpdate0信息", notes = "批量新增JrealUpdate0信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<JrealUpdate0Entity> list = JSONObject.parseArray(data, JrealUpdate0Entity.class);
        jrealUpdate0Service.insertBatch(list);
        return succMsg();
    }
}