package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.SystemMenusMapper;
import com.weds.edwx.entity.SystemMenusEntity;

/**
 * @Author sxm
 * @Description 系统功能管理管理
 * @Date 2018-11-24
 */
@Service
public class SystemMenusService extends BaseService {

    @Autowired
    private SystemMenusMapper systemMenusMapper;

    private Logger log = LogManager.getLogger();

    public SystemMenusEntity selectByPrimaryKey(String companyId, String menuId) {
        return systemMenusMapper.selectByPrimaryKey(companyId, menuId);
    }

    public List<SystemMenusEntity> selectListByEntity(SystemMenusEntity record) {
        return systemMenusMapper.selectListByEntity(record);
    }
}
