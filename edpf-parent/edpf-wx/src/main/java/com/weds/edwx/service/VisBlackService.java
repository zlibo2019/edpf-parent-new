package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisBlackMapper;
import com.weds.edwx.entity.VisBlackEntity;

/**
 * @Author sxm
 * @Description VisBlack管理
 * @Date 2019-03-20
 */
@Service
public class VisBlackService extends BaseService {

    @Autowired
    private VisBlackMapper visBlackMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String openId) {
        return visBlackMapper.deleteByPrimaryKey(openId);
    }

    public int insert(VisBlackEntity record) {
        return visBlackMapper.insert(record);
    }

    public int insertSelective(VisBlackEntity record) {
        return visBlackMapper.insertSelective(record);
    }

    public VisBlackEntity selectByPrimaryKey(String openId) {
        return visBlackMapper.selectByPrimaryKey(openId);
    }

    public VisBlackEntity selectByCardId(String visNo) {
        return visBlackMapper.selectByCardId(visNo);
    }

    public int updateByPrimaryKeySelective(VisBlackEntity record) {
        return visBlackMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisBlackEntity record) {
        return visBlackMapper.updateByPrimaryKey(record);
    }

    public List<VisBlackEntity> selectListByEntity(VisBlackEntity record) {
        return visBlackMapper.selectListByEntity(record);
    }


    public List<VisBlackEntity> selectListByKeys(String keys) {
        return visBlackMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisBlackEntity> list) {
        return visBlackMapper.deleteBatchByKeys(list);
    }
}
