package com.weds.edwx.mapper;

import com.weds.edwx.entity.InvoiceInfoEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-14
 */
@MyBatisDao
public interface InvoiceInfoMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(InvoiceInfoEntity record);

    /**
     */
    int insertSelective(InvoiceInfoEntity record);

    /**
     */
    InvoiceInfoEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(InvoiceInfoEntity record);

    /**
     */
    int updateByPrimaryKey(InvoiceInfoEntity record);

    /**
     */
    List<InvoiceInfoEntity> selectListByEntity(InvoiceInfoEntity record);
}