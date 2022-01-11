package com.fclass;

import com.fclass.annotations.CustomAnnotation;
import com.fclass.config.DefaultConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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

    @CustomAnnotation// this annotation does nothing, I created it
    public static void main( String[] args ) throws LifecycleException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
        DataSource datasource = ctx.getBean(DataSource.class);
        try(Connection connection = datasource.getConnection()) {
            System.out.println("Connection is valid(5000) : "+ connection.isValid(5000));
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        TomcatLaucher tomcatLaucher = ctx.getBean(TomcatLaucher.class);
//        tomcatLaucher.launch();

    }
}