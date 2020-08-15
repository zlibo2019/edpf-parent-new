package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineFoodMapper;
import com.weds.edwx.entity.EdDineFoodEntity;

/**
 * @Author sxm
 * @Description 菜品定义管理
 * @Date 2019-04-12
 */
@Service
public class EdDineFoodService extends BaseService {

    @Autowired
    private EdDineFoodMapper edDineFoodMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String foodId) {
        return edDineFoodMapper.deleteByPrimaryKey(foodId);
    }

    public int insert(EdDineFoodEntity record) {
        return edDineFoodMapper.insert(record);
    }

    public int insertSelective(EdDineFoodEntity record) {
        return edDineFoodMapper.insertSelective(record);
    }

    public EdDineFoodEntity selectByPrimaryKey(String foodId) {
        return edDineFoodMapper.selectByPrimaryKey(foodId);
    }

    public int updateByPrimaryKeySelective(EdDineFoodEntity record) {
        return edDineFoodMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineFoodEntity record) {
        return edDineFoodMapper.updateByPrimaryKey(record);
    }

    public List<EdDineFoodEntity> selectListByEntity(EdDineFoodEntity record) {
        return edDineFoodMapper.selectListByEntity(record);
    }


    public List<EdDineFoodEntity> selectListByKeys(String keys) {
        return edDineFoodMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineFoodEntity> list) {
        return edDineFoodMapper.deleteBatchByKeys(list);
    }

    public List<EdDineFoodEntity> selectFoodList(EdDineFoodEntity record) {
        return edDineFoodMapper.selectFoodList(record);
    }

    public List<EdDineFoodEntity> selectFoodListNew(EdDineFoodEntity record) {
        return edDineFoodMapper.selectFoodListNew(record);
    }
}
