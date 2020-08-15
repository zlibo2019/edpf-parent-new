package com.weds.edpf.core.service;

import com.weds.bean.datasource.DruidParams;
import com.weds.edpf.core.entity.SysFunctionEntity;
import com.weds.edpf.core.mapper.SysFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;

import javax.annotation.Resource;

/**
 * @Author sxm
 * @Description 权限管理管理
 * @Date 2019-03-07
 */
@Service
public class SysFunctionService extends BaseService {

    @Autowired
    private SysFunctionMapper sysFunctionMapper;

    @Resource
    private DruidParams druidParams;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String functionId) {
        return sysFunctionMapper.deleteByPrimaryKey(functionId);
    }

    public int insert(SysFunctionEntity record) {
        return sysFunctionMapper.insert(record);
    }

    public int insertSelective(SysFunctionEntity record) {
        return sysFunctionMapper.insertSelective(record);
    }

    public SysFunctionEntity selectByPrimaryKey(String functionId) {
        return sysFunctionMapper.selectByPrimaryKey(functionId);
    }

    public int updateByPrimaryKeySelective(SysFunctionEntity record) {
        return sysFunctionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SysFunctionEntity record) {
        return sysFunctionMapper.updateByPrimaryKey(record);
    }

    public List<SysFunctionEntity> selectListByEntity(SysFunctionEntity record) {
        return sysFunctionMapper.selectListByEntity(record);
    }


    public List<SysFunctionEntity> selectListByKeys(String keys) {
        return sysFunctionMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<SysFunctionEntity> list) {
        return sysFunctionMapper.deleteBatchByKeys(list);
    }

    public List<SysFunctionEntity> selectTreeData(SysFunctionEntity record) {
        if (druidParams.getDriverClassName().contains("postgresql")) {
            record.setSqlKey("recursive");
        } else {
            record.setSqlKey("");
        }
        return sysFunctionMapper.selectTreeData(record);
    }

    public List<SysFunctionEntity> selectListByIds(List<SysFunctionEntity> list) {
        return sysFunctionMapper.selectListByIds(list);
    }

    public int insertBatch(List<SysFunctionEntity> list) {
        return sysFunctionMapper.insertBatch(list);
    }

    public int deleteAll() {
        return sysFunctionMapper.deleteAll();
    }
}
