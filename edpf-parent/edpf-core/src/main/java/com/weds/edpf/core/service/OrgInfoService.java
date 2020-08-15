package com.weds.edpf.core.service;

import javax.annotation.Resource;

import com.weds.edpf.core.entity.DepEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.OrgInfoMapper;
import com.weds.edpf.core.entity.OrgInfoEntity;

/**
 * @Author
 * @Description 机构基本信息管理
 * @Date 2019-09-25
 */
@Service
public class OrgInfoService extends BaseService {

    @Resource
    private OrgInfoMapper orgInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String orgId) {
        return orgInfoMapper.deleteByPrimaryKey(orgId);
    }

    public int deleteOrgRela(String orgId) {
        return orgInfoMapper.deleteOrgRela(orgId);
    }

    public int haveSubOrg(String orgId) {
        return orgInfoMapper.haveSubOrg(orgId);
    }

    public int insert(OrgInfoEntity record) {
        return orgInfoMapper.insert(record);
    }

    public int insertSelective(OrgInfoEntity record) {
        return orgInfoMapper.insertSelective(record);
    }

    public OrgInfoEntity selectByPrimaryKey(String orgId) {
        return orgInfoMapper.selectByPrimaryKey(orgId);
    }

    public int updateByPrimaryKeySelective(OrgInfoEntity record) {
        return orgInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrgInfoEntity record) {
        return orgInfoMapper.updateByPrimaryKey(record);
    }

    public List<OrgInfoEntity> selectListByEntity(OrgInfoEntity record) {
        return orgInfoMapper.selectListByEntity(record);
    }

    public List<OrgInfoEntity> selectOrgTree(String parentOrgId) {
        return orgInfoMapper.selectOrgTree(parentOrgId);
    }
}
