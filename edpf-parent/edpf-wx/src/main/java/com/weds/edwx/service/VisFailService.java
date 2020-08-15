package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisFailMapper;
import com.weds.edwx.entity.VisFailEntity;

/**
 * @Author sxm
 * @Description VisFail管理
 * @Date 2019-03-20
 */
@Service
public class VisFailService extends BaseService {

    @Autowired
    private VisFailMapper visFailMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return visFailMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisFailEntity record) {
        return visFailMapper.insert(record);
    }

    public int insertSelective(VisFailEntity record) {
        return visFailMapper.insertSelective(record);
    }

    public VisFailEntity selectByPrimaryKey(Integer xh) {
        return visFailMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisFailEntity record) {
        return visFailMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisFailEntity record) {
        return visFailMapper.updateByPrimaryKey(record);
    }

    public List<VisFailEntity> selectListByEntity(VisFailEntity record) {
        return visFailMapper.selectListByEntity(record);
    }


    public List<VisFailEntity> selectListByKeys(String keys) {
        return visFailMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisFailEntity> list) {
        return visFailMapper.deleteBatchByKeys(list);
    }
}
