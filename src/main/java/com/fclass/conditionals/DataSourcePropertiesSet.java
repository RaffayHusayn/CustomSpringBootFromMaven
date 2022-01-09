package com.fclass.conditionals;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/*
This class is used in the conditional to create Datasource Bean
which is only created if we have set the required properties in
the application.properties file
The required properties for the creation of database connection are
1. spring.datasource.url
2. spring.datasource.driver-class-name
 */
public class DataSourcePropertiesSet implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //returns true of both of them are present in the application.properties files otherwise returns false;
        return conditionContext.getEnvironment().containsProperty("spring.datasource.url") && conditionContext.getEnvironment().containsProperty("spring.datasource.driver-class-name");

    }
}
