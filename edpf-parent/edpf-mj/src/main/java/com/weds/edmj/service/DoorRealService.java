package com.weds.edmj.service;

import com.weds.bean.jwt.JwtUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edmj.entity.*;
import com.weds.edmj.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description DoorReal管理
 * @Date 2019-07-29
 */
@Service
public class DoorRealService extends BaseService {

	@Autowired
	private DoorRealMapper doorRealMapper;

	@Autowired
	private DoorfxRealMapper doorfxRealMapper;

	@Autowired
	private WtMjVerMapper wtMjVerMapper;

	@Autowired
	private JrealUpdate0Mapper jrealUpdate0Mapper;

	@Autowired
	private JrealNowcmdMapper jrealNowcmdMapper;

	@Autowired
	private HttpServletRequest request;

	private Logger log = LogManager.getLogger();



	public int deleteByPrimaryKey(String bh) {
		return doorRealMapper.deleteByPrimaryKey(bh);
	}

	public int insert(DoorRealEntity record) {
		return doorRealMapper.insert(record);
	}

	public int insertSelective(DoorRealEntity record) {
		return doorRealMapper.insertSelective(record);
	}

	public int selectCountByEntity(DoorRealEntity record){
		return doorRealMapper.selectCountByEntity(record);
	}

	public int insertDepDoorRelation(DoorRealEntity record){
		return doorRealMapper.insertDepDoorRelation(record);
	}

	//获取门编号的方式
	public String getDoorBh(){
		String gateBh = System.currentTimeMillis()+""+((int)(Math.random()*900)+100);
		DoorRealEntity newDoor = new DoorRealEntity();
		newDoor.setBh(gateBh);
		while (doorRealMapper.selectCountByEntity(newDoor)>0){
			gateBh = System.currentTimeMillis()+""+((int)(Math.random()*900)+100);
			newDoor.setBh(gateBh);
		}
		return newDoor.getBh();
	}
	//新增时插入门方向定义表
	public void insertDoorfxInfo(DoorRealEntity record){
		DoorfxRealEntity doorFxIn = new DoorfxRealEntity();
		DoorfxRealEntity doorFxOut = new DoorfxRealEntity();

		doorFxIn.setDevSerial(record.getDevSerial());
		doorFxIn.setDevOrder(record.getDevOrder());
		doorFxIn.setGateBh(record.getBh());
		doorFxIn.setFx(0);
		doorFxIn.setcFirst(0);
		doorFxIn.setMjgzSk(0);
		doorFxIn.setSj(new Date());

		doorFxOut.setDevSerial(record.getDevSerial());
		doorFxOut.setDevOrder(record.getDevOrder());
		doorFxOut.setGateBh(record.getBh());
		doorFxOut.setFx(1);
		doorFxOut.setcFirst(0);
		doorFxOut.setMjgzSk(0);
		doorFxOut.setSj(new Date());

		if(record.getDevOrder()==9){ //考勤门禁一体机
			doorFxIn.setDevHead(0);
			doorFxIn.setDevHead2(1);
			doorFxIn.setcType(0);
			doorFxOut.setDevHead(0);
			doorFxOut.setDevHead2(1);
			doorFxOut.setcType(0);
		}else{ //门控器
			//判断门控器是单控还是双控
			if(doorRealMapper.selectDcardCountByEntity(record)==2){
				doorFxIn.setDevHead(1);
				doorFxIn.setDevHead2(0);
				doorFxIn.setcType(record.getCTypeIn());
				doorFxOut.setDevHead(0);
				doorFxOut.setDevHead2(2);
				doorFxOut.setcType(record.getCTypeOut());
			}else{
				doorFxIn.setDevHead(1);
				doorFxIn.setDevHead2(0);
				doorFxIn.setcType(record.getCTypeIn());
				doorFxOut.setDevHead(0);
				doorFxOut.setDevHead2(0);
				doorFxOut.setcType(record.getCTypeOut());
			}
		}
		doorfxRealMapper.insertSelective(doorFxIn); //插入门方向表 进
		doorfxRealMapper.insertSelective(doorFxOut);//插入门方向表 出
		if(record.getDevOrder()!=9){
			//插入门禁配置增量日志
			insertWtMjVer(record);
		}
	}

	//新增时插入门定义表
	public void insertDoorInfo(DoorRealEntity record){
		record.setBh(getDoorBh());
		record.setSj(new Date());
		record.setFxFlg(0);
		record.setIsForcein(1);
		if(record.getDevOrder()==9){ //考勤门禁一体机
			record.setDoorLx(1);

		}else{ //门控器
			record.setDoorLx(0);
		}
		doorRealMapper.insertSelective(record);//插入门定义表
		doorRealMapper.insertDepDoorRelation(record);//插入场所和门方向表
	}
	//修改门方向定义表
	public void updateDoorFxInfo(DoorRealEntity record){
		DoorfxRealEntity doorfxIn = new DoorfxRealEntity();
		DoorfxRealEntity doorfxOut = new DoorfxRealEntity();
		doorfxIn.setcType(record.getCTypeIn());
		doorfxIn.setFx(0);
		doorfxIn.setGateBh(record.getBh());
		doorfxOut.setcType(record.getCTypeOut());
		doorfxOut.setFx(1);
		doorfxOut.setGateBh(record.getBh());
		doorfxRealMapper.updateByPrimaryKeySelective(doorfxIn);
		doorfxRealMapper.updateByPrimaryKeySelective(doorfxOut);
	}

