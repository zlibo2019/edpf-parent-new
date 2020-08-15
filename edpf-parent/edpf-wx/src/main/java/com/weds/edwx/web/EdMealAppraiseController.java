package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.EdMealAppraiseEntity;
import com.weds.edwx.entity.XfMenuJlEntity;
import com.weds.edwx.service.EdMealAppraiseService;
import com.weds.edwx.service.XfMenuJlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Description 就餐评价管理
 * @Date 2019-11-27
 */
@RestController
@RequestMapping(value = "/edMealAppraise")
@Api(value = "就餐评价管理", description = "就餐评价管理")
public class EdMealAppraiseController extends BaseController {
    @Resource
    private EdMealAppraiseService edMealAppraiseService;

    @Resource
    private XfMenuJlService xfMenuJlService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增就餐评价信息", notes = "新增就餐评价信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdMealAppraiseEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edMealAppraiseService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新就餐评价信息", notes = "更新就餐评价信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdMealAppraiseEntity record) {
        record.setLtDate(new Date());
        edMealAppraiseService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询就餐评价清单", notes = "查询就餐评价清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdMealAppraiseEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdMealAppraiseEntity> record) {
        setPageHelper(record);
        EdMealAppraiseEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdMealAppraiseEntity();
        }
        List<EdMealAppraiseEntity> list = edMealAppraiseService.selectListByEntity(entity);
        Date date = new Date();
        for (EdMealAppraiseEntity edMealAppraiseEntity : list) {
            edMealAppraiseEntity.setMealMoneyCn(edMealAppraiseEntity.getMealMoney().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString() + "元");
            long diff = DateUtils.getDateDiffSecond(edMealAppraiseEntity.getMealDate(), date);
            if (diff <= 7200 && "0".equals(edMealAppraiseEntity.getMealAppraise())) {
                edMealAppraiseEntity.setOperate("1");
            } else {
                edMealAppraiseEntity.setOperate("0");
            }
        }
        return succMsgData(new BaseCommPager<EdMealAppraiseEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询就餐评价列表", notes = "查询就餐评价列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdMealAppraiseEntity>> selectListByEntity(@RequestBody EdMealAppraiseEntity record) {
        List<EdMealAppraiseEntity> list = edMealAppraiseService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除就餐评价信息", notes = "删除就餐评价信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String bh) {
        edMealAppraiseService.deleteByPrimaryKey(bh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询就餐评价信息", notes = "查询就餐评价信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdMealAppraiseEntity> selectByPrimaryKey(@RequestParam String bh) {
        EdMealAppraiseEntity entity = edMealAppraiseService.selectByPrimaryKey(bh);
        if (entity != null) {
            entity.setMealMoneyCn(entity.getMealMoney().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString() + "元");
            XfMenuJlEntity xfMenuJlEntity = new XfMenuJlEntity();
            xfMenuJlEntity.setJlSerial(Integer.parseInt(entity.getJlBh()));
            xfMenuJlEntity.setUserSerial(Long.parseLong(entity.getUserSerial()));

            List<XfMenuJlEntity> list = xfMenuJlService.selectListByEntity(xfMenuJlEntity);
            for (XfMenuJlEntity menuJlEntity : list) {
                menuJlEntity.setNewMoneyCn(menuJlEntity.getNewMoney().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString() + "元");
            }
            entity.setList(list);
        }
        return succMsgData(entity);
    }
}