package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.DineGlobalMapper;
import com.weds.edwx.entity.DineGlobalEntity;

/**
 * @Author sxm
 * @Description DineGlobal管理
 * @Date 2018-11-14
 */
@Service
public class DineGlobalService extends BaseService {

    @Autowired
    private DineGlobalMapper dineGlobalMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer bh) {
        return dineGlobalMapper.deleteByPrimaryKey(bh);
    }

    public int insert(DineGlobalEntity record) {
        return dineGlobalMapper.insert(record);
    }

    public int insertSelective(DineGlobalEntity record) {
        return dineGlobalMapper.insertSelective(record);
    }

    public DineGlobalEntity selectByPrimaryKey(Integer bh) {
        return dineGlobalMapper.selectByPrimaryKey(bh);
    }

    public int updateByPrimaryKeySelective(DineGlobalEntity record) {
        return dineGlobalMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DineGlobalEntity record) {
        return dineGlobalMapper.updateByPrimaryKey(record);
    }

    public List<DineGlobalEntity> selectListByEntity(DineGlobalEntity record) {
        return dineGlobalMapper.selectListByEntity(record);
    }

}
