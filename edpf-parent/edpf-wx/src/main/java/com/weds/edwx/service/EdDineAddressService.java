package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineAddressMapper;
import com.weds.edwx.entity.EdDineAddressEntity;

/**
 * @Author sxm
 * @Description 送餐点定义管理
 * @Date 2019-04-12
 */
@Service
public class EdDineAddressService extends BaseService {

    @Autowired
    private EdDineAddressMapper edDineAddressMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String addressId) {
        return edDineAddressMapper.deleteByPrimaryKey(addressId);
    }

    public int insert(EdDineAddressEntity record) {
        return edDineAddressMapper.insert(record);
    }

    public int insertSelective(EdDineAddressEntity record) {
        return edDineAddressMapper.insertSelective(record);
    }

    public EdDineAddressEntity selectByPrimaryKey(String addressId) {
        return edDineAddressMapper.selectByPrimaryKey(addressId);
    }

    public int updateByPrimaryKeySelective(EdDineAddressEntity record) {
        return edDineAddressMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineAddressEntity record) {
        return edDineAddressMapper.updateByPrimaryKey(record);
    }

    public List<EdDineAddressEntity> selectListByEntity(EdDineAddressEntity record) {
        return edDineAddressMapper.selectListByEntity(record);
    }


    public List<EdDineAddressEntity> selectListByKeys(String keys) {
        return edDineAddressMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineAddressEntity> list) {
        return edDineAddressMapper.deleteBatchByKeys(list);
    }
}
