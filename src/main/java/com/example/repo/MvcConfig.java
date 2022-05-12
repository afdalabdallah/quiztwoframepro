package com.example.repo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/signup").setViewName("signup");
//        registry.addViewController("/collaboration").setViewName("collaboration");
//        registry.addViewController("/profile").setViewName("login");

    }

}