package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisThingEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisThingMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisThingEntity record);

    /**
     */
    int insertSelective(VisThingEntity record);

    /**
     */
    VisThingEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisThingEntity record);

    /**
     */
    int updateByPrimaryKey(VisThingEntity record);

    /**
     */
    List<VisThingEntity> selectListByEntity(VisThingEntity record);

    /**
     */
    List<VisThingEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisThingEntity> list);
}