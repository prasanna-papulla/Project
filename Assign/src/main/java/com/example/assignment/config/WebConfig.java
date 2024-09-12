package com.example.assignment.config;

import com.example.assignment.interceptors.StudentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the interceptor for specific URL patterns or all requests
        registry.addInterceptor(studentInterceptor)
                .addPathPatterns("/student/**") // Intercepts all URLs under "/student"
                .excludePathPatterns("/student/hello"); // Optionally exclude certain paths
    }
}
