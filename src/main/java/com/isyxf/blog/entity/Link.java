package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 友情链接实体类
 */
@Setter
@Getter
@ToString
public class Link {
    private int id;
    private int https;
    private int state;
    private String websiteName;
    private String websiteUrl;
    private String desc;
    private Date gmtCreate;
    private Date gmtModify;
}
