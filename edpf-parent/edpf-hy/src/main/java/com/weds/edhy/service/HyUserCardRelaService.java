package com.weds.edhy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edhy.mapper.HyUserCardRelaMapper;
import com.weds.edhy.entity.HyUserCardRelaEntity;

/**
 * @Author
 * @Description 会员与卡片关系管理
 * @Date 2019-10-11
 */
@Service
public class HyUserCardRelaService extends BaseService {

    @Resource
    private HyUserCardRelaMapper hyUserCardRelaMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userId, String cardId) {
        return hyUserCardRelaMapper.deleteByPrimaryKey(userId, cardId);
    }

    public int insert(HyUserCardRelaEntity record) {
        return hyUserCardRelaMapper.insert(record);
    }

    public int insertSelective(HyUserCardRelaEntity record) {
        return hyUserCardRelaMapper.insertSelective(record);
    }

    public HyUserCardRelaEntity selectByPrimaryKey(String userId, String cardId) {
        return hyUserCardRelaMapper.selectByPrimaryKey(userId, cardId);
    }

    public int updateByPrimaryKeySelective(HyUserCardRelaEntity record) {
        return hyUserCardRelaMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HyUserCardRelaEntity record) {
        return hyUserCardRelaMapper.updateByPrimaryKey(record);
    }
}
