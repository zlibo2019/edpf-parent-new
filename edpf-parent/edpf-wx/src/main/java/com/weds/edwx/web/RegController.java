package com.weds.edwx .web;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;

import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.entity .RegEntity;
import com.weds.edwx.service .RegService;

/**
 * @Author sxm
 * @Description Reg管理
 * @Date 2018-12-27
 */
@RestController
@RequestMapping(value="/reg")
@Api(value = "Reg管理", description = "Reg管理")
public class RegController extends BaseController{
	@Autowired
	private RegService regService;

	private Logger log = LogManager.getLogger();

	}