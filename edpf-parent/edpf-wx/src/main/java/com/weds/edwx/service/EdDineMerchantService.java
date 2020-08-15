package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineMerchantMapper;
import com.weds.edwx.entity.EdDineMerchantEntity;

/**
 * @Author sxm
 * @Description 商户定义管理
 * @Date 2019-04-12
 */
@Service
public class EdDineMerchantService extends BaseService {

    @Autowired
    private EdDineMerchantMapper edDineMerchantMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String merchantId) {
        return edDineMerchantMapper.deleteByPrimaryKey(merchantId);
    }

    public int insert(EdDineMerchantEntity record) {
        return edDineMerchantMapper.insert(record);
    }

    public int insertSelective(EdDineMerchantEntity record) {
        return edDineMerchantMapper.insertSelective(record);
    }

    public EdDineMerchantEntity selectByPrimaryKey(String merchantId) {
        return edDineMerchantMapper.selectByPrimaryKey(merchantId);
    }

    public int updateByPrimaryKeySelective(EdDineMerchantEntity record) {
        return edDineMerchantMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineMerchantEntity record) {
        return edDineMerchantMapper.updateByPrimaryKey(record);
    }

    public List<EdDineMerchantEntity> selectListByEntity(EdDineMerchantEntity record) {
        return edDineMerchantMapper.selectListByEntity(record);
    }


    public List<EdDineMerchantEntity> selectListByKeys(String keys) {
        return edDineMerchantMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineMerchantEntity> list) {
        return edDineMerchantMapper.deleteBatchByKeys(list);
    }
}
