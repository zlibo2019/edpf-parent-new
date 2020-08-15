package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.MsgFunctionMapper;
import com.weds.edpf.core.entity.MsgFunctionEntity;

/**
 * @Author sxm
 * @Description 消息函数管理管理
 * @Date 2019-04-03
 */
@Service
public class MsgFunctionService extends BaseService {

    @Autowired
    private MsgFunctionMapper msgFunctionMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String functionId) {
        return msgFunctionMapper.deleteByPrimaryKey(functionId);
    }

    public int insert(MsgFunctionEntity record) {
        return msgFunctionMapper.insert(record);
    }

    public int insertSelective(MsgFunctionEntity record) {
        return msgFunctionMapper.insertSelective(record);
    }

    public MsgFunctionEntity selectByPrimaryKey(String functionId) {
        return msgFunctionMapper.selectByPrimaryKey(functionId);
    }

    public int updateByPrimaryKeySelective(MsgFunctionEntity record) {
        return msgFunctionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MsgFunctionEntity record) {
        return msgFunctionMapper.updateByPrimaryKey(record);
    }

    public List<MsgFunctionEntity> selectListByEntity(MsgFunctionEntity record) {
        return msgFunctionMapper.selectListByEntity(record);
    }


    public List<MsgFunctionEntity> selectListByKeys(String keys) {
        return msgFunctionMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MsgFunctionEntity> list) {
        return msgFunctionMapper.deleteBatchByKeys(list);
    }
}
