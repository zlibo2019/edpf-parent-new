package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.TmpDtUserEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-10-24
 */
@MyBatisDao
public interface TmpDtUserMapper {
    /**
     */
    int deleteByPrimaryKey(String zh);

    /**
     */
    int insert(TmpDtUserEntity record);

    /**
     */
    int insertBatch(@Param("list") List<TmpDtUserEntity> list);

    /**
     */
    int insertSelective(TmpDtUserEntity record);

    /**
     */
    TmpDtUserEntity selectByPrimaryKey(String zh);

    /**
     */
    int updateByPrimaryKeySelective(TmpDtUserEntity record);

    /**
     */
    int updateByPrimaryKey(TmpDtUserEntity record);

    /**
     */
    List<TmpDtUserEntity> selectListByEntity(TmpDtUserEntity record);
}