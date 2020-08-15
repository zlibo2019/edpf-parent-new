package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdAgentDevicePriceMapper;
import com.weds.edwx.entity.EdAgentDevicePriceEntity;

/**
 * @Author
 * @Description 代理商设备报备信息管理
 * @Date 2019-11-23
 */
@Service
public class EdAgentDevicePriceService extends BaseService {

    @Resource
    private EdAgentDevicePriceMapper edAgentDevicePriceMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return edAgentDevicePriceMapper.deleteByPrimaryKey(id);
    }

    public int insert(EdAgentDevicePriceEntity record) {
        return edAgentDevicePriceMapper.insert(record);
    }

    public int insertSelective(EdAgentDevicePriceEntity record) {
        return edAgentDevicePriceMapper.insertSelective(record);
    }

    public EdAgentDevicePriceEntity selectByPrimaryKey(String id) {
        return edAgentDevicePriceMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EdAgentDevicePriceEntity record) {
        return edAgentDevicePriceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdAgentDevicePriceEntity record) {
        return edAgentDevicePriceMapper.updateByPrimaryKey(record);
    }

    public List<EdAgentDevicePriceEntity> selectListByEntity(EdAgentDevicePriceEntity record) {
        return edAgentDevicePriceMapper.selectListByEntity(record);
    }
}
