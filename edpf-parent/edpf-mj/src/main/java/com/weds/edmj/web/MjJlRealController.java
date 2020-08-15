package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.service.CommonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;
import com.weds.edpf.core.util.DicFmtBean;


import com.weds.edmj.entity.MjJlRealEntity;
import com.weds.edmj.service.MjJlRealService;

/**
 * @Author sxm
 * @Description 门通行记录表管理
 * @Date 2019-08-06
 */
@RestController
@RequestMapping(value = "/mjJlReal")
@Api(value = "门通行记录表管理", description = "门通行记录表管理")
public class MjJlRealController extends BaseController {
    @Autowired
    private MjJlRealService mjJlRealService;

    @Resource
    private CommonService commonService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增门通行记录表信息", notes = "新增门通行记录表信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MjJlRealEntity record) {
        mjJlRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新门通行记录表信息", notes = "更新门通行记录表信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MjJlRealEntity record) {
        mjJlRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门通行记录表清单", notes = "查询门通行记录表清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjJlRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjJlRealEntity> record) {
        setPageHelper(record);
        MjJlRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjJlRealEntity();
        }
        List<MjJlRealEntity> list = mjJlRealService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new MjJlRealEntity[0]), new String[]{"04010"});
        return succMsgData(new BaseCommPager<MjJlRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门通行记录表清单", notes = "查询门通行记录表清单")
    @RequestMapping(value = "/selectListByCondition", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjJlRealEntity>> selectListByCondition(@RequestBody BasePageSearch<MjJlRealEntity> record) {
        setPageHelper(record);
        MjJlRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjJlRealEntity();
        }
        List<MjJlRealEntity> list = mjJlRealService.selectListByCondition(entity);
        dicFmtBean.DicFormat(list.toArray(new MjJlRealEntity[0]), new String[]{"01011", "04001", "04002", "04010"});
        return succMsgData(new BaseCommPager<MjJlRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门通行记录表列表", notes = "查询门通行记录表列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MjJlRealEntity>> selectListByEntity(@RequestBody MjJlRealEntity record) {
        List<MjJlRealEntity> list = mjJlRealService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new MjJlRealEntity[0]), new String[]{"04010"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除门通行记录表信息", notes = "删除门通行记录表信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Date jlSj, @RequestParam Integer xh) {
        mjJlRealService.deleteByPrimaryKey(jlSj, xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门通行记录表信息", notes = "查询门通行记录表信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MjJlRealEntity> selectByPrimaryKey(@RequestParam Date jlSj, @RequestParam Integer xh) {
        MjJlRealEntity entity = mjJlRealService.selectByPrimaryKey(jlSj, xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除门通行记录表信息", notes = "批量删除门通行记录表信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<MjJlRealEntity> list) {
        List<MjJlRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                mjJlRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增门通行记录表信息", notes = "批量新增门通行记录表信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MjJlRealEntity> list = JSONObject.parseArray(data, MjJlRealEntity.class);
        mjJlRealService.insertBatch(list);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody MjJlRealEntity record) {
        List<MjJlRealEntity> list = mjJlRealService.selectListByCondition(record);
        dicFmtBean.DicFormat(list.toArray(new MjJlRealEntity[0]), new String[]{"01011", "04001", "04002", "04010"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }
}