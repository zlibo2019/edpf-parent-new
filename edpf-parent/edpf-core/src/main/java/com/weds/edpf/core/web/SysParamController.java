package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.SysParamEntity;
import com.weds.edpf.core.service.SysParamService;
import com.weds.edpf.core.util.DicFmtBean;
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
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

/**
 * @Author sxm
 * @Description 系统参数管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/sysParam")
@Api(value = "系统参数管理", description = "系统参数管理")
public class SysParamController extends BaseController {
    @Autowired
    private SysParamService sysParamService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增系统参数信息", notes = "新增系统参数信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody SysParamEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        sysParamService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新系统参数信息", notes = "更新系统参数信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody SysParamEntity record) {
        record.setLtDate(new Date());
        sysParamService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询系统参数清单", notes = "查询系统参数清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<SysParamEntity>> selectListPageByEntity(@RequestBody BasePageSearch<SysParamEntity> record) {
        setPageHelper(record);
        SysParamEntity entity = record.getSearch();
        if (entity == null) {
            entity = new SysParamEntity();
        }
        List<SysParamEntity> list = sysParamService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new SysParamEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<SysParamEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询系统参数列表", notes = "查询系统参数列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<SysParamEntity>> selectListByEntity(@RequestBody SysParamEntity record) {
        List<SysParamEntity> list = sysParamService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new SysParamEntity[0]), new String[]{"01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除系统参数信息", notes = "删除系统参数信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String paramKey) {
        sysParamService.deleteByPrimaryKey(paramKey);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询系统参数信息", notes = "查询系统参数信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<SysParamEntity> selectByPrimaryKey(@RequestParam String paramKey) {
        SysParamEntity entity = sysParamService.selectByPrimaryKey(paramKey);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询系统参数信息", notes = "关键字查询系统参数信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<SysParamEntity>> selectListByKeys(@RequestBody BasePageSearch<SysParamEntity> record) {
        setPageHelper(record);
        List<SysParamEntity> list = sysParamService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new SysParamEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<SysParamEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除系统参数信息", notes = "批量删除系统参数信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<SysParamEntity> list = JSONObject.parseArray(keys, SysParamEntity.class);
        // sysParamService.deleteBatchByKeys(list);
        for (SysParamEntity entity : list) {
            sysParamService.deleteByPrimaryKey(entity.getParamKey());
        }
        return succMsg();
    }
}