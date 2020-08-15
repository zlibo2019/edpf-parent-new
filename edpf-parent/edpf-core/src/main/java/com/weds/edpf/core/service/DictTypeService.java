package com.weds.edpf.core.service;

import com.weds.edpf.core.entity.DictTypeEntity;
import com.weds.edpf.core.mapper.DictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;

/**
 * @Author sxm
 * @Description 字典类型管理
 * @Date 2019-03-07
 */
@Service
public class DictTypeService extends BaseService {

	@Autowired
	private DictTypeMapper dictTypeMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String typeCode) {
		return dictTypeMapper.deleteByPrimaryKey(typeCode);
	}

	public int insert(DictTypeEntity record) {
		return dictTypeMapper.insert(record);
	}

	public int insertSelective(DictTypeEntity record) {
		return dictTypeMapper.insertSelective(record);
	}

	public DictTypeEntity selectByPrimaryKey(String typeCode) {
		return dictTypeMapper.selectByPrimaryKey(typeCode);
	}

	public int updateByPrimaryKeySelective(DictTypeEntity record) {
		return dictTypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DictTypeEntity record) {
		return dictTypeMapper.updateByPrimaryKey(record);
	}

	public List<DictTypeEntity> selectListByEntity(DictTypeEntity record) {
		return dictTypeMapper.selectListByEntity(record);
	}

	
	public List<DictTypeEntity> selectListByKeys(String keys) {
		return dictTypeMapper.selectListByKeys(keys);
	}

	public int deleteBatchByKeys(List<DictTypeEntity> list) {
		return dictTypeMapper.deleteBatchByKeys(list);
	}
}
