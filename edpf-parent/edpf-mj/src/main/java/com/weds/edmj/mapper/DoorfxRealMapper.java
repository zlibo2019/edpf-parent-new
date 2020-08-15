package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DoorRealEntity;
import com.weds.edmj.entity.DoorfxRealEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-29
 */
@MyBatisDao
public interface DoorfxRealMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("gateBh") String gateBh);

    /**
     */
    int insert(DoorfxRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<DoorfxRealEntity> list);

    /**
     */
    int insertSelective(DoorfxRealEntity record);

    /**
     */
    List<DoorfxRealEntity>  selectByPrimaryKey(@Param("gateBh") String gateBh);

    /**
     */
    int updateByPrimaryKeySelective(DoorfxRealEntity record);

    /**
     */
    int updateByPrimaryKey(DoorfxRealEntity record);

    /**
     */
    List<DoorfxRealEntity> selectListByEntity(DoorfxRealEntity record);

    /**
     */
    List<DoorfxRealEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DoorRealEntity> list);
}