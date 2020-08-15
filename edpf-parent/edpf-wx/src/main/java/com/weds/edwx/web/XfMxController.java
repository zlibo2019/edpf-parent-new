package com.weds.edwx.web;

import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.AccountRechargeLogService;
import com.weds.edwx.service.UserInfoService;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;

import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import com.weds.edwx.service.XfMxService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author sxm
 * @Description XfMx管理
 * @Date 2018-12-21
 */
@RestController
@RequestMapping(value = "/xfMx")
@Api(value = "消费管理", description = "消费管理")
public class XfMxController extends BaseController {
    @Autowired
    private XfMxService xfMxService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CommProcService commProcService;

    @Autowired
    private AccountRechargeLogService accountRechargeLogService;

    @Resource
    private HttpServletRequest request;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "一卡通平台充值接口", notes = "一卡通平台充值接口")
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public JsonResult recharge(@RequestBody RechargeEntity rechargeEntity) {
        AccountRechargeLogEntity accountRechargeLogEntity = new AccountRechargeLogEntity();
        accountRechargeLogEntity.setId(StringUtils.getUUID());
        accountRechargeLogEntity.setUserIdcard(rechargeEntity.getIdCard());
        accountRechargeLogEntity.setTransAmt(rechargeEntity.getAmt());
        accountRechargeLogEntity.setTransChannel(rechargeEntity.getChannel());
        accountRechargeLogEntity.setTransDate(new Date());
        accountRechargeLogEntity.setTransIp(request.getRemoteAddr());
        accountRechargeLogEntity.setTransNo(rechargeEntity.getTransNo());
        accountRechargeLogEntity.setTransSj(rechargeEntity.getTransDate());

        UserInfoEntity userInfoEntity = userInfoService.selectByIdCard(rechargeEntity.getIdCard());
        if (userInfoEntity == null) {
            accountRechargeLogEntity.setTransState("2");
            accountRechargeLogService.insertSelective(accountRechargeLogEntity);
            return failMsg("用户信息不存在");
        } else {
            accountRechargeLogEntity.setUserSerial(userInfoEntity.getUserSerial().toString());
            //开始走给一卡通充值流程
            CommProcEntity commProcEntity = new CommProcEntity();
            commProcEntity.setProcName("wx_zh_recharge");
            List<Object> list = new ArrayList<>();
            list.add(userInfoEntity.getUserSerial());
            list.add(rechargeEntity.getAmt());
            list.add(rechargeEntity.getChannel());
            commProcEntity.setParams(list);
            List<List<Map>> map = commProcService.loadProcData(commProcEntity);

            if ("0".equals(map.get(0).get(0).get("").toString())) { //改为充值完成
                AccountInfoEntity myCountInfo = xfMxService.selectAccountBal(rechargeEntity.getIdCard());
                if (myCountInfo == null) {
                    accountRechargeLogEntity.setTransState("3");
                    accountRechargeLogService.insertSelective(accountRechargeLogEntity);
                    return failMsg("账户信息不存在");
                }
                accountRechargeLogEntity.setTransState("1");
                myCountInfo.setUserLname(userInfoEntity.getUserLname());
                accountRechargeLogService.insertSelective(accountRechargeLogEntity);
                return succMsg("充值成功", myCountInfo);
            } else {
                accountRechargeLogEntity.setTransState("4");
                accountRechargeLogService.insertSelective(accountRechargeLogEntity);
                return failMsg("充值失败");
            }
        }
    }

    @Logs
    @ApiOperation(value = "查询我的账户余额信息", notes = "查询我的账户余额信息")
    @RequestMapping(value = "/searchBal", method = RequestMethod.GET)
    public JsonResult<AccountInfoEntity> searchBal(@RequestParam String idCard) {
        UserInfoEntity userInfoEntity = userInfoService.selectByIdCard(idCard);
        if (userInfoEntity == null) {
            return failMsg("用户信息不存在");
        } else {
            AccountInfoEntity myCountInfo = xfMxService.selectAccountBal(idCard);
            if (myCountInfo == null) {
                return failMsg("账户信息不存在");
            }
            myCountInfo.setUserLname(userInfoEntity.getUserLname());
            return succMsgData(myCountInfo);
        }
    }

    @Logs
    @ApiOperation(value = "查询消费汇总信息", notes = "查询消费汇总信息")
    @RequestMapping(value = "/collectSum", method = RequestMethod.POST)
    public JsonResult<XfMxEntity> collectSum(@RequestBody XfTimeEntity record) {
        // 将结束日期往后延一天
        try {
            record.setEndDate(DateUtils.formatDate(DateUtils.addDays(DateUtils.parseDate(record.getEndDate(), DateUtils.DATE_FORMAT), 1), DateUtils.DATE_FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        XfMxEntity entity = xfMxService.selectCollectSum(record);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询消费明细", notes = "查询消费明细")
    @RequestMapping(value = "/selectRecordList", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<XfMxEntity>> selectRecordPageByEntity(@RequestBody BasePageSearch<XfTimeEntity> record) {
        setPageHelper(record);
        XfTimeEntity entity = record.getSearch();
        if (entity == null) {
            entity = new XfTimeEntity();
        }
        try {
            // 将结束日期往后延一天
            entity.setEndDate(DateUtils.formatDate(DateUtils.addDays(DateUtils.parseDate(entity.getEndDate(), DateUtils.DATE_FORMAT), 1), DateUtils.DATE_FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<XfMxEntity> list = xfMxService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<XfMxEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询我的账户余额信息", notes = "查询我的账户余额信息")
    @RequestMapping(value = "/accountSum", method = RequestMethod.POST)
    public JsonResult<AccountInfoEntity> getAccountSum(@RequestBody XfTimeEntity record) {
        AccountInfoEntity myCountInfo = xfMxService.getAccountSum(record);
        if (myCountInfo == null) {
            return failMsg("您没有账户信息，请联系管理员");
        }
        return succMsgData(myCountInfo);
    }

    @Logs
    @ApiOperation(value = "查询我的账户变更记录", notes = "查询我的账户变更记录")
    @RequestMapping(value = "/selectAccountRecord", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<XfMxEntity>> selectAccountRecordList(@RequestBody BasePageSearch<XfTimeEntity> record) {
        setPageHelper(record);
        XfTimeEntity entity = record.getSearch();
        if (entity == null) {
            entity = new XfTimeEntity();
        }
        List<XfMxEntity> list = xfMxService.selectAccountRecordList(entity);
        return succMsgData(new BaseCommPager<XfMxEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询我的账户充值记录", notes = "查询我的账户充值记录")
    @RequestMapping(value = "/selectAccountRecharge", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<XfMxEntity>> selectAccountRechargeList(@RequestBody BasePageSearch<XfTimeEntity> record) {
        setPageHelper(record);
        XfTimeEntity entity = record.getSearch();
        if (entity == null) {
            entity = new XfTimeEntity();
        }
        List<XfMxEntity> list = xfMxService.selectRechargeRecord(entity);
        return succMsgData(new BaseCommPager<XfMxEntity>(list));
    }
}