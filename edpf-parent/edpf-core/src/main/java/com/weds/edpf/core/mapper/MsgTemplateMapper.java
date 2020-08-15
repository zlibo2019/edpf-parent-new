package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.MsgTemplateEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 消息模板管理管理
 * @Date 2019-04-03
 */
@MyBatisDao
public interface MsgTemplateMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("templateId") String templateId, @Param("msgType") String msgType);

    /**
     */
    int insert(MsgTemplateEntity record);

    /**
     */
    int insertSelective(MsgTemplateEntity record);

    /**
     */
    MsgTemplateEntity selectByPrimaryKey(@Param("templateId") String templateId, @Param("msgType") String msgType);

    /**
     */
    int updateByPrimaryKeySelective(MsgTemplateEntity record);

    /**
     */
    int updateByPrimaryKey(MsgTemplateEntity record);

    /**
     */
    List<MsgTemplateEntity> selectListByEntity(MsgTemplateEntity record);

    /**
     */
    List<MsgTemplateEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MsgTemplateEntity> list);
}