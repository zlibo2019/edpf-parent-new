package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineMealSettingEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Author
 * @Description 餐别设置管理
 * @Date 2019-04-16
 */
@MyBatisDao
public interface EdDineMealSettingMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("placeId") String placeId, @Param("merchantId") String merchantId, @Param("mealId") String mealId);

    /**
     */
    int insert(EdDineMealSettingEntity record);

    /**
     */
    int insertSelective(EdDineMealSettingEntity record);

    /**
     */
    EdDineMealSettingEntity selectByPrimaryKey(@Param("placeId") String placeId, @Param("merchantId") String merchantId,
                                               @Param("mealId") String mealId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineMealSettingEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineMealSettingEntity record);

    /**
     */
    List<EdDineMealSettingEntity> selectListByEntity(EdDineMealSettingEntity record);

    /**
     */
    List<EdDineMealSettingEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineMealSettingEntity> list);

    /**
     */
    List<EdDineMealSettingEntity> selectDineInfo(EdDineMealSettingEntity record);
}