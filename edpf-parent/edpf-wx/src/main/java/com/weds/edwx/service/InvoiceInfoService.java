package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.InvoiceInfoMapper;
import com.weds.edwx.entity.InvoiceInfoEntity;

/**
 * @Author sxm
 * @Description InvoiceInfo管理
 * @Date 2018-11-14
 */
@Service
public class InvoiceInfoService extends BaseService {

    @Autowired
    private InvoiceInfoMapper invoiceInfoMapper;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(Integer xh) {
        return invoiceInfoMapper.deleteByPrimaryKey(xh);
    }

    public int insert(InvoiceInfoEntity record) {
        return invoiceInfoMapper.insert(record);
    }

    public int insertSelective(InvoiceInfoEntity record) {
        return invoiceInfoMapper.insertSelective(record);
    }

    public InvoiceInfoEntity selectByPrimaryKey(Integer xh) {
        return invoiceInfoMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(InvoiceInfoEntity record) {
        return invoiceInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(InvoiceInfoEntity record) {
        return invoiceInfoMapper.updateByPrimaryKey(record);
    }

    public List<InvoiceInfoEntity> selectListByEntity(InvoiceInfoEntity record) {
        return invoiceInfoMapper.selectListByEntity(record);
    }

}
