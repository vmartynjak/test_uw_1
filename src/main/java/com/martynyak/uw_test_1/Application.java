package com.martynyak.uw_test_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by vova on 14.09.16.
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
