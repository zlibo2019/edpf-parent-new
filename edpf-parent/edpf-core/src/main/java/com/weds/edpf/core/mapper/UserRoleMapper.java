package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.UserRoleEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 用户角色关系管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface UserRoleMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("userSerial") String userSerial, @Param("roleId") String roleId);

    /**
     */
    int insert(UserRoleEntity record);

    /**
     */
    int insertSelective(UserRoleEntity record);

    /**
     */
    UserRoleEntity selectByPrimaryKey(@Param("userSerial") String userSerial, @Param("roleId") String roleId);

    /**
     */
    int updateByPrimaryKeySelective(UserRoleEntity record);

    /**
     */
    int updateByPrimaryKey(UserRoleEntity record);

    /**
     */
    List<UserRoleEntity> selectListByEntity(UserRoleEntity record);

    /**
     */
    List<UserRoleEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<UserRoleEntity> list);

    /**
     */
    int deleteByRoleId(@Param("roleId") String roleId);
}