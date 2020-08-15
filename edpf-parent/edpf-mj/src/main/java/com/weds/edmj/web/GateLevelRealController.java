package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.GateLevelRealEntity;
import com.weds.edmj.service.GateLevelRealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description GateLevelReal管理
 * @Date 2019-08-08
 */
@RestController
@RequestMapping(value = "/gateLevelReal")
@Api(value = "GateLevelReal管理", description = "GateLevelReal管理")
public class GateLevelRealController extends BaseController {
    @Autowired
    private GateLevelRealService gateLevelRealService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增扩展授权", notes = "新增扩展授权")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody GateLevelRealEntity record) {
        gateLevelRealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询扩展授权列表", notes = "查询扩展授权列表")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<GateLevelRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<GateLevelRealEntity> record) {
        setPageHelper(record);
        GateLevelRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new GateLevelRealEntity();
        }
        List<GateLevelRealEntity> list = gateLevelRealService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new GateLevelRealEntity[0]), new String[]{"04015"});
        return succMsgData(new BaseCommPager<GateLevelRealEntity>(list));
    }


    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody GateLevelRealEntity record) {
        List<GateLevelRealEntity> list = gateLevelRealService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new GateLevelRealEntity[0]), new String[]{"04015"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "批量删除扩展授权信息", notes = "批量删除扩展授权信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<GateLevelRealEntity> list = JSONObject.parseArray(keys, GateLevelRealEntity.class);
        List<GateLevelRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                //下发全量0
                gateLevelRealService.insertFullUpdate0(delList);
                //下发全量1
                gateLevelRealService.insertFullUpdate1(delList);
                //批量删除
                gateLevelRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询是否有其他授权", notes = "查询是否有其他授权")
    @RequestMapping(value = "/selectOtherAuths", method = RequestMethod.POST)
    public JsonResult<String> selectOtherAuths(@RequestBody GateLevelRealEntity record) {
        int reData = gateLevelRealService.selectOtherAuth(record);
        return succMsgData(reData > 0 ? "1" : "0");
    }
}