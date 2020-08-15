package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.DineUserMapper;
import com.weds.edwx.entity.DineUserEntity;

/**
 * @Author sxm
 * @Description DineUser管理
 * @Date 2018-11-13
 */
@Service
public class DineUserService extends BaseService {

    @Autowired
    private DineUserMapper dineUserMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer userSerial) {
        return dineUserMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(DineUserEntity record) {
        return dineUserMapper.insert(record);
    }

    public int insertSelective(DineUserEntity record) {
        return dineUserMapper.insertSelective(record);
    }

    public DineUserEntity selectByPrimaryKey(Integer userSerial) {
        return dineUserMapper.selectByPrimaryKey(userSerial);
    }

    public int updateByPrimaryKeySelective(DineUserEntity record) {
        return dineUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DineUserEntity record) {
        return dineUserMapper.updateByPrimaryKey(record);
    }

    public List<DineUserEntity> selectListByEntity(DineUserEntity record) {
        return dineUserMapper.selectListByEntity(record);
    }
}
