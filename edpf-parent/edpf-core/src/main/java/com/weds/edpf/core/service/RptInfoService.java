package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.RptInfoMapper;
import com.weds.edpf.core.entity.RptInfoEntity;

/**
 * @Author sxm
 * @Description 报表模板管理管理
 * @Date 2019-05-13
 */
@Service
public class RptInfoService extends BaseService {

    @Autowired
    private RptInfoMapper rptInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String rptId) {
        return rptInfoMapper.deleteByPrimaryKey(rptId);
    }

    public int insert(RptInfoEntity record) {
        return rptInfoMapper.insert(record);
    }

    public int insertSelective(RptInfoEntity record) {
        return rptInfoMapper.insertSelective(record);
    }

    public RptInfoEntity selectByPrimaryKey(String rptId) {
        return rptInfoMapper.selectByPrimaryKey(rptId);
    }

    public int updateByPrimaryKeySelective(RptInfoEntity record) {
        return rptInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RptInfoEntity record) {
        return rptInfoMapper.updateByPrimaryKey(record);
    }

    public List<RptInfoEntity> selectListByEntity(RptInfoEntity record) {
        return rptInfoMapper.selectListByEntity(record);
    }


    public List<RptInfoEntity> selectListByKeys(String keys) {
        return rptInfoMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<RptInfoEntity> list) {
        return rptInfoMapper.deleteBatchByKeys(list);
    }
}
