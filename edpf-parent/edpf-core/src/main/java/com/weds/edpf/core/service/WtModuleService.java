package com.weds.edpf.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.WtModuleMapper;
import com.weds.edpf.core.entity.WtModuleEntity;

/**
 * @Author
 * @Description WtModule管理
 * @Date 2019-10-11
 */
@Service
public class WtModuleService extends BaseService {

    @Resource
    private WtModuleMapper wtModuleMapper;

    private Logger log = LogManager.getLogger();

    public long selectSerialByModuleId(String moduleId) {
        synchronized (WtModuleService.class) {
            WtModuleEntity wtModuleEntity = wtModuleMapper.selectByPrimaryKey(moduleId);
            long serial = wtModuleEntity.getModuleUser() + 1;
            WtModuleEntity entity = new WtModuleEntity();
            entity.setModuleId(moduleId);
            entity.setModuleUser(serial);
            wtModuleMapper.updateByPrimaryKeySelective(entity);
            return serial;
        }
    }

    public int deleteByPrimaryKey(String moduleId) {
        return wtModuleMapper.deleteByPrimaryKey(moduleId);
    }

    public int insert(WtModuleEntity record) {
        return wtModuleMapper.insert(record);
    }

    public int insertSelective(WtModuleEntity record) {
        return wtModuleMapper.insertSelective(record);
    }

    public WtModuleEntity selectByPrimaryKey(String moduleId) {
        return wtModuleMapper.selectByPrimaryKey(moduleId);
    }

    public int updateByPrimaryKeySelective(WtModuleEntity record) {
        return wtModuleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(WtModuleEntity record) {
        return wtModuleMapper.updateByPrimaryKey(record);
    }
}
