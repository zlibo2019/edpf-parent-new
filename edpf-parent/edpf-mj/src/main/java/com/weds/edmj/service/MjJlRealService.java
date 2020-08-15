package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.MjJlRealMapper;
import com.weds.edmj.entity.MjJlRealEntity;

/**
 * @Author sxm
 * @Description 门通行记录表管理
 * @Date 2019-08-06
 */
@Service
public class MjJlRealService extends BaseService {

    @Autowired
    private MjJlRealMapper mjJlRealMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Date jlSj, Integer xh) {
        return mjJlRealMapper.deleteByPrimaryKey(jlSj, xh);
    }

    public int insert(MjJlRealEntity record) {
        return mjJlRealMapper.insert(record);
    }

    public int insertSelective(MjJlRealEntity record) {
        return mjJlRealMapper.insertSelective(record);
    }

    public MjJlRealEntity selectByPrimaryKey(Date jlSj, Integer xh) {
        return mjJlRealMapper.selectByPrimaryKey(jlSj, xh);
    }

    public int updateByPrimaryKeySelective(MjJlRealEntity record) {
        return mjJlRealMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MjJlRealEntity record) {
        return mjJlRealMapper.updateByPrimaryKey(record);
    }

    public List<MjJlRealEntity> selectListByEntity(MjJlRealEntity record) {
        return mjJlRealMapper.selectListByEntity(record);
    }

    public List<MjJlRealEntity> selectListByCondition(MjJlRealEntity record) {
        return mjJlRealMapper.selectListByCondition(record);
    }

    public int deleteBatchByKeys(List<MjJlRealEntity> list) {
        return mjJlRealMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<MjJlRealEntity> list) {
        return mjJlRealMapper.insertBatch(list);
    }
}
