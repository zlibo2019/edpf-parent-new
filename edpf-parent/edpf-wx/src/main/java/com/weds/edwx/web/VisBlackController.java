package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edwx.entity.TtSexEntity;
import com.weds.edwx.entity.VisUserEntity;
import com.weds.edwx.service.TtSexService;
import com.weds.edwx.service.VisUserService;
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


import com.weds.edwx.entity.VisBlackEntity;
import com.weds.edwx.service.VisBlackService;

/**
 * @Author sxm
 * @Description VisBlack管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visBlack")
@Api(value = "VisBlack管理", description = "VisBlack管理")
public class VisBlackController extends BaseController {
    @Autowired
    private VisBlackService visBlackService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisBlack信息", notes = "新增VisBlack信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisBlackEntity record) {
        VisBlackEntity visBlackEntity = visBlackService.selectByCardId(record.getVisNo());
        if (visBlackEntity == null) {
            record.setSj(new Date());
            visBlackService.insertSelective(record);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisBlack信息", notes = "更新VisBlack信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisBlackEntity record) {
        visBlackService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisBlack清单", notes = "查询VisBlack清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisBlackEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisBlackEntity> record) {
        setPageHelper(record);
        VisBlackEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisBlackEntity();
        }
        List<VisBlackEntity> list = visBlackService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisBlackEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisBlack列表", notes = "查询VisBlack列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisBlackEntity>> selectListByEntity(@RequestBody VisBlackEntity record) {
        List<VisBlackEntity> list = visBlackService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisBlack信息", notes = "删除VisBlack信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String openId) {
        visBlackService.deleteByPrimaryKey(openId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisBlack信息", notes = "查询VisBlack信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisBlackEntity> selectByPrimaryKey(@RequestParam String openId) {
        VisBlackEntity entity = visBlackService.selectByPrimaryKey(openId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisBlack信息", notes = "关键字查询VisBlack信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisBlackEntity>> selectListByKeys(@RequestBody BasePageSearch<VisBlackEntity> record) {
        setPageHelper(record);
        List<VisBlackEntity> list = visBlackService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisBlackEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisBlack信息", notes = "批量删除VisBlack信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisBlackEntity> list = JSONObject.parseArray(keys, VisBlackEntity.class);
        // visBlackService.deleteBatchByKeys(list);
        for (VisBlackEntity entity : list) {
            visBlackService.deleteByPrimaryKey(entity.getOpenId());
        }
        return succMsg();
    }
}