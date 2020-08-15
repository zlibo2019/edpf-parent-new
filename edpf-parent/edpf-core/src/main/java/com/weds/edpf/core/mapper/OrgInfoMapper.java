package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.OrgInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 机构基本信息管理
 * @Date 2019-09-25
 */
@MyBatisDao
public interface OrgInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String orgId);

    /**
     */
    int deleteOrgRela(String orgId);

    /**
     */
    int haveSubOrg(String orgId);

    /**
     */
    int insert(OrgInfoEntity record);

    /**
     */
    int insertSelective(OrgInfoEntity record);

    /**
     */
    OrgInfoEntity selectByPrimaryKey(String orgId);

    /**
     */
    int updateByPrimaryKeySelective(OrgInfoEntity record);

    /**
     */
    int updateByPrimaryKey(OrgInfoEntity record);

    /**
     */
    List<OrgInfoEntity> selectListByEntity(OrgInfoEntity record);

    /**
     */
    List<OrgInfoEntity> selectOrgTree(@Param("parentOrgId") String parentOrgId);
}