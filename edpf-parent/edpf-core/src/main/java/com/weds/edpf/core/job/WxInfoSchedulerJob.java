package com.weds.edpf.core.job;

import com.weds.edpf.core.service.WeiXinService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class WxInfoSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private WeiXinService weiXinService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("请求微信平台获取Token");
        //获取token
        weiXinService.getAccessToken();
        //获取ticket
        weiXinService.getJsapiTicket();
    }
}
