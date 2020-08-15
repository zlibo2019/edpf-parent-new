package com.weds.edhy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edhy.mapper.HyUserInfoMapper;
import com.weds.edhy.entity.HyUserInfoEntity;

/**
 * @Author
 * @Description 会员附属信息管理
 * @Date 2019-10-08
 */
@Service
public class HyUserInfoService extends BaseService {

    @Resource
    private HyUserInfoMapper hyUserInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userId) {
        return hyUserInfoMapper.deleteByPrimaryKey(userId);
    }

    public int insert(HyUserInfoEntity record) {
        return hyUserInfoMapper.insert(record);
    }

    public int insertSelective(HyUserInfoEntity record) {
        return hyUserInfoMapper.insertSelective(record);
    }

    public HyUserInfoEntity selectByPrimaryKey(String userId) {
        return hyUserInfoMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(HyUserInfoEntity record) {
        return hyUserInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HyUserInfoEntity record) {
        return hyUserInfoMapper.updateByPrimaryKey(record);
    }

    public List<HyUserInfoEntity> selectListByEntity(HyUserInfoEntity record) {
        return hyUserInfoMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<HyUserInfoEntity> list) {
        return hyUserInfoMapper.deleteBatchByKeys(list);
    }

}
