package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

import com.weds.edwx.entity.MeetSpEntity;
import com.weds.edwx.service.MeetSpService;

/**
 * @Author
 * @Description MeetSp管理
 * @Date 2019-11-28
 */
@RestController
@RequestMapping(value = "/meetSp")
@Api(value = "MeetSp管理", description = "MeetSp管理")
public class MeetSpController extends BaseController {
    @Resource
    private MeetSpService meetSpService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MeetSp信息", notes = "新增MeetSp信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MeetSpEntity record) {
        meetSpService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MeetSp信息", notes = "更新MeetSp信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MeetSpEntity record) {
        meetSpService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MeetSp清单", notes = "查询MeetSp清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetSpEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MeetSpEntity> record) {
        setPageHelper(record);
        MeetSpEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetSpEntity();
        }
        List<MeetSpEntity> list = meetSpService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MeetSpEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询MeetSp列表", notes = "查询MeetSp列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MeetSpEntity>> selectListByEntity(@RequestBody MeetSpEntity record) {
        List<MeetSpEntity> list = meetSpService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MeetSp信息", notes = "删除MeetSp信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        meetSpService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MeetSp信息", notes = "查询MeetSp信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MeetSpEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        MeetSpEntity entity = meetSpService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量新增MeetSp信息", notes = "批量新增MeetSp信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MeetSpEntity> list = JSONObject.parseArray(data, MeetSpEntity.class);
        meetSpService.insertBatch(list);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "会议审批", notes = "会议审批")
    @RequestMapping(value = "/approveMeeting", method = RequestMethod.POST)
    public JsonResult<Object> approveMeeting(@RequestBody @Valid MeetSpEntity record) {
        record.setSj(new Date());
        meetSpService.approveMeeting(record);
        return succMsg();
    }
}