package com.isyxf.blog.entity;

import java.util.Date;

public class Article {
    private Integer id;

    private Date gtmCreate;

    private Date gtmModify;

    private Integer classifyId;

    private String title;

    private String desc;

    private String content;

    private String url;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(Date gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public Date getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", gtmCreate=" + gtmCreate +
                ", gtmModify=" + gtmModify +
                ", classifyId=" + classifyId +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", state=" + state +
                '}';
    }
}
