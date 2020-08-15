package com.weds.edpf.core.service;

import com.weds.edpf.core.entity.DictInfoEntity;
import com.weds.edpf.core.mapper.DictInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;

/**
 * @Author sxm
 * @Description 字典信息管理
 * @Date 2019-03-07
 */
@Service
public class DictInfoService extends BaseService {

    @Autowired
    private DictInfoMapper dictInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String typeCode, String dicCode) {
        return dictInfoMapper.deleteByPrimaryKey(typeCode, dicCode);
    }

    public int insert(DictInfoEntity record) {
        return dictInfoMapper.insert(record);
    }

    public int insertSelective(DictInfoEntity record) {
        return dictInfoMapper.insertSelective(record);
    }

    public DictInfoEntity selectByPrimaryKey(String typeCode, String dicCode) {
        return dictInfoMapper.selectByPrimaryKey(typeCode, dicCode);
    }

    public int updateByPrimaryKeySelective(DictInfoEntity record) {
        return dictInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DictInfoEntity record) {
        return dictInfoMapper.updateByPrimaryKey(record);
    }

    public List<DictInfoEntity> selectListByEntity(DictInfoEntity record) {
        return dictInfoMapper.selectListByEntity(record);
    }


    public List<DictInfoEntity> selectListByKeys(String keys) {
        return dictInfoMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<DictInfoEntity> list) {
        return dictInfoMapper.deleteBatchByKeys(list);
    }

    public List<DictInfoEntity> selectListByType(List<String> typeCodes) {
        return dictInfoMapper.selectListByType(typeCodes);
    }
}
