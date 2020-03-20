package com.tianhy.study.nacosdemo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/20 4:22
 **/
public class NacosConfigSdk {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost";
        String dataId = "example";
        String group = "DEFAULT_GROUP";
        //属性配置
        Properties properties = new Properties();
        //设置naocs服务器地址
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        //根据属性配置创建一个配置服务
        ConfigService configService = NacosFactory.createConfigService(properties);
        //获取配置内容
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println("get config:" + content);

        //设置监听
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println("receive config info :" + s);
            }
        });

        //发布
        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
        System.out.println(isPublishOk);

        Thread.sleep(3000);
        //获取
        content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        //删除
//        boolean isRemoveOk = configService.removeConfig(dataId, group);
//        System.out.println(isRemoveOk);
//        Thread.sleep(3000);
//
//        content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
        Thread.sleep(300000);


    }
}
