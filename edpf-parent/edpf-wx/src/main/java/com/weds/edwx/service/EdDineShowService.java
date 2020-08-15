package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineShowMapper;
import com.weds.edwx.entity.EdDineShowEntity;

/**
 * @Author sxm
 * @Description 订餐说明管理
 * @Date 2019-04-30
 */
@Service
public class EdDineShowService extends BaseService {

    @Autowired
    private EdDineShowMapper edDineShowMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String placeId) {
        return edDineShowMapper.deleteByPrimaryKey(placeId);
    }

    public int insert(EdDineShowEntity record) {
        return edDineShowMapper.insert(record);
    }

    public int insertSelective(EdDineShowEntity record) {
        return edDineShowMapper.insertSelective(record);
    }

    public EdDineShowEntity selectByPrimaryKey(String placeId) {
        return edDineShowMapper.selectByPrimaryKey(placeId);
    }

    public int updateByPrimaryKeySelective(EdDineShowEntity record) {
        return edDineShowMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineShowEntity record) {
        return edDineShowMapper.updateByPrimaryKey(record);
    }

    public List<EdDineShowEntity> selectListByEntity(EdDineShowEntity record) {
        return edDineShowMapper.selectListByEntity(record);
    }


    public List<EdDineShowEntity> selectListByKeys(String keys) {
        return edDineShowMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineShowEntity> list) {
        return edDineShowMapper.deleteBatchByKeys(list);
    }
}
