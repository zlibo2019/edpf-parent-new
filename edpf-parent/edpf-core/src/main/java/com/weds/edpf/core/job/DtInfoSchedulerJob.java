package com.weds.edpf.core.job;

import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.weds.core.utils.MapCacheUtils;
import com.weds.dingtalk.service.CommonDtService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import javax.annotation.Resource;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class DtInfoSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Resource
    private CommonDtService commonDtService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("请求钉钉平台获取Token");
        try {
            //获取token
            OapiGettokenResponse tokenResp = commonDtService.getToken();
            if (tokenResp.getErrcode() == 0) {
                MapCacheUtils.single().set("token", tokenResp.getAccessToken());
            }
            //获取ticket
            OapiGetJsapiTicketResponse ticketResp = commonDtService.getTicket();
            if (tokenResp.getErrcode() == 0) {
                MapCacheUtils.single().set("ticket", ticketResp.getTicket());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
