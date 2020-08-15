package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.AccountRechargeLogEntity;

import java.util.List;

/**
 * @Author
 * @Description 账户充值日志管理
 * @Date 2019-10-22
 */
@MyBatisDao
public interface AccountRechargeLogMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(AccountRechargeLogEntity record);

    /**
     */
    int insertSelective(AccountRechargeLogEntity record);

    /**
     */
    AccountRechargeLogEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(AccountRechargeLogEntity record);

    /**
     */
    int updateByPrimaryKey(AccountRechargeLogEntity record);

    /**
     */
    List<AccountRechargeLogEntity> selectListByEntity(AccountRechargeLogEntity record);
}