package com.weds.edpf.core.service;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.entity.DepEntity;
import com.weds.edpf.core.mapper.DepMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sxm
 * @Description Dep管理
 * @Date 2018-12-13
 */
@Service
public class DepService extends BaseService {

    @Autowired
    private DepMapper depMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long depSerial) {
        return depMapper.deleteByPrimaryKey(depSerial);
    }

    public int insert(DepEntity record) {
        return depMapper.insert(record);
    }

    public int insertSelective(DepEntity record) {
        return depMapper.insertSelective(record);
    }

    public DepEntity selectByPrimaryKey(Long depSerial) {
        return depMapper.selectByPrimaryKey(depSerial);
    }

    public int updateByPrimaryKeySelective(DepEntity record) {
        return depMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DepEntity record) {
        return depMapper.updateByPrimaryKey(record);
    }

    public List<DepEntity> selectListByEntity(DepEntity record) {
        return depMapper.selectListByEntity(record);
    }

    public List<DepEntity> selectDeptUserNums(Integer depParentNo) {
        return depMapper.selectDeptUserNums(depParentNo);
    }

    public List<DepEntity> selectOrgTree(Integer depParentNo) {
        return depMapper.selectOrgTree(depParentNo);
    }

    public List<DepEntity> selectOrgTreeLazy(Integer depParentNo) {
        return depMapper.selectOrgTreeLazy(depParentNo);
    }
}

