package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineFoodEntity;
import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.entity.EdDineMenuEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface EdDineFoodMapper {
    /**
     */
    int deleteByPrimaryKey(String foodId);

    /**
     */
    int insert(EdDineFoodEntity record);

    /**
     */
    int insertSelective(EdDineFoodEntity record);

    /**
     */
    EdDineFoodEntity selectByPrimaryKey(String foodId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineFoodEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineFoodEntity record);

    /**
     */
    List<EdDineFoodEntity> selectListByEntity(EdDineFoodEntity record);

    /**
     */
    List<EdDineFoodEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineFoodEntity> list);

    /**
     */
    List<EdDineFoodEntity> selectFoodList(EdDineFoodEntity record);

    /**
     */
    List<EdDineFoodEntity> selectFoodListNew(EdDineFoodEntity record);
}