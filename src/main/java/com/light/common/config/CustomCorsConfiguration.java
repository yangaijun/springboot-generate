package com.light.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomCorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 放行哪些原始域
                .allowedOrigins("*")
                // 放行哪些请求方式
                .allowedMethods("*")
                // 放行哪些原始请求头部信息
                .allowedHeaders("*");
    }
}
