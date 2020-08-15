package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.coder.AES7Coder;
import com.weds.core.utils.coder.Coder;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edwx.entity.UserEntity;
import com.weds.edwx.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edwx.entity.VisDoorKeeperEntity;
import com.weds.edwx.service.VisDoorKeeperService;

/**
 * @Author sxm
 * @Description 门卫用户管理管理
 * @Date 2019-04-17
 */
@RestController
@RequestMapping(value = "/visDoorKeeper")
@Api(value = "门卫用户管理管理", description = "门卫用户管理管理")
public class VisDoorKeeperController extends BaseController {
    @Autowired
    private VisDoorKeeperService visDoorKeeperService;

    @Autowired
    private UserService userService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "门卫用户登录认证", notes = "门卫用户登录认证")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<VisDoorKeeperEntity> login(@RequestBody Map<String, String> map) {
        VisDoorKeeperEntity record = new VisDoorKeeperEntity();
        record.setUserNo(map.get("userNo"));
        try {
            // String userPwd = AES7Coder.decrypt(map.get("userPwd"), new String(Coder.decryptBASE64(wedsWxKey)));
            // record.setUserPwd(Coder.md5Hex(map.get("userNo") + map.get("userPwd")).toUpperCase());
            record.setUserPwd(map.get("userPwd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<VisDoorKeeperEntity> list = visDoorKeeperService.selectListByEntity(record);
        if (list.size() > 0) {
            VisDoorKeeperEntity visDoorKeeperEntity = list.get(0);
            UserEntity userEntity = new UserEntity();
            userEntity.setUserSerial(99999999L);
            visDoorKeeperEntity.setToken(userService.getToken(userEntity));
            return succMsgData(visDoorKeeperEntity);
        } else {
            return failMsg("用户名密码错误");
        }
    }

    @Logs
    @ApiOperation(value = "新增门卫用户管理信息", notes = "新增门卫用户管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid VisDoorKeeperEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        visDoorKeeperService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新门卫用户管理信息", notes = "更新门卫用户管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid VisDoorKeeperEntity record) {
        record.setLtDate(new Date());
        visDoorKeeperService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门卫用户管理清单", notes = "查询门卫用户管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisDoorKeeperEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisDoorKeeperEntity> record) {
        setPageHelper(record);
        VisDoorKeeperEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisDoorKeeperEntity();
        }
        List<VisDoorKeeperEntity> list = visDoorKeeperService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisDoorKeeperEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门卫用户管理列表", notes = "查询门卫用户管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisDoorKeeperEntity>> selectListByEntity(@RequestBody VisDoorKeeperEntity record) {
        List<VisDoorKeeperEntity> list = visDoorKeeperService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除门卫用户管理信息", notes = "删除门卫用户管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userNo) {
        visDoorKeeperService.deleteByPrimaryKey(userNo);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门卫用户管理信息", notes = "查询门卫用户管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisDoorKeeperEntity> selectByPrimaryKey(@RequestParam String userNo) {
        VisDoorKeeperEntity entity = visDoorKeeperService.selectByPrimaryKey(userNo);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询门卫用户管理信息", notes = "关键字查询门卫用户管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisDoorKeeperEntity>> selectListByKeys(@RequestBody BasePageSearch<VisDoorKeeperEntity> record) {
        setPageHelper(record);
        List<VisDoorKeeperEntity> list = visDoorKeeperService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisDoorKeeperEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除门卫用户管理信息", notes = "批量删除门卫用户管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisDoorKeeperEntity> list = JSONObject.parseArray(keys, VisDoorKeeperEntity.class);
        List<VisDoorKeeperEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visDoorKeeperService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}