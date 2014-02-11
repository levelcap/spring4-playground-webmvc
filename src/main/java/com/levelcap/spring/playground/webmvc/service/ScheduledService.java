package com.levelcap.spring.playground.webmvc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * A simple class that sets up a scheduled Date logging / console print.
 * 
 * @author dcohen
 * 
 */
@Configuration
@EnableScheduling
public class ScheduledService
{
    private static final Log logger = LogFactory.getLog(ScheduledService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * Uses the @Scheduled annotation to log / print the current Date every 10
     * seconds.
     */
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime()
    {
        logger.debug("Time: " + dateFormat.format(new Date()));
        System.out.println("Time: " + dateFormat.format(new Date()));
    }
}
