package com.weds.edwx.service;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcConstants;
import com.icbc.api.UiIcbcClient;
import com.icbc.api.request.AggregatePaymentRequestV1;
import com.icbc.api.request.QrcodePayRequestV2;
import com.icbc.api.request.QrcodeQueryRequestV2;
import com.icbc.api.response.QrcodePayResponseV2;
import com.icbc.api.response.QrcodeQueryResponseV2;
import com.weds.core.base.BaseService;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.constant.IcbcPayParams;
import com.weds.edwx.entity.IcbcPaymentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class IcbcPayService extends BaseService {

    @Resource
    private IcbcPayParams icbcPayParams;

    @Resource
    private HttpServletRequest httpServletRequest;


    /**
     * 工商银行聚合支付
     *
     * @param icbcPaymentEntity
     * @return
     * @throws IcbcApiException
     */
    public String appPay(IcbcPaymentEntity icbcPaymentEntity) throws IcbcApiException {
        Date date = new Date();
        //签名类型为RSA2时，需传入appid，私钥和网关公钥，签名类型使用定值IcbcConstants.SIGN_TYPE_RSA2，其他参数使用缺省值
        UiIcbcClient client = new UiIcbcClient(icbcPayParams.getAppId(), IcbcConstants.SIGN_TYPE_RSA2,
                icbcPayParams.getPrivateKey(), icbcPayParams.getApigwPubKey());
        AggregatePaymentRequestV1 request = new AggregatePaymentRequestV1();
        request.setServiceUrl(icbcPayParams.getPaymentUrl());

        //5、请对照接口文档用bizContent.setxxx()方法对业务上送数据进行赋值
        AggregatePaymentRequestV1.AggregatePaymentRequestV1Biz bizContent = new AggregatePaymentRequestV1.AggregatePaymentRequestV1Biz();
        bizContent.setInterfaceVersion("1.0.0.0");
        bizContent.setMerId(icbcPayParams.getMerId());
        bizContent.setChannelId(icbcPayParams.getChannelId());
        bizContent.setOrderDate(DateUtils.formatDate(date, DateUtils.DATE_TIME_SIMPLE_FORMAT));
        bizContent.setEndTime(DateUtils.formatDate(DateUtils.addMinutes(date, 5), DateUtils.DATE_TIME_SIMPLE_FORMAT));
        bizContent.setOutTradeNo(icbcPaymentEntity.getOutTradeNo());
        bizContent.setAttach(icbcPaymentEntity.getOutTradeNo());
        bizContent.setSpbillCreateIp(httpServletRequest.getRemoteAddr());
        bizContent.setTranType("OnlinePay");

        bizContent.setGoodsBody(icbcPaymentEntity.getGoodsBody());
        bizContent.setGoodsDetail(icbcPaymentEntity.getGoodsDetail());
        bizContent.setOrderAmount(icbcPaymentEntity.getOrderAmount());
        bizContent.setMerHint(icbcPaymentEntity.getMerHint());
        bizContent.setReturnUrl(icbcPaymentEntity.getReturnUrl());

        bizContent.setNotifyUrl(icbcPayParams.getNotifyUrl());
        bizContent.setInstallTimes("1");
        bizContent.setPayLimit("no_credit");
        bizContent.setResultType("0");
        bizContent.setNotifyType("HS");
        bizContent.setBackup1("");
        bizContent.setBackup2("");
        bizContent.setBackup3("");
        bizContent.setBackup4("");
        request.setBizContent(bizContent);
        return client.buildPostForm(request);
    }

    /**
     * 查询支付结果
     *
     * @param icbcPaymentEntity
     * @return
     */
    public QrcodeQueryResponseV2 query(IcbcPaymentEntity icbcPaymentEntity) {
        //签名类型为RSA2时，需传入appid，私钥和网关公钥，签名类型使用定值IcbcConstants.SIGN_TYPE_RSA2，其他参数使用缺省值
        UiIcbcClient client = new UiIcbcClient(icbcPayParams.getAppId(), IcbcConstants.SIGN_TYPE_RSA2,
                icbcPayParams.getPrivateKey(), icbcPayParams.getApigwPubKey());
        QrcodeQueryRequestV2 request = new QrcodeQueryRequestV2();

        //4、根据测试环境和生产环境替换相应ip和端口
        request.setServiceUrl(icbcPayParams.getQueryUrl());

        //5、请对照接口文档用bizContent.setxxx()方法对业务上送数据进行赋值
        QrcodeQueryRequestV2.QrcodeQueryRequestV2Biz bizContent = new QrcodeQueryRequestV2.QrcodeQueryRequestV2Biz();
        bizContent.setMerId(icbcPaymentEntity.getMerId());
        // bizContent.setCustId("Ey0LsS39FwdE35TsSW1A2eeoIRMZrjSa");//该字段非必输项
        bizContent.setOutTradeNo(icbcPaymentEntity.getOutTradeNo());//该字段非必输项,out_trade_no和order_id选一项上送即可
        // bizContent.setOrderId("020002040095201802202148775");//该字段非必输项,out_trade_no和order_id选一项上送即可
        request.setBizContent(bizContent);

        try {
            QrcodeQueryResponseV2 response = client.execute(request, "msgId");//msgId消息通讯唯一编号，要求每次调用独立生成，APP级唯一
            System.out.println("response:" + response);
            System.out.println("ReturnCode:" + response.getReturnCode());
            System.out.println("ReturnMsg:" + response.getReturnMsg());
            return response;
        } catch (IcbcApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void scanPay() throws Exception {
        //签名类型为RSA2时，需传入appid，私钥和网关公钥，签名类型使用定值IcbcConstants.SIGN_TYPE_RSA2，其他参数使用缺省值
        DefaultIcbcClient client = new DefaultIcbcClient(icbcPayParams.getAppId(), IcbcConstants.SIGN_TYPE_RSA2,
                icbcPayParams.getPrivateKey(), icbcPayParams.getApigwPubKey());

        QrcodePayRequestV2 request = new QrcodePayRequestV2();

        //4、根据测试环境和生产环境替换相应ip和端口
        request.setServiceUrl("https://apisandbox.dccnet.com.cn/api/qrcode/V2/pay");

        //5、请对照接口文档用bizContent.setxxx()方法对业务上送数据进行赋值
        QrcodePayRequestV2.QrcodePayRequestV2Biz bizContent = new QrcodePayRequestV2.QrcodePayRequestV2Biz();
        bizContent.setQrCode("6235124674559394540");
        bizContent.setMerId("440204140303");
        bizContent.setOutTradeNo("ZHL777O15002039");
        bizContent.setOrderAmt("7370");
        bizContent.setTradeDate("20170112");
        bizContent.setTradeTime("111305");
        request.setBizContent(bizContent);

        QrcodePayResponseV2 response;
        try {
            response = client.execute(request, "12345678");//msgId消息通讯唯一编号，要求每次调用独立生成，APP级唯一
            if (response.isSuccess()) {
                //6、业务成功处理，请根据接口文档用response.getxxx()获取同步返回的业务数据
                System.out.println("ReturnCode:" + response.getReturnCode());
                System.out.println("response:" + response);
            } else {
                //失败
                System.out.println("ReturnCode:" + response.getReturnCode());
                System.out.println("ReturnMsg:" + response.getReturnMsg());
            }
        } catch (IcbcApiException e) {
            e.printStackTrace();
        }
    }
}
