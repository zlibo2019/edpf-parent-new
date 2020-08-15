package com.weds.edwx.mapper;

import com.weds.edwx.entity.DeviceEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-28
 */
@MyBatisDao
public interface DeviceMapper {

    DeviceEntity selectByDevsbid(@Param("devSid") String devSid);

    /**
     */
    int deleteByPrimaryKey(String bh);

    /**
     */
    int insert(DeviceEntity record);

    /**
     */
    int insertSelective(DeviceEntity record);

    /**
     */
    DeviceEntity selectByPrimaryKey(String bh);

    /**
     */
    int updateByPrimaryKeySelective(DeviceEntity record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(DeviceEntity record);

    /**
     */
    int updateByPrimaryKey(DeviceEntity record);

    /**
     */
    List<DeviceEntity> selectListByEntity(DeviceEntity record);

    /**
     */
    List<DeviceEntity> selectListByEntityWithBLOBs(DeviceEntity record);
}