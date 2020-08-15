package com.weds.edmj.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.JmonitorLogEntity;
import com.weds.edmj.service.JmonitorLogService;

/**
 * @Author sxm
 * @Description JmonitorLog管理
 * @Date 2019-08-14
 */
@RestController
@RequestMapping(value = "/jmonitorLog")
@Api(value = "JmonitorLog管理", description = "JmonitorLog管理")
public class JmonitorLogController extends BaseController {
    @Autowired
    private JmonitorLogService jmonitorLogService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "查询JmonitorLog清单", notes = "查询JmonitorLog清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JmonitorLogEntity>> selectListPageByEntity(@RequestBody BasePageSearch<JmonitorLogEntity> record) {
        setPageHelper(record);
        JmonitorLogEntity entity = record.getSearch();
        if (entity == null) {
            entity = new JmonitorLogEntity();
        }
        List<JmonitorLogEntity> list = jmonitorLogService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<JmonitorLogEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询实时监控记录列表", notes = "查询实时监控记录列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<JmonitorLogEntity>> selectListByEntity(@RequestBody JmonitorLogEntity record) {
        List<JmonitorLogEntity> list = jmonitorLogService.selectListByEntity(record);
        return succMsgData(list);
    }
}