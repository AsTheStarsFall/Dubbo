package com.tianhy.study.dubbo.spi;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/17 11:49
 **/
public class SpiServiceImpl implements SpiService{
    @Override
    public void spiService() {
        System.out.println("SpiService");
    }

}
