package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.DineOrderReq;
import com.weds.edwx.entity.EdDineOrderEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 订餐订单管理
 * @Date 2019-10-22
 */
@MyBatisDao
public interface EdDineOrderMapper {
    /**
     */
    int deleteByPrimaryKey(String orderId);

    /**
     */
    int insert(EdDineOrderEntity record);

    /**
     */
    int insertSelective(EdDineOrderEntity record);

    /**
     */
    EdDineOrderEntity selectByPrimaryKey(String orderId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineOrderEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineOrderEntity record);

    /**
     */
    List<EdDineOrderEntity> selectListByEntity(EdDineOrderEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineOrderEntity> list);

    /**
     */
    EdDineOrderEntity selectLastOrder(String userSerial);

    /**
     */
    List<EdDineOrderEntity> selectOrderListPageByEntity(DineOrderReq record);

    /**
     */
    List<EdDineOrderEntity> selectOrderListPageByDate(DineOrderReq record);
}