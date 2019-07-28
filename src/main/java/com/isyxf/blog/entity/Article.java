package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 */
@Setter
@Getter
@ToString
public class Article {
    private int id;
    private int classifyId;
    private Integer state;
    private Date gmtCreate;
    private Date gmtModify;
    private String title;
    private String brief;
    private String content;
    private String url;
}
