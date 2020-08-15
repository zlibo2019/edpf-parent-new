package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.DoorRealEntity;
import com.weds.edmj.entity.JrealMjCameraEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-31
 */
@MyBatisDao
public interface JrealMjCameraMapper {
    /**
     */
    int deleteByPrimaryKey(Integer jid);

    int deleteByGatebh(String Gatebh);

    int deleteByGatebhAndFx(JrealMjCameraEntity record);

    /**
     */
    int insert(JrealMjCameraEntity record);

    /**
     */
    int insertBatch(@Param("list") List<JrealMjCameraEntity> list);

    /**
     */
    int insertSelective(JrealMjCameraEntity record);

    /**
     */
    JrealMjCameraEntity selectByPrimaryKey(Integer jid);

    /**
     */
    int updateByPrimaryKeySelective(JrealMjCameraEntity record);

    /**
     */
    int updateByPrimaryKey(JrealMjCameraEntity record);

    /**
     */
    List<JrealMjCameraEntity> selectListByEntity(JrealMjCameraEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<JrealMjCameraEntity> list);

    int deleteBatchByGatebh(@Param("list")List<DoorRealEntity> list);
}