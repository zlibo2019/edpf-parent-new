package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.jwt.JwtParams;
import com.weds.bean.jwt.JwtUtils;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.*;
import com.weds.core.utils.coder.Coder;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edpf.core.entity.DtFaceEntity;
import com.weds.edpf.core.entity.DtPhotoEntity;
import com.weds.edpf.core.entity.UserBaseEntity;
import com.weds.edpf.core.entity.WtPublicEntity;
import com.weds.edpf.core.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 用户档案表管理
 * @Date 2019-05-23
 */
@RestController
@RequestMapping(value = "/userBase")
@Api(value = "用户档案表管理", description = "用户档案表管理")
public class UserBaseController extends BaseController {
    @Autowired
    private UserBaseService userBaseService;

    @Resource
    private HttpServletRequest request;

    @Resource
    private JwtParams jwtParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "删除用户档案人脸", notes = "删除用户档案人脸")
    @RequestMapping(value = "/deleteFace", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> deleteFace(@RequestParam Long userSerial) {
        UserBaseEntity entity = userBaseService.deleteFaceOrPhoto(userSerial);
        String gly = null;
        if (JwtUtils.getJwtData(request) != null) {
            gly = JwtUtils.getJwtData(request).getString("userSerial");
        }
        userBaseService.updateByPrimaryKeySelective(entity, request.getRemoteAddr(), gly);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "新增用户档案表信息", notes = "新增用户档案表信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody @Valid UserBaseEntity record) {
        try {
            userBaseService.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新用户档案表信息", notes = "更新用户档案表信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid UserBaseEntity record) {
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
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户档案表清单", notes = "查询用户档案表清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserBaseEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserBaseEntity> record) {
        setPageHelper(record);
        UserBaseEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserBaseEntity();
        }
        List<UserBaseEntity> list = userBaseService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserBaseEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询用户档案表列表", notes = "查询用户档案表列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserBaseEntity>> selectListByEntity(@RequestBody UserBaseEntity record) {
        List<UserBaseEntity> list = userBaseService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除用户档案表信息", notes = "删除用户档案表信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long userSerial) {
        String gly = null;
        if (JwtUtils.getJwtData(request) != null) {
            gly = JwtUtils.getJwtData(request).getString("userSerial");
        }
        userBaseService.deleteByPrimaryKey(userSerial, request.getRemoteAddr(), gly);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户档案表信息", notes = "查询用户档案表信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserBaseEntity> selectByPrimaryKey(@RequestParam Long userSerial) {
        UserBaseEntity entity = userBaseService.selectByPrimaryKey(userSerial);
        userBaseService.setUserBaseEntity(entity);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询用户档案表信息", notes = "查询用户档案表信息")
    @RequestMapping(value = "/selectByCardNo", method = RequestMethod.GET)
    public JsonResult<UserBaseEntity> selectByCardNo(@RequestParam String cardNo) {
        UserBaseEntity entity = userBaseService.selectByCardNo(cardNo);
        if (entity == null) {
            return failMsg("未找到用户信息");
        }
        userBaseService.setUserBaseEntity(entity);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询用户档案表信息", notes = "关键字查询用户档案表信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserBaseEntity>> selectListByKeys(@RequestBody BasePageSearch<UserBaseEntity> record) {
        setPageHelper(record);
        UserBaseEntity userBaseEntity = record.getSearch();
        // if ("1".equals(userBaseEntity.getFaceFlag())) {
        //     if (scmParams.getFaceType().equals("1")) {
        //         userBaseEntity.setUserFace(0);
        //     } else {
        //         userBaseEntity.setUserPhoto(0);
        //     }
        // }
        List<UserBaseEntity> list = userBaseService.selectListByKeys(userBaseEntity.getKeys(),
                userBaseEntity.getUserDeps());
        return succMsgData(new BaseCommPager<UserBaseEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除用户档案表信息", notes = "批量删除用户档案表信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<UserBaseEntity> list = JSONObject.parseArray(keys, UserBaseEntity.class);
        List<UserBaseEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                userBaseService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<Object> login(@RequestBody UserBaseEntity record) {
        UserBaseEntity userBaseEntity = userBaseService.userLoginCheck(record);
        if (userBaseEntity == null) {
            return failMsg("用户名密码错误");
        }
        userBaseEntity.setOrgId("10000");
        userBaseEntity.setOrgName("默认公司");
        if (jwtParams.isActive()) {
            userBaseEntity.setToken(userBaseService.getToken(userBaseEntity, jwtParams));
        }
        return succMsgData(userBaseEntity);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/loginById", method = RequestMethod.GET)
    public JsonResult<Object> loginById(@RequestParam String id) {
        try {
            Object token = MapCacheUtils.single().get(id);
            if (token == null || "".equals(token)) {
                return message("610", "二维码失效");
            } else if (token.toString().equals(id)) {
                return message("611", "等待扫码登录");
            }
            String credentials = new String(Coder.decryptBASE64(token.toString()), StandardCharsets.UTF_8);
            String jwtData = JwtUtils.parseJWT(credentials, jwtParams);
            long userSerial = Long.parseLong(JSONObject.parseObject(jwtData).get("userSerial").toString());
            MapCacheUtils.single().del(id);
            UserBaseEntity userBaseEntity = userBaseService.selectByPrimaryKey(userSerial);
            userBaseEntity.setOrgId("10000");
            userBaseEntity.setOrgName("默认公司");
            userBaseEntity.setToken(token.toString());
            return succMsgData(userBaseEntity);
        } catch (Exception e) {
            return failMsg("登录失败");
        }
    }

    @Logs
    @ApiOperation(value = "根据条件查询用户信息", notes = "根据条件查询用户信息")
    @RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
    public JsonResult<List<UserBaseEntity>> selectUserList(@RequestParam String userInfo) {
        List<UserBaseEntity> list = userBaseService.selectUserList(userInfo);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询访客邀请人信息", notes = "查询访客邀请人信息")
    @RequestMapping(value = "/selectVisUserByDept", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserBaseEntity>> selectVisUserByDept(@RequestBody BasePageSearch<UserBaseEntity> record) {
        setPageHelper(record);
        UserBaseEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserBaseEntity();
        }
        List<UserBaseEntity> list = userBaseService.selectVisUserByDept(entity);
        return succMsgData(new BaseCommPager<UserBaseEntity>(list));
    }
}