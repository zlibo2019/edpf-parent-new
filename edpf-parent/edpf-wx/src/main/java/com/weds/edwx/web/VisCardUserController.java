package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.VisCardUserEntity;
import com.weds.edwx.service.VisCardUserService;

/**
 * @Author sxm
 * @Description VisCardUser管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visCardUser")
@Api(value = "VisCardUser管理", description = "VisCardUser管理")
public class VisCardUserController extends BaseController {
    @Autowired
    private VisCardUserService visCardUserService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value = "/testInterface", method = RequestMethod.GET)
    public JsonResult<Object> selectByPrimaryKey(@RequestParam Long visSerial,@RequestParam Integer xh,
                                                 @RequestParam String areas,@RequestParam String visKssj,@RequestParam String visJssj,
                                                 @RequestParam String visCars) throws ParseException {
        Date visKssj1 = DateUtils.parseDate(visKssj,DateUtils.DATE_TIME_FORMAT);
        Date visJssj1 = DateUtils.parseDate(visJssj,DateUtils.DATE_TIME_FORMAT);
       Boolean fg = visCardUserService.cancelCardIncrement(xh,visSerial,areas);
        //visCardUserService.cancelCardPermission(visCars);
        String code = visCardUserService.getVisCodeStr(visSerial.toString(),visKssj1,visJssj1);
        if(fg){
            return succMsg("成功"+code);
        }
        return failMsg("失败");
    }
    @Logs
    @ApiOperation(value = "新增VisCardUser信息", notes = "新增VisCardUser信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisCardUserEntity record) {
        visCardUserService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisCardUser信息", notes = "更新VisCardUser信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisCardUserEntity record) {
        visCardUserService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisCardUser清单", notes = "查询VisCardUser清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisCardUserEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisCardUserEntity> record) {
        setPageHelper(record);
        VisCardUserEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisCardUserEntity();
        }
        List<VisCardUserEntity> list = visCardUserService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisCardUserEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisCardUser列表", notes = "查询VisCardUser列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisCardUserEntity>> selectListByEntity(@RequestBody VisCardUserEntity record) {
        List<VisCardUserEntity> list = visCardUserService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisCardUser信息", notes = "删除VisCardUser信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visCardUserService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisCardUser信息", notes = "查询VisCardUser信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisCardUserEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisCardUserEntity entity = visCardUserService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisCardUser信息", notes = "关键字查询VisCardUser信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisCardUserEntity>> selectListByKeys(@RequestBody BasePageSearch<VisCardUserEntity> record) {
        setPageHelper(record);
        List<VisCardUserEntity> list = visCardUserService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisCardUserEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisCardUser信息", notes = "批量删除VisCardUser信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisCardUserEntity> list = JSONObject.parseArray(keys, VisCardUserEntity.class);
        // visCardUserService.deleteBatchByKeys(list);
        for (VisCardUserEntity entity : list) {
            visCardUserService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }
}