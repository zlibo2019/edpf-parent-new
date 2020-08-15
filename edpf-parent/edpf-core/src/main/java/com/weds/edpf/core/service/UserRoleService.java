package com.weds.edpf.core.service;

import com.weds.edpf.core.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.UserRoleMapper;

/**
 * @Author sxm
 * @Description 用户角色关系管理
 * @Date 2019-03-07
 */
@Service
public class UserRoleService extends BaseService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    private Logger log = LogManager.getLogger();

    public void insertByRoleId(String roleId, List<String> list) {
        Date date = new Date();
        userRoleMapper.deleteByRoleId(roleId);
        for (String str : list) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRoleId(roleId);
            userRoleEntity.setUserSerial(str);
            userRoleEntity.setCtDate(date);
            userRoleEntity.setLtDate(date);
            userRoleMapper.insert(userRoleEntity);
        }
    }

    public int deleteByPrimaryKey(String userSerial, String roleId) {
        return userRoleMapper.deleteByPrimaryKey(userSerial, roleId);
    }

    public int insert(UserRoleEntity record) {
        return userRoleMapper.insert(record);
    }

    public int insertSelective(UserRoleEntity record) {
        return userRoleMapper.insertSelective(record);
    }

    public UserRoleEntity selectByPrimaryKey(String userSerial, String roleId) {
        return userRoleMapper.selectByPrimaryKey(userSerial, roleId);
    }

    public int updateByPrimaryKeySelective(UserRoleEntity record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserRoleEntity record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    public List<UserRoleEntity> selectListByEntity(UserRoleEntity record) {
        return userRoleMapper.selectListByEntity(record);
    }

    public List<UserRoleEntity> selectListByKeys(String keys) {
        return userRoleMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<UserRoleEntity> list) {
        return userRoleMapper.deleteBatchByKeys(list);
    }
}
