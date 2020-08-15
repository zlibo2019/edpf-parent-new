package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisRegionEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisRegionMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisRegionEntity record);

    /**
     */
    int insertSelective(VisRegionEntity record);

    /**
     */
    VisRegionEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisRegionEntity record);

    /**
     */
    int updateByPrimaryKey(VisRegionEntity record);

    /**
     */
    List<VisRegionEntity> selectListByEntity(VisRegionEntity record);

    /**
     */
    List<VisRegionEntity> selectListByBh(@Param("bh") String bh);

    /**
     */
    List<VisRegionEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisRegionEntity> list);
}