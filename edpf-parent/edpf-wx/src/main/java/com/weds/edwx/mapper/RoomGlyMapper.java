package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.RoomGlyEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-11-28
 */
@MyBatisDao
public interface RoomGlyMapper {
    /**
     */
    int insert(RoomGlyEntity record);

    /**
     */
    int insertSelective(RoomGlyEntity record);

    /**
     */
    List<RoomGlyEntity> selectListByEntity(RoomGlyEntity record);
}