package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author sxm
 * @Description Meet管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/meet")
@Api(value = "会议管理", description = "会议管理")
public class MeetController extends BaseController {
    @Autowired
    private MeetService meetService;
    @Autowired
    private DeviceMonitorService deviceMonitorService;
    @Autowired
    private MODULEService moduleService;
    @Autowired
    private MeetMdService meetMdService;
    @Resource
    private TkqRoomService tkqRoomService;
    @Resource
    private MeetSpService meetSpService;
    @Resource
    private MeetGuizeService meetGuizeService;
    @Resource
    private MsgSendService msgSendService;
    @Resource
    private UserService userService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "查询与自己有关的会议日期，用于日历标红显示", notes = "查询与自己有关的会议日期，用于日历标红显示")
    @RequestMapping(value = "/selectDateListByEntity", method = RequestMethod.POST)
    public JsonResult<List<TimeEntity>> selectDateListByEntity(@RequestBody QueryTimeEntity record) {
        //可用参数为 userSerial
        List<TimeEntity> list = meetService.selectDateListByEntity(record);
        return succMsgData(list);
    }

    @ApiOperation(value = "根据会议室编号和日期获取会议列表", notes = "根据会议室编号和日期获取会议列表")
    @RequestMapping(value = "/selectMeetListByRoom", method = RequestMethod.POST)
    public JsonResult<List<MeetEntity>> selectMeetListByRoom(@RequestBody TimeEntity record) {
        try {
            //可用参数为 cdate，userSerial，roomBh
            List<MeetEntity> list = meetService.selectMeetListByRoom(record);
            return succMsgData(list);
        } catch (Exception e) {
            return failMsg("传入的日期格式有误");
        }
    }

    @Logs
    @ApiOperation(value = "查询指定日期的我预约或者参加的会议清单", notes = "查询指定日期的我预约或者参加的会议清单")
    @RequestMapping(value = "/selectMyMeetListByDate", method = RequestMethod.POST)
    public JsonResult<List<MeetEntity>> selectMyMeetListByDate(@RequestBody TimeEntity record) {
        try {
            //可用参数为 cdate，userSerial，type
            List<MeetEntity> list = meetService.selectMyMeetListByDate(record);
            return succMsgData(list);
        } catch (Exception e) {
            return failMsg("传入的日期格式有误");
        }
    }

    @Logs
    @ApiOperation(value = "查询会议详情页面", notes = "查询会议详情页面")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MeetEntity> selectByPrimaryKey(@RequestParam Integer bh, @RequestParam Integer userSerial) {
        MeetEntity entity = meetService.selectByPrimaryKey(bh, userSerial);
        if (entity == null) {
            return failMsg("该会议不存在或已被撤销");
        }
        MeetSpEntity meetSpEntity = new MeetSpEntity();
        meetSpEntity.setMeetBh(bh);
        List<MeetSpEntity> list = meetSpService.selectListByEntity(meetSpEntity);
        List<MeetSpEntity> result = new ArrayList<>();
        for (MeetSpEntity spEntity : list) {
            result.add(spEntity);
            if (spEntity.getSpFlag() == 0) {
                break;
            } else {
                if (spEntity.getSpJg() == 2) {
                    break;
                }
            }
        }
        entity.setList(result);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "会议预约", notes = "会议预约")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody MeetEntity record) {
        //先判断设备是否在线，不在线的话直接返回 失败
        int onlineState = deviceMonitorService.selectByRoomBh(record.getRoomSerial());
        if (onlineState == 0) {
            return failMsg("设备不在线,无法预约会议");
        }
        //获取本次会议编号
        MODULEEntity moduleEntity = moduleService.selectMeetBhByPrimaryKey("0017");
        record.setBh(Integer.parseInt(moduleEntity.getModuleUser().toString()));
        //判断该段时间内会议室是否有会议存在
        int meetCount = meetService.selectMeetByEntity(record);
        if (meetCount > 0) {
            return failMsg("您预约的时间已经被占用,请修改您的预约时间");
        }
        //判断该时间段内会议室绑定的设备是否有会议存在
        int devCout = meetService.selectMeetByDev(record);
        if (devCout > 0) {
            return failMsg("该会议室的会议签到设备已经被占用,请联系管理员为会议室更换会议设备");
        }
        //判断该段时间内的人员是否有其他会议需要参加(二期考虑)

        record.setModuleId("0017");//会议moduleid
        record.setSj(new Date());//当前时间
        //插入会议表
        meetService.insert(record);
        //插入会议名单表
        meetMdService.insert(record);

        //插入会议规则表
        if (meetService.selectMeetRule(record) == 0) {
            meetService.insertMeetRule(record);
        }

        TkqRoomEntity entity = tkqRoomService.selectByPrimaryKey(record.getRoomSerial());
        if (entity.getSp() == 0) {
            //插入会议和设备关系表
            meetService.insertMeetDev(record);
            //插入增量日志表（兼容老设备）jreal_update_1
            meetService.insertUpdate1ByDev(record);
            //插入增量日志表 jreal_update_2,3,4,5
            meetService.insertUpdate2To5ByDev(record);

            if (record.getWxNotice() != null && 1 == record.getWxNotice()) { //是否微信通知与会人员
                record.setRecordTime(DateUtils.getCurrentDateTime());
                meetService.insertWxNotice(record);
            }
        } else {
            String[] approvers = record.getMeetApprovalsStr().split(",");
            List<MeetSpEntity> list = new ArrayList<>();
            for (int i = 0; i < approvers.length; i++) {
                if (i == 0) {
                    MsgSendEntity msgSendEntity = new MsgSendEntity();
                    String strDate = DateUtils.getCurrentDateTime();
                    msgSendEntity.setMsgState(0);
                    msgSendEntity.setRecordDate(strDate);
                    msgSendEntity.setInsertDate(strDate);
                    msgSendEntity.setUserSerial(Long.parseLong(approvers[i]));
                    msgSendEntity.setTempletId("100802");

                    Map<String, String> map = new HashMap<>();
                    map.put("meetname", "您好，您收到一个会议室预约请求");
                    UserEntity userEntity = userService.selectByUserNo(record.getAppointment());
                    map.put("userLname", userEntity.getUserLname());
                    map.put("meettime", DateUtils.formatDate(record.getKssj(), "yyyy-MM-dd HH:mm"));
                    map.put("meetroom", entity.getDepName());
                    msgSendEntity.setMesContent(toJson(map));
                    msgSendEntity.setMsgXh(moduleEntity.getModuleUser().toString());
                    msgSendService.insertSelective(msgSendEntity);
                }
                MeetSpEntity meetSpEntity = new MeetSpEntity();
                meetSpEntity.setUserSerial(Long.parseLong(approvers[i]));
                meetSpEntity.setSpOrder(i);
                meetSpEntity.setSpJg(1);
                meetSpEntity.setSpFlag(0);
                meetSpEntity.setMeetBh(record.getBh());
                list.add(meetSpEntity);
            }
            meetSpService.insertBatch(list);
        }
        //插入操作日志
        meetService.insertOperateLog(record);
        return succMsgData(record);
    }

    @Logs
    @ApiOperation(value = "会议审批", notes = "会议审批")
    @RequestMapping(value = "/approveMeeting", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> approveMeeting(@RequestBody MeetSpEntity record) {
        Integer bh = record.getMeetBh();
        MeetEntity meetEntity = meetService.selectMeetInfo(bh);
        MeetGuizeEntity meetGuizeEntity = meetGuizeService.selectByPrimaryKey(bh);
        meetEntity.setJsqdsj(meetGuizeEntity.getJsqdsj());
        meetEntity.setKsqdsj(meetGuizeEntity.getKsqdsj());
        int meetCount = meetService.selectMeetByEntity(meetEntity);
        if (meetCount > 0) {
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return failMsg("会议预约时间已被占用");
        }
        record.setSj(new Date());
        meetSpService.approveMeeting(record);
        if (record.getSpJg() == 1) {
            int flag = meetSpService.isMeetApproveFinished(bh);
            if (flag == 0) {
                meetEntity.setSj(new Date());
                StringBuilder sb = new StringBuilder();
                List<MeetMdEntity> list = meetMdService.selectUserListByBh(bh);
                for (MeetMdEntity meetMdEntity : list) {
                    sb.append(meetMdEntity.getUserSerial()).append(",");
                }
                meetEntity.setMeetUsersStr(sb.substring(0, sb.length() - 1));
                //插入会议和设备关系表
                meetService.insertMeetDev(meetEntity);
                //插入增量日志表（兼容老设备）jreal_update_1
                meetService.insertUpdate1ByDev(meetEntity);
                //插入增量日志表 jreal_update_2,3,4,5
                meetService.insertUpdate2To5ByDev(meetEntity);

                if (meetEntity.getWxNotice() != null && 1 == meetEntity.getWxNotice()) { //是否微信通知与会人员
                    meetEntity.setRecordTime(DateUtils.getCurrentDateTime());
                    meetService.insertWxNotice(meetEntity);
                }
            } else {
                MeetSpEntity meetSpEntity = new MeetSpEntity();
                meetSpEntity.setUserSerial(record.getUserSerial());
                meetSpEntity.setMeetBh(bh);
                MeetSpEntity entity = meetSpService.selectNextApprover(meetSpEntity);
                if (entity != null) {
                    MsgSendEntity msgSendEntity = new MsgSendEntity();
                    String strDate = DateUtils.getCurrentDateTime();
                    msgSendEntity.setMsgState(0);
                    msgSendEntity.setRecordDate(strDate);
                    msgSendEntity.setInsertDate(strDate);
                    msgSendEntity.setUserSerial(entity.getUserSerial());
                    msgSendEntity.setTempletId("100802");

                    Map<String, String> map = new HashMap<>();
                    map.put("meetname", "您好，您收到一个会议室预约请求");
                    UserEntity userEntity = userService.selectByUserNo(meetEntity.getAppointment());
                    map.put("userLname", userEntity.getUserLname());
                    map.put("meettime", DateUtils.formatDate(meetEntity.getKssj(), "yyyy-MM-dd HH:mm"));
                    TkqRoomEntity tkqRoomEntity = tkqRoomService.selectByPrimaryKey(meetEntity.getRoomSerial());
                    map.put("meetroom", tkqRoomEntity.getDepName());
                    msgSendEntity.setMesContent(toJson(map));
                    msgSendEntity.setMsgXh(bh.toString());
                    msgSendService.insertSelective(msgSendEntity);
                }
            }
        } else {
            UserEntity userEntity = userService.selectByUserNo(meetEntity.getAppointment());
            MsgSendEntity msgSendEntity = new MsgSendEntity();
            String strDate = DateUtils.getCurrentDateTime();
            msgSendEntity.setMsgState(0);
            msgSendEntity.setRecordDate(strDate);
            msgSendEntity.setInsertDate(strDate);
            msgSendEntity.setUserSerial(userEntity.getUserSerial());
            msgSendEntity.setTempletId("100802");

            Map<String, String> map = new HashMap<>();
            map.put("meetname", "您好，您的会议室预约申请审批拒绝");
            map.put("userLname", userEntity.getUserLname());
            map.put("meettime", DateUtils.formatDate(meetEntity.getKssj(), "yyyy-MM-dd HH:mm"));
            TkqRoomEntity tkqRoomEntity = tkqRoomService.selectByPrimaryKey(meetEntity.getRoomSerial());
            map.put("meetroom", tkqRoomEntity.getDepName());
            msgSendEntity.setMesContent(toJson(map));
            msgSendEntity.setMsgXh(bh.toString());
            msgSendService.insertSelective(msgSendEntity);
        }

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取会议审批列表", notes = "获取会议审批列表")
    @RequestMapping(value = "/selectMeetList", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetSpEntity>> selectMeetList(@RequestBody BasePageSearch<MeetSpEntity> record) {
        setPageHelper(record);
        MeetSpEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetSpEntity();
        }
        List<MeetSpEntity> list = meetSpService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MeetSpEntity>(list));
    }

    @Logs
    @ApiOperation(value = "撤销会议", notes = "撤销会议")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer bh, @RequestParam Integer userSerial) {
        MeetEntity entity = meetService.selectMeetInfo(bh);
        //先验证该会议是否自己预约的或者会议尚未开始
        QueryTimeEntity queryTimeEntity = new QueryTimeEntity();
        queryTimeEntity.setUserSerial(userSerial);
        queryTimeEntity.setRoomSerial(bh);
        queryTimeEntity.setCurrentTime(new Date());
        int meetCount = meetService.selectMeetOrderStateByBh(queryTimeEntity);
        if (meetCount == 0) {
            return failMsg("您无权撤销该会议或者会议已经开始");
        }
        //插入增量日志表（兼容老设备）jreal_update_1
        meetService.insertUpdate1ByMeetBh(bh);
        //插入增量日志表 jreal_update_2,3,4,5
        meetService.insertUpdate2To5ByMeetBh(bh);

        if (entity.getWxNotice() == 1) {
            //插入通知表
            MeetEntity meet = new MeetEntity();
            meet.setBh(bh);
            meet.setRecordTime(DateUtils.getCurrentDateTime());
            meetService.insertCancelWxNotice(meet);
        }
        //删除该会议的相关信息
        meetService.deleteByPrimaryKey(bh);
        //插入操作日志
        //meetService.insertOperateLog(record);
        return succMsg("撤销成功");
    }


    @Logs
    @ApiOperation(value = "获取会议审批列表", notes = "获取会议审批列表")
    @RequestMapping(value = "/selectMySubmit", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetEntity>> selectMySubmit(@RequestBody BasePageSearch<MeetEntity> record) {
        setPageHelper(record);
        MeetEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetEntity();
        }
        List<MeetEntity> list = meetService.selectMySubmit(Long.parseLong(entity.getAppointment()));
        return succMsgData(new BaseCommPager<MeetEntity>(list));
    }

    @Logs
    @ApiOperation(value = "获取会议审批列表", notes = "获取会议审批列表")
    @RequestMapping(value = "/selectMyApprove", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetEntity>> selectMyApprove(@RequestBody BasePageSearch<MeetEntity> record) {
        setPageHelper(record);
        MeetEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetEntity();
        }
        List<MeetEntity> list = meetService.selectMyApprove(Long.parseLong(entity.getAppointment()), null);
        return succMsgData(new BaseCommPager<MeetEntity>(list));
    }

    @Logs
    @ApiOperation(value = "获取会议审批列表", notes = "获取会议审批列表")
    @RequestMapping(value = "/isMyApprove", method = RequestMethod.POST)
    public JsonResult<Object> isMyApprove(@RequestBody MeetEntity record) {
        List<MeetEntity> list = meetService.selectMyApprove(Long.parseLong(record.getAppointment()), record.getBh());
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "获取会议审批列表", notes = "获取会议审批列表")
    @RequestMapping(value = "/selectMyCopy", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetEntity>> selectMyCopy(@RequestBody BasePageSearch<MeetEntity> record) {
        setPageHelper(record);
        MeetEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetEntity();
        }
        List<MeetEntity> list = meetService.selectMyCopy(Long.parseLong(entity.getAppointment()));
        return succMsgData(new BaseCommPager<MeetEntity>(list));
    }
}