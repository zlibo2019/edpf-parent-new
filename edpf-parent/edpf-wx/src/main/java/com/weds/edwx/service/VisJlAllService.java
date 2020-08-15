package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisJlAllMapper;
import com.weds.edwx.entity.VisJlAllEntity;

/**
 * @Author sxm
 * @Description VisJlAll管理
 * @Date 2019-03-20
 */
@Service
public class VisJlAllService extends BaseService {

    @Autowired
    private VisJlAllMapper visJlAllMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long xh) {
        return visJlAllMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisJlAllEntity record) {
        return visJlAllMapper.insert(record);
    }

    public int insertSelective(VisJlAllEntity record) {
        return visJlAllMapper.insertSelective(record);
    }

    public VisJlAllEntity selectByPrimaryKey(Long xh) {
        return visJlAllMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisJlAllEntity record) {
        return visJlAllMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisJlAllEntity record) {
        return visJlAllMapper.updateByPrimaryKey(record);
    }

    public List<VisJlAllEntity> selectListByEntity(VisJlAllEntity record) {
        return visJlAllMapper.selectListByEntity(record);
    }


    public List<VisJlAllEntity> selectListByKeys(String keys) {
        return visJlAllMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisJlAllEntity> list) {
        return visJlAllMapper.deleteBatchByKeys(list);
    }
}
