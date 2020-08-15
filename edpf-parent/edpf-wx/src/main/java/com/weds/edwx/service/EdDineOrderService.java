package com.weds.edwx.service;

import javax.annotation.Resource;

import com.weds.edwx.entity.DineOrderReq;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineOrderMapper;
import com.weds.edwx.entity.EdDineOrderEntity;

/**
 * @Author
 * @Description 订餐订单管理
 * @Date 2019-10-22
 */
@Service
public class EdDineOrderService extends BaseService {

    @Resource
    private EdDineOrderMapper edDineOrderMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String orderId) {
        return edDineOrderMapper.deleteByPrimaryKey(orderId);
    }

    public int insert(EdDineOrderEntity record) {
        return edDineOrderMapper.insert(record);
    }

    public int insertSelective(EdDineOrderEntity record) {
        return edDineOrderMapper.insertSelective(record);
    }

    public EdDineOrderEntity selectByPrimaryKey(String orderId) {
        return edDineOrderMapper.selectByPrimaryKey(orderId);
    }

    public int updateByPrimaryKeySelective(EdDineOrderEntity record) {
        return edDineOrderMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineOrderEntity record) {
        return edDineOrderMapper.updateByPrimaryKey(record);
    }

    public List<EdDineOrderEntity> selectListByEntity(EdDineOrderEntity record) {
        return edDineOrderMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<EdDineOrderEntity> list) {
        return edDineOrderMapper.deleteBatchByKeys(list);
    }

    public EdDineOrderEntity selectLastOrder(String userSerial) {
        return edDineOrderMapper.selectLastOrder(userSerial);
    }

    public List<EdDineOrderEntity> selectOrderListPageByEntity(DineOrderReq record) {
        return edDineOrderMapper.selectOrderListPageByEntity(record);
    }

    public List<EdDineOrderEntity> selectOrderListPageByDate(DineOrderReq record) {
        return edDineOrderMapper.selectOrderListPageByDate(record);
    }
}
