package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisBlackEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisBlackMapper {
    /**
     */
    int deleteByPrimaryKey(String openId);

    /**
     */
    int insert(VisBlackEntity record);

    /**
     */
    int insertSelective(VisBlackEntity record);

    /**
     */
    VisBlackEntity selectByPrimaryKey(String openId);

    /**
     */
    VisBlackEntity selectByCardId(String visNo);

    /**
     */
    int updateByPrimaryKeySelective(VisBlackEntity record);

    /**
     */
    int updateByPrimaryKey(VisBlackEntity record);

    /**
     */
    List<VisBlackEntity> selectListByEntity(VisBlackEntity record);

    /**
     */
    List<VisBlackEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisBlackEntity> list);
}