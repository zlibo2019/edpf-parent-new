package com.weds.edmj.service;

import com.weds.edmj.entity.DoorRealEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .DoorfxRealMapper;
import com.weds.edmj.entity .DoorfxRealEntity;

/**
 * @Author sxm
 * @Description DoorfxReal管理
 * @Date 2019-07-29
 */
@Service
public class DoorfxRealService extends BaseService {

	@Autowired
	private DoorfxRealMapper doorfxRealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String gateBh) {
		return doorfxRealMapper.deleteByPrimaryKey(gateBh);
	}

	public int insert(DoorfxRealEntity record) {
		return doorfxRealMapper.insert(record);
	}

	public int insertSelective(DoorfxRealEntity record) {
		return doorfxRealMapper.insertSelective(record);
	}

	public List<DoorfxRealEntity> selectByPrimaryKey(String gateBh) {
		return doorfxRealMapper.selectByPrimaryKey(gateBh);
	}

	public int updateByPrimaryKeySelective(DoorfxRealEntity record) {
		return doorfxRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DoorfxRealEntity record) {
		return doorfxRealMapper.updateByPrimaryKey(record);
	}

    	public List<DoorfxRealEntity> selectListByEntity(DoorfxRealEntity record) {
		return doorfxRealMapper.selectListByEntity(record);
	}
	
	
    	public List<DoorfxRealEntity> selectListByKeys(String keys) {
		return doorfxRealMapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<DoorRealEntity> list) {
        return doorfxRealMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<DoorfxRealEntity> list) {
		return doorfxRealMapper.insertBatch(list);
	}
	}
