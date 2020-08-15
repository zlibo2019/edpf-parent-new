package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineSettingEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 订餐配置管理
 * @Date 2019-04-12
 */
@MyBatisDao
public interface EdDineSettingMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("placeId") String placeId, @Param("mealId") String mealId);

    /**
     */
    int insert(EdDineSettingEntity record);

    /**
     */
    int insertSelective(EdDineSettingEntity record);

    /**
     */
    EdDineSettingEntity selectByPrimaryKey(@Param("placeId") String placeId, @Param("mealId") String mealId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineSettingEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineSettingEntity record);

    /**
     */
    List<EdDineSettingEntity> selectListByEntity(EdDineSettingEntity record);

    /**
     */
    List<EdDineSettingEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineSettingEntity> list);
}