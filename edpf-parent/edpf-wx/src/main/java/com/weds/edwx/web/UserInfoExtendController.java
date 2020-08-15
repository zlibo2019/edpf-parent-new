package com.weds.edwx.web;

import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
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

import com.weds.edwx.entity.UserInfoExtendEntity;
import com.weds.edwx.service.UserInfoExtendService;

/**
 * @Author sxm
 * @Description 用户扩展信息管理
 * @Date 2019-02-21
 */
@RestController
@RequestMapping(value = "/userInfoExtend")
@Api(value = "用户扩展信息管理", description = "用户扩展信息管理")
public class UserInfoExtendController extends BaseController {
    @Autowired
    private UserInfoExtendService userInfoExtendService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增用户扩展信息信息", notes = "新增用户扩展信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody UserInfoExtendEntity record) {
        record.setCtDate(DateUtils.getCurrentDateTime());
        record.setLtDate(DateUtils.getCurrentDateTime());
        userInfoExtendService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新用户扩展信息信息", notes = "更新用户扩展信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody UserInfoExtendEntity record) {
        record.setLtDate(DateUtils.getCurrentDateTime());
        userInfoExtendService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户扩展信息清单", notes = "查询用户扩展信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserInfoExtendEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserInfoExtendEntity> record) {
        setPageHelper(record);
        UserInfoExtendEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserInfoExtendEntity();
        }
        List<UserInfoExtendEntity> list = userInfoExtendService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserInfoExtendEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询用户扩展信息列表", notes = "查询用户扩展信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserInfoExtendEntity>> selectListByEntity(@RequestBody UserInfoExtendEntity record) {
        List<UserInfoExtendEntity> list = userInfoExtendService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除用户扩展信息信息", notes = "删除用户扩展信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userSerial) {
        userInfoExtendService.deleteByPrimaryKey(userSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户扩展信息信息", notes = "查询用户扩展信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserInfoExtendEntity> selectByPrimaryKey(@RequestParam String userSerial) {
        UserInfoExtendEntity entity = userInfoExtendService.selectByPrimaryKey(userSerial);
        try {
            if (entity != null && !StringUtils.isBlank(entity.getHeadImage())) {
                entity.setHeadImage(ImageUtils.imgToBase64(entity.getHeadImage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsgData(entity);
    }
}