package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
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
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.VisUserNewEntity;
import com.weds.edwx.service.VisUserNewService;

/**
 * @Author sxm
 * @Description VisUserNew管理
 * @Date 2019-05-21
 */
@RestController
@RequestMapping(value = "/visUserNew")
@Api(value = "VisUserNew管理", description = "VisUserNew管理")
public class VisUserNewController extends BaseController {
    @Autowired
    private VisUserNewService visUserNewService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisUserNew信息", notes = "新增VisUserNew信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid VisUserNewEntity record) {
        visUserNewService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisUserNew信息", notes = "更新VisUserNew信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid VisUserNewEntity record) {
        visUserNewService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisUserNew清单", notes = "查询VisUserNew清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserNewEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisUserNewEntity> record) {
        setPageHelper(record);
        VisUserNewEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisUserNewEntity();
        }
        List<VisUserNewEntity> list = visUserNewService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisUserNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisUserNew列表", notes = "查询VisUserNew列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisUserNewEntity>> selectListByEntity(@RequestBody VisUserNewEntity record) {
        List<VisUserNewEntity> list = visUserNewService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisUserNew信息", notes = "删除VisUserNew信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long visSerial) {
        visUserNewService.deleteByPrimaryKey(visSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisUserNew信息", notes = "查询VisUserNew信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisUserNewEntity> selectByPrimaryKey(@RequestParam Long visSerial) {
        VisUserNewEntity entity = visUserNewService.selectByPrimaryKey(visSerial);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询VisUserNew信息", notes = "查询VisUserNew信息")
    @RequestMapping(value = "/selectByOpenId", method = RequestMethod.GET)
    public JsonResult<Object> selectByOpenId(@RequestParam String openId) {
        VisUserNewEntity entity = visUserNewService.selectByOpenId(openId);
        if (entity != null && !StringUtils.isBlank(entity.getFacePhoto())) {
            try {
                entity.setFacePhoto(ImageUtils.imgToBase64(entity.getFacePhoto()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisUserNew信息", notes = "关键字查询VisUserNew信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserNewEntity>> selectListByKeys(@RequestBody BasePageSearch<VisUserNewEntity> record) {
        setPageHelper(record);
        List<VisUserNewEntity> list = visUserNewService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisUserNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisUserNew信息", notes = "批量删除VisUserNew信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisUserNewEntity> list = JSONObject.parseArray(keys, VisUserNewEntity.class);
        List<VisUserNewEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visUserNewService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}