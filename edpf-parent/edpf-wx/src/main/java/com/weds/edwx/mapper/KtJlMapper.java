package com.weds.edwx.mapper;

import com.weds.edwx.entity.DeviceEntity;
import com.weds.edwx.entity.KtJlEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-27
 */
@MyBatisDao
public interface KtJlMapper {

    int selectDepUser(DeviceEntity record);
    int selectDepPlace(DeviceEntity record);
    int selectDepUserByUserSerial(DeviceEntity record);
    int selectDepPlaceByUserSerial(DeviceEntity record);
    int insert(KtJlEntity record);

    /**
     */
    int deleteByPrimaryKey(@Param("sj") Date sj, @Param("userSerial") Integer userSerial, @Param("bh") Integer bh);


    /**
     */
    int insertSelective(KtJlEntity record);

    /**
     */
    KtJlEntity selectByPrimaryKey(@Param("sj") Date sj, @Param("userSerial") Integer userSerial, @Param("bh") Integer bh);

    /**
     */
    int updateByPrimaryKeySelective(KtJlEntity record);

    /**
     */
    int updateByPrimaryKey(KtJlEntity record);

    /**
     */
    List<KtJlEntity> selectListByEntity(KtJlEntity record);
}