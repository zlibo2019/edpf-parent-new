package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.DtAcDepMapper;
import com.weds.edmj.entity.DtAcDepEntity;

/**
 * @Author sxm
 * @Description DtAcDep管理
 * @Date 2019-07-30
 */
@Service
public class DtAcDepService extends BaseService {

    @Autowired
    private DtAcDepMapper dtAcDepMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer depSerial) {
        return dtAcDepMapper.deleteByPrimaryKey(depSerial);
    }

    public int insert(DtAcDepEntity record) {
        return dtAcDepMapper.insert(record);
    }

    public int insertSelective(DtAcDepEntity record) {
        return dtAcDepMapper.insertSelective(record);
    }

    public DtAcDepEntity selectByPrimaryKey(Integer depSerial) {
        return dtAcDepMapper.selectByPrimaryKey(depSerial);
    }

    public int updateByPrimaryKeySelective(DtAcDepEntity record) {
        return dtAcDepMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DtAcDepEntity record) {
        return dtAcDepMapper.updateByPrimaryKey(record);
    }

    public List<DtAcDepEntity> selectListByEntity(DtAcDepEntity record) {
        return dtAcDepMapper.selectListByEntity(record);
    }

    public int deleteBatchByKeys(List<DtAcDepEntity> list) {
        return dtAcDepMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<DtAcDepEntity> list) {
        return dtAcDepMapper.insertBatch(list);
    }

    public List<DtAcDepEntity> selectPlaceTree(Integer depParent) {
        return dtAcDepMapper.selectPlaceTree(depParent);
    }
}
