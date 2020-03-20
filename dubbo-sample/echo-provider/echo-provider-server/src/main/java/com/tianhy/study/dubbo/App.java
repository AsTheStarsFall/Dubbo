package com.tianhy.study.dubbo;

import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
//        System.out.println( "Hello World!" );

//        ClassPathXmlApplicationContext classPathXmlApplicationContext =
//                new ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});
//        classPathXmlApplicationContext.start();
        Main.main(args);
        System.in.read();
    }
}
