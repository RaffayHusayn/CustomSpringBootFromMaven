package com.fclass;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("",null); // http:localhost:8081/<nothing>/<servlet>
        //Spring Boot has a dispatcher servlet instead of a HelloServlet which controls the flow to and from all the custom servlets
        tomcat.addServlet(context, "helloServlet" , new HelloServlet());
        //mapping http://localhost:8080/ to a servlet named "helloServlet" ---> in this case the Servlet Class is also called HelloServlet but that doesn't have to be the case
        context.addServletMappingDecoded( "/", "helloServlet");

        tomcat.start();
        System.out.println("starting tomcat server");
        new Thread(()->tomcat.getServer().await()).start();


    }
}
