package com.weds.edmj.service;

import com.weds.bean.jwt.JwtUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edmj.entity.*;
import com.weds.edmj.mapper.GateLevelRealMapper;
import com.weds.edmj.mapper.JrealUpdate0Mapper;
import com.weds.edmj.mapper.MjLogRealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper .MjUserRuleRealMapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description 门授权定义表管理
 * @Date 2019-07-30
 */
@Service
public class MjUserRuleRealService extends BaseService {

	@Autowired
	private MjUserRuleRealMapper mjUserRuleRealMapper;

	@Autowired
	private JrealUpdate0Mapper jrealUpdate0Mapper;

	@Autowired
	private MjLogRealMapper mjLogRealMapper;

	@Autowired
    private GateLevelRealMapper gateLevelRealMapper;

	@Autowired
	private ScmParams scmParams;

	@Autowired
	private HttpServletRequest request;

	private Logger log = LogManager.getLogger();

	public int deleteByPrimaryKey(MjUserRuleRealEntity record) {
	    // 查出要删除的基本信息
	    MjUserRuleRealEntity mjUserRuleRealEntity = mjUserRuleRealMapper.selectUserRuleInfo(record.getXh());
	    if(mjUserRuleRealEntity==null){
	        return 0;
        }
        mjUserRuleRealMapper.deleteByPrimaryKey(record.getXh());
        MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
        mjLogRealEntity.setLx(2);
        mjLogRealEntity.setLogType(3);
        mjLogRealEntity.setLogState(0);
        mjLogRealEntity.setLogBz("");
        mjLogRealEntity.setLogSj(new Date());
        mjLogRealEntity.setLogIp(request.getRemoteAddr());
        mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
        mjLogRealMapper.insertSelective(mjLogRealEntity);
        if(StringUtils.isBlank(mjUserRuleRealEntity.getDevSerial())) {//无绑定设备，则无须下发增量
            return 1;
        }
        //查询是否有公共授权
        GateLevelRealEntity dep = gateLevelRealMapper.selectDepByGateUser(record);
        GateLevelRealEntity gatePublic = gateLevelRealMapper.selectPublicByGateUser(record);
        //没有公共权限时
        if(dep==null && gatePublic==null){
            JrealUpdate0Entity jrealUpdate0Entity = new JrealUpdate0Entity();
            jrealUpdate0Entity.setJdevBh(mjUserRuleRealEntity.getDevSerial());
            //判断是门控器还是考勤机
            if(mjUserRuleRealEntity.getDevOrder()!=9){
                jrealUpdate0Entity.setJdataStr("101,3,0,"
                        +mjUserRuleRealEntity.getUserCard()+","+mjUserRuleRealEntity.getRuleNo()
                        +","+mjUserRuleRealEntity.getDevOrder()+","+mjUserRuleRealEntity.getFx());
            }else {
                if(mjUserRuleRealEntity.getFx()==0){
                    jrealUpdate0Entity.setJdodata(0);
                    jrealUpdate0Entity.setJuserId(0);
                    jrealUpdate0Entity.setJdataStr("1,3,"+mjUserRuleRealEntity.getUserSerial());
                }
            }
            jrealUpdate0Mapper.insertSelective1(jrealUpdate0Entity);
            return 1;
        }
        //有公共权限时
        if(dep!=null){
            mjUserRuleRealEntity.setRuleNo(dep.getRuleNo());
        }
        if(gatePublic!=null){
            mjUserRuleRealEntity.setRuleNo(gatePublic.getRuleNo());
        }
        //判断是门控器还是考勤机
        if(mjUserRuleRealEntity.getDevOrder()!=9){
            jrealUpdate0Mapper.insertUpdate1Mj(mjUserRuleRealEntity);
        }else {
            if(mjUserRuleRealEntity.getFx()==0){
                jrealUpdate0Mapper.insertUpdate1Kq(mjUserRuleRealEntity);
            }
        }
		return 1;
	}

	public int deleteByGateBh(String gateBh){
		return mjUserRuleRealMapper.deleteByGateBh(gateBh);
	}

	public int insert(MjUserRuleRealEntity record) {
		return mjUserRuleRealMapper.insert(record);
	}

