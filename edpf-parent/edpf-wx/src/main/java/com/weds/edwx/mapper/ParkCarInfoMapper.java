package com.weds.edwx.mapper;

import com.weds.edwx.entity.ParkCarInfoEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-27
 */
@MyBatisDao
public interface ParkCarInfoMapper {
    //更新临时车牌状态
    int updateByCar(ParkCarInfoEntity parkCarInfoEntity);
    int deleteCarsRules(ParkCarInfoEntity parkCarInfoEntity);
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(ParkCarInfoEntity record);

    /**
     */
    int insertSelective(ParkCarInfoEntity record);

    /**
     */
    ParkCarInfoEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(ParkCarInfoEntity record);

    /**
     */
    int updateByPrimaryKey(ParkCarInfoEntity record);

    /**
     */
    List<ParkCarInfoEntity> selectListByEntity(ParkCarInfoEntity record);
}