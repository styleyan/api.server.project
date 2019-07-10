package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 书单
 */
@Setter
@Getter
@ToString
public class Books {
    private int id;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 评分
     */
    private Float bookScore;

    /**
     * 推荐理由
     */
    private String bookReason;
    /**
     * 评价
     */
    private String bookEvaluate;
    /**
     * 是否已读, 1:一度, 0: 未读
     */
    private int isRead;
    /**
     * 分类
     */
    private int classifyId;
    private Date gmtCreate;
    private Date gmtModify;
}