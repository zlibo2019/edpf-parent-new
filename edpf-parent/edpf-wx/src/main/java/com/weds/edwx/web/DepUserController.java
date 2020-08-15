package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

import com.weds.edwx.entity.DepUserEntity;
import com.weds.edwx.service.DepUserService;

/**
 * @Author
 * @Description DepUser管理
 * @Date 2019-09-09
 */
@RestController
@RequestMapping(value = "/depUser")
@Api(value = "DepUser管理", description = "DepUser管理")
public class DepUserController extends BaseController {
    @Resource
    private DepUserService depUserService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DepUser信息", notes = "新增DepUser信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid DepUserEntity record) {
        depUserService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DepUser信息", notes = "更新DepUser信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid DepUserEntity record) {
        depUserService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DepUser清单", notes = "查询DepUser清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DepUserEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DepUserEntity> record) {
        setPageHelper(record);
        DepUserEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DepUserEntity();
        }
        List<DepUserEntity> list = depUserService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DepUserEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询DepUser列表", notes = "查询DepUser列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DepUserEntity>> selectListByEntity(@RequestBody DepUserEntity record) {
        List<DepUserEntity> list = depUserService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DepUser信息", notes = "删除DepUser信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        depUserService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DepUser信息", notes = "查询DepUser信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DepUserEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        DepUserEntity entity = depUserService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除DepUser信息", notes = "批量删除DepUser信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<DepUserEntity> list) {
        List<DepUserEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                depUserService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增DepUser信息", notes = "批量新增DepUser信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<DepUserEntity> list = JSONObject.parseArray(data, DepUserEntity.class);
        depUserService.insertBatch(list);
        return succMsg();
    }
}