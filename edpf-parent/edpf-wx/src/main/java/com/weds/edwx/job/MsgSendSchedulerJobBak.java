package com.weds.edwx.job;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.MsgSendEntity;
import com.weds.edwx.entity.VisRegisterEntity;
import com.weds.edwx.service.MsgSendService;
import com.weds.edwx.service.VisCardUserService;
import com.weds.edwx.service.VisRegisterService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MsgSendSchedulerJobBak extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private MsgSendService msgSendService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<MsgSendEntity> list = msgSendService.selectMsgList();
        if (list.size() > 0) {//返回的值不为空，开始走消息发送流程
            //发送消息
            for (int i = 0; i < list.size(); i++) {//循环消息列表
                MsgSendEntity sendMsg = list.get(i);//先判断是否过期，过期一个小时，超时一个小时的消息都不发送。
                try {
                    if (DateUtils.addHours(new Date(), -1).getTime() > DateUtils.parseDate(sendMsg.getRecordDate(), DateUtils.DATE_TIME_FORMAT).getTime() ||
                            DateUtils.addHours(new Date(), 1).getTime() < DateUtils.parseDate(sendMsg.getRecordDate(), DateUtils.DATE_TIME_FORMAT).getTime()) {
                        sendMsg.setMsgState(601);
                        sendMsg.setSendDate(DateUtils.getCurrentDateTime());
                    } else { //未过期的发送
                        //取出消息模板，用于替换
                        String templetContent = list.get(i).getTempletContent();
                        //取出消息内容，替换模板
                        Map<String, String> msgContent = (Map) JSONObject.parseObject(list.get(i).getMesContent());
                        templetContent = templetContent.replace("#openid#", list.get(i).getOpenId()); //替换发送人
                        templetContent = templetContent.replace("#MSGXH#", list.get(i).getMsgXh()); //替换消息序号
                        //templetContent = templetContent.replace("#url#",list.get(i).getMsgUrl());
                        for (String key : msgContent.keySet()) { //批量替换消息模板中固定的数据
                            templetContent = templetContent.replace("#" + key + "#", msgContent.get(key));
                        }
                        //批量替换模板中需要函数表达式的数据
                        if (list.get(i).getMesFunction() != null && !list.get(i).getMesFunction().equals("")) {//判断函数不为空
                            String mesFuntionsStr = list.get(i).getMesFunction();
                            //将函数转换为json字符串
                            mesFuntionsStr = mesFuntionsStr.replace("#MSGXH#", list.get(i).getMsgXh()); //替换消息序号
                            for (String key : msgContent.keySet()) { //批量替换函数中的用于表达式判断的数据
                                mesFuntionsStr = mesFuntionsStr.replace("#" + key + "#", msgContent.get(key));
                            }
                            JSONObject mesFuntionsMap = JSONObject.parseObject(mesFuntionsStr);
                            //解析js方法
                            ScriptEngineManager sem = new ScriptEngineManager();
                            ScriptEngine engine = sem.getEngineByName("javascript");
                            try {
                                for (String key2 : mesFuntionsMap.keySet()) { //批量解析函数
                                    //定义函数
                                    engine.eval(mesFuntionsMap.getString(key2));
                                    //取得调用接口
                                    Invocable jsInvoke = (Invocable) engine;
                                    //将函数返回值转换给字符串
                                    templetContent = templetContent.replace(key2, jsInvoke.invokeFunction("myfunc").toString());
                                }
                            } catch (ScriptException | NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                        }
                        //System.out.println("发送字符串：：：："+templetContent);
                        String result = msgSendService.sendMessage(templetContent);
                        //System.out.println("发送结果：：：："+result);
                        //MsgSendEntity sendMsg = list.get(i);
                        if ("0".equals(result)) {
                            result = "1";
                        }
                        sendMsg.setMsgState(Integer.parseInt(result));
                        sendMsg.setSendDate(DateUtils.getCurrentDateTime());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                msgSendService.updateByPrimaryKeySelective(sendMsg); //更新消息发送状态
            }
        }
    }
}
