package com.weds.edwx.mapper;

import com.weds.edwx.entity.*;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-14
 */
@MyBatisDao
public interface TkqRoomMapper {
    /*
    int deleteByPrimaryKey(Integer depSerial);
    int insert(TkqRoomEntity record);
    int insertSelective(TkqRoomEntity record);
    TkqRoomEntity selectByPrimaryKey(Integer depSerial);
    int updateByPrimaryKeySelective(TkqRoomEntity record);
    int updateByPrimaryKey(TkqRoomEntity record);
    List<TkqRoomEntity> selectListByEntity(TkqRoomEntity record);
    */

    /**
     * 获取会议室状态数据
     *
     * @param record
     * @return
     */
    List<MeetRoomEntity> selectRoomListByEntity(QueryTimeEntity record);

    /**
     * 获取会议室资源数据
     *
     * @param bh
     * @return
     */
    List<RoomResourceEntity> getRoomResourceList(Integer bh);

    TkqRoomEntity selectByPrimaryKey(Integer depSerial);

}