package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .TtSexMapper;
import com.weds.edwx.entity .TtSexEntity;

/**
 * @Author sxm
 * @Description TtSex管理
 * @Date 2019-04-19
 */
@Service
public class TtSexService extends BaseService {

	@Autowired
	private TtSexMapper ttSexMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Short ttOrder) {
		return ttSexMapper.deleteByPrimaryKey(ttOrder);
	}

	public int insert(TtSexEntity record) {
		return ttSexMapper.insert(record);
	}

	public int insertSelective(TtSexEntity record) {
		return ttSexMapper.insertSelective(record);
	}

	public TtSexEntity selectByPrimaryKey(Short ttOrder) {
		return ttSexMapper.selectByPrimaryKey(ttOrder);
	}

	public int updateByPrimaryKeySelective(TtSexEntity record) {
		return ttSexMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TtSexEntity record) {
		return ttSexMapper.updateByPrimaryKey(record);
	}

    	public List<TtSexEntity> selectListByEntity(TtSexEntity record) {
		return ttSexMapper.selectListByEntity(record);
	}
	
	
    	public List<TtSexEntity> selectListByKeys(String keys) {
		return ttSexMapper.selectListByKeys(keys);
	}
	
    	public int deleteBatchByKeys(List<TtSexEntity> list) {
		return ttSexMapper.deleteBatchByKeys(list);
	}
	}
