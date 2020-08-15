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


import com.weds.edmj.entity .RoleEntity;
import com.weds.edmj.service .RoleService;

/**
 * @Author sxm
 * @Description Role管理
 * @Date 2019-08-14
 */
@RestController
@RequestMapping(value="/role")
@Api(value = "Role管理", description = "Role管理")
public class RoleController extends BaseController{
	@Autowired
	private RoleService roleService;

    
	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增Role信息", notes = "新增Role信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody @Valid RoleEntity record) {
        				roleService.insertSelective(record);
		return succMsg();
	}

		@Logs
	@ApiOperation(value = "查询角色列表", notes = "查询角色列表")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<RoleEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RoleEntity> record) {
		setPageHelper(record);
		RoleEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new RoleEntity();
        }
        List<RoleEntity> list = roleService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RoleEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询Role列表", notes = "查询Role列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RoleEntity>> selectListByEntity(@RequestBody RoleEntity record) {
                List<RoleEntity> list = roleService.selectListByEntity(record);
                return succMsgData(list);
    }

		@Logs
	@ApiOperation(value = "批量删除Role信息", notes = "批量删除Role信息")
	@RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
	public JsonResult<Object> deleteBatchByKeys(@RequestBody List<RoleEntity> list) {
        List<RoleEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                roleService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
		return succMsg();
	}
	
		@Logs
	@ApiOperation(value = "批量新增Role信息", notes = "批量新增Role信息")
	@RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
	public JsonResult<Object> insertBatch(@RequestParam String data) {
		List<RoleEntity> list	= JSONObject.parseArray(data, RoleEntity.class);
		roleService.insertBatch(list);
		return succMsg();
	}
	}