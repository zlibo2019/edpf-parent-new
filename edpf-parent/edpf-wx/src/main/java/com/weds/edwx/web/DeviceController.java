package com.weds.edwx.web;

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
import com.weds.edwx.entity.DeviceEntity;
import com.weds.edwx.service.DeviceService;

/**
 * @Author sxm
 * @Description Device管理
 * @Date 2018-12-28
 */
@RestController
@RequestMapping(value = "/device")
@Api(value = "Device管理", description = "Device管理")
public class DeviceController extends BaseController {
    @Autowired
    private DeviceService deviceService;

    private Logger log = LogManager.getLogger();

}