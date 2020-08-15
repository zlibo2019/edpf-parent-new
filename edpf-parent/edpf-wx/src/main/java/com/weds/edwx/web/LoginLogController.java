package com.weds.edwx .web;

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

import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.entity .LoginLogEntity;
import com.weds.edwx.service .LoginLogService;

/**
 * @Author sxm
 * @Description LoginLog管理
 * @Date 2018-11-26
 */
@RestController
@RequestMapping(value="/loginLog")
@Api(value = "LoginLog管理", description = "LoginLog管理")
public class LoginLogController extends BaseController{
	@Autowired
	private LoginLogService loginLogService;

	private Logger log = LogManager.getLogger();
/*
    @Logs
	@ApiOperation(value = "新增LoginLog信息", notes = "新增LoginLog信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody LoginLogEntity record) {
        				loginLogService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新LoginLog信息", notes = "更新LoginLog信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody LoginLogEntity record) {
				loginLogService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询LoginLog清单", notes = "查询LoginLog清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<LoginLogEntity>> selectListPageByEntity(@RequestBody BasePageSearch<LoginLogEntity> record) {
		setPageHelper(record);
		LoginLogEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new LoginLogEntity();
        }
		        List<LoginLogEntity> list = loginLogService.selectListByEntity(entity);
		return succMsg(new BaseCommPager<LoginLogEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询LoginLog列表", notes = "查询LoginLog列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<LoginLogEntity>> selectListByEntity(@RequestBody LoginLogEntity record) {
                List<LoginLogEntity> list = loginLogService.selectListByEntity(record);
        return succMsg(list);
    }

		@Logs
	@ApiOperation(value = "删除LoginLog信息", notes = "删除LoginLog信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey() {
        loginLogService.deleteByPrimaryKey();
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询LoginLog信息", notes = "查询LoginLog信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<LoginLogEntity> selectByPrimaryKey() {
		LoginLogEntity entity = loginLogService.selectByPrimaryKey();
        return succMsg(entity);
	}*/
	}