package com.weds.edhy.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.jwt.JwtUtils;
import com.weds.edpf.core.service.UserBaseService;
import com.weds.edpf.core.service.WtModuleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;
import com.weds.edpf.core.service.CommonService;

import javax.servlet.http.HttpServletResponse;

import com.weds.edhy.entity.HyUserInfoEntity;
import com.weds.edhy.service.HyUserInfoService;

/**
 * @Author
 * @Description 会员附属信息管理
 * @Date 2019-10-08
 */
@RestController
@RequestMapping(value = "/hyUserInfo")
@Api(value = "会员附属信息管理", description = "会员附属信息管理")
public class HyUserInfoController extends BaseController {
    @Resource
    private HyUserInfoService hyUserInfoService;

    @Resource
    private UserBaseService userBaseService;

    @Resource
    private CommonService commonService;

    @Resource
    private WtModuleService wtModuleService;

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增会员附属信息信息", notes = "新增会员附属信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody @Valid HyUserInfoEntity record) {
        try {
            long userSerial = wtModuleService.selectSerialByModuleId("0002");
            record.setUserId(userSerial + "");
            record.setUserSerial(userSerial);
            userBaseService.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        hyUserInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新会员附属信息信息", notes = "更新会员附属信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid HyUserInfoEntity record) {
        record.setUserId(record.getUserSerial().toString());
        try {
            userBaseService.updateFaceOrPhoto(record);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }

        String gly = null;
        if (JwtUtils.getJwtData(request) != null) {
            gly = JwtUtils.getJwtData(request).getString("userSerial");
        }
        userBaseService.updateByPrimaryKeySelective(record, request.getRemoteAddr(), gly);
        hyUserInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询会员附属信息清单", notes = "查询会员附属信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<HyUserInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<HyUserInfoEntity> record) {
        setPageHelper(record);
        HyUserInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new HyUserInfoEntity();
        }
        List<HyUserInfoEntity> list = hyUserInfoService.selectListByEntity(entity);
        for (HyUserInfoEntity hyUserInfoEntity : list) {
            userBaseService.setUserBaseEntity(hyUserInfoEntity);
        }
        return succMsgData(new BaseCommPager<HyUserInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出会员附属信息信息", notes = "导出会员附属信息信息")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody HyUserInfoEntity record) {
        List<HyUserInfoEntity> list = hyUserInfoService.selectListByEntity(record);
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询会员附属信息列表", notes = "查询会员附属信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<HyUserInfoEntity>> selectListByEntity(@RequestBody HyUserInfoEntity record) {
        List<HyUserInfoEntity> list = hyUserInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除会员附属信息信息", notes = "删除会员附属信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @Transactional
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userId) {
        String gly = null;
        if (JwtUtils.getJwtData(request) != null) {
            gly = JwtUtils.getJwtData(request).getString("userSerial");
        }

        userBaseService.deleteByPrimaryKey(Long.parseLong(userId), request.getRemoteAddr(), gly);
        hyUserInfoService.deleteByPrimaryKey(userId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询会员附属信息信息", notes = "查询会员附属信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<HyUserInfoEntity> selectByPrimaryKey(@RequestParam String userId) {
        HyUserInfoEntity entity = hyUserInfoService.selectByPrimaryKey(userId);
        userBaseService.setUserBaseEntity(entity);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除会员附属信息信息", notes = "批量删除会员附属信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<HyUserInfoEntity> list) {
        List<HyUserInfoEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                hyUserInfoService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}