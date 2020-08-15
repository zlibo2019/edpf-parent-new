package com.weds.edwx.service;

import com.weds.edwx.entity.EdDineMealEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineMealSettingMapper;
import com.weds.edwx.entity.EdDineMealSettingEntity;

/**
 * @Author sxm
 * @Description 餐别设置管理
 * @Date 2019-04-16
 */
@Service
public class EdDineMealSettingService extends BaseService {

    @Autowired
    private EdDineMealSettingMapper edDineMealSettingMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String placeId, String merchantId, String mealId) {
        return edDineMealSettingMapper.deleteByPrimaryKey(placeId, merchantId, mealId);
    }

    public int insert(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.insert(record);
    }

    public int insertSelective(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.insertSelective(record);
    }

    public EdDineMealSettingEntity selectByPrimaryKey(String placeId, String merchantId, String mealId) {
        return edDineMealSettingMapper.selectByPrimaryKey(placeId, merchantId, mealId);
    }

    public int updateByPrimaryKeySelective(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.updateByPrimaryKey(record);
    }

    public List<EdDineMealSettingEntity> selectListByEntity(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.selectListByEntity(record);
    }


    public List<EdDineMealSettingEntity> selectListByKeys(String keys) {
        return edDineMealSettingMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineMealSettingEntity> list) {
        return edDineMealSettingMapper.deleteBatchByKeys(list);
    }

    public List<EdDineMealSettingEntity> selectDineInfo(EdDineMealSettingEntity record) {
        return edDineMealSettingMapper.selectDineInfo(record);
    }
}
