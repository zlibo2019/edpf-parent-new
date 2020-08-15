package com.weds.edwx.service;

import com.weds.edwx.entity.MeetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.MeetMdMapper;
import com.weds.edwx.entity.MeetMdEntity;

/**
 * @Author sxm
 * @Description MeetMd管理
 * @Date 2018-11-22
 */
@Service
public class MeetMdService extends BaseService {

    @Autowired
    private MeetMdMapper meetMdMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return meetMdMapper.deleteByPrimaryKey(xh);
    }

    /**
     * 插入会议人员列表
     *
     * @param record
     * @return
     */
    public int insert(MeetEntity record) {
        return meetMdMapper.insert(record);
    }

    public int insertSelective(MeetMdEntity record) {
        return meetMdMapper.insertSelective(record);
    }

    public MeetMdEntity selectByPrimaryKey(Integer xh) {
        return meetMdMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(MeetMdEntity record) {
        return meetMdMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MeetMdEntity record) {
        return meetMdMapper.updateByPrimaryKey(record);
    }

    public List<MeetMdEntity> selectListByEntity(MeetMdEntity record) {
        return meetMdMapper.selectListByEntity(record);
    }

    public List<MeetMdEntity> selectUserListByBh(Integer meetBh) {
        return meetMdMapper.selectUserListByBh(meetBh);
    }
}
