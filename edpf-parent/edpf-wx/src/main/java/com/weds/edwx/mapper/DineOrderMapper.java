package com.weds.edwx.mapper;

import com.weds.edwx.entity.DineOrderEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-13
 */
@MyBatisDao
public interface DineOrderMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(DineOrderEntity record);

    /**
     */
    int insertSelective(DineOrderEntity record);

    /**
     */
    DineOrderEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(DineOrderEntity record);

    /**
     */
    int updateByPrimaryKey(DineOrderEntity record);

    /**
     */
    List<DineOrderEntity> selectListByEntity(DineOrderEntity record);

    /**
     */
    List<DineOrderEntity> selectDistinctListByEntity(DineOrderEntity record);

    /**
     */
    List<DineOrderEntity> selectListByCondition(DineOrderEntity record);

    /**
     */
    DineOrderEntity selectDineNums(DineOrderEntity record);

    /**
     */
    int updateOrderByCondition(DineOrderEntity record);
}