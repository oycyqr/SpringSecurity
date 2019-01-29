package com.oycbest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: oyc
 * @Date: 2019/1/29 11:39
 * @Description:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/user").setViewName("user/user");
        registry.addViewController("/admin").setViewName("admin/admin");
    }
}