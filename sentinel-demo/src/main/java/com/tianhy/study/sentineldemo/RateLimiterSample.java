package com.tianhy.study.sentineldemo;

import com.google.common.util.concurrent.RateLimiter;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * {@link}
 *
 * @Desc: Guava 限流的实现
 * @Author: thy
 * @CreateTime: 2020/1/22 3:40
 **/
public class RateLimiterSample {

    //令牌桶，permitsPerSecond:QPS
    RateLimiter rateLimiter = RateLimiter.create(50);

    public void doThings() {
        //获取许可(如果获取成功则通过，否则限流)
        if (rateLimiter.tryAcquire()) {
            System.out.println("do things");
        } else {
            System.out.println("被限流了");
        }
    }

    public static void main(String[] args) throws IOException {
        CountDownLatch cdl = new CountDownLatch(1);
        RateLimiterSample rls = new RateLimiterSample();
        Random random = new Random();
        // todo 启动20个线程，如果线程数大于permitsPerSecond，则被限流
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                        Thread.sleep(random.nextInt(1000));
                        rls.doThings();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        cdl.countDown();
        System.in.read();

    }

}
