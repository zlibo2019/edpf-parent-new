package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.VisDoorKeeperAreaMapper;
import com.weds.edwx.entity.VisDoorKeeperAreaEntity;

/**
 * @Author sxm
 * @Description 门卫用户区域管理管理
 * @Date 2019-04-17
 */
@Service
public class VisDoorKeeperAreaService extends BaseService {

    @Autowired
    private VisDoorKeeperAreaMapper visDoorKeeperAreaMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String userNo, String areaNo) {
        return visDoorKeeperAreaMapper.deleteByPrimaryKey(userNo, areaNo);
    }

    public int insert(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.insert(record);
    }

    public int insertSelective(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.insertSelective(record);
    }

    public VisDoorKeeperAreaEntity selectByPrimaryKey(String userNo, String areaNo) {
        return visDoorKeeperAreaMapper.selectByPrimaryKey(userNo, areaNo);
    }

    public int updateByPrimaryKeySelective(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.updateByPrimaryKey(record);
    }

    public List<VisDoorKeeperAreaEntity> selectListByEntity(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.selectListByEntity(record);
    }

    public List<VisDoorKeeperAreaEntity> selectAllListByEntity(VisDoorKeeperAreaEntity record) {
        return visDoorKeeperAreaMapper.selectAllListByEntity(record);
    }

    public List<VisDoorKeeperAreaEntity> selectListByKeys(String keys) {
        return visDoorKeeperAreaMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisDoorKeeperAreaEntity> list) {
        return visDoorKeeperAreaMapper.deleteBatchByKeys(list);
    }
}
