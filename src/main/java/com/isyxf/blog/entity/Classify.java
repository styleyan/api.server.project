package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 文章分类实体类
 */
@Setter
@Getter
@ToString
public class Classify {
    private int id;
    private Date gmtCreate;
    private Date gtmModify;
    private String desc;
    private String title;
}
