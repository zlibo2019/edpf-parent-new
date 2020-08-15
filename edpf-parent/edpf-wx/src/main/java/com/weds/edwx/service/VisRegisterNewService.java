package com.weds.edwx.service;

import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.VisUserNewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisRegisterNewMapper;
import com.weds.edwx.entity.VisRegisterNewEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Author sxm
 * @Description VisRegisterNew管理
 * @Date 2019-05-21
 */
@Service
public class VisRegisterNewService extends BaseService {

    @Autowired
    private VisRegisterNewMapper visRegisterNewMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return visRegisterNewMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisRegisterNewEntity record) {
        return visRegisterNewMapper.insert(record);
    }

    public int insertSelective(VisRegisterNewEntity record) {
        return visRegisterNewMapper.insertSelective(record);
    }

    public VisRegisterNewEntity selectByPrimaryKey(Integer xh) {
        return visRegisterNewMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisRegisterNewEntity record) {
        return visRegisterNewMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisRegisterNewEntity record) {
        return visRegisterNewMapper.updateByPrimaryKey(record);
    }

    public List<VisRegisterNewEntity> selectListByEntity(VisRegisterNewEntity record) {
        return visRegisterNewMapper.selectListByEntity(record);
    }


    public List<VisRegisterNewEntity> selectListByKeys(String keys) {
        return visRegisterNewMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisRegisterNewEntity> list) {
        return visRegisterNewMapper.deleteBatchByKeys(list);
    }

    public List<VisRegisterNewEntity> selectRepeatRecord(VisRegisterNewEntity record) {
        return visRegisterNewMapper.selectRepeatRecord(record);
    }
}
