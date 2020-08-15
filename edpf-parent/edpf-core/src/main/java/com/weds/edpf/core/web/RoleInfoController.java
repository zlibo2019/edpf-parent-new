package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.RoleInfoEntity;
import com.weds.edpf.core.entity.UserRoleEntity;
import com.weds.edpf.core.service.RoleFunctionService;
import com.weds.edpf.core.service.RoleInfoService;
import com.weds.edpf.core.service.UserRoleService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 角色信息管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/roleInfo")
@Api(value = "角色信息管理", description = "角色信息管理")
public class RoleInfoController extends BaseController {
    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleFunctionService roleFunctionService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增角色信息信息", notes = "新增角色信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody RoleInfoEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        roleInfoService.insertSelective(record);
        List<String> list = JSONObject.parseArray(record.getFunctions(), String.class);
        if (list != null) {
            roleFunctionService.insertByRoleId(record.getRoleId(), list);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新角色信息信息", notes = "更新角色信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody RoleInfoEntity record) {
        Date date = new Date();
        record.setLtDate(date);
        roleInfoService.updateByPrimaryKeySelective(record);
        List<String> list = JSONObject.parseArray(record.getFunctions(), String.class);
        if (list != null) {
            roleFunctionService.insertByRoleId(record.getRoleId(), list);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询角色信息清单", notes = "查询角色信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RoleInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RoleInfoEntity> record) {
        setPageHelper(record);
        RoleInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RoleInfoEntity();
        }
        List<RoleInfoEntity> list = roleInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new RoleInfoEntity[0]), new String[]{"01001", "01003"});
        return succMsgData(new BaseCommPager<RoleInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询角色信息列表", notes = "查询角色信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RoleInfoEntity>> selectListByEntity(@RequestBody RoleInfoEntity record) {
        List<RoleInfoEntity> list = roleInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new RoleInfoEntity[0]), new String[]{"01001", "01003"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除角色信息信息", notes = "删除角色信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @Transactional
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String roleId) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRoleId(roleId);
        List<UserRoleEntity> list = userRoleService.selectListByEntity(userRoleEntity);
        if (list.size() > 0) {
            return failMsg("角色已使用，无法删除！");
        }
        roleInfoService.deleteByPrimaryKey(roleId);
        // roleFunctionService.deleteByRoleId(roleId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询角色信息信息", notes = "查询角色信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RoleInfoEntity> selectByPrimaryKey(@RequestParam String roleId) {
        RoleInfoEntity entity = roleInfoService.selectByPrimaryKey(roleId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询角色信息信息", notes = "关键字查询角色信息信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RoleInfoEntity>> selectListByKeys(@RequestBody BasePageSearch<RoleInfoEntity> record) {
        setPageHelper(record);
        List<RoleInfoEntity> list = roleInfoService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new RoleInfoEntity[0]), new String[]{"01001", "01003"});
        return succMsgData(new BaseCommPager<RoleInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除角色信息信息", notes = "批量删除角色信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<RoleInfoEntity> list = JSONObject.parseArray(keys, RoleInfoEntity.class);
        // roleInfoService.deleteBatchByKeys(list);
        for (RoleInfoEntity entity : list) {
            roleInfoService.deleteByPrimaryKey(entity.getRoleId());
        }
        return succMsg();
    }
}