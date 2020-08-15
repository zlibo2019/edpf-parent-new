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

import com.weds.edwx.entity .ParkCarInfoEntity;
import com.weds.edwx.service .ParkCarInfoService;

/**
 * @Author sxm
 * @Description ParkCarInfo管理
 * @Date 2019-03-27
 */
@RestController
@RequestMapping(value="/parkCarInfo")
@Api(value = "ParkCarInfo管理", description = "ParkCarInfo管理")
public class ParkCarInfoController extends BaseController{
    @Autowired
    private ParkCarInfoService parkCarInfoService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增ParkCarInfo信息", notes = "新增ParkCarInfo信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody ParkCarInfoEntity record) {
        parkCarInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新ParkCarInfo信息", notes = "更新ParkCarInfo信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody ParkCarInfoEntity record) {
        parkCarInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询ParkCarInfo清单", notes = "查询ParkCarInfo清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<ParkCarInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<ParkCarInfoEntity> record) {
        setPageHelper(record);
        ParkCarInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new ParkCarInfoEntity();
        }
        List<ParkCarInfoEntity> list = parkCarInfoService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<ParkCarInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询ParkCarInfo列表", notes = "查询ParkCarInfo列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<ParkCarInfoEntity>> selectListByEntity(@RequestBody ParkCarInfoEntity record) {
        List<ParkCarInfoEntity> list = parkCarInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除ParkCarInfo信息", notes = "删除ParkCarInfo信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        parkCarInfoService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询ParkCarInfo信息", notes = "查询ParkCarInfo信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<ParkCarInfoEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        ParkCarInfoEntity entity = parkCarInfoService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }
}