package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.MjRuleRealMapper;
import com.weds.edmj.entity.MjRuleRealEntity;

/**
 * @Author sxm
 * @Description MjRuleReal管理
 * @Date 2019-07-25
 */
@Service
public class MjRuleRealService extends BaseService {

    @Autowired
    private MjRuleRealMapper mjRuleRealMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer ruleNo) {
        return mjRuleRealMapper.deleteByPrimaryKey(ruleNo);
    }

    public int insert(MjRuleRealEntity record) {
        Map map = mjRuleRealMapper.selectMaxRuleNo();
        if (map == null) {
            record.setRuleNo(1);
        } else {
            record.setRuleNo(Integer.parseInt(map.get("ruleNo").toString()));
        }
        return mjRuleRealMapper.insert(record);
    }

    public int insertSelective(MjRuleRealEntity record) {
        Map map = mjRuleRealMapper.selectMaxRuleNo();
        if (map == null) {
            record.setRuleNo(1);
        } else {
            record.setRuleNo(Integer.parseInt(map.get("ruleNo").toString()));
        }
        return mjRuleRealMapper.insertSelective(record);
    }

    public MjRuleRealEntity selectByPrimaryKey(Integer ruleNo) {
        return mjRuleRealMapper.selectByPrimaryKey(ruleNo);
    }

    public int updateByPrimaryKeySelective(MjRuleRealEntity record) {
        return mjRuleRealMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MjRuleRealEntity record) {
        return mjRuleRealMapper.updateByPrimaryKey(record);
    }

    public List<MjRuleRealEntity> selectListByEntity(MjRuleRealEntity record) {
        return mjRuleRealMapper.selectListByEntity(record);
    }


    public List<MjRuleRealEntity> selectListByKeys(String keys) {
        return mjRuleRealMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MjRuleRealEntity> list) {
        return mjRuleRealMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<MjRuleRealEntity> list) {
        return mjRuleRealMapper.insertBatch(list);
    }
}
