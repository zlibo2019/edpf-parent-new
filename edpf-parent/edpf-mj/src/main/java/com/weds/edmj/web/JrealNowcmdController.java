package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.JrealNowcmdEntity;
import com.weds.edmj.service.JrealNowcmdService;

/**
 * @Author sxm
 * @Description JrealNowcmd管理
 * @Date 2019-07-31
 */
@RestController
@RequestMapping(value = "/jrealNowcmd")
@Api(value = "JrealNowcmd管理", description = "JrealNowcmd管理")
public class JrealNowcmdController extends BaseController {
    @Autowired
    private JrealNowcmdService jrealNowcmdService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "门操作（远程开门、强制常开闭等）", notes = "门操作（远程开门、强制常开闭等）")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid JrealNowcmdEntity record) {
        jrealNowcmdService.doorOperator(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取强制常开常闭门数", notes = "获取强制常开常闭门数")
    @RequestMapping(value = "/getForceCount", method = RequestMethod.POST)
    public JsonResult<Object> getForceCount(@RequestBody @Valid JrealNowcmdEntity record) {
        Map<String, Integer> forceMap = jrealNowcmdService.selectForceCount(record);
        return succMsgData(forceMap);
    }

    @Logs
    @ApiOperation(value = "关键字查询JrealNowcmd信息", notes = "关键字查询JrealNowcmd信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JrealNowcmdEntity>> selectListByKeys(@RequestBody BasePageSearch<JrealNowcmdEntity> record) {
        setPageHelper(record);
        List<JrealNowcmdEntity> list = jrealNowcmdService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<JrealNowcmdEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量新增JrealNowcmd信息", notes = "批量新增JrealNowcmd信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<JrealNowcmdEntity> list = JSONObject.parseArray(data, JrealNowcmdEntity.class);
        jrealNowcmdService.insertBatch(list);
        return succMsg();
    }
}