package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.entity.EdAgentDevicePriceEntity;
import com.weds.edwx.entity.EdDineOrderEntity;
import com.weds.edwx.service.EdAgentDevicePriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Description 代理商设备报备信息管理
 * @Date 2019-11-23
 */
@RestController
@RequestMapping(value = "/edAgentDevicePrice")
@Api(value = "代理商设备报备信息管理", description = "代理商设备报备信息管理")
public class EdAgentDevicePriceController extends BaseController {
    @Resource
    private EdAgentDevicePriceService edAgentDevicePriceService;

    @Resource
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增代理商设备报备信息信息", notes = "新增代理商设备报备信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdAgentDevicePriceEntity record) {
        EdAgentDevicePriceEntity entity = new EdAgentDevicePriceEntity();
        entity.setDeviceNo(record.getDeviceNo());
        List<EdAgentDevicePriceEntity> list = edAgentDevicePriceService.selectListByEntity(entity);
        if (list.size() > 0) {
            return failMsg("报备型号已存在");
        }
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        record.setId(StringUtils.getUUID());
        edAgentDevicePriceService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新代理商设备报备信息信息", notes = "更新代理商设备报备信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdAgentDevicePriceEntity record) {
        EdAgentDevicePriceEntity entity = new EdAgentDevicePriceEntity();
        entity.setDeviceNo(record.getDeviceNo());
        List<EdAgentDevicePriceEntity> list = edAgentDevicePriceService.selectListByEntity(entity);
        if (list.size() > 0) {
            return failMsg("报备型号已存在");
        }
        record.setLtDate(new Date());
        edAgentDevicePriceService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询代理商设备报备信息清单", notes = "查询代理商设备报备信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdAgentDevicePriceEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdAgentDevicePriceEntity> record) {
        setPageHelper(record);
        EdAgentDevicePriceEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdAgentDevicePriceEntity();
        }
        List<EdAgentDevicePriceEntity> list = edAgentDevicePriceService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new EdAgentDevicePriceEntity[0]), new String[]{"09001"});
        return succMsgData(new BaseCommPager<EdAgentDevicePriceEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询代理商设备报备信息列表", notes = "查询代理商设备报备信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdAgentDevicePriceEntity>> selectListByEntity(@RequestBody EdAgentDevicePriceEntity record) {
        List<EdAgentDevicePriceEntity> list = edAgentDevicePriceService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除代理商设备报备信息信息", notes = "删除代理商设备报备信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String id) {
        edAgentDevicePriceService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询代理商设备报备信息信息", notes = "查询代理商设备报备信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdAgentDevicePriceEntity> selectByPrimaryKey(@RequestParam String id) {
        EdAgentDevicePriceEntity entity = edAgentDevicePriceService.selectByPrimaryKey(id);
        dicFmtBean.DicFormat(entity, new String[]{"09001"});
        return succMsgData(entity);
    }
}