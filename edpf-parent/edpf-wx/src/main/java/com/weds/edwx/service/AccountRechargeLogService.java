package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.AccountRechargeLogEntity;
import com.weds.edwx.mapper.AccountRechargeLogMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description 账户充值日志管理
 * @Date 2019-10-22
 */
@Service
public class AccountRechargeLogService extends BaseService {

    @Resource
    private AccountRechargeLogMapper accountRechargeLogMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return accountRechargeLogMapper.deleteByPrimaryKey(id);
    }

    public int insert(AccountRechargeLogEntity record) {
        return accountRechargeLogMapper.insert(record);
    }

    public int insertSelective(AccountRechargeLogEntity record) {
        return accountRechargeLogMapper.insertSelective(record);
    }

    public AccountRechargeLogEntity selectByPrimaryKey(String id) {
        return accountRechargeLogMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(AccountRechargeLogEntity record) {
        return accountRechargeLogMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AccountRechargeLogEntity record) {
        return accountRechargeLogMapper.updateByPrimaryKey(record);
    }

    public List<AccountRechargeLogEntity> selectListByEntity(AccountRechargeLogEntity record) {
        return accountRechargeLogMapper.selectListByEntity(record);
    }
}
