package com.tianhy.study.dubbo.impl;

import com.tianhy.study.dubbo.api.EchoService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link}
 *
 * @Desc: 服务接口实现
 * @Author: thy
 * @CreateTime: 2020/1/15 12:48
 **/
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String msg) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] msg: " + msg + ",request from consumer:" +
                RpcContext.getContext().getRemoteAddress());
        return msg;
    }
}
