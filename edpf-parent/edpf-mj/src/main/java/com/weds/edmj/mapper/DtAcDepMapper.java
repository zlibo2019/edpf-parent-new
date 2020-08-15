package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DtAcDepEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-30
 */
@MyBatisDao
public interface DtAcDepMapper {
    /**
     */
    int deleteByPrimaryKey(Integer depSerial);

    /**
     */
    int insert(DtAcDepEntity record);

    /**
     */
    int insertBatch(@Param("list") List<DtAcDepEntity> list);

    /**
     */
    int insertSelective(DtAcDepEntity record);

    /**
     */
    DtAcDepEntity selectByPrimaryKey(Integer depSerial);

    /**
     */
    int updateByPrimaryKeySelective(DtAcDepEntity record);

    /**
     */
    int updateByPrimaryKey(DtAcDepEntity record);

    /**
     */
    List<DtAcDepEntity> selectListByEntity(DtAcDepEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DtAcDepEntity> list);

    /**
     */
    List<DtAcDepEntity> selectPlaceTree(@Param("depParent") Integer depParent);
}