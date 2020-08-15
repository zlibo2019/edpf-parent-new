package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.UserDetailEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 人员详细信息管理
 * @Date 2019-09-27
 */
@MyBatisDao
public interface UserDetailMapper {
    /**
     */
    int deleteByPrimaryKey(String userId);

    /**
     */
    int insert(UserDetailEntity record);

    /**
     */
    int insertSelective(UserDetailEntity record);

    /**
     */
    UserDetailEntity selectByPrimaryKey(String userId);

    /**
     */
    int updateByPrimaryKeySelective(UserDetailEntity record);

    /**
     */
    int updateByPrimaryKey(UserDetailEntity record);

    /**
     */
    List<UserDetailEntity> selectListByEntity(UserDetailEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<UserDetailEntity> list);
}