package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DeviceEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-31
 */
@MyBatisDao
public interface DeviceMapper {
    /**
     */
    int deleteByPrimaryKey(String bh);

    /**
     */
    int insert(DeviceEntity record);

    /**
     */
    int insertBatch(@Param("list") List<DeviceEntity> list);

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
    List<DeviceEntity> selectControlList(DeviceEntity record);

    List<DeviceEntity> selectKqList(DeviceEntity record);

    /**
     */
    List<DeviceEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DeviceEntity> list);
}