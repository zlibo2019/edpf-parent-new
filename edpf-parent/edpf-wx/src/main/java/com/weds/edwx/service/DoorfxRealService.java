package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .DoorfxRealMapper;
import com.weds.edwx.entity .DoorfxRealEntity;

/**
 * @Author sxm
 * @Description DoorfxReal管理
 * @Date 2018-12-22
 */
@Service
public class DoorfxRealService extends BaseService {

	@Autowired
	private DoorfxRealMapper doorfxRealMapper;

	private Logger log = LogManager.getLogger();

//	public int deleteByPrimaryKey(String gateBh,Integer xh) {
//		return doorfxRealMapper.deleteByPrimaryKey(gateBh,xh);
//	}
//
//	public int insert(DoorfxRealEntity record) {
//		return doorfxRealMapper.insert(record);
//	}
//
//	public int insertSelective(DoorfxRealEntity record) {
//		return doorfxRealMapper.insertSelective(record);
//	}

	public DoorfxRealEntity selectByPrimaryKey(String gateBh) {
		return doorfxRealMapper.selectByPrimaryKey(gateBh);
	}

//	public int updateByPrimaryKeySelective(DoorfxRealEntity record) {
//		return doorfxRealMapper.updateByPrimaryKeySelective(record);
//	}
//
//	public int updateByPrimaryKey(DoorfxRealEntity record) {
//		return doorfxRealMapper.updateByPrimaryKey(record);
//	}
//
//	public List<DoorfxRealEntity> selectListByEntity(DoorfxRealEntity record) {
//		return doorfxRealMapper.selectListByEntity(record);
//	}

	}
