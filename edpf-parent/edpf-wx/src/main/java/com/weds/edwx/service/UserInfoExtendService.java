package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.UserInfoExtendMapper;
import com.weds.edwx.entity.UserInfoExtendEntity;

/**
 * @Author sxm
 * @Description 用户扩展信息管理
 * @Date 2019-02-21
 */
@Service
public class UserInfoExtendService extends BaseService {

    @Autowired
    private UserInfoExtendMapper userInfoExtendMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userSerial) {
        return userInfoExtendMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(UserInfoExtendEntity record) {
        return userInfoExtendMapper.insert(record);
    }

    public int insertSelective(UserInfoExtendEntity record) {
        return userInfoExtendMapper.insertSelective(record);
    }

    public UserInfoExtendEntity selectByPrimaryKey(String userSerial) {
        return userInfoExtendMapper.selectByPrimaryKey(userSerial);
    }

    public int updateByPrimaryKeySelective(UserInfoExtendEntity record) {
        return userInfoExtendMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserInfoExtendEntity record) {
        return userInfoExtendMapper.updateByPrimaryKey(record);
    }

    public List<UserInfoExtendEntity> selectListByEntity(UserInfoExtendEntity record) {
        return userInfoExtendMapper.selectListByEntity(record);
    }

}
