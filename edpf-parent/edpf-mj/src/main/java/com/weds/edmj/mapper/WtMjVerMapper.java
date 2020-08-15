package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.WtMjVerEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 配置文件更新的日志管理
 * @Date 2019-07-29
 */
@MyBatisDao
public interface WtMjVerMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(WtMjVerEntity record);

    /**
     */
    int insertBatch(@Param("list") List<WtMjVerEntity> list);

    /**
     */
    int insertSelective(WtMjVerEntity record);

    /**
     */
    WtMjVerEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(WtMjVerEntity record);

    /**
     */
    int updateByPrimaryKey(WtMjVerEntity record);

    /**
     */
    List<WtMjVerEntity> selectListByEntity(WtMjVerEntity record);

    /**
     */
    List<WtMjVerEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<WtMjVerEntity> list);
}