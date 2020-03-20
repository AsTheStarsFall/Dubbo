package com.tianhy.study.spi;

import com.alibaba.csp.sentinel.util.AppNameUtil;

import java.util.ServiceLoader;

/**
 * @Description:
 * @Author: thy
 * @Date: 2020/1/23 17:42
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println(AppNameUtil.getAppName());
//        ServiceLoader<TestService> services = ServiceLoader.load(TestService.class);
//
//        for (TestService service : services) {
//            service.test();
//        }
    }
}
