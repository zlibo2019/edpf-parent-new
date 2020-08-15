package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.entity.EdDineMenuEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface EdDineMenuDetailMapper {
    /**
     */
    int deleteByPrimaryKey(String menuId, String foodId);

    /**
     */
    int insert(EdDineMenuDetailEntity record);

    /**
     */
    int insertSelective(EdDineMenuDetailEntity record);

    /**
     */
    EdDineMenuDetailEntity selectByPrimaryKey(String menuId, String foodId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineMenuDetailEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineMenuDetailEntity record);

    /**
     */
    List<EdDineMenuDetailEntity> selectListByEntity(EdDineMenuDetailEntity record);

    /**
     */
    List<EdDineMenuDetailEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineMenuDetailEntity> list);
}