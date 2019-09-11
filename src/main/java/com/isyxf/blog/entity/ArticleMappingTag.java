package com.isyxf.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xiaofei.yan
 * @Create 2019-09-09 16:23
 * @Descript 标签文章映射实体
 */
@Getter
@Setter
@ToString
public class ArticleMappingTag {
    private int id;
    /**
     * 文章id
     */
    private int actId;
    /**
     * 标签id
     */
    private int tagId;
    private Date gmtCreate;
    private Date gmtModify;
}
