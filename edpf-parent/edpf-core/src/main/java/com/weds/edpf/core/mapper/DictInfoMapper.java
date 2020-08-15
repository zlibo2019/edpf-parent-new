package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.DictInfoEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 字典信息管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface DictInfoMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("typeCode") String typeCode, @Param("dicCode") String dicCode);

    /**
     */
    int insert(DictInfoEntity record);

    /**
     */
    int insertSelective(DictInfoEntity record);

    /**
     */
    DictInfoEntity selectByPrimaryKey(@Param("typeCode") String typeCode, @Param("dicCode") String dicCode);

    /**
     */
    int updateByPrimaryKeySelective(DictInfoEntity record);

    /**
     */
    int updateByPrimaryKey(DictInfoEntity record);

    /**
     */
    List<DictInfoEntity> selectListByEntity(DictInfoEntity record);

    /**
     */
    List<DictInfoEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DictInfoEntity> list);

    /**
     */
    List<DictInfoEntity> selectListByType(@Param("typeCodes") List<String> typeCodes);
}