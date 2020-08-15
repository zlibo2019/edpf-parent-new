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

import com.weds.edwx.entity.EdDineOrderDetailEntity;
import com.weds.edwx.service.EdDineOrderDetailService;

/**
 * @Author
 * @Description 订餐订单详情管理
 * @Date 2019-10-22
 */
@RestController
@RequestMapping(value = "/edDineOrderDetail")
@Api(value = "订餐订单详情管理", description = "订餐订单详情管理")
public class EdDineOrderDetailController extends BaseController {
    @Resource
    private EdDineOrderDetailService edDineOrderDetailService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增订餐订单详情信息", notes = "新增订餐订单详情信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineOrderDetailEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineOrderDetailService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新订餐订单详情信息", notes = "更新订餐订单详情信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineOrderDetailEntity record) {
        record.setLtDate(new Date());
        edDineOrderDetailService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单详情清单", notes = "查询订餐订单详情清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineOrderDetailEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineOrderDetailEntity> record) {
        setPageHelper(record);
        EdDineOrderDetailEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineOrderDetailEntity();
        }
        List<EdDineOrderDetailEntity> list = edDineOrderDetailService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineOrderDetailEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询订餐订单详情列表", notes = "查询订餐订单详情列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineOrderDetailEntity>> selectListByEntity(@RequestBody EdDineOrderDetailEntity record) {
        List<EdDineOrderDetailEntity> list = edDineOrderDetailService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除订餐订单详情信息", notes = "删除订餐订单详情信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String id) {
        edDineOrderDetailService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单详情信息", notes = "查询订餐订单详情信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineOrderDetailEntity> selectByPrimaryKey(@RequestParam String id) {
        EdDineOrderDetailEntity entity = edDineOrderDetailService.selectByPrimaryKey(id);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除订餐订单详情信息", notes = "批量删除订餐订单详情信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<EdDineOrderDetailEntity> list) {
        List<EdDineOrderDetailEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineOrderDetailService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

}