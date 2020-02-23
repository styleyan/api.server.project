package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Y.jer
 * 影视
 */
@Setter
@Getter
@ToString
public class Movies {
    private int id;
    /**
     * 影视名
     */
    private String movieName;
    /**
     * 评分
     */
    private Float movieScore;
    /**
     * 评价
     */
    private String movieEvaluate;
    /**
     * 类型: 1:动漫, 2:纪录片, 3:电影, 4:连续剧
     */
    private int type;

    /**
     * 是否显示
     */
    private int state;
    private Date gmtCreate;
    private Date gmtModify;
}
