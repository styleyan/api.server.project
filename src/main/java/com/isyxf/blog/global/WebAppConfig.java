package com.isyxf.blog.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 11:24
 * @Descript 拦截器配置
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {
    private final static Logger logger = LoggerFactory.getLogger(WebAppConfig.class);

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /**
         * 所有以 api 开头的请求都需要经过 LoginHandler 校验
         * excludePathPatterns("", "", ...): 用于排查部分需要校验的氢气地址, 需要指定请求全路径
         */
        // TODO: registry.addInterceptor 是可以添加多个拦截的
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login");
    }
}
