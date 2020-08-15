package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.DtPhotoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-05-29
 */
@MyBatisDao
public interface DtPhotoMapper {
    /**
     */
    int deleteByPrimaryKey(@Param("userSerial") Long userSerial);

    /**
     */
    int insert(DtPhotoEntity record);

    /**
     */
    int insertSelective(DtPhotoEntity record);

    /**
     */
    DtPhotoEntity selectByPrimaryKey(@Param("userSerial") Long userSerial);

    /**
     */
    int updateByPrimaryKeySelective(DtPhotoEntity record);

    /**
     */
    int updateByPrimaryKey(DtPhotoEntity record);
}