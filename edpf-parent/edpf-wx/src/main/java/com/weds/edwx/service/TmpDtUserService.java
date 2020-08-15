package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.TmpDtUserMapper;
import com.weds.edwx.entity.TmpDtUserEntity;

/**
 * @Author
 * @Description TmpDtUser管理
 * @Date 2019-10-24
 */
@Service
public class TmpDtUserService extends BaseService {

    @Resource
    private TmpDtUserMapper tmpDtUserMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String zh) {
        return tmpDtUserMapper.deleteByPrimaryKey(zh);
    }

    public int insert(TmpDtUserEntity record) {
        return tmpDtUserMapper.insert(record);
    }

    public int insertSelective(TmpDtUserEntity record) {
        return tmpDtUserMapper.insertSelective(record);
    }

    public TmpDtUserEntity selectByPrimaryKey(String zh) {
        return tmpDtUserMapper.selectByPrimaryKey(zh);
    }

    public int updateByPrimaryKeySelective(TmpDtUserEntity record) {
        return tmpDtUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TmpDtUserEntity record) {
        return tmpDtUserMapper.updateByPrimaryKey(record);
    }

    public List<TmpDtUserEntity> selectListByEntity(TmpDtUserEntity record) {
        return tmpDtUserMapper.selectListByEntity(record);
    }

    public int insertBatch(List<TmpDtUserEntity> list) {
        return tmpDtUserMapper.insertBatch(list);
    }
}
