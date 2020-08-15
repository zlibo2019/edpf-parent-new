package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.NEWSMapper;
import com.weds.edwx.entity.NEWSEntity;

/**
 * @Author sxm
 * @Description NEWS管理
 * @Date 2019-01-03
 */
@Service
public class NEWSService extends BaseService {

    @Autowired
    private NEWSMapper nEWSMapper;

    private Logger log = LogManager.getLogger();

    /**
     * 插入已读信息
     *
     * @param record
     * @return
     */
    public int insert(NEWSEntity record) {
        //判断是否已经有插入的已读消息
        int readCount = nEWSMapper.selectReadCount(record);
        if (readCount > 0) {
            return 0;
        }
        return nEWSMapper.insert(record);
    }

    /**
     * 获取消息详情
     *
     * @param xh
     * @return
     */
    public NEWSEntity selectByPrimaryKey(Integer xh) {
        return nEWSMapper.selectByPrimaryKey(xh);
    }

    /**
     * 获取消息列表
     *
     * @param record
     * @return
     */
    public List<NEWSEntity> selectListByEntity(NEWSEntity record) {
        return nEWSMapper.selectListByEntity(record);
    }


    /**
     * 插入已读信息
     *
     * @param record
     * @return
     */
    public int insertNew(NEWSEntity record) {
        //判断是否已经有插入的已读消息
        int readCount = nEWSMapper.selectReadCountNew(record);
        if (readCount > 0) {
            return 0;
        }
        return nEWSMapper.insertNew(record);
    }

    /**
     * 获取消息详情
     *
     * @param xh
     * @return
     */
    public NEWSEntity selectByPrimaryKeyNew(Integer xh) {
        return nEWSMapper.selectByPrimaryKeyNew(xh);
    }

    /**
     * 获取消息列表
     *
     * @param record
     * @return
     */
    public List<NEWSEntity> selectListByEntityNew(NEWSEntity record) {
        return nEWSMapper.selectListByEntityNew(record);
    }
}
