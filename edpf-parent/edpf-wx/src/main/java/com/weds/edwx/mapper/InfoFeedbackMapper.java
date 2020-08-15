package com.weds.edwx.mapper;

import com.weds.edwx.entity.InfoFeedbackEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-14
 */
@MyBatisDao
public interface InfoFeedbackMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(InfoFeedbackEntity record);

    /**
     */
    int insertSelective(InfoFeedbackEntity record);

    /**
     */
    InfoFeedbackEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(InfoFeedbackEntity record);

    /**
     */
    int updateByPrimaryKey(InfoFeedbackEntity record);

    /**
     */
    List<InfoFeedbackEntity> selectListByEntity(InfoFeedbackEntity record);
}