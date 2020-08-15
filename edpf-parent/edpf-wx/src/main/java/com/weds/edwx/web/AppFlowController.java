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
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

import com.weds.edwx.entity .AppFlowEntity;
import com.weds.edwx.service .AppFlowService;

/**
 * @Author sxm
 * @Description 审批流程表管理
 * @Date 2019-02-19
 */
@RestController
@RequestMapping(value="/appFlow")
@Api(value = "审批流程表管理", description = "审批流程表管理")
public class AppFlowController extends BaseController{
	@Autowired
	private AppFlowService appFlowService;

	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增审批流程表信息", notes = "新增审批流程表信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody AppFlowEntity record) {
        				appFlowService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新审批流程表信息", notes = "更新审批流程表信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody AppFlowEntity record) {
				appFlowService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询审批流程表清单", notes = "查询审批流程表清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<AppFlowEntity>> selectListPageByEntity(@RequestBody BasePageSearch<AppFlowEntity> record) {
		setPageHelper(record);
		AppFlowEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new AppFlowEntity();
        }
		        List<AppFlowEntity> list = appFlowService.selectListByEntity(entity);
		return succMsgData(new BaseCommPager<AppFlowEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询审批流程表列表", notes = "查询审批流程表列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<AppFlowEntity>> selectListByEntity(@RequestBody AppFlowEntity record) {
                List<AppFlowEntity> list = appFlowService.selectListByEntity(record);
        return succMsgData(list);
    }

		@Logs
	@ApiOperation(value = "删除审批流程表信息", notes = "删除审批流程表信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam String flowId) {
        appFlowService.deleteByPrimaryKey(flowId);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询审批流程表信息", notes = "查询审批流程表信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<AppFlowEntity> selectByPrimaryKey(@RequestParam String flowId) {
		AppFlowEntity entity = appFlowService.selectByPrimaryKey(flowId);
        return succMsgData(entity);
	}
	}