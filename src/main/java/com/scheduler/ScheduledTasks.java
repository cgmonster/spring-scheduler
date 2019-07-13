package com.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${scheduler.retry.time}")
    private void retryFailedSimSwap() {
        try {
            LOGGER.info("Time is {}", dateFormat.format(new Date()));
        } catch (Exception e) {
            LOGGER.error("This is where you screwed : {}", e);
        }
    }
}