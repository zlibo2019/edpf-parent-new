package com.weds.edwx.web;

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
import com.weds.edwx.entity.LoginOpenidEntity;
import com.weds.edwx.service.LoginOpenidService;

/**
 * @Author sxm
 * @Description LoginOpenid管理
 * @Date 2018-11-26
 */
@RestController
@RequestMapping(value = "/loginOpenid")
@Api(value = "LoginOpenid管理", description = "LoginOpenid管理")
public class LoginOpenidController extends BaseController {
    @Autowired
    private LoginOpenidService loginOpenidService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "更新消息推送状态", notes = "更新消息推送状态")
    @RequestMapping(value = "/updateSendState", method = RequestMethod.POST)
    public JsonResult<Object> updateSendState(@RequestBody LoginOpenidEntity record) {
        loginOpenidService.updateSendState(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取消息推送状态", notes = "获取消息推送状态")
    @RequestMapping(value = "/selectSendState", method = RequestMethod.POST)
    public JsonResult<LoginOpenidEntity> selectByPrimaryKey(@RequestBody LoginOpenidEntity record) {
        LoginOpenidEntity entity = loginOpenidService.selectSendState(record);
        return succMsgData(entity);
    }
	/*
    @Logs
	@ApiOperation(value = "新增LoginOpenid信息", notes = "新增LoginOpenid信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody LoginOpenidEntity record) {
        				loginOpenidService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询LoginOpenid清单", notes = "查询LoginOpenid清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<LoginOpenidEntity>> selectListPageByEntity(@RequestBody BasePageSearch<LoginOpenidEntity> record) {
		setPageHelper(record);
		LoginOpenidEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new LoginOpenidEntity();
        }
		        List<LoginOpenidEntity> list = loginOpenidService.selectListByEntity(entity);
		return succMsg(new BaseCommPager<LoginOpenidEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询LoginOpenid列表", notes = "查询LoginOpenid列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<LoginOpenidEntity>> selectListByEntity(@RequestBody LoginOpenidEntity record) {
                List<LoginOpenidEntity> list = loginOpenidService.selectListByEntity(record);
        return succMsg(list);
    }

		@Logs
	@ApiOperation(value = "删除LoginOpenid信息", notes = "删除LoginOpenid信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey() {
        loginOpenidService.deleteByPrimaryKey();
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询LoginOpenid信息", notes = "查询LoginOpenid信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<LoginOpenidEntity> selectByPrimaryKey() {
		LoginOpenidEntity entity = loginOpenidService.selectByPrimaryKey();
        return succMsg(entity);
	}*/
}