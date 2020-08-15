package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.RptInfoEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 报表模板管理管理
 * @Date 2019-05-13
 */
@MyBatisDao
public interface RptInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String rptId);

    /**
     */
    int insert(RptInfoEntity record);

    /**
     */
    int insertSelective(RptInfoEntity record);

    /**
     */
    RptInfoEntity selectByPrimaryKey(String rptId);

    /**
     */
    int updateByPrimaryKeySelective(RptInfoEntity record);

    /**
     */
    int updateByPrimaryKey(RptInfoEntity record);

    /**
     */
    List<RptInfoEntity> selectListByEntity(RptInfoEntity record);

    /**
     */
    List<RptInfoEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RptInfoEntity> list);
}