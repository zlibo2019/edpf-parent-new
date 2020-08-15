package com.weds.edwx.mapper;

import com.weds.edwx.entity.TtSexEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-04-19
 */
@MyBatisDao
public interface TtSexMapper {
    /**
     */
    int deleteByPrimaryKey(Short ttOrder);

    /**
     */
    int insert(TtSexEntity record);

    /**
     */
    int insertSelective(TtSexEntity record);

    /**
     */
    TtSexEntity selectByPrimaryKey(Short ttOrder);

    /**
     */
    int updateByPrimaryKeySelective(TtSexEntity record);

    /**
     */
    int updateByPrimaryKey(TtSexEntity record);

    /**
     */
    List<TtSexEntity> selectListByEntity(TtSexEntity record);

    /**
     */
    List<TtSexEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<TtSexEntity> list);
}