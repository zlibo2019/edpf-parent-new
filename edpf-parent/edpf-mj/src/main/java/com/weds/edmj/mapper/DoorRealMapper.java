package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DoorRealEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-29
 */
@MyBatisDao
public interface DoorRealMapper {
    /**
     */
    int deleteByPrimaryKey(String bh);

    /**
     */
    int insert(DoorRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<DoorRealEntity> list);

    /**
     */
    int insertSelective(DoorRealEntity record);

    int selectCountByEntity(DoorRealEntity record);

    int insertDepDoorRelation(DoorRealEntity record);

    int selectDevStateByEntity(DoorRealEntity record);

    int selectDcardCountByEntity(DoorRealEntity record);
    int deleteDepDoorRelation(DoorRealEntity record);
    /**
     */
    DoorRealEntity selectByPrimaryKey(String gateBh);

    /**
     */
    int updateByPrimaryKeySelective(DoorRealEntity record);

    /**
     */
    int updateByPrimaryKey(DoorRealEntity record);

    int updatePlaceByGate(DoorRealEntity record);

    /**
     */
    List<DoorRealEntity> selectListByEntity(DoorRealEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DoorRealEntity> list);

    int deleteDepRelationBatchByKeys(@Param("list") List<DoorRealEntity> list);

    List<DoorRealEntity> selectForceList(DoorRealEntity record);
}