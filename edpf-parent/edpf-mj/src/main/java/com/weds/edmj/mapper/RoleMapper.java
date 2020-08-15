package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.RoleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-08-14
 */
@MyBatisDao
public interface RoleMapper {
    /**
     */
    int insert(RoleEntity record);

    /**
     */
    int insertBatch(@Param("list") List<RoleEntity> list);

    /**
     */
    int insertSelective(RoleEntity record);

    /**
     */
    List<RoleEntity> selectListByEntity(RoleEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RoleEntity> list);
}