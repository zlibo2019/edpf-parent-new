package com.weds.edwx.mapper;

import com.weds.edwx.entity.AccountEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-28
 */
@MyBatisDao
public interface AccountMapper {
    AccountEntity selectPreOrderByTradeNo(String orderId);

    int selectPreOrder(Map<String, String> record);

    int updateOrderState(Map<String, String> record);

    int updateTradeNo(Map<String, String> record);

    AccountEntity selectPayResult(AccountEntity record);

    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(AccountEntity record);

    /**
     */
    int insertSelective(AccountEntity record);

    /**
     */
    AccountEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(AccountEntity record);

    /**
     */
    int updateByPrimaryKey(AccountEntity record);

    /**
     */
    List<AccountEntity> selectListByEntity(AccountEntity record);


}