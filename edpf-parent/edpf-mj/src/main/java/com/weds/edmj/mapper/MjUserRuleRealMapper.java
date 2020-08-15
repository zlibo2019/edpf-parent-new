package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DoorRealEntity;
import com.weds.edmj.entity.MjUserRuleRealEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 门授权定义表管理
 * @Date 2019-07-30
 */
@MyBatisDao
public interface MjUserRuleRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     * 门删除时，删除该门的所有授权
     * @param gateBh
     * @return
     */
    int deleteByGateBh(String gateBh);

    /**
     */
    int insert(MjUserRuleRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjUserRuleRealEntity> list);

    int deleteByUserGate(MjUserRuleRealEntity record);

    int insertByUserGate(MjUserRuleRealEntity record);

    int insertRulesCopyDoor(MjUserRuleRealEntity record);

    int insertRulesCopyUser(MjUserRuleRealEntity record);

    /**
     */
    int insertSelective(MjUserRuleRealEntity record);

    List<MjUserRuleRealEntity> selectUserRules(MjUserRuleRealEntity record);
    /**
     */
    MjUserRuleRealEntity selectByPrimaryKey(Integer xh);

    MjUserRuleRealEntity selectUserRuleInfo(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(MjUserRuleRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjUserRuleRealEntity record);

    /**
     */
    List<MjUserRuleRealEntity> selectListByEntity(MjUserRuleRealEntity record);

    /**
     */
    List<MjUserRuleRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjUserRuleRealEntity> list);

    int deleteBatchByGateBh(@Param("list") List<DoorRealEntity> list);
}