package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisRegionMapper;
import com.weds.edwx.entity.VisRegionEntity;

/**
 * @Author sxm
 * @Description VisRegion管理
 * @Date 2019-03-20
 */
@Service
public class VisRegionService extends BaseService {

    @Autowired
    private VisRegionMapper visRegionMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return visRegionMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisRegionEntity record) {
        return visRegionMapper.insert(record);
    }

    public int insertSelective(VisRegionEntity record) {
        return visRegionMapper.insertSelective(record);
    }

    public VisRegionEntity selectByPrimaryKey(Integer xh) {
        return visRegionMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisRegionEntity record) {
        return visRegionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisRegionEntity record) {
        return visRegionMapper.updateByPrimaryKey(record);
    }

    public List<VisRegionEntity> selectListByEntity(VisRegionEntity record) {
        return visRegionMapper.selectListByEntity(record);
    }

    public List<VisRegionEntity> selectListByBh(String bh) {
        return visRegionMapper.selectListByBh(bh);
    }

    public List<VisRegionEntity> selectListByKeys(String keys) {
        return visRegionMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisRegionEntity> list) {
        return visRegionMapper.deleteBatchByKeys(list);
    }
}
