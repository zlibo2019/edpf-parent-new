package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.core.utils.DateUtils;
import com.weds.edpf.core.entity.SysParamEntity;
import com.weds.edpf.core.service.SysParamService;
import com.weds.edwx.entity.MeetEntity;
import com.weds.edwx.entity.MeetMdEntity;
import com.weds.edwx.entity.QueryTimeEntity;
import com.weds.edwx.entity.TimeEntity;
import com.weds.edwx.mapper.MeetMapper;
import com.weds.edwx.mapper.MeetMdMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description Meet管理
 * @Date 2018-11-14
 */
@Service
public class MeetService extends BaseService {

    @Autowired
    private MeetMapper meetMapper;
    @Autowired
    private SysParamService sysParamService;
    @Autowired
    private MeetMdMapper meetMdMapper;

    private Logger log = LogManager.getLogger();

    /**
     * 会议预约
     *
     * @param record
     * @return
     */
    public int insert(MeetEntity record) {
        return meetMapper.insert(record);
    }

    /**
     * 查询与自己有关的会议日期，用于日历标红显示
     * 可用参数为 userSerial
     *
     * @param record
     * @return
     */
    public List<TimeEntity> selectDateListByEntity(QueryTimeEntity record) {
        //取出允许预约的天数，默认10，数据表中管理
        int days = 10;
        SysParamEntity sysParamEntity = sysParamService.selectByPrimaryKey("meet_order_days");
        if (sysParamEntity != null) {
            days = Integer.parseInt(sysParamEntity.getParamValue());
        }
        //将开始时间和结束时间计算放入
        record.setKssj(new Date());
        record.setJssj(DateUtils.addDays(DateUtils.getDateTimeZero(new Date()), days + 1));
        //System.out.println("ces::"+sysParamEntity.getParamValue());
        return meetMapper.selectDateListByEntity(record);
    }

    /**
     * 根据会议室编号和日期获取会议列表
     * 可用参数为 cdate，userSerial，roomBh
     *
     * @param record
     * @return
     * @throws ParseException
     */
    public List<MeetEntity> selectMeetListByRoom(TimeEntity record) throws ParseException {

        QueryTimeEntity queryTimeEntity = new QueryTimeEntity();
        queryTimeEntity.setUserSerial(record.getUserSerial());
        queryTimeEntity.setRoomSerial(record.getRoomBh());
        //根据传入的查询日期转换为开始时间和结束时间再进行查询
        queryTimeEntity.setCurrentTime(new Date());
        queryTimeEntity.setKssj(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT));
        queryTimeEntity.setJssj(DateUtils.addDays(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT), 1));
        return meetMapper.selectMeetListByRoom(queryTimeEntity);
    }

    /**
     * 查询指定日期的我预约或者参加的会议清单
     * 可用参数为 cdate，userSerial，type
     *
     * @param record
     * @return
     * @throws ParseException
     */
    public List<MeetEntity> selectMyMeetListByDate(TimeEntity record) throws ParseException {
        QueryTimeEntity queryTimeEntity = new QueryTimeEntity();
        queryTimeEntity.setUserSerial(record.getUserSerial());
        queryTimeEntity.setCurrentTime(new Date());
        //type 0:未开始;2:已结束;不传或其他为全部;
        queryTimeEntity.setType(record.getType());
        //根据传入的查询日期转换为开始时间和结束时间再进行查询
        queryTimeEntity.setKssj(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT));
        queryTimeEntity.setJssj(DateUtils.addDays(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT), 1));
        return meetMapper.selectMyMeetListByDate(queryTimeEntity);
    }

    /**
     * 查询会议详情页面
     *
     * @param bh
     * @param userSerial
     * @return
     */
    public MeetEntity selectByPrimaryKey(Integer bh, Integer userSerial) {
        //查出会议的详细信息
        MeetEntity meetEntity = meetMapper.selectByPrimaryKey(bh, userSerial);
        if (meetEntity != null) { //如果会议存在
            //查出与会人的详细信息
            List<MeetMdEntity> meetMdEntity = meetMdMapper.selectUserListByBh(bh);
            meetEntity.setMeetUsers(meetMdEntity);
        }
        return meetEntity;
    }

    public MeetEntity selectMeetInfo(Integer bh) {
        return meetMapper.selectMeetInfo(bh);
    }

    /**
     * 查询当前时间段该会议室是否空闲
     *
     * @param record
     * @return
     */
    public int selectMeetByEntity(MeetEntity record) {
        return meetMapper.selectMeetByEntity(record);
    }

    /**
     * 查询当前时间段该会议室绑定的设备是否空闲
     *
     * @param record
     * @return
     */
    public int selectMeetByDev(MeetEntity record) {
        return meetMapper.selectMeetByDev(record);
    }

    /**
     * 插入会议室和设备关系
     *
     * @param record
     * @return
     */
    public int insertMeetDev(MeetEntity record) {
        return meetMapper.insertMeetDev(record);
    }

    /**
     * 插入增量日志（兼容会议老设备 类型10）
     *
     * @param record
     * @return
     */
    public int insertUpdate1ByDev(MeetEntity record) {
        return meetMapper.insertUpdate1ByDev(record);
    }

    /**
     * 插入增量日志
     *
     * @param record
     * @return
     */
    public int insertUpdate2To5ByDev(MeetEntity record) {
        return meetMapper.insertUpdate2To5ByDev(record);
    }

    /**
     * 插入操作日志
     *
     * @param record
     * @return
     */
    public int insertOperateLog(MeetEntity record) {
        return meetMapper.insertOperateLog(record);
    }

    /**
     * 查询该会议是否自己预约的或者会议尚未开始
     *
     * @param queryTimeEntity
     * @return
     */
    public int selectMeetOrderStateByBh(QueryTimeEntity queryTimeEntity) {
        return meetMapper.selectMeetOrderStateByBh(queryTimeEntity);
    }

    /**
     * 根据会议编号，删除会议相关信息
     *
     * @param bh
     * @return
     */
    public int deleteByPrimaryKey(Integer bh) {
        return meetMapper.deleteByPrimaryKey(bh);
    }

    public int insertUpdate1ByMeetBh(Integer bh) {
        return meetMapper.insertUpdate1ByMeetBh(bh);
    }

    public int insertUpdate2To5ByMeetBh(Integer bh) {
        return meetMapper.insertUpdate2To5ByMeetBh(bh);
    }

    //给参会人员推送会议消息
    public int insertWxNotice(MeetEntity meet) {
        return meetMapper.insertWxNotice(meet);
    }

    /**
     * 给参会人员推送撤销会议消息
     *
     * @param meet
     * @return
     */
    public int insertCancelWxNotice(MeetEntity meet) {
        return meetMapper.insertCancelWxNotice(meet);
    }

    /**
     * 插入会议规则
     *
     * @param meet
     * @returnuse
     */
    public int insertMeetRule(MeetEntity meet) {
        return meetMapper.insertMeetRule(meet);
    }

    public int selectMeetRule(MeetEntity meet) {
        return meetMapper.selectMeetRule(meet);
    }

    public List<MeetEntity> selectMySubmit(Long userSerial) {
        return meetMapper.selectMySubmit(userSerial);
    }

    public List<MeetEntity> selectMyApprove(Long userSerial, Integer bh) {
        return meetMapper.selectMyApprove(userSerial, bh);
    }

    public List<MeetEntity> selectMyCopy(Long userSerial) {
        return meetMapper.selectMyCopy(userSerial);
    }
}
