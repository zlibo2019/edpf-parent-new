package com.weds.edmj.service;

import com.weds.bean.jwt.JwtUtils;
import com.weds.edmj.entity.MjLogRealEntity;
import com.weds.edmj.mapper.MjLogRealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .RightTempMapper;
import com.weds.edmj.entity .RightTempEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description RightTemp管理
 * @Date 2019-08-13
 */
@Service
public class RightTempService extends BaseService {

	@Autowired
	private RightTempMapper rightTempMapper;

	@Autowired
	private MjLogRealMapper mjLogRealMapper;

	@Autowired
	private HttpServletRequest request;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return rightTempMapper.deleteByPrimaryKey(xh);
	}

	public int insertSelective(RightTempEntity record) {
		record.setFx(3);
		record.setSj(new Date());
		record.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//批量插入临时授权
		rightTempMapper.insertBatch(record);
		//批量插入授权增量
		rightTempMapper.insertUpdate1MjBatch(record);
		rightTempMapper.insertUpdate4KqBatch(record);
		//插入操作日志
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(20);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("新增临时授权");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);
		return 1;
	}
	public List<RightTempEntity> selectListByEntity(RightTempEntity record) {
		return rightTempMapper.selectListByEntity(record);
	}
	public int deleteBatchByKeys(List<RightTempEntity> list) {
		//下发增量
		rightTempMapper.insertUpdateDelMjBatch(list);
		rightTempMapper.insertUpdateDelKqBatch(list);
		//删除
		rightTempMapper.deleteBatchByKeys(list);
		//插入操作日志
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(2);
		mjLogRealEntity.setLogType(20);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("删除临时授权");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);
        return 1;
    }
}
