package com.weds.edmj.web;

import com.weds.edpf.core.service.CommonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.RightTempEntity;
import com.weds.edmj.service.RightTempService;

/**
 * @Author sxm
 * @Description RightTemp管理
 * @Date 2019-08-13
 */
@RestController
@RequestMapping(value = "/rightTemp")
@Api(value = "RightTemp管理", description = "RightTemp管理")
public class RightTempController extends BaseController {
    @Autowired
    private RightTempService rightTempService;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增临时授权信息", notes = "新增临时授权信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid RightTempEntity record) {
        rightTempService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询临时授权清单", notes = "查询临时授权清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RightTempEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RightTempEntity> record) {
        setPageHelper(record);
        RightTempEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RightTempEntity();
        }
        List<RightTempEntity> list = rightTempService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RightTempEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody RightTempEntity record) {
        List<RightTempEntity> list = rightTempService.selectListByEntity(record);
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "批量删除临时授权信息", notes = "批量删除临时授权信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<RightTempEntity> list) {
        List<RightTempEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                rightTempService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}