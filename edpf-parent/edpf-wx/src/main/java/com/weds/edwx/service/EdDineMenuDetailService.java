package com.weds.edwx.service;

import com.weds.edwx.entity.EdDineMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineMenuDetailMapper;
import com.weds.edwx.entity.EdDineMenuDetailEntity;

/**
 * @Author sxm
 * @Description 菜谱详情管理
 * @Date 2019-04-12
 */
@Service
public class EdDineMenuDetailService extends BaseService {

    @Autowired
    private EdDineMenuDetailMapper edDineMenuDetailMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String menuId, String foodId) {
        return edDineMenuDetailMapper.deleteByPrimaryKey(menuId, foodId);
    }

    public int insert(EdDineMenuDetailEntity record) {
        return edDineMenuDetailMapper.insert(record);
    }

    public int insertSelective(EdDineMenuDetailEntity record) {
        return edDineMenuDetailMapper.insertSelective(record);
    }

    public EdDineMenuDetailEntity selectByPrimaryKey(String menuId, String foodId) {
        return edDineMenuDetailMapper.selectByPrimaryKey(menuId, foodId);
    }

    public int updateByPrimaryKeySelective(EdDineMenuDetailEntity record) {
        return edDineMenuDetailMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineMenuDetailEntity record) {
        return edDineMenuDetailMapper.updateByPrimaryKey(record);
    }

    public List<EdDineMenuDetailEntity> selectListByEntity(EdDineMenuDetailEntity record) {
        return edDineMenuDetailMapper.selectListByEntity(record);
    }

    public List<EdDineMenuDetailEntity> selectListByKeys(String keys) {
        return edDineMenuDetailMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineMenuDetailEntity> list) {
        return edDineMenuDetailMapper.deleteBatchByKeys(list);
    }
}
