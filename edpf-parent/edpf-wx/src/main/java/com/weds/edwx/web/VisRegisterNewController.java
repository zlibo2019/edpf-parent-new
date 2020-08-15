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
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.constant.VisitorParams;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.VisCardUserMapper;
import com.weds.edwx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description VisRegisterNew管理
 * @Date 2019-05-21
 */
@RestController
@RequestMapping(value = "/visRegisterNew")
@Api(value = "VisRegisterNew管理", description = "VisRegisterNew管理")
public class VisRegisterNewController extends BaseController {
    @Resource
    private VisRegisterNewService visRegisterNewService;

    @Resource
    private VisUserNewService visUserNewService;

    @Resource
    private VisBlackNewService visBlackNewService;

    @Resource
    private VisFailService visFailService;

    @Resource
    private FkLogService fkLogService;

    @Resource
    private MODULEService moduleService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private VisUserStateService visUserStateService;

    @Resource
    private SystemService systemService;

    @Resource
    private VisThingService visThingService;

    @Resource
    private MsgSendService msgSendService;

    @Resource
    private VisCardUserService visCardUserService;

    @Resource
    private VisRegionService visRegionService;

    @Resource
    private RegService regService;

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private CommonService commonService;

    @Resource
    private ScmParams scmParams;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private VisSettingService visSettingService;

    @Resource
    private VisCardUserMapper visCardUserMapper;

    @Resource
    private StFaceService stFaceService;

