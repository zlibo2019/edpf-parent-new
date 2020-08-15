package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisJlAllEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisJlAllMapper {
    /**
     */
    int deleteByPrimaryKey(Long xh);

    /**
     */
    int insert(VisJlAllEntity record);

    /**
     */
    int insertSelective(VisJlAllEntity record);

    /**
     */
    VisJlAllEntity selectByPrimaryKey(Long xh);

    /**
     */
    int updateByPrimaryKeySelective(VisJlAllEntity record);

    /**
     */
    int updateByPrimaryKey(VisJlAllEntity record);

    /**
     */
    List<VisJlAllEntity> selectListByEntity(VisJlAllEntity record);

    /**
     */
    List<VisJlAllEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisJlAllEntity> list);
}