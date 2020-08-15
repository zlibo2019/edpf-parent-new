package com.weds.edmj.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edmj.entity.WtMjMobileEntity;
import com.weds.edmj.service.WtMjMobileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description 配置手机开门人员管理
 * @Date 2019-08-07
 */
@RestController
@RequestMapping(value = "/wtMjMobile")
@Api(value = "配置手机开门人员管理", description = "配置手机开门人员管理")
public class WtMjMobileController extends BaseController {
    @Autowired
    private WtMjMobileService wtMjMobileService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增配置手机开门人员信息", notes = "新增配置手机开门人员信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid WtMjMobileEntity record) {
        wtMjMobileService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新配置手机开门人员信息", notes = "更新配置手机开门人员信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid WtMjMobileEntity record) {
        wtMjMobileService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询配置手机开门人员清单", notes = "查询配置手机开门人员清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<WtMjMobileEntity>> selectListPageByEntity(@RequestBody BasePageSearch<WtMjMobileEntity> record) {
        setPageHelper(record);
        WtMjMobileEntity entity = record.getSearch();
        if (entity == null) {
            entity = new WtMjMobileEntity();
        }
        List<WtMjMobileEntity> list = wtMjMobileService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<WtMjMobileEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询配置手机开门人员列表", notes = "查询配置手机开门人员列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<WtMjMobileEntity>> selectListByEntity(@RequestBody WtMjMobileEntity record) {
        List<WtMjMobileEntity> list = wtMjMobileService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除配置手机开门人员信息", notes = "删除配置手机开门人员信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        wtMjMobileService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询配置手机开门人员信息", notes = "查询配置手机开门人员信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<WtMjMobileEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        WtMjMobileEntity entity = wtMjMobileService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除配置手机开门人员信息", notes = "批量删除配置手机开门人员信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<WtMjMobileEntity> list) {
        List<WtMjMobileEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                wtMjMobileService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

}