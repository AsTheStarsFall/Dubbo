package com.tianhy.study.dubboclient;

import com.tianhy.study.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/19 0:29
 **/
@RestController
public class HelloController {

    //dubbo提供的注解
    @Reference(loadbalance = "random", cluster = "failfast",
            mock = "com.tianhy.study.dubboclient.HelloServiceMock",timeout = 1)
    HelloService helloService;

    @GetMapping("/sayHello")
    public String sayHello() {
        return helloService.sayHello();
    }

}
