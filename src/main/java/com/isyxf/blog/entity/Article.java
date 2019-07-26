package com.isyxf.blog.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 */
@Data
@Setter
@Getter
@ToString
public class Article {
    private int id;
    private int classifyId;
    private Integer state;
    private Date gtmCreate;
    private Date gtmModify;
    private String title;
    private String desc;
    private String content;
    private String url;
}
