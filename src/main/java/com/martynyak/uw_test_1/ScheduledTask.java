package com.martynyak.uw_test_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by vova on 14.09.16.
 */
@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private TemperatureService service;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        Random random = new Random();
        int t = Math.round(-50 + random.nextFloat()*100);
        service.updateTemperature(t);
    }
}
