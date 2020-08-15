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


import com.weds.edmj.entity.WtMjVerEntity;
import com.weds.edmj.service.WtMjVerService;

/**
 * @Author sxm
 * @Description 配置文件更新的日志管理
 * @Date 2019-07-29
 */
@RestController
@RequestMapping(value = "/wtMjVer")
@Api(value = "配置文件更新的日志管理", description = "配置文件更新的日志管理")
public class WtMjVerController extends BaseController {
    @Autowired
    private WtMjVerService wtMjVerService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增配置文件更新的日志信息", notes = "新增配置文件更新的日志信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid WtMjVerEntity record) {
        wtMjVerService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新配置文件更新的日志信息", notes = "更新配置文件更新的日志信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid WtMjVerEntity record) {
        wtMjVerService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询配置文件更新的日志清单", notes = "查询配置文件更新的日志清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<WtMjVerEntity>> selectListPageByEntity(@RequestBody BasePageSearch<WtMjVerEntity> record) {
        setPageHelper(record);
        WtMjVerEntity entity = record.getSearch();
        if (entity == null) {
            entity = new WtMjVerEntity();
        }
        List<WtMjVerEntity> list = wtMjVerService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<WtMjVerEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询配置文件更新的日志列表", notes = "查询配置文件更新的日志列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<WtMjVerEntity>> selectListByEntity(@RequestBody WtMjVerEntity record) {
        List<WtMjVerEntity> list = wtMjVerService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除配置文件更新的日志信息", notes = "删除配置文件更新的日志信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        wtMjVerService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询配置文件更新的日志信息", notes = "查询配置文件更新的日志信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<WtMjVerEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        WtMjVerEntity entity = wtMjVerService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询配置文件更新的日志信息", notes = "关键字查询配置文件更新的日志信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<WtMjVerEntity>> selectListByKeys(@RequestBody BasePageSearch<WtMjVerEntity> record) {
        setPageHelper(record);
        List<WtMjVerEntity> list = wtMjVerService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<WtMjVerEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除配置文件更新的日志信息", notes = "批量删除配置文件更新的日志信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<WtMjVerEntity> list = JSONObject.parseArray(keys, WtMjVerEntity.class);
        List<WtMjVerEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                wtMjVerService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增配置文件更新的日志信息", notes = "批量新增配置文件更新的日志信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<WtMjVerEntity> list = JSONObject.parseArray(data, WtMjVerEntity.class);
        wtMjVerService.insertBatch(list);
        return succMsg();
    }
}