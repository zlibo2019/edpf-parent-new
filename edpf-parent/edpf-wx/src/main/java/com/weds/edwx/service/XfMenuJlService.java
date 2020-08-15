package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.XfMenuJlEntity;
import com.weds.edwx.mapper.XfMenuJlMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description XfMenuJl管理
 * @Date 2019-11-27
 */
@Service
public class XfMenuJlService extends BaseService {

    @Resource
    private XfMenuJlMapper xfMenuJlMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return xfMenuJlMapper.deleteByPrimaryKey(xh);
    }

    public int insert(XfMenuJlEntity record) {
        return xfMenuJlMapper.insert(record);
    }

    public int insertSelective(XfMenuJlEntity record) {
        return xfMenuJlMapper.insertSelective(record);
    }

    public XfMenuJlEntity selectByPrimaryKey(Integer xh) {
        return xfMenuJlMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(XfMenuJlEntity record) {
        return xfMenuJlMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(XfMenuJlEntity record) {
        return xfMenuJlMapper.updateByPrimaryKey(record);
    }

    public List<XfMenuJlEntity> selectListByEntity(XfMenuJlEntity record) {
        return xfMenuJlMapper.selectListByEntity(record);
    }
}
