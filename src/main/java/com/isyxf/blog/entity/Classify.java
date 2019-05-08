package com.isyxf.blog.entity;

import java.util.Date;

public class Classify {
    private Integer id;

    private Date gmtCreate;

    private Date gtmModify;

    private String desc;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gtmModify=" + gtmModify +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
