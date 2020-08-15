package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.WtMjMobileEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 配置手机开门人员管理
 * @Date 2019-08-07
 */
@MyBatisDao
public interface WtMjMobileMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(WtMjMobileEntity record);

    /**
     */
    int insertSelective(WtMjMobileEntity record);

    /**
     */
    WtMjMobileEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(WtMjMobileEntity record);

    /**
     */
    int updateByPrimaryKey(WtMjMobileEntity record);

    /**
     */
    List<WtMjMobileEntity> selectListByEntity(WtMjMobileEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<WtMjMobileEntity> list);
}