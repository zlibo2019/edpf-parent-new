package com.weds.edpf.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.UserInfoMapper;
import com.weds.edpf.core.entity.UserInfoEntity;

/**
 * @Author
 * @Description 人员基本信息管理
 * @Date 2019-09-27
 */
@Service("userInfoServiceNew")
public class UserInfoService extends BaseService {

    @Resource(name = "userInfoMapperNew")
    private UserInfoMapper userInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userId) {
        return userInfoMapper.deleteByPrimaryKey(userId);
    }

    public int insert(UserInfoEntity record) {
        return userInfoMapper.insert(record);
    }

    public int insertSelective(UserInfoEntity record) {
        return userInfoMapper.insertSelective(record);
    }

    public UserInfoEntity selectByPrimaryKey(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(UserInfoEntity record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserInfoEntity record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    public List<UserInfoEntity> selectListByEntity(UserInfoEntity record) {
        return userInfoMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<UserInfoEntity> list) {
        return userInfoMapper.deleteBatchByKeys(list);
    }

}
