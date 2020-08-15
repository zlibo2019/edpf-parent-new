package com.weds.edwx.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.request.OapiAttendanceListRecordRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiAttendanceListRecordResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.dingtalk.service.CheckDtService;
import com.weds.dingtalk.service.CommonDtService;
import com.weds.edpf.core.service.MsgFormatService;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.AttenceService;
import com.weds.edwx.service.LoginOpenidService;
import com.weds.edwx.service.MsgSendService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import javax.annotation.Resource;
import javax.script.ScriptException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class AttenceDtSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Resource
    private CheckDtService checkDtService;

    @Resource
    private LoginOpenidService loginOpenidService;

    @Resource
    private AttenceService attenceService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        OapiAttendanceListRecordRequest request = new OapiAttendanceListRecordRequest();
        Date date = new Date();
        String end = DateUtils.formatDate(date, DateUtils.DATE_TIME_FORMAT);
        String start = DateUtils.formatDate(DateUtils.addSeconds(date, -5), DateUtils.DATE_TIME_FORMAT);
        request.setCheckDateTo(end);
        request.setCheckDateFrom(start);
        List<KtJlEntity> temp = attenceService.selectDtRecord(DateUtils.addSeconds(date, -5), date);
        List<LoginOpenidEntity> list = loginOpenidService.selectListByEntity(null);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            userList.add(list.get(i).getOpenid());
            if (userList.size() == 30 || i == list.size() - 1) {
                request.setUserIds(userList);
                try {
                    OapiAttendanceListRecordResponse resp = checkDtService.getAttenDetailRecordList(request);
                    if (resp.getErrcode() == 0) {
                        for (OapiAttendanceListRecordResponse.Recordresult recordresult : resp.getRecordresult()) {
                            AddAttenceParamEntity addAttenceParamEntity = new AddAttenceParamEntity();
                            String userSerial = list.stream().filter(t -> t.getOpenid().equals(recordresult.getUserId())).collect(Collectors.toList()).get(0).getUserSerial().toString();
                            addAttenceParamEntity.setUserSerial(userSerial);
                            addAttenceParamEntity.setSj(recordresult.getUserCheckTime());
                            addAttenceParamEntity.setLx("0");
                            addAttenceParamEntity.setFx("OnDuty".equals(recordresult.getCheckType()) ? "1" : "2");
                            addAttenceParamEntity.setDevSerial(9999999);
                            addAttenceParamEntity.setJlzpSerial(null);
                            addAttenceParamEntity.setJing(recordresult.getUserLongitude());
                            addAttenceParamEntity.setWei(recordresult.getUserLatitude());
                            addAttenceParamEntity.setAddress(recordresult.getUserAddress());
                            addAttenceParamEntity.setJlType(1);
                            addAttenceParamEntity.setRecordNo(recordresult.getId().toString());
                            int num = temp.stream().filter(t -> t.getRecordno().equals(recordresult.getId().toString())).toArray().length;
                            if (num == 0) {
                                attenceService.addKq(addAttenceParamEntity);
                            }
                        }
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
                userList.clear();
            }
        }
    }
}
