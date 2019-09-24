package com.isyxf.blog.configuration;

import com.isyxf.blog.interceptor.LoginHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 11:24
 * @Descript 拦截器配置
 * 最初 WebAppConfig extend WebMvcConfigurationSupport 出现jackson配置失效，才改为 WebAppConfig implements WebMvcConfigurer的
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(WebAppConfig.class);


    /**
     * 由于在拦截器中注解无效，需要提交注入 bean
     */
    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 所有以 api 开头的请求都需要经过 LoginHandler 校验
         * excludePathPatterns("", "", ...): 用于排查部分需要校验的氢气地址, 需要指定请求全路径
         */
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login");
    }
}
