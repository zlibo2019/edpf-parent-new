package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .JrealUpdate0Mapper;
import com.weds.edmj.entity .JrealUpdate0Entity;

/**
 * @Author sxm
 * @Description JrealUpdate0管理
 * @Date 2019-07-31
 */
@Service
public class JrealUpdate0Service extends BaseService {

	@Autowired
	private JrealUpdate0Mapper jrealUpdate0Mapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer jsig) {
		return jrealUpdate0Mapper.deleteByPrimaryKey(jsig);
	}

	public int insert(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.insert(record);
	}

	public int insertSelective0(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.insertSelective0(record);
	}
	public int insertSelective1(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.insertSelective1(record);
	}
	public int insertSelective2(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.insertSelective3(record);
	}
	public int insertSelective3(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.insertSelective3(record);
	}

	public JrealUpdate0Entity selectByPrimaryKey(Integer jsig) {
		return jrealUpdate0Mapper.selectByPrimaryKey(jsig);
	}

	public int updateByPrimaryKeySelective(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.updateByPrimaryKey(record);
	}

    	public List<JrealUpdate0Entity> selectListByEntity(JrealUpdate0Entity record) {
		return jrealUpdate0Mapper.selectListByEntity(record);
	}
	
	
    	public List<JrealUpdate0Entity> selectListByKeys(String keys) {
		return jrealUpdate0Mapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<JrealUpdate0Entity> list) {
        return jrealUpdate0Mapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<JrealUpdate0Entity> list) {
		return jrealUpdate0Mapper.insertBatch(list);
	}
	}
