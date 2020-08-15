package com.weds.edwx.mapper;

import com.weds.edwx.entity.AccountInfoEntity;
import com.weds.edwx.entity.XfMxEntity;
import com.weds.edwx.entity.XfTimeEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-21
 */
@MyBatisDao
public interface XfMxMapper {

    XfMxEntity selectCollectSum(XfTimeEntity record);

    List<XfMxEntity> selectListByEntity(XfTimeEntity record);

    AccountInfoEntity getAccountSum(XfTimeEntity record);

    AccountInfoEntity selectAccountBal(String userId);

    List<XfMxEntity> selectAccountRecordList(XfTimeEntity record);

    List<XfMxEntity> selectRechargeRecord(XfTimeEntity record);

}