package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.SysParamEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 系统参数管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface SysParamMapper {
    /**
     */
    int deleteByPrimaryKey(String paramKey);

    /**
     */
    int insert(SysParamEntity record);

    /**
     */
    int insertSelective(SysParamEntity record);

    /**
     */
    SysParamEntity selectByPrimaryKey(String paramKey);

    /**
     */
    int updateByPrimaryKeySelective(SysParamEntity record);

    /**
     */
    int updateByPrimaryKey(SysParamEntity record);

    /**
     */
    List<SysParamEntity> selectListByEntity(SysParamEntity record);

    /**
     */
    List<SysParamEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<SysParamEntity> list);
}