package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .ParkCarInfoMapper;
import com.weds.edwx.entity .ParkCarInfoEntity;

/**
 * @Author sxm
 * @Description ParkCarInfo管理
 * @Date 2019-03-27
 */
@Service
public class ParkCarInfoService extends BaseService {

    @Autowired
    private ParkCarInfoMapper parkCarInfoMapper;

    private Logger log = LogManager.getLogger();

    /**
     * 更新临时车牌状态
     * @param parkCarInfoEntity
     * @return
     */
    public int updateByCar(ParkCarInfoEntity parkCarInfoEntity){
        return parkCarInfoMapper.updateByCar(parkCarInfoEntity);
    }
    public int deleteCarsRules(ParkCarInfoEntity parkCarInfoEntity){
        return parkCarInfoMapper.deleteCarsRules(parkCarInfoEntity);
    }
    public int deleteByPrimaryKey(Integer xh) {
        return parkCarInfoMapper.deleteByPrimaryKey(xh);
    }

    public int insert(ParkCarInfoEntity record) {
        return parkCarInfoMapper.insert(record);
    }

    public int insertSelective(ParkCarInfoEntity record) {
        return parkCarInfoMapper.insertSelective(record);
    }

    public ParkCarInfoEntity selectByPrimaryKey(Integer xh) {
        return parkCarInfoMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(ParkCarInfoEntity record) {
        return parkCarInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ParkCarInfoEntity record) {
        return parkCarInfoMapper.updateByPrimaryKey(record);
    }

    public List<ParkCarInfoEntity> selectListByEntity(ParkCarInfoEntity record) {
        return parkCarInfoMapper.selectListByEntity(record);
    }

}
