package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.MjJlRealEntity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 门通行记录表管理
 * @Date 2019-08-06
 */
@MyBatisDao
public interface MjJlRealMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("jlSj") Date jlSj, @Param("xh") Integer xh);

    /**
     */
    int insert(MjJlRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjJlRealEntity> list);

    /**
     */
    int insertSelective(MjJlRealEntity record);

    /**
     */
    MjJlRealEntity selectByPrimaryKey(@Param("jlSj") Date jlSj, @Param("xh") Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(MjJlRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjJlRealEntity record);

    /**
     */
    List<MjJlRealEntity> selectListByEntity(MjJlRealEntity record);

    /**
     */
    List<MjJlRealEntity> selectListByCondition(MjJlRealEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjJlRealEntity> list);
}