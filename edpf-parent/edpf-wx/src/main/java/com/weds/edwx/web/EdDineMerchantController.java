package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.EdDineMerchantEntity;
import com.weds.edwx.service.EdDineMerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 商户定义管理
 * @Date 2019-04-12
 */
@RestController
@RequestMapping(value = "/edDineMerchant")
@Api(value = "商户定义管理", description = "商户定义管理")
public class EdDineMerchantController extends BaseController {
    @Autowired
    private EdDineMerchantService edDineMerchantService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增商户定义信息", notes = "新增商户定义信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineMerchantEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineMerchantService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新商户定义信息", notes = "更新商户定义信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineMerchantEntity record) {
        record.setLtDate(new Date());
        edDineMerchantService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询商户定义清单", notes = "查询商户定义清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMerchantEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineMerchantEntity> record) {
        setPageHelper(record);
        EdDineMerchantEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineMerchantEntity();
        }
        List<EdDineMerchantEntity> list = edDineMerchantService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineMerchantEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询商户定义列表", notes = "查询商户定义列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineMerchantEntity>> selectListByEntity(@RequestBody EdDineMerchantEntity record) {
        List<EdDineMerchantEntity> list = edDineMerchantService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除商户定义信息", notes = "删除商户定义信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String merchantId) {
        edDineMerchantService.deleteByPrimaryKey(merchantId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询商户定义信息", notes = "查询商户定义信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineMerchantEntity> selectByPrimaryKey(@RequestParam String merchantId) {
        EdDineMerchantEntity entity = edDineMerchantService.selectByPrimaryKey(merchantId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询商户定义信息", notes = "关键字查询商户定义信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMerchantEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineMerchantEntity> record) {
        setPageHelper(record);
        List<EdDineMerchantEntity> list = edDineMerchantService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineMerchantEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除商户定义信息", notes = "批量删除商户定义信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineMerchantEntity> list = JSONObject.parseArray(keys, EdDineMerchantEntity.class);
        List<EdDineMerchantEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineMerchantService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}