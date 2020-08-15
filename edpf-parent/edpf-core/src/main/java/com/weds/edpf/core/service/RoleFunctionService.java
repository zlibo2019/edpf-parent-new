package com.weds.edpf.core.service;

import com.weds.edpf.core.entity.RoleFunctionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.RoleFunctionMapper;

/**
 * @Author sxm
 * @Description 角色功能关系管理
 * @Date 2019-03-08
 */
@Service
public class RoleFunctionService extends BaseService {

    @Autowired
    private RoleFunctionMapper roleFunctionMapper;

    private Logger log = LogManager.getLogger();

    public void insertByRoleId(String roleId, List<String> list) {
        Date date = new Date();
        roleFunctionMapper.deleteByRoleId(roleId);
        for (String str : list) {
            RoleFunctionEntity roleFunctionEntity = new RoleFunctionEntity();
            roleFunctionEntity.setRoleId(roleId);
            roleFunctionEntity.setFunctionId(str);
            roleFunctionEntity.setCtDate(date);
            roleFunctionEntity.setLtDate(date);
            roleFunctionMapper.insert(roleFunctionEntity);
        }
    }

    public int deleteByPrimaryKey(String roleId, String functionId) {
        return roleFunctionMapper.deleteByPrimaryKey(roleId, functionId);
    }

    public int insert(RoleFunctionEntity record) {
        return roleFunctionMapper.insert(record);
    }

    public int insertSelective(RoleFunctionEntity record) {
        return roleFunctionMapper.insertSelective(record);
    }

    public RoleFunctionEntity selectByPrimaryKey(String roleId, String functionId) {
        return roleFunctionMapper.selectByPrimaryKey(roleId, functionId);
    }

    public int updateByPrimaryKeySelective(RoleFunctionEntity record) {
        return roleFunctionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RoleFunctionEntity record) {
        return roleFunctionMapper.updateByPrimaryKey(record);
    }

    public List<RoleFunctionEntity> selectListByEntity(RoleFunctionEntity record) {
        return roleFunctionMapper.selectListByEntity(record);
    }


    public List<RoleFunctionEntity> selectListByKeys(String keys) {
        return roleFunctionMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<RoleFunctionEntity> list) {
        return roleFunctionMapper.deleteBatchByKeys(list);
    }

    public int deleteByRoleId(String roleId) {
        return roleFunctionMapper.deleteByRoleId(roleId);
    }
}
