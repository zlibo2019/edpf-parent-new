package com.weds.edwx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.PrintUtil;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edpf.core.entity.AcDepEntity;
import com.weds.edpf.core.service.AcDepService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.constant.DineParams;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.*;
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
import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author
 * @Description 订餐订单管理
 * @Date 2019-10-22
 */
@RestController
@RequestMapping(value = "/edDineOrder")
@Api(value = "订餐订单管理", description = "订餐订单管理")
public class EdDineOrderController extends BaseController {
    @Resource
    private EdDineOrderService edDineOrderService;

    @Resource
    private EdDineOrderInfoService edDineOrderInfoService;

    @Resource
    private EdDineOrderDetailService edDineOrderDetailService;

    @Resource
    private EdDineAddressService edDineAddressService;

    @Resource
    private EdDineMealService edDineMealService;

    @Resource
    private EdDineMealSettingService edDineMealSettingService;

    @Resource
    private EdDineFoodService edDineFoodService;

    @Resource
    private AcDepService acDepService;

    @Resource
    private CommProcService commProcService;

    @Resource
    private ScmParams scmParams;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private SettingParams settingParams;

    @Resource
    private DineParams dineParams;

    @Resource
    private UserService userService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增订餐订单信息", notes = "新增订餐订单信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody @Valid EdDineOrderEntity record) {
        String orderId;
        synchronized (EdDineOrderController.class) {
            orderId = StringUtils.getOrderNumber("", 2);
            // orderId = "D" + System.currentTimeMillis();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Date date = new Date();
        float orderPrice = 0;
        int orderNum = 0;

        EdDineFoodEntity selectEntity = new EdDineFoodEntity();
        Date orderDate = null;
        try {
            orderDate = DateUtils.parseDate(record.getOrderDate(), DateUtils.DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        selectEntity.setWeekNum("W" + DateUtils.getWeekNum(orderDate));
        selectEntity.setDate(orderDate);
        List<EdDineFoodEntity> menuList = edDineFoodService.selectFoodListNew(selectEntity);

        Date orderDateTemp = null;
        try {
            orderDateTemp = DateUtils.parseDate(record.getOrderDate(), DateUtils.DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateDiff = DateUtils.getDateDiffDay(DateUtils.getCurrentDateTimeZero(), orderDateTemp);

        List<EdDineOrderInfoEntity> printList = new ArrayList<>();
        JSONArray jsonArray = JSONObject.parseArray(record.getOrderInfo());
        for (int i = 0; i < jsonArray.size(); i++) {
            List<EdDineOrderDetailEntity> printSubList = new ArrayList<>();
            float mealPrice = 0;
            int mealNum = 0;
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String mealId = jsonObject.getString("mealId");
            JSONArray foods = jsonObject.getJSONArray("foods");
            EdDineOrderInfoEntity edDineOrderInfoEntity = new EdDineOrderInfoEntity();
            for (int j = 0; j < foods.size(); j++) {
                String foodId = foods.getJSONObject(j).getString("foodId");
                int foodNum = foods.getJSONObject(j).getIntValue("foodOrder");
                for (EdDineFoodEntity edDineFoodEntity : menuList) {
                    if (edDineFoodEntity.getFoodId().equals(foodId) && edDineFoodEntity.getMealId().equals(mealId)) {
                        int num = edDineFoodEntity.getFoodNum() - edDineFoodEntity.getFoodUse();
                        if (num < foodNum) {
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            EdDineMealEntity edDineMealEntity = edDineMealService.selectByPrimaryKey(mealId);
                            EdDineFoodEntity entity = edDineFoodService.selectByPrimaryKey(foodId);
                            return message("612", edDineMealEntity.getMealName() + "-" + entity.getFoodName() + "份数不足");
                        }
                        int orderDays = edDineFoodEntity.getOrderDays();
                        if (dateDiff + 1 > orderDays) {
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            return message("610", "订餐预订时间未到");
                        }

                        if (dateDiff < 0) {
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            return message("611", "已过订餐预订时间");
                        }

                        if (dateDiff == 0 && "1".equals(record.getCancelFlag())) {
                            String orderEnd = edDineFoodEntity.getOrderEnd().replace(":", "");
                            String currTime = DateUtils.formatDate(new Date(), "HHmm");
                            if (Integer.parseInt(currTime) > Integer.parseInt(orderEnd)) {
                                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                                return message("611", "已过订餐预订时间");
                            }
                        }
                        break;
                    }
                }

                orderNum = orderNum + foodNum;
                mealNum = mealNum + foodNum;

                EdDineOrderDetailEntity entity = new EdDineOrderDetailEntity();
                entity.setId(StringUtils.getUUID());
                entity.setCtDate(date);
                entity.setLtDate(date);
                entity.setCtUser(record.getUserSerial());
                entity.setLtUser(record.getUserSerial());
                entity.setOrderId(orderId);
                entity.setMealId(mealId);
                entity.setOrderState("1");

                int merchantId = foods.getJSONObject(j).getIntValue("merchantId");
                AcDepEntity acDepEntity = acDepService.selectByPrimaryKey(merchantId);
                entity.setMerchantId(merchantId + "");
                entity.setMerchantName(acDepEntity.getDepName());

                EdDineFoodEntity edDineFoodEntity = edDineFoodService.selectByPrimaryKey(foodId);
                entity.setFoodId(foodId);
                entity.setFoodName(edDineFoodEntity.getFoodName());

                BigDecimal foodPrice = edDineFoodEntity.getFoodPrice().multiply(edDineFoodEntity.getFoodDiscount());
                orderPrice = orderPrice + foodPrice.floatValue() * foodNum;
                mealPrice = mealPrice + foodPrice.floatValue() * foodNum;
                entity.setFoodPrice(foodPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
                entity.setFoodNum(foodNum);
                edDineOrderDetailService.insertSelective(entity);

                printSubList.add(entity);
            }

            edDineOrderInfoEntity.setCtDate(date);
            edDineOrderInfoEntity.setLtDate(date);
            edDineOrderInfoEntity.setCtUser(record.getUserSerial());
            edDineOrderInfoEntity.setLtUser(record.getUserSerial());
            edDineOrderInfoEntity.setMealId(mealId);
            edDineOrderInfoEntity.setMealState("1");
            edDineOrderInfoEntity.setFoodNum(mealNum);
            edDineOrderInfoEntity.setMealPrice(new BigDecimal(mealPrice).setScale(2, BigDecimal.ROUND_HALF_UP));
            edDineOrderInfoEntity.setOrderId(orderId);
            edDineOrderInfoEntity.setSubOrderId(orderId + "M" + i);
            EdDineMealEntity edDineMealEntity = edDineMealService.selectByPrimaryKey(mealId);
            edDineOrderInfoEntity.setMealName(edDineMealEntity.getMealName());
            edDineOrderInfoService.insertSelective(edDineOrderInfoEntity);

            edDineOrderInfoEntity.setList(printSubList);
            printList.add(edDineOrderInfoEntity);

            // 消费扣费接口
            CommProcEntity commProcEntity = new CommProcEntity();
            commProcEntity.setProcName("link_update_dcxf");
            List<Object> list = new ArrayList<>();
            list.add(Integer.parseInt(record.getUserSerial()));
            list.add(DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
            list.add(record.getPlaceId());
            list.add(new BigDecimal(mealPrice * 100).setScale(2, BigDecimal.ROUND_HALF_UP));
            list.add(scmParams.getChargeback());
            list.add(orderId + "M" + i);
            list.add(edDineMealEntity.getMealName());
            commProcEntity.setParams(list);
            List<List<Map>> resp = commProcService.loadProcData(commProcEntity);
            String result = resp.get(0).get(0).get("").toString();
            if (!"0".equals(result)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                if ("1".equals(result)) {
                    return message("610", "账户余额不足");
                } else if ("2".equals(result)) {
                    return message("611", "人员档案异常");
                } else {
                    return failMsg();
                }
            }
        }

        if (record.getOrderPrice().floatValue() != orderPrice) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return message("613", "菜品价格发生改变");
        }

        AcDepEntity acDepEntity = acDepService.selectByPrimaryKey(Integer.parseInt(record.getPlaceId()));
        record.setPlaceName(acDepEntity.getDepName());
        record.setCtDate(date);
        record.setLtDate(date);
        record.setCtUser(record.getUserSerial());
        record.setLtUser(record.getUserSerial());
        record.setOrderId(orderId);
        record.setOrderState("1");
        record.setOrderPrice(new BigDecimal(orderPrice).setScale(2, BigDecimal.ROUND_HALF_UP));
        record.setFoodNum(orderNum);
        record.setOrderId(orderId);
        if ("1".equals(record.getSendFlag()) && !StringUtils.isBlank(record.getAddrId())) {
            EdDineAddressEntity entity = edDineAddressService.selectByPrimaryKey(record.getAddrId());
            record.setAddrName(entity.getAddressName());
        }
        edDineOrderService.insertSelective(record);

        // CommProcEntity commProcEntity = new CommProcEntity();
        // commProcEntity.setProcName("real_update_dcxf");
        // List<Object> list = new ArrayList<>();
        // list.add(Integer.parseInt(record.getUserSerial()));
        // list.add(DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
        // list.add(record.getPlaceId());
        // list.add(record.getOrderPrice().floatValue() * 100);
        // list.add(scmParams.getChargeback());
        // commProcEntity.setParams(list);
        // List<List<Map>> resp = commProcService.loadProcData(commProcEntity);
        // String result = resp.get(0).get(0).get("").toString();
        // if (!"0".equals(result)) {
        //     TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        //     if ("1".equals(result)) {
        //         return message("610", "账户余额不足");
        //     } else if ("2".equals(result)) {
        //         return message("611", "卡状态异常");
        //     } else if ("3".equals(result)) {
        //         return message("611", "人员档案异常");
        //     } else {
        //         return failMsg();
        //     }
        // }

        if ("1".equals(record.getSendFlag()) && dineParams.isPrintFlag()) {
            new Thread(() -> {
                UserEntity userEntity = userService.selectByPrimaryKey(Long.parseLong(record.getUserSerial()));
                EdDineAddressEntity edDineAddressEntity = edDineAddressService.selectByPrimaryKey(record.getAddrId());
                for (EdDineOrderInfoEntity edDineOrderInfoEntity : printList) {
                    DineOrderPrintEntity dineOrderPrintEntity = new DineOrderPrintEntity();
                    dineOrderPrintEntity.setTitle(userEntity.getUserDepname() + "-" + userEntity.getUserLname());
                    dineOrderPrintEntity.setMealName(edDineOrderInfoEntity.getMealName());
                    dineOrderPrintEntity.setOrderDate(DateUtils.formatDateTime(edDineOrderInfoEntity.getCtDate()));
                    dineOrderPrintEntity.setSendAddr(record.getAddrName());
                    dineOrderPrintEntity.setSendTime(edDineAddressEntity.getStartDate() + "-" + edDineAddressEntity.getEndDate());
                    dineOrderPrintEntity.setSendFlag(true);
                    dineOrderPrintEntity.setList(edDineOrderInfoEntity.getList());
                    dineOrderPrintEntity.setOrderPrice(edDineOrderInfoEntity.getMealPrice().toString());
                    PrintUtil.printSale(new DineOrderPrint(dineOrderPrintEntity, settingParams.getPrintWidth()), settingParams.getPrintWidth(), 10000);
                }
            }).start();
        }

        return succMsgData(orderId);
    }

    @Logs
    @ApiOperation(value = "查询订餐订单清单", notes = "查询订餐订单清单")
    @RequestMapping(value = "/selectOrderListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineOrderEntity>> selectOrderListPageByEntity(@RequestBody BasePageSearch<DineOrderReq> record) {
        setPageHelper(record);
        DineOrderReq entity = record.getSearch();
        if (entity == null) {
            entity = new DineOrderReq();
        }
        List<EdDineOrderEntity> list = edDineOrderService.selectOrderListPageByDate(entity);
        List<EdDineOrderEntity> orderList = edDineOrderService.selectOrderListPageByEntity(entity);

        dicFmtBean.DicFormat(orderList.toArray(new EdDineOrderEntity[0]), new String[]{"03002"});

        for (EdDineOrderEntity edDineOrderEntity : orderList) {
            if ("1".equals(edDineOrderEntity.getOrderState())) {
                edDineOrderEntity.setOperate("1");
                Date orderDateTemp = null;
                try {
                    orderDateTemp = DateUtils.parseDate(edDineOrderEntity.getOrderDate(), DateUtils.DATE_FORMAT);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long dateDiff = DateUtils.getDateDiffDay(DateUtils.getCurrentDateTimeZero(), orderDateTemp);

                if (dateDiff < 0 || dateDiff + 1 > edDineOrderEntity.getOrderDays()) {
                    edDineOrderEntity.setOperate("0");
                }

                if (dateDiff == 0) {
                    String orderEnd = edDineOrderEntity.getOrderEnd().replace(":", "");
                    String currTime = DateUtils.formatDate(new Date(), "HHmm");
                    if (Integer.parseInt(currTime) > Integer.parseInt(orderEnd)) {
                        edDineOrderEntity.setOperate("0");
                    }
                }
            } else {
                edDineOrderEntity.setOperate("0");
            }
        }

        for (EdDineOrderEntity edDineOrderEntity : list) {
            String orderId = edDineOrderEntity.getOrderId();
            edDineOrderEntity.setList(orderList.stream().filter(t -> t.getOrderId().equals(orderId)).collect(Collectors.toList()));
        }
        return succMsgData(new BaseCommPager<>(list));
    }

    @Logs
    @ApiOperation(value = "查询订餐订单详情", notes = "查询订餐订单详情")
    @RequestMapping(value = "/selectOrderDetail", method = RequestMethod.GET)
    public JsonResult<EdDineOrderEntity> selectOrderDetail(@RequestParam String orderId, String mealId) {
        EdDineOrderEntity edDineOrderEntity = edDineOrderService.selectByPrimaryKey(orderId);
        EdDineOrderInfoEntity edDineOrderInfoEntity = new EdDineOrderInfoEntity();
        edDineOrderInfoEntity.setOrderId(orderId);
        edDineOrderInfoEntity.setMealId(mealId);
        List<EdDineOrderInfoEntity> mealList = edDineOrderInfoService.selectListByEntity(edDineOrderInfoEntity);
        edDineOrderEntity.setMealList(mealList);

        if (!StringUtils.isBlank(mealId)) {
            edDineOrderEntity.setOrderState(mealList.get(0).getMealState());
            edDineOrderEntity.setOrderId(mealList.get(0).getSubOrderId());
            edDineOrderEntity.setOrderPrice(mealList.get(0).getMealPrice());
            edDineOrderEntity.setFoodNum(mealList.get(0).getFoodNum());

            if ("1".equals(mealList.get(0).getMealState())) {
                EdDineMealSettingEntity edDineMealSettingEntity = edDineMealSettingService.selectByPrimaryKey(edDineOrderEntity.getPlaceId(), null, mealId);
                edDineOrderEntity.setOperate("1");
                Date orderDateTemp = null;
                try {
                    orderDateTemp = DateUtils.parseDate(edDineOrderEntity.getOrderDate(), DateUtils.DATE_FORMAT);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long dateDiff = DateUtils.getDateDiffDay(DateUtils.getCurrentDateTimeZero(), orderDateTemp);

                if (dateDiff < 0 || dateDiff + 1 > edDineMealSettingEntity.getOrderDays()) {
                    edDineOrderEntity.setOperate("0");
                }

                if (dateDiff == 0) {
                    String orderEnd = edDineMealSettingEntity.getOrderEnd().replace(":", "");
                    String currTime = DateUtils.formatDate(new Date(), "HHmm");
                    if (Integer.parseInt(currTime) > Integer.parseInt(orderEnd)) {
                        edDineOrderEntity.setOperate("0");
                    }
                }
            } else {
                edDineOrderEntity.setOperate("0");
            }
        } else {
            edDineOrderEntity.setOperate("0");
        }

        EdDineOrderDetailEntity edDineOrderDetailEntity = new EdDineOrderDetailEntity();
        edDineOrderDetailEntity.setOrderId(orderId);
        edDineOrderDetailEntity.setMealId(mealId);
        List<EdDineOrderDetailEntity> detailList = edDineOrderDetailService.selectListByEntity(edDineOrderDetailEntity);
        for (EdDineOrderDetailEntity entity : detailList) {
            if (!StringUtils.isBlank(entity.getFoodPhoto())) {
                try {
                    if (!StringUtils.isBlank(scmParams.getScmUrl())) {
                        entity.setFoodPhoto(scmParams.getScmUrl() + entity.getFoodPhoto().replace("wwwroot", ""));
                    } else {
                        entity.setFoodPhoto(ImageUtils.imgToBase64(scmParams.getRootPath() + File.separator + entity.getFoodPhoto()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        edDineOrderEntity.setFoodList(detailList);
        return succMsgData(edDineOrderEntity);
    }

    @Logs
    @ApiOperation(value = "更新订餐订单信息", notes = "更新订餐订单信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineOrderEntity record) {
        record.setLtDate(new Date());
        edDineOrderService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单清单", notes = "查询订餐订单清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineOrderEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineOrderEntity> record) {
        setPageHelper(record);
        EdDineOrderEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineOrderEntity();
        }
        List<EdDineOrderEntity> list = edDineOrderService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineOrderEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询订餐订单列表", notes = "查询订餐订单列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineOrderEntity>> selectListByEntity(@RequestBody EdDineOrderEntity record) {
        List<EdDineOrderEntity> list = edDineOrderService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除订餐订单信息", notes = "删除订餐订单信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String orderId) {
        edDineOrderService.deleteByPrimaryKey(orderId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询订餐订单信息", notes = "查询订餐订单信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineOrderEntity> selectByPrimaryKey(@RequestParam String orderId) {
        EdDineOrderEntity entity = edDineOrderService.selectByPrimaryKey(orderId);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除订餐订单信息", notes = "批量删除订餐订单信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<EdDineOrderEntity> list) {
        List<EdDineOrderEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineOrderService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询最后一次订餐订单信息", notes = "查询最后一次订餐订单信息")
    @RequestMapping(value = "/selectLastOrder", method = RequestMethod.GET)
    public JsonResult<EdDineOrderEntity> selectLastOrder(@RequestParam String userSerial) {
        EdDineOrderEntity entity = edDineOrderService.selectLastOrder(userSerial);
        return succMsgData(entity);
    }
}