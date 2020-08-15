package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .JrealNowcmdMapper;
import com.weds.edmj.entity .JrealNowcmdEntity;

/**
 * @Author sxm
 * @Description JrealNowcmd管理
 * @Date 2019-07-31
 */
@Service
public class JrealNowcmdService extends BaseService {

	@Autowired
	private JrealNowcmdMapper jrealNowcmdMapper;

	private Logger log = LogManager.getLogger();


	public int insert(JrealNowcmdEntity record) {
		return jrealNowcmdMapper.insert(record);
	}

	public int doorOperator(JrealNowcmdEntity record){
		if(record.getOperateLx()==4){//远程开门
			record.setTimeSec(5);
			jrealNowcmdMapper.insertMjDoorOperateBatch(record);
			jrealNowcmdMapper.insertKqDoorOperateBatch(record);
		}else { //其他操作类型 只有门禁有
			record.setTimeSec(0);
			jrealNowcmdMapper.insertMjDoorOperateBatch(record);
		}
		return 1;
	}

	public Map<String,Integer> selectForceCount(JrealNowcmdEntity record){
		//查出强制常开门数
		record.setTimeSec(1);
		int forceOpen = jrealNowcmdMapper.selectForceCount(record);
		//查出强制常闭门数
		record.setTimeSec(2);
		int forceClose = jrealNowcmdMapper.selectForceCount(record);

		Map<String,Integer> forceMap = new HashMap<>();
		forceMap.put("forceOpen",forceOpen);
		forceMap.put("forceClose",forceClose);
		return forceMap;
	}

	public int insertSelective(JrealNowcmdEntity record) {
		return jrealNowcmdMapper.insertSelective(record);
	}
	public List<JrealNowcmdEntity> selectListByKeys(String keys) {
		return jrealNowcmdMapper.selectListByKeys(keys);
	}
    
	public int insertBatch(List<JrealNowcmdEntity> list) {
		return jrealNowcmdMapper.insertBatch(list);
	}
	}
