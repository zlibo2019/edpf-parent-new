package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .MjLogRealMapper;
import com.weds.edmj.entity .MjLogRealEntity;

/**
 * @Author sxm
 * @Description MjLogReal管理
 * @Date 2019-08-01
 */
@Service
public class MjLogRealService extends BaseService {

	@Autowired
	private MjLogRealMapper mjLogRealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return mjLogRealMapper.deleteByPrimaryKey(xh);
	}

	public int insert(MjLogRealEntity record) {
		return mjLogRealMapper.insert(record);
	}

	public int insertSelective(MjLogRealEntity record) {
		return mjLogRealMapper.insertSelective(record);
	}

	public MjLogRealEntity selectByPrimaryKey(Integer xh) {
		return mjLogRealMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(MjLogRealEntity record) {
		return mjLogRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MjLogRealEntity record) {
		return mjLogRealMapper.updateByPrimaryKey(record);
	}

    	public List<MjLogRealEntity> selectListByEntity(MjLogRealEntity record) {
		return mjLogRealMapper.selectListByEntity(record);
	}
	
	
    	public List<MjLogRealEntity> selectListByKeys(String keys) {
		return mjLogRealMapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<MjLogRealEntity> list) {
        return mjLogRealMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<MjLogRealEntity> list) {
		return mjLogRealMapper.insertBatch(list);
	}
	}
