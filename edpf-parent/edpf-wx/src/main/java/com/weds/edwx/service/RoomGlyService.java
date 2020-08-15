package com.weds.edwx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.RoomGlyMapper;
import com.weds.edwx.entity.RoomGlyEntity;

/**
 * @Author
 * @Description RoomGly管理
 * @Date 2019-11-28
 */
@Service
public class RoomGlyService extends BaseService {

    @Resource
    private RoomGlyMapper roomGlyMapper;

    private Logger log = LogManager.getLogger();

    public int insert(RoomGlyEntity record) {
        return roomGlyMapper.insert(record);
    }

    public int insertSelective(RoomGlyEntity record) {
        return roomGlyMapper.insertSelective(record);
    }

    public List<RoomGlyEntity> selectListByEntity(RoomGlyEntity record) {
        return roomGlyMapper.selectListByEntity(record);
    }
}
