package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 用户信息
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String userName;
    private String userAlias;
    private String password;
    private Date gmtCreate;
    private Date gmtModify;
}
