package com.weds.edpf.core.service;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.entity.AcDepEntity;
import com.weds.edpf.core.mapper.AcDepMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description AcDep管理
 * @Date 2019-10-17
 */
@Service
public class AcDepService extends BaseService {

    @Resource
    private AcDepMapper acDepMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer depSerial) {
        return acDepMapper.deleteByPrimaryKey(depSerial);
    }

    public int insert(AcDepEntity record) {
        return acDepMapper.insert(record);
    }

    public int insertSelective(AcDepEntity record) {
        return acDepMapper.insertSelective(record);
    }

    public AcDepEntity selectByPrimaryKey(Integer depSerial) {
        return acDepMapper.selectByPrimaryKey(depSerial);
    }

    public int updateByPrimaryKeySelective(AcDepEntity record) {
        return acDepMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AcDepEntity record) {
        return acDepMapper.updateByPrimaryKey(record);
    }

    public List<AcDepEntity> selectListByEntity(AcDepEntity record) {
        return acDepMapper.selectListByEntity(record);
    }

    public List<AcDepEntity> selectDinePlace() {
        return acDepMapper.selectDinePlace();
    }

    public int deleteBatchByKeys(List<AcDepEntity> list) {
        return acDepMapper.deleteBatchByKeys(list);
    }
}
