package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .TtNationMapper;
import com.weds.edwx.entity .TtNationEntity;

/**
 * @Author sxm
 * @Description TtNation管理
 * @Date 2019-04-19
 */
@Service
public class TtNationService extends BaseService {

	@Autowired
	private TtNationMapper ttNationMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Short ttOrder) {
		return ttNationMapper.deleteByPrimaryKey(ttOrder);
	}

	public int insert(TtNationEntity record) {
		return ttNationMapper.insert(record);
	}

	public int insertSelective(TtNationEntity record) {
		return ttNationMapper.insertSelective(record);
	}

	public TtNationEntity selectByPrimaryKey(Short ttOrder) {
		return ttNationMapper.selectByPrimaryKey(ttOrder);
	}

	public int updateByPrimaryKeySelective(TtNationEntity record) {
		return ttNationMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TtNationEntity record) {
		return ttNationMapper.updateByPrimaryKey(record);
	}

    	public List<TtNationEntity> selectListByEntity(TtNationEntity record) {
		return ttNationMapper.selectListByEntity(record);
	}
	
	
    	public List<TtNationEntity> selectListByKeys(String keys) {
		return ttNationMapper.selectListByKeys(keys);
	}
	
    	public int deleteBatchByKeys(List<TtNationEntity> list) {
		return ttNationMapper.deleteBatchByKeys(list);
	}
	}
