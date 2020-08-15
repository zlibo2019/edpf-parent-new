package com.weds.edwx.mapper;

import com.weds.edwx.entity.FkLogEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-22
 */
@MyBatisDao
public interface FkLogMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(FkLogEntity record);

    /**
     */
    int insertSelective(FkLogEntity record);

    /**
     */
    FkLogEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(FkLogEntity record);

    /**
     */
    int updateByPrimaryKey(FkLogEntity record);

    /**
     */
    List<FkLogEntity> selectListByEntity(FkLogEntity record);
}