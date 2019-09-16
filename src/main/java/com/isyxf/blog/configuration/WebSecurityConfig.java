package com.isyxf.blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 19:52
 * @Descript 身份认证授权
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /**
     * 设置 HTTP 验证规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                // 以 / 的所有请求都放行
                .antMatchers("/").permitAll()
                // 所有 /login 的 post 请求都放行
                .antMatchers(HttpMethod.POST, "/api/user/login").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated();

        super.configure(http);
    }
}
