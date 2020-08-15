package com.weds.edwx.service;

import com.weds.edwx.entity.DoorInfoEntity;
import com.weds.edwx.entity.DoorfxRealEntity;
import com.weds.edwx.entity.MjJlRealEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.MjMobileMapper;
import com.weds.edwx.entity.MjMobileEntity;

/**
 * @Author sxm
 * @Description MjMobile管理
 * @Date 2018-12-22
 */
@Service
public class MjMobileService extends BaseService {

    @Autowired
    private MjMobileMapper mjMobileMapper;

    private Logger log = LogManager.getLogger();

    public int openDoor(DoorfxRealEntity record) {
        return mjMobileMapper.openDoor(record);
    }

    public int updateGateListOrder(DoorInfoEntity record) {
        return mjMobileMapper.updateGateListOrder(record);
    }

    public List<MjMobileEntity> selectDoorList(MjMobileEntity record) {
        return mjMobileMapper.selectDoorList(record);
    }

    public int selectDoorFlg(MjMobileEntity record) {
        return mjMobileMapper.selectDoorFlg(record);
    }

    public int getOpenState(Integer jcmdsig) {
        return mjMobileMapper.getOpenState(jcmdsig);
    }

    public int insertLog(MjMobileEntity record) {
        return mjMobileMapper.insertLog(record);
    }

    public DoorfxRealEntity selectDoorFlgByDevSerial(Long userSerial, String devSid,
                                                     Integer devOrder, Integer devLb) {
        return mjMobileMapper.selectDoorFlgByDevSerial(userSerial, devSid, devOrder, devLb);
    }

    public MjJlRealEntity selectMjRecord(Integer xh) {
        return mjMobileMapper.selectMjRecord(xh);
    }
}
