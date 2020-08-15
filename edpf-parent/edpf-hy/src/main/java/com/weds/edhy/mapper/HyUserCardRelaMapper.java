package com.weds.edhy.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edhy.entity.HyUserCardRelaEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 会员与卡片关系管理
 * @Date 2019-10-11
 */
@MyBatisDao
public interface HyUserCardRelaMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("cardId") String cardId);

    /**
     */
    int insert(HyUserCardRelaEntity record);

    /**
     */
    int insertSelective(HyUserCardRelaEntity record);

    /**
     */
    HyUserCardRelaEntity selectByPrimaryKey(@Param("userId") String userId, @Param("cardId") String cardId);

    /**
     */
    int updateByPrimaryKeySelective(HyUserCardRelaEntity record);

    /**
     */
    int updateByPrimaryKey(HyUserCardRelaEntity record);
}