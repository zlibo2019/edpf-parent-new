package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.VisSettingEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-04
 */
@MyBatisDao
public interface VisSettingMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(VisSettingEntity record);

    /**
     */
    int insertBatch(@Param("list") List<VisSettingEntity> list);

    /**
     */
    int insertSelective(VisSettingEntity record);

    /**
     */
    VisSettingEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(VisSettingEntity record);

    /**
     */
    int updateByPrimaryKey(VisSettingEntity record);

    /**
     */
    List<VisSettingEntity> selectListByEntity(VisSettingEntity record);

    /**
     */
    List<VisSettingEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisSettingEntity> list);
}