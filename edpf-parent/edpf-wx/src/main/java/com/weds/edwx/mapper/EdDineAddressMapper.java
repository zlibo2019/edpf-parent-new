package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineAddressEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface EdDineAddressMapper {
    /**
     */
    int deleteByPrimaryKey(String addressId);

    /**
     */
    int insert(EdDineAddressEntity record);

    /**
     */
    int insertSelective(EdDineAddressEntity record);

    /**
     */
    EdDineAddressEntity selectByPrimaryKey(String addressId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineAddressEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineAddressEntity record);

    /**
     */
    List<EdDineAddressEntity> selectListByEntity(EdDineAddressEntity record);

    /**
     */
    List<EdDineAddressEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineAddressEntity> list);
}