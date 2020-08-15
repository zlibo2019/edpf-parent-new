package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.VisUserNewEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-05-21
 */
@MyBatisDao
public interface VisUserNewMapper {
    /**
     */
    int deleteByPrimaryKey(Long visSerial);

    /**
     */
    int insert(VisUserNewEntity record);

    /**
     */
    int insertSelective(VisUserNewEntity record);

    /**
     */
    VisUserNewEntity selectByPrimaryKey(Long visSerial);

    /**
     */
    VisUserNewEntity selectByOpenId(String openId);

    /**
     */
    VisUserNewEntity selectByVisId(String visId);

    /**
     */
    List<VisUserNewEntity> selectByVisIdOrTel(String param);

    /**
     */
    VisUserNewEntity selectByVisTelephone(String visTelephone);

    /**
     */
    int updateByPrimaryKeySelective(VisUserNewEntity record);

    /**
     */
    int updateByPrimaryKey(VisUserNewEntity record);

    /**
     */
    List<VisUserNewEntity> selectListByEntity(VisUserNewEntity record);

    /**
     */
    List<VisUserNewEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisUserNewEntity> list);
}