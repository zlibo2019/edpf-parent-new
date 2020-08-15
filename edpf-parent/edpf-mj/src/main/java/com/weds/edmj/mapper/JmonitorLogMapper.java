package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.JmonitorLogEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-08-14
 */
@MyBatisDao
public interface JmonitorLogMapper {
    /**
     */
    int deleteByPrimaryKey(Integer jid);

    /**
     */
    int insert(JmonitorLogEntity record);

    /**
     */
    int insertBatch(@Param("list") List<JmonitorLogEntity> list);

    /**
     */
    int insertSelective(JmonitorLogEntity record);

    /**
     */
    JmonitorLogEntity selectByPrimaryKey(Integer jid);

    /**
     */
    int updateByPrimaryKeySelective(JmonitorLogEntity record);

    /**
     */
    int updateByPrimaryKey(JmonitorLogEntity record);

    /**
     */
    List<JmonitorLogEntity> selectListByEntity(JmonitorLogEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<JmonitorLogEntity> list);
}