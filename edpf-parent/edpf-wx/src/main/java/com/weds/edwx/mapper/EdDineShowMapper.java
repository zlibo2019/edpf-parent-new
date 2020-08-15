package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineShowEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 订餐说明管理
 * @Date 2019-04-30
 */
@MyBatisDao
public interface EdDineShowMapper {
    /**
     */
    int deleteByPrimaryKey(String placeId);

    /**
     */
    int insert(EdDineShowEntity record);

    /**
     */
    int insertSelective(EdDineShowEntity record);

    /**
     */
    EdDineShowEntity selectByPrimaryKey(String placeId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineShowEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineShowEntity record);

    /**
     */
    List<EdDineShowEntity> selectListByEntity(EdDineShowEntity record);

    /**
     */
    List<EdDineShowEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineShowEntity> list);
}