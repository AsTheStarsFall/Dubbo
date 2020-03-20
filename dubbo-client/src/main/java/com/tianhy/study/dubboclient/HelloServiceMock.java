package com.tianhy.study.dubboclient;

import com.tianhy.study.HelloService;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/19 4:48
 **/
public class HelloServiceMock implements HelloService {
    @Override
    public String sayHello() {
        return "服务端发生异常，被降级";
    }
}
