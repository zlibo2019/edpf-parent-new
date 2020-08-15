package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.RepairInfoMapper;
import com.weds.edwx.entity.RepairInfoEntity;

/**
 * @Author sxm
 * @Description RepairInfo管理
 * @Date 2019-02-23
 */
@Service
public class RepairInfoService extends BaseService {

    @Autowired
    private RepairInfoMapper repairInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return repairInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(RepairInfoEntity record) {
        return repairInfoMapper.insert(record);
    }

    public int insertSelective(RepairInfoEntity record) {
        return repairInfoMapper.insertSelective(record);
    }

    public RepairInfoEntity selectByPrimaryKey(String id) {
        return repairInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(RepairInfoEntity record) {
        return repairInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RepairInfoEntity record) {
        return repairInfoMapper.updateByPrimaryKey(record);
    }

    public List<RepairInfoEntity> selectListByEntity(RepairInfoEntity record) {
        return repairInfoMapper.selectListByEntity(record);
    }

    public List<Map> selectSumInfoByEntity(RepairInfoEntity record) {
        return repairInfoMapper.selectSumInfoByEntity(record);
    }
}
