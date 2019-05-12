package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Link {
    private long id;
    private Date gmtCreate;
    private Date gtmModify;
    private String websiteName;
    private String websiteUrl;
    private String desc;
    private String https;
}
