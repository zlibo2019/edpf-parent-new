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
import com.weds.edwx.entity .MeetMdEntity;
import com.weds.edwx.service .MeetMdService;

/**
 * @Author sxm
 * @Description MeetMd管理
 * @Date 2018-11-22
 */
@RestController
@RequestMapping(value="/meetMd")
@Api(value = "MeetMd管理", description = "MeetMd管理")
public class MeetMdController extends BaseController{
	@Autowired
	private MeetMdService meetMdService;

	private Logger log = LogManager.getLogger();

    @Logs
	@ApiOperation(value = "新增MeetMd信息", notes = "新增MeetMd信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody MeetMdEntity record) {
        				meetMdService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新MeetMd信息", notes = "更新MeetMd信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody MeetMdEntity record) {
				meetMdService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询MeetMd清单", notes = "查询MeetMd清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<MeetMdEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MeetMdEntity> record) {
		setPageHelper(record);
		MeetMdEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new MeetMdEntity();
        }
		        List<MeetMdEntity> list = meetMdService.selectListByEntity(entity);
		return succMsgData(new BaseCommPager<MeetMdEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询MeetMd列表", notes = "查询MeetMd列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MeetMdEntity>> selectListByEntity(@RequestBody MeetMdEntity record) {
                List<MeetMdEntity> list = meetMdService.selectListByEntity(record);
        return succMsgData(list);
    }

		@Logs
	@ApiOperation(value = "删除MeetMd信息", notes = "删除MeetMd信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        meetMdService.deleteByPrimaryKey(xh);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询MeetMd信息", notes = "查询MeetMd信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<MeetMdEntity> selectByPrimaryKey(@RequestParam Integer xh) {
		MeetMdEntity entity = meetMdService.selectByPrimaryKey(xh);
        return succMsgData(entity);
	}
	}