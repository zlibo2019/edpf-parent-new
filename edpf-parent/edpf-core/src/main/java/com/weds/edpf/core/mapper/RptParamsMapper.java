package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.RptParamsEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 报表模板参数管理
 * @Date 2019-05-15
 */
@MyBatisDao
public interface RptParamsMapper {
    /**
     */
    int deleteByPrimaryKey(String rptId);

    /**
     */
    int insert(RptParamsEntity record);

    /**
     */
    int insertSelective(RptParamsEntity record);

    /**
     */
    RptParamsEntity selectByPrimaryKey(String rptId);

    /**
     */
    int updateByPrimaryKeySelective(RptParamsEntity record);

    /**
     */
    int updateByPrimaryKey(RptParamsEntity record);

    /**
     */
    List<RptParamsEntity> selectListByEntity(RptParamsEntity record);

    /**
     */
    List<RptParamsEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RptParamsEntity> list);
}