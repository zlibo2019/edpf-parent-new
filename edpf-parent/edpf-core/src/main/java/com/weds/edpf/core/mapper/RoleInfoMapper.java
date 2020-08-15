package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.RoleInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @Description 角色信息管理
 * @Date 2019-03-07
 */
@MyBatisDao
public interface RoleInfoMapper {
    /**
     */
    int deleteByPrimaryKey(String roleId);

    /**
     */
    int insert(RoleInfoEntity record);

    /**
     */
    int insertSelective(RoleInfoEntity record);

    /**
     */
    RoleInfoEntity selectByPrimaryKey(String roleId);

    /**
     */
    int updateByPrimaryKeySelective(RoleInfoEntity record);

    /**
     */
    int updateByPrimaryKey(RoleInfoEntity record);

    /**
     */
    List<RoleInfoEntity> selectListByEntity(RoleInfoEntity record);

    /**
     */
    List<RoleInfoEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RoleInfoEntity> list);
}