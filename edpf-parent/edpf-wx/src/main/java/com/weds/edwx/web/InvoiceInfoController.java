package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.InvoiceInfoEntity;
import com.weds.edwx.service.InvoiceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description InvoiceInfo管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/invoiceInfo")
@Api(value = "InvoiceInfo管理", description = "InvoiceInfo管理")
public class InvoiceInfoController extends BaseController {
    @Autowired
    private InvoiceInfoService invoiceInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private WeiXinParams weiXinParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增InvoiceInfo信息", notes = "新增InvoiceInfo信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody InvoiceInfoEntity record) {
        JSONObject jsonObject = uploadInvoiceInfo(record);
        if (jsonObject.getIntValue("errcode") == 0) {
            record.setSpareCol1(jsonObject.getString("url"));
            invoiceInfoService.insertSelective(record);
            return succMsg();
        } else {
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "更新InvoiceInfo信息", notes = "更新InvoiceInfo信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody InvoiceInfoEntity record) {
        JSONObject jsonObject = uploadInvoiceInfo(record);
        if (jsonObject.getIntValue("errcode") == 0) {
            record.setSpareCol1(jsonObject.getString("url"));
            int rtn = invoiceInfoService.updateByPrimaryKeySelective(record);
            if (rtn == 0) {
                invoiceInfoService.insertSelective(record);
            }
            return succMsg();
        } else {
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "查询InvoiceInfo清单", notes = "查询InvoiceInfo清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<InvoiceInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<InvoiceInfoEntity> record) {
        setPageHelper(record);
        InvoiceInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new InvoiceInfoEntity();
        }
        List<InvoiceInfoEntity> list = invoiceInfoService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<InvoiceInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询InvoiceInfo列表", notes = "查询InvoiceInfo列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<InvoiceInfoEntity>> selectListByEntity(@RequestBody InvoiceInfoEntity record) {
        List<InvoiceInfoEntity> list = invoiceInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除InvoiceInfo信息", notes = "删除InvoiceInfo信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        invoiceInfoService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询InvoiceInfo信息", notes = "查询InvoiceInfo信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<InvoiceInfoEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        InvoiceInfoEntity entity = invoiceInfoService.selectByPrimaryKey(xh);
        if (entity != null) {
            String qrCode = entity.getCompanyName() + "," + entity.getTaxNum() + "," + entity.getAddress() + ","
                    + entity.getPhone() + "," + entity.getAcctBank() + "," + entity.getAcctNum();
            entity.setQrCode(qrCode);
        }
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "上传微信发票信息", notes = "上传微信发票信息")
    @RequestMapping(value = "/uploadInfo", method = RequestMethod.GET)
    public JsonResult<String> uploadInfo(@RequestParam Integer xh) {
        InvoiceInfoEntity entity = invoiceInfoService.selectByPrimaryKey(xh);
        JSONObject jsonObject = uploadInvoiceInfo(entity);
        if (jsonObject.getIntValue("errcode") == 0) {
            return succMsgData(jsonObject.getString("url"));
        } else {
            return failMsg();
        }
    }

    private JSONObject uploadInvoiceInfo(InvoiceInfoEntity entity) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> param = new HashMap<>();
        param.put("title", entity.getCompanyName());
        param.put("phone", entity.getPhone());
        param.put("tax_no", entity.getTaxNum());
        param.put("addr", entity.getAddress());
        param.put("bank_type", entity.getAcctBank());
        param.put("bank_no", entity.getAcctNum());
        param.put("user_fill", 0);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(param, headers);
        return restTemplate.postForObject(weiXinParams.getInvoiceUrl(), request, JSONObject.class, SystemPool.getToken());
    }
}