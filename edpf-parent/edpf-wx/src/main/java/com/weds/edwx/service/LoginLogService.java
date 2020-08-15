package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .LoginLogMapper;
import com.weds.edwx.entity .LoginLogEntity;

/**
 * @Author sxm
 * @Description LoginLog管理
 * @Date 2018-11-26
 */
@Service
public class LoginLogService extends BaseService {

	@Autowired
	private LoginLogMapper loginLogMapper;

	private Logger log = LogManager.getLogger();
	public int insert(LoginLogEntity record) {
		return loginLogMapper.insert(record);
	}

	/*
	public int deleteByPrimaryKey() {
		return loginLogMapper.deleteByPrimaryKey();
	}
	public int insertSelective(LoginLogEntity record) {
		return loginLogMapper.insertSelective(record);
	}

	public LoginLogEntity selectByPrimaryKey() {
		return loginLogMapper.selectByPrimaryKey();
	}

	public int updateByPrimaryKeySelective(LoginLogEntity record) {
		return loginLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(LoginLogEntity record) {
		return loginLogMapper.updateByPrimaryKey(record);
	}

	public List<LoginLogEntity> selectListByEntity(LoginLogEntity record) {
		return loginLogMapper.selectListByEntity(record);
	}*/

	}
