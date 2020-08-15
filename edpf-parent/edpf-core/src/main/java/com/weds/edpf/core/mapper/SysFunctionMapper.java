package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.SysFunctionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Description 权限管理管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface SysFunctionMapper {
    /**
     */
    int deleteByPrimaryKey(String functionId);

    /**
     */
    int insert(SysFunctionEntity record);

    /**
     */
    int insertSelective(SysFunctionEntity record);

    /**
     */
    SysFunctionEntity selectByPrimaryKey(String functionId);

    /**
     */
    int updateByPrimaryKeySelective(SysFunctionEntity record);

    /**
     */
    int updateByPrimaryKey(SysFunctionEntity record);

    /**
     */
    List<SysFunctionEntity> selectListByEntity(SysFunctionEntity record);

    /**
     */
    List<SysFunctionEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<SysFunctionEntity> list);

    /**
     */
    List<SysFunctionEntity> selectTreeData(SysFunctionEntity record);

    /**
     */
    int insertBatch(@Param("list") List<SysFunctionEntity> list);

    /**
     */
    List<SysFunctionEntity> selectListByIds(@Param("list") List<SysFunctionEntity> list);

    /**
     */
    int deleteAll();
}