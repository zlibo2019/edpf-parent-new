package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisBlackNewMapper;
import com.weds.edwx.entity.VisBlackNewEntity;

/**
 * @Author sxm
 * @Description VisBlackNew管理
 * @Date 2019-05-21
 */
@Service
public class VisBlackNewService extends BaseService {

    @Autowired
    private VisBlackNewMapper visBlackNewMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String visNo) {
        return visBlackNewMapper.deleteByPrimaryKey(visNo);
    }

    public int insert(VisBlackNewEntity record) {
        return visBlackNewMapper.insert(record);
    }

    public int insertSelective(VisBlackNewEntity record) {
        return visBlackNewMapper.insertSelective(record);
    }

    public VisBlackNewEntity selectByPrimaryKey(String visNo) {
        return visBlackNewMapper.selectByPrimaryKey(visNo);
    }

    public int updateByPrimaryKeySelective(VisBlackNewEntity record) {
        return visBlackNewMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisBlackNewEntity record) {
        return visBlackNewMapper.updateByPrimaryKey(record);
    }

    public List<VisBlackNewEntity> selectListByEntity(VisBlackNewEntity record) {
        return visBlackNewMapper.selectListByEntity(record);
    }


    public List<VisBlackNewEntity> selectListByKeys(String keys) {
        return visBlackNewMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisBlackNewEntity> list) {
        return visBlackNewMapper.deleteBatchByKeys(list);
    }
}
