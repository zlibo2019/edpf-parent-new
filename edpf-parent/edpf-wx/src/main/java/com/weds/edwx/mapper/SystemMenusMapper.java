package com.weds.edwx.mapper;

import com.weds.edwx.entity.SystemMenusEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 系统功能管理管理
 * @Date 2018-11-24
 */
@MyBatisDao
public interface SystemMenusMapper {
    /**
     */
    SystemMenusEntity selectByPrimaryKey(@Param("companyId") String companyId, @Param("menuId") String menuId);

    /**
     */
    List<SystemMenusEntity> selectListByEntity(SystemMenusEntity record);
}