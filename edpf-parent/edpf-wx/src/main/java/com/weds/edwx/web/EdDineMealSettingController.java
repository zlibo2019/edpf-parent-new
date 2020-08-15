package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.EdDineMealSettingEntity;
import com.weds.edwx.service.EdDineMealSettingService;
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
 * @Description 餐别设置管理
 * @Date 2019-04-16
 */
@RestController
@RequestMapping(value = "/edDineMealSetting")
@Api(value = "餐别设置管理", description = "餐别设置管理")
public class EdDineMealSettingController extends BaseController {
    @Autowired
    private EdDineMealSettingService edDineMealSettingService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "获取订餐状态", notes = "获取订餐状态")
    @RequestMapping(value = "/selectDayState", method = RequestMethod.POST)
    public JsonResult<List<String>> selectDayState(@RequestBody EdDineMealSettingEntity record) {
        Date date = new Date();
        if (record == null) {
            record = new EdDineMealSettingEntity();
        }
        record.setUseFlag("1");
        List<EdDineMealSettingEntity> list = edDineMealSettingService.selectDineInfo(record);
        String currTime = DateUtils.formatDate(date, "HHmm");
        boolean flag = false;
        int len = 0;
        for (EdDineMealSettingEntity entity : list) {
            int days = entity.getOrderDays() == null ? 0 : entity.getOrderDays();
            len = Math.max(len, days);
            if (!flag) {
                String endTime = entity.getOrderEnd().replace(":", "");
                flag = Integer.parseInt(currTime) <= Integer.parseInt(endTime);
            }
        }

        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i == 0 && !flag) {
                continue;
            }
            dateList.add(DateUtils.formatDate(DateUtils.addDays(date, i), DateUtils.DATE_FORMAT));
        }
        return succMsgData(dateList);
    }

    @Logs
    @ApiOperation(value = "获取所选日期餐别", notes = "获取所选日期餐别")
    @RequestMapping(value = "/selectDayMeal", method = RequestMethod.POST)
    public JsonResult<List<EdDineMealSettingEntity>> selectDayMeal(@RequestBody EdDineMealSettingEntity record) {
        Date currDate = DateUtils.getCurrentDateTimeZero();
        if (currDate.getTime() > record.getDate().getTime()) {
            return failMsg("订餐日期小于当前日期");
        }
        record.setUseFlag("1");
        List<EdDineMealSettingEntity> list = edDineMealSettingService.selectDineInfo(record);
        String currTime = DateUtils.formatDate(new Date(), "HHmm");
        for (EdDineMealSettingEntity entity : list) {
            entity.setOperate("1");
            String endTime = entity.getOrderEnd().replace(":", "");
            if (currDate.getTime() == record.getDate().getTime() && Integer.parseInt(currTime) > Integer.parseInt(endTime)) {
                entity.setOperate("0");
            }
        }
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "新增餐别设置信息", notes = "新增餐别设置信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineMealSettingEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineMealSettingService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新餐别设置信息", notes = "更新餐别设置信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineMealSettingEntity record) {
        record.setLtDate(new Date());
        edDineMealSettingService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询餐别设置清单", notes = "查询餐别设置清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMealSettingEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineMealSettingEntity> record) {
        setPageHelper(record);
        EdDineMealSettingEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineMealSettingEntity();
        }
        List<EdDineMealSettingEntity> list = edDineMealSettingService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineMealSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询餐别设置列表", notes = "查询餐别设置列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineMealSettingEntity>> selectListByEntity(@RequestBody EdDineMealSettingEntity record) {
        List<EdDineMealSettingEntity> list = edDineMealSettingService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除餐别设置信息", notes = "删除餐别设置信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String placeId, @RequestParam String merchantId, @RequestParam String mealId) {
        edDineMealSettingService.deleteByPrimaryKey(placeId, merchantId, mealId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询餐别设置信息", notes = "查询餐别设置信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineMealSettingEntity> selectByPrimaryKey(@RequestParam String placeId, @RequestParam String merchantId, @RequestParam String mealId) {
        EdDineMealSettingEntity entity = edDineMealSettingService.selectByPrimaryKey(placeId, merchantId, mealId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询餐别设置信息", notes = "关键字查询餐别设置信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMealSettingEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineMealSettingEntity> record) {
        setPageHelper(record);
        List<EdDineMealSettingEntity> list = edDineMealSettingService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineMealSettingEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除餐别设置信息", notes = "批量删除餐别设置信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineMealSettingEntity> list = JSONObject.parseArray(keys, EdDineMealSettingEntity.class);
        List<EdDineMealSettingEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineMealSettingService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}