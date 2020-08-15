package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.MeetSpEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-11-28
 */
@MyBatisDao
public interface MeetSpMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(MeetSpEntity record);

    /**
     */
    int insertBatch(@Param("list") List<MeetSpEntity> list);

    /**
     */
    int insertSelective(MeetSpEntity record);

    /**
     */
    MeetSpEntity selectByPrimaryKey(Integer xh);

    /**
     */
    MeetSpEntity selectNextApprover(MeetSpEntity record);

    /**
     */
    int updateByPrimaryKeySelective(MeetSpEntity record);

    /**
     */
    int approveMeeting(MeetSpEntity record);

    /**
     */
    int updateByPrimaryKey(MeetSpEntity record);


    int isMeetApproveFinished(@Param("meetBh") Integer meetBh);

    /**
     */
    List<MeetSpEntity> selectListByEntity(MeetSpEntity record);
}