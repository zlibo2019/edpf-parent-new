package com.weds.edwx.mapper;

import com.weds.edwx.entity.UserEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-26
 */
@MyBatisDao
public interface UserMapper {
    UserEntity userLoginCheck(UserEntity record);

    UserEntity selectByUserNo(@Param("userNo") String userNo);

    UserEntity merchantLoginCheck(UserEntity record);

    UserEntity selectByUnionId(String unionId);

    UserEntity checkUserPwdBySerial(UserEntity record);

    int updatePwd(UserEntity record);

    UserEntity getCardInfo(UserEntity userEntity);

    int insertPublic(UserEntity userEntity);

    /**
     */
    int deleteByPrimaryKey(Long userSerial);

    /**
     */
    int insert(UserEntity record);

    /**
     */
    int insertSelective(UserEntity record);

    /**
     */
    UserEntity selectByPrimaryKey(Long userSerial);

    /**
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     */
    int updateByPrimaryKey(UserEntity record);

    /**
     */
    List<UserEntity> selectListByEntity(UserEntity record);

    UserEntity selectUserCard(UserEntity userEntity);

    String selectCodeKey(@Param("regNo") String regNo);
}