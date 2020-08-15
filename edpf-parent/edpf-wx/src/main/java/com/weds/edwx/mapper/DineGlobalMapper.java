package com.weds.edwx.mapper;

import com.weds.edwx.entity.DineGlobalEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-14
 */
@MyBatisDao
public interface DineGlobalMapper {
    /**
     */
    int deleteByPrimaryKey(Integer bh);

    /**
     */
    int insert(DineGlobalEntity record);

    /**
     */
    int insertSelective(DineGlobalEntity record);

    /**
     */
    DineGlobalEntity selectByPrimaryKey(Integer bh);

    /**
     */
    int updateByPrimaryKeySelective(DineGlobalEntity record);

    /**
     */
    int updateByPrimaryKey(DineGlobalEntity record);

    /**
     */
    List<DineGlobalEntity> selectListByEntity(DineGlobalEntity record);
}