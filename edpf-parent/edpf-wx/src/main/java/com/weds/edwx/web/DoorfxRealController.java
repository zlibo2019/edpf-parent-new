package com.weds.edwx .web;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.weds.core.base.BaseController;
import com.weds.edwx.service .DoorfxRealService;

/**
 * @Author sxm
 * @Description DoorfxReal管理
 * @Date 2018-12-22
 */
@RestController
@RequestMapping(value="/doorfxReal")
@Api(value = "DoorfxReal管理", description = "DoorfxReal管理")
public class DoorfxRealController extends BaseController{
	@Autowired
	private DoorfxRealService doorfxRealService;

	private Logger log = LogManager.getLogger();
	}