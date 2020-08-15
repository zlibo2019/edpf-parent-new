package com.weds.edwx.mapper;

import com.weds.edwx.entity.UserMenusEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 用户功能管理管理
 * @Date 2018-11-24
 */
@MyBatisDao
public interface UserMenusMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("companyId") String companyId, @Param("userId") String userId, @Param("menuId") String menuId);

    /**
     */
    int insert(UserMenusEntity record);

    /**
     */
    int insertSelective(UserMenusEntity record);

    /**
     */
    UserMenusEntity selectByPrimaryKey(@Param("companyId") String companyId, @Param("userId") String userId, @Param("menuId") String menuId);

    /**
     */
    int updateByPrimaryKeySelective(UserMenusEntity record);

    /**
     */
    int updateByPrimaryKey(UserMenusEntity record);

    /**
     */
    List<UserMenusEntity> selectListByEntity(UserMenusEntity record);

    /**
     */
    int deleteByUserId(@Param("userId") String userId);
}