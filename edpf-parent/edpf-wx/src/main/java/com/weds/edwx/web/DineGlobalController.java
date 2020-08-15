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
import com.weds.edwx.entity.DineGlobalEntity;
import com.weds.edwx.service.DineGlobalService;

/**
 * @Author sxm
 * @Description DineGlobal管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/dineGlobal")
@Api(value = "DineGlobal管理", description = "DineGlobal管理")
public class DineGlobalController extends BaseController {
    @Autowired
    private DineGlobalService dineGlobalService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DineGlobal信息", notes = "新增DineGlobal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DineGlobalEntity record) {
        dineGlobalService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DineGlobal信息", notes = "更新DineGlobal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DineGlobalEntity record) {
        dineGlobalService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineGlobal清单", notes = "查询DineGlobal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DineGlobalEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DineGlobalEntity> record) {
        setPageHelper(record);
        DineGlobalEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DineGlobalEntity();
        }
        List<DineGlobalEntity> list = dineGlobalService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DineGlobalEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询DineGlobal列表", notes = "查询DineGlobal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DineGlobalEntity>> selectListByEntity(@RequestBody DineGlobalEntity record) {
        List<DineGlobalEntity> list = dineGlobalService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DineGlobal信息", notes = "删除DineGlobal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer bh) {
        dineGlobalService.deleteByPrimaryKey(bh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineGlobal信息", notes = "查询DineGlobal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DineGlobalEntity> selectByPrimaryKey(@RequestParam Integer bh) {
        DineGlobalEntity entity = dineGlobalService.selectByPrimaryKey(bh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询订餐说明", notes = "查询订餐说明")
    @RequestMapping(value = "/selectDineRemark", method = RequestMethod.GET)
    public JsonResult<DineGlobalEntity> selectDineRemark() {
        List<DineGlobalEntity> list = dineGlobalService.selectListByEntity(null);
        return succMsgData(list.get(0));
    }
}