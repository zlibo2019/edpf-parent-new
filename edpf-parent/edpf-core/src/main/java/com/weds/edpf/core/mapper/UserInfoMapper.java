package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.UserInfoEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 人员基本信息管理
 * @Date 2019-09-27
 */
@MyBatisDao("userInfoMapperNew")
public interface UserInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String userId);

    /**
     */
    int insert(UserInfoEntity record);

    /**
     */
    int insertSelective(UserInfoEntity record);

    /**
     */
    UserInfoEntity selectByPrimaryKey(String userId);

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
    int deleteBatchByKeys(@Param("list") List<UserInfoEntity> list);
}