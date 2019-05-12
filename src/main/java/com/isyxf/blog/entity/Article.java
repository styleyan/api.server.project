package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Article {
    private long id;
    private Date gtmCreate;
    private Date gtmModify;
    private long classifyId;
    private String title;
    private String desc;
    private String content;
    private String url;
    private Integer state;
}
