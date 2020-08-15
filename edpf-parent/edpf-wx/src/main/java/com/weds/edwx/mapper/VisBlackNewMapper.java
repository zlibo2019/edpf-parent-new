package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.VisBlackNewEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-05-21
 */
@MyBatisDao
public interface VisBlackNewMapper {
    /**
     */
    int deleteByPrimaryKey(String visNo);

    /**
     */
    int insert(VisBlackNewEntity record);

    /**
     */
    int insertSelective(VisBlackNewEntity record);

    /**
     */
    VisBlackNewEntity selectByPrimaryKey(String visNo);

    /**
     */
    int updateByPrimaryKeySelective(VisBlackNewEntity record);

    /**
     */
    int updateByPrimaryKey(VisBlackNewEntity record);

    /**
     */
    List<VisBlackNewEntity> selectListByEntity(VisBlackNewEntity record);

    /**
     */
    List<VisBlackNewEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisBlackNewEntity> list);
}