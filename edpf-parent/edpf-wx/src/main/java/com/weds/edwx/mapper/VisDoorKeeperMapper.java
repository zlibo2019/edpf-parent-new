package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisDoorKeeperEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 门卫用户管理管理
 * @Date 2019-04-17
 */
@MyBatisDao
public interface VisDoorKeeperMapper {
    /**
     */
    int deleteByPrimaryKey(String userNo);

    /**
     */
    int insert(VisDoorKeeperEntity record);

    /**
     */
    int insertSelective(VisDoorKeeperEntity record);

    /**
     */
    VisDoorKeeperEntity selectByPrimaryKey(String userNo);

    /**
     */
    int updateByPrimaryKeySelective(VisDoorKeeperEntity record);

    /**
     */
    int updateByPrimaryKey(VisDoorKeeperEntity record);

    /**
     */
    List<VisDoorKeeperEntity> selectListByEntity(VisDoorKeeperEntity record);

    /**
     */
    List<VisDoorKeeperEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisDoorKeeperEntity> list);
}