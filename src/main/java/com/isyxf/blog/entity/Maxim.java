package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 个人箴言
 */
@Setter
@Getter
@ToString
public class Maxim {
    private int id;
    private Date gmtCreate;
    private Date gmtModify;
    private String context;
    private int status;
}
