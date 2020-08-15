package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.MjLogRealEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-08-01
 */
@MyBatisDao
public interface MjLogRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(MjLogRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MjLogRealEntity> list);

    /**
     */
    int insertSelective(MjLogRealEntity record);

    /**
     */
    MjLogRealEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(MjLogRealEntity record);

    /**
     */
    int updateByPrimaryKey(MjLogRealEntity record);

    /**
     */
    List<MjLogRealEntity> selectListByEntity(MjLogRealEntity record);

    /**
     */
    List<MjLogRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MjLogRealEntity> list);
}