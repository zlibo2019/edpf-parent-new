package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .DeviceMonitorMapper;
import com.weds.edwx.entity .DeviceMonitorEntity;

/**
 * @Author sxm
 * @Description DeviceMonitor管理
 * @Date 2018-11-24
 */
@Service
public class DeviceMonitorService extends BaseService {

	@Autowired
	private DeviceMonitorMapper deviceMonitorMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return deviceMonitorMapper.deleteByPrimaryKey(xh);
	}

	public int insert(DeviceMonitorEntity record) {
		return deviceMonitorMapper.insert(record);
	}

	public int insertSelective(DeviceMonitorEntity record) {
		return deviceMonitorMapper.insertSelective(record);
	}

	public DeviceMonitorEntity selectByPrimaryKey(Integer xh) {
		return deviceMonitorMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(DeviceMonitorEntity record) {
		return deviceMonitorMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DeviceMonitorEntity record) {
		return deviceMonitorMapper.updateByPrimaryKey(record);
	}

	public List<DeviceMonitorEntity> selectListByEntity(DeviceMonitorEntity record) {
		return deviceMonitorMapper.selectListByEntity(record);
	}

	public int selectByRoomBh(Integer bh){
		return  deviceMonitorMapper.selectByRoomBh(bh);
	}

	}
