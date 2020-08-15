package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .DeviceMapper;
import com.weds.edwx.entity .DeviceEntity;

/**
 * @Author sxm
 * @Description Device管理
 * @Date 2018-12-28
 */
@Service
public class DeviceService extends BaseService {

	@Autowired
	private DeviceMapper deviceMapper;

	private Logger log = LogManager.getLogger();

	/**
	 * 根据dev sid 查询设备是否存在
	 * @param devSid
	 * @return
	 */
	public DeviceEntity selectByDevsbid(String devSid){
		return deviceMapper.selectByDevsbid(devSid);
	}


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

	public List<DeviceEntity> selectListByEntity(DeviceEntity record) {
		return deviceMapper.selectListByEntity(record);
	}

	}
