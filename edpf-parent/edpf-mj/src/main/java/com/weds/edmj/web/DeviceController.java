package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.ControlRealEntity;
import com.weds.edmj.service.ControlRealService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.DeviceEntity;
import com.weds.edmj.service.DeviceService;

/**
 * @Author sxm
 * @Description Device管理
 * @Date 2019-07-31
 */
@RestController
@RequestMapping(value = "/device")
@Api(value = "Device管理", description = "Device管理")
public class DeviceController extends BaseController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ControlRealService controlRealService;

    @Autowired
    private DicFmtBean fmtBean;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "更新Device信息", notes = "更新Device信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid DeviceEntity record) {
        deviceService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门控器列表", notes = "查询门控器列表")
    @RequestMapping(value = "/selectControlList", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DeviceEntity>> selectControlList(@RequestBody BasePageSearch<DeviceEntity> record) {
        setPageHelper(record);
        DeviceEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DeviceEntity();
        }
        List<DeviceEntity> list = deviceService.selectControlList(entity);
        return succMsgData(new BaseCommPager<DeviceEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询考勤门禁一体机列表", notes = "查询考勤门禁一体机列表")
    @RequestMapping(value = "/selectKqList", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DeviceEntity>> selectKqList(@RequestBody BasePageSearch<DeviceEntity> record) {
        setPageHelper(record);
        DeviceEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DeviceEntity();
        }
        List<DeviceEntity> list = deviceService.selectKqList(entity);
        fmtBean.DicFormat(list.toArray(new DeviceEntity[0]), new String[]{"04007"});
        return succMsgData(new BaseCommPager<DeviceEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门控器继电器列表", notes = "查询门控器继电器列表")
    @RequestMapping(value = "/selectControlsList", method = RequestMethod.POST)
    public JsonResult<List<ControlRealEntity>> selectControlsList(@RequestBody DeviceEntity record) {
        List<ControlRealEntity> list = controlRealService.selectListByEntity(record);
        return succMsgData(list);
    }


    @Logs
    @ApiOperation(value = "查询Device列表", notes = "查询Device列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DeviceEntity>> selectListByEntity(@RequestBody DeviceEntity record) {
        List<DeviceEntity> list = deviceService.selectControlList(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除Device信息", notes = "删除Device信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String bh) {
        deviceService.deleteByPrimaryKey(bh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询Device信息", notes = "查询Device信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DeviceEntity> selectByPrimaryKey(@RequestParam String bh) {
        DeviceEntity entity = deviceService.selectByPrimaryKey(bh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询Device信息", notes = "关键字查询Device信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DeviceEntity>> selectListByKeys(@RequestBody BasePageSearch<DeviceEntity> record) {
        setPageHelper(record);
        List<DeviceEntity> list = deviceService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<DeviceEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除Device信息", notes = "批量删除Device信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<DeviceEntity> list = JSONObject.parseArray(keys, DeviceEntity.class);
        List<DeviceEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                deviceService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增Device信息", notes = "批量新增Device信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<DeviceEntity> list = JSONObject.parseArray(data, DeviceEntity.class);
        deviceService.insertBatch(list);
        return succMsg();
    }
}