package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.JrealUpdate0Entity;
import java.util.List;

import com.weds.edmj.entity.MjUserRuleRealEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-31
 */
@MyBatisDao
public interface JrealUpdate0Mapper {
    /**
     */
    int deleteByPrimaryKey(Integer jsig);

    /**
     */
    int insert(JrealUpdate0Entity record);

    /**
     */
    int insertBatch(@Param("list") List<JrealUpdate0Entity> list);

    int insertUpdate0FullBath(MjUserRuleRealEntity record);
    int insertUpdate1FullBath(MjUserRuleRealEntity record);
    int insertUpdate1MjIncrementBath(MjUserRuleRealEntity record);
    int insertUpdate1KqIncrementBath(MjUserRuleRealEntity record);
    int insertUpdate1MjIncrementCopyUser(MjUserRuleRealEntity record);
    int insertUpdate1KqIncrementCopyUser(MjUserRuleRealEntity record);
    int insertUpdate1Mj(MjUserRuleRealEntity record);
    int insertUpdate1Kq(MjUserRuleRealEntity record);

    /**
     */
    int insertSelective0(JrealUpdate0Entity record);
    int insertSelective1(JrealUpdate0Entity record);
    int insertSelective2(JrealUpdate0Entity record);
    int insertSelective3(JrealUpdate0Entity record);

    /**
     */
    JrealUpdate0Entity selectByPrimaryKey(Integer jsig);

    /**
     */
    int updateByPrimaryKeySelective(JrealUpdate0Entity record);

    /**
     */
    int updateByPrimaryKey(JrealUpdate0Entity record);

    /**
     */
    List<JrealUpdate0Entity> selectListByEntity(JrealUpdate0Entity record);

    /**
     */
    List<JrealUpdate0Entity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<JrealUpdate0Entity> list);
}