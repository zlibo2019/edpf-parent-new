package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.WtMjVerMapper;
import com.weds.edmj.entity.WtMjVerEntity;

/**
 * @Author sxm
 * @Description 配置文件更新的日志管理
 * @Date 2019-07-29
 */
@Service
public class WtMjVerService extends BaseService {

    @Autowired
    private WtMjVerMapper wtMjVerMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return wtMjVerMapper.deleteByPrimaryKey(xh);
    }

    public int insert(WtMjVerEntity record) {
        return wtMjVerMapper.insert(record);
    }

    public int insertSelective(WtMjVerEntity record) {
        return wtMjVerMapper.insertSelective(record);
    }

    public WtMjVerEntity selectByPrimaryKey(Integer xh) {
        return wtMjVerMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(WtMjVerEntity record) {
        return wtMjVerMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(WtMjVerEntity record) {
        return wtMjVerMapper.updateByPrimaryKey(record);
    }

    public List<WtMjVerEntity> selectListByEntity(WtMjVerEntity record) {
        return wtMjVerMapper.selectListByEntity(record);
    }


    public List<WtMjVerEntity> selectListByKeys(String keys) {
        return wtMjVerMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<WtMjVerEntity> list) {
        return wtMjVerMapper.deleteBatchByKeys(list);
    }

    public int insertBatch(List<WtMjVerEntity> list) {
        return wtMjVerMapper.insertBatch(list);
    }
}
