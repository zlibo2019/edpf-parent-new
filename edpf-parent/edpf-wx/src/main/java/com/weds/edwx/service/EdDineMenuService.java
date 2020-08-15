package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.EdDineMenuMapper;
import com.weds.edwx.entity.EdDineMenuEntity;

/**
 * @Author sxm
 * @Description 菜谱定义管理
 * @Date 2019-04-15
 */
@Service
public class EdDineMenuService extends BaseService {

    @Autowired
    private EdDineMenuMapper edDineMenuMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String menuId) {
        return edDineMenuMapper.deleteByPrimaryKey(menuId);
    }

    public int insert(EdDineMenuEntity record) {
        return edDineMenuMapper.insert(record);
    }

    public int insertSelective(EdDineMenuEntity record) {
        return edDineMenuMapper.insertSelective(record);
    }

    public EdDineMenuEntity selectByPrimaryKey(String menuId) {
        return edDineMenuMapper.selectByPrimaryKey(menuId);
    }

    public int updateByPrimaryKeySelective(EdDineMenuEntity record) {
        return edDineMenuMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EdDineMenuEntity record) {
        return edDineMenuMapper.updateByPrimaryKey(record);
    }

    public List<EdDineMenuEntity> selectListByEntity(EdDineMenuEntity record) {
        return edDineMenuMapper.selectListByEntity(record);
    }


    public List<EdDineMenuEntity> selectListByKeys(String keys) {
        return edDineMenuMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<EdDineMenuEntity> list) {
        return edDineMenuMapper.deleteBatchByKeys(list);
    }
}
