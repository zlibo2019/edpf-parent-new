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
import com.weds.edwx.entity .MODULEEntity;
import com.weds.edwx.service .MODULEService;

/**
 * @Author sxm
 * @Description MODULE管理
 * @Date 2018-11-24
 */
@RestController
@RequestMapping(value="/mODULE")
@Api(value = "MODULE管理", description = "MODULE管理")
public class MODULEController extends BaseController{
	@Autowired
	private MODULEService mODULEService;

	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增MODULE信息", notes = "新增MODULE信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody MODULEEntity record) {
        				mODULEService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新MODULE信息", notes = "更新MODULE信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody MODULEEntity record) {
				mODULEService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询MODULE清单", notes = "查询MODULE清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<MODULEEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MODULEEntity> record) {
		setPageHelper(record);
		MODULEEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new MODULEEntity();
        }
		        List<MODULEEntity> list = mODULEService.selectListByEntity(entity);
		return succMsgData(new BaseCommPager<MODULEEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询MODULE列表", notes = "查询MODULE列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MODULEEntity>> selectListByEntity(@RequestBody MODULEEntity record) {
                List<MODULEEntity> list = mODULEService.selectListByEntity(record);
        return succMsgData(list);
    }

		@Logs
	@ApiOperation(value = "删除MODULE信息", notes = "删除MODULE信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam String moduleId) {
        mODULEService.deleteByPrimaryKey(moduleId);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询MODULE信息", notes = "查询MODULE信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<MODULEEntity> selectByPrimaryKey(@RequestParam String moduleId) {
		MODULEEntity entity = mODULEService.selectByPrimaryKey(moduleId);
        return succMsgData(entity);
	}
	}