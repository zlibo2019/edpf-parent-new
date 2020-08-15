package com.weds.edwx.mapper;

import com.weds.edwx.entity.MsgSendEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-19
 */
@MyBatisDao
public interface MsgSendMapper {
    /**
     */
    int deleteByPrimaryKey(Long id);

    /**
     */
    int insert(MsgSendEntity record);

    /**
     */
    int insertSelective(MsgSendEntity record);

    /**
     */
    MsgSendEntity selectByPrimaryKey(Long id);

    /**
     */
    int updateByPrimaryKeySelective(MsgSendEntity record);

    /**
     */
    int updateByPrimaryKey(MsgSendEntity record);

    /**
     */
    List<MsgSendEntity> selectListByEntity(MsgSendEntity record);

    /**
     */
    List<MsgSendEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<MsgSendEntity> list);

    /**
     */
    List<MsgSendEntity> selectMsgList();

    List<MsgSendEntity> selectMsgListYun();
}