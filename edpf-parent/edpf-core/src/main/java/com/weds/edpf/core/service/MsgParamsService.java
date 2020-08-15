package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.MsgParamsMapper;
import com.weds.edpf.core.entity.MsgParamsEntity;

/**
 * @Author sxm
 * @Description 消息参数管理管理
 * @Date 2019-04-03
 */
@Service
public class MsgParamsService extends BaseService {

    @Autowired
    private MsgParamsMapper msgParamsMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String paramId, String templateId) {
        return msgParamsMapper.deleteByPrimaryKey(paramId, templateId);
    }

    public int insert(MsgParamsEntity record) {
        return msgParamsMapper.insert(record);
    }

    public int insertSelective(MsgParamsEntity record) {
        return msgParamsMapper.insertSelective(record);
    }

    public MsgParamsEntity selectByPrimaryKey(String paramId, String templateId) {
        return msgParamsMapper.selectByPrimaryKey(paramId, templateId);
    }

    public int updateByPrimaryKeySelective(MsgParamsEntity record) {
        return msgParamsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MsgParamsEntity record) {
        return msgParamsMapper.updateByPrimaryKey(record);
    }

    public List<MsgParamsEntity> selectListByEntity(MsgParamsEntity record) {
        return msgParamsMapper.selectListByEntity(record);
    }


    public List<MsgParamsEntity> selectListByKeys(String keys) {
        return msgParamsMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MsgParamsEntity> list) {
        return msgParamsMapper.deleteBatchByKeys(list);
    }
}
