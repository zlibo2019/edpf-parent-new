package com.weds.edpf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.MsgTemplateMapper;
import com.weds.edpf.core.entity.MsgTemplateEntity;

/**
 * @Author sxm
 * @Description 消息模板管理管理
 * @Date 2019-04-03
 */
@Service
public class MsgTemplateService extends BaseService {

    @Autowired
    private MsgTemplateMapper msgTemplateMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String templateId, String msgType) {
        return msgTemplateMapper.deleteByPrimaryKey(templateId, msgType);
    }

    public int insert(MsgTemplateEntity record) {
        return msgTemplateMapper.insert(record);
    }

    public int insertSelective(MsgTemplateEntity record) {
        return msgTemplateMapper.insertSelective(record);
    }

    public MsgTemplateEntity selectByPrimaryKey(String templateId, String msgType) {
        return msgTemplateMapper.selectByPrimaryKey(templateId, msgType);
    }

    public int updateByPrimaryKeySelective(MsgTemplateEntity record) {
        return msgTemplateMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MsgTemplateEntity record) {
        return msgTemplateMapper.updateByPrimaryKey(record);
    }

    public List<MsgTemplateEntity> selectListByEntity(MsgTemplateEntity record) {
        return msgTemplateMapper.selectListByEntity(record);
    }


    public List<MsgTemplateEntity> selectListByKeys(String keys) {
        return msgTemplateMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MsgTemplateEntity> list) {
        return msgTemplateMapper.deleteBatchByKeys(list);
    }
}
