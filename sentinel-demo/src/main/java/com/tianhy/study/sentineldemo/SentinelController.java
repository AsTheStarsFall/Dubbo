package com.tianhy.study.sentineldemo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/22 4:25
 **/
@RestController
public class SentinelController {

    //定义资源
    @SentinelResource(value = SentinelSample.LIMIT_RESOURCE)
    @GetMapping("/say")
    public String sayHello() {
        System.out.println("Come in sayHello");
        return "hello";
    }

}
