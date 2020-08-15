package com.weds.edwx.mapper;

import com.weds.edwx.entity.MeetEntity;
import com.weds.edwx.entity.QueryTimeEntity;
import com.weds.edwx.entity.TimeEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-14
 */
@MyBatisDao
public interface MeetMapper {
    /**
     */
    int deleteByPrimaryKey(Integer bh);

    /**
     */
    int insert(MeetEntity record);

    /**
     */
    int insertSelective(MeetEntity record);

    /**
     */
    MeetEntity selectByPrimaryKey(@Param("bh") Integer bh, @Param("userSerial") Integer userSerial);


    MeetEntity selectMeetInfo(@Param("bh") Integer bh);

    /**
     */
    int updateByPrimaryKeySelective(MeetEntity record);

    /**
     */
    int updateByPrimaryKey(MeetEntity record);

    /**
     */
    List<MeetEntity> selectListByEntity(MeetEntity record);

    List<TimeEntity> selectDateListByEntity(QueryTimeEntity record);

    List<MeetEntity> selectMeetListByRoom(QueryTimeEntity record);

    List<MeetEntity> selectMyMeetListByDate(QueryTimeEntity record);

    List<MeetEntity> selectMySubmit(@Param("userSerial") Long userSerial);

    List<MeetEntity> selectMyApprove(@Param("userSerial") Long userSerial, @Param("bh") Integer bh);

    List<MeetEntity> selectMyCopy(@Param("userSerial") Long userSerial);

    int selectMeetByEntity(MeetEntity meet);

    int selectMeetByDev(MeetEntity meet);

    int insertUpdate1ByDev(MeetEntity meet);

    int insertUpdate2To5ByDev(MeetEntity meet);

    int insertOperateLog(MeetEntity meet);

    int insertMeetDev(MeetEntity meet);

    int selectMeetOrderStateByBh(QueryTimeEntity record);

    int insertUpdate1ByMeetBh(Integer bh);

    int insertUpdate2To5ByMeetBh(Integer bh);

    int insertWxNotice(MeetEntity meet);

    int insertCancelWxNotice(MeetEntity meet);

    int selectMeetRule(MeetEntity meet);

    int insertMeetRule(MeetEntity meet);
}