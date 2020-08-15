package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.Coder;
import com.weds.core.utils.coder.DESCoder;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edpf.core.entity.UserRoleEntity;
import com.weds.edpf.core.service.UserRoleService;
import com.weds.edpf.core.service.WeiXinService;
import com.weds.edwx.entity.LoginLogEntity;
import com.weds.edwx.entity.LoginOpenidEntity;
import com.weds.edwx.entity.UserEntity;
import com.weds.edwx.service.LoginLogService;
import com.weds.edwx.service.LoginOpenidService;
import com.weds.edwx.service.RegService;
import com.weds.edwx.service.UserService;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description User管理
 * @Date 2018-11-26
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "User管理", description = "User管理")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginOpenidService loginOpenidService;

    @Autowired
    private LoginLogService loginLogService;

    private Logger log = LogManager.getLogger();

    @Autowired
    private CommProcService commProcService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RegService regService;

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private SettingParams settingParams;

    @Resource
    private ScmParams scmParams;

    @Resource
    private WeiXinService weiXinService;

    @Resource
    private UserRoleService userRoleService;

    @Logs
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @RequestMapping(value = "/updateDefaultPwd", method = RequestMethod.POST)
    public JsonResult<Object> updateDefaultPwd(@RequestBody UserEntity record) {
        record.setUserSerial(record.getUserSerial());
        record.setNewPassword(record.getNewPassword());
        userService.updatePwd(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "登录验证", notes = "登录验证")
    @RequestMapping(value = "/userLoginCheck", method = RequestMethod.POST)
    public JsonResult<UserEntity> userLoginCheck(@RequestBody UserEntity record) {
        if (null == record.getOpenId() || "".equals(record.getOpenId())) { //如果openid不存在，不让用户登录
            return failMsg("获取openid失败，请关闭当前页面并重新打开");
        }
        List<LoginOpenidEntity> list = loginOpenidService.selectListByEntity(null);
        try {
            int limit = Integer.parseInt(DESCoder.decrypt(settingParams.getLimit(), new String(Coder.decryptBASE64(settingParams.getKey()))));
            if (limit != -1 && list.size() >= limit) {
                return failMsg("超过最大人数限制");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        //根据工号和密码判断该人员是否存在u
        UserEntity user = new UserEntity();
        if (record.getLoginType() == 0) {//普通员工登录
            // user = userService.userLoginCheck(record);
            user = userService.selectByUserNo(record.getUserNo());
        } else if (record.getLoginType() == 1) { //商户登录
            user = userService.merchantLoginCheck(record);
        }

        if (user == null) {
            return failMsg("用户名密码错误");
        } else {
            if (StringUtils.isBlank(user.getUserPassword())) {
                if (weiXinParams.getPassword().equals(record.getUserPassword())) {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserSerial(user.getUserSerial());
                    userEntity.setNewPassword(weiXinParams.getPassword());
                    userService.updatePwd(userEntity);
                } else {
                    return failMsg("用户名密码错误");
                }
            } else {
                if (!record.getUserPassword().equals(user.getUserPassword())) {
                    return failMsg("用户名密码错误");
                }
            }
        }
        user.setOpenId(record.getOpenId());
        user.setSafePwd(!StringUtils.isBlank(user.getUserPassword()) && !weiXinParams.getPassword().equals(record.getUserPassword()));

        LoginOpenidEntity bind;

        synchronized (this) {
            //判断 user_serial 是否已经被绑定
            bind = loginOpenidService.checkBindState(user);
        }

        if (bind != null && StringUtils.isBlank(bind.getOpenid()) && !StringUtils.isBlank(bind.getUnionId())) { //如果绑定关系为小程序的话，则更新
            String unionId = weiXinService.getUnionIdByOpenId(user.getOpenId());
            if (!bind.getUnionId().equals(unionId)) {
                return failMsg("此账号已与其它微信号绑定");
            }
            user.setOpenId(user.getOpenId());
            user.setUnionId(unionId);
            loginOpenidService.updateOpenIdByUnionId(user); //更新
            user.setOrgId("10000");
            user.setOrgName(regService.selectByPrimaryKey().getRegUnit());
            user.setToken(userService.getToken(user));

            //插入登录操作日志
            LoginLogEntity loginLogEntity = new LoginLogEntity();
            loginLogEntity.setLx(1);
            loginLogEntity.setLogBz("用户登录");
            loginLogEntity.setUserNo(record.getUserNo());
            loginLogEntity.setOpenid(record.getOpenId());
            loginLogEntity.setLogSj(DateUtils.getCurrentDateTime());
            loginLogEntity.setUserSerial(user.getUserSerial());
            loginLogEntity.setUserLname(user.getUserLname());
            loginLogService.insert(loginLogEntity);

            return succMsgData(user);
        }
        if (bind != null && !user.getOpenId().equals(bind.getOpenid())) { //判断已经被绑定
            return failMsg("此账号已与其它微信号绑定");
        }

        user.setUserSj(new Date());
        //取出 unionId
        String uninonId = weiXinService.getUnionIdByOpenId(user.getOpenId());
        user.setUnionId(uninonId);
        user.setOrgId("10000");
        user.setOrgName(regService.selectByPrimaryKey().getRegUnit());
        user.setToken(userService.getToken(user));

        if (bind == null) {
            //未绑定时，插入绑定关系
            loginOpenidService.insertBindRelation(user);
        }

        //插入登录操作日志
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setLx(1);
        loginLogEntity.setLogBz("用户登录");
        loginLogEntity.setUserNo(record.getUserNo());
        loginLogEntity.setOpenid(record.getOpenId());
        loginLogEntity.setLogSj(DateUtils.getCurrentDateTime());
        loginLogEntity.setUserSerial(user.getUserSerial());
        loginLogEntity.setUserLname(user.getUserLname());
        loginLogService.insert(loginLogEntity);
        return succMsgData(user);
    }

    @Logs
    @ApiOperation(value = "获取openid信息，并判断是否绑定", notes = "获取openid信息，并判断是否绑定")
    @RequestMapping(value = "/getOpenId", method = RequestMethod.GET)
    public JsonResult<Map> getOpenId(@RequestParam String code) {
        //根据返回的code获取openid
        String openId = weiXinService.getOpenId(code);
        if (openId == null || openId.equals("")) { //未获取到openid
            String url;
            if ("1".equals(weiXinParams.getMode())) {
                url = weiXinService.getAppletUrl("snsapi_userinfo");
            } else {
                url = MessageFormat.format(weiXinParams.getAppletUrl(), "", weiXinParams.getAppId(), weiXinParams.getHeadUrl(), "snsapi_userinfo", "");
            }
            // return failMsg("获取openid失败，请关闭当前页面并重新打开");
            return failMsg(url);
        }
        Map<String, String> map = new HashMap<>();
        map.put("openId", openId);
        map.put("companyId", weiXinParams.getCompanyId());
        return succMsgData(map);
    }

    @Logs
    @RequestMapping(value = "/getUserInfoByOpenId", method = RequestMethod.GET)
    public JsonResult<UserEntity> getUserInfoByOpenId(@RequestParam String openId) {
        //根据openid判断是否绑定登录信息
        LoginOpenidEntity loginOpenid = loginOpenidService.selectByOpendId(openId);
        UserEntity user = new UserEntity();
        if (loginOpenid == null) { //未绑定，直接返回openId
            user.setOpenId(openId);
            return message("605", "未绑定", user);
        }
        //已绑定，返回绑定的用户信息
        user = userService.selectByPrimaryKey(loginOpenid.getUserSerial());
        user.setOpenId(openId);
        user.setOrgId("10000");
        user.setOrgName(regService.selectByPrimaryKey().getRegUnit());
        user.setToken(userService.getToken(user));
        return succMsgData(user);
    }

    @Logs
    @ApiOperation(value = "获取unionId，并判断是否绑定", notes = "获取unionId，并判断是否绑定")
    @RequestMapping(value = "/getUnionId", method = RequestMethod.GET)
    public JsonResult<UserEntity> getUnionId(@RequestParam String code) {
        //根据code获取unionId
        JSONObject codeJson = weiXinService.getUnionId(code);
        String unionId = codeJson.getString("unionid");
        String openId = codeJson.getString("openid");
        //String unionId = userService.getUnionId(code);
        if (unionId == null || unionId == "") { //未获取到unionId
            return failMsg("获取unionId失败，请检查是否关注公众号");
        }
        //System.out.println("##############################" + unionId);
        //根据unionId判断是否绑定登录信息
//        String unionId = "o1wqvxBxspkXJXmtSOdsfeWE8-Es"
        UserEntity userEntity = userService.selectByUnionId(unionId);
        if (userEntity == null) { //未绑定，直接返回unionId
            userEntity = new UserEntity();
            userEntity.setUnionId(unionId);
            userEntity.setAppletOpenId(openId);
            return message("605", "未绑定", userEntity);
        }
        userEntity.setUnionId(unionId);
        userEntity.setAppletOpenId(openId);
        userEntity.setOrgId("10000");
        userEntity.setOrgName(regService.selectByPrimaryKey().getRegUnit());
        userEntity.setToken(userService.getToken(userEntity));
        return succMsgData(userEntity);
    }

    @Logs
    @ApiOperation(value = "根据unionId获取用户信息", notes = "根据unionId获取用户信息")
    @RequestMapping(value = "/getUserByUnionId", method = RequestMethod.GET)
    public JsonResult<UserEntity> getUserByUnionId(@RequestParam String unionId) {
        if (unionId == null || unionId == "") { //未获取到unionId
            return failMsg("获取unionId失败，请关闭当前页面并重新打开");
        }
        //根据unionId判断是否绑定登录信息
        UserEntity userEntity = userService.selectByUnionId(unionId);
        if (userEntity == null) { //未绑定，直接返回unionId
            userEntity = new UserEntity();
            userEntity.setUnionId(unionId);
            return message("605", "未绑定", userEntity);
        }
        if (StringUtils.isBlank(userEntity.getOpenId())) {
            userEntity = new UserEntity();
            String url;
            if ("1".equals(weiXinParams.getMode())) {
                url = weiXinService.getAppletUrl("snsapi_userinfo");
            } else {
                url = MessageFormat.format(weiXinParams.getAppletUrl(), "", weiXinParams.getAppId(), weiXinParams.getHeadUrl(), "snsapi_userinfo", "");
            }
            userEntity.setUser1(url);
            return failMsg("openId为空，请去微信公众平台登录后重试", userEntity);
        }
        userEntity.setUnionId(unionId);
        userEntity.setOrgId("10000");
        userEntity.setOrgName(regService.selectByPrimaryKey().getRegUnit());
        userEntity.setToken(userService.getToken(userEntity));
        return succMsgData(userEntity);
    }

    @Logs
    @ApiOperation(value = "根据code获取openId和用户信息", notes = "根据code获取openId和用户信息")
    @RequestMapping(value = "/setOpenId", method = RequestMethod.GET)
    public JsonResult<UserEntity> setOpenId(@RequestParam String code) {
        //根据返回的code获取openid
        String openId = weiXinService.getOpenId(code);
        if (openId == null || openId == "") { //未获取到openid
            return failMsg("获取openid失败，请关闭当前页面并重新打开");
        }
        //根据openid判断是否绑定登录信息
        LoginOpenidEntity loginOpenid = loginOpenidService.selectByOpendId(openId);
        if (loginOpenid != null) { //已经绑定，问题数据，找管理员解决
            return failMsg("该openId已经绑定，请联系管理员处理！");
        }
        UserEntity user = new UserEntity();
        //未绑定，进行更新处理
        String unionId = weiXinService.getUnionIdByOpenId(openId); // "o1wqvxHmHQB8X1s0Onp0ijB6I26w";
        if (StringUtils.isBlank(unionId)) {
            return failMsg("无unionId，请联系管理员处理");
        }
        user.setOpenId(openId);
        user.setUnionId(unionId);
        loginOpenidService.updateOpenIdByUnionId(user); //更新
        //更新完，返回用户信息
        UserEntity userEntity2 = userService.selectByUnionId(unionId);
        if (userEntity2 == null) { //未绑定，直接返回unionId
            return failMsg("该openId无绑定信息，请联系管理员处理！");
        }
        userEntity2.setOpenId(openId);
        userEntity2.setUnionId(unionId);
        userEntity2.setOrgId("10000");
        userEntity2.setOrgName(regService.selectByPrimaryKey().getRegUnit());
        userEntity2.setToken(userService.getToken(userEntity2));
        return succMsgData(userEntity2);
    }

    @Logs
    @ApiOperation(value = "退出登录并解绑", notes = "退出登录并解绑")
    @RequestMapping(value = "/unbindRelation", method = RequestMethod.POST)
    public JsonResult<UserEntity> unUserBind(@RequestBody UserEntity userEntity) {
        //先判断绑定关系是否存在
        LoginOpenidEntity bindStatus = loginOpenidService.selectBindStatus(userEntity);
        if (bindStatus == null) {
            return message("610", "绑定关系不存在");
        }
        //验证user_serial 和 密码是否正确
        UserEntity user = userService.checkUserPwdBySerial(userEntity);
        if (user == null) {//密码错误
            return failMsg("密码错误");
        }
        //密码正确时，删除绑定关系
        loginOpenidService.deleteBindStatus(userEntity);

        //插入登录操作日志
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setLx(4);
        loginLogEntity.setLogBz("用户解绑");
        loginLogEntity.setUserNo(user.getUserNo());
        loginLogEntity.setOpenid(userEntity.getOpenId());
        loginLogEntity.setLogSj(DateUtils.getCurrentDateTime());
        loginLogEntity.setUserSerial(user.getUserSerial());
        loginLogEntity.setUserLname(user.getUserLname());
        loginLogService.insert(loginLogEntity);

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "小程序登录验证", notes = "小程序登录验证")
    @RequestMapping(value = "/userAppletLoginCheck", method = RequestMethod.POST)
    public JsonResult<UserEntity> userAppletLoginCheck(@RequestBody UserEntity record) {

        UserEntity user = userService.userLoginCheck(record);
        //插入登录操作日志
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setLx(0);
        loginLogEntity.setLogBz("小程序用户登录");
        loginLogEntity.setUserNo(record.getUserNo());
        loginLogEntity.setOpenid(record.getUnionId());
        loginLogEntity.setLogSj(DateUtils.getCurrentDateTime());
        loginLogService.insert(loginLogEntity);
        if (user == null) {
            return failMsg("用户名密码错误");
        }
        user.setUnionId(record.getUnionId());
        user.setAppletOpenId(record.getAppletOpenId());
        //判断 user_serial 是否已经被绑定
        LoginOpenidEntity bind = loginOpenidService.checkBindState(user);
        if (bind != null && !user.getUnionId().equals(bind.getUnionId())) { //判断已经被绑定
            return failMsg("此账号已与其它微信号绑定");
        }
        if (bind == null) {
            user.setUserSj(new Date());
            //未绑定时，插入绑定关系
            loginOpenidService.insertAppletBindRelation(user);
            user.setOrgId("10000");
            user.setOrgName(regService.selectByPrimaryKey().getRegUnit());
            user.setToken(userService.getToken(user));
        }
        user.setToken(userService.getToken(user));
        return succMsgData(user);
    }

    @Logs
    @ApiOperation(value = "修改员工密码", notes = "修改员工密码")
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    public JsonResult<Object> updatePwd(@RequestBody UserEntity record) {
        //先判断旧密码是否正确
        UserEntity userEntity = userService.checkUserPwdBySerial(record);
        if (userEntity == null) {
            return failMsg("原密码输入错误");
        }
        int count = userService.updatePwd(record);
        if (count == 0) {
            return failMsg("密码修改失败");
        }
        return succMsg("密码修改成功");
    }

    @Logs
    @ApiOperation(value = "获取员工卡户信息", notes = "获取员工卡户信息")
    @RequestMapping(value = "/getCardInfo", method = RequestMethod.POST)
    public JsonResult<Object> getCardInfo(@RequestBody UserEntity record) {
        //先判断旧密码是否正确
        UserEntity userEntity = userService.getCardInfo(record);
        if (userEntity == null) {
            return failMsg("您要查询的信息不存在");
        }
        return succMsgData(userEntity);
    }

    @Logs
    @ApiOperation(value = "卡片挂失", notes = "卡片挂失")
    @RequestMapping(value = "/cardLoss", method = RequestMethod.POST)
    public JsonResult<Object> setCardLoss(@RequestBody UserEntity record) {
        CommProcEntity commProcEntity = new CommProcEntity();
        commProcEntity.setProcName("ClientPro_Card_loss");
        List<Object> list = new ArrayList<>();
        list.add(record.getUserSerial().toString());
        list.add(record.getUserCard());
        list.add("");
        list.add("1");
        list.add(request.getRemoteAddr());
        list.add(record.getUserSerial().toString());
        list.add("");
        commProcEntity.setParams(list);
        //执行挂失的存储过程
        List<List<Map>> map = commProcService.loadProcData(commProcEntity);
        String flg = map.get(0).get(0).get("").toString();
        //String flg = "3";
        if (flg.equals("1")) { //挂失成功之后，下发增量日志
            record.setUserSj(new Date());
            userService.insertPublic(record);
            return succMsg("挂失成功");
        }
        if (flg.equals("2")) {
            return failMsg("人员不存在");
        }
        if (flg.equals("3")) {
            return failMsg("卡号状态不正常,无法挂失");
        }
        if (flg.equals("4")) {
            return failMsg("卡号状态不正常,无法挂失");
        }
        return failMsg("不知原因的失败");
    }

    @Logs
    @ApiOperation(value = "获取二维码密钥", notes = "获取二维码密钥")
    @RequestMapping(value = "/getCode", method = RequestMethod.POST)
    public JsonResult<Object> getUserCode(@RequestBody UserEntity record) {
        UserEntity userEntity = userService.getCardInfo(record);//取出人员卡信息
        if (userEntity == null || "".equals(userEntity.getUserCard()) || userEntity.getUserCard() == null) {
            return failMsg("该人员无卡片信息");
        }
        String startTime = DateUtils.formatDate(DateUtils.addSeconds(new Date(), -180), "yyMMddHHmmss");
        int keepTime = 1 * 60 + 360;
        String codeStr = (new Random().nextInt(90000) + 10000) + ":1" + ":" + startTime + ":" + keepTime + ":"
                + record.getUserSerial() + "," + userEntity.getUserCard();
        String codeData = userService.genaratorCode(codeStr);
        if (codeData == null) {
            return failMsg("二维码生成失败");
        }
        Map<String, Object> sucMap = new HashMap<String, Object>();
        sucMap.put("codeStr", codeData);
        return succMsgData(sucMap);
    }

    @Logs
    @ApiOperation(value = "静默获取微信openId地址", notes = "静默获取微信openId地址")
    @RequestMapping(value = "/getWxOpenIdUrl", method = RequestMethod.GET)
    public JsonResult<Object> getWxOpenIdUrl(@RequestParam String reqUrl, @RequestParam String code) {
        String url;
        if ("1".equals(weiXinParams.getMode())) {
            url = weiXinService.getAppletUrl("snsapi_base");
        } else {
            url = MessageFormat.format(weiXinParams.getAppletUrl(), "", weiXinParams.getAppId(),
                    URLEncoder.encode(reqUrl), "snsapi_base", URLEncoder.encode(code));
        }
        return succMsgData(url);
    }

    @Logs
    @ApiOperation(value = "根据code获取微信openId", notes = "根据code获取微信openId")
    @RequestMapping(value = "/getWxOpenIdByCode", method = RequestMethod.GET)
    public JsonResult<Object> getWxOpenIdByCode(@RequestParam String code) {
        String openId = weiXinService.getOpenId(code);
        return succMsgData(openId);
    }

    @Logs
    @ApiOperation(value = "查询VisUser信息", notes = "查询VisUser信息")
    @RequestMapping(value = "/getWxUserInfo", method = RequestMethod.GET)
    public JsonResult<JSONObject> getWxUserInfo(@RequestParam String openId) {
        JSONObject json = weiXinService.getWxUserInfo(openId);
        return succMsgData(json);
    }

    @Logs
    @ApiOperation(value = "getUserHeadImage", notes = "getUserHeadImage")
    @RequestMapping(value = "/getUserHeadImage", method = RequestMethod.GET)
    public JsonResult<Object> getUserHeadImage(@RequestParam Long userSerial) {
        UserEntity entity = userService.selectByPrimaryKey(userSerial);
        if (entity.getUserPhoto() != null && entity.getUserPhoto() == 1) {
            String path = scmParams.getRootPath() + File.separator + scmParams.getPhotoPath() + File.separator
                    + entity.getUserSerial() / 1000 + File.separator + entity.getUserSerial() + ".jpg";
            try {
                return succMsgData(ImageUtils.imgToBase64(path));
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg();
            }
        } else {
            return succMsg();
        }
    }



	/*
    @Logs
	@ApiOperation(value = "新增User信息", notes = "新增User信息")
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public JsonResult<Object> insert(@RequestBody UserEntity record) {
        				userService.insertSelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "更新User信息", notes = "更新User信息")
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public JsonResult<Object> updateByPrimaryKey(@RequestBody UserEntity record) {
				userService.updateByPrimaryKeySelective(record);
		return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询User清单", notes = "查询User清单")
	@RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
	public JsonResult<BaseCommPager<UserEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserEntity> record) {
		setPageHelper(record);
		UserEntity entity = record.getSearch();
        if (entity == null) {
        	entity = new UserEntity();
        }
		        List<UserEntity> list = userService.selectListByEntity(entity);
		return succMsg(new BaseCommPager<UserEntity>(list));
	}

    @Logs
    @ApiOperation(value = "查询User列表", notes = "查询User列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserEntity>> selectListByEntity(@RequestBody UserEntity record) {
                List<UserEntity> list = userService.selectListByEntity(record);
        return succMsg(list);
    }

		@Logs
	@ApiOperation(value = "删除User信息", notes = "删除User信息")
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
	public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long userSerial) {
        userService.deleteByPrimaryKey(userSerial);
        return succMsg();
	}

	@Logs
	@ApiOperation(value = "查询User信息", notes = "查询User信息")
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public JsonResult<UserEntity> selectByPrimaryKey(@RequestParam Long userSerial) {
		UserEntity entity = userService.selectByPrimaryKey(userSerial);
        return succMsg(entity);
	}*/
}