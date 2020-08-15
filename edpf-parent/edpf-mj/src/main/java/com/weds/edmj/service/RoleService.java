package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .RoleMapper;
import com.weds.edmj.entity .RoleEntity;

/**
 * @Author sxm
 * @Description Role管理
 * @Date 2019-08-14
 */
@Service
public class RoleService extends BaseService {

	@Autowired
	private RoleMapper roleMapper;

	private Logger log = LogManager.getLogger();


	public int insert(RoleEntity record) {
		return roleMapper.insert(record);
	}

	public int insertSelective(RoleEntity record) {
		return roleMapper.insertSelective(record);
	}


    	public List<RoleEntity> selectListByEntity(RoleEntity record) {
		return roleMapper.selectListByEntity(record);
	}
	
	

        public int deleteBatchByKeys(List<RoleEntity> list) {
        return roleMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<RoleEntity> list) {
		return roleMapper.insertBatch(list);
	}
	}
