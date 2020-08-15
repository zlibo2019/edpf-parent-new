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
import com.weds.edwx.entity.DineUserEntity;
import com.weds.edwx.service.DineUserService;

/**
 * @Author sxm
 * @Description DineUser管理
 * @Date 2018-11-13
 */
@RestController
@RequestMapping(value = "/dineUser")
@Api(value = "DineUser管理", description = "DineUser管理")
public class DineUserController extends BaseController {
    @Autowired
    private DineUserService dineUserService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DineUser信息", notes = "新增DineUser信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DineUserEntity record) {
        dineUserService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DineUser信息", notes = "更新DineUser信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DineUserEntity record) {
        record.setSj(new Date());
        int rtn = dineUserService.updateByPrimaryKeySelective(record);
        if (rtn == 0) {
            dineUserService.insertSelective(record);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineUser清单", notes = "查询DineUser清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DineUserEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DineUserEntity> record) {
        setPageHelper(record);
        DineUserEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DineUserEntity();
        }
        List<DineUserEntity> list = dineUserService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DineUserEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询DineUser列表", notes = "查询DineUser列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DineUserEntity>> selectListByEntity(@RequestBody DineUserEntity record) {
        List<DineUserEntity> list = dineUserService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DineUser信息", notes = "删除DineUser信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer userSerial) {
        dineUserService.deleteByPrimaryKey(userSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineUser信息", notes = "查询DineUser信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DineUserEntity> selectByPrimaryKey(@RequestParam Integer userSerial) {
        DineUserEntity entity = dineUserService.selectByPrimaryKey(userSerial);
        return succMsgData(entity);
    }
}