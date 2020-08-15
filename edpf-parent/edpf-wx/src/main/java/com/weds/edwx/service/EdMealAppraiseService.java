package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.entity.EdMealAppraiseEntity;
import com.weds.edwx.mapper.EdMealAppraiseMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author
 * @Description 就餐评价管理
 * @Date 2019-11-27
 */
@Service
public class EdMealAppraiseService extends BaseService {

    @Resource
    private EdMealAppraiseMapper edMealAppraiseMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String bh) {
        return edMealAppraiseMapper.deleteByPrimaryKey(bh);
    }

    public int insert(EdMealAppraiseEntity record) {
        return edMealAppraiseMapper.insert(record);
    }

    public int insertSelective(EdMealAppraiseEntity record) {
        return edMealAppraiseMapper.insertSelective(record);
    }

    public EdMealAppraiseEntity selectByPrimaryKey(String bh) {
        return edMealAppraiseMapper.selectByPrimaryKey(bh);
    }

    public int updateByPrimaryKeySelective(EdMealAppraiseEntity record) {
        return edMealAppraiseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdMealAppraiseEntity record) {
        return edMealAppraiseMapper.updateByPrimaryKey(record);
    }

    public List<EdMealAppraiseEntity> selectListByEntity(EdMealAppraiseEntity record) {
        return edMealAppraiseMapper.selectListByEntity(record);
    }
}
