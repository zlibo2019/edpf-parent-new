package com.weds.edwx.web;

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
import com.weds.core.utils.DateUtils;

import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.entity.InfoFeedbackEntity;
import com.weds.edwx.service.InfoFeedbackService;

/**
 * @Author sxm
 * @Description InfoFeedback管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/infoFeedback")
@Api(value = "InfoFeedback管理", description = "InfoFeedback管理")
public class InfoFeedbackController extends BaseController {
    @Autowired
    private InfoFeedbackService infoFeedbackService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增InfoFeedback信息", notes = "新增InfoFeedback信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody InfoFeedbackEntity record) {
        record.setSj(new Date());
        record.setGlyNo(record.getUserSerial().toString());
        infoFeedbackService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新InfoFeedback信息", notes = "更新InfoFeedback信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody InfoFeedbackEntity record) {
        infoFeedbackService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询InfoFeedback清单", notes = "查询InfoFeedback清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<InfoFeedbackEntity>> selectListPageByEntity(@RequestBody BasePageSearch<InfoFeedbackEntity> record) {
        setPageHelper(record);
        InfoFeedbackEntity entity = record.getSearch();
        if (entity == null) {
            entity = new InfoFeedbackEntity();
        }
        List<InfoFeedbackEntity> list = infoFeedbackService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<InfoFeedbackEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询InfoFeedback列表", notes = "查询InfoFeedback列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<InfoFeedbackEntity>> selectListByEntity(@RequestBody InfoFeedbackEntity record) {
        List<InfoFeedbackEntity> list = infoFeedbackService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除InfoFeedback信息", notes = "删除InfoFeedback信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        infoFeedbackService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询InfoFeedback信息", notes = "查询InfoFeedback信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<InfoFeedbackEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        InfoFeedbackEntity entity = infoFeedbackService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }
}