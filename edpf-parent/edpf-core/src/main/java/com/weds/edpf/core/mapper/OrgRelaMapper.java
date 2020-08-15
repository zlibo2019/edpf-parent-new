package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.OrgRelaEntity;

/**
 * @Author
 * @Description 机构关系信息管理
 * @Date 2019-09-27
 */
@MyBatisDao
public interface OrgRelaMapper {
    /**
     */
    int deleteByPrimaryKey(String id);

    /**
     */
    int insert(OrgRelaEntity record);

    /**
     */
    int insertSelective(OrgRelaEntity record);

    /**
     */
    OrgRelaEntity selectByPrimaryKey(String id);

    /**
     */
    int updateByPrimaryKeySelective(OrgRelaEntity record);

    /**
     */
    int updateByPrimaryKey(OrgRelaEntity record);
}