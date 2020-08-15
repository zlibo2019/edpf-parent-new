package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisDoorKeeperAreaEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 门卫用户区域管理管理
 * @Date 2019-04-17
 */
@MyBatisDao
public interface VisDoorKeeperAreaMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("userNo") String userNo, @Param("areaNo") String areaNo);

    /**
     */
    int insert(VisDoorKeeperAreaEntity record);

    /**
     */
    int insertSelective(VisDoorKeeperAreaEntity record);

    /**
     */
    VisDoorKeeperAreaEntity selectByPrimaryKey(@Param("userNo") String userNo, @Param("areaNo") String areaNo);

    /**
     */
    int updateByPrimaryKeySelective(VisDoorKeeperAreaEntity record);

    /**
     */
    int updateByPrimaryKey(VisDoorKeeperAreaEntity record);

    /**
     */
    List<VisDoorKeeperAreaEntity> selectListByEntity(VisDoorKeeperAreaEntity record);

    /**
     */
    List<VisDoorKeeperAreaEntity> selectAllListByEntity(VisDoorKeeperAreaEntity record);

    /**
     */
    List<VisDoorKeeperAreaEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisDoorKeeperAreaEntity> list);
}