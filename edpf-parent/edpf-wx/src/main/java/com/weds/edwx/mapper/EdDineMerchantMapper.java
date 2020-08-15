package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineMerchantEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 商户定义管理
 * @Date 2019-04-12
 */
@MyBatisDao
public interface EdDineMerchantMapper {
    /**
     */
    int deleteByPrimaryKey(String merchantId);

    /**
     */
    int insert(EdDineMerchantEntity record);

    /**
     */
    int insertSelective(EdDineMerchantEntity record);

    /**
     */
    EdDineMerchantEntity selectByPrimaryKey(String merchantId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineMerchantEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineMerchantEntity record);

    /**
     */
    List<EdDineMerchantEntity> selectListByEntity(EdDineMerchantEntity record);

    /**
     */
    List<EdDineMerchantEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineMerchantEntity> list);
}