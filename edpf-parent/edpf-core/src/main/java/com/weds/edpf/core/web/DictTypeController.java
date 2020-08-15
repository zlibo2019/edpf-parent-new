package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.DictTypeEntity;
import com.weds.edpf.core.service.DictTypeService;
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
 * @Description 字典类型管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/dictType")
@Api(value = "字典类型管理", description = "字典类型管理")
public class DictTypeController extends BaseController {
    @Autowired
    private DictTypeService dictTypeService;

    private Logger log = LogManager.getLogger();

    @Autowired
    private DicFmtBean dicFmtBean;

    @Logs
    @ApiOperation(value = "新增字典类型信息", notes = "新增字典类型信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DictTypeEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        dictTypeService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新字典类型信息", notes = "更新字典类型信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DictTypeEntity record) {
        record.setLtDate(new Date());
        dictTypeService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询字典类型清单", notes = "查询字典类型清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DictTypeEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DictTypeEntity> record) {
        setPageHelper(record);
        DictTypeEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DictTypeEntity();
        }
        List<DictTypeEntity> list = dictTypeService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new DictTypeEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<DictTypeEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询字典类型列表", notes = "查询字典类型列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DictTypeEntity>> selectListByEntity(@RequestBody DictTypeEntity record) {
        List<DictTypeEntity> list = dictTypeService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new DictTypeEntity[0]), new String[]{"01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除字典类型信息", notes = "删除字典类型信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String typeCode) {
        dictTypeService.deleteByPrimaryKey(typeCode);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询字典类型信息", notes = "查询字典类型信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DictTypeEntity> selectByPrimaryKey(@RequestParam String typeCode) {
        DictTypeEntity entity = dictTypeService.selectByPrimaryKey(typeCode);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询字典类型信息", notes = "关键字查询字典类型信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DictTypeEntity>> selectListByKeys(@RequestBody BasePageSearch<DictTypeEntity> record) {
        setPageHelper(record);
        List<DictTypeEntity> list = dictTypeService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new DictTypeEntity[0]), new String[]{"01001"});
        return succMsgData(new BaseCommPager<DictTypeEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除字典类型信息", notes = "批量删除字典类型信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<DictTypeEntity> list = JSONObject.parseArray(keys, DictTypeEntity.class);
        // dictTypeService.deleteBatchByKeys(list);
        for (DictTypeEntity entity : list) {
            dictTypeService.deleteByPrimaryKey(entity.getTypeCode());
        }
        return succMsg();
    }
}