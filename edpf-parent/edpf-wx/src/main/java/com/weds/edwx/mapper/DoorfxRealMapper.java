package com.weds.edwx.mapper;

import com.weds.edwx.entity.DoorfxRealEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-22
 */
@MyBatisDao
public interface DoorfxRealMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("gateBh") String gateBh, @Param("xh") Integer xh);

    /**
     */
    int insert(DoorfxRealEntity record);

    /**
     */
    int insertSelective(DoorfxRealEntity record);

    /**
     */
    DoorfxRealEntity selectByPrimaryKey(@Param("gateBh") String gateBh);

    /**
     */
    int updateByPrimaryKeySelective(DoorfxRealEntity record);

    /**
     */
    int updateByPrimaryKey(DoorfxRealEntity record);

    /**
     */
    List<DoorfxRealEntity> selectListByEntity(DoorfxRealEntity record);
}