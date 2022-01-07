package com.fclass.conditionals;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TomcatOnClassPathCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            //checking and trying to load Embedded Tomcat .jar from the Classpath
            Class.forName("org.apache.catalina.startup.Tomcat");
            return true; //means that we have embedded tomcat dependency in the pom.xml / in the classpath
        } catch (ClassNotFoundException e) {
            return false; // means we don't have embedded tomcat in the class path
        }
    }
}
