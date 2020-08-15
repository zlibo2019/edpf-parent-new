package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineSettingMapper;
import com.weds.edwx.entity.EdDineSettingEntity;

/**
 * @Author sxm
 * @Description 订餐配置管理
 * @Date 2019-04-12
 */
@Service
public class EdDineSettingService extends BaseService {

    @Autowired
    private EdDineSettingMapper edDineSettingMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String placeId, String mealId) {
        return edDineSettingMapper.deleteByPrimaryKey(placeId, mealId);
    }

    public int insert(EdDineSettingEntity record) {
        return edDineSettingMapper.insert(record);
    }

    public int insertSelective(EdDineSettingEntity record) {
        return edDineSettingMapper.insertSelective(record);
    }

    public EdDineSettingEntity selectByPrimaryKey(String placeId, String mealId) {
        return edDineSettingMapper.selectByPrimaryKey(placeId, mealId);
    }

    public int updateByPrimaryKeySelective(EdDineSettingEntity record) {
        return edDineSettingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineSettingEntity record) {
        return edDineSettingMapper.updateByPrimaryKey(record);
    }

    public List<EdDineSettingEntity> selectListByEntity(EdDineSettingEntity record) {
        return edDineSettingMapper.selectListByEntity(record);
    }

    public List<EdDineSettingEntity> selectListByKeys(String keys) {
        return edDineSettingMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineSettingEntity> list) {
        return edDineSettingMapper.deleteBatchByKeys(list);
    }
}
