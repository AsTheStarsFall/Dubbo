package com.tianhy.study.sentinelweb;

import com.tianhy.study.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link}
 *
 * @Desc: 通过HTTP访问，测试限流
 * @Author: thy
 * @CreateTime: 2020/1/23 6:49
 **/
@RestController
public class SentinelController {

    //消费服务
    @Reference(timeout = 3000)
    ProviderService providerService;

    @GetMapping("/say")
    public String sayHello() {
        System.out.println("Come in sayHello");
        RpcContext.getContext().setAttachment("dubboApplication", "sentinel-web");
        return providerService.sayHello("hi");
    }


    @GetMapping("/say1")
    public String sayHello1() {
        System.out.println("Come in sayHello");
        return providerService.sayHello("hi");
    }



}
