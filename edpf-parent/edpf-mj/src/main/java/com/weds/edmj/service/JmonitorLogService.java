package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .JmonitorLogMapper;
import com.weds.edmj.entity .JmonitorLogEntity;

/**
 * @Author sxm
 * @Description JmonitorLog管理
 * @Date 2019-08-14
 */
@Service
public class JmonitorLogService extends BaseService {

	@Autowired
	private JmonitorLogMapper jmonitorLogMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer jid) {
		return jmonitorLogMapper.deleteByPrimaryKey(jid);
	}

	public int insert(JmonitorLogEntity record) {
		return jmonitorLogMapper.insert(record);
	}

	public int insertSelective(JmonitorLogEntity record) {
		return jmonitorLogMapper.insertSelective(record);
	}

	public JmonitorLogEntity selectByPrimaryKey(Integer jid) {
		return jmonitorLogMapper.selectByPrimaryKey(jid);
	}

	public int updateByPrimaryKeySelective(JmonitorLogEntity record) {
		return jmonitorLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(JmonitorLogEntity record) {
		return jmonitorLogMapper.updateByPrimaryKey(record);
	}

    	public List<JmonitorLogEntity> selectListByEntity(JmonitorLogEntity record) {
		return jmonitorLogMapper.selectListByEntity(record);
	}
	
	

        public int deleteBatchByKeys(List<JmonitorLogEntity> list) {
        return jmonitorLogMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<JmonitorLogEntity> list) {
		return jmonitorLogMapper.insertBatch(list);
	}
	}
