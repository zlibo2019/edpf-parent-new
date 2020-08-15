package com.weds.edpf.core.runner;

import com.weds.bean.utils.SpringContextHolder;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.JobUnitEntity;
import com.weds.edpf.core.service.JobUnitService;
import com.weds.etl.config.SchedulerParams;
import com.weds.etl.service.SchedulerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EdpfSchedulerJobRunner implements ApplicationRunner {

    private Logger log = LogManager.getLogger();

    @Resource
    private JobUnitService jobUnitService;

    @Resource
    private SchedulerParams schedulerParams;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (schedulerParams.isActive()) {
            SchedulerService schedulerService = SpringContextHolder.getBean("schedulerService");
            // schedulerService.addSchedulerListener(new CustomJobListener(), null, null);
            JobUnitEntity record = new JobUnitEntity();
            record.setUseFlag("1");
            record.setUseType("1");
            List<JobUnitEntity> list = jobUnitService.selectListByEntity(record);
            for (JobUnitEntity jobUnitEntity : list) {
                String path = jobUnitEntity.getJobPath();
                Trigger.TriggerState triggerState = schedulerService.getState(path);
                if (triggerState == Trigger.TriggerState.NORMAL) {
                    log.info("定时任务已开启");
                    continue;
                } else if (triggerState == Trigger.TriggerState.ERROR) {
                    log.error("定时任务异常");
                    continue;
                }

                if (jobUnitEntity.getSeqType().equals("0")) {
                    int delay = StringUtils.isBlank(jobUnitEntity.getSpareCol1()) ? 0 : Integer.parseInt(jobUnitEntity.getSpareCol1());
                    schedulerService.addDelayJob(path, Integer.parseInt(jobUnitEntity.getSeqExpr()), delay);
                } else {
                    schedulerService.addCronJob(path, jobUnitEntity.getSeqExpr());
                }
            }
        }
    }
}
