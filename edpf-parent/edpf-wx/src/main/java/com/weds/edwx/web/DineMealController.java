package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.edwx.entity.DineMealEntity;
import com.weds.edwx.service.DineMealService;
import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author sxm
 * @Description DineMeal管理
 * @Date 2018-11-13
 */
@RestController
@RequestMapping(value = "/dineMeal")
@Api(value = "DineMeal管理", description = "DineMeal管理")
public class DineMealController extends BaseController {
    @Autowired
    private DineMealService dineMealService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DineMeal信息", notes = "新增DineMeal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DineMealEntity record) {
        dineMealService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DineMeal信息", notes = "更新DineMeal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DineMealEntity record) {
        dineMealService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineMeal清单", notes = "查询DineMeal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DineMealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DineMealEntity> record) {
        setPageHelper(record);
        DineMealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DineMealEntity();
        }
        List<DineMealEntity> list = dineMealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DineMealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询DineMeal列表", notes = "查询DineMeal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DineMealEntity>> selectListByEntity(@RequestBody DineMealEntity record) {
        if (record == null) {
            record = new DineMealEntity();
        }
        record.setMealBle(0);
        List<DineMealEntity> list = dineMealService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DineMeal信息", notes = "删除DineMeal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        dineMealService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineMeal信息", notes = "查询DineMeal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DineMealEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        DineMealEntity entity = dineMealService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }
}