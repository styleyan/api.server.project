package com.isyxf.blog;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import com.isyxf.blog.entity.ConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@MapperScan(value = "com.isyxf.blog.dao")
@EnableConfigurationProperties({ConfigBean.class})
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
