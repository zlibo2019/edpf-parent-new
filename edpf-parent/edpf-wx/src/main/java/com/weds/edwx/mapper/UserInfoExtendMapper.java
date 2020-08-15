package com.weds.edwx.mapper;

import com.weds.edwx.entity.UserInfoExtendEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 用户扩展信息管理
 * @Date 2019-02-21
 */
@MyBatisDao
public interface UserInfoExtendMapper {
    /**
     */
    int deleteByPrimaryKey(String userSerial);

    /**
     */
    int insert(UserInfoExtendEntity record);

    /**
     */
    int insertSelective(UserInfoExtendEntity record);

    /**
     */
    UserInfoExtendEntity selectByPrimaryKey(String userSerial);

    /**
     */
    int updateByPrimaryKeySelective(UserInfoExtendEntity record);

    /**
     */
    int updateByPrimaryKey(UserInfoExtendEntity record);

    /**
     */
    List<UserInfoExtendEntity> selectListByEntity(UserInfoExtendEntity record);
}