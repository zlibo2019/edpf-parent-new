package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.MjSdRuleRealMapper;
import com.weds.edmj.entity.MjSdRuleRealEntity;

/**
 * @Author sxm
 * @Description MjSdRuleReal管理
 * @Date 2019-07-25
 */
@Service
public class MjSdRuleRealService extends BaseService {

    @Autowired
    private MjSdRuleRealMapper mjSdRuleRealMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return mjSdRuleRealMapper.deleteByPrimaryKey(xh);
    }

    public int insert(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.insert(record);
    }

    public int deleteByCondition(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.deleteByCondition(record);
    }

    public int insertSelective(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.insertSelective(record);
    }

    public MjSdRuleRealEntity selectByPrimaryKey(Integer xh) {
        return mjSdRuleRealMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.updateByPrimaryKey(record);
    }

    public List<MjSdRuleRealEntity> selectListByEntity(MjSdRuleRealEntity record) {
        return mjSdRuleRealMapper.selectListByEntity(record);
    }


    public List<MjSdRuleRealEntity> selectListByKeys(String keys) {
        return mjSdRuleRealMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MjSdRuleRealEntity> list) {
        return mjSdRuleRealMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<MjSdRuleRealEntity> list) {
        return mjSdRuleRealMapper.insertBatch(list);
    }
}
