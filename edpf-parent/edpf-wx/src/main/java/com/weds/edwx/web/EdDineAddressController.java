package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.EdDineAddressEntity;
import com.weds.edwx.service.EdDineAddressService;

/**
 * @Author sxm
 * @Description 送餐点定义管理
 * @Date 2019-04-12
 */
@RestController
@RequestMapping(value = "/edDineAddress")
@Api(value = "送餐点定义管理", description = "送餐点定义管理")
public class EdDineAddressController extends BaseController {
    @Autowired
    private EdDineAddressService edDineAddressService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增送餐点定义信息", notes = "新增送餐点定义信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineAddressEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineAddressService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新送餐点定义信息", notes = "更新送餐点定义信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineAddressEntity record) {
        record.setLtDate(new Date());
        edDineAddressService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询送餐点定义清单", notes = "查询送餐点定义清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineAddressEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineAddressEntity> record) {
        setPageHelper(record);
        EdDineAddressEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineAddressEntity();
        }
        List<EdDineAddressEntity> list = edDineAddressService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineAddressEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询送餐点定义列表", notes = "查询送餐点定义列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineAddressEntity>> selectListByEntity(@RequestBody EdDineAddressEntity record) {
        if (record == null) {
            record = new EdDineAddressEntity();
        }
        record.setUseFlag("1");
        List<EdDineAddressEntity> list = edDineAddressService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除送餐点定义信息", notes = "删除送餐点定义信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String addressId) {
        edDineAddressService.deleteByPrimaryKey(addressId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询送餐点定义信息", notes = "查询送餐点定义信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineAddressEntity> selectByPrimaryKey(@RequestParam String addressId) {
        EdDineAddressEntity entity = edDineAddressService.selectByPrimaryKey(addressId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询送餐点定义信息", notes = "关键字查询送餐点定义信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineAddressEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineAddressEntity> record) {
        setPageHelper(record);
        List<EdDineAddressEntity> list = edDineAddressService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineAddressEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除送餐点定义信息", notes = "批量删除送餐点定义信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineAddressEntity> list = JSONObject.parseArray(keys, EdDineAddressEntity.class);
        List<EdDineAddressEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineAddressService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}