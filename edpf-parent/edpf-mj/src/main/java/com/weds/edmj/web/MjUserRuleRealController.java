package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.ExcelUtils;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.entity.MjUserRuleRealEntity;
import com.weds.edmj.service.MjUserRuleRealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description 门授权定义表管理
 * @Date 2019-07-30
 */
@RestController
@RequestMapping(value = "/mjUserRuleReal")
@Api(value = "门授权定义表管理", description = "门授权定义表管理")
public class MjUserRuleRealController extends BaseController {
    @Autowired
    private MjUserRuleRealService mjUserRuleRealService;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增门授权", notes = "新增门授权")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MjUserRuleRealEntity record) {
        int re = mjUserRuleRealService.insertSelective(record);
        if (re == 0) {
            return failMsg("请选择授权规则");
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "复制门权限", notes = "复制门权限")
    @RequestMapping(value = "/copyGate", method = RequestMethod.POST)
    public JsonResult<Object> copyGateRule(@RequestBody MjUserRuleRealEntity record) {
        mjUserRuleRealService.copyGate(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "复制人权限", notes = "复制门权限")
    @RequestMapping(value = "/copyUser", method = RequestMethod.POST)
    public JsonResult<Object> copyUserRule(@RequestBody MjUserRuleRealEntity record) {
        mjUserRuleRealService.copyUser(record);
        return succMsg();
    }


    @Logs
    @ApiOperation(value = "查询门授权定义表清单", notes = "查询门授权定义表清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjUserRuleRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjUserRuleRealEntity> record) {
        setPageHelper(record);
        MjUserRuleRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjUserRuleRealEntity();
        }
        List<MjUserRuleRealEntity> list = mjUserRuleRealService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new MjUserRuleRealEntity[0]), new String[]{"04001"});
        return succMsgData(new BaseCommPager<MjUserRuleRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除门授权", notes = "批量删除门授权")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MjUserRuleRealEntity> list = JSONObject.parseArray(keys, MjUserRuleRealEntity.class);
        for (int i = 0; i < list.size(); i++) {
            MjUserRuleRealEntity mjUserRuleRealEntity = list.get(i);//做循环删除操作
            mjUserRuleRealService.deleteByPrimaryKey(mjUserRuleRealEntity);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody MjUserRuleRealEntity record) {
        List<MjUserRuleRealEntity> list = mjUserRuleRealService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new MjUserRuleRealEntity[0]), new String[]{"04001"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "导入授权", notes = "导入授权")
    @RequestMapping(value = "/importRight", method = RequestMethod.POST)
    public JsonResult<Object> importRight(@RequestBody MultipartFile file) {
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        ExcelUtils excelUtils = new ExcelUtils(type);
        try {
            List<Map> list = excelUtils.readWorkSheetValue(file.getInputStream(), 0, 2);
            for (int i = 0; i < list.size(); i++) {

            }
        } catch (IOException e) {
            return failMsg();
        }
        return succMsg();
    }
}