package com.weds.edwx .web;

import com.alibaba.fastjson.JSONObject;
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


import com.weds.edwx.entity .FkLogEntity;
import com.weds.edwx.service .FkLogService;

/**
 * @Author sxm
 * @Description FkLog管理
 * @Date 2019-03-22
 */
@RestController
@RequestMapping(value="/fkLog")
@Api(value = "FkLog管理", description = "FkLog管理")
public class FkLogController extends BaseController{
	@Autowired
	private FkLogService fkLogService;

    
	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增FkLog信息", notes = "新增FkLog信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody FkLogEntity record) {
        				fkLogService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新FkLog信息", notes = "更新FkLog信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody FkLogEntity record) {
        		fkLogService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

		@Logs
	@ApiOperation(value = "查询FkLog清单", notes = "查询FkLog清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<FkLogEntity>> selectListPageByEntity(@RequestBody BasePageSearch<FkLogEntity> record) {
		setPageHelper(record);
		FkLogEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new FkLogEntity();
        }
                List<FkLogEntity> list = fkLogService.selectListByEntity(entity);
        		return succMsgData(new BaseCommPager<FkLogEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询FkLog列表", notes = "查询FkLog列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<FkLogEntity>> selectListByEntity(@RequestBody FkLogEntity record) {
                List<FkLogEntity> list = fkLogService.selectListByEntity(record);
                return succMsgData(list);
    }
	
		@Logs
	@ApiOperation(value = "删除FkLog信息", notes = "删除FkLog信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        fkLogService.deleteByPrimaryKey(xh);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询FkLog信息", notes = "查询FkLog信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<FkLogEntity> selectByPrimaryKey(@RequestParam Integer xh) {
		FkLogEntity entity = fkLogService.selectByPrimaryKey(xh);
                return succMsgData(entity);
	}
	
	
	}