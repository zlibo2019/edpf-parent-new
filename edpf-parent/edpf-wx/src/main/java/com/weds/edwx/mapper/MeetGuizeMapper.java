package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.MeetGuizeEntity;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-12-02
 */
@MyBatisDao
public interface MeetGuizeMapper {
    /**
     */
    int deleteByPrimaryKey(Integer meetBh);

    /**
     */
    int insert(MeetGuizeEntity record);

    /**
     */
    int insertSelective(MeetGuizeEntity record);

    /**
     */
    MeetGuizeEntity selectByPrimaryKey(Integer meetBh);

    /**
     */
    int updateByPrimaryKeySelective(MeetGuizeEntity record);

    /**
     */
    int updateByPrimaryKey(MeetGuizeEntity record);

    /**
     */
    List<MeetGuizeEntity> selectListByEntity(MeetGuizeEntity record);
}