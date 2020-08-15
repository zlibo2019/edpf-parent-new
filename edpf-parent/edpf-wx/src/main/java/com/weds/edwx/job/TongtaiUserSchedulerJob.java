package com.weds.edwx.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.Coder;
import com.weds.edwx.constant.TongTaiParams;
import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.entity.TmpDtUserEntity;
import com.weds.edwx.service.TmpDtUserService;
import com.weds.etl.base.SchedulerJob;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

public class TongtaiUserSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Resource
    private TongTaiParams tongTaiParams;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CommProcService commProcService;

    @Resource
    private TmpDtUserService tmpDtUserService;

    @Override
    @Transactional
    public void execute(JobExecutionContext context) {
        boolean flag = true;
        int start = 0;
        // String tableId = context.getJobDetail().getJobDataMap().getString("tableId");
        String tableId = "12899";
        // String columns = context.getJobDetail().getJobDataMap().getString("columns");
        String[] columns = {"ID", "VIPNAME", "MOBIL", "ENTERDATE", "CARDNO"};

        while (flag) {
            flag = false;
            String sipTimestamp = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
            String sipSign = Coder.md5Hex(tongTaiParams.getAppkey() + sipTimestamp + Coder.md5Hex(tongTaiParams.getPassword()).toLowerCase()).toLowerCase();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
            param.add("sip_appkey", tongTaiParams.getAppkey());
            param.add("sip_timestamp", sipTimestamp);
            param.add("sip_sign", sipSign);

            Map<String, Object> transactions = new HashMap<>();
            transactions.put("id", StringUtils.getUUID());
            transactions.put("command", "Query");

            Map<String, Object> params = new HashMap<>();
            params.put("table", tableId);
            params.put("columns", columns);
            params.put("count", true);
            params.put("start", start);
            params.put("range", tongTaiParams.getRow());
            transactions.put("params", params);

            List<Map<String, Object>> list = new ArrayList<>();
            list.add(transactions);

            param.add("transactions", JSONObject.toJSONString(list));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(param, httpHeaders);
            ResponseEntity<String> rtn = restTemplate.postForEntity(tongTaiParams.getUrl(), request, String.class);
            HttpHeaders header = rtn.getHeaders();
            List<String> sipStatus = header.get("sip_status");
            if (sipStatus != null && sipStatus.size() == 1 && sipStatus.get(0).equals("9999")) {
                JSONObject resp = JSONArray.parseArray(rtn.getBody()).getJSONObject(0);
                if (resp.getString("code").equals("0")) {
                    int count = resp.getIntValue("count");
                    JSONArray rows = resp.getJSONArray("rows");
                    if (count > 0 && rows.size() > 0) {
                        if (rows.size() == tongTaiParams.getRow()) {
                            start = start + tongTaiParams.getRow();
                            flag = true;
                        }

                        List<TmpDtUserEntity> dataList = new ArrayList<>();
                        for (int i = 0; i < rows.size(); i++) {
                            JSONArray values = rows.getJSONArray(i);
                            TmpDtUserEntity tmpDtUserEntity = new TmpDtUserEntity();
                            tmpDtUserEntity.setZh(values.get(0).toString());
                            tmpDtUserEntity.setUserLname(values.get(1) == null ? null : values.get(1).toString());
                            tmpDtUserEntity.setUserTelephone(values.get(2) == null ? null : values.get(2).toString());
                            tmpDtUserEntity.setSpareCol1(values.get(4) == null ? null : values.get(4).toString());
                            tmpDtUserEntity.setSpareCol2(values.get(3) == null ? null : values.get(3).toString());
                            tmpDtUserEntity.setUserPassword(tongTaiParams.getDefaultPwd());
                            tmpDtUserEntity.setUserNo(values.get(0).toString());
                            tmpDtUserEntity.setDepNo(tongTaiParams.getDefaultDep());
                            dataList.add(tmpDtUserEntity);
                            if (dataList.size() == 10 || i == rows.size() - 1) {
                                tmpDtUserService.insertBatch(dataList);
                                dataList.clear();
                            }
                        }
                    }
                }
            }
        }
        CommProcEntity commProcEntity = new CommProcEntity();
        commProcEntity.setProcName("updateuser_big_scm");
        commProcService.loadProcData(commProcEntity);
    }
}
