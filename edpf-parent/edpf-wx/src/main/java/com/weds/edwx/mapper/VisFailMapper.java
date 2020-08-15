package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisFailEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisFailMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisFailEntity record);

    /**
     */
    int insertSelective(VisFailEntity record);

    /**
     */
    VisFailEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisFailEntity record);

    /**
     */
    int updateByPrimaryKey(VisFailEntity record);

    /**
     */
    List<VisFailEntity> selectListByEntity(VisFailEntity record);

    /**
     */
    List<VisFailEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisFailEntity> list);
}