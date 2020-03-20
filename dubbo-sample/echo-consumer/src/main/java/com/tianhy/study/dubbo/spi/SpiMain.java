package com.tianhy.study.dubbo.spi;

import java.util.ServiceLoader;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/17 11:50
 **/
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<SpiService> services = ServiceLoader.load(SpiService.class);
        //获取所有SPI实现
        for (SpiService service : services) {
            service.spiService();
//            service.hello();
        }

    }
}
