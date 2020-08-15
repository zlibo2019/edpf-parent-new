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
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

import com.weds.edwx.entity.RepairTypeParamEntity;
import com.weds.edwx.service.RepairTypeParamService;

/**
 * @Author sxm
 * @Description RepairTypeParam管理
 * @Date 2019-02-28
 */
@RestController
@RequestMapping(value = "/repairTypeParam")
@Api(value = "RepairTypeParam管理", description = "RepairTypeParam管理")
public class RepairTypeParamController extends BaseController {
    @Autowired
    private RepairTypeParamService repairTypeParamService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增RepairTypeParam信息", notes = "新增RepairTypeParam信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody RepairTypeParamEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        repairTypeParamService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新RepairTypeParam信息", notes = "更新RepairTypeParam信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody RepairTypeParamEntity record) {
        record.setLtDate(new Date());
        repairTypeParamService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询RepairTypeParam清单", notes = "查询RepairTypeParam清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RepairTypeParamEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RepairTypeParamEntity> record) {
        setPageHelper(record);
        RepairTypeParamEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RepairTypeParamEntity();
        }
        List<RepairTypeParamEntity> list = repairTypeParamService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RepairTypeParamEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询RepairTypeParam列表", notes = "查询RepairTypeParam列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RepairTypeParamEntity>> selectListByEntity(@RequestBody RepairTypeParamEntity record) {
        List<RepairTypeParamEntity> list = repairTypeParamService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除RepairTypeParam信息", notes = "删除RepairTypeParam信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String companyId, @RequestParam String typeId) {
        repairTypeParamService.deleteByPrimaryKey(companyId, typeId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询RepairTypeParam信息", notes = "查询RepairTypeParam信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RepairTypeParamEntity> selectByPrimaryKey(@RequestParam String companyId, @RequestParam String typeId) {
        RepairTypeParamEntity entity = repairTypeParamService.selectByPrimaryKey(companyId, typeId);
        return succMsgData(entity);
    }
}