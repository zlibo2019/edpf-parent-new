package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.RoleFunctionEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 角色功能关系管理
 * @Date 2019-03-08
 */
@MyBatisDao
public interface RoleFunctionMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("functionId") String functionId);

    /**
     */
    int insert(RoleFunctionEntity record);

    /**
     */
    int insertSelective(RoleFunctionEntity record);

    /**
     */
    RoleFunctionEntity selectByPrimaryKey(@Param("roleId") String roleId, @Param("functionId") String functionId);

    /**
     */
    int updateByPrimaryKeySelective(RoleFunctionEntity record);

    /**
     */
    int updateByPrimaryKey(RoleFunctionEntity record);

    /**
     */
    List<RoleFunctionEntity> selectListByEntity(RoleFunctionEntity record);

    /**
     */
    List<RoleFunctionEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RoleFunctionEntity> list);

    /**
     */
    int deleteByRoleId(@Param("roleId") String roleId);
}