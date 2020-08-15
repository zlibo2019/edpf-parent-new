package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;
import com.weds.edpf.core.util.DicFmtBean;


import com.weds.edpf.core.entity.RptParamsEntity;
import com.weds.edpf.core.service.RptParamsService;

/**
 * @Author sxm
 * @Description 报表模板参数管理
 * @Date 2019-05-15
 */
@RestController
@RequestMapping(value = "/rptParams")
@Api(value = "报表模板参数管理", description = "报表模板参数管理")
public class RptParamsController extends BaseController {
    @Autowired
    private RptParamsService rptParamsService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增报表模板参数信息", notes = "新增报表模板参数信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insertBatch(@RequestBody Map<String, String> paramMap) {
        String rptId = paramMap.get("rptId");
        rptParamsService.deleteByPrimaryKey(rptId);
        List<RptParamsEntity> list = JSONArray.parseArray(paramMap.get("rptParams"), RptParamsEntity.class);
        Date date = new Date();
        for (RptParamsEntity rptParamsEntity : list) {
            rptParamsEntity.setCtDate(date);
            rptParamsService.insertSelective(rptParamsEntity);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新报表模板参数信息", notes = "更新报表模板参数信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid RptParamsEntity record) {
        rptParamsService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询报表模板参数清单", notes = "查询报表模板参数清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RptParamsEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RptParamsEntity> record) {
        setPageHelper(record);
        RptParamsEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RptParamsEntity();
        }
        List<RptParamsEntity> list = rptParamsService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new RptParamsEntity[0]), new String[]{"01011", "01001"});
        return succMsgData(new BaseCommPager<RptParamsEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询报表模板参数列表", notes = "查询报表模板参数列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RptParamsEntity>> selectListByEntity(@RequestBody RptParamsEntity record) {
        record.setUseFlag("1");
        List<RptParamsEntity> list = rptParamsService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new RptParamsEntity[0]), new String[]{"01011", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除报表模板参数信息", notes = "删除报表模板参数信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String rptId) {
        rptParamsService.deleteByPrimaryKey(rptId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询报表模板参数信息", notes = "查询报表模板参数信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RptParamsEntity> selectByPrimaryKey(@RequestParam String rptId) {
        RptParamsEntity entity = rptParamsService.selectByPrimaryKey(rptId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询报表模板参数信息", notes = "关键字查询报表模板参数信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RptParamsEntity>> selectListByKeys(@RequestBody BasePageSearch<RptParamsEntity> record) {
        setPageHelper(record);
        List<RptParamsEntity> list = rptParamsService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new RptParamsEntity[0]), new String[]{"01011", "01001"});
        return succMsgData(new BaseCommPager<RptParamsEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除报表模板参数信息", notes = "批量删除报表模板参数信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<RptParamsEntity> list = JSONObject.parseArray(keys, RptParamsEntity.class);
        List<RptParamsEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                rptParamsService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}