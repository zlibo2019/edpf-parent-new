package com.weds.edpf.core.service;

import com.weds.edpf.core.entity.RoleInfoEntity;
import com.weds.edpf.core.mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;

/**
 * @Author sxm
 * @Description 角色信息管理
 * @Date 2019-03-07
 */
@Service
public class RoleInfoService extends BaseService {

	@Autowired
	private RoleInfoMapper roleInfoMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String roleId) {
		return roleInfoMapper.deleteByPrimaryKey(roleId);
	}

	public int insert(RoleInfoEntity record) {
		return roleInfoMapper.insert(record);
	}

	public int insertSelective(RoleInfoEntity record) {
		return roleInfoMapper.insertSelective(record);
	}

	public RoleInfoEntity selectByPrimaryKey(String roleId) {
		return roleInfoMapper.selectByPrimaryKey(roleId);
	}

	public int updateByPrimaryKeySelective(RoleInfoEntity record) {
		return roleInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(RoleInfoEntity record) {
		return roleInfoMapper.updateByPrimaryKey(record);
	}

	public List<RoleInfoEntity> selectListByEntity(RoleInfoEntity record) {
		return roleInfoMapper.selectListByEntity(record);
	}

	
	public List<RoleInfoEntity> selectListByKeys(String keys) {
		return roleInfoMapper.selectListByKeys(keys);
	}

	public int deleteBatchByKeys(List<RoleInfoEntity> list) {
		return roleInfoMapper.deleteBatchByKeys(list);
	}
}
