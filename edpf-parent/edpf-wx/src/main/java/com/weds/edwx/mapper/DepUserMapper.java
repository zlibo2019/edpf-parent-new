package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.DepUserEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-09-09
 */
@MyBatisDao
public interface DepUserMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(DepUserEntity record);

    /**
     */
    int insertBatch(@Param("list") List<DepUserEntity> list);

    /**
     */
    int insertSelective(DepUserEntity record);

    /**
     */
    DepUserEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(DepUserEntity record);

    /**
     */
    int updateByPrimaryKey(DepUserEntity record);

    /**
     */
    List<DepUserEntity> selectListByEntity(DepUserEntity record);

    /**
     */
    List<DepUserEntity> selectListByCondition(DepUserEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DepUserEntity> list);
}