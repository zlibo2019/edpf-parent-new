package com.weds.edwx .service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper .RegMapper;
import com.weds.edwx.entity .RegEntity;

/**
 * @Author sxm
 * @Description Reg管理
 * @Date 2018-12-27
 */
@Service
public class RegService extends BaseService {

	@Autowired
	private RegMapper regMapper;

	private Logger log = LogManager.getLogger();


	public RegEntity selectByPrimaryKey() {
		return regMapper.selectByPrimaryKey();
	}

	}
