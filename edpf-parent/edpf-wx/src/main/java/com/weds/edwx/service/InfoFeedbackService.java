package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.InfoFeedbackMapper;
import com.weds.edwx.entity.InfoFeedbackEntity;

/**
 * @Author sxm
 * @Description InfoFeedback管理
 * @Date 2018-11-14
 */
@Service
public class InfoFeedbackService extends BaseService {

    @Autowired
    private InfoFeedbackMapper infoFeedbackMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return infoFeedbackMapper.deleteByPrimaryKey(xh);
    }

    public int insert(InfoFeedbackEntity record) {
        return infoFeedbackMapper.insert(record);
    }

    public int insertSelective(InfoFeedbackEntity record) {
        return infoFeedbackMapper.insertSelective(record);
    }

    public InfoFeedbackEntity selectByPrimaryKey(Integer xh) {
        return infoFeedbackMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(InfoFeedbackEntity record) {
        return infoFeedbackMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(InfoFeedbackEntity record) {
        return infoFeedbackMapper.updateByPrimaryKey(record);
    }

    public List<InfoFeedbackEntity> selectListByEntity(InfoFeedbackEntity record) {
        return infoFeedbackMapper.selectListByEntity(record);
    }
}
