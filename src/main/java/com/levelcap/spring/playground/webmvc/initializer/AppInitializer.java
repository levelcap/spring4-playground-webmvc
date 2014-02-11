package com.levelcap.spring.playground.webmvc.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Defines the startup and context behavior of the web application.
 * 
 * @author dcohen
 * 
 */
public class AppInitializer implements WebApplicationInitializer
{
    private static final String CONFIG_LOCATION = "com.levelcap.spring.playground.webmvc.config";
    private static final String MAPPING_URL = "/*";

    /**
     * Defines the startup behavior of the web application. Adds listeners,
     * dispatcher and basic mapping.
     * 
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
                new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);
    }

    /**
     * Defines the getContext behavior of the web application, pulling in the
     * Configuration classes from CONFIG_LOCATION.
     * 
     */
    private AnnotationConfigWebApplicationContext getContext()
    {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }
}