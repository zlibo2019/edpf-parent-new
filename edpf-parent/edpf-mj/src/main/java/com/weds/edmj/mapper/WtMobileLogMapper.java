package com.weds.edmj.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edmj.entity.WtMobileLogEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 手机门禁日志管理
 * @Date 2019-08-08
 */
@MyBatisDao
public interface WtMobileLogMapper {
    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(WtMobileLogEntity record);

    /**
     */
    int insertBatch(@Param("list") List<WtMobileLogEntity> list);

    /**
     */
    int insertSelective(WtMobileLogEntity record);

    /**
     */
    WtMobileLogEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(WtMobileLogEntity record);

    /**
     */
    int updateByPrimaryKey(WtMobileLogEntity record);

    /**
     */
    List<WtMobileLogEntity> selectListByEntity(WtMobileLogEntity record);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<WtMobileLogEntity> list);
}