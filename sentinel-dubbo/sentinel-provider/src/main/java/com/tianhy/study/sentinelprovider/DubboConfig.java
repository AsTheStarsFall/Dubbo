package com.tianhy.study.sentinelprovider;

import org.apache.dubbo.config.*;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link}
 *
 * @Desc: Dubbo配置
 * @Author: thy
 * @CreateTime: 2020/1/23 6:04
 **/
@Configuration
@DubboComponentScan("com.tianhy.study.sentinelprovider")
public class DubboConfig {

    //Dubbo应用配置
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("sentinel-dubbo");
        applicationConfig.setOwner("Thy");
        return applicationConfig;
    }

    //zk作为注册中心，暴露IP端口
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("zookeeper://119.23.249.97:2181");
        registryConfig.setAddress("zookeeper://localhost:2181");
        return registryConfig;
    }

    //使用Dubbo协议
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

}
