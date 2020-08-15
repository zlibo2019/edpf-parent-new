package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineMealEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 餐别定义管理
 * @Date 2019-04-16
 */
@MyBatisDao
public interface EdDineMealMapper {
    /**
     */
    int deleteByPrimaryKey(String mealId);

    /**
     */
    int insert(EdDineMealEntity record);

    /**
     */
    int insertSelective(EdDineMealEntity record);

    /**
     */
    EdDineMealEntity selectByPrimaryKey(String mealId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineMealEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineMealEntity record);

    /**
     */
    List<EdDineMealEntity> selectListByEntity(EdDineMealEntity record);

    /**
     */
    List<EdDineMealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineMealEntity> list);
}