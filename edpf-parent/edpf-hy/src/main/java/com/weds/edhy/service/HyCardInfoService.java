package com.weds.edhy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edhy.mapper.HyCardInfoMapper;
import com.weds.edhy.entity.HyCardInfoEntity;

/**
 * @Author
 * @Description 卡片信息管理
 * @Date 2019-10-11
 */
@Service
public class HyCardInfoService extends BaseService {

    @Resource
    private HyCardInfoMapper hyCardInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String cardId) {
        return hyCardInfoMapper.deleteByPrimaryKey(cardId);
    }

    public int insert(HyCardInfoEntity record) {
        return hyCardInfoMapper.insert(record);
    }

    public int insertSelective(HyCardInfoEntity record) {
        return hyCardInfoMapper.insertSelective(record);
    }

    public HyCardInfoEntity selectByPrimaryKey(String cardId) {
        return hyCardInfoMapper.selectByPrimaryKey(cardId);
    }

    public int updateByPrimaryKeySelective(HyCardInfoEntity record) {
        return hyCardInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HyCardInfoEntity record) {
        return hyCardInfoMapper.updateByPrimaryKey(record);
    }

    public List<HyCardInfoEntity> selectListByEntity(HyCardInfoEntity record) {
        return hyCardInfoMapper.selectListByEntity(record);
    }

    public int deleteBatchByKeys(List<HyCardInfoEntity> list) {
        return hyCardInfoMapper.deleteBatchByKeys(list);
    }
}
