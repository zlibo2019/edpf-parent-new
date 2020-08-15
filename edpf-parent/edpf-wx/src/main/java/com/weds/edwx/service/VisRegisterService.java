package com.weds.edwx.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisRegisterMapper;
import com.weds.edwx.entity.VisRegisterEntity;

/**
 * @Author sxm
 * @Description VisRegister管理
 * @Date 2019-03-20
 */
@Service
public class VisRegisterService extends BaseService {

    @Autowired
    private VisRegisterMapper visRegisterMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return visRegisterMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisRegisterEntity record) {
        return visRegisterMapper.insert(record);
    }

    public int insertSelective(VisRegisterEntity record) {
        return visRegisterMapper.insertSelective(record);
    }

    public VisRegisterEntity selectByPrimaryKey(Integer xh) {
        return visRegisterMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisRegisterEntity record) {
        return visRegisterMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisRegisterEntity record) {
        return visRegisterMapper.updateByPrimaryKey(record);
    }

    public List<VisRegisterEntity> selectListByEntity(VisRegisterEntity record) {
        return visRegisterMapper.selectListByEntity(record);
    }

    public List<VisRegisterEntity> selectRepeatRecord(VisRegisterEntity record) {
        return visRegisterMapper.selectRepeatRecord(record);
    }

    public List<VisRegisterEntity> selectLossRecord(VisRegisterEntity record) {
        return visRegisterMapper.selectLossRecord(record);
    }

    public List<VisRegisterEntity> selectListByKeys(String keys) {
        return visRegisterMapper.selectListByKeys(keys);
    }

    public List<VisRegisterEntity> selectVisListByEntity(VisRegisterEntity record) {
        return visRegisterMapper.selectVisListByEntity(record);
    }

    public VisRegisterEntity selectVisiting(long visSerial) {
        return visRegisterMapper.selectVisiting(visSerial);
    }

    public int deleteBatchByKeys(List<VisRegisterEntity> list) {
        return visRegisterMapper.deleteBatchByKeys(list);
    }

    public VisRegisterEntity selectTodayRecords(long visSerial, String currDate, String visKeeperNo) {
        return visRegisterMapper.selectTodayRecord(visSerial, currDate, visKeeperNo);
    }

    public int deleteTodayRecords(long visSerial, String currDate) {
        return visRegisterMapper.deleteTodayRecord(visSerial, currDate);
    }
}
