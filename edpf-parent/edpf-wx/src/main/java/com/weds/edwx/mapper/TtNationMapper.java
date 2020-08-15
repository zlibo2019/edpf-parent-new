package com.weds.edwx.mapper;

import com.weds.edwx.entity.TtNationEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-04-19
 */
@MyBatisDao
public interface TtNationMapper {
    /**
     */
    int deleteByPrimaryKey(Short ttOrder);

    /**
     */
    int insert(TtNationEntity record);

    /**
     */
    int insertSelective(TtNationEntity record);

    /**
     */
    TtNationEntity selectByPrimaryKey(Short ttOrder);

    /**
     */
    int updateByPrimaryKeySelective(TtNationEntity record);

    /**
     */
    int updateByPrimaryKey(TtNationEntity record);

    /**
     */
    List<TtNationEntity> selectListByEntity(TtNationEntity record);

    /**
     */
    List<TtNationEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<TtNationEntity> list);
}