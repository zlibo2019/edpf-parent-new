package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .WtMobileLogMapper;
import com.weds.edmj.entity .WtMobileLogEntity;

/**
 * @Author sxm
 * @Description 手机门禁日志管理
 * @Date 2019-08-08
 */
@Service
public class WtMobileLogService extends BaseService {

	@Autowired
	private WtMobileLogMapper wtMobileLogMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return wtMobileLogMapper.deleteByPrimaryKey(xh);
	}

	public int insert(WtMobileLogEntity record) {
		return wtMobileLogMapper.insert(record);
	}

	public int insertSelective(WtMobileLogEntity record) {
		return wtMobileLogMapper.insertSelective(record);
	}

	public WtMobileLogEntity selectByPrimaryKey(Integer xh) {
		return wtMobileLogMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(WtMobileLogEntity record) {
		return wtMobileLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(WtMobileLogEntity record) {
		return wtMobileLogMapper.updateByPrimaryKey(record);
	}

    	public List<WtMobileLogEntity> selectListByEntity(WtMobileLogEntity record) {
		return wtMobileLogMapper.selectListByEntity(record);
	}
	
	

        public int deleteBatchByKeys(List<WtMobileLogEntity> list) {
        return wtMobileLogMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<WtMobileLogEntity> list) {
		return wtMobileLogMapper.insertBatch(list);
	}
	}
