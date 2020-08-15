package com.weds.edmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edmj.mapper.WtMjMobileMapper;
import com.weds.edmj.entity.WtMjMobileEntity;

/**
 * @Author sxm
 * @Description 配置手机开门人员管理
 * @Date 2019-08-07
 */
@Service
public class WtMjMobileService extends BaseService {

    @Autowired
    private WtMjMobileMapper wtMjMobileMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return wtMjMobileMapper.deleteByPrimaryKey(xh);
    }

    public int insert(WtMjMobileEntity record) {
        return wtMjMobileMapper.insert(record);
    }

    public int insertSelective(WtMjMobileEntity record) {
        return wtMjMobileMapper.insertSelective(record);
    }

    public WtMjMobileEntity selectByPrimaryKey(Integer xh) {
        return wtMjMobileMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(WtMjMobileEntity record) {
        return wtMjMobileMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(WtMjMobileEntity record) {
        return wtMjMobileMapper.updateByPrimaryKey(record);
    }

    public List<WtMjMobileEntity> selectListByEntity(WtMjMobileEntity record) {
        return wtMjMobileMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<WtMjMobileEntity> list) {
        return wtMjMobileMapper.deleteBatchByKeys(list);
    }

}
