package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Date;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edpf.core.entity.MsgParamsEntity;
import com.weds.edpf.core.service.MsgParamsService;

/**
 * @Author sxm
 * @Description 消息参数管理管理
 * @Date 2019-04-03
 */
@RestController
@RequestMapping(value = "/msgParams")
@Api(value = "消息参数管理管理", description = "消息参数管理管理")
public class MsgParamsController extends BaseController {
    @Autowired
    private MsgParamsService msgParamsService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增消息参数管理信息", notes = "新增消息参数管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MsgParamsEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        msgParamsService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新消息参数管理信息", notes = "更新消息参数管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MsgParamsEntity record) {
        record.setLtDate(new Date());
        msgParamsService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息参数管理清单", notes = "查询消息参数管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgParamsEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MsgParamsEntity> record) {
        setPageHelper(record);
        MsgParamsEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MsgParamsEntity();
        }
        List<MsgParamsEntity> list = msgParamsService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MsgParamsEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询消息参数管理列表", notes = "查询消息参数管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MsgParamsEntity>> selectListByEntity(@RequestBody MsgParamsEntity record) {
        List<MsgParamsEntity> list = msgParamsService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除消息参数管理信息", notes = "删除消息参数管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String paramId, @RequestParam String templateId) {
        msgParamsService.deleteByPrimaryKey(paramId, templateId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息参数管理信息", notes = "查询消息参数管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MsgParamsEntity> selectByPrimaryKey(@RequestParam String paramId, @RequestParam String templateId) {
        MsgParamsEntity entity = msgParamsService.selectByPrimaryKey(paramId, templateId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询消息参数管理信息", notes = "关键字查询消息参数管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgParamsEntity>> selectListByKeys(@RequestBody BasePageSearch<MsgParamsEntity> record) {
        setPageHelper(record);
        List<MsgParamsEntity> list = msgParamsService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MsgParamsEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除消息参数管理信息", notes = "批量删除消息参数管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MsgParamsEntity> list = JSONObject.parseArray(keys, MsgParamsEntity.class);
        // msgParamsService.deleteBatchByKeys(list);
        for (MsgParamsEntity entity : list) {
            msgParamsService.deleteByPrimaryKey(entity.getParamId(), entity.getTemplateId());
        }
        return succMsg();
    }
}