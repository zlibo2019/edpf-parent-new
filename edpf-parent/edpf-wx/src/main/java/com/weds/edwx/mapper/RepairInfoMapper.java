package com.weds.edwx.mapper;

import com.weds.edwx.entity.RepairInfoEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Description 管理
 * @Date 2019-02-23
 */
@MyBatisDao
public interface RepairInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(RepairInfoEntity record);

    /**
     */
    int insertSelective(RepairInfoEntity record);

    /**
     */
    RepairInfoEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(RepairInfoEntity record);

    /**
     */
    int updateByPrimaryKey(RepairInfoEntity record);

    /**
     */
    List<RepairInfoEntity> selectListByEntity(RepairInfoEntity record);

    /**
     */
    List<Map> selectSumInfoByEntity(RepairInfoEntity record);
}