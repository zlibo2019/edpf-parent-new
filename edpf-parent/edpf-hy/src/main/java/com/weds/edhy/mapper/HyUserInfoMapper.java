package com.weds.edhy.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edhy.entity.HyUserInfoEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 会员附属信息管理
 * @Date 2019-10-08
 */
@MyBatisDao
public interface HyUserInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String userId);

    /**
     */
    int insert(HyUserInfoEntity record);

    /**
     */
    int insertSelective(HyUserInfoEntity record);

    /**
     */
    HyUserInfoEntity selectByPrimaryKey(String userId);

    /**
     */
    int updateByPrimaryKeySelective(HyUserInfoEntity record);

    /**
     */
    int updateByPrimaryKey(HyUserInfoEntity record);

    /**
     */
    List<HyUserInfoEntity> selectListByEntity(HyUserInfoEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<HyUserInfoEntity> list);
}