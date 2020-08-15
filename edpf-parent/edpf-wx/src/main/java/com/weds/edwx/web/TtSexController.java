package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.TtSexEntity;
import com.weds.edwx.service.TtSexService;
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
 * @Description TtSex管理
 * @Date 2019-04-19
 */
@RestController
@RequestMapping(value = "/ttSex")
@Api(value = "TtSex管理", description = "TtSex管理")
public class TtSexController extends BaseController {
    @Autowired
    private TtSexService ttSexService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增TtSex信息", notes = "新增TtSex信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid TtSexEntity record) {
        ttSexService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新TtSex信息", notes = "更新TtSex信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid TtSexEntity record) {
        ttSexService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询TtSex清单", notes = "查询TtSex清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<TtSexEntity>> selectListPageByEntity(@RequestBody BasePageSearch<TtSexEntity> record) {
        setPageHelper(record);
        TtSexEntity entity = record.getSearch();
        if (entity == null) {
            entity = new TtSexEntity();
        }
        List<TtSexEntity> list = ttSexService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<TtSexEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询TtSex列表", notes = "查询TtSex列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<TtSexEntity>> selectListByEntity(@RequestBody TtSexEntity record) {
        List<TtSexEntity> list = ttSexService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除TtSex信息", notes = "删除TtSex信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Short ttOrder) {
        ttSexService.deleteByPrimaryKey(ttOrder);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询TtSex信息", notes = "查询TtSex信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<TtSexEntity> selectByPrimaryKey(@RequestParam Short ttOrder) {
        TtSexEntity entity = ttSexService.selectByPrimaryKey(ttOrder);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询TtSex信息", notes = "关键字查询TtSex信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<TtSexEntity>> selectListByKeys(@RequestBody BasePageSearch<TtSexEntity> record) {
        setPageHelper(record);
        List<TtSexEntity> list = ttSexService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<TtSexEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除TtSex信息", notes = "批量删除TtSex信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<TtSexEntity> list = JSONObject.parseArray(keys, TtSexEntity.class);
        List<TtSexEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                ttSexService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}