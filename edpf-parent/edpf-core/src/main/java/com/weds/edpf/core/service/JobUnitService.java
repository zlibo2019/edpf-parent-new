package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.JobUnitMapper;
import com.weds.edpf.core.entity.JobUnitEntity;

/**
 * @Author sxm
 * @Description 作业单元信息管理
 * @Date 2019-05-06
 */
@Service
public class JobUnitService extends BaseService {

    @Autowired
    private JobUnitMapper jobUnitMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String jobId) {
        return jobUnitMapper.deleteByPrimaryKey(jobId);
    }

    public int insert(JobUnitEntity record) {
        return jobUnitMapper.insert(record);
    }

    public int insertSelective(JobUnitEntity record) {
        return jobUnitMapper.insertSelective(record);
    }

    public JobUnitEntity selectByPrimaryKey(String jobId) {
        return jobUnitMapper.selectByPrimaryKey(jobId);
    }

    public int updateByPrimaryKeySelective(JobUnitEntity record) {
        return jobUnitMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(JobUnitEntity record) {
        return jobUnitMapper.updateByPrimaryKey(record);
    }

    public List<JobUnitEntity> selectListByEntity(JobUnitEntity record) {
        return jobUnitMapper.selectListByEntity(record);
    }


    public List<JobUnitEntity> selectListByKeys(String keys) {
        return jobUnitMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<JobUnitEntity> list) {
        return jobUnitMapper.deleteBatchByKeys(list);
    }
}
