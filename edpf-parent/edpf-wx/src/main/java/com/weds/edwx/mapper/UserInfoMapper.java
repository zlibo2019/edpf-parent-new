package com.weds.edwx.mapper;

import com.weds.edwx.entity.UserInfoEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-13
 */
@MyBatisDao
public interface UserInfoMapper {
    /**
     */
    int deleteByPrimaryKey(Long userSerial);

    /**
     */
    int insert(UserInfoEntity record);

    /**
     */
    int insertSelective(UserInfoEntity record);

    /**
     */
    UserInfoEntity selectByPrimaryKey(Long userSerial);

    /**
     */
    UserInfoEntity selectByIdCard(String userId);

    /**
     */
    int updateByPrimaryKeySelective(UserInfoEntity record);

    /**
     */
    int updateByPrimaryKey(UserInfoEntity record);

    /**
     */
    List<UserInfoEntity> selectListByEntity(UserInfoEntity record);

    /**
     */
    List<UserInfoEntity> selectUsersInfo(@Param("userList") List<Integer> userList);

    /**
     */
    List<UserInfoEntity> selectDeptUsers(@Param("depList") List<Integer> depList);


    List<UserInfoEntity> selectDeptUsersList(@Param("depList") List<Integer> depList);

    /**
     */
    List<UserInfoEntity> selectUserList(@Param("userInfo") String userInfo);

    /**
     */
    List<UserInfoEntity> selectVisUserByDept(UserInfoEntity record);
}