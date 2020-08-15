package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisThingMapper;
import com.weds.edwx.entity.VisThingEntity;

/**
 * @Author sxm
 * @Description VisThing管理
 * @Date 2019-03-20
 */
@Service
public class VisThingService extends BaseService {

    @Autowired
    private VisThingMapper visThingMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return visThingMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisThingEntity record) {
        return visThingMapper.insert(record);
    }

    public int insertSelective(VisThingEntity record) {
        return visThingMapper.insertSelective(record);
    }

    public VisThingEntity selectByPrimaryKey(Integer xh) {
        return visThingMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisThingEntity record) {
        return visThingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisThingEntity record) {
        return visThingMapper.updateByPrimaryKey(record);
    }

    public List<VisThingEntity> selectListByEntity(VisThingEntity record) {
        return visThingMapper.selectListByEntity(record);
    }


    public List<VisThingEntity> selectListByKeys(String keys) {
        return visThingMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisThingEntity> list) {
        return visThingMapper.deleteBatchByKeys(list);
    }
}
