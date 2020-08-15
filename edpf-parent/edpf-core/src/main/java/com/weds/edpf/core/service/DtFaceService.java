package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.DtFaceMapper;
import com.weds.edpf.core.entity.DtFaceEntity;

/**
 * @Author sxm
 * @Description DtFace管理
 * @Date 2019-05-29
 */
@Service
public class DtFaceService extends BaseService {

    @Autowired
    private DtFaceMapper dtFaceMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Long userSerial) {
        return dtFaceMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(DtFaceEntity record) {
        return dtFaceMapper.insert(record);
    }

    public int insertSelective(DtFaceEntity record) {
        return dtFaceMapper.insertSelective(record);
    }

    public DtFaceEntity selectByPrimaryKey(Long userSerial) {
        return dtFaceMapper.selectByPrimaryKey(userSerial);
    }

    public int updateByPrimaryKeySelective(DtFaceEntity record) {
        return dtFaceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DtFaceEntity record) {
        return dtFaceMapper.updateByPrimaryKey(record);
    }


}
