package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.MjRuleRealEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-25
 */
@MyBatisDao
public interface MjRuleRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer ruleNo);

    /**
     */
    Map selectMaxRuleNo();

    /**
     */
    int insert(MjRuleRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjRuleRealEntity> list);

    /**
     */
    int insertSelective(MjRuleRealEntity record);

    /**
     */
    MjRuleRealEntity selectByPrimaryKey(Integer ruleNo);

    /**
     */
    int updateByPrimaryKeySelective(MjRuleRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjRuleRealEntity record);

    /**
     */
    List<MjRuleRealEntity> selectListByEntity(MjRuleRealEntity record);

    /**
     */
    List<MjRuleRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjRuleRealEntity> list);
}