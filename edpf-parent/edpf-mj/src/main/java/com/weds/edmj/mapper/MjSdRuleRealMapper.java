package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.MjSdRuleRealEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-25
 */
@MyBatisDao
public interface MjSdRuleRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);


    int deleteByCondition(MjSdRuleRealEntity record);

    /**
     */
    int insert(MjSdRuleRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjSdRuleRealEntity> list);

    /**
     */
    int insertSelective(MjSdRuleRealEntity record);

    /**
     */
    MjSdRuleRealEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(MjSdRuleRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjSdRuleRealEntity record);

    /**
     */
    List<MjSdRuleRealEntity> selectListByEntity(MjSdRuleRealEntity record);

    /**
     */
    List<MjSdRuleRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjSdRuleRealEntity> list);
}