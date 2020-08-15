package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .ParkCarDepMapper;
import com.weds.edwx.entity .ParkCarDepEntity;

/**
 * @Author sxm
 * @Description ParkCarDep管理
 * @Date 2019-03-26
 */
@Service
public class ParkCarDepService extends BaseService {

    @Autowired
    private ParkCarDepMapper parkCarDepMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer parkSerial) {
        return parkCarDepMapper.deleteByPrimaryKey(parkSerial);
    }

    public int insert(ParkCarDepEntity record) {
        return parkCarDepMapper.insert(record);
    }

    public int insertSelective(ParkCarDepEntity record) {
        return parkCarDepMapper.insertSelective(record);
    }

    public ParkCarDepEntity selectByPrimaryKey(Integer parkSerial) {
        return parkCarDepMapper.selectByPrimaryKey(parkSerial);
    }

    public int updateByPrimaryKeySelective(ParkCarDepEntity record) {
        return parkCarDepMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ParkCarDepEntity record) {
        return parkCarDepMapper.updateByPrimaryKey(record);
    }

    public List<ParkCarDepEntity> selectListByEntity(ParkCarDepEntity record) {
        return parkCarDepMapper.selectListByEntity(record);
    }

}
