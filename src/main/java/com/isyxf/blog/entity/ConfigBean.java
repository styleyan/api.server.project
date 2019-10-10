package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiaofei.yan
 * @Create 2019-10-10 13:59
 * @Descript 配置bean
 */
@ConfigurationProperties(prefix = "com.isyxf")
@Getter
@Setter
public class ConfigBean {
    private String url;
    private String name;
    private Integer age;
    private String add;
}
