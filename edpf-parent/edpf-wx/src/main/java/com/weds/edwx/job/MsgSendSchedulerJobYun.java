package com.weds.edwx.job;

import com.weds.core.utils.DateUtils;
import com.weds.edwx.entity.MsgSendEntity;
import com.weds.edwx.service.MsgSendService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MsgSendSchedulerJobYun extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private MsgSendService msgSendService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<MsgSendEntity> list = msgSendService.selectMsgListYun();
        if (list.size() > 0) {//返回的值不为空，开始走消息发送流程
            //发送消息
            for (MsgSendEntity msgSendEntity : list) {//循环消息列表
                try {
                    if (DateUtils.addHours(new Date(), -1).getTime() > DateUtils.parseDate(msgSendEntity.getRecordDate(), DateUtils.DATE_TIME_FORMAT).getTime() ||
                            DateUtils.addHours(new Date(), 1).getTime() < DateUtils.parseDate(msgSendEntity.getRecordDate(), DateUtils.DATE_TIME_FORMAT).getTime()) {
                        msgSendEntity.setMsgState(601);
                        msgSendEntity.setSendDate(DateUtils.getCurrentDateTime());
                    } else { //未过期的发送
                        String result = msgSendService.sendMessage(toJson(msgSendEntity));
                        if ("0".equals(result)) {
                            result = "1";
                        }
                        msgSendEntity.setMsgState(Integer.parseInt(result));
                        msgSendEntity.setSendDate(DateUtils.getCurrentDateTime());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                msgSendService.updateByPrimaryKeySelective(msgSendEntity); //更新消息发送状态
            }
        }
    }
}
