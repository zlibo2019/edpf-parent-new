package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.PinYinUtils;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.UserInfoEntity;
import com.weds.edwx.entity.UserInfoExtendEntity;
import com.weds.edwx.entity.UserInfoReq;
import com.weds.edwx.service.SystemService;
import com.weds.edwx.service.UserInfoExtendService;
import com.weds.edwx.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description UserInfo管理
 * @Date 2018-12-13
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(value = "UserInfo管理", description = "UserInfo管理")
public class UserInfoController extends BaseController {
    @Autowired
    private UserInfoService userInfoService;

    @Resource
    private UserInfoExtendService userInfoExtendService;

    @Resource
    private SystemService systemService;

    @Resource
    private WeiXinParams weiXinParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增UserInfo信息", notes = "新增UserInfo信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody UserInfoEntity record) {
        userInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新UserInfo信息", notes = "更新UserInfo信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody UserInfoEntity record) {
        userInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询UserInfo清单", notes = "查询UserInfo清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserInfoEntity> record) {
        setPageHelper(record);
        UserInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserInfoEntity();
        }
        List<UserInfoEntity> list = userInfoService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询UserInfo列表", notes = "查询UserInfo列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserInfoEntity>> selectListByEntity(@RequestBody UserInfoEntity record) {
        List<UserInfoEntity> list = userInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询部门下所有用户", notes = "查询部门下所有用户")
    @RequestMapping(value = "/selectDeptUsers", method = RequestMethod.GET)
    public JsonResult<List<UserInfoEntity>> selectDeptUsers(@RequestParam String depJson) {
        List<Integer> depList = JSONObject.parseArray(depJson, Integer.class);
        List<UserInfoEntity> list = userInfoService.selectDeptUsers(depList);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询部门下所有用户", notes = "查询部门下所有用户")
    @RequestMapping(value = "/selectDeptUsersList", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserInfoEntity>> selectDeptUsersList(@RequestBody BasePageSearch<UserInfoReq> record) {
        UserInfoReq entity = record.getSearch();
        if (entity == null) {
            entity = new UserInfoReq();
        }
        List<Integer> depList = JSONObject.parseArray(entity.getDepJson(), Integer.class);
        setPageHelper(record);
        List<UserInfoEntity> list = userInfoService.selectDeptUsersList(depList);
        return succMsgData(new BaseCommPager<UserInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @RequestMapping(value = "/selectUsersInfo", method = RequestMethod.GET)
    public JsonResult<List<UserInfoEntity>> selectUsersInfo(@RequestParam String userJson) {
        List<Integer> userList = JSONObject.parseArray(userJson, Integer.class);
        List<UserInfoEntity> list = userInfoService.selectUsersInfo(userList);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "根据条件查询用户信息", notes = "根据条件查询用户信息")
    @RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
    public JsonResult<List<UserInfoEntity>> selectUserList(@RequestParam String userInfo) {
        List<UserInfoEntity> list = userInfoService.selectUserList(userInfo);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "根据条件查询用户信息", notes = "根据条件查询用户信息")
    @RequestMapping(value = "/selectUserListByPY", method = RequestMethod.GET)
    public JsonResult<Map> selectUserListByPY(@RequestParam String py, @RequestParam Integer pageIndex,
                                              @RequestParam Integer pageSize) {
        List<UserInfoEntity> list = userInfoService.selectUserList(null);
        List<UserInfoEntity> temp = list.stream().filter(t -> {
            String userPY = PinYinUtils.getPinYinHeadChar(t.getUserLname()).toUpperCase();
            return userPY.contains(py.toUpperCase());
        }).collect(Collectors.toList());
        int start = Math.min(temp.size(), (pageIndex - 1) * pageSize);
        int end = Math.min(temp.size(), pageIndex * pageSize);
        List<UserInfoEntity> resp = temp.subList(start, end);
        Map<String, Object> map = new HashMap<>();
        map.put("list", resp);
        map.put("pageIndex", pageIndex);
        map.put("totalPage", Math.ceil(temp.size() * 1.0 / pageSize));
        return succMsgData(map);
    }

    @Logs
    @ApiOperation(value = "查询访客邀请人信息", notes = "查询访客邀请人信息")
    @RequestMapping(value = "/selectVisUserByDept", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserInfoEntity>> selectVisUserByDept(@RequestBody BasePageSearch<UserInfoEntity> record) {
        setPageHelper(record);
        UserInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserInfoEntity();
        }
        List<UserInfoEntity> list = userInfoService.selectVisUserByDept(entity);
        return succMsgData(new BaseCommPager<UserInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "删除UserInfo信息", notes = "删除UserInfo信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long userSerial) {
        userInfoService.deleteByPrimaryKey(userSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询UserInfo信息", notes = "查询UserInfo信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserInfoEntity> selectByPrimaryKey(@RequestParam Long userSerial) {
        UserInfoEntity entity = userInfoService.selectByPrimaryKey(userSerial);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询UserInfo信息", notes = "查询UserInfo信息")
    @RequestMapping(value = "/selectByIdCard", method = RequestMethod.GET)
    public JsonResult<UserInfoEntity> selectByIdCard(@RequestParam String userId) {
        UserInfoEntity entity = userInfoService.selectByIdCard(userId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "设置微信用户头像", notes = "设置微信用户头像")
    @RequestMapping(value = "/setWxHeadImage", method = RequestMethod.POST)
    public JsonResult<String> setWxHeadImage(@RequestBody Map<String, String> paramsMap) {
        String mediaId = paramsMap.get("mediaId");
        try {
            String imagePath = systemService.wxImageDownLoad(mediaId, null, "jpeg", weiXinParams.getHeadImagePath(), 450, null);
            UserInfoExtendEntity record = new UserInfoExtendEntity();
            record.setUserSerial(paramsMap.get("userSerial"));
            record.setHeadImage(imagePath);
            record.setLtDate(DateUtils.getCurrentDateTime());
            int rtn = userInfoExtendService.updateByPrimaryKeySelective(record);
            if (rtn == 0) {
                record.setCtDate(DateUtils.getCurrentDateTime());
                userInfoExtendService.insertSelective(record);
            }
            return succMsgData(ImageUtils.imgToBase64(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
    }
}