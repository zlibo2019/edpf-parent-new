package com.weds.edwx.service;

import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.TkqRoomMapper;

/**
 * @Author sxm
 * @Description TkqRoom管理
 * @Date 2018-11-14
 */
@Service
public class TkqRoomService extends BaseService {

    @Autowired
    private TkqRoomMapper tkqRoomMapper;

    private Logger log = LogManager.getLogger();

    /**
     * 查询当前日期的会议室列表和会议室的当前状态
     * 仅cdate 可用
     *
     * @param record
     * @return
     * @throws ParseException
     */
    public List<MeetRoomEntity> selectRoomListByEntity(TimeEntity record) throws ParseException {
        QueryTimeEntity queryTimeEntity = new QueryTimeEntity();
        //处理时间的业务逻辑，将当前日期变化为开始时间和结束时间进行查询
        if (record.getCdate().equals(DateUtils.getCurrentDate())) {
            //查询日期等于当前日期
            queryTimeEntity.setKssj(new Date());
            queryTimeEntity.setJssj(DateUtils.addDays(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT), 1));
        } else if (DateUtils.parseDate(record.getCdate(), DateUtils.DATE_FORMAT).getTime() > DateUtils.parseDate(DateUtils.getCurrentDate(), DateUtils.DATE_FORMAT).getTime()) { //
            //查询日期大于当前日期
            queryTimeEntity.setKssj(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT));
            queryTimeEntity.setJssj(DateUtils.addDays(DateUtils.parseDate(record.getCdate() + " 00:00:00", DateUtils.DATE_TIME_FORMAT), 1));
        } else { //
            //查询日期小于当前日期
        }
        queryTimeEntity.setCurrentTime(new Date());
        return tkqRoomMapper.selectRoomListByEntity(queryTimeEntity);
    }

    /**
     * 获取会议室资源数据
     *
     * @param bh
     * @return
     */
    public List<RoomResourceEntity> getRoomResourceList(Integer bh) {
        return tkqRoomMapper.getRoomResourceList(bh);
    }


    public TkqRoomEntity selectByPrimaryKey(Integer depSerial){
        return tkqRoomMapper.selectByPrimaryKey(depSerial);
    }
}
