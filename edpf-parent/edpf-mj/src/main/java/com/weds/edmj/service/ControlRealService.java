package com.weds.edmj.service;

import com.weds.edmj.entity.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .ControlRealMapper;
import com.weds.edmj.entity .ControlRealEntity;

/**
 * @Author sxm
 * @Description ControlReal管理
 * @Date 2019-07-31
 */
@Service
public class ControlRealService extends BaseService {

	@Autowired
	private ControlRealMapper controlRealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String devSerial, Integer devOrder) {
		return controlRealMapper.deleteByPrimaryKey(devSerial, devOrder);
	}

	public int insert(ControlRealEntity record) {
		return controlRealMapper.insert(record);
	}

	public int insertSelective(ControlRealEntity record) {
		return controlRealMapper.insertSelective(record);
	}

	public ControlRealEntity selectByPrimaryKey(String devSerial, Integer devOrder) {
		return controlRealMapper.selectByPrimaryKey(devSerial, devOrder);
	}

	public int updateByPrimaryKeySelective(ControlRealEntity record) {
		return controlRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ControlRealEntity record) {
		return controlRealMapper.updateByPrimaryKey(record);
	}

    	public List<ControlRealEntity> selectListByEntity(DeviceEntity record) {
		return controlRealMapper.selectListByEntity(record);
	}
	
	
    	public List<ControlRealEntity> selectListByKeys(String keys) {
		return controlRealMapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<ControlRealEntity> list) {
        return controlRealMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<ControlRealEntity> list) {
		return controlRealMapper.insertBatch(list);
	}
	}
