package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.VisRegisterNewEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-05-21
 */
@MyBatisDao
public interface VisRegisterNewMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisRegisterNewEntity record);

    /**
     */
    int insertSelective(VisRegisterNewEntity record);

    /**
     */
    VisRegisterNewEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisRegisterNewEntity record);

    /**
     */
    int updateByPrimaryKey(VisRegisterNewEntity record);

    /**
     */
    List<VisRegisterNewEntity> selectListByEntity(VisRegisterNewEntity record);

    /**
     */
    List<VisRegisterNewEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisRegisterNewEntity> list);

    /**
     */
    List<VisRegisterNewEntity> selectRepeatRecord(VisRegisterNewEntity record);
}