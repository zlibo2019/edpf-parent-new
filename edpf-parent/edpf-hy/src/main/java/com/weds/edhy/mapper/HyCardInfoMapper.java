package com.weds.edhy.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edhy.entity.HyCardInfoEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 卡片信息管理
 * @Date 2019-10-11
 */
@MyBatisDao
public interface HyCardInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String cardId);

    /**
     */
    int insert(HyCardInfoEntity record);

    /**
     */
    int insertSelective(HyCardInfoEntity record);

    /**
     */
    HyCardInfoEntity selectByPrimaryKey(String cardId);

    /**
     */
    int updateByPrimaryKeySelective(HyCardInfoEntity record);

    /**
     */
    int updateByPrimaryKey(HyCardInfoEntity record);

    /**
     */
    List<HyCardInfoEntity> selectListByEntity(HyCardInfoEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<HyCardInfoEntity> list);
}