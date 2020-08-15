package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .VisUserStateMapper;
import com.weds.edwx.entity .VisUserStateEntity;

/**
 * @Author sxm
 * @Description VisUserState管理
 * @Date 2019-03-20
 */
@Service
public class VisUserStateService extends BaseService {

	@Autowired
	private VisUserStateMapper visUserStateMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Long userSerial) {
		return visUserStateMapper.deleteByPrimaryKey(userSerial);
	}

	public int insert(VisUserStateEntity record) {
		return visUserStateMapper.insert(record);
	}

	public int insertSelective(VisUserStateEntity record) {
		return visUserStateMapper.insertSelective(record);
	}

	public VisUserStateEntity selectByPrimaryKey(Long userSerial) {
		return visUserStateMapper.selectByPrimaryKey(userSerial);
	}

	public int updateByPrimaryKeySelective(VisUserStateEntity record) {
		return visUserStateMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(VisUserStateEntity record) {
		return visUserStateMapper.updateByPrimaryKey(record);
	}

	public List<VisUserStateEntity> selectListByEntity(VisUserStateEntity record) {
		return visUserStateMapper.selectListByEntity(record);
	}

	
	public List<VisUserStateEntity> selectListByKeys(String keys) {
		return visUserStateMapper.selectListByKeys(keys);
	}

	public int deleteBatchByKeys(List<VisUserStateEntity> list) {
		return visUserStateMapper.deleteBatchByKeys(list);
	}
}
