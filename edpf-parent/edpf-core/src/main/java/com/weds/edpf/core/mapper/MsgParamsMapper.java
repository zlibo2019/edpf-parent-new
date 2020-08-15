package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.MsgParamsEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 消息参数管理管理
 * @Date 2019-04-03
 */
@MyBatisDao
public interface MsgParamsMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("paramId") String paramId, @Param("templateId") String templateId);

    /**
     */
    int insert(MsgParamsEntity record);

    /**
     */
    int insertSelective(MsgParamsEntity record);

    /**
     */
    MsgParamsEntity selectByPrimaryKey(@Param("paramId") String paramId, @Param("templateId") String templateId);

    /**
     */
    int updateByPrimaryKeySelective(MsgParamsEntity record);

    /**
     */
    int updateByPrimaryKey(MsgParamsEntity record);

    /**
     */
    List<MsgParamsEntity> selectListByEntity(MsgParamsEntity record);

    /**
     */
    List<MsgParamsEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MsgParamsEntity> list);
}