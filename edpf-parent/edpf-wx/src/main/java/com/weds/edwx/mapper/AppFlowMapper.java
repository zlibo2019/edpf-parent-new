package com.weds.edwx.mapper;

import com.weds.edwx.entity.AppFlowEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author
 * @Description 审批流程表管理
 * @Date 2019-02-19
 */
@MyBatisDao
public interface AppFlowMapper {
    /**
     */
    int deleteByPrimaryKey(String flowId);

    /**
     */
    int insert(AppFlowEntity record);

    /**
     */
    int insertSelective(AppFlowEntity record);

    /**
     */
    AppFlowEntity selectByPrimaryKey(String flowId);

    /**
     */
    int updateByPrimaryKeySelective(AppFlowEntity record);

    /**
     */
    int updateByPrimaryKey(AppFlowEntity record);

    /**
     */
    List<AppFlowEntity> selectListByEntity(AppFlowEntity record);


    /**
     */
    int deleteNextApproval(String bussinessId);
}