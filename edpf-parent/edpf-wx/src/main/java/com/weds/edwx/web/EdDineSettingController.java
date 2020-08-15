package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.EdDineSettingEntity;
import com.weds.edwx.service.EdDineSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 订餐配置管理
 * @Date 2019-04-12
 */
@RestController
@RequestMapping(value = "/edDineSetting")
@Api(value = "订餐配置管理", description = "订餐配置管理")
public class EdDineSettingController extends BaseController {
    @Autowired
    private EdDineSettingService edDineSettingService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增订餐配置信息", notes = "新增订餐配置信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineSettingEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineSettingService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新订餐配置信息", notes = "更新订餐配置信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineSettingEntity record) {
        record.setLtDate(new Date());
        edDineSettingService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐配置清单", notes = "查询订餐配置清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineSettingEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineSettingEntity> record) {
        setPageHelper(record);
        EdDineSettingEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineSettingEntity();
        }
        List<EdDineSettingEntity> list = edDineSettingService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询订餐配置列表", notes = "查询订餐配置列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineSettingEntity>> selectListByEntity(@RequestBody EdDineSettingEntity record) {
        List<EdDineSettingEntity> list = edDineSettingService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除订餐配置信息", notes = "删除订餐配置信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String placeId, @RequestParam String mealId) {
        edDineSettingService.deleteByPrimaryKey(placeId, mealId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐配置信息", notes = "查询订餐配置信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineSettingEntity> selectByPrimaryKey(@RequestParam String placeId, @RequestParam String mealId) {
        EdDineSettingEntity entity = edDineSettingService.selectByPrimaryKey(placeId, mealId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询订餐配置信息", notes = "关键字查询订餐配置信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineSettingEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineSettingEntity> record) {
        setPageHelper(record);
        List<EdDineSettingEntity> list = edDineSettingService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除订餐配置信息", notes = "批量删除订餐配置信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineSettingEntity> list = JSONObject.parseArray(keys, EdDineSettingEntity.class);
        List<EdDineSettingEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineSettingService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}