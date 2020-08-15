package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.DictInfoEntity;
import com.weds.edpf.core.service.DictInfoService;
import com.weds.edpf.core.util.DicFmtBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

/**
 * @Author sxm
 * @Description 字典信息管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/dictInfo")
@Api(value = "字典信息管理", description = "字典信息管理")
public class DictInfoController extends BaseController {
    @Autowired
    private DictInfoService dictInfoService;

    private Logger log = LogManager.getLogger();

    @Autowired
    private DicFmtBean dicFmtBean;

    @Logs
    @ApiOperation(value = "新增字典信息信息", notes = "新增字典信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DictInfoEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        dictInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新字典信息信息", notes = "更新字典信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DictInfoEntity record) {
        record.setLtDate(new Date());
        dictInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询字典信息清单", notes = "查询字典信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DictInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DictInfoEntity> record) {
        setPageHelper(record);
        DictInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DictInfoEntity();
        }
        List<DictInfoEntity> list = dictInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new DictInfoEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<DictInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询字典信息列表", notes = "查询字典信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DictInfoEntity>> selectListByEntity(@RequestBody DictInfoEntity record) {
        List<DictInfoEntity> list = dictInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new DictInfoEntity[0]), new String[]{"01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除字典信息信息", notes = "删除字典信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String typeCode, @RequestParam String dicCode) {
        dictInfoService.deleteByPrimaryKey(typeCode, dicCode);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询字典信息信息", notes = "查询字典信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DictInfoEntity> selectByPrimaryKey(@RequestParam String typeCode, @RequestParam String dicCode) {
        DictInfoEntity entity = dictInfoService.selectByPrimaryKey(typeCode, dicCode);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询字典信息信息", notes = "关键字查询字典信息信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DictInfoEntity>> selectListByKeys(@RequestBody BasePageSearch<DictInfoEntity> record) {
        setPageHelper(record);
        List<DictInfoEntity> list = dictInfoService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new DictInfoEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<DictInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除字典信息信息", notes = "批量删除字典信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<DictInfoEntity> list = JSONObject.parseArray(keys, DictInfoEntity.class);
        // dictInfoService.deleteBatchByKeys(list);
        for (DictInfoEntity entity : list) {
            dictInfoService.deleteByPrimaryKey(entity.getTypeCode(), entity.getDicCode());
        }
        return succMsg();
    }
}