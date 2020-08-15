package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.WtPublicEntity;

/**
 * @Author
 * @Description 管理
 * @Date 2019-05-25
 */
@MyBatisDao
public interface WtPublicMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(WtPublicEntity record);

    /**
     */
    int insertSelective(WtPublicEntity record);

    /**
     */
    WtPublicEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(WtPublicEntity record);

    /**
     */
    int updateByPrimaryKey(WtPublicEntity record);
}