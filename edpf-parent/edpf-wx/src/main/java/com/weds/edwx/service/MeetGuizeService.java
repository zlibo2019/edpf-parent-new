package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.MeetGuizeEntity;
import com.weds.edwx.mapper.MeetGuizeMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description MeetGuize管理
 * @Date 2019-12-02
 */
@Service
public class MeetGuizeService extends BaseService {

    @Resource
    private MeetGuizeMapper meetGuizeMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer meetBh) {
        return meetGuizeMapper.deleteByPrimaryKey(meetBh);
    }

    public int insert(MeetGuizeEntity record) {
        return meetGuizeMapper.insert(record);
    }

    public int insertSelective(MeetGuizeEntity record) {
        return meetGuizeMapper.insertSelective(record);
    }

    public MeetGuizeEntity selectByPrimaryKey(Integer meetBh) {
        return meetGuizeMapper.selectByPrimaryKey(meetBh);
    }

    public int updateByPrimaryKeySelective(MeetGuizeEntity record) {
        return meetGuizeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MeetGuizeEntity record) {
        return meetGuizeMapper.updateByPrimaryKey(record);
    }

    public List<MeetGuizeEntity> selectListByEntity(MeetGuizeEntity record) {
        return meetGuizeMapper.selectListByEntity(record);
    }
}
