package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisSettingMapper;
import com.weds.edwx.entity.VisSettingEntity;

/**
 * @Author sxm
 * @Description VisSetting管理
 * @Date 2019-07-04
 */
@Service
public class VisSettingService extends BaseService {

    @Autowired
    private VisSettingMapper visSettingMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return visSettingMapper.deleteByPrimaryKey(id);
    }

    public int insert(VisSettingEntity record) {
        return visSettingMapper.insert(record);
    }

    public int insertSelective(VisSettingEntity record) {
        return visSettingMapper.insertSelective(record);
    }

    public VisSettingEntity selectByPrimaryKey(String id) {
        return visSettingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(VisSettingEntity record) {
        return visSettingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisSettingEntity record) {
        return visSettingMapper.updateByPrimaryKey(record);
    }

    public List<VisSettingEntity> selectListByEntity(VisSettingEntity record) {
        return visSettingMapper.selectListByEntity(record);
    }


    public List<VisSettingEntity> selectListByKeys(String keys) {
        return visSettingMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisSettingEntity> list) {
        return visSettingMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<VisSettingEntity> list) {
        return visSettingMapper.insertBatch(list);
    }
}
