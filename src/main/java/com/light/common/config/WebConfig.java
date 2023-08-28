package com.light.common.config;

import com.light.common.config.interceptor.AuthFilter;
import com.light.common.config.interceptor.WebIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * web配置
 *
 * @date 2017-08-23 15:48
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebIntercepter())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 是否发送 Cookie
                .allowCredentials(true)
                // 放行哪些原始域
                .allowedOriginPatterns("*")
                // 放行哪些请求方式
                .allowedMethods("*")
                // 放行哪些原始请求头部信息
                .allowedHeaders("*")
                .exposedHeaders("*");
    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
