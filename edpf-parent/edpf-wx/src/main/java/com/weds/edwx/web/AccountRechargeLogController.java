package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.AccountRechargeLogEntity;
import com.weds.edwx.service.AccountRechargeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description 账户充值日志管理
 * @Date 2019-10-22
 */
@RestController
@RequestMapping(value = "/accountRechargeLog")
@Api(value = "账户充值日志管理", description = "账户充值日志管理")
public class AccountRechargeLogController extends BaseController {
    @Resource
    private AccountRechargeLogService accountRechargeLogService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增账户充值日志信息", notes = "新增账户充值日志信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid AccountRechargeLogEntity record) {
        accountRechargeLogService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新账户充值日志信息", notes = "更新账户充值日志信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid AccountRechargeLogEntity record) {
        accountRechargeLogService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询账户充值日志清单", notes = "查询账户充值日志清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<AccountRechargeLogEntity>> selectListPageByEntity(@RequestBody BasePageSearch<AccountRechargeLogEntity> record) {
        setPageHelper(record);
        AccountRechargeLogEntity entity = record.getSearch();
        if (entity == null) {
            entity = new AccountRechargeLogEntity();
        }
        List<AccountRechargeLogEntity> list = accountRechargeLogService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<AccountRechargeLogEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询账户充值日志列表", notes = "查询账户充值日志列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<AccountRechargeLogEntity>> selectListByEntity(@RequestBody AccountRechargeLogEntity record) {
        List<AccountRechargeLogEntity> list = accountRechargeLogService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除账户充值日志信息", notes = "删除账户充值日志信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String id) {
        accountRechargeLogService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询账户充值日志信息", notes = "查询账户充值日志信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<AccountRechargeLogEntity> selectByPrimaryKey(@RequestParam String id) {
        AccountRechargeLogEntity entity = accountRechargeLogService.selectByPrimaryKey(id);
        return succMsgData(entity);
    }


}