package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.MjShidRealEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-25
 */
@MyBatisDao
public interface MjShidRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer bh);

    /**
     */
    int insert(MjShidRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjShidRealEntity> list);

    /**
     */
    int insertSelective(MjShidRealEntity record);

    /**
     */
    MjShidRealEntity selectByPrimaryKey(Integer bh);

    /**
     */
    Map selectMaxBh();

    /**
     */
    Map selectShidCount(String ruleNo);

    /**
     */
    int updateByPrimaryKeySelective(MjShidRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjShidRealEntity record);

    /**
     */
    List<MjShidRealEntity> selectListByEntity(MjShidRealEntity record);

    /**
     */
    List<MjShidRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjShidRealEntity> list);
}