package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.DictTypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 字典类型管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface DictTypeMapper {
    /**
     */
    int deleteByPrimaryKey(String typeCode);

    /**
     */
    int insert(DictTypeEntity record);

    /**
     */
    int insertSelective(DictTypeEntity record);

    /**
     */
    DictTypeEntity selectByPrimaryKey(String typeCode);

    /**
     */
    int updateByPrimaryKeySelective(DictTypeEntity record);

    /**
     */
    int updateByPrimaryKey(DictTypeEntity record);

    /**
     */
    List<DictTypeEntity> selectListByEntity(DictTypeEntity record);

    /**
     */
    List<DictTypeEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<DictTypeEntity> list);
}