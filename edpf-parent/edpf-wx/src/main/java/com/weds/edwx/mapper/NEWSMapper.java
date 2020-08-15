package com.weds.edwx.mapper;

import com.weds.edwx.entity.NEWSEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-01-03
 */
@MyBatisDao
public interface NEWSMapper {


    /**
     * 判断是否已经有已读信息
     *
     * @param record
     * @return
     */
    int selectReadCount(NEWSEntity record);

    /**
     * 插入已读信息
     */
    int insert(NEWSEntity record);

    /**
     * 获取消息详情
     */
    NEWSEntity selectByPrimaryKey(Integer xh);

    /**
     * 获取消息列表
     */
    List<NEWSEntity> selectListByEntity(NEWSEntity record);

    /**
     * 判断是否已经有已读信息
     *
     * @param record
     * @return
     */
    int selectReadCountNew(NEWSEntity record);

    /**
     * 插入已读信息
     */
    int insertNew(NEWSEntity record);

    /**
     * 获取消息详情
     */
    NEWSEntity selectByPrimaryKeyNew(Integer xh);

    /**
     * 获取消息列表
     */
    List<NEWSEntity> selectListByEntityNew(NEWSEntity record);
}