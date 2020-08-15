package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisUserStateEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisUserStateMapper {
    /**
     */
    int deleteByPrimaryKey(Long userSerial);

    /**
     */
    int insert(VisUserStateEntity record);

    /**
     */
    int insertSelective(VisUserStateEntity record);

    /**
     */
    VisUserStateEntity selectByPrimaryKey(Long userSerial);

    /**
     */
    int updateByPrimaryKeySelective(VisUserStateEntity record);

    /**
     */
    int updateByPrimaryKey(VisUserStateEntity record);

    /**
     */
    List<VisUserStateEntity> selectListByEntity(VisUserStateEntity record);

    /**
     */
    List<VisUserStateEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisUserStateEntity> list);
}