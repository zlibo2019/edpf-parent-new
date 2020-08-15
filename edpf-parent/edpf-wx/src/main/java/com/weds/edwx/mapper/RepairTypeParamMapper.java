package com.weds.edwx.mapper;

import com.weds.edwx.entity.RepairTypeParamEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-02-28
 */
@MyBatisDao
public interface RepairTypeParamMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("companyId") String companyId, @Param("typeId") String typeId);

    /**
     */
    int insert(RepairTypeParamEntity record);

    /**
     */
    int insertSelective(RepairTypeParamEntity record);

    /**
     */
    RepairTypeParamEntity selectByPrimaryKey(@Param("companyId") String companyId, @Param("typeId") String typeId);

    /**
     */
    int updateByPrimaryKeySelective(RepairTypeParamEntity record);

    /**
     */
    int updateByPrimaryKey(RepairTypeParamEntity record);

    /**
     */
    List<RepairTypeParamEntity> selectListByEntity(RepairTypeParamEntity record);
}