	public int insertSelective(MjUserRuleRealEntity record) {
		//先判断进出规则是否为0
		if(record.getInRule()==0 && record.getOutRule()==0){
			return 0;
		}
		//先删除之前重复的授权
		mjUserRuleRealMapper.deleteByUserGate(record);
		int userCount  = record.getUserList().size();
		//先判断方向授权规则是否一致
		if(record.getInRule() == record.getOutRule()){
			record.setFx(3);
			record.setRuleNo(record.getInRule());
			//插入授权表
			mjUserRuleRealMapper.insertByUserGate(record);
			if(userCount<=scmParams.getMaxNum()){
				//插入增量日志
				jrealUpdate0Mapper.insertUpdate1MjIncrementBath(record);
				jrealUpdate0Mapper.insertUpdate1KqIncrementBath(record);
			}

		}else{
			if(record.getInRule()!=0){
				record.setFx(0);
				record.setRuleNo(record.getInRule());
				mjUserRuleRealMapper.insertByUserGate(record);
				if(userCount<=scmParams.getMaxNum()){
					//插入增量日志
					jrealUpdate0Mapper.insertUpdate1MjIncrementBath(record);
					jrealUpdate0Mapper.insertUpdate1KqIncrementBath(record);
				}
			}
			if(record.getOutRule()!=0){
				record.setFx(1);
				record.setRuleNo(record.getOutRule());
				mjUserRuleRealMapper.insertByUserGate(record);
				if(userCount<=scmParams.getMaxNum()){
					//插入增量日志
					jrealUpdate0Mapper.insertUpdate1MjIncrementBath(record);
				}
			}
		}
		if(userCount>scmParams.getMaxNum()) {
			//插入全量
			jrealUpdate0Mapper.insertUpdate0FullBath(record);
			jrealUpdate0Mapper.insertUpdate1FullBath(record);
		}
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(3);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("授权");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);
		return 1;
	}

	/**
	 * 复制门权限
	 * @param record
	 * @return
	 */
	public int copyGate(MjUserRuleRealEntity record){
		//先查出来此次复制门有多少人的授权，超过1000人的话，再下发全量
		//删除目标门原来的授权
		mjUserRuleRealMapper.deleteByUserGate(record);
		record.setSj(new Date());
		record.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//将源门的权限复制给目标门
		mjUserRuleRealMapper.insertRulesCopyDoor(record);
		//给目标门进行全量的下发操作
		jrealUpdate0Mapper.insertUpdate0FullBath(record);
		jrealUpdate0Mapper.insertUpdate1FullBath(record);
		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(3);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("复制门权限");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);
		return 1;
	}

	/**
	 * 复制人权限
	 * @param record
	 * @return
	 */
	public int copyUser(MjUserRuleRealEntity record){
		//取出目标人员原来的规则
		List<MjUserRuleRealEntity> oldRuleList = mjUserRuleRealMapper.selectUserRules(record);
		//删除目标人员原来的规则并下发增量
		for (int i = 0; i < oldRuleList.size(); i++) {
			MjUserRuleRealEntity mjUserRuleRealEntity = oldRuleList.get(i);//做循环删除操作
			deleteByPrimaryKey(mjUserRuleRealEntity);
		}
		record.setSj(new Date());
		record.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//将源人员的授权规则 赋值 给 目标人员原来的规则
		mjUserRuleRealMapper.insertRulesCopyUser(record);
		//对新授权做下发增量处理
		jrealUpdate0Mapper.insertUpdate1MjIncrementCopyUser(record);
		jrealUpdate0Mapper.insertUpdate1KqIncrementCopyUser(record);

		MjLogRealEntity mjLogRealEntity = new MjLogRealEntity();
		mjLogRealEntity.setLx(0);
		mjLogRealEntity.setLogType(3);
		mjLogRealEntity.setLogState(0);
		mjLogRealEntity.setLogBz("复制人权限");
		mjLogRealEntity.setLogSj(new Date());
		mjLogRealEntity.setLogIp(request.getRemoteAddr());
		mjLogRealEntity.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));
		//插入系统操作日志
		mjLogRealMapper.insertSelective(mjLogRealEntity);

		return 1;
	}
	public MjUserRuleRealEntity selectByPrimaryKey(Integer xh) {
		return mjUserRuleRealMapper.selectByPrimaryKey(xh);
	}

	public int updateByPrimaryKeySelective(MjUserRuleRealEntity record) {
		return mjUserRuleRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MjUserRuleRealEntity record) {
		return mjUserRuleRealMapper.updateByPrimaryKey(record);
	}

    	public List<MjUserRuleRealEntity> selectListByEntity(MjUserRuleRealEntity record) {
		return mjUserRuleRealMapper.selectListByEntity(record);
	}
	
	
    	public List<MjUserRuleRealEntity> selectListByKeys(String keys) {
		return mjUserRuleRealMapper.selectListByKeys(keys);
	}
	
        public int deleteBatchByKeys(List<MjUserRuleRealEntity> list) {
        return mjUserRuleRealMapper.deleteBatchByKeys(list);
    }
	public int deleteBatchByGateBh(List<DoorRealEntity> list) {
		return mjUserRuleRealMapper.deleteBatchByGateBh(list);
	}
    
    	public int insertBatch(List<MjUserRuleRealEntity> list) {
		return mjUserRuleRealMapper.insertBatch(list);
	}
	}
