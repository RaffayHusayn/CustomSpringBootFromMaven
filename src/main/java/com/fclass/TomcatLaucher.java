package com.fclass;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.annotation.PostConstruct;

public class TomcatLaucher {

    @PostConstruct // call this method right after the constructor is called which in this case is called
    //when the application is started because the Bean's scope by default is Singleton meaning all the
    //beans are created when the application is started and the same Bean is used throughout the application
    public void launch() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("",null); // http:localhost:8081/<nothing>/<servlet>
        //Spring Boot has a dispatcher servlet instead of a HelloServlet which controls the flow to and from all the custom servlets
        tomcat.addServlet(context, "helloServlet" , new HelloServlet());
        //mapping http://localhost:8080/ to a servlet named "helloServlet" ---> in this case the Servlet Class is also called HelloServlet but that doesn't have to be the case
        context.addServletMappingDecoded( "/", "helloServlet");

        //starting the tomcat server
        tomcat.start();
        //new thread which keeps the server running
        new Thread(()->tomcat.getServer().await()).start();
    }

}
