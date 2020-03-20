package com.tianhy.study.dubbo.impl;

import com.tianhy.study.dubbo.api.HelloService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/15 15:12
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
//        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
//        System.out.println("[" + now + "] msg: " + msg + ",request from consumer:" +
//                RpcContext.getContext().getRemoteAddress());
        return msg;
    }
}
