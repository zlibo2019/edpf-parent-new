package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.RightTempEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-08-13
 */
@MyBatisDao
public interface RightTempMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insertBatch(RightTempEntity record);

    int insertUpdate4KqBatch(RightTempEntity record);

    int insertUpdate1MjBatch(RightTempEntity record);

    /**
     */
    int insertSelective(RightTempEntity record);

    /**
     */
    RightTempEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(RightTempEntity record);

    /**
     */
    int updateByPrimaryKey(RightTempEntity record);

    /**
     */
    List<RightTempEntity> selectListByEntity(RightTempEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<RightTempEntity> list);

    int insertUpdateDelMjBatch(@Param("list") List<RightTempEntity> list);

    int insertUpdateDelKqBatch(@Param("list") List<RightTempEntity> list);

}