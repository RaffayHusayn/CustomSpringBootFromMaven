package com.fclass;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    @Configuration
    public static class MyAppConfig{

        @Bean
        public TomcatLaucher getTomcatLauncher(){
            return new TomcatLaucher();
        }
    }

    public static void main( String[] args ) throws LifecycleException {

        new AnnotationConfigApplicationContext(MyAppConfig.class);
//        TomcatLaucher tomcatLaucher = ctx.getBean(TomcatLaucher.class);
//        tomcatLaucher.launch();

    }
}