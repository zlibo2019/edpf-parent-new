package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .WtMjLogRealMapper;
import com.weds.edmj.entity .WtMjLogRealEntity;

/**
 * @Author sxm
 * @Description 门禁管理的基本日志管理
 * @Date 2019-08-08
 */
@Service
public class WtMjLogRealService extends BaseService {

	@Autowired
	private WtMjLogRealMapper wtMjLogRealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return wtMjLogRealMapper.deleteByPrimaryKey(xh);
	}

	public int insert(WtMjLogRealEntity record) {
		return wtMjLogRealMapper.insert(record);
	}

	public int insertSelective(WtMjLogRealEntity record) {
		return wtMjLogRealMapper.insertSelective(record);
	}

	public WtMjLogRealEntity selectByPrimaryKey(Integer xh) {
		return wtMjLogRealMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(WtMjLogRealEntity record) {
		return wtMjLogRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(WtMjLogRealEntity record) {
		return wtMjLogRealMapper.updateByPrimaryKey(record);
	}

    	public List<WtMjLogRealEntity> selectListByEntity(WtMjLogRealEntity record) {
		return wtMjLogRealMapper.selectListByEntity(record);
	}
	
	

        public int deleteBatchByKeys(List<WtMjLogRealEntity> list) {
        return wtMjLogRealMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<WtMjLogRealEntity> list) {
		return wtMjLogRealMapper.insertBatch(list);
	}
	}
