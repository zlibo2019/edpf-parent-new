package com.weds.edwx.web;

import com.icbc.api.IcbcApiException;
import com.icbc.api.response.QrcodeQueryResponseV2;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.AccountEntity;
import com.weds.edwx.entity.IcbcPaymentEntity;
import com.weds.edwx.service.AccountService;
import com.weds.edwx.service.IcbcPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping(value = "/icbcPay")
@Api(value = "工商银行支付管理", description = "工商银行支付管理")
public class IcbcPayController extends BaseController {

    @Resource
    private IcbcPayService icbcPayService;

    @Resource
    private AccountService accountService;

    @Logs
    @ApiOperation(value = "聚合支付", notes = "聚合支付")
    @RequestMapping(value = "/appPay", method = RequestMethod.POST)
    public JsonResult<Object> appPay(@RequestBody IcbcPaymentEntity icbcPaymentEntity) {
        Date date = new Date();
        try {
            BigDecimal orderAmount = null;
            if (!StringUtils.isBlank(icbcPaymentEntity.getOrderAmount())) {
                orderAmount = new BigDecimal(Float.parseFloat(icbcPaymentEntity.getOrderAmount()) * 100);
                icbcPaymentEntity.setOrderAmount(orderAmount.toString());
            }
            String outTradeNo = DateUtils.formatDate(date, "yyyyMMddHHmmssSSS") + (new Random().nextInt(900) + 100);
            icbcPaymentEntity.setOutTradeNo(outTradeNo);
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setSj(date); //插入订单时间
            accountEntity.setState(0);
            accountEntity.setOrderId(outTradeNo);
            accountEntity.setAddMoney(orderAmount);
            int preFlg = accountService.insertSelective(accountEntity);
            String resp = icbcPayService.appPay(icbcPaymentEntity);
        } catch (IcbcApiException e) {
            e.printStackTrace();
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "支付查询", notes = "支付查询")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public JsonResult<Object> query(@RequestBody IcbcPaymentEntity icbcPaymentEntity) {
        QrcodeQueryResponseV2 resp = icbcPayService.query(icbcPaymentEntity);
        if (resp.isSuccess()) {
            // 一卡通平台充值
            // int preFlg = accountService.rechargeAccount();
            return succMsg();
        } else {
            return failMsg();
        }
    }
}
