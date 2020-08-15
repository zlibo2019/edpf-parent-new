package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.UserInfoEntity;
import com.weds.edwx.mapper.UserInfoMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sxm
 * @Description UserInfo管理
 * @Date 2018-12-13
 */
@Service
public class UserInfoService extends BaseService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long userSerial) {
        return userInfoMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(UserInfoEntity record) {
        return userInfoMapper.insert(record);
    }

    public int insertSelective(UserInfoEntity record) {
        return userInfoMapper.insertSelective(record);
    }

    public UserInfoEntity selectByPrimaryKey(Long userSerial) {
        return userInfoMapper.selectByPrimaryKey(userSerial);
    }

    public UserInfoEntity selectByIdCard(String userId) {
        return userInfoMapper.selectByIdCard(userId);
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

    public List<UserInfoEntity> selectUsersInfo(List<Integer> userList) {
        return userInfoMapper.selectUsersInfo(userList);
    }

    public List<UserInfoEntity> selectDeptUsers(List<Integer> depList) {
        return userInfoMapper.selectDeptUsers(depList);
    }

    public List<UserInfoEntity> selectDeptUsersList(List<Integer> depList) {
        return userInfoMapper.selectDeptUsersList(depList);
    }

    public List<UserInfoEntity> selectUserList(String userInfo) {
        return userInfoMapper.selectUserList(userInfo);
    }

    public List<UserInfoEntity> selectVisUserByDept(UserInfoEntity record) {
        return userInfoMapper.selectVisUserByDept(record);
    }
}
