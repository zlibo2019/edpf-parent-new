package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.ControlRealEntity;
import java.util.List;

import com.weds.edmj.entity.DeviceEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-31
 */
@MyBatisDao
public interface ControlRealMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("devSerial") String devSerial, @Param("devOrder") Integer devOrder);

    /**
     */
    int insert(ControlRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<ControlRealEntity> list);

    /**
     */
    int insertSelective(ControlRealEntity record);

    /**
     */
    ControlRealEntity selectByPrimaryKey(@Param("devSerial") String devSerial, @Param("devOrder") Integer devOrder);

    /**
     */
    int updateByPrimaryKeySelective(ControlRealEntity record);

    /**
     */
    int updateByPrimaryKey(ControlRealEntity record);

    /**
     */
    List<ControlRealEntity> selectListByEntity(DeviceEntity record);

    /**
     */
    List<ControlRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<ControlRealEntity> list);
}