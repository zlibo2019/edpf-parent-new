package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.EdDineOrderDetailEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 订餐订单详情管理
 * @Date 2019-10-22
 */
@MyBatisDao
public interface EdDineOrderDetailMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(EdDineOrderDetailEntity record);

    /**
     */
    int insertSelective(EdDineOrderDetailEntity record);

    /**
     */
    EdDineOrderDetailEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(EdDineOrderDetailEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineOrderDetailEntity record);

    /**
     */
    List<EdDineOrderDetailEntity> selectListByEntity(EdDineOrderDetailEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineOrderDetailEntity> list);
}