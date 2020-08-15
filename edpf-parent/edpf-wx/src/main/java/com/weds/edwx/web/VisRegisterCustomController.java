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
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.service.SysParamService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
public class VisRegisterCustomController extends BaseController {
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

    @Resource
    private DicFmtBean dicFmtBean;

    @Autowired
    private VisRegionService visRegionService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private VisCardUserService visCardUserService;

    @Resource
    private ScmParams scmParams;

    @Autowired
    private TtSexService ttSexService;

    @Resource
    private CommonService commonService;

    @Resource
    private SysParamService sysParamService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "PC端根据卡号查找访客信息", notes = "PC端根据卡号查找访客信息")
    @RequestMapping(value = "/selectInfoByCardNo", method = RequestMethod.GET)
    public JsonResult<VisRegisterEntity> selectInfoByCardNo(@RequestParam String cardNo, @RequestParam String visKeeperNo) {
        VisRegisterEntity entity = new VisRegisterEntity();
        entity.setVisCard(cardNo);
        entity.setVisKeeperNo(visKeeperNo);
        entity.setVisState(1);
        List<VisRegisterEntity> list = visRegisterService.selectVisListByEntity(entity);
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


    @Logs
    @ApiOperation(value = "PC端查询访客列表", notes = "PC端查询访客列表")
    @RequestMapping(value = "/selectVisListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<VisRegisterEntity>> selectVisListPageByEntity(@RequestBody BasePageSearch<VisRegisterEntity> record) {
        setPageHelper(record);
        VisRegisterEntity entity = record.getSearch();
        if (entity == null) {
            entity = new VisRegisterEntity();
        }
        // Date date = new Date();
        // if (entity.getStartDate() == null) {
        //     entity.setStartDate(date);
        // }
        // if (entity.getEndDate() == null) {
        //     entity.setEndDate(date);
        // }
        List<VisRegisterEntity> list = visRegisterService.selectVisListByEntity(entity);
        return succMsgData(new BaseCommPager<VisRegisterEntity>(list));
    }

    @Logs
    @ApiOperation(value = "PC端根据身份证号查询未发卡访客预约信息", notes = "PC端根据身份证号查询未发卡访客预约信息")
    @RequestMapping(value = "/selectVisById", method = RequestMethod.GET)
    public JsonResult<VisitorEntity> selectVisById(@RequestParam String visNo, String visKeeperNo) {
        VisitorEntity visitorEntity = new VisitorEntity();
        VisUserEntity visUserEntity = visUserService.selectByCardId(visNo);
        try {
            if (visUserEntity != null) {
                TtSexEntity ttSexEntity = new TtSexEntity();
                ttSexEntity.setTtName(visUserEntity.getVisSex());
                List<TtSexEntity> list = ttSexService.selectListByEntity(ttSexEntity);
                if (list.size() > 0) {
                    visUserEntity.setTtOrder(list.get(0).getTtOrder());
                }
                if (!StringUtils.isBlank(visUserEntity.getFacePhoto())) {
                    visUserEntity.setFacePhoto(ImageUtils.imgToBase64(visUserEntity.getFacePhoto()));
                }

                if (!StringUtils.isBlank(visUserEntity.getCardPhoto())) {
                    visUserEntity.setCardPhoto(ImageUtils.imgToBase64(visUserEntity.getCardPhoto()));
                }

                visitorEntity.setVisUserEntity(visUserEntity);

                // VisRegisterEntity temp = new VisRegisterEntity();
                // temp.setVisSerial(visUserEntity.getVisSerial());
                // temp.setVisState(1);
                // List<VisRegisterEntity> searchList = visRegisterService.selectVisListByEntity(temp);
                // if (searchList.size() > 0) {
                //     VisRegisterEntity visRegisterEntity = searchList.get(0);
                //     visRegisterEntity.setVisThing(visRegisterEntity.getVisThing().trim());
                //     visitorEntity.setVisRegisterEntity(visRegisterEntity);
                //     return message("610", "访客已发卡，请先销卡", visitorEntity);
                // }

                VisRegisterEntity visRegisterEntity = visRegisterService.selectVisiting(visUserEntity.getVisSerial());
                if (visRegisterEntity != null) {
                    if (visRegisterEntity.getVisState() == 1) {
                        return message("610", "访客已发卡，请先销卡", visitorEntity);
                    } else {
                        visRegisterEntity.setVisThing(visRegisterEntity.getVisThing().trim());
                        visitorEntity.setVisRegisterEntity(visRegisterEntity);
                    }
                }

                // VisRegisterEntity visRegisterEntity = visRegisterService.selectTodayRecord(visUserEntity.getVisSerial(),
                //         DateUtils.getCurrentDate(), visKeeperNo);
                // if (visRegisterEntity != null) {
                //     visRegisterEntity.setVisThing(visRegisterEntity.getVisThing().trim());
                //     visitorEntity.setVisRegisterEntity(visRegisterEntity);
                // }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsgData(visitorEntity);
    }


    @Logs
    @ApiOperation(value = "根据序号查询访客预约信息", notes = "根据序号查询访客预约信息")
    @RequestMapping(value = "/selectByXh", method = RequestMethod.GET)
    public JsonResult<VisitorEntity> selectByXh(@RequestParam Integer xh) {
        VisitorEntity visitorEntity = new VisitorEntity();
        try {
            VisRegisterEntity entity = visRegisterService.selectByPrimaryKey(xh);
            int visitorState = Integer.parseInt(entity.getVisitorState() == null ? "-1" : entity.getVisitorState());
            int approveState = Integer.parseInt(entity.getApproveState() == null ? "-1" : entity.getApproveState());
            int state = Math.max(visitorState, approveState);
            entity.setState(state == -1 ? "" : state + "");
            dicFmtBean.DicFormat(entity, new String[]{"02002"});
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
    @ApiOperation(value = "PC端用户发卡", notes = "PC端用户发卡")
    @RequestMapping(value = "/sendCard", method = RequestMethod.GET)
    @Transactional
    public JsonResult<Object> sendCard(@RequestParam Integer xh, @RequestParam String cardNo, @RequestParam String visKeeperNo) {
        VisRegisterEntity temp = new VisRegisterEntity();
        temp.setXh(xh);
        temp.setVisKeeperNo(visKeeperNo);
        List<VisRegisterEntity> listVisReg = visRegisterService.selectVisListByEntity(temp);
        VisRegisterEntity visRegisterEntity;
        if (listVisReg.size() == 0) {
            return failMsg("未找到访客信息");
        } else {
            visRegisterEntity = listVisReg.get(0);
        }
        // VisRegisterEntity visRegisterEntity = visRegisterService.selectByPrimaryKey(xh);
        VisRegisterEntity entity = new VisRegisterEntity();
        entity.setVisSerial(visRegisterEntity.getVisSerial());
        entity.setVisKeeperNo(visKeeperNo);
        entity.setVisState(1);
        List<VisRegisterEntity> list = visRegisterService.selectVisListByEntity(entity);
        if (list.size() > 0) {
            return failMsg("访客已发卡，请先销卡");
        }

        entity = new VisRegisterEntity();
        entity.setVisCard(cardNo);
        entity.setVisState(1);
        list = visRegisterService.selectVisListByEntity(entity);
        if (list.size() > 0) {
            return failMsg("该卡片已被使用，请先销卡");
        }

        String ptApp = sysParamService.selectValueByPrimaryKey("SYSTEM_PT_APP");
        if ("1".equals(ptApp) && !StringUtils.isBlank(visRegisterEntity.getCarState()) && visRegisterEntity.getCarState().equals("1")
                && !StringUtils.isBlank(visRegisterEntity.getVisCars())) {
            VisUserEntity visUserEntity = visUserService.selectByVisSerial(visRegisterEntity.getVisSerial());
            boolean flag = visCardUserService.insertCardPermission(visUserEntity.getVisLname(), visUserEntity.getCompName(),
                    visUserEntity.getVisId(), visRegisterEntity.getVisCars(), visRegisterEntity.getVisKssj(),
                    visRegisterEntity.getVisJssj());
            if (!flag) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return failMsg("发卡失败");
            }
        }

        String flag = visCardUserService.insertCardIncrement(visRegisterEntity.getVisSerial(), cardNo, xh,
                visRegisterEntity.getVisArea(), visRegisterEntity.getVisKssj(), visRegisterEntity.getVisJssj());
        if (!flag.equalsIgnoreCase(CoreConstants.SUCCESSED_FLAG)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return failMsg("发卡失败");
        }

        VisRegisterEntity registerEntity = new VisRegisterEntity();
        registerEntity.setXh(xh);
        registerEntity.setVisKssjReal(new Date());
        visRegisterService.updateByPrimaryKeySelective(registerEntity);
        commonService.makeFctFile(visRegisterEntity.getVisSerial());

        return succMsg("发卡成功");
    }

    @Logs
    @ApiOperation(value = "PC端用户销卡", notes = "PC端用户销卡")
    @RequestMapping(value = "/destroyCard", method = RequestMethod.GET)
    @Transactional
    public JsonResult<Object> destroyCard(@RequestParam Integer xh, @RequestParam String visKeeperNo) {
        VisRegisterEntity entity = new VisRegisterEntity();
        entity.setXh(xh);
        entity.setVisKeeperNo(visKeeperNo);
        List<VisRegisterEntity> list = visRegisterService.selectVisListByEntity(entity);
        VisRegisterEntity visRegisterEntity;
        if (list.size() == 0) {
            return failMsg("未找到访客信息");
        } else {
            visRegisterEntity = list.get(0);
        }
        boolean flag = visCardUserService.cancelCardIncrement(xh, visRegisterEntity.getVisSerial(),
                visRegisterEntity.getVisArea());
        if (flag) {
            VisRegisterEntity record = new VisRegisterEntity();
            record.setXh(xh);
            record.setVisState(2);
            visRegisterService.updateByPrimaryKeySelective(record);
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return succMsg("销卡失败");
        }

        String ptApp = sysParamService.selectValueByPrimaryKey("SYSTEM_PT_APP");
        if ("1".equals(ptApp) && !StringUtils.isBlank(visRegisterEntity.getCarState()) && visRegisterEntity.getCarState().equals("1")
                && !StringUtils.isBlank(visRegisterEntity.getCarries())) {
            flag = visCardUserService.cancelCardPermission(visRegisterEntity.getCarries());
            if (!flag) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return succMsg("销卡失败");
            }
        }
        VisRegisterEntity registerEntity = new VisRegisterEntity();
        registerEntity.setXh(xh);
        registerEntity.setVisJssjReal(new Date());
        visRegisterService.updateByPrimaryKeySelective(registerEntity);
        return succMsg("销卡成功");
    }

    private JsonResult<Object> insertOrUpdateInfo(VisitorEntity record) {
        FkLogEntity fkLogEntity = new FkLogEntity();
        VisFailEntity entity = new VisFailEntity();
        Date date = new Date();

        long visSerial;
        int fkLogLx = 0;
        if (record.getVisRegisterEntity().getXh() != null) {
            fkLogLx = 1;
        }

        entity.setVisNo(record.getVisUserEntity().getVisId());
        entity.setUserSerial(record.getVisRegisterEntity().getUserSerial());
        entity.setVisNums(record.getVisRegisterEntity().getVisNums());
        entity.setVisCars(record.getVisRegisterEntity().getVisCars());
        entity.setVisKssj(record.getVisRegisterEntity().getVisKssj());
        entity.setVisThing(record.getVisRegisterEntity().getVisThing());
        entity.setVisBz(record.getVisRegisterEntity().getVisBz());
        entity.setVisOk(record.getVisRegisterEntity().getVisOk());
        entity.setSj(date);

        VisUserEntity visUserEntity = visUserService.selectByCardId(record.getVisUserEntity().getVisId());
        if (visUserEntity != null) {
            visSerial = visUserEntity.getVisSerial();
            // 验证来访人是否在黑名单
            VisBlackEntity visBlackEntity = visBlackService.selectByCardId(record.getVisUserEntity().getVisId());
            if (visBlackEntity != null) {
                entity.setVisSerial(visSerial);
                entity.setVisFail(fkLogLx);
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
            // if (fkLogLx == 0) {
            //删除当天访客登记记录
            // visRegisterService.deleteTodayRecord(visUserEntity.getVisSerial(), DateUtils.getCurrentDate());
            // }
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
            fkLogEntity.setLx(fkLogLx);
            fkLogEntity.setLogType(0);
            fkLogEntity.setLogState(7);
            fkLogEntity.setLogSj(date);
            fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
            fkLogService.insertSelective(fkLogEntity);
            return message("611", "被访人不接受访问");
        }

        // if (visUserEntity != null && visUserEntity.getVisSerial() != null) {
        //     VisRegisterEntity temp = new VisRegisterEntity();
        //     temp.setVisSerial(visUserEntity.getVisSerial());
        //     temp.setVisState(1);
        //     List<VisRegisterEntity> searchList = visRegisterService.selectVisListByEntity(temp);
        //     if (searchList.size() > 0) {
        //         return failMsg("访客已发卡，请先销卡");
        //     }
        // }

        if (visUserEntity != null && visUserEntity.getVisSerial() != null) {
            VisRegisterEntity visRegisterEntity = visRegisterService.selectVisiting(visUserEntity.getVisSerial());
            if (visRegisterEntity != null) {
                if (visRegisterEntity.getVisState() == 1) {
                    return failMsg("访客已发卡，请先销卡");
                } else {
                    if (fkLogLx == 0) {
                        return failMsg("访客已预约，无法再次预约");
                    }
                }
            }
        }

        record.getVisUserEntity().setVisSj(date);
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
                path = ImageUtils.base64ToFile(photo, visSerial + "", "jpg", dir, scmParams.getRootPath());
                commonService.makeFctFile(path);
                record.getVisUserEntity().setFacePhoto(path);
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg();
            }
        } else {
            record.getVisUserEntity().setFacePhotoFlag("0");
        }

        String cardPhoto = record.getVisUserEntity().getCardPhoto();
        if (!StringUtils.isBlank(cardPhoto)) {
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
            record.getVisUserEntity().setVisPhoto(0);
        }
        if (!StringUtils.isBlank(record.getVisUserEntity().getVisSex())) {
            TtSexEntity ttSexEntity = ttSexService.selectByPrimaryKey(Short.parseShort(record.getVisUserEntity().getVisSex()));
            record.getVisUserEntity().setVisSex(ttSexEntity.getTtName());
        }
        int flag = visUserService.updateByIdSelective(record.getVisUserEntity());
        if (flag == 0) {
            record.getVisUserEntity().setVisSerial(visSerial);
            visUserService.insert(record.getVisUserEntity());
            // 写访客日志
            fkLogEntity.setLx(fkLogLx);
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

        String area = record.getVisRegisterEntity().getVisArea();
        if (!StringUtils.isBlank(area)) {
            List<VisRegionEntity> list = visRegionService.selectListByBh(area);
            String areaName = String.join(",", list.stream().map(VisRegionEntity::getName).collect(Collectors.toList()));
            record.getVisRegisterEntity().setVisAreaName(areaName);
        }

        record.getVisRegisterEntity().setSj(date);
        record.getVisRegisterEntity().setVisSerial(visSerial);
        record.getVisRegisterEntity().setVisState(0);

        if (fkLogLx == 0) {
            visRegisterService.insertSelective(record.getVisRegisterEntity());
        } else {
            visRegisterService.updateByPrimaryKeySelective(record.getVisRegisterEntity());
        }

        // 写访客日志
        fkLogEntity.setLx(fkLogLx);
        fkLogEntity.setLogType(record.getVisRegisterEntity().getVisOk() + 1);
        fkLogEntity.setLogState(0);
        fkLogEntity.setLogSj(date);
        fkLogEntity.setLogIp(httpServletRequest.getRemoteAddr());
        fkLogService.insertSelective(fkLogEntity);
        return succMsgData(record.getVisRegisterEntity().getXh());
    }

    @Logs
    @ApiOperation(value = "PC端新增VisRegister信息", notes = "PC端新增VisRegister信息")
    @RequestMapping(value = "/insertInfo", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insertInfo(@RequestBody VisitorEntity record) {
        return this.insertOrUpdateInfo(record);
    }

    @Logs
    @ApiOperation(value = "更新VisRegister信息", notes = "更新VisRegister信息")
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateAll(@RequestBody VisitorEntity record) {
        return this.insertOrUpdateInfo(record);
    }
}