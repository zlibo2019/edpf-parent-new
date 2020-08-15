package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.EdDineOrderInfoEntity;
import com.weds.edwx.mapper.EdDineOrderInfoMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description 订餐订单信息管理
 * @Date 2019-10-22
 */
@Service
public class EdDineOrderInfoService extends BaseService {

    @Resource
    private EdDineOrderInfoMapper edDineOrderInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String subOrderId) {
        return edDineOrderInfoMapper.deleteByPrimaryKey(subOrderId);
    }

    public int insert(EdDineOrderInfoEntity record) {
        return edDineOrderInfoMapper.insert(record);
    }

    public int insertSelective(EdDineOrderInfoEntity record) {
        return edDineOrderInfoMapper.insertSelective(record);
    }

    public EdDineOrderInfoEntity selectByPrimaryKey(String subOrderId) {
        return edDineOrderInfoMapper.selectByPrimaryKey(subOrderId);
    }

    public int updateByPrimaryKeySelective(EdDineOrderInfoEntity record) {
        return edDineOrderInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineOrderInfoEntity record) {
        return edDineOrderInfoMapper.updateByPrimaryKey(record);
    }

    public List<EdDineOrderInfoEntity> selectListByEntity(EdDineOrderInfoEntity record) {
        return edDineOrderInfoMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<EdDineOrderInfoEntity> list) {
        return edDineOrderInfoMapper.deleteBatchByKeys(list);
    }

}
