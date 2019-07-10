package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 奇文
 */
@Setter
@Getter
@ToString
public class RemarkableWriting {
    private int id;
    private String title;
    private String url;
    /**
     * 是否显示
     */
    private int status;
    private Date gmtCreate;
    private Date gmtModify;
}
