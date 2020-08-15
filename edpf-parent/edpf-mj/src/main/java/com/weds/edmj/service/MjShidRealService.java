package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.MjShidRealMapper;
import com.weds.edmj.entity.MjShidRealEntity;

/**
 * @Author sxm
 * @Description MjShidReal管理
 * @Date 2019-07-25
 */
@Service
public class MjShidRealService extends BaseService {

    @Autowired
    private MjShidRealMapper mjShidRealMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer bh) {
        return mjShidRealMapper.deleteByPrimaryKey(bh);
    }

    public int insert(MjShidRealEntity record) {
        return mjShidRealMapper.insert(record);
    }

    public int insertSelective(MjShidRealEntity record) {
        return mjShidRealMapper.insertSelective(record);
    }

    public MjShidRealEntity selectByPrimaryKey(Integer bh) {
        return mjShidRealMapper.selectByPrimaryKey(bh);
    }

    public Map selectMaxBh() {
        return mjShidRealMapper.selectMaxBh();
    }

    public Map selectShidCount(String ruleNo) {
        return mjShidRealMapper.selectShidCount(ruleNo);
    }

    public int updateByPrimaryKeySelective(MjShidRealEntity record) {
        return mjShidRealMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MjShidRealEntity record) {
        return mjShidRealMapper.updateByPrimaryKey(record);
    }

    public List<MjShidRealEntity> selectListByEntity(MjShidRealEntity record) {
        return mjShidRealMapper.selectListByEntity(record);
    }


    public List<MjShidRealEntity> selectListByKeys(String keys) {
        return mjShidRealMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MjShidRealEntity> list) {
        return mjShidRealMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<MjShidRealEntity> list) {
        return mjShidRealMapper.insertBatch(list);
    }
}
