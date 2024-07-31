package com.train.batch.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(TestJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("quartz执行");
    }
}
