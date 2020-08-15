package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.UserRoleEntity;
import com.weds.edpf.core.service.UserRoleService;
import io.swagger.models.auth.In;
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
 * @Description 用户角色关系管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/userRole")
@Api(value = "用户角色关系管理", description = "用户角色关系管理")
public class UserRoleController extends BaseController {
    @Autowired
    private UserRoleService userRoleService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增用户角色关系信息", notes = "新增用户角色关系信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody UserRoleEntity record) {
        // Date date = new Date();
        // record.setCtDate(date);
        // record.setLtDate(date);
        // userRoleService.insertSelective(record);
        List<String> list = JSONObject.parseArray(record.getUserSerials(), String.class);
        if (list != null) {
            userRoleService.insertByRoleId(record.getRoleId(), list);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新用户角色关系信息", notes = "更新用户角色关系信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody UserRoleEntity record) {
        record.setLtDate(new Date());
        userRoleService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户角色关系清单", notes = "查询用户角色关系清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserRoleEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserRoleEntity> record) {
        setPageHelper(record);
        UserRoleEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserRoleEntity();
        }
        List<UserRoleEntity> list = userRoleService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserRoleEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询用户角色关系列表", notes = "查询用户角色关系列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserRoleEntity>> selectListByEntity(@RequestBody UserRoleEntity record) {
        List<UserRoleEntity> list = userRoleService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除用户角色关系信息", notes = "删除用户角色关系信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userSerial, @RequestParam String roleId) {
        userRoleService.deleteByPrimaryKey(userSerial, roleId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户角色关系信息", notes = "查询用户角色关系信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserRoleEntity> selectByPrimaryKey(@RequestParam String userSerial, @RequestParam String roleId) {
        UserRoleEntity entity = userRoleService.selectByPrimaryKey(userSerial, roleId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询用户角色关系信息", notes = "关键字查询用户角色关系信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserRoleEntity>> selectListByKeys(@RequestBody BasePageSearch<UserRoleEntity> record) {
        setPageHelper(record);
        List<UserRoleEntity> list = userRoleService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<UserRoleEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除用户角色关系信息", notes = "批量删除用户角色关系信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<UserRoleEntity> list = JSONObject.parseArray(keys, UserRoleEntity.class);
        // userRoleService.deleteBatchByKeys(list);
        for (UserRoleEntity entity : list) {
            userRoleService.deleteByPrimaryKey(entity.getUserSerial(), entity.getRoleId());
        }
        return succMsg();
    }
}