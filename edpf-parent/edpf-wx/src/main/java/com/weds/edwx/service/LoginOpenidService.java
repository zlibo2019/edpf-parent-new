package com.weds.edwx .service;

import com.weds.edwx.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .LoginOpenidMapper;
import com.weds.edwx.entity .LoginOpenidEntity;

/**
 * @Author sxm
 * @Description LoginOpenid管理
 * @Date 2018-11-26
 */
@Service
public class LoginOpenidService extends BaseService {

	@Autowired
	private LoginOpenidMapper loginOpenidMapper;

	private Logger log = LogManager.getLogger();

	public List<LoginOpenidEntity> selectListByEntity(LoginOpenidEntity record){
		return loginOpenidMapper.selectListByEntity(record);
	}

	/**
	 * 查询该员工序号是否被绑定
	 * @param userEntity
	 * @return
	 */
	public LoginOpenidEntity checkBindState(UserEntity userEntity){
		return loginOpenidMapper.checkBindState(userEntity);
	}

	/**
	 * 插入user_serial 和 openid的绑定关系
	 * @param userEntity
	 * @return
	 */
	public int insertBindRelation(UserEntity userEntity){
		if(userEntity.getUnionId() == null || "".equals(userEntity.getUnionId())){ //uniondId不存在
			return loginOpenidMapper.insertBindRelation(userEntity); //直接插入
		}
		LoginOpenidEntity loginOpenidEntity = loginOpenidMapper.getBindUserByUnionId(userEntity);
		if(loginOpenidEntity == null) { //不存在 unionid的记录，则插入
			return loginOpenidMapper.insertBindRelation(userEntity); //直接插入
		}
		return loginOpenidMapper.updateUserInfoByUnionId(userEntity); //更新
	}

	/**
	 * 根据unionId 修改 openId信息
	 * @param userEntity
	 * @return
	 */
	public int updateOpenIdByUnionId(UserEntity userEntity){
		return loginOpenidMapper.updateOpenIdByUnionId(userEntity); //更新
	}

	public int insertAppletBindRelation(UserEntity userEntity){
		return loginOpenidMapper.insertBindRelation(userEntity);
	}

	/**
	 * 查询openid是否绑定员工序号
	 * @param openId
	 * @return
	 */
	public LoginOpenidEntity selectByOpendId(String openId){
		return loginOpenidMapper.selectByOpendId(openId);
	}

	/**
	 * 查询user_serial 和 openid的绑定关系是否存在
	 * @param userEntity
	 * @return
	 */
	public LoginOpenidEntity selectBindStatus(UserEntity userEntity){
		return loginOpenidMapper.selectBindStatus(userEntity);
	}

	public int deleteBindStatus(UserEntity userEntity){
		return loginOpenidMapper.deleteBindStatus(userEntity);
	}

	/**
	 * 修改消息发送状态
	 * @param record
	 * @return
	 */
	public int updateSendState(LoginOpenidEntity record) {
		return loginOpenidMapper.updateSendState(record);
	}

	public LoginOpenidEntity selectSendState(LoginOpenidEntity record){
		return loginOpenidMapper.selectSendState(record);
	}


	/*public int deleteByPrimaryKey() {
		return loginOpenidMapper.deleteByPrimaryKey();
	}

	public int insert(LoginOpenidEntity record) {
		return loginOpenidMapper.insert(record);
	}

	public int insertSelective(LoginOpenidEntity record) {
		return loginOpenidMapper.insertSelective(record);
	}

	public LoginOpenidEntity selectByPrimaryKey() {
		return loginOpenidMapper.selectByPrimaryKey();
	}

	public int updateByPrimaryKeySelective(LoginOpenidEntity record) {
		return loginOpenidMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(LoginOpenidEntity record) {
		return loginOpenidMapper.updateByPrimaryKey(record);
	}

	public List<LoginOpenidEntity> selectListByEntity(LoginOpenidEntity record) {
		return loginOpenidMapper.selectListByEntity(record);
	}*/

	}
