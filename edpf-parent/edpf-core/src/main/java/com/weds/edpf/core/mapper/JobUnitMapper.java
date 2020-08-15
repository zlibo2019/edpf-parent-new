package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.JobUnitEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 作业单元信息管理
 * @Date 2019-05-06
 */
@MyBatisDao
public interface JobUnitMapper {
    /**
     */
    int deleteByPrimaryKey(String jobId);

    /**
     */
    int insert(JobUnitEntity record);

    /**
     */
    int insertSelective(JobUnitEntity record);

    /**
     */
    JobUnitEntity selectByPrimaryKey(String jobId);

    /**
     */
    int updateByPrimaryKeySelective(JobUnitEntity record);

    /**
     */
    int updateByPrimaryKey(JobUnitEntity record);

    /**
     */
    List<JobUnitEntity> selectListByEntity(JobUnitEntity record);

    /**
     */
    List<JobUnitEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<JobUnitEntity> list);
}