    @Resource
    private VisitorParams visitorParams;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "获取访客系统识别方式", notes = "获取访客系统识别方式")
    @RequestMapping(value = "/selectVisDiscernType", method = RequestMethod.GET)
    public JsonResult<String> selectVisDiscernType() {
        return succMsgData(scmParams.getDiscernType());
    }

    @Logs
    @ApiOperation(value = "获取访客系统参数", notes = "获取访客系统参数")
    @RequestMapping(value = "/getVisParams", method = RequestMethod.GET)
    public JsonResult<String> getVisParams() {
        return succMsgData(visitorParams.getWxAppFlag());
    }

    @Logs
    @ApiOperation(value = "新增或修改访客预约信息", notes = "新增或修改访客预约信息")
    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insertOrUpdate(@RequestBody @Valid VisitorNewEntity record) {
        Date visJssj = record.getVisRegisterEntity().getVisJssj();
        if (visJssj != null) {
            record.getVisRegisterEntity().setVisJssj(DateUtils.addSeconds(visJssj, 59));
        }
        Date date = new Date();
        FkLogEntity fkLogEntity = new FkLogEntity();

        int fkLogLx = 0;
        if (record.getVisRegisterEntity().getXh() != null) {
            fkLogLx = 1;
        }

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

        long visSerial;
        String visId = record.getVisUserEntity().getVisId();
        VisUserNewEntity visUserNewEntity;

        // 身份证号不为空时
        if (!StringUtils.isBlank(visId)) {
            visUserNewEntity = visUserNewService.selectByVisId(visId);
            Long tempVisSerial = record.getVisUserEntity().getTempVisSerial();
            if (visUserNewEntity != null && visUserNewEntity.getVisSerial() != null) {
                // 获取访客编号
                visSerial = visUserNewEntity.getVisSerial();
                // 如果是更新且访客编号不一致时，删除原访客信息
                if (fkLogLx == 1 && tempVisSerial != null && visSerial != tempVisSerial) {
                    record.getVisRegisterEntity().setVisSerial(visSerial);
                    visUserNewService.deleteByPrimaryKey(tempVisSerial);
                }
                // 验证来访人是否在黑名单
                VisBlackNewEntity visBlackNewEntity = visBlackNewService.selectByPrimaryKey(visId);
                if (visBlackNewEntity != null) {
                    entity.setVisSerial(visSerial);
                    entity.setVisFail(0);
                    visFailService.insertSelective(entity);

                    // 写访客日志
                    fkLogEntity.setLx(fkLogLx);
                    fkLogEntity.setLogType(5);
                    fkLogEntity.setLogState(0);
                    fkLogEntity.setLogSj(date);
                    fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
                    fkLogService.insertSelective(fkLogEntity);
                    return message("610", "来访人被列为黑名单");
                }

                // VisRegisterNewEntity temp = new VisRegisterNewEntity();
                // temp.setVisSerial(visSerial);
                // temp.setVisState(1);
                // List<VisRegisterNewEntity> searchList = visRegisterNewService.selectListByEntity(temp);
                // if (searchList.size() > 0) {
                //     return failMsg("访客已发卡，请先销卡");
                // }

                if (visCardUserService.haveCardsOrQrcode(null, visSerial)) {
                    return failMsg("访客已发卡，请先销卡");
                }

                VisRegisterNewEntity temp = new VisRegisterNewEntity();
                temp.setVisSerial(visSerial);
                temp.setVisKssj(record.getVisRegisterEntity().getVisKssj());
                temp.setVisJssj(record.getVisRegisterEntity().getVisJssj());
                List<VisRegisterNewEntity> listVis = visRegisterNewService.selectRepeatRecord(temp);
                if (listVis.size() > 0) {
                    return failMsg("预约时间段已存在");
                }
            } else {
                if (fkLogLx == 1 && tempVisSerial != null) {
                    visSerial = tempVisSerial;
                } else {
                    VisUserNewEntity entity1 = visUserNewService.selectByOpenId(record.getVisUserEntity().getOpenId());
                    if (entity1 != null) {
                        visSerial = entity1.getVisSerial();
                    } else {
                        visSerial = moduleService.selectSerialByModuleId("0023");
                    }
                }
                // String visTelephone = record.getVisUserEntity().getVisTelephone();
                // visUserNewEntity = visUserNewService.selectByVisTelephone(visTelephone);
                // if (visUserNewEntity != null) {
                //     visSerial = visUserNewEntity.getVisSerial();
                // } else {
                // }
            }
        } else {
            // String visTelephone = record.getVisUserEntity().getVisTelephone();
            // List<VisUserNewEntity> list = visUserNewService.selectByVisIdOrTel(visTelephone);
            // if (visUserNewEntity != null) {
            //     visSerial = visUserNewEntity.getVisSerial();
            // } else {
            visSerial = moduleService.selectSerialByModuleId("0023");
            // }
        }

        // 验证被访人是否可访
        VisUserStateEntity visUserStateEntity = visUserStateService.selectByPrimaryKey(record.getVisRegisterEntity().getUserSerial());
        if (visUserStateEntity != null) {
            entity.setVisSerial(visSerial);
            entity.setVisFail(visUserStateEntity.getState());
            visFailService.insertSelective(entity);

            // 写访客日志
            fkLogEntity.setLx(fkLogLx);
            fkLogEntity.setLogType(0);
            fkLogEntity.setLogState(7);
            fkLogEntity.setLogSj(date);
            fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
            fkLogService.insertSelective(fkLogEntity);
            return message("611", "被访人不接受访问");
        }

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
        String userLname = record.getVisRegisterEntity().getUserLname();
        if (!StringUtils.isBlank(userLname)) {
            userInfoEntity.setUserLname(userLname);
        }
        String telePhone = record.getVisRegisterEntity().getTelePhone();
        if (!StringUtils.isBlank(telePhone)) {
            userInfoEntity.setUserTelephone(telePhone);
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
            if (!"-1".equals(photo)) {
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

                    if ("0".equals(record.getType())) {
                        path = ImageUtils.base64ToFile(photo, visSerial + "", "jpg", dir, scmParams.getRootPath());
                    } else {
                        path = systemService.wxImageDownLoad(photo, visSerial + "", "jpg", dir,
                                scmParams.getPhotoSize(), scmParams.getRootPath());
                    }
                    commonService.makeFctFile(path);
                    record.getVisUserEntity().setFacePhoto(path);
                } catch (Exception e) {
                    e.printStackTrace();
                    return failMsg();
                }
            } else {
                record.getVisUserEntity().setFacePhoto(null);
            }
        } else {
            record.getVisUserEntity().setFacePhotoFlag("0");
        }

        String cardPhoto = record.getVisUserEntity().getCardPhoto();
        if (!StringUtils.isBlank(cardPhoto)) {
            if (!"-1".equals(cardPhoto)) {
                // 保存身份证照片
                try {
                    String path = scmParams.getVisPhotoPath() + File.separator + (visSerial / 1000);
                    ImageUtils.base64ToFile(cardPhoto, visSerial + "", "jpg", path, scmParams.getRootPath());
                    record.getVisUserEntity().setVisPhoto(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return failMsg();
                }
            } else {
                record.getVisUserEntity().setVisPhoto(null);
            }
        } else {
            record.getVisUserEntity().setVisPhoto(0);
        }

        // String visSex = record.getVisUserEntity().getVisSex();
        // if (!StringUtils.isBlank(visSex)) {
        //     TtSexEntity ttSexEntity = ttSexService.selectByPrimaryKey(Short.parseShort(visSex));
        //     record.getVisUserEntity().setVisSex(ttSexEntity.getTtName());
        // }

        record.getVisUserEntity().setVisSj(date);
        record.getVisUserEntity().setVisSerial(visSerial);
        int flag = visUserNewService.updateByPrimaryKeySelective(record.getVisUserEntity());
        if (flag == 0) {
            visUserNewService.insert(record.getVisUserEntity());
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

        record.getVisRegisterEntity().setSj(date);
        record.getVisRegisterEntity().setVisSerial(visSerial);

        String area = record.getVisRegisterEntity().getVisArea();
        if (!StringUtils.isBlank(area)) {
            List<VisRegionEntity> temp = visRegionService.selectListByBh(area);
            String areaName = String.join(",", temp.stream().map(VisRegionEntity::getName).collect(Collectors.toList()));
            record.getVisRegisterEntity().setVisAreaName(areaName);
        }

        record.getVisRegisterEntity().setSj(date);
        record.getVisRegisterEntity().setVisSerial(visSerial);
        record.getVisRegisterEntity().setVisState(0);

        if (fkLogLx == 0) {
            visRegisterNewService.insertSelective(record.getVisRegisterEntity());
        } else {
            visRegisterNewService.updateByPrimaryKeySelective(record.getVisRegisterEntity());
        }

        // 写访客日志
        fkLogEntity.setLx(fkLogLx);
        fkLogEntity.setLogType(record.getVisRegisterEntity().getVisOk() + 1);
        fkLogEntity.setLogState(0);
        fkLogEntity.setLogSj(date);
        fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
        fkLogService.insertSelective(fkLogEntity);

        String approveState = record.getVisRegisterEntity().getApproveState();
        // int lx = record.getVisRegisterEntity().getVisLx();
        if (visitorParams.getWxAppFlag().equals("1") && "1".equals(record.getType()) && "0".equals(approveState)) {
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
        }

        //visitorParams.getWxAppFlag().equals("1") &&
        String discernType = scmParams.getDiscernType();
        //
        if (("7".equals(approveState) || (!visitorParams.getDoorKeeperApprove().equals("1")
                && ("3".equals(approveState) || "5".equals(approveState))))
                && ("1".equals(discernType) || "3".equals(discernType) || "4".equals(discernType) || "5".equals(discernType))) {
            // VisRegisterNewEntity temp = new VisRegisterNewEntity();
            // temp.setVisSerial(visSerial);
            // temp.setVisState(1);
            // List<VisRegisterNewEntity> listTemp = visRegisterNewService.selectListByEntity(temp);
            // if (listTemp.size() > 0) {
            //     return failMsg("访客已发卡，请先销卡");
            // }

            if (visCardUserService.haveCardsOrQrcode(null, visSerial)) {
                return failMsg("访客已发卡，请先销卡");
            }

            VisRegisterNewEntity visRegisterNewEntity = record.getVisRegisterEntity();

            String carState = visRegisterNewEntity.getCarState();
            if ("1".equals(visitorParams.getPtAppFlag()) && "1".equals(carState) && !StringUtils.isBlank(visRegisterNewEntity.getVisCars())) {
                VisUserNewEntity visUserEntity = visUserNewService.selectByPrimaryKey(visSerial);
                boolean rtn = visCardUserService.insertCardPermission(visUserEntity.getVisLname(), visUserEntity.getCompName(),
                        visUserEntity.getVisId(), visRegisterNewEntity.getVisCars(), visRegisterNewEntity.getVisKssj(),
                        visRegisterNewEntity.getVisJssj());
                if (!rtn) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return failMsg("发卡失败");
                }
            }

            VisRegisterNewEntity entity1 = new VisRegisterNewEntity();

            String areaNo;
            if ("7".equals(approveState)) {
                areaNo = visRegisterNewEntity.getVisArea();
            } else {
                List<VisRegionEntity> tempList = visRegionService.selectListByEntity(null);
                areaNo = String.join(",", tempList.stream().map(VisRegionEntity::getBh).collect(Collectors.toList()));
                String areaName = String.join(",", tempList.stream().map(VisRegionEntity::getName).collect(Collectors.toList()));
                entity1.setVisArea(areaNo);
                entity1.setVisAreaName(areaName);
            }

            String rtn = visCardUserService.insertCardIncrement(visSerial, record.getVisRegisterEntity().getXh(),
                    areaNo, visRegisterNewEntity.getVisKssj(), visRegisterNewEntity.getVisJssj());
            if (!rtn.equalsIgnoreCase(CoreConstants.SUCCESSED_FLAG)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return failMsg("发卡失败");
            }

            entity1.setVisKssjReal(date);
            entity1.setXh(record.getVisRegisterEntity().getXh());
            visRegisterNewService.updateByPrimaryKeySelective(entity1);

            String facePhoto = record.getVisUserEntity().getFacePhoto();
            if ("1".equals(visitorParams.getDeviceType()) && !StringUtils.isBlank(facePhoto)) {
                try {
                    JsonResult<Object> jsonResult = stFaceService.insertStFace(record.getVisUserEntity(), areaNo);
                    if (!CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return jsonResult;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return failMsg();
                }
            }

            // MsgSendEntity msgSendEntity = new MsgSendEntity();
            // String strDate = DateUtils.getCurrentDateTime();
            // msgSendEntity.setMsgState(0);
            // msgSendEntity.setRecordDate(strDate);
            // msgSendEntity.setInsertDate(strDate);
            // msgSendEntity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
            // msgSendEntity.setTempletId("100702");

            // Map<String, String> map = new HashMap<>();
            // map.put("content", "访客已到达，请及时接待");
            // VisThingEntity visThingEntity = visThingService.selectByPrimaryKey(Integer.parseInt(record.getVisRegisterEntity().getVisThing()));
            // map.put("thingName", visThingEntity.getThingName());
            // map.put("visLName", record.getVisUserEntity().getVisLname());
            // map.put("visTelePhone", record.getVisUserEntity().getVisTelephone());
            // map.put("visKssjReal", DateUtils.formatDate(date, "yyyy-MM-dd HH:mm"));
            // msgSendEntity.setMesContent(toJson(map));
            // msgSendEntity.setMsgXh(record.getVisRegisterEntity().getXh() + "");
            // msgSendService.insertSelective(msgSendEntity);
        }
        return succMsgData(record);
    }

    @Logs
    @ApiOperation(value = "人脸录入", notes = "人脸录入")
    @RequestMapping(value = "/updateFace", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateFace(@RequestBody VisUserNewEntity record) {
        // 保存人脸照片
        try {
            String dir;
            if (scmParams.getFaceType().equals("1")) {
                dir = scmParams.getFacePath() + File.separator + (record.getVisSerial() / 1000);
                record.setFacePhotoFlag("2");
            } else {
                dir = scmParams.getPhotoPath() + File.separator + (record.getVisSerial() / 1000);
                record.setFacePhotoFlag("1");
            }

            String path = ImageUtils.base64ToFile(record.getFacePhoto(), record.getVisSerial() + "", "jpg", dir, scmParams.getRootPath());
            commonService.makeFctFile(path);
            record.setFacePhoto(path);
            visUserNewService.updateByPrimaryKeySelective(record);
            VisRegisterEntity visRegisterEntity = new VisRegisterEntity();
            VisRegisterNewEntity entity = visRegisterNewService.selectByPrimaryKey(record.getXh());
            visRegisterEntity.setVisArea(entity.getVisArea());
            visCardUserMapper.insertUpdate4Kq(visRegisterEntity);

            if ("1".equals(visitorParams.getDeviceType()) && !StringUtils.isBlank(path)) {
                VisUserNewEntity visUserNewEntity = visUserNewService.selectByPrimaryKey(record.getVisSerial());
                JsonResult<Object> jsonResult = stFaceService.insertStFace(visUserNewEntity, entity.getVisArea());
                if (!CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return jsonResult;
                }
            }
            return succMsg();
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "审批访客预约信息", notes = "审批访客预约信息")
    @RequestMapping(value = "/updateVis", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateVis(@RequestBody @Valid VisRegisterNewEntity record) {
        Date date = new Date();
        MsgSendEntity msgSendEntity = new MsgSendEntity();
        VisRegisterNewEntity entity = visRegisterNewService.selectByPrimaryKey(record.getXh());
        if (entity == null) {
            return failMsg("未找到访客信息");
        }

        // 写访客日志
        FkLogEntity fkLogEntity = new FkLogEntity();
        fkLogEntity.setLx(1);
        fkLogEntity.setLogType(entity.getVisOk() == null ? 0 : entity.getVisOk() + 1);
        fkLogEntity.setLogState(0);
        fkLogEntity.setLogSj(date);
        fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
        fkLogService.insertSelective(fkLogEntity);

        String discernType = scmParams.getDiscernType();
        String visitorState = record.getVisitorState();

        if ("9".equals(visitorState)) {// 销卡
            if ("9".equals(entity.getVisitorState())) {
                return failMsg("访客已结束访问");
            } else {
                record.setVisJssjReal(date);
                record.setVisState(2);

                // String cardNo;
                // if ("3".equals(discernType) || "4".equals(discernType)) {
                //     cardNo = entity.getVisSerial().toString();
                // } else {
                //     cardNo = record.getVisCard();
                // }
                //
                // boolean flag = visCardUserService.cancelCardIncrement(record.getXh(), entity.getVisSerial(), cardNo,
                //         entity.getVisArea());

                boolean flag = visCardUserService.cancelCardIncrementAll(record.getXh(), entity.getVisSerial(),
                        entity.getVisArea());
                if (flag) {
                    record.setVisState(2);
                } else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return succMsg("销卡失败");
                }

                if ("1".equals(visitorParams.getPtAppFlag()) && "1".equals(entity.getCarState())
                        && !StringUtils.isBlank(entity.getCarries())) {
                    flag = visCardUserService.cancelCardPermission(entity.getVisCars());
                    if (!flag) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return succMsg("销卡失败");
                    }
                }
                visRegisterNewService.updateByPrimaryKeySelective(record);
            }
        } else if ("8".equals(visitorState)) {//发卡
            // 下发卡片
            // String cardNo;
            // if ("3".equals(discernType) || "4".equals(discernType)) {
            //     cardNo = entity.getVisSerial().toString();
            // } else {
            //     cardNo = record.getVisCard();
            // }

            String cardNo = record.getVisCard();

            if ("5".equals(discernType)) {
                if (visCardUserService.haveCards(entity.getVisSerial())) {
                    return failMsg("访客已发卡，请先销卡");
                }
            } else {
                // VisRegisterNewEntity temp = new VisRegisterNewEntity();
                // temp.setVisSerial(entity.getVisSerial());
                // temp.setVisState(1);
                // List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(temp);
                // if (list.size() > 0) {
                //     return failMsg("访客已发卡，请先销卡");
                // }
                if (visCardUserService.haveCardsOrQrcode(null, entity.getVisSerial())) {
                    return failMsg("访客已发卡，请先销卡");
                }
            }

            // VisRegisterNewEntity temp = new VisRegisterNewEntity();
            // temp.setVisCard(cardNo);
            // temp.setVisState(1);
            // List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(temp);
            // if (list.size() > 0) {
            //     return failMsg("该卡片已被使用，请先销卡");
            // }

            if (visCardUserService.haveCardsOrQrcode(cardNo, null)) {
                return failMsg("该卡片已被使用，请先销卡");
            }

            if ("1".equals(visitorParams.getPtAppFlag()) && "1".equals(entity.getCarState()) && !StringUtils.isBlank(entity.getVisCars())) {
                VisUserNewEntity visUserEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
                boolean flag = visCardUserService.insertCardPermission(visUserEntity.getVisLname(), visUserEntity.getCompName(),
                        visUserEntity.getVisId(), entity.getVisCars(), entity.getVisKssj(),
                        entity.getVisJssj());
                if (!flag) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return failMsg("发卡失败");
                }
            }

            String flag = visCardUserService.insertCardIncrement(entity.getVisSerial(), cardNo, record.getXh(),
                    entity.getVisArea(), entity.getVisKssj(), entity.getVisJssj());
            if (!flag.equalsIgnoreCase(CoreConstants.SUCCESSED_FLAG)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return failMsg("发卡失败");
            }
            record.setVisKssjReal(date);
            record.setVisitorState("7");
            visRegisterNewService.updateByPrimaryKeySelective(record);

            if ("1".equals(visitorParams.getDeviceType())) {
                VisUserNewEntity visUserNewEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
                if (!StringUtils.isBlank(visUserNewEntity.getFacePhoto())) {
                    try {
                        JsonResult<Object> jsonResult = stFaceService.insertStFace(visUserNewEntity, entity.getVisArea());
                        if (!CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) {
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            return jsonResult;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return failMsg();
                    }
                }
            }

            // if ("1".equals(visitorParams.getWxAppFlag())) {
            //     String strDate = DateUtils.getCurrentDateTime();
            //     msgSendEntity.setMsgState(0);
            //     msgSendEntity.setRecordDate(strDate);
            //     msgSendEntity.setInsertDate(strDate);
            //     msgSendEntity.setUserSerial(entity.getVisSerial());
            //     msgSendEntity.setTempletId("100702");
            //
            //     Map<String, String> map = new HashMap<>();
            //     map.put("content", "访客已到达，请及时接待");
            //     VisThingEntity visThingEntity = visThingService.selectByPrimaryKey(Integer.parseInt(entity.getVisThing().trim()));
            //     map.put("thingName", visThingEntity.getThingName());
            //     map.put("visLName", entity.getVisLname());
            //     map.put("visTelePhone", entity.getVisTelephone());
            //     map.put("visKssjReal", DateUtils.formatDate(date, "yyyy-MM-dd HH:mm"));
            //     msgSendEntity.setMesContent(toJson(map));
            //     msgSendEntity.setMsgXh(entity.getXh().toString());
            //     msgSendService.insertSelective(msgSendEntity);
            // }
        } else {
            String approveState = record.getApproveState();
            if (!visitorParams.getDoorKeeperApprove().equals("1") && "1".equals(approveState)
                    && ("1".equals(discernType) || "3".equals(discernType) || "4".equals(discernType) || "5".equals(discernType))) {
                // VisRegisterNewEntity temp = new VisRegisterNewEntity();
                // temp.setVisSerial(entity.getVisSerial());
                // temp.setVisState(1);
                // List<VisRegisterNewEntity> listTemp = visRegisterNewService.selectListByEntity(temp);
                // if (listTemp.size() > 0) {
                //     return failMsg("访客已发卡，请先销卡");
                // }

                if (visCardUserService.haveCardsOrQrcode(null, entity.getVisSerial())) {
                    return failMsg("访客已发卡，请先销卡");
                }

                VisSettingEntity visSettingEntity = visSettingService.selectByPrimaryKey("1");
                String carState = visSettingEntity == null ? "0" : visSettingEntity.getSetValue();
                if ("1".equals(visitorParams.getPtAppFlag()) && !StringUtils.isBlank(carState) && carState.equals("1")
                        && !StringUtils.isBlank(entity.getVisCars())) {
                    VisUserNewEntity visUserEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
                    boolean rtn = visCardUserService.insertCardPermission(visUserEntity.getVisLname(), visUserEntity.getCompName(),
                            visUserEntity.getVisId(), entity.getVisCars(), entity.getVisKssj(),
                            entity.getVisJssj());
                    if (!rtn) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return failMsg("发卡失败");
                    }
                }

                List<VisRegionEntity> list = visRegionService.selectListByEntity(null);
                String areaNo = String.join(",", list.stream().map(VisRegionEntity::getBh).collect(Collectors.toList()));
                String areaName = String.join(",", list.stream().map(VisRegionEntity::getName).collect(Collectors.toList()));
                String rtn = visCardUserService.insertCardIncrement(entity.getVisSerial(), record.getXh(),
                        areaNo, entity.getVisKssj(), entity.getVisJssj());
                if (!rtn.equalsIgnoreCase(CoreConstants.SUCCESSED_FLAG)) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return failMsg("发卡失败");
                }
                record.setVisArea(areaNo);
                record.setVisAreaName(areaName);
                record.setVisKssjReal(date);
                record.setVisCard(entity.getVisSerial().toString());

                if ("1".equals(visitorParams.getDeviceType())) {
                    VisUserNewEntity visUserNewEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
                    if (!StringUtils.isBlank(visUserNewEntity.getFacePhoto())) {
                        try {
                            JsonResult<Object> jsonResult = stFaceService.insertStFace(visUserNewEntity, entity.getVisArea());
                            if (!CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) {
                                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                                return jsonResult;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return failMsg();
                        }
                    }
                }
            }
            visRegisterNewService.updateByPrimaryKeySelective(record);
            if ("1".equals(visitorParams.getWxAppFlag())) {
                if (approveState.equals("1") || approveState.equals("2") || approveState.equals("4")) {
                    String strDate = DateUtils.getCurrentDateTime();
                    msgSendEntity.setMsgState(0);
                    msgSendEntity.setRecordDate(strDate);
                    msgSendEntity.setInsertDate(strDate);
                    msgSendEntity.setUserSerial(entity.getVisSerial());
                    msgSendEntity.setTempletId("100701");

                    Map<String, String> map = new HashMap<>();
                    String stateCn;
                    Date kssj;
                    switch (approveState) {
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
                    map.put("approveState", approveState);
                    VisThingEntity visThingEntity = visThingService.selectByPrimaryKey(Integer.parseInt(entity.getVisThing().trim()));
                    map.put("thingName", visThingEntity.getThingName());
                    UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(entity.getUserSerial());
                    map.put("userLname", userInfoEntity.getUserLname());
                    map.put("visKssj", DateUtils.formatDate(kssj, "yyyy-MM-dd HH:mm"));
                    VisUserNewEntity visUserEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
                    map.put("visLName", visUserEntity != null ? visUserEntity.getVisLname() : "");
                    map.put("visTelePhone", visUserEntity != null ? visUserEntity.getVisTelephone() : "");
                    msgSendEntity.setMesContent(toJson(map));
                    msgSendEntity.setMsgXh(record.getXh() + "," + approveState);
                    msgSendService.insertSelective(msgSendEntity);
                }
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "PC端根据身份证号或手机号查询访客预约信息", notes = "PC端根据身份证号或手机号查询访客预约信息")
    @RequestMapping(value = "/selectVisByIdOrTel", method = RequestMethod.GET)
    public JsonResult<Object> selectVisByIdOrTel(@RequestParam String param, String visKeeperNo, Integer xh) {
        List<VisUserNewEntity> visList = visUserNewService.selectByVisIdOrTel(param);
        if (visList.size() > 0) {
            if (visList.size() == 1) {
                VisitorNewEntity visitorNewEntity = new VisitorNewEntity();
                VisUserNewEntity entity = visList.get(0);
                if (!StringUtils.isBlank(entity.getFacePhoto())) {
                    try {
                        entity.setFacePhoto(ImageUtils.imgToBase64(entity.getFacePhoto()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (entity.getVisPhoto() != null && entity.getVisPhoto() == 1) {
                    try {
                        String path = scmParams.getRootPath() + File.separator + scmParams.getVisPhotoPath() + File.separator
                                + (entity.getVisSerial() / 1000) + File.separator
                                + entity.getVisSerial().toString() + ".jpg";
                        entity.setCardPhoto(ImageUtils.imgToBase64(path));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                visitorNewEntity.setVisUserEntity(entity);

                VisRegisterNewEntity visRegisterNewEntity = new VisRegisterNewEntity();
                visRegisterNewEntity.setXh(xh);
                visRegisterNewEntity.setVisSerial(visList.get(0).getVisSerial());
                visRegisterNewEntity.setVisState(0);
                visRegisterNewEntity.setApproveState("1,3,5,7");
                if (visitorParams.isDoorKeeperSelf()) {
                    visRegisterNewEntity.setVisKeeperNo(visKeeperNo);
                }
                List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(visRegisterNewEntity);
                if (list.size() > 0) {
                    if (list.size() == 1) {
                        visitorNewEntity.setVisRegisterEntity(list.get(0));
                        return succMsgData(visitorNewEntity);
                    } else {
                        return message("611", list);
                    }
                } else {
                    return succMsgData(visitorNewEntity);
                }
            } else {
                List<Long> visSerials = visList.stream().map(VisUserNewEntity::getVisSerial).collect(Collectors.toList());
                VisRegisterNewEntity visRegisterNewEntity = new VisRegisterNewEntity();
                visRegisterNewEntity.setXh(xh);
                visRegisterNewEntity.setVisSerials(visSerials);
                visRegisterNewEntity.setVisState(0);
                visRegisterNewEntity.setApproveState("1,3,7");
                if (visitorParams.isDoorKeeperSelf()) {
                    visRegisterNewEntity.setVisKeeperNo(visKeeperNo);
                }
                List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(visRegisterNewEntity);
                if (list.size() > 0) {
                    if (list.size() == 1) {
                        List<VisUserNewEntity> temp = visList.stream().filter(t -> t.getVisSerial().intValue() == list.get(0).getVisSerial().intValue()).collect(Collectors.toList());
                        VisitorNewEntity visitorNewEntity = new VisitorNewEntity();
                        VisUserNewEntity entity = temp.get(0);
                        if (!StringUtils.isBlank(entity.getFacePhoto())) {
                            try {
                                entity.setFacePhoto(ImageUtils.imgToBase64(entity.getFacePhoto()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        if (entity.getVisPhoto() != null && entity.getVisPhoto() == 1) {
                            try {
                                String path = scmParams.getRootPath() + File.separator + scmParams.getVisPhotoPath() + File.separator
                                        + (entity.getVisSerial() / 1000) + File.separator
                                        + entity.getVisSerial().toString() + ".jpg";
                                entity.setCardPhoto(ImageUtils.imgToBase64(path));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        visitorNewEntity.setVisUserEntity(entity);
                        visitorNewEntity.setVisRegisterEntity(list.get(0));
                        return succMsgData(visitorNewEntity);
                    } else {
                        return message("611", list);
                    }
                } else {
                    return message("612", "访客信息不存在");
                }
            }
        } else {
            return message("612", "访客信息不存在");
        }
    }

    @Logs
    @ApiOperation(value = "查询VisRegisterNew清单", notes = "查询VisRegisterNew清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegisterNewEntity>> selectListPageByEntity(@RequestBody BasePageSearch<VisRegisterNewEntity> record) {
        setPageHelper(record);
        VisRegisterNewEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisRegisterNewEntity();
        }
        if (!visitorParams.isDoorKeeperSelf()) {
            entity.setVisKeeperNo(null);
        }
        if (entity.getVisState() != null && entity.getVisState() == 0) {
            entity.setApproveState("1,3,5,7");
        }

        // 0 审核中 1 已通过 2 已拒绝 3 已邀请 4 已确认 5 已登记 6 7 已验证 8 访问中 9 已访问 10 已失效
        if (entity.getVisState() != null && entity.getVisState() == -1) {
            entity.setVisState(null);
            entity.setApproveState("1,3,5,7,8,9");
        }
        List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(entity);
        for (VisRegisterNewEntity visRegisterNewEntity : list) {

            int visitorState = Integer.parseInt(visRegisterNewEntity.getVisitorState() == null ? "-1" : visRegisterNewEntity.getVisitorState());
            int approveState = Integer.parseInt(visRegisterNewEntity.getApproveState() == null ? "-1" : visRegisterNewEntity.getApproveState());
            int state = Math.max(visitorState, approveState);
            visRegisterNewEntity.setState(state == -1 ? "" : state + "");
        }
        dicFmtBean.DicFormat(list.toArray(new VisRegisterNewEntity[0]), new String[]{"02001", "02002", "02004"});
        return succMsgData(new BaseCommPager<VisRegisterNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询VisRegisterNew列表", notes = "查询VisRegisterNew列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<VisRegisterNewEntity>> selectListByEntity(@RequestBody VisRegisterNewEntity record) {
        List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除VisRegisterNew信息", notes = "删除VisRegisterNew信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        visRegisterNewService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询VisRegisterNew信息", notes = "查询VisRegisterNew信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<VisitorNewEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        VisitorNewEntity visitorNewEntity = new VisitorNewEntity();
        VisRegisterNewEntity entity = visRegisterNewService.selectByPrimaryKey(xh);
        entity.setCompanyName(regService.selectByPrimaryKey().getRegUnit());
        String approveStateStr = entity.getApproveState();
        String doorKeeperApprove = visitorParams.getDoorKeeperApprove();
        String discernType = scmParams.getDiscernType();
        if (("3".equals(discernType) || "4".equals(discernType) || "5".equals(discernType))
                && (("1".equals(approveStateStr) && !"1".equals(doorKeeperApprove)) || "3".equals(approveStateStr)
                || approveStateStr.equals("7"))) {
            String qrCode = visCardUserService.getVisCodeStr(entity.getVisSerial().toString(), entity.getVisKssj(), entity.getVisJssj());
            entity.setQrcode(qrCode);

            UserInfoEntity userInfoEntity = userInfoService.selectByPrimaryKey(entity.getUserSerial());
            entity.setUserLname(userInfoEntity.getUserLname());
            entity.setTelePhone(userInfoEntity.getUserTelephone());
        }

        int visitorState = Integer.parseInt(entity.getVisitorState() == null ? "-1" : entity.getVisitorState());
        int approveState = Integer.parseInt(approveStateStr == null ? "-1" : approveStateStr);
        int state = Math.max(visitorState, approveState);
        entity.setState(state == -1 ? "" : state + "");
        dicFmtBean.DicFormat(entity, new String[]{"02002"});
        visitorNewEntity.setVisRegisterEntity(entity);

        VisUserNewEntity visUserNewEntity = visUserNewService.selectByPrimaryKey(entity.getVisSerial());
        if (!StringUtils.isBlank(visUserNewEntity.getFacePhoto())) {
            try {
                visUserNewEntity.setFacePhoto(ImageUtils.imgToBase64(visUserNewEntity.getFacePhoto()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (visUserNewEntity.getVisPhoto() != null && visUserNewEntity.getVisPhoto() == 1) {
            try {
                String path = scmParams.getRootPath() + File.separator + scmParams.getVisPhotoPath() + File.separator
                        + (visUserNewEntity.getVisSerial() / 1000) + File.separator
                        + visUserNewEntity.getVisSerial().toString() + ".jpg";
                visUserNewEntity.setCardPhoto(ImageUtils.imgToBase64(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        visitorNewEntity.setVisUserEntity(visUserNewEntity);
        return succMsgData(visitorNewEntity);
    }

    @Logs
    @ApiOperation(value = "关键字查询VisRegisterNew信息", notes = "关键字查询VisRegisterNew信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegisterNewEntity>> selectListByKeys(@RequestBody BasePageSearch<VisRegisterNewEntity> record) {
        setPageHelper(record);
        List<VisRegisterNewEntity> list = visRegisterNewService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<VisRegisterNewEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除VisRegisterNew信息", notes = "批量删除VisRegisterNew信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<VisRegisterNewEntity> list = JSONObject.parseArray(keys, VisRegisterNewEntity.class);
        List<VisRegisterNewEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                visRegisterNewService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "PC端根据卡号查找访客信息", notes = "PC端根据卡号查找访客信息")
    @RequestMapping(value = "/selectInfoByCardNo", method = RequestMethod.GET)
    public JsonResult<VisRegisterNewEntity> selectInfoByCardNo(@RequestParam String cardNo, String visKeeperNo) {
        VisRegisterNewEntity entity = new VisRegisterNewEntity();
        entity.setVisCard(cardNo);
        if (visitorParams.isDoorKeeperSelf()) {
            entity.setVisKeeperNo(visKeeperNo);
        }

        entity.setVisState(1);
        List<VisRegisterNewEntity> list = visRegisterNewService.selectListByEntity(entity);
        if (list.size() == 0) {
            return failMsg("未找到访客记录");
        }

        try {
            if (!StringUtils.isBlank(list.get(0).getFacePhoto())) {
                list.get(0).setFacePhoto(ImageUtils.imgToBase64(list.get(0).getFacePhoto()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return succMsgData(list.get(0));
    }
}