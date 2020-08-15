package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.EdDineOrderInfoEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 订餐订单信息管理
 * @Date 2019-10-22
 */
@MyBatisDao
public interface EdDineOrderInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String subOrderId);

    /**
     */
    int insert(EdDineOrderInfoEntity record);

    /**
     */
    int insertSelective(EdDineOrderInfoEntity record);

    /**
     */
    EdDineOrderInfoEntity selectByPrimaryKey(String subOrderId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineOrderInfoEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineOrderInfoEntity record);

    /**
     */
    List<EdDineOrderInfoEntity> selectListByEntity(EdDineOrderInfoEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineOrderInfoEntity> list);
}