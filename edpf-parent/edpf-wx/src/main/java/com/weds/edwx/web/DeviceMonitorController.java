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
import com.weds.edwx.entity .DeviceMonitorEntity;
import com.weds.edwx.service .DeviceMonitorService;

/**
 * @Author sxm
 * @Description DeviceMonitor管理
 * @Date 2018-11-24
 */
@RestController
@RequestMapping(value="/deviceMonitor")
@Api(value = "DeviceMonitor管理", description = "DeviceMonitor管理")
public class DeviceMonitorController extends BaseController{
	@Autowired
	private DeviceMonitorService deviceMonitorService;

	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增DeviceMonitor信息", notes = "新增DeviceMonitor信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody DeviceMonitorEntity record) {
        				deviceMonitorService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新DeviceMonitor信息", notes = "更新DeviceMonitor信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody DeviceMonitorEntity record) {
				deviceMonitorService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询DeviceMonitor清单", notes = "查询DeviceMonitor清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<DeviceMonitorEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DeviceMonitorEntity> record) {
		setPageHelper(record);
		DeviceMonitorEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new DeviceMonitorEntity();
        }
		        List<DeviceMonitorEntity> list = deviceMonitorService.selectListByEntity(entity);
		return succMsgData(new BaseCommPager<DeviceMonitorEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询DeviceMonitor列表", notes = "查询DeviceMonitor列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DeviceMonitorEntity>> selectListByEntity(@RequestBody DeviceMonitorEntity record) {
                List<DeviceMonitorEntity> list = deviceMonitorService.selectListByEntity(record);
        return succMsgData(list);
    }

		@Logs
	@ApiOperation(value = "删除DeviceMonitor信息", notes = "删除DeviceMonitor信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        deviceMonitorService.deleteByPrimaryKey(xh);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询DeviceMonitor信息", notes = "查询DeviceMonitor信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<DeviceMonitorEntity> selectByPrimaryKey(@RequestParam Integer xh) {
		DeviceMonitorEntity entity = deviceMonitorService.selectByPrimaryKey(xh);
        return succMsgData(entity);
	}
	}