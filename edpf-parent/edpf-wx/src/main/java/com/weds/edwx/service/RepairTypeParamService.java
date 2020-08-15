package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.RepairTypeParamMapper;
import com.weds.edwx.entity.RepairTypeParamEntity;

/**
 * @Author sxm
 * @Description RepairTypeParam管理
 * @Date 2019-02-28
 */
@Service
public class RepairTypeParamService extends BaseService {

    @Autowired
    private RepairTypeParamMapper repairTypeParamMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String companyId, String typeId) {
        return repairTypeParamMapper.deleteByPrimaryKey(companyId, typeId);
    }

    public int insert(RepairTypeParamEntity record) {
        return repairTypeParamMapper.insert(record);
    }

    public int insertSelective(RepairTypeParamEntity record) {
        return repairTypeParamMapper.insertSelective(record);
    }

    public RepairTypeParamEntity selectByPrimaryKey(String companyId, String typeId) {
        return repairTypeParamMapper.selectByPrimaryKey(companyId, typeId);
    }

    public int updateByPrimaryKeySelective(RepairTypeParamEntity record) {
        return repairTypeParamMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RepairTypeParamEntity record) {
        return repairTypeParamMapper.updateByPrimaryKey(record);
    }

    public List<RepairTypeParamEntity> selectListByEntity(RepairTypeParamEntity record) {
        return repairTypeParamMapper.selectListByEntity(record);
    }
}
