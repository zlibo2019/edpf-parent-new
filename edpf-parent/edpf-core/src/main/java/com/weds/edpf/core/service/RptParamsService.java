package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.RptParamsMapper;
import com.weds.edpf.core.entity.RptParamsEntity;

/**
 * @Author sxm
 * @Description 报表模板参数管理
 * @Date 2019-05-15
 */
@Service
public class RptParamsService extends BaseService {

    @Autowired
    private RptParamsMapper rptParamsMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String rptId) {
        return rptParamsMapper.deleteByPrimaryKey(rptId);
    }

    public int insert(RptParamsEntity record) {
        return rptParamsMapper.insert(record);
    }

    public int insertSelective(RptParamsEntity record) {
        return rptParamsMapper.insertSelective(record);
    }

    public RptParamsEntity selectByPrimaryKey(String rptId) {
        return rptParamsMapper.selectByPrimaryKey(rptId);
    }

    public int updateByPrimaryKeySelective(RptParamsEntity record) {
        return rptParamsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RptParamsEntity record) {
        return rptParamsMapper.updateByPrimaryKey(record);
    }

    public List<RptParamsEntity> selectListByEntity(RptParamsEntity record) {
        return rptParamsMapper.selectListByEntity(record);
    }


    public List<RptParamsEntity> selectListByKeys(String keys) {
        return rptParamsMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<RptParamsEntity> list) {
        return rptParamsMapper.deleteBatchByKeys(list);
    }
}
