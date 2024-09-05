package com.train.batch.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.train.batch.feign.BusinessFeign;
import com.train.common.resp.CommonResp;
import jakarta.annotation.Resource;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Date;

public class DailyTrainJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(DailyTrainJob.class);
    @Resource
    private BusinessFeign businessFeign;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 增加日志流水号
        MDC.put("LOG_ID", System.currentTimeMillis() + RandomUtil.randomString(3));
        LOG.info("生成15天后的车次数据开始");
        Date date = new Date();
        LOG.info("当前日期：{}", date);

        // 循环生成从今天起未来15天的数据
    /*    for (int i = 1; i <= 15; i++) {
            DateTime dateTime = DateUtil.offsetDay(date, i);
            Date offsetDate = dateTime.toJdkDate();
            LOG.info("生成 {} 天后的车次数据", i);
            CommonResp<Object> commonResp = businessFeign.genDaily(offsetDate);
            LOG.info("生成 {} 天后的车次数据结束，结果：{}", i, commonResp);
        }*/
        DateTime dateTime = DateUtil.offsetDay(date, 15);
        Date offsetDate = dateTime.toJdkDate();
        CommonResp<Object> commonResp = businessFeign.genDaily(offsetDate);
        LOG.info("生成15天后的车次数据结束，结果：{}", commonResp);


    }
}
