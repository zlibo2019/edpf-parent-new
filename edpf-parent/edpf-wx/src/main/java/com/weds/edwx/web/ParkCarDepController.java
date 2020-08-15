package com.weds.edwx .web;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

import com.weds.edwx.entity .ParkCarDepEntity;
import com.weds.edwx.service .ParkCarDepService;

/**
 * @Author sxm
 * @Description ParkCarDep管理
 * @Date 2019-03-26
 */
@RestController
@RequestMapping(value="/parkCarDep")
@Api(value = "ParkCarDep管理", description = "ParkCarDep管理")
public class ParkCarDepController extends BaseController{
    @Autowired
    private ParkCarDepService parkCarDepService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增ParkCarDep信息", notes = "新增ParkCarDep信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody ParkCarDepEntity record) {
        parkCarDepService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新ParkCarDep信息", notes = "更新ParkCarDep信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody ParkCarDepEntity record) {
        parkCarDepService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询ParkCarDep清单", notes = "查询ParkCarDep清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<ParkCarDepEntity>> selectListPageByEntity(@RequestBody BasePageSearch<ParkCarDepEntity> record) {
        setPageHelper(record);
        ParkCarDepEntity entity = record.getSearch();
        if (entity == null) {
            entity = new ParkCarDepEntity();
        }
        List<ParkCarDepEntity> list = parkCarDepService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<ParkCarDepEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询ParkCarDep列表", notes = "查询ParkCarDep列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<ParkCarDepEntity>> selectListByEntity(@RequestBody ParkCarDepEntity record) {
        List<ParkCarDepEntity> list = parkCarDepService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除ParkCarDep信息", notes = "删除ParkCarDep信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer parkSerial) {
        parkCarDepService.deleteByPrimaryKey(parkSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询ParkCarDep信息", notes = "查询ParkCarDep信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<ParkCarDepEntity> selectByPrimaryKey(@RequestParam Integer parkSerial) {
        ParkCarDepEntity entity = parkCarDepService.selectByPrimaryKey(parkSerial);
        return succMsgData(entity);
    }
}