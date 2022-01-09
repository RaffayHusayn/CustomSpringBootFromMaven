package com.fclass.config;

import com.fclass.TomcatLaucher;
import com.fclass.conditionals.TomcatOnClassPathCondition;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

/*
Think of this as the configuration class that Spring boot would have internally
 */
@Configuration
//This is to set where to look for those properties that we will use to setup and even configure Bean
@PropertySources({
        //if applicaiton.properties doesn't exist we will get an error unless we set ignoreResourceNotFound = true
        @PropertySource( value = "classpath:application.properties", ignoreResourceNotFound = true),
        // if application-<some-profile>.properties doesn't exist we will get an error unless we set ignoreResourceNotFound = true
        @PropertySource(value  = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class DefaultConfig {

    //Bean to start the Embedded Tomcat server if we have a tomcat embed jar in the classpath
        @Bean
        @Conditional(TomcatOnClassPathCondition.class)
        public TomcatLaucher getTomcatLauncher(){
            return new TomcatLaucher();
        }
    // Bean to create a Datasource to connect to the inmmemory database if we have used
    // spring.datasource.url and spring.datasource.driver-class-name in the application.properties file
        @Bean
//        @Conditional()
        public DataSource dataSource(Environment environment) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
            Driver driver = (Driver) Class.forName(environment.getProperty("spring.datasource.driver-class-name")).newInstance();
            String url = environment.getProperty("spring.datasource.url");
            return new SimpleDriverDataSource(driver, url);
        }

}
