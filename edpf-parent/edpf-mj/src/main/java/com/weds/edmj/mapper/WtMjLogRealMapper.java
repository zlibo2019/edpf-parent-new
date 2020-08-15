package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.WtMjLogRealEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 门禁管理的基本日志管理
 * @Date 2019-08-08
 */
@MyBatisDao
public interface WtMjLogRealMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(WtMjLogRealEntity record);

    /**
     */
    int insertBatch(@Param("list") List<WtMjLogRealEntity> list);

    /**
     */
    int insertSelective(WtMjLogRealEntity record);

    /**
     */
    WtMjLogRealEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(WtMjLogRealEntity record);

    /**
     */
    int updateByPrimaryKey(WtMjLogRealEntity record);

    /**
     */
    List<WtMjLogRealEntity> selectListByEntity(WtMjLogRealEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<WtMjLogRealEntity> list);
}