package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.Coder;
import com.weds.core.utils.coder.DESCoder;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.service.WeiXinService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description VisRegister管理
 * @Date 2019-03-20
 */
@RestController
@RequestMapping(value = "/visRegister")
@Api(value = "VisRegister管理", description = "VisRegister管理")
public class VisRegisterController extends BaseController {
    @Autowired
    private VisRegisterService visRegisterService;

    @Autowired
    private VisUserService visUserService;

    @Autowired
    private VisBlackService visBlackService;

    @Autowired
    private VisUserStateService visUserStateService;

    @Autowired
    private MODULEService moduleService;

    @Autowired
    private VisFailService visFailService;

    @Autowired
    private FkLogService fkLogService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RegService regService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private DicFmtBean dicFmtBean;

    @Autowired
    private VisCardUserService visCardUserService;

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private SettingParams settingParams;

    @Resource
    private ScmParams scmParams;

    @Autowired
    private MsgSendService msgSendService;

    @Autowired
    private VisThingService visThingService;

    @Resource
    private CommonService commonService;

    @Resource
    private WeiXinService weiXinService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增VisRegister信息", notes = "新增VisRegister信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody VisitorEntity record) {
        long visSerial;
        Date date = new Date();
        FkLogEntity fkLogEntity = new FkLogEntity();

        VisFailEntity entity = new VisFailEntity();
        entity.setVisNo(record.getVisUserEntity().getVisId());
        entity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
        entity.setVisNums(record.getVisRegisterEntity().getVisNums());
        entity.setVisCars(record.getVisRegisterEntity().getVisCars());
        entity.setVisKssj(record.getVisRegisterEntity().getVisKssj());
        entity.setVisThing(record.getVisRegisterEntity().getVisThing());
        entity.setVisBz(record.getVisRegisterEntity().getVisBz());
        entity.setVisOk(record.getVisRegisterEntity().getVisOk());
        entity.setSj(date);

        VisUserEntity visUserEntity = visUserService.selectByPrimaryKey(record.getVisUserEntity().getOpenId());
        if (visUserEntity != null && visUserEntity.getVisSerial() != null) {
            visSerial = visUserEntity.getVisSerial();
            VisRegisterEntity temp = new VisRegisterEntity();
            temp.setVisSerial(visSerial);
            temp.setVisState(1);
            List<VisRegisterEntity> searchList = visRegisterService.selectListByEntity(temp);
            if (searchList.size() > 0) {
                return failMsg("访客已预约，无法再次预约");
            }

            if (!StringUtils.isBlank(record.getVisRegisterEntity().getQrId())) {
                temp = new VisRegisterEntity();
                temp.setQrId(record.getVisRegisterEntity().getQrId());
                List<VisRegisterEntity> qrList = visRegisterService.selectListByEntity(temp);
                if (qrList.size() > 0) {
                    return failMsg("访客邀请二维码已被使用");
                }
            }

            temp = new VisRegisterEntity();
            temp.setVisSerial(visSerial);
            temp.setVisKssj(record.getVisRegisterEntity().getVisKssj());
            temp.setVisJssj(record.getVisRegisterEntity().getVisJssj());
            List<VisRegisterEntity> listVis = visRegisterService.selectRepeatRecord(temp);
            if (listVis.size() > 0) {
                return failMsg("预约时间段已存在");
            }

            // 验证来访人是否在黑名单
            VisBlackEntity visBlackEntity = visBlackService.selectByPrimaryKey(record.getVisUserEntity().getOpenId());
            if (visBlackEntity != null) {
                entity.setVisSerial(visSerial);
                entity.setVisFail(0);
                visFailService.insertSelective(entity);

                // 写访客日志
                fkLogEntity.setLx(0);
                fkLogEntity.setLogType(5);
                fkLogEntity.setLogState(0);
                fkLogEntity.setLogSj(date);
                fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
                fkLogService.insertSelective(fkLogEntity);
                return message("610", "来访人被列为黑名单");
            }
        } else {
            visSerial = moduleService.selectSerialByModuleId("0023");
        }

        // 验证被访人是否可访
        VisUserStateEntity visUserStateEntity = visUserStateService
                .selectByPrimaryKey(record.getVisRegisterEntity().getUserSerial());
        if (visUserStateEntity != null) {
            entity.setVisSerial(visSerial);
            entity.setVisFail(visUserStateEntity.getState());
            visFailService.insertSelective(entity);

            // 写访客日志
            fkLogEntity.setLx(0);
            fkLogEntity.setLogType(0);
            fkLogEntity.setLogState(7);
            fkLogEntity.setLogSj(date);
            fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
            fkLogService.insertSelective(fkLogEntity);
            return message("611", "被访人不接受访问");
        }

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserLname(record.getVisRegisterEntity().getUserLname());
        userInfoEntity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
        if (!StringUtils.isBlank(record.getVisRegisterEntity().getTelePhone())) {
            userInfoEntity.setUserTelephone(record.getVisRegisterEntity().getTelePhone());
        }
        List<UserInfoEntity> list = userInfoService.selectListByEntity(userInfoEntity);

        if (list.size() == 0) {
            return message("612", "被访人不存在");
        } else if (list.size() > 1) {
            return message("613", "被访人存在重名", list);
        } else {
            record.getVisRegisterEntity().setUserSerial(list.get(0).getUserSerial());
        }

        String photo = record.getVisUserEntity().getFacePhoto();
        if (!StringUtils.isBlank(photo)) {
            // 保存人脸照片
            try {
                String path;
                String dir;
                if (scmParams.getFaceType().equals("1")) {
                    dir = scmParams.getFacePath() + File.separator + (visSerial / 1000);
                    record.getVisUserEntity().setFacePhotoFlag("2");
                } else {
                    dir = scmParams.getPhotoPath() + File.separator + (visSerial / 1000);
                    record.getVisUserEntity().setFacePhotoFlag("1");
                }
                path = systemService.wxImageDownLoad(photo, visSerial + "", "jpg", dir, 640, scmParams.getRootPath());
                commonService.makeFctFile(path);
                record.getVisUserEntity().setFacePhoto(path);
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg();
            }
        } else {
            if (photo != null) {
                record.getVisUserEntity().setFacePhoto("");
            }
        }

        int flag = visUserService.updateByPrimaryKeySelective(record.getVisUserEntity());
        if (flag == 0) {
            record.getVisUserEntity().setVisSerial(visSerial);
            visUserService.insert(record.getVisUserEntity());
            // 写访客日志
            fkLogEntity.setLx(0);
            fkLogEntity.setLogType(0);
            fkLogEntity.setLogState(0);
            fkLogEntity.setLogSj(date);
            fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
            fkLogService.insertSelective(fkLogEntity);
        } else {
            // 写访客日志
            fkLogEntity.setLx(1);
            fkLogEntity.setLogType(0);
            fkLogEntity.setLogState(0);
            fkLogEntity.setLogSj(date);
            fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
            fkLogService.insertSelective(fkLogEntity);
        }

        record.getVisUserEntity().setVisSj(date);
        record.getVisRegisterEntity().setSj(date);
        record.getVisRegisterEntity().setVisSerial(visSerial);
        visRegisterService.insertSelective(record.getVisRegisterEntity());

        // 写访客日志
        fkLogEntity.setLx(0);
        fkLogEntity.setLogType(record.getVisRegisterEntity().getVisOk() + 1);
        fkLogEntity.setLogState(0);
        fkLogEntity.setLogSj(date);
        fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
        fkLogService.insertSelective(fkLogEntity);

        MsgSendEntity msgSendEntity = new MsgSendEntity();
        String strDate = DateUtils.getCurrentDateTime();
        msgSendEntity.setMsgState(0);
        msgSendEntity.setRecordDate(strDate);
        msgSendEntity.setInsertDate(strDate);
        msgSendEntity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
        msgSendEntity.setTempletId("100701");
        Map<String, String> map = new HashMap<>();
        map.put("content", "您有一条访客预约信息待处理");
        VisThingEntity visThingEntity = visThingService.selectByPrimaryKey(Integer.parseInt(record.getVisRegisterEntity().getVisThing()));
        map.put("thingName", visThingEntity.getThingName());
        map.put("approveState", "-1");
        map.put("userLname", list.get(0).getUserLname());
        map.put("visKssj", DateUtils.formatDate(record.getVisRegisterEntity().getVisKssj(), "yyyy-MM-dd HH:mm"));
        map.put("visLName", record.getVisUserEntity().getVisLname());
        map.put("visTelePhone", record.getVisUserEntity().getVisTelephone());
        msgSendEntity.setMesContent(toJson(map));
        msgSendEntity.setMsgXh(record.getVisRegisterEntity().getXh() + "");
        msgSendService.insertSelective(msgSendEntity);
        return succMsgData(record.getVisRegisterEntity().getXh());
    }

    @Logs
    @ApiOperation(value = "更新VisRegister信息", notes = "更新VisRegister信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody VisRegisterEntity record) {
        Date date = new Date();
        boolean flag = false;
        VisRegisterEntity entity = visRegisterService.selectByPrimaryKey(record.getXh());
        if (record.getVisitorState() != null && record.getVisitorState().equals("6")) {
            // 结束访问
            if (entity.getVisitorState().equals("6")) {
                return failMsg("访客已结束访问");
            } else {
                record.setVisJssjReal(new Date());
                record.setVisState(2);
                flag = visCardUserService.cancelCardIncrement(entity.getXh(), entity.getVisSerial(), entity.getVisArea());
                if (!flag) {
                    return failMsg();
                }

                if (entity.getCarState().equals("1") && !StringUtils.isBlank(entity.getVisCars())) {
                    flag = visCardUserService.cancelCardPermission(entity.getVisCars());
                    if (!flag) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return failMsg();
                    }
                }
            }
        } else if (record.getApproveState().equals("1") || record.getApproveState().equals("4")) {
            VisRegisterEntity temp1 = new VisRegisterEntity();
            temp1.setVisSerial(entity.getVisSerial());
            temp1.setVisKssj(record.getVisKssj());
            temp1.setVisJssj(record.getVisJssj());
            List<VisRegisterEntity> listVis = visRegisterService.selectRepeatRecord(temp1);

            if (listVis.size() > 0) {
                return failMsg("预约时间段已存在");
            }

            // 审批同意或访客确认
            String rtn = visCardUserService.insertCardIncrement(entity.getVisSerial(), entity.getXh(), record.getVisArea(),
                    record.getVisKssj(), record.getVisJssj());
            if (!rtn.equalsIgnoreCase(CoreConstants.SUCCESSED_FLAG)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return failMsg();
            }

            if (record.getCarState() != null && record.getCarState().equals("1") && !StringUtils.isBlank(entity.getVisCars())) {
                VisUserEntity visUserEntity = visUserService.selectByVisSerial(entity.getVisSerial());
                if (visUserEntity == null) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return failMsg();
                }
                flag = visCardUserService.insertCardPermission(visUserEntity.getVisLname(), visUserEntity.getCompName(),
                        visUserEntity.getVisId(), entity.getVisCars(), record.getVisKssj(), record.getVisJssj());
                if (!flag) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return failMsg();
                }
            }
        } else if (record.getApproveState().equals("2")) {
            // 审批拒绝
        }
        // 写访客日志
        FkLogEntity fkLogEntity = new FkLogEntity();
        fkLogEntity.setLx(1);
        fkLogEntity.setLogType(entity.getVisOk() == null ? 0 : entity.getVisOk() + 1);
        fkLogEntity.setLogState(0);
        fkLogEntity.setLogSj(date);
        fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
        fkLogService.insertSelective(fkLogEntity);

        visRegisterService.updateByPrimaryKeySelective(record);

        String state = record.getApproveState();
        if (state != null && (state.equals("1") || state.equals("2") || state.equals("4"))) {
            MsgSendEntity msgSendEntity = new MsgSendEntity();
            String strDate = DateUtils.getCurrentDateTime();
            msgSendEntity.setMsgState(0);
            msgSendEntity.setRecordDate(strDate);
            msgSendEntity.setInsertDate(strDate);
            msgSendEntity.setUserSerial(entity.getVisSerial());
            msgSendEntity.setTempletId("100701");
            Map<String, String> map = new HashMap<>();
            String stateCn;
            Date kssj;
            switch (state) {
                case "1":
                    stateCn = "审批通过";
                    kssj = record.getVisKssj();
                    break;
                case "2":
                    stateCn = "审批拒绝";
                    kssj = entity.getVisKssj();
                    break;
                default:
                    stateCn = "已确认";
                    kssj = record.getVisKssj();
                    break;
            }
            map.put("content", "您提交的访客预约信息" + stateCn);
            map.put("approveState", state);
            VisThingEntity visThingEntity = visThingService.selectByPrimaryKey(Integer.parseInt(entity.getVisThing().trim()));
            map.put("thingName", visThingEntity.getThingName());
            UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(entity.getUserSerial());
            map.put("userLname", userInfoEntity.getUserLname());
            map.put("visKssj", DateUtils.formatDate(kssj, "yyyy-MM-dd HH:mm"));
            VisUserEntity visUserEntity = visUserService.selectByVisSerial(entity.getVisSerial());
            map.put("visLName", visUserEntity != null ? visUserEntity.getVisLname() : "");
            map.put("visTelePhone", visUserEntity != null ? visUserEntity.getVisTelephone() : "");
            msgSendEntity.setMesContent(toJson(map));
            msgSendEntity.setMsgXh(record.getXh() + "," + state);
            msgSendService.insertSelective(msgSendEntity);
            // MsgSendEntity msgSendEntity = new MsgSendEntity();
            // String strDate = DateUtils.getCurrentDateTime();
            // msgSendEntity.setMsgState(0);
            // msgSendEntity.setRecordDate(strDate);
            // msgSendEntity.setInsertDate(strDate);
            // msgSendEntity.setUserSerial(entity.getVisSerial());
            // msgSendEntity.setTempletId("100702");
            // Map<String, String> map = new HashMap<>();
            // String stateCn;
            // Date kssj;
            // switch (state) {
            //     case "1":
            //         stateCn = "审批通过";
            //         kssj = record.getVisKssj();
            //         break;
            //     case "2":
            //         stateCn = "审批拒绝";
            //         kssj = entity.getVisKssj();
            //         break;
            //     default:
            //         stateCn = "已确认";
            //         kssj = record.getVisKssj();
            //         break;
            // }
            // map.put("content", "您提交的访客预约信息" + stateCn);
            //
            // VisThingEntity visThingEntity = new VisThingEntity();
            // visThingEntity.setBh(entity.getVisThing());
            // List<VisThingEntity> thingList = visThingService.selectListByEntity(visThingEntity);
            // map.put("thingName", thingList.size() > 0 ? thingList.get(0).getThingName() : "");
            // UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(entity.getUserSerial());
            // map.put("userLname", userInfoEntity.getUserLname());
            //
            // map.put("visKssj", DateUtils.formatDate(kssj, "yyyy-MM-dd HH:mm"));
            // VisUserEntity visUserEntity = new VisUserEntity();
            // visUserEntity.setVisSerial(entity.getVisSerial());
            // List<VisUserEntity> list = visUserService.selectListByEntity(visUserEntity);
            // map.put("visLName", list.size() > 0 ? list.get(0).getVisLname() : "");
            // map.put("visTelePhone", list.size() > 0 ? list.get(0).getVisTelephone() : "");
            // msgSendEntity.setMesContent(toJson(map));
            // msgSendEntity.setMsgXh(record.getBh());
            // msgSendService.insertSelective(msgSendEntity);
        }

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisRegister清单", notes = "查询VisRegister清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegisterEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisRegisterEntity> record) {
        setPageHelper(record);
        VisRegisterEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisRegisterEntity();
        }
        List<VisRegisterEntity> list = visRegisterService.selectListByEntity(entity);
        for (VisRegisterEntity visRegisterEntity : list) {
            int visitorState = Integer.parseInt(visRegisterEntity.getVisitorState() == null ? "-1" : visRegisterEntity.getVisitorState());
            int approveState = Integer.parseInt(visRegisterEntity.getApproveState() == null ? "-1" : visRegisterEntity.getApproveState());
            int state = Math.max(visitorState, approveState);
            visRegisterEntity.setState(state == -1 ? "" : state + "");
        }
        dicFmtBean.DicFormat(list.toArray(new VisRegisterEntity[0]), new String[]{"02001", "02002"});
        return succMsgData(new BaseCommPager<VisRegisterEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisRegister列表", notes = "查询VisRegister列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisRegisterEntity>> selectListByEntity(@RequestBody VisRegisterEntity record) {
        List<VisRegisterEntity> list = visRegisterService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisRegister信息", notes = "删除VisRegister信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visRegisterService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisRegister信息", notes = "查询VisRegister信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisitorEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisitorEntity visitorEntity = new VisitorEntity();
        try {
            VisRegisterEntity entity = visRegisterService.selectByPrimaryKey(xh);
            int visitorState = Integer.parseInt(entity.getVisitorState() == null ? "-1" : entity.getVisitorState());
            int approveState = Integer.parseInt(entity.getApproveState() == null ? "-1" : entity.getApproveState());
            int state = Math.max(visitorState, approveState);
            entity.setState(state == -1 ? "" : state + "");
            dicFmtBean.DicFormat(entity, new String[]{"02002"});

            if (entity.getApproveState() != null && !entity.getApproveState().equals("0") && !entity.getApproveState().equals("2")) {
                Date start = new Date();
                Date end = DateUtils.addDays(start, 365);
                String qrCode = visCardUserService.getVisCodeStr(entity.getVisSerial() + "", start, end);
                entity.setQrcode(qrCode);

                UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(entity.getUserSerial());
                entity.setUserLname(userInfoEntity.getUserLname());
                entity.setTelePhone(userInfoEntity.getUserTelephone());
                entity.setCompanyName(regService.selectByPrimaryKey().getRegUnit());
            }
            visitorEntity.setVisRegisterEntity(entity);

            VisUserEntity visUserEntity = visUserService.selectByVisSerial(entity.getVisSerial());
            if (visUserEntity != null) {
                if (!StringUtils.isBlank(visUserEntity.getFacePhoto())) {
                    visUserEntity.setFacePhoto(ImageUtils.imgToBase64(visUserEntity.getFacePhoto()));
                }
                visitorEntity.setVisUserEntity(visUserEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsgData(visitorEntity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisRegister信息", notes = "关键字查询VisRegister信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegisterEntity>> selectListByKeys(@RequestBody BasePageSearch<VisRegisterEntity> record) {
        setPageHelper(record);
        List<VisRegisterEntity> list = visRegisterService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisRegisterEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisRegister信息", notes = "批量删除VisRegister信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisRegisterEntity> list = JSONObject.parseArray(keys, VisRegisterEntity.class);
        for (VisRegisterEntity entity : list) {
            visRegisterService.deleteByPrimaryKey(entity.getXh());
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取访客二维码", notes = "获取访客二维码")
    @RequestMapping(value = "/getVisitorQrCode", method = RequestMethod.GET)
    public JsonResult<Object> getVisitorQrCode(@RequestParam String userSerial, String reqUrl) {
        UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(Long.parseLong(userSerial));
        long timestamp = System.currentTimeMillis() + 3600 * 1000;
        String params = timestamp + "#" + userSerial + "#" + StringUtils.getUUID();
        try {
            String code = DESCoder.encrypt(params, new String(Coder.decryptBASE64(settingParams.getKey())));
            String url;
            if ("1".equals(weiXinParams.getMode())) {
                url = weiXinService.getAppletUrl("snsapi_base");
            } else {
                url = MessageFormat.format(weiXinParams.getAppletUrl(), "", weiXinParams.getAppId(),
                        URLEncoder.encode(reqUrl), "snsapi_base", URLEncoder.encode(code));
            }
            userInfoEntity.setCode(url);
            userInfoEntity.setCurrTime(DateUtils.formatDate(new Date(timestamp), DateUtils.DATE_TIME_FORMAT));
            return succMsgData(userInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "校验访客二维码", notes = "校验访客二维码")
    @RequestMapping(value = "/checkVisitorQrCode", method = RequestMethod.GET)
    public JsonResult<Object> checkVisitorQrCode(@RequestParam String params, @RequestParam String openId) {
        try {
            String code = URLDecoder.decode(DESCoder.decrypt(URLDecoder.decode(params), new String(Coder.decryptBASE64(settingParams.getKey()))));
            long timestamp = Long.parseLong(code.split("#")[0]);
            String qrId = code.split("#")[2];
            VisRegisterEntity record = new VisRegisterEntity();
            record.setQrId(qrId);
            List<VisRegisterEntity> list = visRegisterService.selectListByEntity(record);
            if (list.size() > 0) {
                VisUserEntity visUserEntity = visUserService.selectByPrimaryKey(openId);
                for (VisRegisterEntity entity : list) {
                    if (entity.getVisSerial().equals(visUserEntity.getVisSerial())) {
                        return message("610", "存在访客记录", list.get(0).getXh());
                    }
                }
                return failMsg("邀请二维码已失效");
            }

            if (System.currentTimeMillis() > timestamp) {
                return failMsg("邀请二维码已失效");
            }
            UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(Long.parseLong(code.split("#")[1]));
            userInfoEntity.setQrId(qrId);
            return succMsgData(userInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
    }
}