	public void insertWtMjVer(DoorRealEntity record){
		//插入门禁增量日志
		WtMjVerEntity wtMjVerEntity1 = new WtMjVerEntity();
		wtMjVerEntity1.setGateBh(record.getBh());
		wtMjVerEntity1.setFx(0);
		wtMjVerEntity1.setType(0);
		wtMjVerEntity1.setLogLx(1);
		wtMjVerEntity1.setLx(5);
		wtMjVerEntity1.setLogSj(new Date());
		wtMjVerEntity1.setLogBz(record.getCTypeIn().toString());
		wtMjVerEntity1.setLogIp(request.getRemoteAddr());
		wtMjVerEntity1.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));

		wtMjVerMapper.insertSelective(wtMjVerEntity1);
		wtMjVerEntity1.setFx(1);
		wtMjVerEntity1.setLogBz(record.getCTypeOut().toString());
		wtMjVerMapper.insertSelective(wtMjVerEntity1);

		WtMjVerEntity wtMjVerEntity2 = new WtMjVerEntity();
		wtMjVerEntity2.setGateBh(record.getBh());
		wtMjVerEntity2.setType(0);
		wtMjVerEntity2.setLogLx(1);
		wtMjVerEntity2.setLx(6);
		wtMjVerEntity2.setLogSj(new Date());
		wtMjVerEntity2.setLogIp(request.getRemoteAddr());
		wtMjVerEntity2.setGlyNo(JwtUtils.getJwtData(request).getString("userSerial"));

		wtMjVerMapper.insertSelective(wtMjVerEntity2);
	}

	public void insertJrealUpdate(DoorRealEntity record,boolean all,boolean netcam){
		JrealUpdate0Entity jrealUpdate0Entity = new JrealUpdate0Entity();
		jrealUpdate0Entity.setJdevBh(record.getDevSerial());
		jrealUpdate0Entity.setJdodata(1073741824);
		jrealUpdate0Mapper.insertSelective0(jrealUpdate0Entity);
		jrealUpdate0Mapper.insertSelective1(jrealUpdate0Entity);
		if(all){
			jrealUpdate0Mapper.insertSelective2(jrealUpdate0Entity);
			jrealUpdate0Mapper.insertSelective3(jrealUpdate0Entity);
		}
		if(netcam){
			insertNowCmdNetCam();
		}
	}

	public void insertNowCmdNetCam(){
		JrealNowcmdEntity jrealNowcmdEntity = new JrealNowcmdEntity();
		jrealNowcmdEntity.setJtype(2);
		jrealNowcmdEntity.setJint(1);
		jrealNowcmdEntity.setJstr("netcam");
		jrealNowcmdMapper.insertSelective(jrealNowcmdEntity);
	}

	public int selectDevStateByEntity(DoorRealEntity record){
		return doorRealMapper.selectDevStateByEntity(record);
	}

	public int deleteDepDoorRelation(DoorRealEntity record){
		return doorRealMapper.deleteDepDoorRelation(record);
	}
	public DoorRealEntity selectByPrimaryKey(String gateBh) {
		DoorRealEntity doorRealEntity = doorRealMapper.selectByPrimaryKey(gateBh);
		if(doorRealEntity!=null && !StringUtils.isBlank(doorRealEntity.getDevSerial()) && doorRealEntity.getDevOrder()!=9){
			List<DoorfxRealEntity> doorfxRealEntityList = doorfxRealMapper.selectByPrimaryKey(gateBh);
			for(int i=0;i<doorfxRealEntityList.size();i++){
				DoorfxRealEntity realEntity = doorfxRealEntityList.get(i);
				if(realEntity.getFx()==0){
					doorRealEntity.setCTypeIn(realEntity.getcType());
				}
				if(realEntity.getFx()==1){
					doorRealEntity.setCTypeOut(realEntity.getcType());
				}
			}
		}
		return doorRealEntity;
	}

	public int updateByPrimaryKeySelective(DoorRealEntity record) {
		return doorRealMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DoorRealEntity record) {
		return doorRealMapper.updateByPrimaryKey(record);
	}
	public int updatePlaceByGate(DoorRealEntity record) {
	    return doorRealMapper.updatePlaceByGate(record);
    }

    	public List<DoorRealEntity> selectListByEntity(DoorRealEntity record) {
		return doorRealMapper.selectListByEntity(record);
	}
	
	public int deleteBatchByKeys(List<DoorRealEntity> list) {
        return doorRealMapper.deleteBatchByKeys(list);
    }
    
    public int insertBatch(List<DoorRealEntity> list) {
		return doorRealMapper.insertBatch(list);
	}
	public int deleteDepRelationBatchByKeys(List<DoorRealEntity> list){
		return doorRealMapper.deleteDepRelationBatchByKeys(list);
	}

	public List<DoorRealEntity> selectForceList(DoorRealEntity record){
		return doorRealMapper.selectForceList(record);
	}
}
