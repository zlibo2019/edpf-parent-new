package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.EdAgentDevicePriceEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 代理商设备报备信息管理
 * @Date 2019-11-23
 */
@MyBatisDao
public interface EdAgentDevicePriceMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(EdAgentDevicePriceEntity record);

    /**
     */
    int insertSelective(EdAgentDevicePriceEntity record);

    /**
     */
    EdAgentDevicePriceEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(EdAgentDevicePriceEntity record);

    /**
     */
    int updateByPrimaryKey(EdAgentDevicePriceEntity record);

    /**
     */
    List<EdAgentDevicePriceEntity> selectListByEntity(EdAgentDevicePriceEntity record);
}