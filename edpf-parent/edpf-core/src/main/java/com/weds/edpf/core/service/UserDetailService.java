package com.weds.edpf.core.service;

import javax.annotation.Resource;

import com.weds.edpf.core.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.UserDetailMapper;
import com.weds.edpf.core.entity.UserDetailEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author
 * @Description 人员详细信息管理
 * @Date 2019-09-27
 */
@Service
public class UserDetailService extends BaseService {

    @Resource
    private UserDetailMapper userDetailMapper;

    @Resource(name = "userInfoMapperNew")
    private UserInfoMapper userInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userId) {
        return userDetailMapper.deleteByPrimaryKey(userId);
    }

    public int insert(UserDetailEntity record) {
        return userDetailMapper.insert(record);
    }

    @Transactional
    public int insertSelective(UserDetailEntity record) {
        userInfoMapper.insertSelective(record);
        return userDetailMapper.insertSelective(record);
    }

    public UserDetailEntity selectByPrimaryKey(String userId) {
        return userDetailMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(UserDetailEntity record) {
        userInfoMapper.updateByPrimaryKeySelective(record);
        return userDetailMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserDetailEntity record) {
        return userDetailMapper.updateByPrimaryKey(record);
    }

    public List<UserDetailEntity> selectListByEntity(UserDetailEntity record) {
        return userDetailMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<UserDetailEntity> list) {
        return userDetailMapper.deleteBatchByKeys(list);
    }

}
