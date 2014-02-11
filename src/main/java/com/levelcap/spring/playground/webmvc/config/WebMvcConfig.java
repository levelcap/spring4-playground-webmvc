package com.levelcap.spring.playground.webmvc.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.DeviceWebArgumentResolver;
import org.springframework.mobile.device.site.SitePreferenceWebArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

/**
 * MVC Configuration class. @EnableWebMvc imports Springs MVC configuration, @Configuration
 * marks this as a Configuration class, and @ComponentScan sets the base package
 * path (com.levelcap.spring.playground.webmvc) to look for our @Controllers and
 * other components.
 * 
 * @author Dave Cohen
 * 
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.levelcap.spring.playground.webmvc")
class WebMvcConfig extends WebMvcConfigurerAdapter
{
    // Add a deviceResolverHandlerInterceptor Bean to the Web Configuration for
    // Device handling
    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor()
    {
        return new DeviceResolverHandlerInterceptor();
    }

    // Add argument resolvers to allow Device as a Controller parameter in
    // DeviceDetectionController
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        // Adding Spring mobile argument resolvers
        argumentResolvers.add(
                new ServletWebArgumentResolverAdapter(
                        new DeviceWebArgumentResolver()));

        argumentResolvers.add(
                new ServletWebArgumentResolverAdapter(
                        new SitePreferenceWebArgumentResolver()));
    }

    // Add the interceptors created in the bean above
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
    }
}