package com.weds.edwx.mapper;

import com.weds.edwx.entity.DeviceMonitorEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-24
 */
@MyBatisDao
public interface DeviceMonitorMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(DeviceMonitorEntity record);

    /**
     */
    int insertSelective(DeviceMonitorEntity record);

    /**
     */
    DeviceMonitorEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(DeviceMonitorEntity record);

    /**
     */
    int updateByPrimaryKey(DeviceMonitorEntity record);

    /**
     */
    List<DeviceMonitorEntity> selectListByEntity(DeviceMonitorEntity record);

    /**
     * 根据会议室编号，查询会议室是否有在线设备
     */
    int selectByRoomBh(Integer bh);
}