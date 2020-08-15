package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.RptInfoEntity;
import com.weds.edpf.core.service.RptInfoService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.rpt.constants.RptParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 报表模板管理管理
 * @Date 2019-05-13
 */
@RestController
@RequestMapping(value = "/rptInfo")
@Api(value = "报表模板管理管理", description = "报表模板管理管理")
public class RptInfoController extends BaseController {
    @Autowired
    private RptInfoService rptInfoService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private RptParams rptParams;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "上传报表模板", notes = "上传报表模板")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonResult<Object> upload(@RequestBody MultipartFile multipartFile, @RequestParam String name) {
        if (multipartFile != null) {
            String fileName = name + ".jasper";
            File file = new File(rptParams.getTemplatePath() + File.separator + fileName);
            file.deleteOnExit();
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return succMsgData(fileName);
        } else {
            return succMsg();
        }
    }

    @Logs
    @ApiOperation(value = "下载报表模板", notes = "下载报表模板")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam String rptId) {
        RptInfoEntity rptInfoEntity = rptInfoService.selectByPrimaryKey(rptId);
        String path = rptParams.getTemplatePath() + File.separator + rptInfoEntity.getRptTemplate();
        try {
            response.setHeader("content-disposition", "attachment;filename=" +
                    URLEncoder.encode(rptInfoEntity.getRptTemplate(), "UTF-8"));
            FileInputStream fis = new FileInputStream(path);
            OutputStream out = response.getOutputStream();
            IOUtils.copy(fis, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Logs
    @ApiOperation(value = "新增报表模板管理信息", notes = "新增报表模板管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid RptInfoEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        rptInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新报表模板管理信息", notes = "更新报表模板管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid RptInfoEntity record) {
        record.setLtDate(new Date());
        rptInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询报表模板管理清单", notes = "查询报表模板管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RptInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RptInfoEntity> record) {
        setPageHelper(record);
        RptInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RptInfoEntity();
        }
        List<RptInfoEntity> list = rptInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new RptInfoEntity[0]), new String[]{"01010", "01001"});
        return succMsgData(new BaseCommPager<RptInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询报表模板管理列表", notes = "查询报表模板管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RptInfoEntity>> selectListByEntity(@RequestBody RptInfoEntity record) {
        List<RptInfoEntity> list = rptInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new RptInfoEntity[0]), new String[]{"01010", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除报表模板管理信息", notes = "删除报表模板管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String rptId) {
        rptInfoService.deleteByPrimaryKey(rptId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询报表模板管理信息", notes = "查询报表模板管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RptInfoEntity> selectByPrimaryKey(@RequestParam String rptId) {
        RptInfoEntity entity = rptInfoService.selectByPrimaryKey(rptId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询报表模板管理信息", notes = "关键字查询报表模板管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RptInfoEntity>> selectListByKeys(@RequestBody BasePageSearch<RptInfoEntity> record) {
        setPageHelper(record);
        List<RptInfoEntity> list = rptInfoService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new RptInfoEntity[0]), new String[]{"01010", "01001"});
        return succMsgData(new BaseCommPager<RptInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除报表模板管理信息", notes = "批量删除报表模板管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<RptInfoEntity> list = JSONObject.parseArray(keys, RptInfoEntity.class);
        List<RptInfoEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                rptInfoService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}