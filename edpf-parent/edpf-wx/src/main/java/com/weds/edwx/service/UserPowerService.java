package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.UserPowerMapper;
import com.weds.edwx.entity.UserPowerEntity;

/**
 * @Author
 * @Description UserPower管理
 * @Date 2019-10-09
 */
@Service
public class UserPowerService extends BaseService {

    @Resource
    private UserPowerMapper userPowerMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long userSerial) {
        return userPowerMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(UserPowerEntity record) {
        return userPowerMapper.insert(record);
    }

    public int insertSelective(UserPowerEntity record) {
        return userPowerMapper.insertSelective(record);
    }

    public UserPowerEntity selectByPrimaryKey(Long userSerial) {
        return userPowerMapper.selectByPrimaryKey(userSerial);
    }

    public int updateByPrimaryKeySelective(UserPowerEntity record) {
        return userPowerMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserPowerEntity record) {
        return userPowerMapper.updateByPrimaryKey(record);
    }

    public List<UserPowerEntity> selectListByEntity(UserPowerEntity record) {
        return userPowerMapper.selectListByEntity(record);
    }
}
