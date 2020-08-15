package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisUserEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisUserMapper {
    /**
     */
    int deleteByPrimaryKey(String openId);

    /**
     */
    int insert(VisUserEntity record);

    /**
     */
    int insertSelective(VisUserEntity record);

    /**
     */
    VisUserEntity selectByPrimaryKey(String openId);

    /**
     */
    VisUserEntity selectByVisSerial(Long visSerial);


    /**
     */
    VisUserEntity selectByCardId(@Param("visId") String visId);

    /**
     */
    int updateByPrimaryKeySelective(VisUserEntity record);

    /**
     */
    int updateByIdSelective(VisUserEntity record);

    /**
     */
    int updateByPrimaryKey(VisUserEntity record);

    /**
     */
    List<VisUserEntity> selectListByEntity(VisUserEntity record);

    /**
     */
    List<VisUserEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisUserEntity> list);
}