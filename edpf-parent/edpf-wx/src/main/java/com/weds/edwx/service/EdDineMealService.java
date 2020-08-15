package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .EdDineMealMapper;
import com.weds.edwx.entity .EdDineMealEntity;

/**
 * @Author sxm
 * @Description 餐别定义管理
 * @Date 2019-04-16
 */
@Service
public class EdDineMealService extends BaseService {

	@Autowired
	private EdDineMealMapper edDineMealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String mealId) {
		return edDineMealMapper.deleteByPrimaryKey(mealId);
	}

	public int insert(EdDineMealEntity record) {
		return edDineMealMapper.insert(record);
	}

	public int insertSelective(EdDineMealEntity record) {
		return edDineMealMapper.insertSelective(record);
	}

	public EdDineMealEntity selectByPrimaryKey(String mealId) {
		return edDineMealMapper.selectByPrimaryKey(mealId);
	}

	public int updateByPrimaryKeySelective(EdDineMealEntity record) {
		return edDineMealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(EdDineMealEntity record) {
		return edDineMealMapper.updateByPrimaryKey(record);
	}

    	public List<EdDineMealEntity> selectListByEntity(EdDineMealEntity record) {
		return edDineMealMapper.selectListByEntity(record);
	}
	
	
    	public List<EdDineMealEntity> selectListByKeys(String keys) {
		return edDineMealMapper.selectListByKeys(keys);
	}
	
    	public int deleteBatchByKeys(List<EdDineMealEntity> list) {
		return edDineMealMapper.deleteBatchByKeys(list);
	}
	}
