package com.weds.edwx.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.dingtalk.service.CommonDtService;
import com.weds.edpf.core.service.MsgFormatService;
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

import javax.annotation.Resource;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MsgSendSchedulerJobNew extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private MsgSendService msgSendService;

    @Resource
    private MsgFormatService msgFormatService;

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
                        Map<String, Object> msgContent = JSONObject.parseObject(msgSendEntity.getMesContent());
                        String templetContent = msgFormatService.parseTemplate(msgSendEntity.getTempletId(), "0", msgContent);
                        if (!StringUtils.isBlank(templetContent)) {
                            templetContent = templetContent.replace("#openid#", msgSendEntity.getOpenId()); //替换发送人
                            templetContent = templetContent.replace("#MSGXH#", msgSendEntity.getMsgXh()); //替换消息序号
                            String result = msgSendService.sendMessage(templetContent);
                            if ("0".equals(result)) {
                                result = "1";
                            }
                            msgSendEntity.setMsgState(Integer.parseInt(result));
                        } else {
                            msgSendEntity.setMsgState(2);
                        }
                        msgSendEntity.setSendDate(DateUtils.getCurrentDateTime());
                    }
                } catch (ParseException | NoSuchMethodException | ScriptException e) {
                    e.printStackTrace();
                }
                msgSendService.updateByPrimaryKeySelective(msgSendEntity); //更新消息发送状态
            }
        }
    }
}
