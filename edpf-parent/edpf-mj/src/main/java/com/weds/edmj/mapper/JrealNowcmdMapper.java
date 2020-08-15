package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.JrealNowcmdEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-07-31
 */
@MyBatisDao
public interface JrealNowcmdMapper {
    /**
     */
    int insert(JrealNowcmdEntity record);

    /**
     */
    int insertBatch(@Param("list") List<JrealNowcmdEntity> list);

    /**
     */
    int insertSelective(JrealNowcmdEntity record);

    int insertMjDoorOperateBatch(JrealNowcmdEntity record);

    int insertKqDoorOperateBatch(JrealNowcmdEntity record);

    int selectForceCount(JrealNowcmdEntity record);

    /**
     */
    List<JrealNowcmdEntity> selectListByEntity(JrealNowcmdEntity record);

    /**
     */
    List<JrealNowcmdEntity> selectListByKeys(@Param("keys") String keys);

}