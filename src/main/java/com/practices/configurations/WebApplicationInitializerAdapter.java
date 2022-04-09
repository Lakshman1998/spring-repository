package com.practices.configurations;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializerAdapter implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebApplicationContextAdapter.class);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("DISPATCHER SERVLET", new DispatcherServlet(webApplicationContext));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}
