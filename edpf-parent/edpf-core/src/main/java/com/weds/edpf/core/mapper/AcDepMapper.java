package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.AcDepEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-10-17
 */
@MyBatisDao
public interface AcDepMapper {
    /**
     */
    int deleteByPrimaryKey(Integer depSerial);

    /**
     */
    int insert(AcDepEntity record);

    /**
     */
    int insertSelective(AcDepEntity record);

    /**
     */
    AcDepEntity selectByPrimaryKey(Integer depSerial);

    /**
     */
    int updateByPrimaryKeySelective(AcDepEntity record);

    /**
     */
    int updateByPrimaryKey(AcDepEntity record);

    /**
     */
    List<AcDepEntity> selectListByEntity(AcDepEntity record);


    List<AcDepEntity> selectDinePlace();

    /**
     */
    int deleteBatchByKeys(@Param("list") List<AcDepEntity> list);
}