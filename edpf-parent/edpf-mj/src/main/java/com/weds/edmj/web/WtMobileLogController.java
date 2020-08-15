package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.WtMobileLogEntity;
import com.weds.edmj.service.WtMobileLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description 手机门禁日志管理
 * @Date 2019-08-08
 */
@RestController
@RequestMapping(value = "/wtMobileLog")
@Api(value = "手机门禁日志管理", description = "手机门禁日志管理")
public class WtMobileLogController extends BaseController {
    @Autowired
    private WtMobileLogService wtMobileLogService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增手机门禁日志信息", notes = "新增手机门禁日志信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid WtMobileLogEntity record) {
        wtMobileLogService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新手机门禁日志信息", notes = "更新手机门禁日志信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid WtMobileLogEntity record) {
        wtMobileLogService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询手机门禁日志清单", notes = "查询手机门禁日志清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<WtMobileLogEntity>> selectListPageByEntity(@RequestBody BasePageSearch<WtMobileLogEntity> record) {
        setPageHelper(record);
        WtMobileLogEntity entity = record.getSearch();
        if (entity == null) {
            entity = new WtMobileLogEntity();
        }
        List<WtMobileLogEntity> list = wtMobileLogService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new WtMobileLogEntity[0]), new String[]{"04011", "04012"});
        return succMsgData(new BaseCommPager<WtMobileLogEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody WtMobileLogEntity record) {
        List<WtMobileLogEntity> list = wtMobileLogService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new WtMobileLogEntity[0]), new String[]{"04011", "04012"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询手机门禁日志列表", notes = "查询手机门禁日志列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<WtMobileLogEntity>> selectListByEntity(@RequestBody WtMobileLogEntity record) {
        List<WtMobileLogEntity> list = wtMobileLogService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new WtMobileLogEntity[0]), new String[]{"04011", "04012"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除手机门禁日志信息", notes = "删除手机门禁日志信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        wtMobileLogService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询手机门禁日志信息", notes = "查询手机门禁日志信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<WtMobileLogEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        WtMobileLogEntity entity = wtMobileLogService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除手机门禁日志信息", notes = "批量删除手机门禁日志信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<WtMobileLogEntity> list) {
        List<WtMobileLogEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                wtMobileLogService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增手机门禁日志信息", notes = "批量新增手机门禁日志信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<WtMobileLogEntity> list = JSONObject.parseArray(data, WtMobileLogEntity.class);
        wtMobileLogService.insertBatch(list);
        return succMsg();
    }
}