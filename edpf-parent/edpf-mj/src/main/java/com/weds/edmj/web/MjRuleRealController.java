package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edmj.entity.MjShidRealEntity;
import com.weds.edmj.service.MjShidRealService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.MjRuleRealEntity;
import com.weds.edmj.service.MjRuleRealService;

/**
 * @Author sxm
 * @Description MjRuleReal管理
 * @Date 2019-07-25
 */
@RestController
@RequestMapping(value = "/mjRuleReal")
@Api(value = "MjRuleReal管理", description = "MjRuleReal管理")
public class MjRuleRealController extends BaseController {
    @Autowired
    private MjRuleRealService mjRuleRealService;

    @Autowired
    private MjShidRealService mjShidRealService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MjRuleReal信息", notes = "新增MjRuleReal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MjRuleRealEntity record) {
        // if (record.getRuleNo() == 1) {
        //     return failMsg("默认规则不允许操作");
        // }

        mjRuleRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MjRuleReal信息", notes = "更新MjRuleReal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MjRuleRealEntity record) {
        if (record.getRuleNo() == 1) {
            return failMsg("默认规则不允许操作");
        }

        mjRuleRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjRuleReal清单", notes = "查询MjRuleReal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjRuleRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjRuleRealEntity> record) {
        setPageHelper(record);
        MjRuleRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjRuleRealEntity();
        }
        List<MjRuleRealEntity> list = mjRuleRealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MjRuleRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询MjRuleReal列表", notes = "查询MjRuleReal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MjRuleRealEntity>> selectListByEntity(@RequestBody MjRuleRealEntity record) {
        List<MjRuleRealEntity> list = mjRuleRealService.selectListByEntity(record);
        if (!record.isAdd()) {
            MjRuleRealEntity mjRuleRealEntity = new MjRuleRealEntity();
            mjRuleRealEntity.setRuleNo(0);
            mjRuleRealEntity.setRuleName("不指定");
            list.add(0, mjRuleRealEntity);
        }
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MjRuleReal信息", notes = "删除MjRuleReal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer ruleNo) {
        if (ruleNo == 1) {
            return failMsg("默认规则不允许操作");
        }

        MjShidRealEntity mjShidRealEntity = new MjShidRealEntity();
        mjShidRealEntity.setRuleNo(ruleNo);
        List<MjShidRealEntity> list = mjShidRealService.selectListByEntity(mjShidRealEntity);
        if (list.size() > 0) {
            return failMsg("规则存在时段设置不允许删除");
        }
        mjRuleRealService.deleteByPrimaryKey(ruleNo);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjRuleReal信息", notes = "查询MjRuleReal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MjRuleRealEntity> selectByPrimaryKey(@RequestParam Integer ruleNo) {
        if (ruleNo == 1) {
            return failMsg("默认规则不允许操作");
        }

        MjRuleRealEntity entity = mjRuleRealService.selectByPrimaryKey(ruleNo);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询MjRuleReal信息", notes = "关键字查询MjRuleReal信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjRuleRealEntity>> selectListByKeys(@RequestBody BasePageSearch<MjRuleRealEntity> record) {
        setPageHelper(record);
        List<MjRuleRealEntity> list = mjRuleRealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MjRuleRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除MjRuleReal信息", notes = "批量删除MjRuleReal信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MjRuleRealEntity> list = JSONObject.parseArray(keys, MjRuleRealEntity.class);
        List<MjRuleRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                mjRuleRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增MjRuleReal信息", notes = "批量新增MjRuleReal信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MjRuleRealEntity> list = JSONObject.parseArray(data, MjRuleRealEntity.class);
        mjRuleRealService.insertBatch(list);
        return succMsg();
    }
}