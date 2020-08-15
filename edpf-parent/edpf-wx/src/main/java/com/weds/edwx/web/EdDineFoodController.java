package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.entity.DictTypeEntity;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.entity.EdDineMenuEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.EdDineFoodEntity;
import com.weds.edwx.service.EdDineFoodService;

/**
 * @Author sxm
 * @Description 菜品定义管理
 * @Date 2019-04-12
 */
@RestController
@RequestMapping(value = "/edDineFood")
@Api(value = "菜品定义管理", description = "菜品定义管理")
public class EdDineFoodController extends BaseController {
    @Autowired
    private EdDineFoodService edDineFoodService;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Resource
    private ScmParams scmParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "获取菜品清单", notes = "获取菜品清单")
    @RequestMapping(value = "/selectFoodList", method = RequestMethod.POST)
    public JsonResult<Object> selectFoodList(@RequestBody EdDineFoodEntity record) {
        long dateDiff = DateUtils.getDateDiffDay(DateUtils.getCurrentDateTimeZero(), record.getDate());
        record.setWeekNum("W" + DateUtils.getWeekNum(record.getDate()));
        // List<EdDineFoodEntity> list = edDineFoodService.selectFoodList(record);
        List<EdDineFoodEntity> list = edDineFoodService.selectFoodListNew(record);
        dicFmtBean.DicFormat(list.toArray(new EdDineFoodEntity[0]), new String[]{"03001"});
        List<DictTypeEntity> typeList = new ArrayList<>();
        for (EdDineFoodEntity edDineFoodEntity : list) {
            int num = edDineFoodEntity.getFoodNum() - edDineFoodEntity.getFoodUse();
            int orderDays = edDineFoodEntity.getOrderDays();
            if (dateDiff < 0 || dateDiff + 1 > orderDays) {
                edDineFoodEntity.setOperate("0");
            } else if (dateDiff == 0) {
                String orderEnd = edDineFoodEntity.getOrderEnd().replace(":", "");
                String currTime = DateUtils.formatDate(new Date(), "HHmm");
                if (Integer.parseInt(currTime) > Integer.parseInt(orderEnd)) {
                    edDineFoodEntity.setOperate("0");
                } else {
                    if (num > 0) {
                        edDineFoodEntity.setOperate("1");
                    } else {
                        edDineFoodEntity.setOperate("0");
                    }
                }
            } else {
                if (num > 0) {
                    edDineFoodEntity.setOperate("1");
                } else {
                    edDineFoodEntity.setOperate("0");
                }
            }
            String foodPhoto = edDineFoodEntity.getFoodPhoto();
            if (!StringUtils.isBlank(foodPhoto)) {
                try {
                    if (!StringUtils.isBlank(scmParams.getScmUrl())) {
                        edDineFoodEntity.setFoodPhoto(scmParams.getScmUrl() + edDineFoodEntity.getFoodPhoto().replace("wwwroot", ""));
                    } else {
                        edDineFoodEntity.setFoodPhoto(ImageUtils.imgToBase64(scmParams.getRootPath() + File.separator
                                + edDineFoodEntity.getFoodPhoto()));
                    }
                    // edDineFoodEntity.setFoodPhoto("./" + edDineFoodEntity.getFoodPhoto());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            edDineFoodEntity.setFoodPrice(edDineFoodEntity.getFoodPrice().multiply(edDineFoodEntity.getFoodDiscount()));
            List temp = typeList.stream().filter(t -> t.getTypeCode().equals(edDineFoodEntity.getFoodType())).collect(Collectors.toList());
            if (temp.size() == 0) {
                DictTypeEntity foodType = new DictTypeEntity();
                foodType.setTypeCode(edDineFoodEntity.getFoodType());
                foodType.setTypeName(edDineFoodEntity.getDicFmtMap().get("foodTypeCn"));
                typeList.add(foodType);
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("typeList", typeList);
        map.put("menuList", list);
        return succMsgData(map);
    }

    @Logs
    @ApiOperation(value = "新增菜品定义信息", notes = "新增菜品定义信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineFoodEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineFoodService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新菜品定义信息", notes = "更新菜品定义信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineFoodEntity record) {
        record.setLtDate(new Date());
        edDineFoodService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜品定义清单", notes = "查询菜品定义清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineFoodEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineFoodEntity> record) {
        setPageHelper(record);
        EdDineFoodEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineFoodEntity();
        }
        List<EdDineFoodEntity> list = edDineFoodService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineFoodEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询菜品定义列表", notes = "查询菜品定义列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineFoodEntity>> selectListByEntity(@RequestBody EdDineFoodEntity record) {
        List<EdDineFoodEntity> list = edDineFoodService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除菜品定义信息", notes = "删除菜品定义信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String foodId) {
        edDineFoodService.deleteByPrimaryKey(foodId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜品定义信息", notes = "查询菜品定义信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineFoodEntity> selectByPrimaryKey(@RequestParam String foodId) {
        EdDineFoodEntity entity = edDineFoodService.selectByPrimaryKey(foodId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询菜品定义信息", notes = "关键字查询菜品定义信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineFoodEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineFoodEntity> record) {
        setPageHelper(record);
        List<EdDineFoodEntity> list = edDineFoodService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineFoodEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除菜品定义信息", notes = "批量删除菜品定义信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineFoodEntity> list = JSONObject.parseArray(keys, EdDineFoodEntity.class);
        List<EdDineFoodEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineFoodService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}