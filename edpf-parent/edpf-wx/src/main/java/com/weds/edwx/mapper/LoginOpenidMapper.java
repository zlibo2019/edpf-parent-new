package com.weds.edwx.mapper;

import com.weds.edwx.entity.LoginOpenidEntity;
import com.weds.edwx.entity.UserEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-26
 */
@MyBatisDao
public interface LoginOpenidMapper {
    List<LoginOpenidEntity> selectListByEntity(LoginOpenidEntity record);

    int insertBindRelation (UserEntity userEntity);

    LoginOpenidEntity checkBindState (UserEntity userEntity);

    LoginOpenidEntity selectByOpendId(String openId);

    LoginOpenidEntity selectBindStatus(UserEntity userEntity);

    int deleteBindStatus(UserEntity userEntity);

    LoginOpenidEntity getBindUserByUnionId(UserEntity userEntity);

    int updateUserInfoByUnionId(UserEntity userEntity);

    int updateOpenIdByUnionId(UserEntity userEntity);

    int updateSendState(LoginOpenidEntity record);

    LoginOpenidEntity selectSendState(LoginOpenidEntity record);
}