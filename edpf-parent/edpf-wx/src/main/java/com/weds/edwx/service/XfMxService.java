package com.weds.edwx.service;

import com.weds.edwx.entity.AccountInfoEntity;
import com.weds.edwx.entity.XfTimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.XfMxMapper;
import com.weds.edwx.entity.XfMxEntity;

/**
 * @Author sxm
 * @Description XfMx管理
 * @Date 2018-12-21
 */
@Service
public class XfMxService extends BaseService {

    @Autowired
    private XfMxMapper xfMxMapper;

    private Logger log = LogManager.getLogger();

    /**
     * 根据开始时间和结束时间查询人员的消费、充值和补贴汇总
     *
     * @param xfTimeEntity
     * @return
     */
    public XfMxEntity selectCollectSum(XfTimeEntity xfTimeEntity) {
        return xfMxMapper.selectCollectSum(xfTimeEntity);
    }

    /**
     * 根据开始时间和结束时间查询人员的消费、充值和补贴明细列表
     *
     * @param record
     * @return
     */
    public List<XfMxEntity> selectListByEntity(XfTimeEntity record) {
        return xfMxMapper.selectListByEntity(record);
    }

    /**
     * 获取账户余额信息
     *
     * @param record
     * @return
     */
    public AccountInfoEntity getAccountSum(XfTimeEntity record) {
        return xfMxMapper.getAccountSum(record);
    }

    public AccountInfoEntity selectAccountBal(String userId) {
        return xfMxMapper.selectAccountBal(userId);
    }

    /**
     * 获取我的账户变更记录
     *
     * @param record
     * @return
     */
    public List<XfMxEntity> selectAccountRecordList(XfTimeEntity record) {
        return xfMxMapper.selectAccountRecordList(record);
    }

    /**
     * 获取账户充值记录
     *
     * @param record
     * @return
     */
    public List<XfMxEntity> selectRechargeRecord(XfTimeEntity record) {
        return xfMxMapper.selectRechargeRecord(record);
    }


}
