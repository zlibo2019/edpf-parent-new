package com.weds.edwx.job;

import com.weds.edwx.service.CustomizedService;
import com.weds.edwx.service.UserService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class CustomizedSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private CustomizedService customizedService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hour = sdf.format(new Date());

        if (hour.equals("09:23")) {
            customizedService.sendMessage(1, 1);
        }
        if (hour.equals("08:30")) {
            customizedService.sendMessage(1, 2);
        }
        if (hour.equals("09:00")) {
            customizedService.sendMessage(1, 4);
        }
        if (hour.equals("17:30")) {
            customizedService.sendMessage(1, 3);
            customizedService.sendMessage(2, 1);
        }
    }
}
