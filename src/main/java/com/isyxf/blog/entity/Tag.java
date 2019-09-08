package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 标签
 */
@Setter
@Getter
@ToString
public class Tag {
    private int id;
    private String name;
    private Date gmtCreate;
    private Date gmtModify;
}
