package com.weds.edwx.web;

import com.weds.core.resp.JsonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.entity.NEWSEntity;
import com.weds.edwx.service.NEWSService;

/**
 * @Author sxm
 * @Description NEWS管理
 * @Date 2019-01-03
 */
@RestController
@RequestMapping(value = "/nEWS")
@Api(value = "NEWS管理", description = "NEWS管理")
public class NEWSController extends BaseController {
    @Autowired
    private NEWSService nEWSService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "查询消息列表", notes = "查询消息列表")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<NEWSEntity>> selectListPageByEntity(@RequestBody BasePageSearch<NEWSEntity> record) {
        setPageHelper(record);
        NEWSEntity entity = record.getSearch();
        if (entity == null) {
            entity = new NEWSEntity();
        }
        List<NEWSEntity> list = nEWSService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<NEWSEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询消息详情", notes = "查询消息详情")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<NEWSEntity> selectByPrimaryKey(@RequestBody NEWSEntity record) {
        NEWSEntity entity = nEWSService.selectByPrimaryKey(record.getXh());//获取消息详情
        if (entity == null) {
            return failMsg("您要查询的消息不存在，请刷新后重试");
        }
        nEWSService.insert(record);//插入已读信息
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询消息列表", notes = "查询消息列表")
    @RequestMapping(value = "/selectListPageByEntityNew", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<NEWSEntity>> selectListPageByEntityNew(@RequestBody BasePageSearch<NEWSEntity> record) {
        setPageHelper(record);
        NEWSEntity entity = record.getSearch();
        if (entity == null) {
            entity = new NEWSEntity();
        }
        List<NEWSEntity> list = nEWSService.selectListByEntityNew(entity);
        return succMsgData(new BaseCommPager<NEWSEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询消息详情", notes = "查询消息详情")
    @RequestMapping(value = "/selectByPrimaryKeyNew", method = RequestMethod.POST)
    public JsonResult<NEWSEntity> selectByPrimaryKeyNew(@RequestBody NEWSEntity record) {
        NEWSEntity entity = nEWSService.selectByPrimaryKeyNew(record.getXh());//获取消息详情
        if (entity == null) {
            return failMsg("您要查询的消息不存在，请刷新后重试");
        }
        nEWSService.insertNew(record);//插入已读信息
        return succMsgData(entity);
    }
}