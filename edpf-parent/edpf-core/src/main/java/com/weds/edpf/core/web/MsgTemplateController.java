package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.MsgTemplateEntity;
import com.weds.edpf.core.service.MsgFormatService;
import com.weds.edpf.core.service.MsgParamsService;
import com.weds.edpf.core.service.MsgTemplateService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptException;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description 消息模板管理管理
 * @Date 2019-04-03
 */
@RestController
@RequestMapping(value = "/msgTemplate")
@Api(value = "消息模板管理管理", description = "消息模板管理管理")
public class MsgTemplateController extends BaseController {
    @Autowired
    private MsgTemplateService msgTemplateService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Autowired
    private MsgFormatService msgFormatService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增消息模板管理信息", notes = "新增消息模板管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MsgTemplateEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        msgTemplateService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新消息模板管理信息", notes = "更新消息模板管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MsgTemplateEntity record) {
        record.setLtDate(new Date());
        msgTemplateService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息模板管理清单", notes = "查询消息模板管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgTemplateEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MsgTemplateEntity> record) {
        setPageHelper(record);
        MsgTemplateEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MsgTemplateEntity();
        }
        List<MsgTemplateEntity> list = msgTemplateService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new MsgTemplateEntity[0]), new String[]{"01006", "01001"});
        return succMsgData(new BaseCommPager<MsgTemplateEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询消息模板管理列表", notes = "查询消息模板管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MsgTemplateEntity>> selectListByEntity(@RequestBody MsgTemplateEntity record) {
        List<MsgTemplateEntity> list = msgTemplateService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new MsgTemplateEntity[0]), new String[]{"01006", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除消息模板管理信息", notes = "删除消息模板管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String templateId, @RequestParam String msgType) {
        msgTemplateService.deleteByPrimaryKey(templateId, msgType);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询消息模板管理信息", notes = "查询消息模板管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MsgTemplateEntity> selectByPrimaryKey(@RequestParam String templateId, @RequestParam String msgType) {
        MsgTemplateEntity entity = msgTemplateService.selectByPrimaryKey(templateId, msgType);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询消息模板管理信息", notes = "关键字查询消息模板管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgTemplateEntity>> selectListByKeys(@RequestBody BasePageSearch<MsgTemplateEntity> record) {
        setPageHelper(record);
        List<MsgTemplateEntity> list = msgTemplateService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new MsgTemplateEntity[0]), new String[]{"01006", "01001"});
        return succMsgData(new BaseCommPager<MsgTemplateEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除消息模板管理信息", notes = "批量删除消息模板管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MsgTemplateEntity> list = JSONObject.parseArray(keys, MsgTemplateEntity.class);
        // msgTemplateService.deleteBatchByKeys(list);
        for (MsgTemplateEntity entity : list) {
            msgTemplateService.deleteByPrimaryKey(entity.getTemplateId(), entity.getMsgType());
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取模板格式化后消息", notes = "获取模板格式化后消息")
    @RequestMapping(value = "/parseTemplate", method = RequestMethod.POST)
    public JsonResult<String> parseTemplate(@RequestParam String templateId, @RequestParam String msgType,
                                            @RequestBody Map<String, Object> params) {
        try {
            String str = msgFormatService.parseTemplate(templateId, msgType, params);
            return succMsgData(str);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
            return failMsg();
        }
    }
}