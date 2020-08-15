package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.XfMenuJlEntity;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-11-27
 */
@MyBatisDao
public interface XfMenuJlMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(XfMenuJlEntity record);

    /**
     */
    int insertSelective(XfMenuJlEntity record);

    /**
     */
    XfMenuJlEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(XfMenuJlEntity record);

    /**
     */
    int updateByPrimaryKey(XfMenuJlEntity record);

    /**
     */
    List<XfMenuJlEntity> selectListByEntity(XfMenuJlEntity record);
}