package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .VisDoorKeeperMapper;
import com.weds.edwx.entity .VisDoorKeeperEntity;

/**
 * @Author sxm
 * @Description 门卫用户管理管理
 * @Date 2019-04-17
 */
@Service
public class VisDoorKeeperService extends BaseService {

	@Autowired
	private VisDoorKeeperMapper visDoorKeeperMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String userNo) {
		return visDoorKeeperMapper.deleteByPrimaryKey(userNo);
	}

	public int insert(VisDoorKeeperEntity record) {
		return visDoorKeeperMapper.insert(record);
	}

	public int insertSelective(VisDoorKeeperEntity record) {
		return visDoorKeeperMapper.insertSelective(record);
	}

	public VisDoorKeeperEntity selectByPrimaryKey(String userNo) {
		return visDoorKeeperMapper.selectByPrimaryKey(userNo);
	}

	public int updateByPrimaryKeySelective(VisDoorKeeperEntity record) {
		return visDoorKeeperMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(VisDoorKeeperEntity record) {
		return visDoorKeeperMapper.updateByPrimaryKey(record);
	}

    	public List<VisDoorKeeperEntity> selectListByEntity(VisDoorKeeperEntity record) {
		return visDoorKeeperMapper.selectListByEntity(record);
	}
	
	
    	public List<VisDoorKeeperEntity> selectListByKeys(String keys) {
		return visDoorKeeperMapper.selectListByKeys(keys);
	}
	
    	public int deleteBatchByKeys(List<VisDoorKeeperEntity> list) {
		return visDoorKeeperMapper.deleteBatchByKeys(list);
	}
	}
