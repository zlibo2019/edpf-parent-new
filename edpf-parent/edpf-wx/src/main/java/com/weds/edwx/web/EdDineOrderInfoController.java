package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edwx.entity.EdDineMealSettingEntity;
import com.weds.edwx.entity.EdDineOrderEntity;
import com.weds.edwx.entity.EdDineOrderInfoEntity;
import com.weds.edwx.service.EdDineMealSettingService;
import com.weds.edwx.service.EdDineOrderInfoService;
import com.weds.edwx.service.EdDineOrderService;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Description 订餐订单信息管理
 * @Date 2019-10-22
 */
@RestController
@RequestMapping(value = "/edDineOrderInfo")
@Api(value = "订餐订单信息管理", description = "订餐订单信息管理")
public class EdDineOrderInfoController extends BaseController {
    @Resource
    private EdDineOrderInfoService edDineOrderInfoService;

    @Resource
    private EdDineOrderService edDineOrderService;

    @Resource
    private EdDineMealSettingService edDineMealSettingService;

    @Resource
    private CommProcService commProcService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增订餐订单信息信息", notes = "新增订餐订单信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineOrderInfoEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineOrderInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新订餐订单信息信息", notes = "更新订餐订单信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineOrderInfoEntity record) {
        if ("2".equals(record.getMealState())) {
            EdDineOrderInfoEntity edDineOrderInfoEntity = edDineOrderInfoService.selectByPrimaryKey(record.getSubOrderId());
            EdDineOrderEntity edDineOrderEntity = edDineOrderService.selectByPrimaryKey(edDineOrderInfoEntity.getOrderId());
            EdDineMealSettingEntity edDineMealSettingEntity = edDineMealSettingService.selectByPrimaryKey(edDineOrderEntity.getPlaceId(), null, edDineOrderInfoEntity.getMealId());
            Date orderDateTemp = null;
            try {
                orderDateTemp = DateUtils.parseDate(edDineOrderEntity.getOrderDate(), DateUtils.DATE_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long dateDiff = DateUtils.getDateDiffDay(DateUtils.getCurrentDateTimeZero(), orderDateTemp);

            if (dateDiff < 0 || dateDiff + 1 > edDineMealSettingEntity.getOrderDays()) {
                return failMsg("撤单时间已过不可操作");
            }

            if (dateDiff == 0) {
                String orderEnd = edDineMealSettingEntity.getOrderEnd().replace(":", "");
                String currTime = DateUtils.formatDate(new Date(), "HHmm");
                if (Integer.parseInt(currTime) > Integer.parseInt(orderEnd)) {
                    return failMsg("撤单时间已过不可操作");
                }
            }

            // 消费撤单接口
            CommProcEntity commProcEntity = new CommProcEntity();
            commProcEntity.setProcName("link_update_dccx");
            List<Object> list = new ArrayList<>();
            list.add(Integer.parseInt(edDineOrderEntity.getUserSerial()));
            list.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            list.add(edDineOrderEntity.getPlaceId());
            list.add(edDineOrderInfoEntity.getMealPrice().floatValue() * 100);
            list.add(record.getSubOrderId());
            list.add(DateUtils.formatDate(edDineOrderEntity.getCtDate(), "yyyy-MM-dd"));
            commProcEntity.setParams(list);
            List<List<Map>> resp = commProcService.loadProcData(commProcEntity);
            String result = resp.get(0).get(0).get("").toString();
            if (!"0".equals(result)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                if ("1".equals(result)) {
                    return message("610", "订单号异常");
                } else if ("2".equals(result)) {
                    return message("611", "人员档案异常");
                } else {
                    return failMsg();
                }
            }
        }

        record.setLtDate(new Date());
        edDineOrderInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单信息清单", notes = "查询订餐订单信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineOrderInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineOrderInfoEntity> record) {
        setPageHelper(record);
        EdDineOrderInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineOrderInfoEntity();
        }
        List<EdDineOrderInfoEntity> list = edDineOrderInfoService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineOrderInfoEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询订餐订单信息列表", notes = "查询订餐订单信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineOrderInfoEntity>> selectListByEntity(@RequestBody EdDineOrderInfoEntity record) {
        List<EdDineOrderInfoEntity> list = edDineOrderInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除订餐订单信息信息", notes = "删除订餐订单信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String subOrderId) {
        edDineOrderInfoService.deleteByPrimaryKey(subOrderId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单信息信息", notes = "查询订餐订单信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineOrderInfoEntity> selectByPrimaryKey(@RequestParam String subOrderId) {
        EdDineOrderInfoEntity entity = edDineOrderInfoService.selectByPrimaryKey(subOrderId);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除订餐订单信息信息", notes = "批量删除订餐订单信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<EdDineOrderInfoEntity> list) {
        List<EdDineOrderInfoEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineOrderInfoService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

}