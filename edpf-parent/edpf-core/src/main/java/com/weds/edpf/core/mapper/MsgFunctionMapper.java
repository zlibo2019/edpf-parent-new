package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.MsgFunctionEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 消息函数管理管理
 * @Date 2019-04-03
 */
@MyBatisDao
public interface MsgFunctionMapper {
    /**
     */
    int deleteByPrimaryKey(String functionId);

    /**
     */
    int insert(MsgFunctionEntity record);

    /**
     */
    int insertSelective(MsgFunctionEntity record);

    /**
     */
    MsgFunctionEntity selectByPrimaryKey(String functionId);

    /**
     */
    int updateByPrimaryKeySelective(MsgFunctionEntity record);

    /**
     */
    int updateByPrimaryKey(MsgFunctionEntity record);

    /**
     */
    List<MsgFunctionEntity> selectListByEntity(MsgFunctionEntity record);

    /**
     */
    List<MsgFunctionEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MsgFunctionEntity> list);
}