package com.tianhy.study.sentineldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelDemoApplication {
    public static void main(String[] args) {
        SentinelSample.initFlowRules();
        SpringApplication.run(SentinelDemoApplication.class, args);
    }
}
