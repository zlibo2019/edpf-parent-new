package com.weds.edwx.mapper;

import com.weds.edwx.entity.MeetEntity;
import com.weds.edwx.entity.MeetMdEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-22
 */
@MyBatisDao
public interface MeetMdMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     * 插入会议人员列表
     */
    int insert(MeetEntity record);

    /**
     */
    int insertSelective(MeetMdEntity record);

    /**
     */
    MeetMdEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(MeetMdEntity record);

    /**
     */
    int updateByPrimaryKey(MeetMdEntity record);

    /**
     */
    List<MeetMdEntity> selectListByEntity(MeetMdEntity record);

    /**
     * 根据会议编号查出所有与会人员
     * @param meetBh
     * @return
     */
    List<MeetMdEntity> selectUserListByBh(Integer meetBh);
}