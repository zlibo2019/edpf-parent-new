package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.MsgFunctionEntity;
import com.weds.edpf.core.service.MsgFunctionService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 消息函数管理管理
 * @Date 2019-04-03
 */
@RestController
@RequestMapping(value = "/msgFunction")
@Api(value = "消息函数管理管理", description = "消息函数管理管理")
public class MsgFunctionController extends BaseController {
    @Autowired
    private MsgFunctionService msgFunctionService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增消息函数管理信息", notes = "新增消息函数管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MsgFunctionEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        msgFunctionService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新消息函数管理信息", notes = "更新消息函数管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MsgFunctionEntity record) {
        record.setLtDate(new Date());
        msgFunctionService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息函数管理清单", notes = "查询消息函数管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgFunctionEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MsgFunctionEntity> record) {
        setPageHelper(record);
        MsgFunctionEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MsgFunctionEntity();
        }
        List<MsgFunctionEntity> list = msgFunctionService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new MsgFunctionEntity[0]), new String[]{"01007", "01001"});
        return succMsgData(new BaseCommPager<MsgFunctionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询消息函数管理列表", notes = "查询消息函数管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MsgFunctionEntity>> selectListByEntity(@RequestBody MsgFunctionEntity record) {
        List<MsgFunctionEntity> list = msgFunctionService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new MsgFunctionEntity[0]), new String[]{"01007", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除消息函数管理信息", notes = "删除消息函数管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String functionId) {
        msgFunctionService.deleteByPrimaryKey(functionId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息函数管理信息", notes = "查询消息函数管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MsgFunctionEntity> selectByPrimaryKey(@RequestParam String functionId) {
        MsgFunctionEntity entity = msgFunctionService.selectByPrimaryKey(functionId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询消息函数管理信息", notes = "关键字查询消息函数管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgFunctionEntity>> selectListByKeys(@RequestBody BasePageSearch<MsgFunctionEntity> record) {
        setPageHelper(record);
        List<MsgFunctionEntity> list = msgFunctionService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new MsgFunctionEntity[0]), new String[]{"01007", "01001"});
        return succMsgData(new BaseCommPager<MsgFunctionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除消息函数管理信息", notes = "批量删除消息函数管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MsgFunctionEntity> list = JSONObject.parseArray(keys, MsgFunctionEntity.class);
        // msgFunctionService.deleteBatchByKeys(list);
        for (MsgFunctionEntity entity : list) {
            msgFunctionService.deleteByPrimaryKey(entity.getFunctionId());
        }
        return succMsg();
    }
}