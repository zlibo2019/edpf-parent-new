package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.MeetSpMapper;
import com.weds.edwx.entity.MeetSpEntity;

/**
 * @Author
 * @Description MeetSp管理
 * @Date 2019-11-28
 */
@Service
public class MeetSpService extends BaseService {

    @Resource
    private MeetSpMapper meetSpMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return meetSpMapper.deleteByPrimaryKey(xh);
    }

    public int insert(MeetSpEntity record) {
        return meetSpMapper.insert(record);
    }

    public int insertSelective(MeetSpEntity record) {
        return meetSpMapper.insertSelective(record);
    }

    public MeetSpEntity selectByPrimaryKey(Integer xh) {
        return meetSpMapper.selectByPrimaryKey(xh);
    }

    public MeetSpEntity selectNextApprover(MeetSpEntity record) {
        return meetSpMapper.selectNextApprover(record);
    }

    public int updateByPrimaryKeySelective(MeetSpEntity record) {
        return meetSpMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MeetSpEntity record) {
        return meetSpMapper.updateByPrimaryKey(record);
    }

    public int approveMeeting(MeetSpEntity record) {
        return meetSpMapper.approveMeeting(record);
    }

    public int isMeetApproveFinished(Integer meetBh) {
        return meetSpMapper.isMeetApproveFinished(meetBh);
    }

    public List<MeetSpEntity> selectListByEntity(MeetSpEntity record) {
        return meetSpMapper.selectListByEntity(record);
    }

    public int insertBatch(List<MeetSpEntity> list) {
        return meetSpMapper.insertBatch(list);
    }
}
