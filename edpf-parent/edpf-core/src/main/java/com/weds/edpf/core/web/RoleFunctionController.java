package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.RoleFunctionEntity;
import com.weds.edpf.core.service.RoleFunctionService;
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
 * @Description 角色功能关系管理
 * @Date 2019-03-08
 */
@RestController
@RequestMapping(value = "/roleFunction")
@Api(value = "角色功能关系管理", description = "角色功能关系管理")
public class RoleFunctionController extends BaseController {
    @Autowired
    private RoleFunctionService roleFunctionService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增角色功能关系信息", notes = "新增角色功能关系信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody RoleFunctionEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        roleFunctionService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新角色功能关系信息", notes = "更新角色功能关系信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody RoleFunctionEntity record) {
        record.setLtDate(new Date());
        roleFunctionService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询角色功能关系清单", notes = "查询角色功能关系清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RoleFunctionEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RoleFunctionEntity> record) {
        setPageHelper(record);
        RoleFunctionEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RoleFunctionEntity();
        }
        List<RoleFunctionEntity> list = roleFunctionService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RoleFunctionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询角色功能关系列表", notes = "查询角色功能关系列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RoleFunctionEntity>> selectListByEntity(@RequestBody RoleFunctionEntity record) {
        List<RoleFunctionEntity> list = roleFunctionService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除角色功能关系信息", notes = "删除角色功能关系信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String roleId, @RequestParam String functionId) {
        roleFunctionService.deleteByPrimaryKey(roleId, functionId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询角色功能关系信息", notes = "查询角色功能关系信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RoleFunctionEntity> selectByPrimaryKey(@RequestParam String roleId, @RequestParam String functionId) {
        RoleFunctionEntity entity = roleFunctionService.selectByPrimaryKey(roleId, functionId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询角色功能关系信息", notes = "关键字查询角色功能关系信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RoleFunctionEntity>> selectListByKeys(@RequestBody BasePageSearch<RoleFunctionEntity> record) {
        setPageHelper(record);
        List<RoleFunctionEntity> list = roleFunctionService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<RoleFunctionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除角色功能关系信息", notes = "批量删除角色功能关系信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<RoleFunctionEntity> list = JSONObject.parseArray(keys, RoleFunctionEntity.class);
        // roleFunctionService.deleteBatchByKeys(list);
        for (RoleFunctionEntity entity : list) {
            roleFunctionService.deleteByPrimaryKey(entity.getRoleId(), entity.getFunctionId());
        }
        return succMsg();
    }
}