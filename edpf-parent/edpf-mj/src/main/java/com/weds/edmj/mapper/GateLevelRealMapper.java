package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.GateLevelRealEntity;
import java.util.List;

import com.weds.edmj.entity.MjUserRuleRealEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-08-08
 */
@MyBatisDao
public interface GateLevelRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    int deleteByGateList(GateLevelRealEntity record);

    /**
     */
    int insert(GateLevelRealEntity record);

    int deleteByGateListAndDep(GateLevelRealEntity record);

    /**
     */
    int insertBatch(GateLevelRealEntity record);

    int insertRoleBatch(GateLevelRealEntity record);

    int insertDepBatch(GateLevelRealEntity record);
    /**
     */
    int insertSelective(GateLevelRealEntity record);

    /**
     */
    GateLevelRealEntity selectByPrimaryKey(Integer xh);

    GateLevelRealEntity selectDepByGateUser(MjUserRuleRealEntity record);

    GateLevelRealEntity selectPublicByGateUser(MjUserRuleRealEntity record);

    /**
     */
    int updateByPrimaryKeySelective(GateLevelRealEntity record);

    /**
     */
    int updateByPrimaryKey(GateLevelRealEntity record);

    /**
     */
    List<GateLevelRealEntity> selectListByEntity(GateLevelRealEntity record);


    /**
     */
    int deleteBatchByKeys(@Param("list") List<GateLevelRealEntity> list);

    int insertFullUpdate0(@Param("list") List<GateLevelRealEntity> list);
    int insertFullUpdate1(@Param("list") List<GateLevelRealEntity> list);

    int selectOtherAuth(GateLevelRealEntity record);
}