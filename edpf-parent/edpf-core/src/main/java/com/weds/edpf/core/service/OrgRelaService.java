package com.weds.edpf.core.service;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.entity.OrgRelaEntity;
import com.weds.edpf.core.mapper.OrgRelaMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author
 * @Description 机构关系信息管理
 * @Date 2019-09-27
 */
@Service
public class OrgRelaService extends BaseService {

    @Resource
    private OrgRelaMapper orgRelaMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String id) {
        return orgRelaMapper.deleteByPrimaryKey(id);
    }

    public int insert(OrgRelaEntity record) {
        return orgRelaMapper.insert(record);
    }

    public int insertSelective(OrgRelaEntity record) {
        return orgRelaMapper.insertSelective(record);
    }

    public OrgRelaEntity selectByPrimaryKey(String id) {
        return orgRelaMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(OrgRelaEntity record) {
        return orgRelaMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrgRelaEntity record) {
        return orgRelaMapper.updateByPrimaryKey(record);
    }
}
