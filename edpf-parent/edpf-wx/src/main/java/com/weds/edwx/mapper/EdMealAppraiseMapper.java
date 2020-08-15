package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.EdMealAppraiseEntity;

import java.util.List;

/**
 * @Author
 * @Description 就餐评价管理
 * @Date 2019-11-27
 */
@MyBatisDao
public interface EdMealAppraiseMapper {
    /**
     */
    int deleteByPrimaryKey(String bh);

    /**
     */
    int insert(EdMealAppraiseEntity record);

    /**
     */
    int insertSelective(EdMealAppraiseEntity record);

    /**
     */
    EdMealAppraiseEntity selectByPrimaryKey(String bh);

    /**
     */
    int updateByPrimaryKeySelective(EdMealAppraiseEntity record);

    /**
     */
    int updateByPrimaryKey(EdMealAppraiseEntity record);

    /**
     */
    List<EdMealAppraiseEntity> selectListByEntity(EdMealAppraiseEntity record);
}