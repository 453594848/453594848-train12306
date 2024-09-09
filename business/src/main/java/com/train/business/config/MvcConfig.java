package com.train.business.config;

import com.train.common.interceptor.LogInterceptor;
import com.train.common.interceptor.MemberInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Resource
    MemberInterceptor memberInterceptor;
    @Resource
    LogInterceptor logInterceptor;

    // 登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        //路径不要包含context - path
        registry.addInterceptor(memberInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/hello"
                ).order(1);


        registry.addInterceptor(logInterceptor).order(0);
    }
}
