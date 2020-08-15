package com.weds.edmj.service;

import com.weds.bean.jwt.JwtUtils;
import com.weds.edmj.entity.MjLogRealEntity;
import com.weds.edmj.entity.MjUserRuleRealEntity;
import com.weds.edmj.mapper.JrealUpdate0Mapper;
import com.weds.edmj.mapper.MjLogRealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .GateLevelRealMapper;
import com.weds.edmj.entity .GateLevelRealEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description GateLevelReal管理
 * @Date 2019-08-08
 */
@Service
public class GateLevelRealService extends BaseService {

	@Autowired
	private GateLevelRealMapper gateLevelRealMapper;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JrealUpdate0Mapper jrealUpdate0Mapper;

	@Autowired
	private MjLogRealMapper mjLogRealMapper;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(Integer xh) {
		return gateLevelRealMapper.deleteByPrimaryKey(xh);
	}

	public int insert(GateLevelRealEntity record) {
		return gateLevelRealMapper.insert(record);
	}

	public int insertSelective(GateLevelRealEntity record) {
		//删除传入门的所有授权
		gateLevelRealMapper.deleteByGateList(record);
		record.setFx(3);
		record.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		record.setSj(new Date());
		if(record.getLx()==0){ //公共权限
			gateLevelRealMapper.insertBatch(record);
		}else{
			gateLevelRealMapper.deleteByGateListAndDep(record);
			if(record.getLx()==1){
				//部门权限
				gateLevelRealMapper.insertDepBatch(record);
			}
			if(record.getLx()==2){
				//角色权限
				gateLevelRealMapper.insertRoleBatch(record);
			}
		}
		//插入全量日志
		MjUserRuleRealEntity mjUserRuleRealEntity = new MjUserRuleRealEntity();
		mjUserRuleRealEntity.setGateList(record.getGateList());
		jrealUpdate0Mapper.insertUpdate0FullBath(mjUserRuleRealEntity);
		jrealUpdate0Mapper.insertUpdate1FullBath(mjUserRuleRealEntity);
		//插入操作日志
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(3);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("扩展授权");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);

		return 1;
	}

	public GateLevelRealEntity selectByPrimaryKey(Integer xh) {
		return gateLevelRealMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(GateLevelRealEntity record) {
		return gateLevelRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(GateLevelRealEntity record) {
		return gateLevelRealMapper.updateByPrimaryKey(record);
	}

	public List<GateLevelRealEntity> selectListByEntity(GateLevelRealEntity record) {
		return gateLevelRealMapper.selectListByEntity(record);
	}

	public int selectOtherAuth(GateLevelRealEntity record){
		return gateLevelRealMapper.selectOtherAuth(record);
	}

	public int deleteBatchByKeys(List<GateLevelRealEntity> list) {
        return gateLevelRealMapper.deleteBatchByKeys(list);
    }
    public int insertFullUpdate0(List<GateLevelRealEntity> list){
		return gateLevelRealMapper.insertFullUpdate0(list);
	}
	public int insertFullUpdate1(List<GateLevelRealEntity> list){
		return gateLevelRealMapper.insertFullUpdate1(list);
	}
}
