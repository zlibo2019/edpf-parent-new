package com.weds.edwx.mapper;

import com.weds.edwx.entity.DineMealEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-13
 */
@MyBatisDao
public interface DineMealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(DineMealEntity record);

    /**
     */
    int insertSelective(DineMealEntity record);

    /**
     */
    DineMealEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(DineMealEntity record);

    /**
     */
    int updateByPrimaryKey(DineMealEntity record);

    /**
     */
    List<DineMealEntity> selectListByEntity(DineMealEntity record);


    /**
     */
    DineMealEntity selectByMealBh(String mealBh);
}