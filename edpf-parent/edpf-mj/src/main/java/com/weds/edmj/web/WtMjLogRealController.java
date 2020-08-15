package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.WtMjLogRealEntity;
import com.weds.edmj.service.WtMjLogRealService;
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
 * @Description 门禁管理的基本日志管理
 * @Date 2019-08-08
 */
@RestController
@RequestMapping(value = "/wtMjLogReal")
@Api(value = "门禁管理的基本日志管理", description = "门禁管理的基本日志管理")
public class WtMjLogRealController extends BaseController {
    @Autowired
    private WtMjLogRealService wtMjLogRealService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增门禁管理的基本日志信息", notes = "新增门禁管理的基本日志信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid WtMjLogRealEntity record) {
        wtMjLogRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新门禁管理的基本日志信息", notes = "更新门禁管理的基本日志信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid WtMjLogRealEntity record) {
        wtMjLogRealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门禁管理的基本日志清单", notes = "查询门禁管理的基本日志清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<WtMjLogRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<WtMjLogRealEntity> record) {
        setPageHelper(record);
        WtMjLogRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new WtMjLogRealEntity();
        }
        List<WtMjLogRealEntity> list = wtMjLogRealService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new WtMjLogRealEntity[0]), new String[]{"04013", "04014", "04012"});
        return succMsgData(new BaseCommPager<WtMjLogRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody WtMjLogRealEntity record) {
        List<WtMjLogRealEntity> list = wtMjLogRealService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new WtMjLogRealEntity[0]), new String[]{"04013", "04014", "04012"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询门禁管理的基本日志列表", notes = "查询门禁管理的基本日志列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<WtMjLogRealEntity>> selectListByEntity(@RequestBody WtMjLogRealEntity record) {
        List<WtMjLogRealEntity> list = wtMjLogRealService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new WtMjLogRealEntity[0]), new String[]{"04013", "04014", "04012"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除门禁管理的基本日志信息", notes = "删除门禁管理的基本日志信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        wtMjLogRealService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门禁管理的基本日志信息", notes = "查询门禁管理的基本日志信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<WtMjLogRealEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        WtMjLogRealEntity entity = wtMjLogRealService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除门禁管理的基本日志信息", notes = "批量删除门禁管理的基本日志信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<WtMjLogRealEntity> list) {
        List<WtMjLogRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                wtMjLogRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增门禁管理的基本日志信息", notes = "批量新增门禁管理的基本日志信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<WtMjLogRealEntity> list = JSONObject.parseArray(data, WtMjLogRealEntity.class);
        wtMjLogRealService.insertBatch(list);
        return succMsg();
    }
}