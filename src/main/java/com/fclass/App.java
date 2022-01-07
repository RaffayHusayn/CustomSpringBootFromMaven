package com.fclass;

import com.fclass.config.DefaultConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
public class App 
{
    @Configuration
    @Import(DefaultConfig.class) // == kinda similar to @SpringBootApplication annotation which is @Configuration @EnableAutoConfiguration @ComponentScan
    public static class MyAppConfig{
        //uses a lot of configuration from the Default Configuration class
    }

    public static void main( String[] args ) throws LifecycleException {

        new AnnotationConfigApplicationContext(MyAppConfig.class);
//        TomcatLaucher tomcatLaucher = ctx.getBean(TomcatLaucher.class);
//        tomcatLaucher.launch();

    }
}