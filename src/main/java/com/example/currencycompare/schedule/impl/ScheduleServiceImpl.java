package com.example.currencycompare.schedule.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import com.example.currencycompare.schedule.ScheduleService;
import com.example.currencycompare.schedule.SendRegularMessagesJob;

public class ScheduleServiceImpl implements ScheduleService {
    private final String NOTIFICATION_JOB = "testJob";
    private final String CRONTRIGGER = "crontrigger";
    private final String CRONTRIGGERGROUP = "crontriggergroup1";
    private final String CRON_SCHEDULE = "0 0 8,9,10,11,12,13,14,15,16,17,18,19 ? * * *";

    private static final Logger logger = LogManager.getLogger(ScheduleServiceImpl.class);

    @Override
    public void init() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(SendRegularMessagesJob.class)
                .withIdentity(NOTIFICATION_JOB)
                .build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(CRONTRIGGER, CRONTRIGGERGROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(CRON_SCHEDULE))
                .build();


        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch = schFactory.getScheduler();
        sch.start();
        sch.scheduleJob(job, cronTrigger);

        logger.info("Schedule have been initialize");
    }
}
