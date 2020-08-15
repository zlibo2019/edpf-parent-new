package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.service.WeiXinService;
import com.weds.edwx.service.UserService;
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


import com.weds.edwx.entity.VisUserEntity;
import com.weds.edwx.service.VisUserService;

/**
 * @Author sxm
 * @Description VisUser管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visUser")
@Api(value = "VisUser管理", description = "VisUser管理")
public class VisUserController extends BaseController {
    @Autowired
    private VisUserService visUserService;

    @Autowired
    private WeiXinService weiXinService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisUser信息", notes = "新增VisUser信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody VisUserEntity record) {
        visUserService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新VisUser信息", notes = "更新VisUser信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisUserEntity record) {
        visUserService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisUser清单", notes = "查询VisUser清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisUserEntity> record) {
        setPageHelper(record);
        VisUserEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisUserEntity();
        }
        List<VisUserEntity> list = visUserService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<VisUserEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisUser列表", notes = "查询VisUser列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisUserEntity>> selectListByEntity(@RequestBody VisUserEntity record) {
        List<VisUserEntity> list = visUserService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisUser信息", notes = "删除VisUser信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String openId) {
        visUserService.deleteByPrimaryKey(openId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "PC端查询VisUser信息", notes = "PC端查询VisUser信息")
    @RequestMapping(value = "/selectByCardId", method = RequestMethod.GET)
    public JsonResult<VisUserEntity> selectByCardId(@RequestParam String visNo) {
        VisUserEntity visUserEntity = visUserService.selectByCardId(visNo);
        try {
            if (visUserEntity != null) {
                if (!StringUtils.isBlank(visUserEntity.getFacePhoto())) {
                    visUserEntity.setFacePhoto(ImageUtils.imgToBase64(visUserEntity.getFacePhoto()));
                }

                if (!StringUtils.isBlank(visUserEntity.getCardPhoto())) {
                    visUserEntity.setCardPhoto(ImageUtils.imgToBase64(visUserEntity.getCardPhoto()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succMsgData(visUserEntity);
    }

    @Logs
    @ApiOperation(value = "查询VisUser信息", notes = "查询VisUser信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisUserEntity> selectByPrimaryKey(@RequestParam String openId) {
        JSONObject json = weiXinService.getWxUserInfo(openId);
        String subScribe = "0";
        if (json != null) {
            subScribe = json.getString("subscribe");
        }

        VisUserEntity entity = visUserService.selectByPrimaryKey(openId);
        if (entity != null) {
            try {
                if (!StringUtils.isBlank(entity.getFacePhoto())) {
                    entity.setFacePhoto(ImageUtils.imgToBase64(entity.getFacePhoto()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            entity = new VisUserEntity();
        }
        entity.setSubScribe(subScribe);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisUser信息", notes = "关键字查询VisUser信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisUserEntity>> selectListByKeys(@RequestBody BasePageSearch<VisUserEntity> record) {
        setPageHelper(record);
        List<VisUserEntity> list = visUserService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisUserEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisUser信息", notes = "批量删除VisUser信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisUserEntity> list = JSONObject.parseArray(keys, VisUserEntity.class);
        // visUserService.deleteBatchByKeys(list);
        for (VisUserEntity entity : list) {
            visUserService.deleteByPrimaryKey(entity.getOpenId());
        }
        return succMsg();
    }
}