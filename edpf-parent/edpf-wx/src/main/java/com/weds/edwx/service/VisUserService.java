package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisUserMapper;
import com.weds.edwx.entity.VisUserEntity;

/**
 * @Author sxm
 * @Description VisUser管理
 * @Date 2019-03-20
 */
@Service
public class VisUserService extends BaseService {

    @Autowired
    private VisUserMapper visUserMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String openId) {
        return visUserMapper.deleteByPrimaryKey(openId);
    }

    public int insert(VisUserEntity record) {
        return visUserMapper.insert(record);
    }

    public int insertSelective(VisUserEntity record) {
        return visUserMapper.insertSelective(record);
    }

    public VisUserEntity selectByPrimaryKey(String openId) {
        return visUserMapper.selectByPrimaryKey(openId);
    }

    public VisUserEntity selectByVisSerial(Long visSerial) {
        return visUserMapper.selectByVisSerial(visSerial);
    }

    public VisUserEntity selectByCardId(String visId) {
        return visUserMapper.selectByCardId(visId);
    }

    public int updateByPrimaryKeySelective(VisUserEntity record) {
        return visUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByIdSelective(VisUserEntity record) {
        return visUserMapper.updateByIdSelective(record);
    }

    public int updateByPrimaryKey(VisUserEntity record) {
        return visUserMapper.updateByPrimaryKey(record);
    }

    public List<VisUserEntity> selectListByEntity(VisUserEntity record) {
        return visUserMapper.selectListByEntity(record);
    }

    public List<VisUserEntity> selectListByKeys(String keys) {
        return visUserMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisUserEntity> list) {
        return visUserMapper.deleteBatchByKeys(list);
    }
}
