package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.DineOrderMapper;
import com.weds.edwx.entity.DineOrderEntity;

/**
 * @Author sxm
 * @Description DineOrder管理
 * @Date 2018-11-13
 */
@Service
public class DineOrderService extends BaseService {

    @Autowired
    private DineOrderMapper dineOrderMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return dineOrderMapper.deleteByPrimaryKey(xh);
    }

    public int insert(DineOrderEntity record) {
        return dineOrderMapper.insert(record);
    }

    public int insertSelective(DineOrderEntity record) {
        return dineOrderMapper.insertSelective(record);
    }

    public DineOrderEntity selectByPrimaryKey(Integer xh) {
        return dineOrderMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(DineOrderEntity record) {
        return dineOrderMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DineOrderEntity record) {
        return dineOrderMapper.updateByPrimaryKey(record);
    }

    public List<DineOrderEntity> selectListByEntity(DineOrderEntity record) {
        return dineOrderMapper.selectListByEntity(record);
    }

    public List<DineOrderEntity> selectDistinctListByEntity(DineOrderEntity record) {
        return dineOrderMapper.selectDistinctListByEntity(record);
    }

    public List<DineOrderEntity> selectListByCondition(DineOrderEntity record) {
        return dineOrderMapper.selectListByCondition(record);
    }

    public int updateOrderByCondition(DineOrderEntity record) {
        return dineOrderMapper.updateOrderByCondition(record);
    }

    public DineOrderEntity selectDineNums(DineOrderEntity record) {
        return dineOrderMapper.selectDineNums(record);
    }
}
