package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .DeviceMapper;
import com.weds.edmj.entity .DeviceEntity;

/**
 * @Author sxm
 * @Description Device管理
 * @Date 2019-07-31
 */
@Service
public class DeviceService extends BaseService {

	@Autowired
	private DeviceMapper deviceMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(String bh) {
		return deviceMapper.deleteByPrimaryKey(bh);
	}

	public int insert(DeviceEntity record) {
		return deviceMapper.insert(record);
	}

	public int insertSelective(DeviceEntity record) {
		return deviceMapper.insertSelective(record);
	}

	public DeviceEntity selectByPrimaryKey(String bh) {
		return deviceMapper.selectByPrimaryKey(bh);
	}

	public int updateByPrimaryKeySelective(DeviceEntity record) {
		return deviceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DeviceEntity record) {
		return deviceMapper.updateByPrimaryKey(record);
	}

	public List<DeviceEntity> selectControlList(DeviceEntity record) {
		return deviceMapper.selectControlList(record);
	}

	public List<DeviceEntity> selectKqList(DeviceEntity record){
		return deviceMapper.selectKqList(record);
	}
	
	
    	public List<DeviceEntity> selectListByKeys(String keys) {
		return deviceMapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<DeviceEntity> list) {
        return deviceMapper.deleteBatchByKeys(list);
    }
    
    	public int insertBatch(List<DeviceEntity> list) {
		return deviceMapper.insertBatch(list);
	}
	}
