package com.weds.edpf.core.service;

import com.weds.edpf.core.mapper.SysParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.entity.SysParamEntity;

/**
 * @Author sxm
 * @Description 系统参数管理
 * @Date 2019-03-07
 */
@Service
public class SysParamService extends BaseService {

    @Autowired
    private SysParamMapper sysParamMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String paramKey) {
        return sysParamMapper.deleteByPrimaryKey(paramKey);
    }

    public int insert(SysParamEntity record) {
        return sysParamMapper.insert(record);
    }

    public int insertSelective(SysParamEntity record) {
        return sysParamMapper.insertSelective(record);
    }

    public SysParamEntity selectByPrimaryKey(String paramKey) {
        return sysParamMapper.selectByPrimaryKey(paramKey);
    }

    public String selectValueByPrimaryKey(String paramKey) {
        SysParamEntity sysParamEntity = sysParamMapper.selectByPrimaryKey(paramKey);
        if (sysParamEntity == null) {
            return null;
        } else {
            return sysParamEntity.getParamValue();
        }
    }

    public int updateByPrimaryKeySelective(SysParamEntity record) {
        return sysParamMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SysParamEntity record) {
        return sysParamMapper.updateByPrimaryKey(record);
    }

    public List<SysParamEntity> selectListByEntity(SysParamEntity record) {
        return sysParamMapper.selectListByEntity(record);
    }


    public List<SysParamEntity> selectListByKeys(String keys) {
        return sysParamMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<SysParamEntity> list) {
        return sysParamMapper.deleteBatchByKeys(list);
    }
}
