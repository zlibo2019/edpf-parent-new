package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.UserBaseEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 用户档案表管理
 * @Date 2019-05-23
 */
@MyBatisDao
public interface UserBaseMapper {
    /**
     */
    int deleteByPrimaryKey(Long userSerial);

    /**
     */
    int insert(UserBaseEntity record);

    /**
     */
    int insertSelective(UserBaseEntity record);

    /**
     */
    UserBaseEntity selectByPrimaryKey(Long userSerial);

    /**
     */
    UserBaseEntity selectByCardNo(String userCard);

    /**
     */
    int updateByPrimaryKeySelective(UserBaseEntity record);

    /**
     */
    int updateByPrimaryKey(UserBaseEntity record);

    /**
     */
    List<UserBaseEntity> selectListByEntity(UserBaseEntity record);

    /**
     */
    List<UserBaseEntity> selectListByKeys(@Param("keys") String keys, @Param("userDeps") String userDeps);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<UserBaseEntity> list);

    /**
     */
    UserBaseEntity userLoginCheck(UserBaseEntity record);

    /**
     */
    List<UserBaseEntity> selectUserList(@Param("userInfo") String userInfo);

    /**
     */
    List<UserBaseEntity> selectVisUserByDept(UserBaseEntity record);
}