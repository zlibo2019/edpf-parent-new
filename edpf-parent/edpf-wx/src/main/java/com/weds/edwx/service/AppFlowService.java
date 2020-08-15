package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.AppFlowMapper;
import com.weds.edwx.entity.AppFlowEntity;

/**
 * @Author sxm
 * @Description 审批流程表管理
 * @Date 2019-02-19
 */
@Service
public class AppFlowService extends BaseService {

    @Autowired
    private AppFlowMapper appFlowMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String flowId) {
        return appFlowMapper.deleteByPrimaryKey(flowId);
    }

    public int insert(AppFlowEntity record) {
        return appFlowMapper.insert(record);
    }

    public int insertSelective(AppFlowEntity record) {
        return appFlowMapper.insertSelective(record);
    }

    public AppFlowEntity selectByPrimaryKey(String flowId) {
        return appFlowMapper.selectByPrimaryKey(flowId);
    }

    public int updateByPrimaryKeySelective(AppFlowEntity record) {
        return appFlowMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AppFlowEntity record) {
        return appFlowMapper.updateByPrimaryKey(record);
    }

    public List<AppFlowEntity> selectListByEntity(AppFlowEntity record) {
        return appFlowMapper.selectListByEntity(record);
    }

    public int deleteNextApproval(String bussinessId){
        return appFlowMapper.deleteNextApproval(bussinessId);
    }
}
