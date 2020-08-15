package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.WtModuleEntity;

/**
 * @Author
 * @Description 管理
 * @Date 2019-10-11
 */
@MyBatisDao
public interface WtModuleMapper {
    /**
     */
    int deleteByPrimaryKey(String moduleId);

    /**
     */
    int insert(WtModuleEntity record);

    /**
     */
    int insertSelective(WtModuleEntity record);

    /**
     */
    WtModuleEntity selectByPrimaryKey(String moduleId);

    /**
     */
    int updateByPrimaryKeySelective(WtModuleEntity record);

    /**
     */
    int updateByPrimaryKey(WtModuleEntity record);
}