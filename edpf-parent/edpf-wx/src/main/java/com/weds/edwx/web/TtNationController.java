package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.TtNationEntity;
import com.weds.edwx.service.TtNationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description TtNation管理
 * @Date 2019-04-19
 */
@RestController
@RequestMapping(value = "/ttNation")
@Api(value = "TtNation管理", description = "TtNation管理")
public class TtNationController extends BaseController {
    @Autowired
    private TtNationService ttNationService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增TtNation信息", notes = "新增TtNation信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid TtNationEntity record) {
        ttNationService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新TtNation信息", notes = "更新TtNation信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid TtNationEntity record) {
        ttNationService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询TtNation清单", notes = "查询TtNation清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<TtNationEntity>> selectListPageByEntity(@RequestBody BasePageSearch<TtNationEntity> record) {
        setPageHelper(record);
        TtNationEntity entity = record.getSearch();
        if (entity == null) {
            entity = new TtNationEntity();
        }
        List<TtNationEntity> list = ttNationService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<TtNationEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询TtNation列表", notes = "查询TtNation列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<TtNationEntity>> selectListByEntity(@RequestBody TtNationEntity record) {
        List<TtNationEntity> list = ttNationService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除TtNation信息", notes = "删除TtNation信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Short ttOrder) {
        ttNationService.deleteByPrimaryKey(ttOrder);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询TtNation信息", notes = "查询TtNation信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<TtNationEntity> selectByPrimaryKey(@RequestParam Short ttOrder) {
        TtNationEntity entity = ttNationService.selectByPrimaryKey(ttOrder);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询TtNation信息", notes = "关键字查询TtNation信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<TtNationEntity>> selectListByKeys(@RequestBody BasePageSearch<TtNationEntity> record) {
        setPageHelper(record);
        List<TtNationEntity> list = ttNationService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<TtNationEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除TtNation信息", notes = "批量删除TtNation信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<TtNationEntity> list = JSONObject.parseArray(keys, TtNationEntity.class);
        List<TtNationEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                ttNationService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}