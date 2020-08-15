package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.DineMealEntity;
import com.weds.edwx.entity.DineOrderEntity;
import com.weds.edwx.service.DineMealService;
import com.weds.edwx.service.DineOrderService;
import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description DineOrder管理
 * @Date 2018-11-13
 */
@RestController
@RequestMapping(value = "/dineOrder")
@Api(value = "DineOrder管理", description = "DineOrder管理")
public class DineOrderController extends BaseController {
    @Autowired
    private DineOrderService dineOrderService;

    @Autowired
    private DineMealService dineMealService;

    // @Autowired
    // private FastDFSService fastDFSService;
    //

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DineOrder信息", notes = "新增DineOrder信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DineOrderEntity record) {
        dineOrderService.insertSelective(record);

        // fastDFSService.getFile("group1", "M00/00/00/CgEAIVwPdN-AfanVAAiQfFy3oqM441.jpg");
        // try {
        //     FileOutputStream fos = new FileOutputStream("E:\\Users\\SSS\\Desktop\\1.jpg");
        //     InputStream is = fastDFSService.downFile("group1", "M00/00/00/CgEAIVwPdN-AfanVAAiQfFy3oqM441.jpg");
        //     IOUtils.write(IOUtils.toByteArray(is), fos);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DineOrder信息", notes = "更新DineOrder信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DineOrderEntity record) {
        record.setFoodBh("2019030509012060");
        int rtn = dineOrderService.updateByPrimaryKeySelective(record);
        if (rtn == 0) {
            record.setListBh(DateUtils.getCurrentDateTime("yyyyMMddHHmmssSSS").substring(0, 16));
            record.setSj(new Date());
            dineOrderService.insertSelective(record);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineOrder清单", notes = "查询DineOrder清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DineOrderEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DineOrderEntity> record) {
        setPageHelper(record);
        DineOrderEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DineOrderEntity();
        }

        List<DineOrderEntity> list = dineOrderService.selectDistinctListByEntity(entity);
        List<DineOrderEntity> listInfo = dineOrderService.selectListByEntity(entity);

        for (DineOrderEntity dineOrderEntity : list) {
            List<DineOrderEntity> subList = new ArrayList<>();
            for (DineOrderEntity orderEntity : listInfo) {
                String fmt = DateUtils.formatDate(orderEntity.getRq(), DateUtils.DATE_FORMAT);
                if (dineOrderEntity.getStrRq().equals(fmt)) {
                    subList.add(orderEntity);
                }
            }
            dineOrderEntity.setList(subList);
        }

        return succMsgData(new BaseCommPager<DineOrderEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询DineOrder列表", notes = "查询DineOrder列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DineOrderEntity>> selectListByEntity(@RequestBody DineOrderEntity record) {
        List<DineOrderEntity> list = dineOrderService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DineOrder信息", notes = "删除DineOrder信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        dineOrderService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DineOrder信息", notes = "查询DineOrder信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DineOrderEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        DineOrderEntity entity = dineOrderService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询用户DineOrder列表", notes = "查询用户DineOrder列表")
    @RequestMapping(value = "/selectListByCondition", method = RequestMethod.POST)
    public JsonResult<List<DineOrderEntity>> selectListByCondition(@RequestBody DineOrderEntity record) {
        record.setRq(DateUtils.getCurrentDateTimeZero());
        List<DineOrderEntity> list = dineOrderService.selectListByCondition(record);
        for (DineOrderEntity dineOrderEntity : list) {
            dineOrderEntity.setKey(DateUtils.formatDate(dineOrderEntity.getRq(), DateUtils.DATE_FORMAT) + dineOrderEntity.getMealBh());
        }
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "更新用户DineOrder信息", notes = "更新用户DineOrder信息")
    @RequestMapping(value = "/updateOrderByCondition", method = RequestMethod.POST)
    @ApiImplicitParam()
    public JsonResult<Object> updateOrderByCondition(@RequestBody DineOrderEntity record) {
        dineOrderService.updateOrderByCondition(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户订餐份数", notes = "查询用户订餐份数")
    @RequestMapping(value = "/selectDineNums", method = RequestMethod.POST)
    public JsonResult<DineOrderEntity> selectDineNums(@RequestBody DineOrderEntity record) {
        if (DateUtils.getCurrentDate().equals(DateUtils.formatDate(record.getRq(), DateUtils.DATE_FORMAT))) {
            DineMealEntity dineMealEntity = dineMealService.selectByMealBh(record.getMealBh());
            int jssj = Integer.parseInt(dineMealEntity.getJssj().replace(":", ""));
            int curr = Integer.parseInt(DateUtils.getCurrentTimeSimple());
            if (curr > jssj) {
                return failMsg("超过订餐可修改时间，不允许修改！");
            }
        }
        DineOrderEntity dineOrderEntity = dineOrderService.selectDineNums(record);
        return succMsgData(dineOrderEntity);
    }
}