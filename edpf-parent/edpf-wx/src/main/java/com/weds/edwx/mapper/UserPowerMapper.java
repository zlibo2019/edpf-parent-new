package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.UserPowerEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-10-09
 */
@MyBatisDao
public interface UserPowerMapper {
    /**
     */
    int deleteByPrimaryKey(Long userSerial);

    /**
     */
    int insert(UserPowerEntity record);

    /**
     */
    int insertSelective(UserPowerEntity record);

    /**
     */
    UserPowerEntity selectByPrimaryKey(Long userSerial);

    /**
     */
    int updateByPrimaryKeySelective(UserPowerEntity record);

    /**
     */
    int updateByPrimaryKey(UserPowerEntity record);

    /**
     */
    List<UserPowerEntity> selectListByEntity(UserPowerEntity record);
}