package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .FkLogMapper;
import com.weds.edwx.entity .FkLogEntity;

/**
 * @Author sxm
 * @Description FkLog管理
 * @Date 2019-03-22
 */
@Service
public class FkLogService extends BaseService {

	@Autowired
	private FkLogMapper fkLogMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return fkLogMapper.deleteByPrimaryKey(xh);
	}

	public int insert(FkLogEntity record) {
		return fkLogMapper.insert(record);
	}

	public int insertSelective(FkLogEntity record) {
		return fkLogMapper.insertSelective(record);
	}

	public FkLogEntity selectByPrimaryKey(Integer xh) {
		return fkLogMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(FkLogEntity record) {
		return fkLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(FkLogEntity record) {
		return fkLogMapper.updateByPrimaryKey(record);
	}

    	public List<FkLogEntity> selectListByEntity(FkLogEntity record) {
		return fkLogMapper.selectListByEntity(record);
	}
	
	
    
    }
