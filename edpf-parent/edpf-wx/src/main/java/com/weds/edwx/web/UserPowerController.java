package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.UserPowerEntity;
import com.weds.edwx.service.UserPowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description UserPower管理
 * @Date 2019-10-09
 */
@RestController
@RequestMapping(value = "/userPower")
@Api(value = "UserPower管理", description = "UserPower管理")
public class UserPowerController extends BaseController {
    @Resource
    private UserPowerService userPowerService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增UserPower信息", notes = "新增UserPower信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid UserPowerEntity record) {
        userPowerService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新UserPower信息", notes = "更新UserPower信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid UserPowerEntity record) {
        userPowerService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询UserPower清单", notes = "查询UserPower清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserPowerEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserPowerEntity> record) {
        setPageHelper(record);
        UserPowerEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserPowerEntity();
        }
        List<UserPowerEntity> list = userPowerService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserPowerEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询UserPower列表", notes = "查询UserPower列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserPowerEntity>> selectListByEntity(@RequestBody UserPowerEntity record) {
        List<UserPowerEntity> list = userPowerService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除UserPower信息", notes = "删除UserPower信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long userSerial) {
        userPowerService.deleteByPrimaryKey(userSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询UserPower信息", notes = "查询UserPower信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserPowerEntity> selectByPrimaryKey(@RequestParam Long userSerial) {
        UserPowerEntity entity = userPowerService.selectByPrimaryKey(userSerial);
        return succMsgData(entity);
    }
}