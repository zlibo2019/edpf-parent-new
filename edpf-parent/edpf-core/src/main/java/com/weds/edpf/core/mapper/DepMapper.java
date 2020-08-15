package com.weds.edpf.core.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edpf.core.entity.DepEntity;

import java.util.List;


/**
 * @Author
 * @Description 管理
 * @Date 2018-12-13
 */
@MyBatisDao
public interface DepMapper {
    /**
     */
    int deleteByPrimaryKey(Long depSerial);

    /**
     */
    int insert(DepEntity record);

    /**
     */
    int insertSelective(DepEntity record);

    /**
     */
    DepEntity selectByPrimaryKey(Long depSerial);

    /**
     */
    int updateByPrimaryKeySelective(DepEntity record);

    /**
     */
    int updateByPrimaryKey(DepEntity record);

    /**
     */
    List<DepEntity> selectListByEntity(DepEntity record);

    /**
     */
    List<DepEntity> selectDeptUserNums(Integer depParentNo);

    /**
     */
    List<DepEntity> selectOrgTree(Integer depParentNo);

    /**
     */
    List<DepEntity> selectOrgTreeLazy(Integer depParentNo);
}