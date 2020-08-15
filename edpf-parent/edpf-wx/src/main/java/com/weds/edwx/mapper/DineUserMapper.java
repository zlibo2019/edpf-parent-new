package com.weds.edwx.mapper;

import com.weds.edwx.entity.DineUserEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-13
 */
@MyBatisDao
public interface DineUserMapper {
    /**
     */
    int deleteByPrimaryKey(Integer userSerial);

    /**
     */
    int insert(DineUserEntity record);

    /**
     */
    int insertSelective(DineUserEntity record);

    /**
     */
    DineUserEntity selectByPrimaryKey(Integer userSerial);

    /**
     */
    int updateByPrimaryKeySelective(DineUserEntity record);

    /**
     */
    int updateByPrimaryKey(DineUserEntity record);

    /**
     */
    List<DineUserEntity> selectListByEntity(DineUserEntity record);
}