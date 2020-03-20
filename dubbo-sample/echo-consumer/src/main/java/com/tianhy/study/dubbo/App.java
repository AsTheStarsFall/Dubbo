package com.tianhy.study.dubbo;

import com.tianhy.study.dubbo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext(new String[]{"/echo-consumer.xml"});
        classPathXmlApplicationContext.start();
        EchoService echoService = (EchoService) classPathXmlApplicationContext.getBean("echoService");
        String echo = echoService.echo("echo!!");
        System.out.println("Result :" + echo);
    }
}
