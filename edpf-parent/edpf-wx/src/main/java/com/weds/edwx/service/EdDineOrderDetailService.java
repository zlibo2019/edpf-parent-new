package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.EdDineOrderDetailEntity;
import com.weds.edwx.mapper.EdDineOrderDetailMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description 订餐订单详情管理
 * @Date 2019-10-22
 */
@Service
public class EdDineOrderDetailService extends BaseService {

    @Resource
    private EdDineOrderDetailMapper edDineOrderDetailMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return edDineOrderDetailMapper.deleteByPrimaryKey(id);
    }

    public int insert(EdDineOrderDetailEntity record) {
        return edDineOrderDetailMapper.insert(record);
    }

    public int insertSelective(EdDineOrderDetailEntity record) {
        return edDineOrderDetailMapper.insertSelective(record);
    }

    public EdDineOrderDetailEntity selectByPrimaryKey(String id) {
        return edDineOrderDetailMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EdDineOrderDetailEntity record) {
        return edDineOrderDetailMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineOrderDetailEntity record) {
        return edDineOrderDetailMapper.updateByPrimaryKey(record);
    }

    public List<EdDineOrderDetailEntity> selectListByEntity(EdDineOrderDetailEntity record) {
        return edDineOrderDetailMapper.selectListByEntity(record);
    }


    public int deleteBatchByKeys(List<EdDineOrderDetailEntity> list) {
        return edDineOrderDetailMapper.deleteBatchByKeys(list);
    }

}
