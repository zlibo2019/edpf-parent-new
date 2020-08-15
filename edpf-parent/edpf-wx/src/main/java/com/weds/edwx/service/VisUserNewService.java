package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisUserNewMapper;
import com.weds.edwx.entity.VisUserNewEntity;

/**
 * @Author sxm
 * @Description VisUserNew管理
 * @Date 2019-05-21
 */
@Service
public class VisUserNewService extends BaseService {

    @Autowired
    private VisUserNewMapper visUserNewMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long visSerial) {
        return visUserNewMapper.deleteByPrimaryKey(visSerial);
    }

    public int insert(VisUserNewEntity record) {
        return visUserNewMapper.insert(record);
    }

    public int insertSelective(VisUserNewEntity record) {
        return visUserNewMapper.insertSelective(record);
    }

    public VisUserNewEntity selectByPrimaryKey(Long visSerial) {
        return visUserNewMapper.selectByPrimaryKey(visSerial);
    }

    public VisUserNewEntity selectByOpenId(String openId) {
        return visUserNewMapper.selectByOpenId(openId);
    }

    public VisUserNewEntity selectByVisId(String visId) {
        return visUserNewMapper.selectByVisId(visId);
    }

    public List<VisUserNewEntity> selectByVisIdOrTel(String param) {
        return visUserNewMapper.selectByVisIdOrTel(param);
    }

    public VisUserNewEntity selectByVisTelephone(String visTelephone) {
        return visUserNewMapper.selectByVisTelephone(visTelephone);
    }


    public int updateByPrimaryKeySelective(VisUserNewEntity record) {
        return visUserNewMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisUserNewEntity record) {
        return visUserNewMapper.updateByPrimaryKey(record);
    }

    public List<VisUserNewEntity> selectListByEntity(VisUserNewEntity record) {
        return visUserNewMapper.selectListByEntity(record);
    }

    public List<VisUserNewEntity> selectListByKeys(String keys) {
        return visUserNewMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisUserNewEntity> list) {
        return visUserNewMapper.deleteBatchByKeys(list);
    }
}
