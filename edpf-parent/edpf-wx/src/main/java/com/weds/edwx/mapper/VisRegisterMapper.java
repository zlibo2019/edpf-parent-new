package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisRegisterEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisRegisterMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisRegisterEntity record);

    /**
     */
    int insertSelective(VisRegisterEntity record);

    /**
     */
    VisRegisterEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisRegisterEntity record);

    /**
     */
    int updateByPrimaryKey(VisRegisterEntity record);

    /**
     */
    List<VisRegisterEntity> selectListByEntity(VisRegisterEntity record);

    /**
     */
    List<VisRegisterEntity> selectRepeatRecord(VisRegisterEntity record);

    /**
     */
    List<VisRegisterEntity> selectLossRecord(VisRegisterEntity record);

    /**
     */
    List<VisRegisterEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    List<VisRegisterEntity> selectVisListByEntity(VisRegisterEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisRegisterEntity> list);

    /**
     */
    VisRegisterEntity selectVisiting(@Param("visSerial") long visSerial);

    /**
     */
    VisRegisterEntity selectTodayRecord(@Param("visSerial") long visSerial, @Param("currDate") String currDate,
                                        @Param("visKeeperNo") String visKeeperNo);

    /**
     */
    int deleteTodayRecord(@Param("visSerial") long visSerial, @Param("currDate") String currDate);
}