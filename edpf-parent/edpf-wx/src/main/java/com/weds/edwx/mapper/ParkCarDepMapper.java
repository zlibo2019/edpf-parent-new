package com.weds.edwx.mapper;

import com.weds.edwx.entity.ParkCarDepEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-26
 */
@MyBatisDao
public interface ParkCarDepMapper {
    /**
     */
    int deleteByPrimaryKey(Integer parkSerial);

    /**
     */
    int insert(ParkCarDepEntity record);

    /**
     */
    int insertSelective(ParkCarDepEntity record);

    /**
     */
    ParkCarDepEntity selectByPrimaryKey(Integer parkSerial);

    /**
     */
    int updateByPrimaryKeySelective(ParkCarDepEntity record);

    /**
     */
    int updateByPrimaryKey(ParkCarDepEntity record);

    /**
     */
    List<ParkCarDepEntity> selectListByEntity(ParkCarDepEntity record);
}