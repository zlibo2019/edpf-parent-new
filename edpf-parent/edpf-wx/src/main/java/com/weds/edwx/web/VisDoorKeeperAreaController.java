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


import com.weds.edwx.entity.VisDoorKeeperAreaEntity;
import com.weds.edwx.service.VisDoorKeeperAreaService;

/**
 * @Author sxm
 * @Description 门卫用户区域管理管理
 * @Date 2019-04-17
 */
@RestController
@RequestMapping(value = "/visDoorKeeperArea")
@Api(value = "门卫用户区域管理管理", description = "门卫用户区域管理管理")
public class VisDoorKeeperAreaController extends BaseController {
    @Autowired
    private VisDoorKeeperAreaService visDoorKeeperAreaService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增门卫用户区域管理信息", notes = "新增门卫用户区域管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid VisDoorKeeperAreaEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        visDoorKeeperAreaService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新门卫用户区域管理信息", notes = "更新门卫用户区域管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid VisDoorKeeperAreaEntity record) {
        visDoorKeeperAreaService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门卫用户区域管理清单", notes = "查询门卫用户区域管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisDoorKeeperAreaEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisDoorKeeperAreaEntity> record) {
        setPageHelper(record);
        VisDoorKeeperAreaEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisDoorKeeperAreaEntity();
        }
        List<VisDoorKeeperAreaEntity> list = visDoorKeeperAreaService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisDoorKeeperAreaEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门卫用户区域管理列表", notes = "查询门卫用户区域管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisDoorKeeperAreaEntity>> selectListByEntity(@RequestBody VisDoorKeeperAreaEntity record) {
        List<VisDoorKeeperAreaEntity> list = visDoorKeeperAreaService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询门卫用户区域管理列表", notes = "查询门卫用户区域管理列表")
    @RequestMapping(value = "/selectAllListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisDoorKeeperAreaEntity>> selectAllListByEntity(@RequestBody VisDoorKeeperAreaEntity record) {
        List<VisDoorKeeperAreaEntity> list = visDoorKeeperAreaService.selectAllListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除门卫用户区域管理信息", notes = "删除门卫用户区域管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userNo, @RequestParam String areaNo) {
        visDoorKeeperAreaService.deleteByPrimaryKey(userNo, areaNo);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门卫用户区域管理信息", notes = "查询门卫用户区域管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisDoorKeeperAreaEntity> selectByPrimaryKey(@RequestParam String userNo, @RequestParam String areaNo) {
        VisDoorKeeperAreaEntity entity = visDoorKeeperAreaService.selectByPrimaryKey(userNo, areaNo);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询门卫用户区域管理信息", notes = "关键字查询门卫用户区域管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisDoorKeeperAreaEntity>> selectListByKeys(@RequestBody BasePageSearch<VisDoorKeeperAreaEntity> record) {
        setPageHelper(record);
        List<VisDoorKeeperAreaEntity> list = visDoorKeeperAreaService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisDoorKeeperAreaEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除门卫用户区域管理信息", notes = "批量删除门卫用户区域管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisDoorKeeperAreaEntity> list = JSONObject.parseArray(keys, VisDoorKeeperAreaEntity.class);
        List<VisDoorKeeperAreaEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visDoorKeeperAreaService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}