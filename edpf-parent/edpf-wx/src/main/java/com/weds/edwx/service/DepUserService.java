package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.DepUserMapper;
import com.weds.edwx.entity.DepUserEntity;

/**
 * @Author
 * @Description DepUser管理
 * @Date 2019-09-09
 */
@Service
public class DepUserService extends BaseService {

    @Resource
    private DepUserMapper depUserMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return depUserMapper.deleteByPrimaryKey(xh);
    }

    public int insert(DepUserEntity record) {
        return depUserMapper.insert(record);
    }

    public int insertSelective(DepUserEntity record) {
        return depUserMapper.insertSelective(record);
    }

    public DepUserEntity selectByPrimaryKey(Integer xh) {
        return depUserMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(DepUserEntity record) {
        return depUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DepUserEntity record) {
        return depUserMapper.updateByPrimaryKey(record);
    }

    public List<DepUserEntity> selectListByEntity(DepUserEntity record) {
        return depUserMapper.selectListByEntity(record);
    }

    public List<DepUserEntity> selectListByCondition(DepUserEntity record) {
        return depUserMapper.selectListByCondition(record);
    }

    public int deleteBatchByKeys(List<DepUserEntity> list) {
        return depUserMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<DepUserEntity> list) {
        return depUserMapper.insertBatch(list);
    }
}
