package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Classify {
    private long id;
    private Date gmtCreate;
    private Date gtmModify;
    private String desc;
    private String title;
}
