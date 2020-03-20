package com.tianhy.study.sentinelprovider;

import com.tianhy.study.ProviderService;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

/**
 * {@link}
 *
 * @Desc: 发布一个Dubbo服务
 * @Author: thy
 * @CreateTime: 2020/1/23 5:38
 **/
//发布dubbo服务
@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String sayHello(String str) {
        System.out.println("Come in sayHello");
        return str + LocalDateTime.now();
    }

}
