package com.weds.edpf.core.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class CustomJobListener implements JobListener {
    private Logger logger = LogManager.getLogger();

    @Override
    public String getName() {
        String name = getClass().getSimpleName();
        logger.info(" listener name is:" + name);
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " is going to be executed");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " was vetoed and not executed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " was executed");
    }
}
