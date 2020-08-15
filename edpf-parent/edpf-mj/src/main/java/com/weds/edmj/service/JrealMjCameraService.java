package com.weds.edmj.service;

import com.weds.bean.jwt.JwtUtils;
import com.weds.edmj.entity.DoorRealEntity;
import com.weds.edmj.entity.JrealNowcmdEntity;
import com.weds.edmj.entity.MjLogRealEntity;
import com.weds.edmj.mapper.JrealNowcmdMapper;
import com.weds.edmj.mapper.MjLogRealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .JrealMjCameraMapper;
import com.weds.edmj.entity .JrealMjCameraEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description JrealMjCamera管理
 * @Date 2019-07-31
 */
@Service
public class JrealMjCameraService extends BaseService {

	@Autowired
	private JrealMjCameraMapper jrealMjCameraMapper;

	@Autowired
	private MjLogRealMapper mjLogRealMapper;

	@Autowired
	private JrealNowcmdMapper jrealNowcmdMapper;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private DoorRealService doorRealService;




	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer jid) {
		//查出摄像头信息
		JrealMjCameraEntity jrealMjCameraEntity = jrealMjCameraMapper.selectByPrimaryKey(jid);
		//删除绑定的摄像头
		jrealMjCameraMapper.deleteByPrimaryKey(jid);
		//更新摄像头列表
		insertNowCmdNetCam();
		//插入日志
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(2);
		mjLogRealEntity.setLogType(17);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz(jrealMjCameraEntity.getGateBh()+":"+jrealMjCameraEntity.getJcamIp());
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		return mjLogRealMapper.insertSelective(mjLogRealEntity);
	}
	public int deleteByGatebh(String gateBh){
		return jrealMjCameraMapper.deleteByGatebh(gateBh);
	}

	public int insert(JrealMjCameraEntity record) {
		return jrealMjCameraMapper.insert(record);
	}

	public int insertSelective(JrealMjCameraEntity record) {
		DoorRealEntity doorRealEntity = doorRealService.selectByPrimaryKey(record.getGateBh());
		if(record.getJdoorFx()==3){
			jrealMjCameraMapper.deleteByGatebh(record.getGateBh());
		}else{
			List<Integer> fxList = new ArrayList<>();
			fxList.add(3);
			fxList.add(record.getJdoorFx());
			record.setFxList(fxList);
			jrealMjCameraMapper.deleteByGatebhAndFx(record);
		}
		jrealMjCameraMapper.insertSelective(record);
		//更新摄像头列表
		insertNowCmdNetCam();
		//插入日志
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(17);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz(doorRealEntity.getBh()+":"+doorRealEntity.getDoorName()+":"+record.getJcamIp());
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		return mjLogRealMapper.insertSelective(mjLogRealEntity);
	}

	public void insertNowCmdNetCam(){
		JrealNowcmdEntity jrealNowcmdEntity = new JrealNowcmdEntity();
		jrealNowcmdEntity.setJtype(2);
		jrealNowcmdEntity.setJint(1);
		jrealNowcmdEntity.setJstr("netcam");
		jrealNowcmdMapper.insertSelective(jrealNowcmdEntity);
	}

	public JrealMjCameraEntity selectByPrimaryKey(Integer jid) {
		return jrealMjCameraMapper.selectByPrimaryKey(jid);
	}

	public int updateByPrimaryKeySelective(JrealMjCameraEntity record) {
		return jrealMjCameraMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(JrealMjCameraEntity record) {
		return jrealMjCameraMapper.updateByPrimaryKey(record);
	}

    	public List<JrealMjCameraEntity> selectListByEntity(JrealMjCameraEntity record) {
		return jrealMjCameraMapper.selectListByEntity(record);
	}
        public int deleteBatchByKeys(List<JrealMjCameraEntity> list) {
        return jrealMjCameraMapper.deleteBatchByKeys(list);
    }

	public int deleteBatchByGatebh(List<DoorRealEntity> list) {
		return jrealMjCameraMapper.deleteBatchByGatebh(list);
	}
    
    	public int insertBatch(List<JrealMjCameraEntity> list) {
		return jrealMjCameraMapper.insertBatch(list);
	}
	}
