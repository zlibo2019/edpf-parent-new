package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.DineMealMapper;
import com.weds.edwx.entity.DineMealEntity;

/**
 * @Author sxm
 * @Description DineMeal管理
 * @Date 2018-11-13
 */
@Service
public class DineMealService extends BaseService {

    @Autowired
    private DineMealMapper dineMealMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return dineMealMapper.deleteByPrimaryKey(xh);
    }

    public int insert(DineMealEntity record) {
        return dineMealMapper.insert(record);
    }

    public int insertSelective(DineMealEntity record) {
        return dineMealMapper.insertSelective(record);
    }

    public DineMealEntity selectByPrimaryKey(Integer xh) {
        return dineMealMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(DineMealEntity record) {
        return dineMealMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DineMealEntity record) {
        return dineMealMapper.updateByPrimaryKey(record);
    }

    public List<DineMealEntity> selectListByEntity(DineMealEntity record) {
        return dineMealMapper.selectListByEntity(record);
    }

    public DineMealEntity selectByMealBh(String mealBh) {
        return dineMealMapper.selectByMealBh(mealBh);
    }
}
